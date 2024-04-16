<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<head>
<title>Welcome to ${name} Todo Page</title>
</head>
<body>
<div class="container">
    <h1>Welcome ${name}, You can add todo below here: </h1>
    <br>

  <form:form method="post" modelAttribute="todo">


            ID:          <form:input type="hidden" path="id"/>
                         <br>
  			Description: <form:input type="text" path="description" required="required"/>
                         <br>
            targetDate:  <form:input type="hidden" path="targetDate"/>
                         <br>
            Is Done:     <form:input type="hidden" path="done" />
                         <br>
            <form:errors path="description" class="text-warning"/> <br>
  		<input type="submit" class="btn btn-success"/>

  	</form:form>
</div>
</body>
</html>