
package com.emergentes.servicio;

import com.emergentes.modelo.Producto;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface ProductoServicio {
    
    public void manejador(HttpServletRequest request);
    public void evaluador(HttpServletRequest request);
    
    public List<Producto> traerProductos();
    public Producto encontrarProducto();
    public String getElementoJsp();
    public String getAtributo();
    
}
