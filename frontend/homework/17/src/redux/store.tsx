import { configureStore } from "@reduxjs/toolkit";
import ItemReducer from "./ItemSlice";
import SnackBarSlice from "./SnackBarSlice";

export const store = configureStore({
    reducer:{
        productList:ItemReducer,
        snackbar: SnackBarSlice,
    }
})

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;