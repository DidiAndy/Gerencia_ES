package classes;

import java.sql.ResultSet;

import connection.ClsConexion;
public class Cls_listar {
	public int validar_PK(String fecha, String objetivo){
		int retorna=1;
		//retornar 1 en caso de que las PK NO se repitan en la base
		String sql="select count(tb_datos.fk_fecha) from tb_datos where tb_datos.fk_fecha='"+fecha+"' and tb_datos.obj_estrat='"+objetivo+"';";
		ClsConexion con = new ClsConexion();
		ResultSet rs=null;
		try{
			rs=con.Consulta(sql);
			while(rs.next()){
				retorna=rs.getInt(1);
			}
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
		return retorna;
	}
	public String listar_bsc(String fecha){
		String sql="select tb_datos.fk_fecha,tb_datos.perespectiva,tb_datos.obj_estrat,tb_datos.indicador,tb_datos.tendencia,tb_datos.frecuencia,tb_datos.fuente,tb_datos.responsable,tb_datos.lb,tb_datos.lm,tb_datos.valor from tb_datos,tb_fechas where tb_fechas.fecha=tb_datos.fk_fecha and tb_datos.fk_fecha='"+fecha+"' order by tb_datos.perespectiva;";
		ClsConexion con = new ClsConexion();
		ResultSet rs=null;
		String green="progress-bar progress-bar-success progress-bar-striped",yellow="progress-bar progress-bar-warning progress-bar-striped",red="progress-bar progress-bar-danger progress-bar-striped";
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
	
	public String estadistic_morethan(String fecha){
		String sql="select tb_datos.fk_fecha,tb_datos.perespectiva,tb_datos.obj_estrat,tb_datos.indicador,tb_datos.tendencia,tb_datos.frecuencia,tb_datos.fuente,tb_datos.responsable,tb_datos.lb,tb_datos.lm,tb_datos.valor from tb_datos,tb_fechas where tb_fechas.fecha=tb_datos.fk_fecha and tb_datos.fk_fecha='"+fecha+"' order by tb_datos.perespectiva;";
		ClsConexion con = new ClsConexion();
		ResultSet rs=null;
		String green="progress-bar progress-bar-success progress-bar-striped",yellow="progress-bar progress-bar-warning progress-bar-striped",red="progress-bar progress-bar-danger progress-bar-striped";
		String acumulada="<table class=\"table table-striped\"> ";
		acumulada+=" <thead><tr><th>Progreso general</th><th>Luz</th></tr></thead><tbody> ";
		int sumagreen=0,totalgreen=0,sumayellow=0,totalyellow=0,sumared=0,totalred=0;
		double respgreenup=0,respgreendown=0,respyellowup=0,respyellowdown=0,respredup=0,respreddown=0;
		try{
			rs=con.Consulta(sql);
			while(rs.next()){
				acumulada+="<tr><td>"+rs.getInt(9)+"</td><td>"+rs.getInt(10)+"</td><td>"+rs.getInt(11)+"</td> ";
				if(rs.getString(5).equals(">")){
					//tiende a subir
					int lb=rs.getInt(9),lm=rs.getInt(10),value=rs.getInt(11);
					if(value>lm){
						sumagreen+=lm;
						totalgreen+=value;
					}
					if(value>=lb && value<=lm){
						sumayellow=+lb+lm;
						totalyellow=+value;
					}
					if(value<lb){
						sumared+=lm;
						totalred+=value;
					}
				}else{
					//tiende a bajar
					int lb=rs.getInt(9),lm=rs.getInt(10),value=rs.getInt(11);
					if(value<lm){
						//green <
						acumulada+="<td><div class=\"progress\"><div class=\""+green+"\""
								+ " role=\"progressbar\" aria-valuenow=\"100\"aria-valuemin=\"0\" aria-valuemax=\"100\""
								+ " style=\"width:100%\"></div></div>"
								+ "</td></tr> ";	
					}
					if(value>=lm && value<=lb){
						//yellow <
						acumulada+="<td><div class=\"progress\"><div class=\""+yellow+"\""
								+ " role=\"progressbar\" aria-valuenow=\"100\"aria-valuemin=\"0\" aria-valuemax=\"100\""
								+ " style=\"width:100%\"></div></div>"
								+ "</td></tr> ";	
					}
					if(value>lb){
						//red <
						acumulada+="<td><div class=\"progress\"><div class=\""+red+"\""
								+ " role=\"progressbar\" aria-valuenow=\"100\"aria-valuemin=\"0\" aria-valuemax=\"100\""
								+ " style=\"width:100%\"></div></div>"
								+ "</td></tr> ";	
					}
					
				}//fin total de if else
				//poner aqui abajo todos los semaforos globales para > y <
				respgreenup=(totalgreen/sumagreen)*100;
				//green >
				acumulada+="<td><div class=\"progress\"><div class=\""+green+"\""
						+ " role=\"progressbar\" aria-valuenow=\""+respgreenup+"\"aria-valuemin=\"0\" aria-valuemax=\"100\""
						+ " style=\"width:100%\"></div></div>"
						+ "</td></tr> ";
				respyellowup=(totalyellow/(sumayellow/2))*100;
				//yellow >
				acumulada+="<td><div class=\"progress\"><div class=\""+yellow+"\""
						+ " role=\"progressbar\" aria-valuenow=\""+respyellowup+"\"aria-valuemin=\"0\" aria-valuemax=\"100\""
						+ " style=\"width:100%\"></div></div>"
						+ "</td></tr> ";	
				respredup=(totalred/sumared)*100;
				//red >
				acumulada+="<td><div class=\"progress\"><div class=\""+red+"\""
						+ " role=\"progressbar\" aria-valuenow=\""+respredup+"\"aria-valuemin=\"0\" aria-valuemax=\"100\""
						+ " style=\"width:100%\"></div></div>"
						+ "</td></tr> ";	
				
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
