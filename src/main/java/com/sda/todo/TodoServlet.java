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

    // instalacja łańcucha:
    private TodoChain todoChain;

    @Override
    public void init() throws ServletException {
        todoDao = new TodoDaoFile(getServletContext(), "/todo/data");
        todoView = new TodoViewHtml();
        todoChain = new TodoChain(todoView, todoDao);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        writer.println(todoChain.invoke(req, resp));

    }
}
