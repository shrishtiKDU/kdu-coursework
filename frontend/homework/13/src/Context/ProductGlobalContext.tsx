import { useEffect, useState, createContext, ChangeEvent } from "react";
import { APIProduct } from "../util/APIProduct";

export interface IProduct {
  products: APIProduct[];
  filter: string;
  filteredProducts: APIProduct[];
  handleFilter: (event: ChangeEvent<HTMLSelectElement>) => void;
  sortOrder: string;
  handleSortChange: (event: ChangeEvent<HTMLSelectElement>) => void;
  searchQuery: string;
  handleSearch: (query: string) => void;
}

export const ProductGlobalContext = createContext<IProduct>({
  products: [],
  filter: "",
  filteredProducts: [],
  handleFilter: () => {},
  sortOrder: "",
  handleSortChange: () => {},
  searchQuery: "",
  handleSearch: () => {},
});

interface GlobalContextProps {
  children: React.ReactNode;
}

export const ProductContextProvider: React.FC<GlobalContextProps> = ({
  children,
}) => {
  const [products, setProducts] = useState<APIProduct[]>([]);
  const [filter, setFilter] = useState<string>("");
  const [filteredProducts, setFilteredProducts] = useState<APIProduct[]>([]);
  const [sortOrder, setSortOrder] = useState("");
  const [searchQuery, setSearchQuery] = useState("");

  const handleFilter = (event: ChangeEvent<HTMLSelectElement>) => {
    setFilter(event.target.value);
  };

  const handleSearch = (query: string) => {
    setSearchQuery(query);
  };

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

    setFilteredProducts(tempProducts);
  };

  useEffect(() => {
    fetch("https://fakestoreapi.com/products")
      .then((response) => response.json())
      .then((data: APIProduct[]) => {
        setProducts(data);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }, []);

  useEffect(() => {
    filterProducts();
  }, [products, filter, searchQuery]);

  const handleSortChange = (e: ChangeEvent<HTMLSelectElement>) => {
    const order = e.target.value;
    setSortOrder(order);
    // Add sorting logic if needed
  };

  return (
    <ProductGlobalContext.Provider
      value={{
        products,
        filter,
        handleFilter,
        filteredProducts,
        sortOrder,
        handleSortChange,
        searchQuery,
        handleSearch,
      }}
    >
      {children}
    </ProductGlobalContext.Provider>
  );
};
