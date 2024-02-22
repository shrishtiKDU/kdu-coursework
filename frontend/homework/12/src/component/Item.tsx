import React, { useContext } from "react";
import "./Item.scss";
import ListItem from "./ListItem";

import { GlobalContext } from "./TodoList";
function Item() {
  const { todos } = useContext(GlobalContext);
  return (
    <div className="Item-div">
      <ul id="list">
        {todos.map((item) => {
          return <ListItem todoItem={item} />;
        })}
      </ul>
    </div>
  );
}

export default Item;
