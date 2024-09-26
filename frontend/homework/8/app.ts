
interface Recipe {
    image: string;
    name: string;
    rating: number;
    cuisine: string;
    ingredients: string[];
    difficulty: string;
    timetaken: number;
    calorieCount:number;
}



// fetchdata


async function fetchRecipie() : Promise<Recipe[]> {
    const response  = await fetch('https://dummyjson.com/recipes');
    const data = await response.json();
   

    const recipes: Recipe[] = data.recipes.map((recipe: any) => ({
        image: recipe.image,
        name: recipe.name,
        rating: recipe.rating,
        cuisine: recipe.cuisine,
        ingredients: recipe.ingredients,
        difficulty: recipe.difficulty,
        timetaken: recipe.prepTimeMinutes + recipe.cookTimeMinutes,
        calorieCount: recipe.caloriesPerServing
    }));
    console.log(recipes);
    return recipes;
}


// search recipie api func 

async function searchRecipie(searchQuery:string):Promise<Recipe[]>{
 try{
    const url = `https://dummyjson.com/recipes/search?q=${encodeURIComponent(searchQuery)}`;
    const response = await fetch(url);
    const data = await response.json();
    const recipes:Recipe[]  = data.recipes.map((recipe : any)=>({
        image: recipe.image,
        name: recipe.name,
        rating: recipe.rating,
        cuisine: recipe.cuisine,
        ingredients: recipe.ingredients,
        difficulty: recipe.difficulty,
        timetaken: recipe.prepTimeMinutes + recipe.cookTimeMinutes,
        calorieCount: recipe.caloriesPerServing
    }));
    console.log(recipes);
    return recipes;
 }catch(error){
    console.log('Error', error);
    return [];
 }
}

searchRecipie('Vegetarian');

fetchRecipie();



