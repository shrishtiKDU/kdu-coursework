import React, { useContext } from "react";
import "./ListItem.scss";
import { GlobalContext } from "./TodoList";
import { IData } from "../Util/text";


function ListItem({todoItem}:{todoItem:IData}) {
  const todoContext = useContext(GlobalContext);

  
  const handleRemove = (id:number) => {
    const newTodo = todoContext.todos.filter((todo)=> todo.id!==id)
    todoContext.setTodos(newTodo);
  };

  return (
    <li className="list-item">
      <p className="text">{todoItem.content} </p>
      <button className="x" onClick={()=> handleRemove(todoItem.id)}>
        x
      </button>
    </li>
  );
}

export default ListItem;
