
import { createUseStyles } from 'react-jss';
import { APIRooms } from '../util/APIRooms';

import { useDispatch, useSelector } from "react-redux";
import { setPrice, setRoomType } from '../redux/roomSlice';
import {  MouseEventHandler } from 'react';

interface RoomProp {
    detail: APIRooms;
  }

export default function RoomSelector({detail}:RoomProp) {
    const reduxDispatch = useDispatch();

    const useStyeles = createUseStyles({
        option:{
            border:"1px solid gray",
            paddingLeft:"32px",
            paddingRight:"32px",
            paddingTop:"16px",
            paddingBottom:"16px"
        },
    })
    const handleRoomType= (event: MouseEventHandler<HTMLButtonElement>) => {
       reduxDispatch(setRoomType(event.target.id));
       reduxDispatch(setPrice(event.target.id));
       console.log(event.target.id);
      };
    
    const classes = useStyeles();
  return (
    <div className={classes.option} id={detail.costPerNight} onClick={handleRoomType}>{detail.name}</div>
  )
}
