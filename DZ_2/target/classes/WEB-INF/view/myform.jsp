<!DOCTYPE html>

<html>
    <body>
        <h1>Form Example</h1>
        <form action="advProcessForm" method="GET">
            <input type="text" name="productId" placeholder="Enter product id" />
            <input type="submit" />
        </form>
        <br>
        <a href="${pageContext.request.contextPath}/">to Index Page</a>
    </body>
</html>