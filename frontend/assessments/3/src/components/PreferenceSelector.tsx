import React, { MouseEventHandler } from 'react'
import { createUseStyles } from 'react-jss';
import { useDispatch } from 'react-redux';
import { setPreference, setPrice } from '../redux/roomSlice';
import { APIRooms, AddOn } from '../util/APIRooms';


interface AddOnProp {
    details: AddOn[],
  }
export default function PreferenceSelector({details}:AddOnProp) {

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
    const handlepreference= (event: MouseEventHandler<HTMLButtonElement>) => {
       reduxDispatch(setPreference(event.target.id));
    //    reduxDispatch(setPrice(event.target.id));
       console.log(event.target.id);
      };
      const classes = useStyeles();
  return (

    {details.map((data)=>{
            return(<p className={classes.option} id={data.cost} onClick={handlepreference}> {data.name}</p>)
        })
    }

   
  )
}
