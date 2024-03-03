import { createAsyncThunk } from "@reduxjs/toolkit";

export const getProducts = createAsyncThunk("getProducts", async () => {
  try {
    const response = await fetch("https://fakestoreapi.com/products");
    const data = await response.json();
    return data; // Return the result directly without specifying a type
  } catch {
    throw new Error("Data couldn't be fetched");
  }
});
