<!-- Directivas que deben tener los .jsp para indicar el tipo de contenido y el encoding -->
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!-- las etiquetas < %@% > sirven para indicar alguna directiva -->
<%@ page import="java.util.Map" %>

<%
    //las etiquetas < %% > sirven para especificar o contener código Java, nótese que van sin el @, esto se le conoce como scriptlet.
    // Ya que en html no se puede embeber código Java, se debe hacer uso en los jsp de los scriptlets.

    //request es un obj propio del jsp.
    //request.getAttribute(String) es un método que extrae algún atributo por nombre
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");//"errores" atributo pasado desde el servlet
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de usuario</title>
    <!-- CSS only -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h3>Formulario de usuarios</h3>
<%if (errores != null && errores.size() > 0) {%>
<ul class="alert alert-danger mx-5">
    <% for (String error : errores.values()) {%>
    <!-- < %=error% > se le conoce como expresiones de jsp para imprimir en html-->
    <li><%=error%>
    </li>
    <%}%>
</ul>
<%}%>
<div class="px-5">
    <form action="/webapp/registro" method="post">
        <div class="row mb-3">
            <label for="username" class="col-form-label col-sm-2">Usuario</label>
            <div class="sm-4"><input type="text" name="username" id="username" class="form-control"></div>
            <%
                if (errores != null && errores.containsKey("username")) {
                    out.println("<div class='row mb-3 alert alert-danger col-sm-4' style='color : red'>" + errores.get("username") + "</div>");
                }
            %>
        </div>
        <div class="row mb-3">
            <label for="password" class="col-form-label col-sm-2">Password</label>
            <div class="sm-4"><input type="password" name="password" id="password" class="form-control"></div>
            <%
                if (errores != null && errores.containsKey("password")) {
                    out.println("<small class='alert alert-danger col-sm-4' style='color : red'>" + errores.get("password") + "</small>");
                }
            %>
        </div>
        <div class="row mb-3">
            <label for="email" class="col-form-label col-sm-2">Email</label>
            <div class="sm-4"><input type="email" name="email" id="email" class="form-control"></div>
            <%
                if (errores != null && errores.containsKey("email")) {
                    out.println("<small class='alert alert-danger col-sm-4' style='color : red'>" + errores.get("email") + "</small>");
                }
            %>
        </div>
        <div class="row mb-3">
            <label for="pais" class="col-form-label col-sm-2">Pais</label>
            <div class="sm-4">
                <select name="pais" id="pais" class="form-select">
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
            <%
                if (errores != null && errores.containsKey("pais")) {
                    out.println("<small class='alert alert-danger col-sm-4' style='color : red'>" + errores.get("pais") + "</small>");
                }
            %>
        </div>
        <div class="row mb-3">
            <label for="lenguajes" class="col-form-label col-sm-2">Lenguajes de programación</label>
            <div class="sm-4">
                <select name="lenguajes" id="lenguajes" multiple class="form-select">
                    <option value="java" selected>Java SE</option>
                    <option value="jakartaee" selected>Jakarta EE</option>
                    <option value="spring">Spring boot</option>
                    <option value="js">JavaScripts</option>
                    <option value="angular" selected>Angular</option>
                    <option value="react">React</option>
                </select>
            </div>
            <%
                if (errores != null && errores.containsKey("lenguajes")) {
                    out.println("<small class='alert alert-danger col-sm-4' style='color : red'>" + errores.get("lenguajes") + "</small>");
                }
            %>
        </div>
        <div class="row mb-3">
            <label class="col-form-label col-sm-2">Roles</label>
            <div class="form-check">
                <input type="checkbox" name="roles" value="ROLE_ADMIN" checked class="form-check-input">
                <label class="form-check-label">Administrador</label>
            </div>
            <div class="form-check">
                <input type="checkbox" name="roles" value="ROLE_USER" checked class="form-check-input">
                <label class="form-check-label">Usuario</label>
            </div>
            <div class="form-check">
                <input type="checkbox" name="roles" value="ROLE_MODERATOR" class="form-check-input">
                <label class="form-check-label">Moderador</label>
            </div>
            <%
                if (errores != null && errores.containsKey("roles")) {
                    out.println("<small class='alert alert-danger col-sm-4' style='color : red'>" + errores.get("roles") + "</small>");
                }
            %>
        </div>
        <div class="row mb-3">
            <label class="col-form-label col-sm-2">Idiomas</label>
            <div class="form-check">
                <input type="radio" name="idioma" value="es" class="form-check-input">
                <label class="form-check-label">Español</label>
            </div>
            <div class="form-check">
                <input type="radio" name="idioma" value="en" class="form-check-input">
                <label class="form-check-label">Inglés</label>
            </div>
            <div class="form-check">
                <input type="radio" name="idioma" value="fr" class="form-check-input">
                <label class="form-check-label">Frances</label>
            </div>
        </div>
        <%
            if (errores != null && errores.containsKey("idioma")) {
                out.println("<small class='alert alert-danger col-sm-4' style='color : red'>" + errores.get("idioma") + "</small>");
            }
        %>
        <div class="row mb-3">
            <label for="habilitar" class="col-form-label col-sm-2">Habilitar</label>
            <div class="form-check">
                <input type="checkbox" name="habilitar" id="habilitar" checked class="form-check-input">
            </div>
        </div>
        <div class="row mb-3">
            <div>
                <input type="submit" value="Enviar" class="btn btn-primary">
            </div>
        </div>
        <input type="hidden" name="secreto" value="12345">
    </form>
</div>
</body>
</html>

