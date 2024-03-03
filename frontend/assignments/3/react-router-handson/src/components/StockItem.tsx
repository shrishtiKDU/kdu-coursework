import React, { useState } from "react";
import { createUseStyles } from "react-jss";
import { IStock } from "../util/Istock";
import TickSvgData from "../assets/ticksvgfill.svg"; // Import the tick SVG
import PlusSvgData from "../assets/roundsvg.svg"; 
import { deleteStockFromList, setWatchListStocks } from "../redux/StockSlice";
import { useDispatch, useSelector } from "react-redux";
import CrossSvgData from "../assets/cross.svg"; 
import { RootState } from "../redux/store";
import { Link } from 'react-router-dom';

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
    color:"black"
  },
  add: {
    display: "flex",
    alignItems: "center",
    marginLeft: "8rem",
    marginRight: "3rem",
  },
  tolink:{
    textDecoration:"none"
  }
});

export default function StockItem({ detail }: StockType) {
  const classes = useStyeles();
  const [isSvgChanged, setIsSvgChanged] = useState(false); // State to track if SVG is changed
  const [isHovered, setIsHovered] = useState(false);
  const reduxDispatch = useDispatch();
  const watchListStocks = useSelector((state: RootState) => state.stockList.watchListStocks);

  const handleSvgClick = () => {
    setIsSvgChanged(!isSvgChanged);
    if (!isSvgChanged) {
      console.log(detail, "watchlist");
      reduxDispatch(setWatchListStocks(detail));
      console.log(watchListStocks, "aaaaaaaa")
    }
    if (isSvgChanged) {
      reduxDispatch(deleteStockFromList(detail));
      setIsSvgChanged(false);
    }
  };

  const handleMouseEnter = () => {
    setIsHovered(true);
  };

  const handleMouseLeave = () => {
    setIsHovered(false);
  };

  return (
    <div className={classes.main}>
          <Link to={`/stockpage/${detail.stock_name}`} className={classes.tolink}>
      <p className={classes.symbol}>{detail.stock_symbol}</p>
      </Link>
      <div className={classes.right_info}>
        <p className={classes.price}> &#x20B9; {detail.base_price}</p>
        <div className={classes.add} onClick={handleSvgClick} onMouseEnter={handleMouseEnter} onMouseLeave={handleMouseLeave}>
          {isSvgChanged ? (
            isHovered ? (
              <img src={CrossSvgData} alt="Cross SVG" width="24px" height="24px" />
            ) : (
              <img src={TickSvgData} alt="Tick SVG" width="24px" height="24px" />
            )
          ) : (
            <img src={PlusSvgData} alt="Tick SVG" width="24px" height="24px" /> 
          )}
        </div>
      </div>
    </div>

  );
}
