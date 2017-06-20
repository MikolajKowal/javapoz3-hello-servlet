package com.sda.todo;

import java.util.List;

public class TodoViewHtml implements TodoView {

    @Override
    public String show(List<TodoModel> todos) {

        // opcja z "for-em"
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<a href=\"/hello-servlets-1.0-SNAPSHOT/todo/all\"><strong>All</strong></a></br>");
        stringBuilder.append("<a href=\"/hello-servlets-1.0-SNAPSHOT/todo/add\"><em>Add</em></a>");
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

    @Override
    public String showAddForm() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<form method=\"get\" action=\"/hello-servlets-1.0-SNAPSHOT/todo/add\"></br>\n");
        stringBuilder.append("<em><strong><font color=\"red\">Name</font></strong></em>: <input type=\"text\" name=\"name\" /></br>\n");
        stringBuilder.append("<em><strong><font color=\"red\">Description</font></strong></em>: <input type=\"text\" name=\"description\" /></br>\n");
        stringBuilder.append("<em><strong><font color=\"red\">Checked</font></strong></em>: <input type=\"checkbox\" name=\"checked\" /></br>\n");
        stringBuilder.append("<em><strong><font color=\"red\">Priority</font></strong></em>: <input type=\"number\" name=\"priority\" /></br>\n");
        stringBuilder.append("<em><strong><font color=\"red\">Date</font></strong></em>: <input type=\"date\" name=\"date\" /></br>\n");
        stringBuilder.append("<input type=\"submit\"/></br>\n");
        stringBuilder.append("</form></br>\n");

        return stringBuilder.toString();
    }
}

