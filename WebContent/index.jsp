<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="classes.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">
<title>index</title>
</head>
<body>
<%
String error, msg;
error=request.getParameter("error");
msg=request.getParameter("msg");
if (error != null && error.equals("true")){
%>
	<div class="alert alert-success" role="alert">
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  <strong>ESTADO</strong>.<%=" Proceso realizado con exito"%>
	</div>
<%
}if(error != null && error.equals("false")){
	%>
	<div class="alert alert-danger" role="alert">
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  <strong>ESTADO</strong>.<%=" Se ha producido un error, por favor actualize y vuelva a intentar"%>
	</div>
<%
}
%>
<!--FIN MENSAJE DEL SERVLET -->
<div id="wrap">
<div class="container-fluid">
<center><br>
<h3><span class="label label-default">BSC</span></h3>
<br></center>
<div class="col-md-2">
<!-- no PONER NADA AQUI -->
</div>
<div class="col-md-4">
<br>
<h3><span class="label label-default">LISTAR MATRIZ BSC</span></h3>
<br>
<form action="Sr_listar" method="post">
<select class=form-control name=fechas>
<option>2016-1</option>
<option>2016-2</option>
<option>2016-3</option>
<option>2016-4</option>
<option>2016-5</option>
<option>2016-6</option>
<option>2016-7</option>
<option>2016-8</option>
<option>2016-9</option>
<option>2016-10</option>
<option>2016-11</option>
<option>2016-12</option>
</select>
<center>
<input type="submit" name="btnListar" class="btn btn-success" role="button" value="Listar">
</center>
</form>
</div>


<div class="col-md-4">
<br>
<h3><span class="label label-default">INGRESAR MATRIZ BSC</span></h3>
<br>
<form action="Sr_ingresar" method="post">
<select class=form-control name=fechas2>
<option>2016-1</option>
<option>2016-2</option>
<option>2016-3</option>
<option>2016-4</option>
<option>2016-5</option>
<option>2016-6</option>
<option>2016-7</option>
<option>2016-8</option>
<option>2016-9</option>
<option>2016-10</option>
<option>2016-11</option>
<option>2016-12</option>
</select>
<center>
<input type="submit" name="btnIngresar" class="btn btn-success" role="button" value="Ingresar">
</center>
</form>
</div>
<div class="col-md-2">
<!-- no PONER NADA AQUI -->
</div>
</div><!--Container -->
</div><!--Wrap-->



<!-- Zona JQuery y JS -->
    <script src="Estilos/jquery-2.1.3.min.js"></script>
    <script src="Estilos/bootstrap.min.js"></script>
</body>
</html>