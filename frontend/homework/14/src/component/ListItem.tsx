import React, { useContext, useState } from "react";
import "./ListItem.scss";
import { IData } from "../Util/text";
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../redux/store";
import { setTodos } from "../redux/ListSlice";


function ListItem({todoItem}:{todoItem:IData}) {
  const reduxDispatch = useDispatch();
  const todos = useSelector((state:RootState) => state.todoList.todos);

  const handleRemove = (id: number) => {
    reduxDispatch(setTodos(todos.filter((todo) => todo.id !== id)));
  };

  
  const [isCompleted, setIsCompleted] = useState(false);

  const handleCheckboxChange = () => {
    setIsCompleted(!isCompleted);
  };
  

  return (
    <li  className={`list-item ${isCompleted ? 'completed' : ''}`}>
         <input type="checkbox" checked={isCompleted} onChange={handleCheckboxChange} />
      <p className="text">{todoItem.content} </p>
      <button className="x" onClick={()=> handleRemove(todoItem.id)}>
        x
      </button>
    </li>
  );
}

export default ListItem;
