<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css" />
        <title>Home page</title>
    </head>
    <body>
        <div align="center">
            <h1>Home page</h1>
            <table border="1">
                <th>Id</th>
                <th>Name</th>
                <th>Cost</th>


                <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.cost}</td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>