package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.ClsIngreso;
import classes.Cls_listar;


/**
 * Servlet implementation class Sr_ingresar
 */
@WebServlet("/Sr_ingresar")
public class Sr_ingresar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sr_ingresar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tende,fecha, perspectiva, objetivo, indicador ,tendencia,unidad; String frecuencia, fuente,responsable; double lbase=0, lmeta=0, valor=0;
		ClsIngreso obj = new ClsIngreso();
		Cls_listar obj2=new Cls_listar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//date format
		String date2=null;
		Date date = new Date();
		
		fecha = request.getParameter("txtFecha");//PK
		
		date2=sdf.format(date);
		String xx=String.valueOf(date2);
		
		System.out.println("fecha ingresado: "+fecha+" fecha del sistema "+xx);
		
		perspectiva = request.getParameter("txtPerspectiva");
		objetivo = request.getParameter("txtObjetivo");//PK
		indicador = request.getParameter("txtIndicador");
		tendencia = request.getParameter("txtTendencia");
		unidad = request.getParameter("txtUnidad");
		
		if(tendencia.equals("A subir")){
			tende=">";
		}else{
			tende="<";
		}
		
			
		frecuencia = request.getParameter("txtFrecuencia");
		fuente=request.getParameter("txtFuente");
		responsable = request.getParameter("txtResponsable");
		
		lbase = Double.parseDouble(request.getParameter("txtLBase"));
		lmeta = Double.parseDouble(request.getParameter("txtLMeta"));
		valor = Double.parseDouble(request.getParameter("txtValor"));
		
		
		int verificar_valores=0;
		if(tende.equals(">") && lmeta>lbase){
			System.out.println("TIENDE A SUBIR Y ESTA BIEn");
			verificar_valores=1;
		}else{
			if(tende.equals("<") && lbase>lmeta){
				System.out.println("TIENDE A bajar Y ESTA BIEn");
				verificar_valores=1;
			}else{
				verificar_valores=2;
			}
		}
		
		
		int valor_de_PK=1;
		valor_de_PK=obj2.validar_PK(fecha,objetivo);
	if(fecha.equals(xx)){	
		if(valor_de_PK==0){
if(verificar_valores==1){		
if(objetivo!=null && indicador!=null && fuente!=null  && responsable!=null){
if(obj.agregarDatos(fecha, perspectiva, objetivo, indicador, tende, frecuencia, fuente, responsable, lbase, lmeta, valor,unidad)){
response.sendRedirect("ingresar.jsp?error=true&msg=Datos Ingresados&fechas2="+fecha+"");
}else{//en caso de que no se ingresen los datos
response.sendRedirect("ingresar.jsp?error=false&msg=No se ha podido ingresar los datos intente de nuevo&fechas2="+fecha+"");
}
}else{//en caso de que los datos esten vacios
response.sendRedirect("ingresar.jsp?error=false&msg=Datos vacios&fechas2="+fecha+"");
}
}else{response.sendRedirect("ingresar.jsp?error=false&msg=Los valores ingresados no concuerdan con la tendencia&fechas2="+fecha+"");}
}else{//jairo else de verificar las PK que no sean iguales
response.sendRedirect("ingresar.jsp?error=false&msg=Verifique que los datos que ingresa no sean iguales \n al mes y objetivo estr. que desea ingresar&fechas2="+fecha+"");
}
	}else{//fechas
		response.sendRedirect("ingresar.jsp?error=false&msg=La fecha ingresada no es valida, verifique el mes que estamos hoy.&fechas2="+fecha+"");
	}
	
	
	
	
	}}