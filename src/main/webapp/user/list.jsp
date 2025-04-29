<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/28/2025
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List User</title>
</head>
<style>
  body h3 #search {
    width: 200px;
    height: 30px;
    border-radius: 5px;
    border: 1px solid #ccc;
    padding: 5px;
    margin: 10px;
  }
</style>
<body>
<center>
  <h1>User Management</h1>
  <h2>
    <a href="/user?action=create">Add New User</a>
  </h2>
  <h3>
    <input id="search" type="search" name="search" placeholder="Search by name" value="${search.name}"/>
  </h3>
</center>
<div align="center">
  <table border="1" cellpadding="5">
    <caption>
      <h2>List of Users</h2>
    </caption>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Email</th>
      <th>Country</th>
      <th>Action</th>
    </tr>
    <c:forEach var="user" items="${listUser}">
      <tr>
        <td>
          <c:out value="${user.id}" />
        </td>
        <td>
          <c:out value="${user.name}" />
        </td>
        <td>
          <c:out value="${user.email}" />
        </td>
        <td>
          <c:out value="${user.country}" />
        </td>
        <td>
          <a href="/user?action=update&id=${user.id}">Edit</a>
          <a href="/user?action=delete&id=${user.id}">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
