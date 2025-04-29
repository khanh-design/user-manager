<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/29/2025
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>Edit User Management</title>
  </head>
  <body>
  <center>
    <h1>User Management</h1>
    <h2>
      <a href="/user?action=user">List All User</a>
    </h2>
  </center>
  <div align="center">
    <form method="post">
      <table align="center" border="1">
        <caption>
          <h2>
            Edit User
          </h2>
        </caption>
        <c:if test="${user != null}">
          <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
        </c:if>
        <tr>
          <th>User Name: </th>
          <td>
            <input type="text" name="name" id="name" value="${user.name}"/>
          </td>
        </tr>
        <tr>
          <th>User Email: </th>
          <td>
            <input type="text" name="email" id="email" value="${user.email}"/>
          </td>
        </tr>
        <tr>
          <th>Country: </th>
          <td>
            <input type="text" name="country" id="country" value="${user.country}"/>
          </td>
        </tr>
        <tr>
          <td align="center" colspan="5">
            <input type="submit" value="Save"/>
          </td>
        </tr>
      </table>
    </form>
  </div>
  </body>
</html>
