import React, { useContext, useState } from "react";
import "./Header.scss";
import { event } from "cypress/types/jquery";
import { GlobalContext } from "./TodoList";

interface HeaderProps {
  onSearch: (query: string) => void;
}
function Header() {
  const [searchQuery, setSearchQuery] = useState("");
  const todoContext = useContext(GlobalContext);

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const query = event.target.value;
    setSearchQuery(query);
    const filteredTodos = todoContext.todos.filter((todo) =>
      todo.content.toLowerCase().includes(searchQuery.toLowerCase())
    );
    console.log(todoContext.todos, "a");
    todoContext.setTodos(filteredTodos);
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
