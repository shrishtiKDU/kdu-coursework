const path = require('path');

/**
 * Extracts file information from a given file path.
 * @param {string} filePath - The file path.
 * @returns {Object} An object containing the file information.
 */
function extractFileInfo(filePath) {
    return {
        extension: path.extname(filePath),
        baseName: path.basename(filePath),
        directory: path.dirname(filePath)
    };
}

/**
 * Processes an array of file paths to extract information about each file.
 * @param {string[]} filePaths - An array of file paths.
 * @returns {Object[]} An array of objects containing file information for each file path.
 */
function processFilePaths(filePaths) {
    return filePaths.map(filePath => extractFileInfo(filePath));
}

const filePaths = [
    'dir1/dir2/file1.txt',
    'dir1/dir3/file2.txt',
    'dir1/dir3/file3.md',
    'dir4/file4.jpg',
    'dir4/file5.pdf',
];

const fileInfo = processFilePaths(filePaths);
console.log(fileInfo);
