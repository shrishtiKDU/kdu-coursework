import React, { useEffect, useState } from "react";
import { createUseStyles } from "react-jss";
import { useDispatch, useSelector } from "react-redux";
import { APPDispatch, RootState } from "../redux/store";
import { getTxn } from "../redux/FetchTxn";
import { setFilterByName, setFilteredTxn, setSearchQuery, setStatus, setTransactions } from "../redux/TxnSlice";
import { getStocks } from "../redux/FetchStocks";
import { setStocks } from "../redux/StockSlice";

const useStyeles = createUseStyles({
  main: {
    paddingLeft: "4rem",
    paddingTop: "2rem",
    display: "flex",
  },
  menubar: {
    border: "1px solid black",
    backgroundColor: "rgb(233,236,239)",
    width: "25%",
    padding: "1rem",
    borderRadius: "1.5rem",
    height:"20%",
  },
  menu_head: {
    display: "flex",
    borderBottom: "1px solid black",
    justifyContent: "space-between",
    paddingBottom: "0.5rem",
  },
  filter_txt: {
    fontSize: "1.4rem",
  },
  clear_all: {
    fontSize: "1.4rem",
    color: "rgb(25,113,194)",
  },
  search: {
    paddingTop: "1rem",
    paddingBottom: "1rem",
    borderBottom: "1px solid black",
  },
  search_input: {
    padding: "6px",
    width: "90%",
  },
  date_div: {
    display: "flex",
    justifyContent: "space-between",
    marginTop: "1rem",
    borderBottom: "1px solid black",
    paddingBottom: "1rem",
  },
  date: {
    height: "1.5rem",
    width: "45%",
  },
  passfail: {
    marginTop: "1rem",
    paddingBottom: "1rem",
    borderBottom: "1px solid black",
    display: "flex",
  },
  scrollStock: {
    height: "250px",
    overflow: "auto",
  },
  onestock: {
    paddingTop: "1rem",
  },
  scroll_stock_name: {
    fontSize: "1.3rem",
    paddingLeft: "0.6rem",
  },
  passed: {
    fontSize: "1.2rem",
  },
  failinput: {
    marginLeft: "2rem",
  },
  right: {
    marginLeft: "4rem",
    marginTop:"-3rem",
    width: "100%",
    marginRight: "8rem",
    overflow:"auto"
  },
  all_txn_inrange: {},
  txn_individual: {
    display: "flex",
    marginTop: "1.5rem",
    paddingBottom: "1.5rem",
    borderBottom: "1px solid black",
  },
  txnDateDiv: {
    paddingBottom: "1rem",
    borderBottom: "1px dashed gray",
    marginTop:"4rem"
  },
  txnDate: {
    color: "gray",
    fontSize: "1.2rem",
  },
  stockname: {
    fontSize: "1.3rem",
    width:"50%"
  },
  stocklogo: {
    fontSize: "1.2rem",
    width:"25%"
  },
  stockprice: {
    fontSize: "1.2rem",
    color: "gray",
    width:"25%"
  },
  enddiv: {
    display: "flex",
    width:"25%"
  },
  stockdot: {
    marginLeft: "2rem",
    marginRight: "1rem",
    backgroundColor: "green",
    borderRadius: "100%",
    height: "10px",
    width: "10px",
    marginTop: "4px",
  },
  stocktime: {
    fontSize: "1.2rem",
  },
  redDot:{
    backgroundColor:"red"
  }
});

