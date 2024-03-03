import React from "react";
import { APIProduct } from "../util/APIProduct";
import "./ProductCard.css";
import { Link } from "react-router-dom";
interface ProductProp {
  detail: APIProduct;
}

/**
 * Component for rendering a product card.
 * @param {Object} props - The props object.
 * @param {APIProduct} props.detail - The details of the product to display.
 * @returns {JSX.Element} JSX element representing the product card.
 */
export default function ProductCard({ detail }: ProductProp) {
  return (
    <div className="product">
      <Link to={`/products/${detail.id}`} className="link">
        <p className="rating">Rating : {detail.rating.rate}</p>
        <div className="image-src">
          <img src={detail.image} alt="product img" className="product-img" />
        </div>
        <div className="product-txt">
          <p className="product-title">{detail.title}</p>
          <p className="product-price">${detail.price}</p>
        </div>
      </Link>
    </div>
  );
}
