
    const todoInput = document.getElementById('todoInput');
    const todoList = document.getElementById('todoList-text');

  
    function addTodo() {
        if (todoInput.value !== '') {
            const todoItem = document.createElement('li');
            todoItem.innerText = todoInput.value;
            const deleteButton = document.createElement('button');
            deleteButton.innerText = 'Delete';
            deleteButton.classList.add('delete-btn');
            deleteButton.onclick = function () {
                todoItem.remove();
            };
            todoItem.appendChild(deleteButton);
            todoList.appendChild(todoItem);
            todoInput.value = '';
        }
    }

    todoInput.addEventListener('keypress', function (e) {
        if (e.key === 'Enter') {
            addTodo();
        }
    });
