package com.sda.todo;

import java.util.List;

public interface TodoDao {

    List<TodoModel> getAllTodos(); // definiujemy listę która zwraca nam wszystkie elementy

    void addTodo(TodoModel todoModel);

}
