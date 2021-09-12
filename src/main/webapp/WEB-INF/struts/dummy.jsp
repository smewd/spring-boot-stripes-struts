<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Arrays" %>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<html>
<head>
    <title>Dummy jsp page.</title>
</head>
<body>
    src/main/webapp/WEB-INF/struts/dummy.jsp<br/><br/><br/>

    Struts Bean value = <bean:write name="dummyForm" property="value"/> </br>
    System currentMillis = <%= System.currentTimeMillis()  %> </br>

    <%= LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) %><br/>
    <%
        response.getWriter().flush();
        Map<String, String[]> map = request.getParameterMap();
        for (String key : map.keySet()) {
            out.println(key + " - " + Arrays.toString(map.get(key)));
        }
    %>
</body>
</html>
