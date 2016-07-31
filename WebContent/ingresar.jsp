<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Estilos/bootstrap.min.css">
<title>Ingresar Datos</title>
</head>
<body background="imagenes/fondo.jpg">

<%
String error,msg,fechaselected;
error = request.getParameter("error");
msg= request.getParameter("msg");
fechaselected=request.getParameter("fechas2");
if (error != null && error.equals("true")){
%>
	<div class="alert alert-success" role="alert">
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  <strong>ESTADO</strong>.<%=" "+msg%>
	</div>
<%
}if(error != null && error.equals("false")){
	%>
	<div class="alert alert-danger" role="alert">
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  <strong>ESTADO</strong>.<%=" "+msg%>
	</div>
<%
}
%>
<!--FIN MENSAJE DEL SERVLET -->
<div class="row">

	<center><br>
<h3><span class="label label-default">REGISTRO USUARIO</span></h3>
<br></center> 


<form action="Sr_ingresar" method="post">
<center>
<h3><span class="badge">*Todos los campos son obligatorios.</span></h3>
</center>

<table class="table table-hover">

<tr>

<td> <span class="input-group-addon" id="basic-addon1">Fecha:</span>
  <input type="text" class="form-control" name="txtFecha" value=<%=fechaselected%> aria-describedby="basic-addon1"  READONLY></td>
<td> <span class="input-group-addon" id="basic-addon1">Perspectiva:* </span>
<select class="form-control" name="txtPerspectiva">
  <option>Financiera</option>
  <option>Cliente</option>
  <option>Procesos</option>
  <option>K.I.</option>
</select>
</td>
<td> <span class="input-group-addon" id="basic-addon1">Objetivo Estratégico:* </span>
  <input type="text" class="form-control" name="txtObjetivo" aria-describedby="basic-addon1" style="text-transform:uppercase" required></td>
<td> <span class="input-group-addon" id="basic-addon1"> Indicador* </span>
  <input type="text" class="form-control" name="txtIndicador" aria-describedby="basic-addon1"  style="text-transform:uppercase" required></td>
</tr>
<tr>
<div class="col-md-4">
</div>
<td> <span class="input-group-addon" id="basic-addon1">Tendencia* </span>
<select class="form-control" name="txtTendencia">
  <option>A subir</option>
  <option>A bajar</option>

</select>
  </td>
  <td> <span class="input-group-addon" id="basic-addon1">Frecuencia* </span>
<select class="form-control" name="txtFrecuencia">
  <option>Anual</option>
  <option>Mensual</option>
  <option>Semestral</option>
</select>
  </td>
<td> <span class="input-group-addon" id="basic-addon1">Fuente:*</span>
  <input type="text" class="form-control" name="txtFuente"  aria-describedby="basic-addon1" style="text-transform:uppercase" required></td>
<td> <span class="input-group-addon" id="basic-addon1">Responsable:* </span>
  <input type="text" class="form-control" name="txtResponsable"  aria-describedby="basic-addon1" style="text-transform:uppercase" required></td>
</tr>
<tr>
<div class="col-md-4">
</div>
<td> <span class="input-group-addon" id="basic-addon1"> Línea Base:* </span>
  <input type="number" class="form-control" name="txtLBase" pattern="[0-9]" aria-describedby="basic-addon1" title="ingrese solo números" required></td>
<td> <span class="input-group-addon" id="basic-addon1"> Línea Meta:* </span>
  <input type="number" class="form-control" name="txtLBase" pattern="[0-9]"  aria-describedby="basic-addon1" title="ingrese solo números" required></td>
<td> <span class="input-group-addon" id="basic-addon1"> Valor/Resultado:* </span>
  <input type="number" class="form-control" name="txtValor" pattern="[0-9]"  aria-describedby="basic-addon1" title="ingrese solo números" required></td>

</tr>
</table>

<hr>
<br><br>
<center>
<input type="submit" name="btnRegistar" class="btn btn-success" role="button"  style="font-size:15px;"" value="Aceptar">
<a class="btn btn-danger" href="index.jsp" style="font-size:15px; color:red;"  role="button">Cancelar</a>
</center>
</form>
</div>



<!-- Zona JQuery y JS -->
    <script src="Estilos/jquery-2.1.3.min.js"></script>
    <script src="Estilos/bootstrap.min.js"></script>
</body>
</html>