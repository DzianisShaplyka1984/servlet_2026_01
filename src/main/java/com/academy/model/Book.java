package com.academy.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
  private int id;
  private String title;
  private int year;
}
