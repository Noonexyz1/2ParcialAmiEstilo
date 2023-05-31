
package com.emergentes.controler;

import com.emergentes.modelo.Producto;
import com.emergentes.servicio.ProductoServicio;
import com.emergentes.servicio.ProductoServicioImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Inicio2", urlPatterns = {"/Inicio2"})
public class Inicio2 extends HttpServlet {

    private ProductoServicio productoServicio;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        /*traer todos los datos*/
        productoServicio = new ProductoServicioImpl();
                
        request.setAttribute("productos", productoServicio.traerProductos());
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
    }
    

}
