<%@ page import="com.academy.service.BookService" %>
<%@ page import="com.academy.model.Book" %>
<%@ page import="com.academy.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<html>
  <head>
    <title>Books</title>
  </head>
  <body>
    <h1>List Books</h1>

    <c:set var="greeting" value="${sessionScope.message}"></c:set>
    ${sessionScope.user.login}


    <c:if test='${fn:contains("Hello world", "Hello")}'>
      contains
    </c:if>

    <br>

    <c:forEach items="${books}" var="book">
      ${book.title}


      <c:choose>
        <c:when test="${book.year > 0 && book.year < 2000}">
          антиквариант
        </c:when>
        <c:otherwise>
          эта самая новая книга
        </c:otherwise>
      </c:choose>
    <br>
    </c:forEach>

    <label>(c) <%@ include file="time.jsp"%></label>
  </body>
</html>