import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { IStock } from "../util/Istock";
import { getStocks } from "./FetchStocks";

interface ErrorType{
    message:string | null,
    state:"fulfilled" | "pending" | "rejected",
    error?:string,
    stocks:IStock[],
    watchListStocks: IStock[],
}

const initialState:ErrorType ={
    message:null,
    state:'pending',
    stocks:[],
    watchListStocks:[]
}

const stockSlice = createSlice({
    name :"stockList",
    initialState,
    reducers:{
      setStocks :(state, action:PayloadAction<IStock[]>)=>{
        state.stocks=action.payload;
      },
      setWatchListStocks : (state, action:PayloadAction<IStock>)=>{
        const existingStock = state.watchListStocks.find(
            (stock) => stock.stock_symbol === action.payload.stock_symbol
          );
          // If the stock doesn't exist, push it to the watchlist
          if (!existingStock) {
            state.watchListStocks.push(action.payload);
          }
      // state.watchListStocks.push(action.payload);
      },
      deleteStockFromList:(state, action:PayloadAction<IStock>)=>{
        state.watchListStocks = state.watchListStocks.filter(stock => stock.stock_symbol!== action.payload.stock_symbol);
      }
    },
    extraReducers(builder){
        builder.addCase(getStocks.pending, (state) =>{
            state.state="pending"
        }).addCase(getStocks.fulfilled , (state,action) =>{
            state.stocks=action.payload;
            state.state="fulfilled"
        }).addCase(getStocks.rejected, (state, action) =>{
            state.state="rejected";
            state.error=action.payload as string;
        })
    }

});

export default  stockSlice.reducer;
export const {setStocks, setWatchListStocks,deleteStockFromList} =  stockSlice.actions;

