import React, { ChangeEvent, useEffect } from "react";
import "./Navbar.css";
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../redux/store";
import { setFilterQuery, setFilteredProducts, setSearchQuery, setSortQuery } from "../redux/ItemSlice";


const Navbar: React.FC = () => {

  const reduxDispatch = useDispatch();
  const products = useSelector((state:RootState) => state.productList.products);
  const searchQuery = useSelector((state:RootState)=>state.productList.searchQuery);
  const filter = useSelector((state:RootState)=>state.productList.filter);
  const sortOrder = useSelector((state:RootState)=>state.productList.sort);
  

  const uniqueBrands = Array.from(
    new Set(products.map((product) => product.category))
  );

  const handleSearch = (query: string) => {
    reduxDispatch(setSearchQuery(query));
  };

  const handleFilter = (event: ChangeEvent<HTMLSelectElement>) => {
    reduxDispatch(setFilterQuery(event.target.value));
  };

  const handleSortChange = (event: ChangeEvent<HTMLSelectElement>) => {
    reduxDispatch(setSortQuery(event.target.value));
  };

  useEffect(() => {
    filterProducts();
  }, [products, filter, searchQuery]);

  const filterProducts = () => {
    let tempProducts = [...products];

    if (filter !== "All" && filter !== "") {
      tempProducts = tempProducts.filter(
        (product) => product.category === filter
      );
    }

    if (searchQuery.trim() !== "") {
      const query = searchQuery.toLowerCase();
      tempProducts = tempProducts.filter((product) =>
        product.title.toLowerCase().includes(query)
      );
    }

    reduxDispatch(setFilteredProducts(tempProducts));
  };

  /**
   * Navbar component renders the navigation bar of the KDU MARKETPLACE.
   * It provides search, filter, and sorting functionalities for the products.
   */
  return (
    <div className="main-nav">
      <div className="search-div">
        <input
          type="text"
          className="input"
          placeholder="search"
          value={searchQuery}
          onChange={(e) => handleSearch(e.target.value)}
        />
        <svg
          className="search"
          xmlns="http://www.w3.org/2000/svg"
          x="0px"
          y="0px"
          width="34"
          height="33"
          viewBox="0 0 30 30"
        >
          <path d="M 13 3 C 7.4889971 3 3 7.4889971 3 13 C 3 18.511003 7.4889971 23 13 23 C 15.396508 23 17.597385 22.148986 19.322266 20.736328 L 25.292969 26.707031 A 1.0001 1.0001 0 1 0 26.707031 25.292969 L 20.736328 19.322266 C 22.148986 17.597385 23 15.396508 23 13 C 23 7.4889971 18.511003 3 13 3 z M 13 5 C 17.430123 5 21 8.5698774 21 13 C 21 17.430123 17.430123 21 13 21 C 8.5698774 21 5 17.430123 5 13 C 5 8.5698774 8.5698774 5 13 5 z"></path>
        </svg>
      </div>

      <div className="filter-search-div">
        <div className="filter-div">
          <p className="txt">Filter : </p>
          <select value={filter} onChange={handleFilter} className="opt">
            <option value="All">All</option>
            {uniqueBrands.map((product) => (
              <option value={product}>{product}</option>
            ))}
          </select>
        </div>
        <div className="product-div">
          <p className="txt">Product List</p>
          <select value={sortOrder} onChange={handleSortChange} className="opt">
            <option value="asc">ASC</option>
            <option value="desc">DESC</option>
          </select>
        </div>
      </div>
    </div>
  );
};

export default Navbar;
