import React, { useContext } from 'react'
import { GlobalContext } from './TodoList';

export default function Helper() {
  const todoContext = useContext(GlobalContext);
  return (
    <div>
      
          <div className="todo-list">
            <h1 className="todo-heading">Add Items</h1>
            <form id="form" onSubmit={todoContext.handleSubmit}>
              <div className="search-div">
                <input
                  type="text"
                  id="add-input"
                  onChange={todoContext.handleInputChange}
                />
                <button type="submit" id="submit-btn">
                  Submit
                </button>
              </div>
            </form>
            <p className="items">Items</p>
            </div>
          
    </div>
  )
}
