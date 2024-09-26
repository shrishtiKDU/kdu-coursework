const submitbtn = document.getElementById("submit-btn");
const username = document.getElementById("username");
const password = document.getElementById("password");
submitbtn.addEventListener("click", (e) => {
  e.preventDefault();
  fetch("http://localhost:3004/api/user/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      username: username.value,
      password: password.value,
    }),
  })
    .then((res) => res.json())
    .then((data) => {
      if (data.status) {
        sessionStorage.setItem("loggedInUser", JSON.stringify(data.user));
        if (sessionStorage.length > 0) {
          // Data is stored in sessionStorage
          console.log("SessionStorage contains data");
        } else {
          // No data stored in sessionStorage
          console.log("SessionStorage is empty");
        }
        window.location.href = "http://127.0.0.1:5500/home.html";
      } else {
        alert(data.message);
      }
    })
    .catch((error) => {
      console.error("Error:", error);
    });
});
