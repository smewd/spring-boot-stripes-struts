<%@ page language="java" %>

Hejsan!
<%--
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Arrays" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>This is a simple jsp page.</title>
</head>
<body>
    src/main/webapp/WEB-INF/struts/dummy.jsp<br/><br/><br/>

    Struts Bean value = <bean:write name="dummyForm" property="value"/> </br>
    System currentMillis = <%= System.currentTimeMillis()  %> </br>

    <%
        response.getWriter().flush();
        Map<String, String[]> map = request.getParameterMap();
        for (String key : map.keySet()) {
            out.println(key + " - " + Arrays.toString(map.get(key)));
        }
    %>
</body>
</html>
--%>
