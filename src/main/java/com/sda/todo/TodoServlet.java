package com.sda.todo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TodoServlet extends HttpServlet {

    private TodoDao todoDao;

    private TodoView todoView;

    @Override
    public void init() throws ServletException {
        todoDao = new TodoDaoMock();
        todoView = new TodoViewHtml();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        List<TodoModel> allTodos = todoDao.getAllTodos();
        String todosView = todoView.show(allTodos);
//        System.out.println(todosView);    - wypisywanie widoku Todosów do logów
        writer.println(todosView);

    }
}
