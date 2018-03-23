<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: dolodarenko
  Date: 21.03.2018
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=cp1251" language="java" %>
<html>
<head>
    <title>Bunnies list</title>
    <link rel="stylesheet" href="styles/w3.css">
</head>
<body class="w3-light-grey">
    <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
        <h1>Super bunnies :-)</h1>
    </div>

    <div class="w3-container w3-center w3-margin-bottom w3-padding">
        <div class="w3-card-4">
            <div class="w3-container w3-light-blue">
                <h2>Bunnies</h2>
            </div>
            <%
                Map<Integer, String> users = (Map<Integer, String>) request.getAttribute("users");

                if (users != null && !users.isEmpty())
                {
                	out.println("<table class=\"w3-table-all w3-hoverable w3-centered\">");

                    //Заголовок таблицы
                	out.println("<tr>");
                    out.println("<th>ID</th>");
                    out.println("<th>Name</th>");
                    out.println("<th>  </th>");
                    out.println("<th>  </th>");
                    out.println("</tr>");

                    //данные
                    for (Map.Entry<Integer, String> value : users.entrySet())
                    {
                        out.println("<tr class=\"w3-hover-light-blue\">");
                        out.println("<form action=\"/webtest/list\" method=\"post\" class=\"w3-container\">");
                        out.println("<td><input class=\"w3-input w3-border-0\" type=\"text\" maxlength=\"5\" size=\"5\" name=\"id\" value=\"" + value.getKey() + "\" readonly></td>");
                        out.println("<td>" + value.getValue() + "</td>");
                        out.println("<td><input class=\"w3-btn w3-hover-light-grey w3-round-large\" type=\"submit\" value=\"Edit\" name=\"Edit\"/></td>");
                        out.println("<td><input class=\"w3-btn w3-hover-light-grey w3-round-large\" type=\"submit\" value=\"Delete\" name=\"Delete\"/></td>");
                        out.println("</form>");
                        out.println("</tr>");
                    }

                    out.println("</table>");

                    /*
                    out.println("<ul class=\"w3-ul\">");
                    for (String s : names)
                        out.println("<li class=\"w3-hover-sand\">" + s + "</li>");
                    out.println("</ui>");
                    */

                    out.println("<div class=\"w3-container w3-center\">" +
                            "<div class=\"w3-bar w3-padding-large w3-padding-24\">" +
                            "<button class=\"w3-btn w3-hover-green w3-round-large\" onclick=\"location.href='/webtest/add'\">Add a bunny</button>" +
                            "</div></div>");
                }
                else
                {
                    out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n" +
                            "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                            "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                            "   <h5>There are no bunnies yet!</h5>\n" +
                            "</div>");

                    out.println("<div class=\"w3-container w3-center\">" +
                            "<div class=\"w3-bar w3-padding-large w3-padding-24\">" +
                            "<button class=\"w3-btn w3-hover-green w3-round-large\" onclick=\"location.href='/webtest/add'\">Add a bunny</button>" +
                            "</div></div>");
                }
            %>
        </div>
    </div>

    <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
        <button class="w3-btn w3-hover-blue-gray w3-round-large" onclick="location.href='/webtest'">Back to main</button>
    </div>
</body>
</html>
