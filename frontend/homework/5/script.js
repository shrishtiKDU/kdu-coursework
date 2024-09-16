const os = require('os');  
const fs = require("fs");

/**
 * Retrieves and returns information about the current operating system.
 * @returns {Object} An object containing various information about the operating system.
 */
function getOSInfo() {
    const hostname = os.hostname();
    const operatingSystem = os.platform();
    const architecture = os.arch();
    const release = os.release();
    const uptime = os.uptime();
    const cpuCores = os.cpus().length;
    const totalMemory = os.totalmem();
    const freemem = os.freemem();
    const workingdir = process.cwd();

    return {
        hostname: hostname,
        operatingSystem: operatingSystem,
        architecture: architecture,
        release: release,
        uptime: uptime,
        cpuCores: cpuCores,
        totalMemory: totalMemory,
        freemem: freemem,
        workingdir: workingdir
    };
}

// Get OS information
const osInfo = getOSInfo();
console.log(osInfo);

// Write OS information to a JSON file
fs.writeFile("write.json", JSON.stringify(osInfo), err => {
    if (err) throw err;
    console.log("Done writing");
});

// Convert OS information to JSON string
const osInfoJSON = JSON.stringify(osInfo);

// Export the JSON string containing OS information
module.exports = osInfoJSON;
