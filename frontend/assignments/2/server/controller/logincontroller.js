const registeredUsers = [
  {
    id: "1",
    user_name: "shrishti",
    user_email_id: "shrishti@example.com",
    password: "1234",
    profile_url: "https://example.com/user1_profile",
  },
  {
    id: "2",
    user_name: "brian",
    user_email_id: "brian@example.com",
    password: "hello",
    profile_url: "./assets/Profile/brian.png",
  },
  {
    id: "3",
    user_name: "nitesh",
    user_email_id: "nites@example.com",
    password: "beontime",
    profile_url: "https://example.com/user3_profile",
  },
];

exports.loginCred = (req, res) => {
  try {
    const { username, password } = req.body;
    if (!username || !password) {
      return res
        .status(400)
        .json({ status: false, message: "Invalid credentials" });
    }
    const user = registeredUsers.find(
      (user) => user.user_name === username && user.password === password
    );
    if (user) {
      return res
        .status(200)
        .json({ status: true, message: "Login successful", user: user });
    } else
      return res
        .status(401)
        .json({ status: false, message: "Invalid credentials" });
  } catch (err) {
    return res.status(500).json({
      status: false,
      message: "Server error occured",
      error: err.message,
    });
  }
};
