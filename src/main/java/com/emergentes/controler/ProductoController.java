package com.emergentes.controler;

import com.emergentes.modelo.Producto;
import com.emergentes.servicio.ProductoServicio;
import com.emergentes.servicio.ProductoServicioImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
public class ProductoController extends HttpServlet {

    private ProductoServicio productoServicio;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        productoServicio = new ProductoServicioImpl();
        productoServicio.evaluador(request);
        
        Producto producto = productoServicio.encontrarProducto();
        String elementoJsp = productoServicio.getElementoJsp();    
        String atributo = productoServicio.getAtributo();
        
        request.setAttribute(atributo, producto);
        request.getRequestDispatcher(elementoJsp).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        productoServicio = new ProductoServicioImpl();
        
        
        //recibimos los datos del formulario
        productoServicio.manegador(request);
        
        //redirijimos a la pagina de inicio
        //request.setAttribute("productos", null);
        /*este metodo ya tiene el getContexPath()*/
        //request.getRequestDispatcher("/Inicio2").forward(request, response);
        response.sendRedirect(request.getContextPath() + "/Inicio2");

    }
    
    

}
