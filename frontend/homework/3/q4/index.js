
const giveData = {
    firstName: 'alex',
    lastName: 'hunter',
    email: 'alex@yahoo.com',
    age: 24,
    city: 'london',
    country: 'england'
    }

Object.entries(giveData).forEach(([key,value]) =>{
    if(key == "email" || key=="age"){

        console.log(value);
    }else{
        giveData[key] = value.toUpperCase();
    
        
    }
});
console.log(giveData);




    // givenData.key(giveData)

    // giveData.element(
    //     element.firstName.toUpperCae();
    //     element.lastName.toUpperCae();
    //     element.city.toUpperCae();
    //     element.country.toUpperCae();
    //     );

    // console.log(giveData);