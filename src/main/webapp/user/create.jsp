<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/28/2025
  Time: 7:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
  <h1>User Management</h1>
  <h2>
    <a href="user?action=users">List All Users</a>
  </h2>
</center>
<div align="center">
  <form method="post">
    <table border="1" cellpadding="5">
      <caption>
        <h2>Add New User</h2>
      </caption>
      <tr>
        <th>User Name: </th>
        <td>
          <input type="text" name="name" id="name" size="45" />
        </td>
      </tr>
      <tr>
        <td>User Email: </td>
        <td>
          <input type="text" name="email" id="email" size="45" />
        </td>
      </tr>
      <tr>
        <td>Country: </td>
        <td>
          <input type="text" name="country" id="country" size="15" />
        </td>
      </tr>
      <tr>
        <td>Pretimition: </td>
        <td>
          <input type="checkbox" name="add" size="15"/>add |
          <input type="checkbox" name="edit" size="15"/>edit |
          <input type="checkbox" name="delete" size="15"/>delete |
          <input type="checkbox" name="view" size="15"/>view
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="Save"/>
        </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>
