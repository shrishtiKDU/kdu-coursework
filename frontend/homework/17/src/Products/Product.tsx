import React from "react";
import { Link, useParams } from "react-router-dom";
import { useSelector } from "react-redux"; // Import useSelector hook
import "./Product.css";
import { RootState } from "../redux/store";

interface ParamType {
  id: string;
  [key: string]: string | undefined;
}

export default function Product() {
  const { id } = useParams<ParamType>();

  // Get filtered products from Redux state
  const filteredProducts = useSelector((state: RootState) => state.productList.filteredProduct);

  // Find the product with the given ID
  const product = filteredProducts.find((product) => product.id === parseInt(id!, 10));

  // If product is not found, you can display a message or handle it as per your requirement
  if (!product) {
    return <div>Product not found</div>;
  }

  return (
    <div className="main">
      <p className="prod-title">{product.title}</p>
      <div className="content-div">
        <img src={product.image} alt="image" className="img" />
        <div className="content">
          <p className="model">Model : {product.title}</p>
          <p className="category">Category: {product.category}</p>
          <p className="price">Price :{product.price}</p>
          <p className="desc-title">Product description</p>
          <p className="description">{product.description}</p>
          <Link to="/" className="btn">
            {" "}
            <p className="back-btn">Back to Products</p>
          </Link>
        </div>
      </div>
    </div>
  );
}
