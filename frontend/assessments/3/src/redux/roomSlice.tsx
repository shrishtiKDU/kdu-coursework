import { APIRooms } from "../util/APIRooms";
import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { getRooms } from "./FetchData";

interface RoomtType {
  rooms: APIRooms[];
  typeroom:string,
  preference:string,
  price:string,
  state: "fulfilled" | "pending" | "rejected";
  error?: string;
}

const initialState: RoomtType = {
  rooms: [],
  typeroom:"",
  preference:"",
  price:"",
  state: "pending",
};

const roomSlice = createSlice({
  name: "roomList",
  initialState,
  reducers: {
    setRooms: (state, action: PayloadAction<APIRooms[]>) => {
      state.rooms = action.payload;
    },
    setRoomType: (state, action: PayloadAction<string>) => {
      state.typeroom = action.payload;
    },
    setPreference:(state, action: PayloadAction<string>) => {
      state.preference = action.payload;
    },
    setPrice:(state, action: PayloadAction<string>) => {
      state.price = action.payload;
    },
  },
  extraReducers(builder) {
    builder
      .addCase(getRooms.pending, (state) => {
        state.state = "pending";
      })
      .addCase(getRooms.fulfilled, (state, action) => {
        state.rooms = action.payload;
        state.state = "fulfilled";
      })
      .addCase(getRooms.rejected, (state, action) => {
        state.state = "rejected";
        state.error = action.payload as string;
      });
  },
});

export default roomSlice.reducer;
export const { setRooms, setPrice, setPreference, setRoomType } = roomSlice.actions;
