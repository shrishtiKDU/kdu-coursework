import { configureStore } from "@reduxjs/toolkit";
import RoomReducer from "./roomSlice";


export const store = configureStore({
    reducer:{
        roomList:RoomReducer,
      
    }
})

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;