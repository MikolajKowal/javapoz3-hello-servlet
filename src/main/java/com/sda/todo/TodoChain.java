package com.sda.todo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TodoChain {

    private List<TodoChainElement> chainElements;

    private TodoView todoView;

    private TodoDao todoDao;

    public TodoChain (TodoView todoView, TodoDao todoDao){
        this.chainElements = new ArrayList<>();
        this.todoView = todoView;
        this.todoDao = todoDao;
        init();
    }

    public String invoke(String path) {
        Iterator<TodoChainElement> iterator = chainElements.iterator();
        TodoChainElement finalElement = null;
        boolean flag = false;
        while (!flag && iterator.hasNext()) {
            TodoChainElement next = iterator.next();
            if (next.isMyResponsibility(path)) {
                finalElement = next;
                flag = true;
            }
        }
        // zwróc rezultat:
        return finalElement != null ? finalElement.action() : "<h1>Cannot find page</h1>";
    }

//    private String invoke(TodoChainElement finalElement) {
//        if(finalElement != null){
//            return finalElement.action();
//        } else {
//            return "<h1>Cannot find page</h1>";
//        }
//    }


    private void init() {
        chainElements.add(new AllTodosChainElement("/all", todoDao, todoView));
        chainElements.add(new AddTodoChainElement("/add", todoDao, todoView));
    }




}
