package com.emergentes.servicio;

import com.emergentes.dao.ProductoDAO;
import com.emergentes.dao.ProductoDAOimpl;
import com.emergentes.modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductoServicioImpl implements ProductoServicio {

    private Producto producto;
    private String elemntoJsp;
    private String atributo;

    private ProductoDAO dao;

    public ProductoServicioImpl() {
        dao = new ProductoDAOimpl();
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
    public String getAtributo() {
        return atributo;
    }

    @Override
    public void manegador(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String descripcion = request.getParameter("descripcion");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            float precio = Float.parseFloat(request.getParameter("precio"));
            String categoria = request.getParameter("categoria");

            //Producto producto = new Producto();
            producto.setId(id);
            producto.setDescripcion(descripcion);
            producto.setCantidad(cantidad);
            producto.setPrecio(precio);
            producto.setCategoria(categoria);

            if (Integer.parseInt(request.getParameter("id")) == 0) {
                dao.insert(producto);

            } else {
                dao.update(producto);

            }

        } catch (Exception ex) {
            Logger.getLogger(ProductoServicioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void evaluador(HttpServletRequest request) {

        if (request.getParameter("action").equals("new")) {
            elemntoJsp = "producto.jsp";
            atributo = "producto";
            producto = new Producto();

        } else if (request.getParameter("action").equals("edit")) {
            elemntoJsp = "producto.jsp";
            atributo = "producto";
            try {
                producto = dao.getById(Integer.parseInt(request.getParameter("id")));
            } catch (Exception ex) {
                System.out.println("ERROR en evaluador()" + ex.getMessage());
                ex.getStackTrace();
            }

        } else if (request.getParameter("action").equals("delete")) {
            elemntoJsp = "producto.jsp";
            //elemntoJsp = "producto.jsp";
            try {
                dao.delete(Integer.parseInt(request.getParameter("id")));
            } catch (Exception ex) {
                System.out.println("ERROR en evaluador()" + ex.getMessage());
                ex.getStackTrace();
            }

        }

    }

    

    @Override
    public List<Producto> traerProductos() {
        List<Producto> productos = new ArrayList<>();
        try {
            productos = dao.getAll();
        } catch (Exception ex) {
            Logger.getLogger(ProductoServicioImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return productos;
        }

    }

}
