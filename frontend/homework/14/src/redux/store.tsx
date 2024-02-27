import { configureStore } from "@reduxjs/toolkit";
import ListReducer from "./ListSlice";

export const store = configureStore({
  reducer: {
    todoList: ListReducer,
  },
});

export type RootState = ReturnType<typeof store.getState>;
