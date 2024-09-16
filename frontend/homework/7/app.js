const express = require("express");
const http = require("http");
const cors = require("cors");
const socketIo= require('socket.io');

const app =express();
app.use(cors());
app.use(express.json());

const server = http.createServer(app);
const io= new socketIo.Server(server, {
    cors:{
        origin:"*"
    }
});



io.on("connection", socket =>{

console.log("connection created");

socket.on('chatMessage', msg =>{

    io.except(socket.id).emit('chatMessage', msg); 
})
})




const PORT =3000;
server.listen(PORT, ()=>{
    console.log("server is running on port", PORT);
})