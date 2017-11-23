<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!22123222 ${data1}</h2>

<c:out value="${data1}"/>
<form method="post" action="post">
    <input type="text" name="name" />
    <input type="text" name="value" />

    <button type="submit" value="submit"></button>
</form>
</body>
</html>
