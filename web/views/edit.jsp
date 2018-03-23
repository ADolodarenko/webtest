<%@ page import="app.entities.User" %><%--
  Created by IntelliJ IDEA.
  User: dolodarenko
  Date: 22.03.2018
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=cp1251" language="java" %>
<html>
<head>
    <title>Edit the bunny</title>
    <link rel="stylesheet" href="styles/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Super bunnies :-)</h1>
</div>

<div class="w3-container w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Edit the bunny</h2>
        </div>

        <%
            User user = (User) request.getAttribute("user");

            if (user != null)
            {
            	out.println("<form action=\"/webtest/edit\" method=\"post\" class=\"w3-selection w3-light-grey w3-padding\">");

            	out.println("<input type=\"text\" name=\"id\" value=\"" + user.getId() +
                        "\" class=\"w3-input w3-border-0\" style=\"width: 10%\" readonly\"><br/>");
                out.println("<label>Name:");
                out.println("<input type=\"text\" name=\"name\" value=\"" + user.getName() +
                        "\" class=\"w3-input w3-animate-input w3-border w3-round-large\" style=\"width: 30%\"><br />");
                out.println("</label>");
                out.println("<label>Password:");
                out.println("<input type=\"password\" name=\"pass\" value=\"" + user.getPassword() +
                        "\" class=\"w3-input w3-animate-input w3-border w3-round-large\" style=\"width: 30%\"><br />");
                out.println("</label>");
                out.println("<button type=\"submit\" class=\"w3-btn w3-green w3-round-large w3-margin-bottom\">Submit</button>");

            	out.println("</form>");
            }
        %>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-hover-blue-gray w3-round-large" onclick="location.href='/webtest/list'">Back to the list</button>
</div>
</body>
</html>
