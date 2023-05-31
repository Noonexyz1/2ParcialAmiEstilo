
package com.emergentes.servicio;

import com.emergentes.modelo.Producto;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ProductoServicio {
    
    public void eliminarProducto();
    public void editarProducto();
    public void nuevoProducto();
    
    public List<Producto> traerProductos();
    public Producto encontrarProducto();
    public String getElementoJsp();
    public void evaluador(HttpServletRequest request, HttpServletResponse response);
    
}
