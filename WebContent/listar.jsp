<%@page import="classes.Cls_listar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="classes.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">
<title>Lista de BSC</title>
</head>
<body>

<%
//<!--INICIO MENSAJE DEL SERVLET -->
String var;
var=request.getParameter("var");
%>

<div id="wrap">
<div class="container-fluid">
<center><br>
<h3><span class="label label-default">Lista del mes</span></h3>
<br></center>
<%
Cls_listar classes=new Cls_listar();
String x=classes.listar_bsc(var);
out.print(x);
%>



</div><!--Container -->
</div><!--Wrap-->



<!-- Zona JQuery y JS -->
    <script src="Estilos/jquery-2.1.3.min.js"></script>
    <script src="Estilos/bootstrap.min.js"></script>
</body>
</html>