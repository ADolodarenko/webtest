<%--
  Created by IntelliJ IDEA.
  User: dolodarenko
  Date: 21.03.2018
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=cp1251" language="java" %>
<html>
<head>
    <title>Add new bunny</title>
    <link rel="stylesheet" href="styles/w3.css">
</head>
<body class="w3-light-grey">
    <div class="w3-display-container">
        <img src="views/bunny_again_part.jpg" alt="Bunny">
        <div class="w3-padding w3-display-right w3-text-sand"><h1>Super bunnies :-)</h1></div>
    </div>

    <div class="w3-container w3-padding">
        <%
            if (request.getAttribute("userName") != null)
                out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                        "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                        "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                        "   <h5>Bunny '" + request.getAttribute("userName") + "' added!</h5>\n" +
                        "</div>");
        %>
        <div class="w3-card-4">
            <div class="w3-container w3-center w3-green">
                <h2>Add a bunny</h2>
            </div>

            <form method="post" class="w3-selection w3-light-grey w3-padding">
                <label>Name:
                    <input type="text" name="name" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                </label>
                <label>Password:
                    <input type="password" name="pass" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                </label>
                <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
            </form>
        </div>
    </div>

    <div class="w3-container w3-khaki w3-opacity w3-right-align w3-padding">
        <button class="w3-btn w3-text-brown w3-hover-brown w3-hover-text-sand w3-round-large" onclick="location.href='/webtest/list'">Back to the list</button>
    </div>
</body>
</html>
