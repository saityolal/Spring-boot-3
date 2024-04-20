    <%@ include file="common/navigation.jspf" %>
    <%@ include file="common/header.jspf" %>
    <%@ include file="common/footer.jspf" %>
   
            <div class="container">
                <h1>Welcome ${name}, You can add todo below here: </h1>
                <br>

                <form:form method="post" modelAttribute="todo"> <!--  model attribute must match with your object -->


                    ID:
                    <form:input type="hidden" path="id" /> <!-- path name must match with your object attributes -->>
                    <br>
                    <br>    
                    Description:
                    <form:input type="text" path="description" required="required" />
                    <br>
                    <br>
                    targetDate:
                    <form:input type="text" path="targetDate" />
                    <br>
                    <br>
                    Is Done:
                    <form:input type="text" path="done" />
                    <br>
                    <br>
                    <form:errors path="description" class="text-warning" />
                    <form:errors path="targetDate" class="text-warning" />
                    <form:errors path="Done" class="text-warning" />
                    <input type="submit" class="btn btn-success" />

                </form:form>
            </div>
        <script type="text/javascript">
            $('.targetDate').datepicker({
                format: 'yyyy-mm-dd'
            });
        </script>