import React from "react";
import "./Header.scss";

import { RootState } from "../redux/store";
import { useDispatch, useSelector } from "react-redux";
import { setInputTxt, setSearchQuery, setTodos } from "../redux/ListSlice";


interface HeaderProps {
  onSearch: (query: string) => void;
}
function Header() {
  
  const todos = useSelector((state:RootState) => state.todoList.todos);

  const searchQuery = useSelector((state:RootState) => state.todoList.searchQuery);
  
  const reduxDispatch = useDispatch();

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    reduxDispatch(setSearchQuery(event.target.value));
    console.log(searchQuery);
    const filteredTodos = todos.filter((todo) =>
    todo.content.toLowerCase().includes(searchQuery.toLowerCase())
  );
  reduxDispatch(setTodos(filteredTodos));
  };


  return (
    <div>
      <div className="header">
        <div>
          <p className="header-txt">Item Lister</p>
        </div>
        <div>
          <input
            type="text"
            id="textArea"
            placeholder="search here"
            value={searchQuery}
            onChange={handleInputChange}
          />
        </div>
      </div>
    </div>
  );
}

export default Header;
