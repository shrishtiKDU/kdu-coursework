import { createUseStyles } from "react-jss";
import { AppDispatch, RootState } from "../redux/store";
import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";
import { getRooms } from "../redux/FetchData";
import { setRooms } from "../redux/roomSlice";
import RoomSelector from "../components/RoomSelector";
import PreferenceSelector from "../components/PreferenceSelector";

const useStyeles = createUseStyles({
  head: {
    display: "flex",
    justifyContent: "center",
    fontSize: "4rem",
  },

  room: {
    marginTop: "2rem",
  },
  title: {
    backgroundColor: "rgb(240,138,93)",
    color: "white",
    padding: "0.8rem",
  },
  align: {
    display: "flex",
    justifyContent: "space-evenly",
  },
  option: {
    border: "1px solid gray",
    paddingLeft: "32px",
    paddingRight: "32px",
    paddingTop: "16px",
    paddingBottom: "16px",
  },
  price: {
    fontSize: "2rem",
    color: "black",
  },
  btn: {
    backgroundColor: "rgb(240,138,93)",
    paddingLeft: "32px",
    paddingRight: "32px",
    paddingTop: "16px",
    paddingBottom: "16px",
    color: "white",
  },
});

export default function Home() {
  const dispatch: AppDispatch = useDispatch();
  const rooms = useSelector((state: RootState) => state.roomList.rooms);
  const price = useSelector((state: RootState) => state.roomList.price);
  const typeroom = useSelector((state: RootState) => state.roomList.typeroom);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const newRooms = await dispatch(getRooms());
        setRooms(newRooms.payload);
      } catch (error) {
        console.error("Error fetching products", error);
      }
    };
    fetchData();
  }, [dispatch]);





  const classes = useStyeles();
  return (
    <div>
      <div className={classes.head}> Hotel Booking</div>
      <div className={classes.room}>
        <p className={classes.title}>Select room type</p>
        <div className={classes.align}>
          {rooms.map((roomtype) => {
            return <RoomSelector key={roomtype.id} detail={roomtype} />;
          })}
        </div>
      </div>
      <div>
        <p className={classes.title}> Select date</p>
        <div className={classes.align}>
          <input type="date" name="party" min="2017-04-01" max="2017-04-30" />
          <input type="date" name="party" min="2017-04-01" max="2017-04-30" />
        </div>
      </div>
      <div>
        <p className={classes.title}> Select additional add on/preference </p>
        <div className={classes.align}>
          {/* <p className={classes.option} id='breakfast'>Breakfast</p>
                <p className={classes.option} id='balcony'>Balcony Unit</p>
                <p className={classes.option} id='sea'>Sea Facing</p> */}

          {/* {rooms.map((roomtype) => { */}
        //         if(roomtype.name===typeroom){

        //             roomtype.addOns.map((data)=>{
        //                 return ( <PreferenceSelector key={data.name} details={data.} />)

        //             })
        //         }
        //   })}

          
          
        </div>
      </div>

      <p className={classes.price}>Cost + 18%GST=</p>
      <p className={classes.price}> {price}</p>

      <button type="submit" className={classes.btn}>
        Submit
      </button>
    </div>
  );
}
