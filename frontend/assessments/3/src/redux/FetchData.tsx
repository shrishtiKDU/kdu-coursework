import { createAsyncThunk } from "@reduxjs/toolkit";

export const getRooms = createAsyncThunk("getRooms", async () => {
  try {
    const response = await fetch("https://kdu-automation.s3.ap-south-1.amazonaws.com/mini-project-apis/assessment-3.json");
    const data = await response.json();
    return data.roomTypes; // Return the result directly without specifying a type
  } catch {
    throw new Error("Data couldn't be fetched");
  }
});
