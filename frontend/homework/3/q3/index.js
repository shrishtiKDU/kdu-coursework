

const shoes = [
    { type: "sneaker", color: "cyan", size: "xl", price: 400},
    { type: "loafer", color: "green", size: "l", price: 700},
]


const shirts = [
    { type: "typ1", color: "cyan", size: "xl", price: 400},
    { type: "typ2", color: "green", size: "l", price: 700},
    { type: "typ3", color: "blue", size: "xs", price: 800},

]

const warehouse =shoes.concat(shirts);

console.log(warehouse);

var sum=0;
function total(items){
    items.forEach(element => {
        sum+=element.price;
    });
    return sum;
}

console.log(total(warehouse));

// sort warehouse array accoridn g to decending price of products

function compare(a,b){
    const itemA = a.price;
    const itemB = b.price;
    if(itemA<itemB){
        return -1;
    }
    else{
        return 1;
    }
    return 0;
}

warehouse.sort(compare);
console.log(warehouse);


// display product with color blue 

warehouse.forEach(element => {
    if(element.color == "blue")
    console.log(element);
})

