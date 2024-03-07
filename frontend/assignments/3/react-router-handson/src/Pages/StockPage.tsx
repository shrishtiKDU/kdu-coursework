import { useEffect, useState } from "react";
import { createUseStyles } from "react-jss";
import { useDispatch, useSelector } from "react-redux";
import { useParams } from "react-router-dom";
import { IStock, ITxn } from "../util/Istock";
import { RootState } from "../redux/store";
import { getStocks } from "../redux/FetchStocks";
import Upsvg from "../assets/uparrow.png";
import Downsvg from "../assets/downarrow.png";
import moment from "moment-timezone";
import { Socket, io } from "socket.io-client";


interface ParamType {
  name: string;
  [key: string]: string | undefined;
}

const useStyeles = createUseStyles({
  main: {
    display: "flex",
    paddingLeft: "4rem",
    paddingRight: "4rem",
    paddingTop: "1rem",
  },
  left: {
    width: "75%",
    marginRight: "3rem",
  },
  info_left: {
    display: "flex",
    justifyContent: "space-between",
  },
  company: {
    display: "flex",
    justifyContent: "space-evenly",
    alignItems: "center",
    width: "30%",
    border: "2px solid black",
    marginRight: "1rem",
  },
  price_section: {
    display: "flex",
    width: "100%",
    justifyContent: "space-evenly",
    alignItems: "center",
    border: "2px solid black",
    marginRight: "1rem",
  },
  price: {
    fontSize: "1.4rem",
  },
  input_qty: {
    display: "flex",
    justifyContent: "space-between",
    gap: "2rem",
    width: "100%",
    marginRight: "1rem",
  },
  input_bar: {
    padding: "1.2rem",
    width: "100%",
    border: "2px solid black",
  },
  buy: {
    backgroundColor: "rgb(178,242,187)",
    border: "1.5px solid rgb(128,210,141)",
    color: "rgb(128,210,141)",
    fontWeight: "bold",
    padding: "1rem",
  },
  sell: {
    backgroundColor: "rgb(255,201,201)",
    border: "1.5px solid rgb(235,123,123)",
    color: "rgb(235,123,123)",
    fontWeight: "bold",
    padding: "1rem",
  },
  right: {
    width: "25%",
  },
  history: {
    border: "2px solid black",
    padding: "1rem",
  },
  history_txt: {
    fontSize: "2rem",
    paddingBottom: "1rem",
  },
  activity: {
    border: "1px solid black",
    borderRadius: "1rem",
    paddingTop: "1rem",
    paddingBottom: "1rem",
    paddingRight: "2rem",
    paddingLeft: "1rem",
    display: "flex",
    justifyContent: "space-between",
  },
  stock_qty: {
    fontSize: "1.6rem",
    marginBottom: "0.6rem",
  },
  action: {
    marginTop: "1rem",
    fontSize: "1.3rem",
  },
  action_div: {
    display: "flex",
    alignContent: "center",
  },
  chart: {
    position: "relative",
  },
  grid_item: {
    backgroundColor: "rgba(255, 255, 255, 0.8)",
    textAlign: "center",
    border: "1px dashed gray",
  },
  grid_container: {
    display: "inline-grid",
    gridTemplateColumns: "auto auto auto auto auto auto",
    border: "1px dotted gray",
    paddin: "10px",
    width: "100%",
    height: "500px",
    marginTop: "32px",
  },
  txn: {
    marginTop: "2rem",
    border: "2px solid black",
  },
  txn_div: {
    padding: "2rem",
  },
  txn_user: {
    fontSize: "1.6rem",
  },
  txt_time: {
    marginTop: "0.6rem",
    fontSize: "1.2rem",
  },
  drop_select: {
    height: "3.3rem",
    width: "31rem",
    border: "none",
    backgroundColor: "white",
  },
  drop_symbol: {
    marginRight: "3rem",
    marginLeft: "4rem",
    backgroundColor: "blue",
  },
  drop_main: {
    marginLeft: "2rem",
    display: "flex",
    justifyContent: "space-between",
    border: "none",
  },
  uparrow: {
    height: "2rem",
    fill: "green",
  },
  downarrow: {
    height: "2rem",
    fill: "red",
  },
  numgreen: {
    color: "green",
    fontWeight:"bold",
    fontSize:"1.3rem"
  },
  numred: {
    color: "red",
    fontWeight:"bolder",
    fontSize:"1.3rem"
  },
  percentgreen:{
    color:"green",
    fontWeight:"bolder",
  },
  percentred:{
    color:"red",
    fontWeight:"bolder",
  },
  bars:{
    position:"absolute",
    display:"flex",
    justifyContent:"start",
    
    bottom:"0%",
    flexDirection:"row",
    flexFlow:"wrap-reverse"
  }
});

