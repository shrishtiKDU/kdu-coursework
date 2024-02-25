import React, { useContext } from "react";
import { Link, useParams } from "react-router-dom";
import { ProductGlobalContext } from "../Context/ProductGlobalContext";
import "./Product.css";

/**
 * Component for displaying details of a single product.
 * @returns {JSX.Element} JSX element representing the product details.
 */
interface ParamType {
  id: string;
  [key: string]: string | undefined;
}

export default function Product() {
  const { filteredProducts } = useContext(ProductGlobalContext);
  const { id } = useParams<ParamType>();

  // Find the product with the given ID
  const product = filteredProducts.find(
    (product) => product.id === parseInt(id!, 10)
  );

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
