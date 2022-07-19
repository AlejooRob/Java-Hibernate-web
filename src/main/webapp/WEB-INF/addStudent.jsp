
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Agregar Alumno</title>
    </head>
    <body>
        <h1>Agregar Alumno</h1>
        <form name="form1" action="${pageContext.request.contextPath}/ServletAdd" method="POST">
            Nombre: <input type="text" name="firstName" />
            <br />
            Apellido: <input type="text" name="lastName" />
            <br />
            <br />
            Datos domicilio:
            <br />
            Calle: <input type="text" name="street" />
            <br />
            No. Calle: <input type="text" name="streetNumber" />
            <br />
            Ciudad: <input type="text" name="city" />
            <br />
            <br />
            Datos de contacto:
            <br />
            Email: <input type="email" name="email" />
            <br />
            Teléfono: <input type="text" name="phone" />
            <br />
            <br />
            <input type="submit" name="Add" value="Agregar" />
        </form>
    </body>
</html>
