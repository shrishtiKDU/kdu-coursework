const post = document.getElementById("tweet-input");
const submitbtn = document.querySelector(".tweet-btn");
const tweetsContainer = document.querySelector(".posts");
submitbtn.addEventListener("click", (e) => {
  e.preventDefault();
  const postText = post.value.trim();
  console.log(postText);
  if (postText === "") {
    alert("Please enter something to post.");
    return;
  }

  fetch("http://localhost:3004/api/posts", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ content: postText }),
  })
    .then((res) => res.json())
    .then((data) => {
      if (data.status) {
        addNewTweet("Nitesh Gupta", postText);
        post.value = "";
      } else {
        alert(data.message);
      }
    });
});

function addNewTweet(username, tweetBody) {
  // Create elements for the new tweet
  const newTweet = document.createElement("div");
  newTweet.classList.add("tweet");
  const tweetData = {
    username: username,
    tweetBody: tweetBody,
  };

  newTweet.innerHTML = `
        <div class="tweet-img">
            <img src="./assets/Profile/profile pic.png" alt="pfp" class="profile-icon"/>
        </div>
        <div class="tweet-desc">
            <div class="tweet-head">
                <div class="tweet-head-info">
                    <p class="name">Nitesh Gupta</p>
                    <p class="username" id="tweet-username">@${username
                      .toLowerCase()
                      .replace(" ", "_")}  <span id="dot"> . </span>  34s</p>
                </div>
                <p class="more-option"> ...</p>
            </div>
            <div class="tweet-body-main">
                <p class="tweet-body">${tweetBody}</p>
                <div class="tweet-nav">
                    <img src="./assets/myassets/comment.png" alt="comment" class="tweet-nav-icon">
                    <img src="./assets/myassets/retweet.png" alt="retweet" class="tweet-nav-icon">
                    <img src="./assets/myassets/like.png" alt="like" class="tweet-nav-icon">
                    <img src="./assets/myassets/insights.png" alt="insights" class="tweet-nav-icon">
                    <div class="last-two-icon">
                        <img src="./assets/myassets/bookmark-dark.png" alt="bookmark" class="tweet-nav-icon">
                        <img src="./assets/myassets/save.png" alt="save" class="tweet-nav-icon">
                    </div>
                </div>
            </div>
        </div>
    `;
  tweetsContainer.insertBefore(newTweet, tweetsContainer.firstChild);
}

let page = 1;
const pageSize = 5;
let isLoading = false;

window.onload = function () {
  loadPosts();
  window.addEventListener("scroll", handleScroll);
};

async function loadPosts() {
  if (isLoading) return;
  isLoading = true;
  const response = await fetch(
    `http://localhost:3004/api/posts?page=${page}&pageSize=${pageSize}`
  );
  const data = await response.json();
  const postsContainer = document.getElementById("posts");

  data.posts.forEach((post) => {
    const postElement = document.createElement("div");
    postElement.classList.add("tweet");
    if (post.content) {
      postElement.innerHTML = `
            <div class="tweet-img">
            <img src="./assets/Profile/profile pic.png" alt="pfp" class="profile-icon"/>
        </div>
        <div class="tweet-desc">
            <div class="tweet-head">
                <div class="tweet-head-info">
                    <p class="name">Nitesh Gupta</p>
                    <p class="username" id="tweet-username">@${post.username
                      .toLowerCase()
                      .replace(" ", "_")}  <span id="dot"> . </span>  34s</p>
                </div>
                <p class="more-option"> ...</p>
            </div>
            <div class="tweet-body-main">
                <p class="tweet-body">${post.content}</p>
                <div class="tweet-nav">
                    <img src="./assets/myassets/comment.png" alt="comment" class="tweet-nav-icon">
                    <img src="./assets/myassets/retweet.png" alt="retweet" class="tweet-nav-icon">
                    <img src="./assets/myassets/like.png" alt="like" class="tweet-nav-icon">
                    <img src="./assets/myassets/insights.png" alt="insights" class="tweet-nav-icon">
                    <div class="last-two-icon">
                        <img src="./assets/myassets/bookmark-dark.png" alt="bookmark" class="tweet-nav-icon">
                        <img src="./assets/myassets/save.png" alt="save" class="tweet-nav-icon">
                    </div>
                </div>
            </div>
        </div>
    `;
      //  postsContainer.insertBefore(postElement, postsContainer.firstChild);
      postsContainer.appendChild(postElement);
    }
  });

  page++;
  isLoading = false;
  window.removeEventListener("scroll", handleScroll);
}

function handleScroll() {
  if (window.innerHeight + window.scrollY >= document.body.offsetHeight) {
    loadPosts();
  }
}
