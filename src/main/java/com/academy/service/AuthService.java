package com.academy.service;

import com.academy.model.Role;
import com.academy.model.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AuthService {
  private List<User> users;
  private static AuthService instance =  new AuthService();

  public AuthService() {
    users = new ArrayList<User>();

    Role admin = new Role("ADMIN");
    Role customer = new Role("CUSTOMER");
    User user1 = new User("Ivan", "qwert", Collections.singletonList(admin));
    User user2 = new User("John", "qwert", Collections.singletonList(customer));

    users.add(user1);
    users.add(user2);
  }

  public static AuthService getInstance() {
    return instance;
  }

  public boolean authenticate(String login, String password) {
    if (login.isEmpty() || password.isEmpty()) {
      return false;
    }

    for (User user : users) {
      if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
        return true;
      }
    }

    return false;
  }

  public void save(User user) {
    users.add(user);
  }
}
