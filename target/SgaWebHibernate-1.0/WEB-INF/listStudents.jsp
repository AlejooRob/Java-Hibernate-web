<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Listado de Alumnos</title>
    </head>
    <body>
        <h2>Listar ALumnos</h2>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletRedirect">Agregar</a>
        <br />
        <br />
        <table border="1">
            
            <tr>
                <th>Alumno ID</th>
                <th>Nombre</th>
                <th>Domicilio</th>
                <th>Email</th>
                <th>Teléfono</th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/ServletUpdate?idStudent=${student.idStudent}">
                            ${student.idStudent}
                        </a>
                    </td>
                    <td>${student.firstName} ${student.lastName}</td>
                    <td>${student.residence.street} ${student.residence.streetNumber} ${student.residence.city}</td>
                    <td>${student.contact.email}</td>
                    <td>${student.contact.phone}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
