package com.academy.controller;

import com.academy.model.Book;
import com.academy.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class BooksServlet extends HttpServlet {
  protected void  doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

      BookService bookService = new BookService();

      List<Book>  books = bookService.getBooks();

      req.setAttribute("books", books);

      HttpSession session = req.getSession();
      session.setAttribute("message", "Hello World");

      req.getRequestDispatcher("/WEB-INF/page/books.jsp").forward(req, response);
    }
}
