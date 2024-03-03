import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { getTxn } from "./FetchTxn";
import { ITxn } from "../util/Istock";

interface ErrorType{
    message:string | null,
    state:"fulfilled" | "pending" | "rejected",
    error?:string,
    transactions:ITxn[],
    filteredTxn: ITxn[],
    searchQuery:string,
    status:string,
    filterByName:string
}

const initialState:ErrorType ={
    message:null,
    state:'pending',
    transactions:[],
    searchQuery:"",
    filteredTxn:[],
    status:"",
    filterByName:""
}

const transactionSlice = createSlice({
    name :"txnList",
    initialState,
    reducers:{
      setTransactions :(state, action:PayloadAction<ITxn[]>)=>{
        state.transactions=action.payload;
      },
      setSearchQuery :(state, action:PayloadAction<string>)=>{
        state.searchQuery=action.payload;
      },
      setFilteredTxn:(state, action:PayloadAction<ITxn[]>)=>{
        state.filteredTxn=action.payload;
      },
      setStatus:(state, action:PayloadAction<string>)=>{
        state.status=action.payload;
      },
      setFilterByName:(state, action:PayloadAction<string>)=>{
        state.filterByName=action.payload;
      },
    },
    extraReducers(builder){
        builder.addCase(getTxn.pending, (state) =>{
            state.state="pending"
        }).addCase(getTxn.fulfilled , (state,action) =>{
            state.transactions=action.payload;
            state.state="fulfilled"
        }).addCase(getTxn.rejected, (state, action) =>{
            state.state="rejected";
            state.error=action.payload as string;
        })
    }

});

export default  transactionSlice.reducer;
export const {setTransactions, setSearchQuery, setFilteredTxn, setStatus, setFilterByName} =  transactionSlice.actions;


