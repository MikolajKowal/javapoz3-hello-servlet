package com.sda.todo;

import java.util.List;

public class TodoViewHtml implements TodoView {

    @Override
    public String show(List<TodoModel> todos) {

        // opcja z "for-em"
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ol>");
        for (TodoModel todo : todos) {
            stringBuilder.append(show(todo));
        }
        stringBuilder.append("</ol>");
        return stringBuilder.toString();

        // opcja z lambdą / wymienna z for-em
//        todos.stream()
//                .map(e -> show(e))     // map = konwersja e, który najpierw jest obiektem klasy TodoModel na Stringa
//                .forEach(e -> stringBuilder.append(e));  // otrzymanego Stringa ładujemy do kolejnego Stringa

    }


    @Override
    public String show(TodoModel model) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<li\n");
        stringBuilder.append("<h3>" + model.getDate().toString() + "</h3>\n");
        stringBuilder.append("<h1>" + model.getName() + "</h1>\n");
        stringBuilder.append("<p>" + model.getDescription() + "</p>\n");
        stringBuilder.append("<p>");
        for (int i = 0; i < model.getPriority(); i++) {
            stringBuilder.append("X");
        }
        stringBuilder.append("</p>\n");
        stringBuilder.append("</li>\n");

        return stringBuilder.toString();
    }
}
