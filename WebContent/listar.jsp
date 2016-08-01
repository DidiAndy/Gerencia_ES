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
String var;
var=request.getParameter("var");
if(var == null){
	response.sendRedirect("index.jsp");
}
%>
<!-- ESPACIO PARA HEADER INICIA -->
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
  <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">
        <img alt="Brand" src="imagenes/logo_ups.png">
      </a>
    </div>
  </div>
</nav>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index.jsp">Home <span class="glyphicon glyphicon-home"></span></a></li>
      </ul>
      <form action="Sr_listar" method="post" class="navbar-form navbar-right">
        <div class="form-group">
          <input type="text" class="form-control" name="fechas" placeholder="2016-9" required>
        </div>
        <button type="submit" class="btn btn-default">Buscar a&ntilde;o-mes</button>
      </form>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<!-- HEADER TERMINA -->

<div id="wrap">
<div class="container-fluid">
<center><br>
<h3><span class="label label-default">Lista del mes <%=var%> </span></h3>
<br></center>

<div class="col-md-1">
<!-- NO PONER NADA AQUI -->
</div>
<div class="col-md-10">

<%
Cls_listar classes=new Cls_listar();
String x=classes.listar_bsc(var);
out.print(x);
%>
</div>
<div class="col-md-1">
<!-- NO PONER NADA AQUI -->
</div>
<div class="row">
<br>
<!-- /////////////////////////////////////////////////////////////////////////////// -->
    <div class="thumbnail">
       <img src="imagenes/estadistics.gif" alt="barras"  style="width:175px;height:150px;border:0" class="img-thumbnail">
      <div class="caption">
      <center>
       <h3>Estad&iacute;stica</h3>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal1">Ver</button>
        </center>
      </div>
    </div>


<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
       <h2><span class="label label-default" id="gridSystemModalLabel">SEM&Aacute;FORO DE VARIABLES GLOBALES</span></h2>
      </div>
      <div class="modal-body">
      <span class="badge"><%="Presentación del año y mes: "+var%></span>
  <div class="form-group">
           <%
  String x2=classes.estadistic_morethan(var);
  out.print(x2);
  %>
  
  </div>
   <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
        <!-- ----------------------------------------------------------------- -->
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- /////////////////////////////////////////////////////////////////////////// -->

</div>
</div><!--Container -->
</div><!--Wrap-->

<br><br><br>
<div id="footer" style="text-align: center; font-size: 15px; border: 5px solid #A8A59C; color:#6E6E6E;background-color:#F2F2F2">
<br>

Desarrollado por la Carrera: Ingeniería de Sistemas
<br>
Universidad Politécnica Salesiana
<br>
      Sede Quito - Campus Sur
<br>
Sistemas
<br>
Quito - Ecuador 2016
<br>
<br>
</div> 

<!-- Zona JQuery y JS -->
    <script src="Estilos/jquery-2.1.3.min.js"></script>
    <script src="Estilos/bootstrap.min.js"></script>
</body>
</html>