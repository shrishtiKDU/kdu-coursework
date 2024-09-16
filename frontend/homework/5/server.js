const fs = require('fs').promises;
const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const http = require("http");

/**
 * Middleware to parse JSON bodies for incoming requests.
 */
app.use(bodyParser.json());

/**
 * Endpoint to display system information.
 * @param {Object} req - The request object.
 * @param {Object} res - The response object.
 */
app.get('/api/display', async (req, res) => {
    try {
        const data = await readFile('./write.json');
        res.end("Hello, my name is Shrishti!\n" + " Here is my system information: \n" + data);
    } catch (error) {
        console.error("Error occurred while reading file: ", error);
        res.status(500).send("Internal Server Error");
    }
});

/**
 * Reads a file asynchronously.
 * @param {string} filepath - The path of the file to be read.
 * @returns {Promise<string>} A promise resolving to the content of the file.
 */
async function readFile(filepath) {
    try {
        const data = await fs.readFile(filepath);
        console.log(data.toString());
        return data.toString();
    } catch (error) {
        console.error("Error occurred while reading file: ", error);
        throw error;
    }
}

const server = http.createServer(app);

const PORT = 8000;
server.listen(PORT, () => {
    console.log("Server is running on port 8000");
});
