<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Обновить данные</title>
</head>
<body>

    <di>Имя: <c:out value="${requestScope.user.name}"/> </di>
    <di>Возраст: <c:out value="${requestScope.user.age}"/> </di>
    <br/>
<form method="post" action="update">
    <label>Новое имя: <input type="text" name="name"/></label><br/>
    <label>Новый возраст: <input type="number" name="age"/></label><br/>
    <input type="number" hidden name="id" value="${requestScope.user.id}">
    <input type="submit" value="Ok" name="Ok"><br/>
</form>
</body>
</html>
