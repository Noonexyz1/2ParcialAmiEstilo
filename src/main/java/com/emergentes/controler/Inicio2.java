
package com.emergentes.controler;

import com.emergentes.modelo.Producto;
import com.emergentes.servicio.ProductoServicio;
import com.emergentes.servicio.ProductoServicioImpl;
import java.io.IOException;
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
        
        List<Producto> lista = productoServicio.traerProductos();
        
        //por alguna razon no funciona con:
        //request.setAttribute("productos", productoServicio.traerProductos());
        //Me parece que es debido a que la implementacion es con ArrayList y yo uso el List interface  
        
        //es mejor hacerlo de esta manera y no complicar las cosas sin motivo:
        request.setAttribute("productos", lista);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
    }
    

}
