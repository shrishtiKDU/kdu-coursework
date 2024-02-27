import React from "react";
import { setInputTxt, setTodos } from "../redux/ListSlice";
import { useDispatch, useSelector } from "react-redux";
import { IData } from "../Util/text";
import { RootState } from "../redux/store";

export default function Helper() {
  const reduxDispatch = useDispatch();

  const inputTxt = useSelector((state: RootState) => state.todoList.inputTxt);
  const todos = useSelector((state: RootState) => state.todoList.todos);
  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    reduxDispatch(setInputTxt(event.target.value));
  };

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    if (inputTxt.trim() !== "") {
      const newTodo: IData = {
        id: todos.length + 1,
        content: inputTxt.trim(),
        completed: false,
      };
      reduxDispatch(setTodos([...todos, newTodo]));
      reduxDispatch(setInputTxt(""));
    }
  };

  return (
    <div>
      <div className="todo-list">
        <h1 className="todo-heading">Add Items</h1>
        <form id="form" onSubmit={handleSubmit}>
          <div className="search-div">
            <input type="text" id="add-input" onChange={handleInputChange} />
            <button type="submit" id="submit-btn">
              Submit
            </button>
          </div>
        </form>
        <p className="items">Items</p>
      </div>
    </div>
  );
}
