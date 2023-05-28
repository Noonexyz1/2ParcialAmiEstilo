<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.emergentes.modelo.Producto"%>
<%
    Producto producto = (Producto) request.getAttribute("producto");
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
        <h1>
            <c:if test="${producto.id == 0}">
                Nuevo Registro
            </c:if>

                <c:if test="${producto.id != 0}">
                Editar Registro
            </c:if>

        </h1>
        <form action="Inicio" method="POST">

            <input type="hidden" name="id" value="${producto.id}"> 

            <table>
                <tr>
                    <td>Descripcion:</td>
                    <td><input type="text" name="descripcion" value="${producto.descripcion}"></td>
                </tr>
                <tr>
                    <td>Cantidad:</td>
                    <td><input type="number" name="cantidad" value="${producto.cantidad}"></td>
                </tr>
                <tr>
                    <td>Precio:</td>
                    <td><input type="text" name="precio" value="${producto.precio}"></td>
                </tr>
                <tr>
                    <td>Categoria:</td>
                    <td><input type="text" name="categoria" value="${producto.categoria}"></td>
                </tr>
                
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar Producto"></td>
                </tr>
                
            </table>
        </form>

    </body>
</html>
