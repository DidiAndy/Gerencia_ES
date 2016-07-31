package connection;
import java.sql.*;
/*
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
*/


import java.sql.DriverManager;
import java.sql.ResultSet;
public class ClsConexion {
	
	private Connection con;
	private Statement St;
	private String driver;
	private String user;
	private String pwd;
	private String cadena;
	
	
	public String getDriver()
	{
		return this.driver;
	}
	String getUser()
	{
		return this.user;
	}
	String getPwd()
	{
		return this.pwd;
	}
	String getCadena()
	{
		return this.cadena;
	}
	public Connection getConexion()
	{ 
		return this.con; 
	}
	
	public ClsConexion() {
		
		this.driver ="org.postgresql.Driver";
		this.user="postgres";
		this.pwd="jairo";
		this.cadena="jdbc:postgresql://localhost:5432/bd_gerenciaestrategica";
		//this.cadena="jdbc:postgresql://localhost:5432/bd_imagen";
		
		this.con=this.crearConexion();
		
	}
	
	Connection crearConexion(){
		try {
			Class.forName("org.postgresql.Driver");
			}
			catch (ClassNotFoundException e) {
			
			}
		
		try{
			Class.forName(getDriver()).newInstance();
			Connection con=DriverManager.getConnection(getCadena(),getUser(),getPwd());
			return con;
		}
	catch(Exception ee)
	{
		System.out.println("Error: " + ee.getMessage());
		return null;
	}
	}
	

	
	// C O N E X I O N . . . . ... M Y S Q L
	/*
public ClsConexion() {
		
		this.driver ="org.postgresql.Driver";
		this.user= "root";
		this.pwd="jairo";
		this.cadena="jdbc:mysql://localhost:3306/daniel";
		//this.cadena="jdbc:postgresql://localhost:5432/bd_imagen";
		
		this.con=this.crearConexion();
		
	}
	
	Connection crearConexion(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			}
			catch (Exception e) {
			
			}
		
		try{
			Class.forName(getDriver()).newInstance();
			Connection con=(Connection) DriverManager.getConnection(getCadena(),getUser(),getPwd());
			return con;
		}
	catch(Exception ee)
	{
		System.out.println("Error: " + ee.getMessage());
		return null;
	}
	}
	*/

	public String Ejecutar(String sql)
	{
	String error="";
	try
	{
	St=(Statement) getConexion().createStatement();
	St.execute(sql);
	error="Datos insertados";
	}
	catch(Exception ex)
	{
	error = ex.getMessage();
	}
	return(error);
	}



	public ResultSet Consulta(String sql)
	{
	String error="";
	ResultSet reg=null;
	
	try
	{
	St=(Statement) getConexion().createStatement();
	reg=St.executeQuery(sql);
	
	
	}
	catch(Exception ee)
	{
	error = ee.getMessage();
	}
	return(reg);

	
	}
}
