function code(input){
    input = input.replaceAll("a", "4");
    input = input.replaceAll("e", "3");
    input = input.replaceAll("i", "1");
    input = input.replaceAll("o", "0");
    input = input.replaceAll("s", "5");
    return input;
}

var input = "javascript is cool";
input = code(input);
console.log(input);