export default function Portfolio() {
  const classes = useStyeles();
  const dispatch: APPDispatch = useDispatch();

  const transactions = useSelector(
    (state: RootState) => state.transactionList.transactions
  );
  const filterByName= useSelector(
    (state: RootState) => state.transactionList.filterByName
  );

  const filteredTxns = useSelector(
    (state: RootState) => state.transactionList.filteredTxn
  );
  const searchQuery = useSelector(
    (state: RootState) => state.transactionList.searchQuery
  );

  const status = useSelector(
    (state: RootState) => state.transactionList.status,
  );
  const stocks = useSelector((state: RootState) => state.stockList.stocks);

  const [loading, setLoading] = useState(true);
  const [open, setOpen] = useState(false);
  const [error, setError] = useState<string | null>(null);



  // to set filtered txnnnnnnnnnn


  const filterTxns = () => {
    let tempTxns = [...transactions];

    if (searchQuery.trim() !== "" ) {
      const query = searchQuery.toLowerCase();
      tempTxns = tempTxns.filter((txn) =>
        txn.stock_name.toLowerCase().includes(query)
      );
    }
    if(status ==="Passed" || status==="Failed"){
      const query = status.toLowerCase();
      tempTxns = tempTxns.filter((txn)=>
      txn.status.toLowerCase()===query);
    }
    if(filterByName !== ""){
      console.log("Aaaaaaaaaaaaaa", filterByName);
      const query = filterByName;
      tempTxns = tempTxns.filter((txn) => 
      txn.stock_name === query);
    }
    dispatch(setFilteredTxn(tempTxns));

  };

  // useeffect to load first txnsssss

  useEffect(() => {
    const fetchData = async () => {
      try {
        setLoading(true);
        setOpen(true);
        const txns = await dispatch(getTxn());
        const stocks = await dispatch(getStocks());
        setLoading(false);
        setStocks(stocks.payload);
        setTransactions(txns.payload);
      } catch (error) {
        console.error("Error fetching products", error);
        setLoading(false);
        setError("Error fetching products");
        setOpen(true);
      }
    };
    fetchData();
  }, [dispatch]);



  // use effect for filtered txnnnnnnn 


  useEffect(() => {
    filterTxns();
  }, [transactions, status, searchQuery, filterByName]);

  // grouping of data accoding date 

  const groupedTransactions = filteredTxns.reduce((acc, transaction) => {
    const date = new Date(transaction.timestamp).toLocaleDateString("en-US", {
      year: "numeric",
      month: "short",
      day: "2-digit",
    });
    if (!acc[date]) {
      acc[date] = [];
    }
    acc[date].push(transaction);
    return acc;
  }, {});

  // Step 2: Sort the grouped transactions by date in descending order
  const sortedDates = Object.keys(groupedTransactions).sort(
    (a, b) => new Date(b).getTime() - new Date(a).getTime()
  );


  

  // handlerssss 

  // ----------------1 ----------------
  const handleSearch = (query: string) => {
    dispatch(setSearchQuery(query));
    
  };

  // ---------------- 2 ---------------
  const handleStatus= (query:string) => {
    dispatch(setStatus(query === status ? "" : query));  };


  // ---------------- 3 ---------------
  const handleFilterByName = (query : string) =>{
    dispatch(setFilterByName(query === filterByName ? "" : query));
  }
  





  return (
    <div className={classes.main}>
      <div className={classes.menubar}>
        <div className={classes.menu_head}>
          <p className={classes.filter_txt}>Filters</p>
          <p className={classes.clear_all}>Clear All</p>
        </div>
        <div className={classes.search}>
          <input
            type="text"
            placeholder="search for a stock"
            className={classes.search_input}
            value={searchQuery}
            onChange={(e) => handleSearch(e.target.value)}
            />
        </div>
        <div className={classes.date_div}>
          <input
            type="date"
            id="startdate"
            name="startdate"
            className={classes.date}
          />
          <input
            type="date"
            id="endate"
            name="enddate"
            className={classes.date}
          />
        </div>
        <div className={classes.passfail}>
        <input
            type="checkbox"
            value="Passed"
           onChange={(e)=> handleStatus(e.target.value)}
          />
          <p className={classes.passed}>Passed </p>
          <input
            type="checkbox"
            value="Failed"
            onChange={(e)=> handleStatus(e.target.value)}
            className={classes.failinput}
          />
          <p className={classes.passed}> Failed</p>

        </div>
        <div className={classes.scrollStock}>
          <div className={classes.allstock}>
            {transactions.map((stock) => (
              <div className={classes.onestock}>
                <input
                  type="checkbox"
                  id={stock.stock_name}
                  name={stock.stock_name}
                  value={stock.stock_name}
                  onChange={(e) => handleFilterByName(e.target.value)}
                />
                <label
                  htmlFor={stock.stock_name}
                  className={classes.scroll_stock_name}
                >
                  {stock.stock_name}
                </label>
              </div>
            ))}
          </div>
        </div>
      </div>

      <div className={classes.right}>
        {sortedDates.map((date) => (
          <div className={classes.dateWiseTxn}>
            <div className={classes.txnDateDiv}>
              <p className={classes.txnDate}> {date}</p>
            </div>
            <div className={classes.all_txn_inrange}>
              {groupedTransactions[date].map((txn, index) => (
                <div className={classes.txn_individual}>
                  <p className={classes.stockname}>{txn.stock_name}</p>
                  <p className={classes.stocklogo}> {txn.stock_symbol}</p>
                  <p className={classes.stockprice}> &#x20B9;{txn.transaction_price}</p>
                  <div className={classes.enddiv}>
                    <p className={classes.stocktime}>
                      {" "}
                      {new Date(txn.timestamp).toLocaleTimeString("en-US", {
                        hour: "2-digit",
                        minute: "2-digit",
                      })}
                    </p>
 <div
                      className={`${classes.stockdot} ${
                        txn.status === "Failed" ? classes.redDot : classes.greenDot
                      }`}
                    ></div>

                  </div>
                </div>
              ))}
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}
