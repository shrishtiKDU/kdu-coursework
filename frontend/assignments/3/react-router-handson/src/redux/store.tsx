import { configureStore } from "@reduxjs/toolkit";
import SnackBarSlice from "./SnackBarSlice";
import stockReducer from "./StockSlice";
import transactionReducer from "./TxnSlice";

export const store = configureStore({
    reducer:{
    transactionList: transactionReducer,
    stockList:stockReducer,
    snackbar: SnackBarSlice,
    }
})


export type RootState = ReturnType<typeof store.getState>;
export type APPDispatch = typeof store.dispatch;
