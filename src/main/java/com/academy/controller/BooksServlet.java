package com.academy.controller;

import com.academy.model.Book;
import com.academy.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BooksServlet extends HttpServlet {
  protected void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Cookie[] cookies = request.getCookies();

    String exist = "false";

    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("exist")) {
        exist = cookie.getValue();
      }
    }

    BookService bookService = new BookService();

    List<Book>  books = bookService.getBooks();


    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Books</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>List Books</h1>");
    for (Book book : books) {
      out.println("<br>" + book.getTitle());
    }
    out.println("</body>");
    out.println("</html>");
    out.close();
  }
}
