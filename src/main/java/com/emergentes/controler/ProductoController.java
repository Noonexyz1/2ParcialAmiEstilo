
package com.emergentes.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
public class ProductoController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        request.setAttribute("producto", null);
        request.getRequestDispatcher("producto.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        //recibimos los datos del formulario
        //enviamos a la base de datos
        
        
        

        //redirijimos a la pagina de inicio
        //request.setAttribute("productos", null);
        
            /*este metodo ya tiene el getContexPath()*/
            //request.getRequestDispatcher("/Inicio2").forward(request, response);
        
        response.sendRedirect(request.getContextPath() + "/Inicio2");

        
    }

    
    
    
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    

}
