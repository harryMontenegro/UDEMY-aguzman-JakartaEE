<!-- Directivas que deben tener los .jsp para indicar el tipo de contenido y el encoding -->
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!-- las etiquetas < %@% > sirven para indicar alguna directiva -->
<%@page import="java.util.List"%>

<%
    //las etiquetas < %% > sirven para especificar o contener código Java, nótese que van sin el @, esto se le conoce como scriptlet.
    // Ya que en html no se puede embeber código Java, se debe hacer uso en los jsp de los scriptlets.

    //request es un obj propio del jsp.
    //request.getAttribute(String) es un método que extrae algún atributo por nombre
    List<String> errores = (List<String>) request.getAttribute("errores");//"errores" atributo pasado desde el servlet
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de usuario</title>
</head>
<body>
<h3>Formulario de usuarios</h3>
<%if (errores != null && errores.size() > 0) {%>
<ul>
    <% for (String error : errores) {%>
    <!-- < %=error% > se le conoce como expresiones de jsp para imprimir en html-->
    <li><%=error%>
    </li>
    <%}%>
</ul>
<%}%>
<form action="/webapp/registro" method="post">
    <div>
        <label for="username">Usuario</label>
        <div><input type="text" name="username" id="username"></div>
    </div>
    <div>
        <label for="password">Password</label>
        <div><input type="password" name="password" id="password"></div>
    </div>
    <div>
        <label for="email">Email</label>
        <div><input type="email" name="email" id="email"></div>
    </div>
    <div>
        <label for="pais">Pais</label>
        <div>
            <select name="pais" id="pais">
                <option value="">-- Seleccionar --</option>
                <option value="ES">España</option>
                <option value="MX">Mexico</option>
                <option value="CL" selected>Clile</option>
                <option value="AR">Argentina</option>
                <option value="PE">Perú</option>
                <option value="CO">Colombia</option>
                <option value="VE">Venezuela</option>
            </select>
        </div>
    </div>
    <div>
        <label for="lenguajes">Lenguajes de programación</label>
        <div>
            <select name="lenguajes" id="lenguajes" multiple>
                <option value="java" selected>Java SE</option>
                <option value="jakartaee" selected>Jakarta EE</option>
                <option value="spring">Spring boot</option>
                <option value="js">JavaScripts</option>
                <option value="angular" selected>Angular</option>
                <option value="react">React</option>
            </select>
        </div>
    </div>
    <div>
        <label>Roles</label>
        <div>
            <input type="checkbox" name="roles" value="ROLE_ADMIN" checked>
            <label>Administrador</label>
        </div>
        <div>
            <input type="checkbox" name="roles" value="ROLE_USER" checked>
            <label>Usuario</label>
        </div>
        <div>
            <input type="checkbox" name="roles" value="ROLE_MODERATOR">
            <label>Moderador</label>
        </div>
    </div>
    <div>
        <label>Idiomas</label>
        <div>
            <input type="radio" name="idioma" value="es">
            <label>Español</label>
        </div>
        <div>
            <input type="radio" name="idioma" value="en">
            <label>Inglés</label>
        </div>
        <div>
            <input type="radio" name="idioma" value="fr">
            <label>Frances</label>
        </div>
    </div>
    <div>
        <label for="habilitar">Habilitar</label>
        <div>
            <input type="checkbox" name="habilitar" id="habilitar" checked>
        </div>
    </div>
    <div>
        <div>
            <input type="submit" value="Enviar">
        </div>
    </div>
    <input type="hidden" name="secreto" value="12345">
</form>
</body>
</html>

