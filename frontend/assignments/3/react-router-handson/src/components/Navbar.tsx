import React from 'react'
import {createUseStyles} from 'react-jss'
import Img from "../assets/logo.png";
import { Link } from 'react-router-dom';
const useStyeles = createUseStyles({
    myButton:{
        height:"3rem",
        width:"3rem",
        display:'flex',
        alignItems:"center",
    },
    nav:{
        display:' flex',
        justifyContent:'space-between',
     backgroundColor:"rgb(25,113,194)",
     padding:"0.8rem",
     border:"2px solid black",
     margin:"1rem"
    },
    headingtxt:{
        color:"white",
        fontSize:"2.5rem",
        display:'flex',
        alignItems:"center",
    },
    left:{
        display:'flex',
        justifyContent:"space-between",
        textDecoration:"none",
        border:"none"

    },
    right:{
        display:'flex',
        justifyContent:"space-between",
    },
    txt:{
        display:'flex',
        alignItems:"center",
        fontSize:"1.6rem",
        color:"white",
        marginLeft:"1rem",
       
      
    },
    txtlink:{
        textDecoration:"none",
    }

})



export default function Navbar() {

    const classes = useStyeles();
  return (
    <div className={classes.nav}>
         <Link to="/" className={classes.txtlink}>
        <div className={classes.left}>
            <img src={Img} alt='pfp img' className={classes.myButton}/>
            <p className={classes.headingtxt}>KDU Stock Market</p>
        </div>
        </Link>
        <div className={classes.right}>
           <Link to="/" className={classes.txtlink}> <p className={classes.txt}>Summarizer</p></Link>
           <Link to="/portfolio" className={classes.txtlink}><p className={classes.txt}>My Portfolio</p></Link> 
        </div>
    </div>
  )
}
