package com.academy.listener;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

public class SessionListener implements HttpSessionAttributeListener {
  public void attributeAdded(HttpSessionBindingEvent event) {
    System.out.println("Session with id " + event.getSession().getId() + " added attribute " + event.getName() + " with value " + event.getValue());
  }

  public void attributeRemoved(HttpSessionBindingEvent event) {
    System.out.println("Session with id " + event.getSession().getId() + " removed attribute " + event.getName() + " with value " + event.getValue());
  }

  public void attributeReplaced(HttpSessionBindingEvent event) {
    System.out.println("Session with id " + event.getSession().getId() + " replaced attribute " + event.getName() + " with value " + event.getValue());
  }
}
