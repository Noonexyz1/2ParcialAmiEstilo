
package com.emergentes.servicio;

import com.emergentes.dao.ProductoDAO;
import com.emergentes.dao.ProductoDAOimpl;
import com.emergentes.modelo.Producto;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductoServicioImpl implements ProductoServicio {

    private ProductoDAO dao;
    
    private Producto producto;
    private String elemntoJsp;
    
    public ProductoServicioImpl(){
        
    }
        
    
    
    
    
    @Override
    public Producto encontrarProducto() {
        return producto;
    }

    @Override
    public String getElementoJsp() {
        return elemntoJsp;
    }

    @Override
    public void evaluador(HttpServletRequest request, HttpServletResponse response) {
        dao = new ProductoDAOimpl();
        
        if (request.getParameter("action").equals("new")) {
            elemntoJsp = "producto.jsp";
            producto = new Producto();
            
        } else if (request.getParameter("action").equals("edit")) {
            elemntoJsp = "producto.jsp";
            try {
                producto = dao.getById(Integer.parseInt(request.getParameter("id")));
            } catch (Exception ex) {
                System.out.println("ERROR en evaluador()" + ex.getMessage());
                ex.getStackTrace();
            }
            
        } else if (request.getParameter("action").equals("delete")) {
            elemntoJsp = "producto.jsp";
            try {
                dao.delete(Integer.parseInt(request.getParameter("id")));
            } catch (Exception ex) {
                System.out.println("ERROR en evaluador()" + ex.getMessage());
                ex.getStackTrace();
            }
            
        }
        
        
    }
    
    
    
    
    
    @Override
    public void eliminarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void nuevoProducto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Producto> traerProductos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    

}


