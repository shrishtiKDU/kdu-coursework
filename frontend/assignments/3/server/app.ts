import express from "express";
import http from "http";
import cors from "cors";
import socketIo from "socket.io";
import { users } from "./data/Users.tsx";
import {Transaction} from "./util.tsx";
const app = express();
app.use(cors());
app.use(express.json());
const server = http.createServer(app);

const io = new socketIo.Server(server, {
  cors: {
    origin: "*",
  },
});

let currentUser = 0;

io.on("connection", (socket) => {
  const user = users[currentUser];
  currentUser = (currentUser + 1) % users.length;
  socket.emit("user", user);

  console.log(`${user} connected`);

  socket.on("joinRoom", (name) => {
    socket.join(name);
    console.log("room joined" + socket.id +"  room : " + name);
  });

  socket.on("activity", (transaction:Transaction) => {
    
    if (transaction.status === 'Failed') {
        return;
    }
    io.to(transaction.stock_symbol).except(socket.id).emit("newTxn", {
        name:user, ...transaction
    });
     socket.on('disconnect', ()=>{
        console.log(socket.id + "let");
     })
  });
});

const PORT = 3005;
server.listen(PORT, () => {
  console.log("server is running", PORT);
});
