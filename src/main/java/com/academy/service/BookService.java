package com.academy.service;

import com.academy.model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookService {
  private List<Book> books;

  public BookService() {
    books = new ArrayList<>();

    Book book = new Book(1, "Title1", 1000);
    Book book1 = new Book(2, "Title2", 1001);
    Book book2 = new Book(3, "Title3", 2010);
    Book book3 = new Book(4, "Title4", 2010);
    Book book4 = new Book(5, "Title5", 2020);

    books.add(book);
    books.add(book1);
    books.add(book2);
    books.add(book3);
    books.add(book4);
  }

  public List<Book> getBooks() {
    return books;
  }

  public Book getBook(int id) {
    for (Book book : books) {
      if (book.getId() == id) {
        return book;
      }
    }

    return null;
  }
}
