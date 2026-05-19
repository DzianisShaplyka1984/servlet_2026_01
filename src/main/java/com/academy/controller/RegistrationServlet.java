package com.academy.controller;

import com.academy.model.Role;
import com.academy.model.User;
import com.academy.service.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Collections;

public class RegistrationServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>My app book</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Login page</h1>");
    out.println("<form method=\"post\" action=\"/registration\">");
    out.println("<label>Login: </label> <input name=\"login\"/><br>");
    out.println("<label>Password: </label> <input name=\"password\"/><br>");
    out.println("<input type=\"submit\" value=\"Register\"/>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    BufferedReader reader = request.getReader();
    String line;

    StringBuilder sb = new StringBuilder();
    while ((line = reader.readLine()) != null) {
      sb.append(line);
    }

    String[] credentials = sb.toString().split("&");
    String login = credentials[0].split("=")[1];
    String password = credentials[1].split("=")[1];

    User user = new User(login, password, Collections.singletonList(new Role("CUSTOMER")));

    AuthService.getInstance().save(user);

    Writer  writer = response.getWriter();
    writer.write("<html>");
    writer.write("<head>");
    writer.write("<title>My app book</title>");
    writer.write("</head>");
    writer.write("<body>");
    writer.write("Registration successful");
    writer.write("</body>");
    writer.write("</html>");
    writer.close();
  }
}
