<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Producto"%>
<%
    ArrayList<Producto> producto = (ArrayList<Producto>) request.getAttribute("productos");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Diego Diomir MR</title>        
        <style>
            table {
                border-collapse: collapse;
            }

            td,th {
                border: 1px solid black;
                padding: 10px;
            }
        </style>

    </head>

    <body>

        <table border="1">
            <tr>
                <td>
                    <p>
                        SEGUNDO PARCIAL TEM-742 <br>
                        Nombre: Diego Diomir Mamani Ramos<br>
                        Carnet: 12700466<br>
                    </p>
                </td>
            </tr>
        </table>

        <h1>Gestion de Productos <br> DIEGO D. MAMANI RAMOS</h1>
        <p><a href="Inicio?action=add">Nuevo Producto</a></p>
        <table>
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th>Cantidad</th>
                <th>Precio</th>
                <th>Categoria</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${producto}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.cantidad}</td>
                    <td>${item.precio}</td>
                    <td>${item.categoria}</td>
                    <td>  <a href="Inicio?action=edit&id=${item.id}">Editar</a>  </td>
                    <td>  <a href="Inicio?action=delete&id=${item.id}" onclick="return(confirm('Estas seguro de eliminar???????'))">Eliminar</a> </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
