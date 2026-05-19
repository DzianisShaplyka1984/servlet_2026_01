package com.academy.filter;

import com.academy.model.User;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
  private boolean active = true;
  public void init(FilterConfig filterConfig) throws ServletException {
    active = filterConfig.getInitParameter("active").equals("true");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;

    HttpSession session = req.getSession();

    User user = (User) session.getAttribute("user");
    String url = req.getRequestURL().toString();

    if ((user != null) || (url.contains("/login")) || !active) {
      chain.doFilter(request, response);
    } else {

    }
  }
}
