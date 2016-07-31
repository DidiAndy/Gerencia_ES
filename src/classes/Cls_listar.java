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

	public String listar_bsc(String xx){
		String acu="<h3> "+xx+"</h3>";
		System.out.println(acu);
		return acu;
	}
}
