import { APIProduct } from "../util/APIProduct";
import {PayloadAction, createSlice } from "@reduxjs/toolkit";
import { getProducts } from "./FetchData";

interface ItemType{
    products:APIProduct[],
    state:"fulfilled" | "pending" | "rejected";
    error?:string;
    filteredProduct: APIProduct[],
    searchQuery:string,
    filter:string,
    sort:string,
}
const initialState: ItemType={
    products:[],
    state:"pending",
    filteredProduct: [],
    searchQuery:"",
    filter:"",
    sort:""

}

const itemSlice = createSlice({
    name:"productList",
    initialState,
    reducers:{
        setSearchQuery: (state, action: PayloadAction<string>) => {
            state.searchQuery = action.payload;
          },
          setFilterQuery:(state, action:PayloadAction<string>)=>{
            state.filter=action.payload;
          },
          setSortQuery:(state, action:PayloadAction<string>)=>{
            state.sort=action.payload;
          },
          setFilteredProducts:(state,action:PayloadAction<APIProduct[]>)=>{
            state.filteredProduct=action.payload;
          }
    },
    extraReducers(builder){
        builder.addCase(getProducts.pending, (state) =>{
            state.state="pending"
        }).addCase(getProducts.fulfilled , (state,action) =>{
            state.products=action.payload;
            state.filteredProduct = action.payload;
            state.state="fulfilled"
        }).addCase(getProducts.rejected, (state, action) =>{
            state.state="rejected";
            state.error=action.payload as string;
        })
    }
})


export default itemSlice.reducer;
export const {setSearchQuery, setFilterQuery, setSortQuery, setFilteredProducts} = itemSlice.actions;