import React, { useState, Children } from "react";
import Header from "./Header";
import Item from "./Item";
import "./TodoList.scss";
import { IData } from "../Util/text";
import { createContext } from "react";
import { Query } from "@testing-library/react";
import Helper from "./Helper";

interface IGlobalContext {
  searchQuery: string;
  todos: IData[];
  setTodos: React.Dispatch<React.SetStateAction<IData[]>>;
  handleSearch: (query: string) => void;
  handleInputChange: (event: React.ChangeEvent<HTMLInputElement>) => void;
  handleSubmit: (event: React.FormEvent<HTMLFormElement>) => void;
  handleRemove: (Query: number) => void;
}
export const GlobalContext = createContext<IGlobalContext>({
  searchQuery: "",
  todos: [],
  setTodos: () => {},
  handleSearch: () => {},
  handleInputChange: (event: React.ChangeEvent<HTMLInputElement>) => {},
  handleSubmit: (event: React.FormEvent<HTMLFormElement>) => {},
  handleRemove: () => {},
});

interface GlobalProviderProps {
  children: React.ReactNode;
}

const GlobalProvider = ({ children }: GlobalProviderProps) => {
  const [searchQuery, setSearchQuery] = useState<string>("");
  const [todos, setTodos] = useState<IData[]>([]);
  const [inputTxt, setInputTxt] = useState("");
  const handleSearch = (query: string) => {
    setSearchQuery(query);
  };

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setInputTxt(event.target.value);
  };
  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    if (inputTxt.trim() !== "") {
      const newTodo: IData = {
        id: todos.length + 1,
        content: inputTxt.trim(),
        completed: false,
      };
      setTodos([...todos, newTodo]);
      setInputTxt("");
    }
  };
  const handleRemove = (id: number) => {
    setTodos(todos.filter((todo) => todo.id !== id));
  };

  return (
    <GlobalContext.Provider
      value={{
        searchQuery,
        todos,
        setTodos,
        handleSearch,
        handleInputChange,
        handleSubmit,
        handleRemove,
      }}
    >
      {children}
    </GlobalContext.Provider>
  );
};

function TodoList() {
  return (
    <GlobalProvider>
      <div className="main-section">
        <Header />
        <div className="parent">
          <Helper />
          <Item />
        </div>
      </div>
    </GlobalProvider>
  );
}

export default TodoList;
