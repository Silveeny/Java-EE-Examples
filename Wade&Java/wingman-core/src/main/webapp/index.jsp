<%@ page import="java.util.List" %>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>
    <body>
        <h1> Hola amigo</h1>


        <form action="">


            <div class="input-group">
                <div class="form-outline">
                    <input type="search" id="form1" class="form-control" />
                    <label class="form-label" for="form1">Search</label>
                </div>

                <button type="button" class="btn btn-primary">
                    <i class="fas fa-search">search</i>
                </button>
            </div>

            <select class="form-select" multiple aria-label="multiple select example">
                <%
                    List<String> countries = (List<String>) request.getAttribute("desCountries");
                    for (String country : countries) {
                %>
                  <option value="<%= country %>"><%= country %></option>
                <% } %>
            </select>

            <%--            --%>
            <select class="form-select" multiple aria-label="multiple select example">
                <%
                    List<String> ingredients = (List<String>) request.getAttribute("desIngredients");
                    for (String ingredient : ingredients) {
                %>
                  <option value="<%= ingredient %>"><%= ingredient %></option>
                <% } %>
            </select>

            <%--            --%>
            <select class="form-select" multiple aria-label="multiple select example">
                <%
                    List<String> events = (List<String>) request.getAttribute("desEvents");
                    for (String event : events) {
                %>
                  <option value="<%= event %>"><%= event %></option>
                <% } %>
            </select>

            <%--            --%>
            <select class="form-select" multiple aria-label="multiple select example">
                <%
                    List<String> restrictions = (List<String>) request.getAttribute("desRestrictions");
                    for (String restriction : restrictions) {
                %>
                  <option value="<%= restriction %>"><%= restriction %></option>
                <% } %>
            </select>


        </form>

        <button type="button" class="btn btn-primary" aria-label="Left Align" id="all-carbonated-drinks">
            <svg xmlns="http://www.w3.org/2000/svg" width="36" height="36" fill="currentColor" class="bi bi-cup" viewBox="0 0 36 36">
                <path d="M1 2a1 1 0 0 1 1-1h11a1 1 0 0 1 1 1v1h.5A1.5 1.5 0 0 1 16 4.5v7a1.5 1.5 0 0 1-1.5 1.5h-.55a2.5 2.5 0 0 1-2.45 2h-8A2.5 2.5 0 0 1 1 12.5V2zm13 10h.5a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.5-.5H14v8zM13 2H2v10.5A1.5 1.5 0 0 0 3.5 14h8a1.5 1.5 0 0 0 1.5-1.5V2z"/>
            </svg>
            Carbonated Drinks
        </button>

        <button type="button" class="btn btn-primary" aria-label="Left Align" id="all-mocktails">
            <svg xmlns="http://www.w3.org/2000/svg" width="36" height="36" fill="currentColor" class="bi bi-cup" viewBox="0 0 36 36">
                <path d="M1 2a1 1 0 0 1 1-1h11a1 1 0 0 1 1 1v1h.5A1.5 1.5 0 0 1 16 4.5v7a1.5 1.5 0 0 1-1.5 1.5h-.55a2.5 2.5 0 0 1-2.45 2h-8A2.5 2.5 0 0 1 1 12.5V2zm13 10h.5a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.5-.5H14v8zM13 2H2v10.5A1.5 1.5 0 0 0 3.5 14h8a1.5 1.5 0 0 0 1.5-1.5V2z"/>
            </svg>
            Mocktails
        </button>

        <button type="button" class="btn btn-primary" aria-label="Left Align" id="all-coffee">
            <svg xmlns="http://www.w3.org/2000/svg" width="36" height="36" fill="currentColor" class="bi bi-cup" viewBox="0 0 36 36">
                <path d="M1 2a1 1 0 0 1 1-1h11a1 1 0 0 1 1 1v1h.5A1.5 1.5 0 0 1 16 4.5v7a1.5 1.5 0 0 1-1.5 1.5h-.55a2.5 2.5 0 0 1-2.45 2h-8A2.5 2.5 0 0 1 1 12.5V2zm13 10h.5a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.5-.5H14v8zM13 2H2v10.5A1.5 1.5 0 0 0 3.5 14h8a1.5 1.5 0 0 0 1.5-1.5V2z"/>
            </svg>
            Coffee
        </button>

        <button type="button" class="btn btn-primary" aria-label="Left Align" id="all-tea">
            <svg xmlns="http://www.w3.org/2000/svg" width="36" height="36" fill="currentColor" class="bi bi-cup" viewBox="0 0 36 36">
                <path d="M1 2a1 1 0 0 1 1-1h11a1 1 0 0 1 1 1v1h.5A1.5 1.5 0 0 1 16 4.5v7a1.5 1.5 0 0 1-1.5 1.5h-.55a2.5 2.5 0 0 1-2.45 2h-8A2.5 2.5 0 0 1 1 12.5V2zm13 10h.5a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.5-.5H14v8zM13 2H2v10.5A1.5 1.5 0 0 0 3.5 14h8a1.5 1.5 0 0 0 1.5-1.5V2z"/>
            </svg>
            Tea
        </button>

        <div id="results-area">

        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<%--        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>--%>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
       <script type="text/javascript" src="resources/main.js"></script>
    </body>

</html>