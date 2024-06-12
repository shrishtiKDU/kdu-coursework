import React from "react";
import { IData } from "../Util/text";
import { PayloadAction, createSlice } from "@reduxjs/toolkit";
interface ListType {
  searchQuery: string;
  todos: IData[];
  inputTxt: string;
}

const initialState: ListType = {
  searchQuery: "",
  todos: [],
  inputTxt: "",
};
const todoSlice = createSlice({
  name: "todoList",
  initialState,
  reducers: {
    setSearchQuery: (state, action: PayloadAction<string>) => {
      state.searchQuery = action.payload;
    },
    setTodos: (state, action: PayloadAction<IData[]>) => {
      state.todos = action.payload;
    },
    setInputTxt: (state, action: PayloadAction<string>) => {
      state.inputTxt = action.payload;
    },
  },
});

export default todoSlice.reducer;
export const { setSearchQuery, setInputTxt, setTodos } = todoSlice.actions;
