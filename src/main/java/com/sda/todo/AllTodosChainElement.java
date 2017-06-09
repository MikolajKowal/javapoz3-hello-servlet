package com.sda.todo;

import java.util.List;

public class AllTodosChainElement implements TodoChainElement {

    private String path;

    private TodoDao todoDao;

    private TodoView todoView;

    public AllTodosChainElement(String path, TodoDao todoDao, TodoView todoView) {
        this.path = path;
        this.todoDao = todoDao;
        this.todoView = todoView;
    }

    @Override
    public boolean isMyResponsibility(String path) {
        return this.path.equals(path);
    }

    @Override
    public String action() {
       List<TodoModel> allTodos = todoDao.getAllTodos();
       return todoView.show(allTodos);
    }
}
