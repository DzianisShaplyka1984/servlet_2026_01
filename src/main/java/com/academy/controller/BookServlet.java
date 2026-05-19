package com.academy.controller;

import com.academy.model.Book;
import com.academy.model.User;
import com.academy.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //resp.setContentType("text/html;charset=UTF-8");
    resp.setHeader("content-type", "text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

      int id = Integer.parseInt(req.getParameter("id"));
      BookService bookService = new BookService();
      Book book = bookService.getBook(id);

      out.println("<html>");
      out.println("<head>");
      out.println("<title>My app book</title>");
      out.println("</head>");
      out.println("<body>");
      out.println(
          "<h1>Some book with id: " + book.getId() + " title: " + book.getTitle() + " year: "
              + book.getYear() + "</h1>");
      out.println("</body>");
      out.println("</html>");
      out.close();
    }
}
