package servlets;

import java.io.IOException;
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
		String tende,fecha, perspectiva, objetivo, indicador ,tendencia; String frecuencia, fuente,responsable; int lbase, lmeta, valor;
		ClsIngreso obj = new ClsIngreso();
		Cls_listar obj2=new Cls_listar();
		fecha = request.getParameter("txtFecha");//PK
		perspectiva = request.getParameter("txtPerspectiva");
		objetivo = request.getParameter("txtObjetivo");//PK
		indicador = request.getParameter("txtIndicador");
		tendencia = request.getParameter("txtTendencia");
		
		if(tendencia.equals("A subir")){
			tende=">";
		}else{
			tende="<";
		}
		
			
		frecuencia = request.getParameter("txtFrecuencia");
		fuente=request.getParameter("txtFuente");
		responsable = request.getParameter("txtResponsable");
		
		lbase = Integer.parseInt(request.getParameter("txtLBase"));
		lmeta = Integer.parseInt(request.getParameter("txtLBase"));
		valor = Integer.parseInt(request.getParameter("txtValor"));
			
		int valor_de_PK=1;
		valor_de_PK=obj2.validar_PK(fecha,objetivo);
		
		if(valor_de_PK==0){
		if(objetivo!=null && indicador!=null && fuente!=null  && responsable!=null){
			 
			if(obj.agregarDatos(fecha, perspectiva, objetivo, indicador, tende, frecuencia, fuente, responsable, lbase, lmeta, valor)){
				response.sendRedirect("ingresar.jsp?error=true&msg=Datos Ingresados&fechas2="+fecha+"");
			}else{
				response.sendRedirect("ingresar.jsp?error=false&msg=No se ha podido ingresar los datos intente de nuevo&fechas2="+fecha+"");
			}
		}else{
			response.sendRedirect("ingresar.jsp?error=false&msg=Datos vacios&fechas2="+fecha+"");
			}
		}else{//jairo
			response.sendRedirect("ingresar.jsp?error=false&msg=Verifique que los datos que ingresa no sean iguales \n al mes y objetivo estr. que desea ingresar&fechas2="+fecha+"");
		}
	
	
	
	
	
	}}