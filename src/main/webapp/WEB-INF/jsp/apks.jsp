<%@ page import="model.ApkInfo" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport"
          content="width=device-width,
minimum-scale=1, maximum-scale=5">
    <link rel="stylesheet" href="css/jquery.mobile.custom.structure.css">
    <link rel="stylesheet" href="css/jquery.mobile.custom.structure.min.css">
    <link rel="stylesheet" href="css/jquery.mobile.custom.theme.css">
    <link rel="stylesheet" href="css/jquery.mobile.custom.theme.min.css">
    <script src="js/jquery.mobile.custom.js"></script>
    <script src="js/jquery.mobile.custom.min.js"></script>
    <title>Android apk</title>
</head>
<body>


<table data-role="table" id="table-column-toggle"
       data-mode="columntoggle" class="ui-responsive table-stroke">
    <thead>
    <tr>
        <%--<th data-priority="3">Rank</th>--%>
        <th>名字</th>
        <th data-priority="3">时间</th>
    </tr>
    </thead>
    <tbody>


    <c:forEach var="apk" items="${apks}">

        <tr>
            <td><a href="${apk.url}"
                   data-rel="external">${apk.name}</a></td>
            <td>${apk.date}</td>
        </tr>

    </c:forEach>

    <%--<tr>--%>
    <%--<td><a href="http://en.wikipedia.org/wiki/Citizen_Kane"--%>
    <%--data-rel="external">Citizen KaneCitizen KaneCitizen KaneCitizen--%>
    <%--Kane</a></td>--%>
    <%--<td>1941</td>--%>
    <%--</tr>--%>

    </tbody>
</table>
</body>
</html>