
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Modificar Alumno</title>
    </head>
    <body>
        <h1>Modificar Alumno</h1>
        <form name="form1" action="${pageContext.request.contextPath}/ServletUpdate" method="POST">
            <input type="hidden" name="idStudent" value="${student.idStudent}" />
            Nombre: <input type="text" name="firstName" value="${student.firstName}"/>
            <br />
            Apellido: <input type="text" name="lastName" value="${student.lastName}"/>
            <br />
            <br />
            Datos domicilio:
            <br />
            Calle: <input type="text" name="street" value="${student.residence.street}"/>
            <br />
            No. Calle: <input type="text" name="streetNumber" value="${student.residence.streetNumber}"/>
            <br />
            Ciudad: <input type="text" name="city" value="${student.residence.city}"/>
            <br />
            <br />
            Datos de contacto:
            <br />
            Email: <input type="email" name="email" value="${student.contact.email}"/>
            <br />
            Teléfono: <input type="text" name="phone" value="${student.contact.phone}"/>
            <br />
            <br />
            <input type="submit" name="Add" value="Modificar" />
            <input type="submit" name="Delete" value="Delete" />
        </form>
    </body>
</html>
