import React from "react";
import Header from "./Header";
import Item from "./Item";
import "./TodoList.scss";

import Helper from "./Helper";

function TodoList() {
  return (
    <div className="main-section">
      <Header />
      <div className="parent">
        <Helper />
        <Item />
      </div>
    </div>
  );
}

export default TodoList;
