<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>

<h2>Все пользователи</h2><br />

<table>
    <tr>
        <td>№</td>
        <td>Имя</td>
        <td>Возраст</td>
    </tr>
    <c:forEach var = "user" items = "${requestScope.users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>
                <form method="post" action="delete">
                    <input type="number" hidden name="id" value="${user.id}">
                    <input type="submit" name="delete" value="Удалить">
                </form>
            </td>
            <td>
                <form method="get" action="update">
                    <input type="number" hidden name="id" value="${user.id}">
                    <input type="submit" name="delete" value="Редактировать">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<form method="get" action="user">
    <input type="submit" value="Загрузить список" name="Загрузить список">
</form>

<h2>Добавление нового пользователя</h2><br/>
<form method="post" action="user">
    <label><input type="text" name="name">Имя</label>
    <label><input type="number" name="age">Возраст</label>
    <input type="submit" value="Добавить" name="Добавить">
</form>

</body>
</html>
