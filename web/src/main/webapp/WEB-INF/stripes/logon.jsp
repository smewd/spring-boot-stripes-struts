<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>

<head>
	<link rel="stylesheet" type="text/css" href="${contextPath}/theme/style.css" >
	<title>Login för utvecklare</title>
</head>

<body class="fargad-bakgrund">
	<center>
		<s:errors/>

		<br/><br/><br/><br/>
		<img src="${contextPath}/image/hassan_liten_100.gif" alt="HASSAN" border="0"/>
		<h1>Inloggning</h1>
		<br/>
		${actionBean.computerName}
		<h3>(Utveckling/Test/Utbildning)</h3>


		<s:form beanclass="se.skandia.ll.fsk.client.web.main.LogonActionBean" focus="skandiaId">
			<!-- For some reason >1 textfield is needed for IE to do submit with correct event on enter -->
			<div style="visibility: hidden"> <s:text name=""/> </div>

			Användare
			<s:text name="skandiaId" maxlength="13" size="13"/>
			<s:submit name="listRoles" value="Logga in" class="roundedButton"/>
		</s:form>
	</center>
</body>
</html>
