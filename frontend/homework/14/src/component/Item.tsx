
import ListItem from "./ListItem";
import { useSelector } from "react-redux";
import { RootState } from "../redux/store";

function Item() {
  const filteredTodos = useSelector((state: RootState) => state.todoList.todos);
  return (
    <div className="Item-div">
      <ul id="list">
        {filteredTodos.map((item) => { // Use filteredTodos here
          return <ListItem todoItem={item} />;
        })}
      </ul>
    </div>
  );
}

export default Item;
