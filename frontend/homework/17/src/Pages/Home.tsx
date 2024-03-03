// Home.tsx

import React, { useEffect, useState } from "react";
import ProductCard from "../components/ProductCard";
import "./Home.css";
import { AppDispatch, RootState } from "../redux/store";
import { useDispatch, useSelector } from "react-redux";
import CircularProgress from "@mui/material/CircularProgress";
import Snackbar from "@mui/material/Snackbar";
import { Alert } from "@mui/material";

import { clearError } from "../redux/SnackBarSlice";
import { getProducts } from "../redux/FetchData";
import { setFilteredProducts } from "../redux/ItemSlice";


export default function Home() {
  const [open, setOpen] = useState(false);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  const dispatch: AppDispatch = useDispatch();

  const handleClose = () => {
    setOpen(false);
    dispatch(clearError());
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        setOpen(true);
        setLoading(true);
      
        const newProducts=  await dispatch(getProducts());
        setFilteredProducts(newProducts.payload);
        setLoading(false);
      } catch (error) {
        console.error("Error fetching products", error);
        setError("Error fetching products");
        setOpen(true);
        setLoading(false);
      }
    };
    fetchData();
  }, [dispatch]);

  // const { filteredProducts } = useContext(ProductGlobalContext);
  // console.log(filteredProducts);
  const filteredProducts = useSelector((state:RootState)=> state.productList.filteredProduct)
  

  return (
    <div className="home">
      <div className="title-div">
        <p className="title">KDU MARKETPLACE</p>
      </div>
      <div className="home-div">
        {loading ? (
          <div>
            <CircularProgress size={100} />
          </div>
        ) : error ? (
          <Snackbar
            open={open}
            autoHideDuration={5000}
            onClose={handleClose}
            message="This Snackbar will be dismissed in 5 seconds."
          >
            <Alert onClose={handleClose} severity="error" variant="filled">
              {error}
            </Alert>
          </Snackbar>
        ) : (
          <div className="home-div">
            {filteredProducts.map((product) => {
              return <ProductCard key={product.id} detail={product} />;
            })}
          </div>
        )}

        {!loading && !error && (
          <Snackbar
            open={open}
            autoHideDuration={6000}
            onClose={handleClose}
          >
            <Alert onClose={handleClose} severity="success" variant="filled">
              Data fetched successfully
            </Alert>
          </Snackbar>
        )}
      </div>
    </div>
  );
}
