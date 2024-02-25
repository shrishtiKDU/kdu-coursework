import React, { useContext } from "react";
import ProductCard from "../components/ProductCard";
import "./Home.css";
import { ProductGlobalContext } from "../Context/ProductGlobalContext";
export default function Home() {
  /**
   * Home component renders the home page of the KDU MARKETPLACE.
   * It displays a list of products fetched from the global context.
   */

  const { filteredProducts } = useContext(ProductGlobalContext);

  return (
    <div className="home">
      <div className="title-div">
        <p className="title">KDU MARKETPLACE</p>
      </div>
      <div className="home-div">
        {filteredProducts.map((product) => {
          return <ProductCard key={product.id} detail={product} />;
        })}
      </div>
    </div>
  );
}
