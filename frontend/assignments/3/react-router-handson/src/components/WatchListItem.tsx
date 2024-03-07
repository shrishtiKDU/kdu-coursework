import React, { useState } from "react";
import { createUseStyles } from "react-jss";
import { IStock } from "../util/Istock";
import TickSvgData from "../assets/ticksvgfill.svg"; // Import the tick SVG
import CrossSvgData from "../assets/cross.svg"; 
import { deleteStockFromList } from "../redux/StockSlice";
import { useDispatch } from "react-redux";
import { Link } from "react-router-dom";

interface StockType {
  detail: IStock;
}

const useStyeles = createUseStyles({
  symbol: {
    height: "3rem",
    width: "3rem",
    display: "flex",
    alignItems: "center",
    marginLeft: "2rem",
    color:"black"
  },
  main: {
    borderBottom: "1px solid black",
    display: "flex",
    justifyContent: "space-between",
  },
  right_info: {
    display: "flex",
    justifyContent: "space-between",
  },
  price: {
    fontWeight: "bold",
    display: "flex",
    alignItems: "center",
  },
  add: {
    display: "flex",
    alignItems: "center",
    marginLeft: "8rem",
    marginRight: "3rem", 
  },
  tolink:{
    textDecoration:"none",
  }
});

export default function WatchListItem({detail}: StockType) {

  const [isHovered, setIsHovered] = useState(false);
  const classes = useStyeles();

  const reduxDispatch = useDispatch();

  const handleSvgClick = () => {
      reduxDispatch(deleteStockFromList(detail));
  };

  const handleMouseEnter = () => {
    setIsHovered(true);
  };

  const handleMouseLeave = () => {
    setIsHovered(false);
  };

  console.log(detail, "detail");
  return (
    <div className={classes.main}>
        <Link to={`/stockpage/${detail.stock_name}`} className={classes.tolink}>
      <p className={classes.symbol}>{detail.stock_symbol}</p>
      </Link>
      <div className={classes.right_info}>
        <p className={classes.price}> &#x20B9; {detail.base_price}</p>
        <div className={classes.add} onClick={handleSvgClick} onMouseEnter={handleMouseEnter} onMouseLeave={handleMouseLeave}>
           {isHovered ? (
              <img src={CrossSvgData} alt="Cross SVG" width="24px" height="24px" />
            ) : (
              <img src={TickSvgData} alt="Tick SVG" width="24px" height="24px" />
            )}
         
       
        </div>
      </div>
    </div>
  );
}
