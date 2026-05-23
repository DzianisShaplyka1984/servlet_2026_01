package com.academy.controller;

import com.academy.model.Book;
import com.academy.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
          "<h1>Book with id: " + book.getId() + " title: " + book.getTitle() + " year: "
              + book.getYear() + "</h1>");
      out.println("<label>(c) 2026</label>");
      out.println("</body>");
      out.println("</html>");
      out.close();
    }
}
