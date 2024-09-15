

const daysArray = ["Sunday "," Monday ",
" Tuesday","Wednesday "," Thursday "," Friday",
"Saturday "];

const resultArray= [];
for(let i=0;i<daysArray.length;i++){

   resultArray.push(daysArray[i].trim().substr(0,3).toUpperCase());
}
console.log(resultArray);