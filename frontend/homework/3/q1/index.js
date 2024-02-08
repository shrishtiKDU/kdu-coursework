

const billArray = 
[
140,45,280
]

function tipCalc(billArray){
 
    const tips=[];
    const finalCost=[];
    for(let i=0;i<billArray.length;i++){
        let tip=0;
        if(billArray[i]<50){
            tip = billArray[i]*0.2;
        }else if(billArray[i]>=50 && billArray[i]<=200){
            tip=billArray[i] * 0.5;
        }
        else{
            tip = billArray[i]*0.1;
        }
        tips.push(tip);
        finalCost.push(billArray[i] + tip);
    }
    return[tips, finalCost];
}

const[tips,finalCost] = tipCalc(billArray);


console.log("tips", tips);
console.log("cost", finalCost);