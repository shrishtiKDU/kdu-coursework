import React, { useEffect, useState } from "react";
import StockItem from "../components/StockItem";
import { createUseStyles, Theme } from "react-jss";
import { getStocks } from "../redux/FetchStocks";
import { setStocks } from "../redux/StockSlice";
import { APPDispatch } from "../redux/store";
import { useDispatch, useSelector } from "react-redux";
import CircularProgress from "@mui/material/CircularProgress";

import Snackbar from "@mui/material/Snackbar";
import { RootState } from "../redux/store";
import { Alert, Pagination } from "@mui/material";
import { clearError } from "../redux/SnackBarSlice";
import { Link } from "react-router-dom";
import { setFilteredTxn } from "../redux/TxnSlice";

const useStyles = createUseStyles((theme: Theme) => ({
  main: {
    backgroundColor: "rgb(248,249,250)",
  },
  menubar: {
    display: "flex",
    justifyContent: "start",
    marginBottom: "3rem",
  },
  txt: {
    fontSize: "1.8rem",
    marginLeft: "1.2rem",
    marginTop: "2rem",
    textDecoration: "none",
    color: "black",
    borderBottom: "3px solid transparent", // Default bottom border
    
  },
  active: {
    borderBottom: "3px solid rgb(25,113,194)", // Apply bottom border when active
  },
  listhead: {
    display: "flex",
    justifyContent: "space-between",
    borderBottom: "3px solid black",
    padding: "0.7rem",
  },
  listheadright: {
    display: "flex",
  },
  listdiv: {
    border: "3px solid black",
    marginLeft: "18rem",
    marginRight: "18rem",
    borderRadius: "1rem",
  },
  divtxt: {
    fontSize: "1.6rem",
    marginRight: "2rem",
    marginLeft: "2rem",
  },
  listbody: {
    paddingRight: "2rem",
    paddingBottom: "2rem",
    paddingLeft: "2rem",
  },
  pages: {
    display: "flex",
    justifyContent: "center",
    '& .MuiPaginationItem-page.Mui-selected': {
      //  color: theme.palette.primary.main,
    },
  },
}));

export default function Explore() {
  const classes = useStyles();
  const [loading, setLoading] = useState(true);
  const [open, setOpen] = useState(false);
  const [error, setError] = useState<string | null>(null);
  const [currentPage, setCurrentPage] = useState(1);
  const [itemsPerPage] = useState(7);
  const [activeLink, setActiveLink] = useState("explore");

  const dispatch: APPDispatch = useDispatch();
  const stocks = useSelector((state: RootState) => state.stockList.stocks);
  console.log(stocks);

  useEffect(() => {
    const fetchData = async () => {
      try {
        setLoading(true);
        setOpen(true);
        const stocks = await dispatch(getStocks());
        setLoading(false);
        setStocks(stocks.payload);
      } catch (error) {
        console.error("Error fetching products", error);
        setLoading(false);
        setError("Error fetching products");
        setOpen(true);
      }
    };
    fetchData();
  }, [dispatch]);

  // snackbar functionality

  const handleClose = () => {
    setOpen(false);
    dispatch(clearError());
  };

  const indexOfLastItem = currentPage * itemsPerPage;
  const indexOfFirstItem = indexOfLastItem - itemsPerPage;
  const currentStocks = stocks.slice(indexOfFirstItem, indexOfLastItem);

  const paginate = (pageNumber: number) => setCurrentPage(pageNumber);

  const handleActiveLink = (link: string) => {
    setActiveLink(link);
  };

  return (
    <div className={classes.main}>
      <div className={classes.menubar}>
        <Link
          to="/"
          className={`${classes.txt} ${activeLink === "explore" ? classes.active : ""}`}
          onClick={() => handleActiveLink("explore")}
        >
          Explore
        </Link>
        <Link
          to="/watchlist"
          className={`${classes.txt} ${activeLink === "watchlist" ? classes.active : ""}`}
          onClick={() => handleActiveLink("watchlist")}
        >
          My WatchList
        </Link>
      </div>
      <div className={classes.listdiv}>
        <div className={classes.listhead}>
          <div>
            <p className={classes.divtxt}>Company</p>
          </div>
          <div className={classes.listheadright}>
            <p className={classes.divtxt}>Base Price</p>
            <p className={classes.divtxt}>WatchList</p>
          </div>
        </div>

        {loading ? (
          <div>
            <CircularProgress size={100} />
          </div>
        ) : error ? (
          <Snackbar
            open={open}
            autoHideDuration={5000}
            onClose={handleClose}
            message="Error fetching the data ."
          >
            <Alert onClose={handleClose} severity="error" variant="filled">
              {error}
            </Alert>
          </Snackbar>
        ) : (
          <div className={classes.listbody}>
            {currentStocks.map((stock) => (
              <StockItem key={stock.stock_name} detail={stock} />
            ))}
          </div>
        )}
        <Pagination
          count={Math.ceil(stocks.length / itemsPerPage)}
          page={currentPage}
          onChange={(event, page) => paginate(page)}
          className={classes.pages}
          color="primary"
          variant="outlined"
        />
      </div>

      {!loading && (
        <Snackbar open={open} autoHideDuration={6000} onClose={handleClose}>
          <Alert onClose={handleClose} severity="success" variant="filled">
            Data fetched successfully
          </Alert>
        </Snackbar>
      )}
    </div>
  );
}