export default function StockPage() {
  const classes = useStyeles();
  const { name } = useParams<ParamType>();
  const reduxDispatch = useDispatch();
  const [selectedStock, setSelectedStock] = useState<string>(name);
  const [stockInFocus, setStockInFocus] = useState<IStock>("");
  const [prevPrice, setPrevPrice] = useState(0);
  const [percentage, setpercentage] = useState(1);
  const [socket, setSocket] = useState<Socket>(null);

 const[roomData, setRoomData] = useState<ITxn[]>([]);

  const stocksList = useSelector((state: RootState) => state.stockList.stocks);

  useEffect(() => {
    reduxDispatch(getStocks());
  }, [reduxDispatch]);

  const updateCandlesticks = (currentPrice: number, prevPrice: number) => {
    setpercentage(((currentPrice - prevPrice) / prevPrice) * 100);
    console.log("Percentage change:", percentage.toFixed(1));
  };

  useEffect(() => {
    let timer: NodeJS.Timeout;
  
    const updateStockPrice = () => {
      if (stockInFocus) {
        const newPrice = Math.random() * 5000;
        setPrevPrice(stockInFocus.base_price);
        setStockInFocus({ ...stockInFocus, base_price: newPrice });
        console.log(stockInFocus.base_price);
        const newPercentage = ((newPrice - prevPrice) / prevPrice) * 100;
        setpercentage(newPercentage);
        changeBar(newPrice, prevPrice);
      }
    };
  
    if (stockInFocus) {
      timer = setTimeout(updateStockPrice, 1000);
    }
  
    return () => clearTimeout(timer);
  }, [stockInFocus, prevPrice]);
  


  

  useEffect(() => {
    // Find the stock corresponding to the name parameter
    const stock = stocksList.find(
      (stock) => stock.stock_name === selectedStock
    );
    if (stock) {
      setStockInFocus(stock);
      setPrevPrice(stock.base_price);
    }
  }, [stocksList, selectedStock]);

  const handleSelectChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    setSelectedStock(event.target.value);
    const barsContainer = document.getElementById('bars');
    if (barsContainer) {
      barsContainer.innerHTML = ''; // Clear bars when selecting a new stock
    }
  };

  const changeBar = (currentPrice: number, prevPrice: number) => {
    const cost = currentPrice - prevPrice;
    const barsContainer = document.getElementById('bars');
    const newdiv = document.createElement('div');
    newdiv.classList.add('bar');
    const abscost = Math.abs(cost)/100;
    console.log(currentPrice + " "+  prevPrice +  " " + abscost);
    newdiv.style.height = `${abscost}px`;
    newdiv.style.width = "36px";
    newdiv.style.marginRight = "3.2px";
    if (cost < 140) {
        newdiv.style.backgroundColor = "rgb(255, 201, 201)";
        newdiv.style.border = "1px solid #e03131";
    } else {
        newdiv.style.backgroundColor = "#b1f2ba";
        newdiv.style.border = "1px solid #2f9e44";
    }
    barsContainer.appendChild(newdiv);
}


  console.log("Afg", stockInFocus);


  useEffect(() => {
    const socket = io('http://localhost:3005');
    setSocket(socket);
    setRoomData([]);

    socket.on('connect', () => {
        console.log('Connected to server');
    });

    socket.emit('joinRoom', name)

    socket.on('newTxn', (payload: ITxn) => {
        setRoomData((prev => [...prev, payload]));
    });

    return () => {
        socket.disconnect();
    };
}, [name]);


useEffect(() => {
    console.log(roomData)
}, [roomData])

  return (
    <div className={classes.main}>
      <div className={classes.left}>
        <div className={classes.info_left}>
          <div className={classes.company}>
            <select
              value={selectedStock}
              onChange={handleSelectChange}
              className={classes.drop_select}
            >
              {stocksList.map((stock) => (
                <option
                  key={stock.stock_name}
                  value={stock.stock_name}
                  className={classes.drop_main}
                >
                  <p className={classes.drop_symbol}>{stock.stock_symbol}</p>
                  {stock.stock_name}
                </option>
              ))}
            </select>
          </div>
          <div className={classes.price_section}>
            <p className={classes.price}>Price</p>
            <p
              className={`${classes.num} ${
                percentage >= 0 ? classes.numgreen : classes.numred
              }`}
            >
              {stockInFocus.base_price}
            </p>

            {percentage >= 0 ? (
              <img src={Upsvg} alt="Up Arrow" className={classes.uparrow} />
            ) : (
              <img
                src={Downsvg}
                alt="Down Arrow"
                className={classes.downarrow}
              />
            )}

            <p className={`${classes.num} ${
                percentage >= 0 ? classes.percentgreen : classes.percentred
              }`}> {percentage.toFixed(1)} %</p>
          </div>

          <div className={classes.input_qty}>
            <input
              type="text"
              className={classes.input_bar}
              placeholder="add buy"
            />
            <button className={classes.buy}>Buy</button>
            <button className={classes.sell}>Sell</button>
          </div>
        </div>
        <div className={classes.chart}>
          <div className={classes.grid_container}>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
            <div className={classes.grid_item}></div>
          </div>
          <div className={classes.bars} id="bars">{/* bars go here */}</div>
        </div>
      </div>
      <div className={classes.right}>
        <div className={classes.history}>
          <p className={classes.history_txt}>History</p>
          <div className="alltxn">
            <div className={classes.activity}>
              <div className={classes.activity_left}>
                <p className={classes.stock_qty}>100 stocks</p>
                <p className={classes.date}>Fri 23rd april</p>
              </div>
              <div className={classes.action_div}>
                <p className={classes.action}> Buy </p>
              </div>
            </div>
          </div>
        </div>
        <div className={classes.txn}>
          <div className={classes.txn_div}>
            <p className={classes.txn_user}>Sagun bought 500 zomato</p>
            <p className={classes.txt_time}>10:00 AM</p>
            {
                        roomData?.map(info => (
                            <>
                                <p className={classes.txn_user}>{info.name} {info.type ===  "Buy" ? "bought" : "sold"} {info.quantity} {info.stock_name}</p>
                                <p className={classes.txt_time}>{moment(info.timestamp).tz('Asia / Kolkata').format("h:mm A")}</p>
                            </>
                        ))
                    }
          </div>
        </div>
      </div>
    </div>
  );
}
