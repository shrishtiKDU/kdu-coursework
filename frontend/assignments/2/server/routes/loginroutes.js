const express = require("express");
const router = express.Router();
const createPost = require("../controller/postcontroller");
const { loginCred } = require("../controller/logincontroller");
router.post("/posts", createPost);
router.post("/user/login", loginCred);

module.exports = router;
