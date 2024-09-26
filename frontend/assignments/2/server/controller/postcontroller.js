const createPost = (req, res) => {
  try {
    const { content } = req.body;

    if (content) {
      console.log(content);
      return res
        .status(200)
        .json({ status: true, message: "post add successful" });
    } else
      return res.status(401).json({ status: false, message: "not added " });
  } catch (err) {
    return res
      .status(500)
      .json({
        status: false,
        message: "Server error occured",
        error: err.message,
      });
  }
};
module.exports = createPost;
