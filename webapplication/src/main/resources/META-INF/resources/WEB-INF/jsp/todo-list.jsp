<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
<title>Welcome to ${name} Todo Page</title>
</head>
<body>
<div class="container">
    <h1>Welcome ${name}, Your todos are : </h1>
    <br>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <table class="table">
        <thead>
            <tr>
                <th>id</th>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Done?</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.id}</td>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                </tr>


            </c:forEach>

        </tbody>
    </table>
    <a href="todo-add" class="btn btn-success">Add Todo</a>
</div>
</body>
</html>