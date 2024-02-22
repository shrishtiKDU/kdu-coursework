const express = require("express");
const app = express();
const cors = require("cors");
const socketIo = require("socket.io");
const http = require("http");
const loginRoutes = require("./routes/loginroutes");
const posts = require('./data/posts');
//const postRoutes = require("./routes/postroutes");

app.use(cors());
app.use(express.json());
const server = http.createServer(app);
const io = new socketIo.Server(server, {
    cors: {
        origin: "http://127.0.0.1:5500",
    },
});

let activeUsers = [];
let connections = []

io.on("connection", async (socket) =>{
  console.log("connection built");
  socket.on("register", (data) =>{
    if (data && data.user_name) { 
      activeUsers.push(data);
      socket.emit("newUsers", activeUsers);
      connections[data.user_name] = socket.id;
      io.except(socket.id).emit("newUser", data);
      console.log(connections);
    } else {
      console.error("Invalid data received:", data);
    }
  })
  socket.conn.on("close", ()=>{
    const offlineUser = Object.keys(connections).find(key => connections[key] ===socket.id);
    io.emit("removeUser", offlineUser);
    delete connections[offlineUser];
    const id =activeUsers.findIndex(user => user.user_name === offlineUser);
    if(id !== -1){
      activeUsers.splice(id,1);
    }
    console.log(connections);
  })
  socket.on("message", (data) =>{
    const {user, message} = data;
    const socketId = connections[user];
    if(socketId){
      io.to(socketId).emit("newMessage", data);
    }else{
      console.log(`user ${user} not active`)
    }
    console.log(message);
  })
})





app.use('/api', loginRoutes);

app.get('/api/posts', (req, res) => {
    const { pageNumber, pageSize } = req.query;
    const currentPage = parseInt(pageNumber) || 1;
    const size = parseInt(pageSize) || 5;
    const startIndex = (currentPage - 1) * size;
    const endIndex = currentPage * size;
  
    const paginatedPosts = posts.slice(startIndex, endIndex);
    
    res.json({
      currentPage,
      pageSize: size,
      totalPages: Math.ceil(posts.length / size),
      totalPosts: posts.length,
      posts: paginatedPosts
    });
  });


const PORT = 3004;
server.listen(PORT, () =>{
    console.log("server is running", PORT);
})

