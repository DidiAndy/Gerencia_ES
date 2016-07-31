package classes;

import java.sql.ResultSet;

import connection.ClsConexion;

public class Cls_listar {
	public String listar_fechas(){
		String sql="select fecha from tb_fechas;";
		ClsConexion con = new ClsConexion();
		ResultSet rs=null;
		String fecha="<select class=form-control name=fechas>"
				+ "<option> </option>";
				try{
				rs=con.Consulta(sql);
				while(rs.next()){
					fecha+="<option>"+rs.getString(1)+"</option>";
				}
				
				}catch(Exception e){
					e.getMessage();
				}
				fecha+="</select>";
				try {
					rs.close();
					con.getConexion().close();
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println(fecha);
				return fecha;
	}	

	public String listar_bsc(String fecha){
		String sql="select tb_datos.fk_fecha,tb_datos.perespectiva,tb_datos.obj_estrat,tb_datos.indicador,tb_datos.tendencia,tb_datos.frecuencia,tb_datos.fuente,tb_datos.responsable,tb_datos.lb,tb_datos.lm,tb_datos.valor from tb_datos,tb_fechas where tb_fechas.fecha=tb_datos.fk_fecha and tb_datos.fk_fecha='"+fecha+"' order by tb_datos.perespectiva;";
		ClsConexion con = new ClsConexion();
		ResultSet rs=null;
		String green="progress-bar progress-bar-success",yellow="progress-bar progress-bar-warning",red="progress-bar progress-bar-danger";
		String acumulada="<table class=\"table table-striped\"> ";
		acumulada+=" <thead><tr><th>Fecha</th><th>Perspectiva</th><th>Obj.estrat&eacute;gico</th><th>Indicador</th><th>Tend.</th><th>Frec.</th><th>Fuente</th><th>Resp.</th><th>L.B.</th><th>L.M.</th><th>Val</th><th>Luz</th></tr></thead><tbody> ";
		try{
			rs=con.Consulta(sql);
			while(rs.next()){
				acumulada+="<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getInt(9)+"</td><td>"+rs.getInt(10)+"</td><td>"+rs.getInt(11)+"</td> ";
				if(rs.getString(5).equals(">")){
					//tiende a subir
					int lb=rs.getInt(9),lm=rs.getInt(10),value=rs.getInt(11);
					if(value>lm){
						//green
						acumulada+="<td><div class=\"progress\"><div class=\""+green+"\""
								+ " role=\"progressbar\" aria-valuenow=\"100\"aria-valuemin=\"0\" aria-valuemax=\"100\""
								+ " style=\"width:100%\"></div></div>"
								+ "</td></tr> ";	
					}
					if(value>=lb && value<=lm){
						//yellow
						acumulada+="<td><div class=\"progress\"><div class=\""+yellow+"\""
								+ " role=\"progressbar\" aria-valuenow=\"100\"aria-valuemin=\"0\" aria-valuemax=\"100\""
								+ " style=\"width:100%\"></div></div>"
								+ "</td></tr> ";	
					}
					if(value<lb){
						//red
						acumulada+="<td><div class=\"progress\"><div class=\""+red+"\""
								+ " role=\"progressbar\" aria-valuenow=\"100\"aria-valuemin=\"0\" aria-valuemax=\"100\""
								+ " style=\"width:100%\"></div></div>"
								+ "</td></tr> ";	
					}
				}else{
					//tiende a bajar
					int lb=rs.getInt(9),lm=rs.getInt(10),value=rs.getInt(11);
					if(value<lm){
						//green
						acumulada+="<td><div class=\"progress\"><div class=\""+green+"\""
								+ " role=\"progressbar\" aria-valuenow=\"100\"aria-valuemin=\"0\" aria-valuemax=\"100\""
								+ " style=\"width:100%\"></div></div>"
								+ "</td></tr> ";	
					}
					if(value>=lm && value<=lb){
						//yellow
						acumulada+="<td><div class=\"progress\"><div class=\""+yellow+"\""
								+ " role=\"progressbar\" aria-valuenow=\"100\"aria-valuemin=\"0\" aria-valuemax=\"100\""
								+ " style=\"width:100%\"></div></div>"
								+ "</td></tr> ";	
					}
					if(value>lb){
						//red
						acumulada+="<td><div class=\"progress\"><div class=\""+red+"\""
								+ " role=\"progressbar\" aria-valuenow=\"100\"aria-valuemin=\"0\" aria-valuemax=\"100\""
								+ " style=\"width:100%\"></div></div>"
								+ "</td></tr> ";	
					}
					
				}
				
			}
			acumulada+="</tbody></table>";
			}catch(Exception e){
			e.getMessage();	
			}
		//nuevo codigo cerrar sesion
				try {
					rs.close();
					con.getConexion().close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			return acumulada;
	}
}
