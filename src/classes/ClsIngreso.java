package classes;
import java.sql.SQLException;

import connection.ClsConexion;
public class ClsIngreso {
	

	public boolean agregarDatos(String fecha,String perspectiva,String objetivo,String indicador ,String tendencia,String frecuencia, String fuente,String responsable, int lbase, int lmeta,int valor){
		boolean t=false;
		ClsConexion obj = new ClsConexion();
		String sql="insert INTO tb_datos (fk_fecha,perespectiva,obj_estrat,indicador,tendencia,frecuencia,fuente,responsable,lb,lm,valor) values ('"+fecha+"','"+perspectiva+"','"+objetivo+"','"+indicador+"','"+tendencia+"','"+frecuencia+"','"+fuente+"','"+responsable+"',"+lbase+","+lmeta+","+valor+");";
		System.out.println(sql);
		try {
			obj.Ejecutar(sql);
			t=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			obj.getConexion().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	
}
