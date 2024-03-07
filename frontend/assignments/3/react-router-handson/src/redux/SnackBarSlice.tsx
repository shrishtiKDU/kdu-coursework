import { createSlice, PayloadAction } from "@reduxjs/toolkit";

interface ErrorType{
    message:string | null;
}

const initialState:ErrorType ={
    message:null,
}

const errorSlice = createSlice({
    name :"error",
    initialState,
    reducers:{
        setError(state, action:PayloadAction<string>){
            state.message = action.payload;
        },
        clearError(state){
            state.message=null;
        }
    }
});

export const {setError, clearError} = errorSlice.actions;
export default  errorSlice.reducer;

