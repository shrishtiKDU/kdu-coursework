const socket = io("http://127.0.0.1:3004");

socket.on("newUser", (data) => {
  addUser(data);
  console.log("an");
});

socket.on("newUsers", (data) => {
  data.map((user) => {
    addUser(user);
  });
});

let selected = "";

function addUser(user) {
  console.log(user, "Aaa");
  let chatDivHtml = `
  <button id="${user.user_name}" class="message-user">
    <img src="${user.profile_url}" class="profile-icon">
    <p class="name" id="msg-name">${user.user_name}</p>
    <p class="username" id="msg-uname">@${user.user_name}</p>
  </button>
`;

  // Convert the HTML string to a DOM element
  let messagediv = new DOMParser().parseFromString(chatDivHtml, "text/html");
  console.log(typeof messagediv, messagediv);

  const newdom = document.getElementById("message-list");
  newdom.appendChild(messagediv.documentElement);

  let chat = document.createElement("div");
  chat.id = `${user.user_name}_chat`;
  chat.style.display = "none";
  chat.classList.add("chat-box");

  let chatTitle = document.createElement("div");

  let usernameDiv = document.createElement("p");
  usernameDiv.innerText = user.user_name;
  chatTitle.appendChild(usernameDiv);
  chatTitle.classList.add("chat-head");

  let messageArea = document.createElement("div");
  messageArea.classList.add("message-list");

  let textBox = document.createElement("div");
  textBox.classList.add("input-msg-div");

  let input = document.createElement("input");
  input.classList.add("input-msg");
  input.placeholder = "enter text here";

  let send = document.createElement("button");
  send.classList.add("send-btn");

  // Create the img element
  let img = document.createElement("img");
  img.setAttribute("src", "./assets/myassets/sent.png");
  img.classList.add("sent-arrow");

  // Append the img element to the button
  send.appendChild(img);
  textBox.appendChild(input);
  textBox.appendChild(send);
  console.log("jaaaaaaaaaaaaaaj", textbBox);

  chat.appendChild(chatTitle);
  chat.appendChild(messageArea);
  chat.appendChild(textBox);
  document.getElementById("main-chat").appendChild(chat);

  messagediv.addEventListener("click", () => {
    document.querySelectorAll(".chat-box").forEach((chatDiv) => {
      chatDiv.style.display = "none";
    });
    selected = chatButton.id;
    chat.style.display = "flex";
  });

  send.addEventListener("click", () => {
    const message = input.value.trim();
    if (message !== "") {
      let data = {
        from: JSON.parse(sessionStorage.getItem("loggedInUser")).user_name,
        user: selected,
        message: message,
      };
      socket.emit("message", data);
      input.value = "";
      displayMessage(data.user, data.message, true);
    }
  });
}

socket.on("removeUser", (data) => {
  const chatDiv = document.getElementById(data);
  if (chatDiv) {
    chatDiv.remove();
    const userChat = document.getElementById(`${data}_chat`);
    userChat.remove();
  }
});

socket.emit("register", JSON.parse(sessionStorage.getItem("loggedInUser")));

socket.on("newMessage", (data) => {
  console.log(data);
  displayMessage(data.from, data.message, false);
});

function displayMessage(user, message, sent) {
  const messageBlock = document.createElement("div");
  messageBlock.classList.add(sent ? "message-sent" : "message-recieved");

  const messageText = document.createElement("div");
  messageText.innerText = message;

  messageBlock.appendChild(messageText);

  const chatArea = document
    .getElementById(`${user}_chat`)
    .querySelector(".message-list");
  chatArea.appendChild(messageBlock);
}
