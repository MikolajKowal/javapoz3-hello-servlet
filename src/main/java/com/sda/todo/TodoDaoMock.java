package com.sda.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TodoDaoMock implements TodoDao {

    private List<TodoModel> todos;

    public TodoDaoMock() {
        todos = new ArrayList<>();

        init(); // metoda w której dodajemy dane
    }

    @Override
    public List<TodoModel> getAllTodos() {
        return todos;
    }

    @Override
    public void addTodo(TodoModel todoModel) {
         todos.add(todoModel);
    }

    private void init() {
        todos.add(new TodoModel("Homework", "I've got to do excercises 1 from page 10", false, 5, LocalDate.now()));
        todos.add(new TodoModel("Meeting with John", "We are going to the cinema", false, 3, LocalDate.now().minusDays(2)));
        todos.add(new TodoModel("Dinner with Joan", "We are going to restaurant", false, 2, LocalDate.now().plusDays(4)));


    }
}
