package org.aguzman.apiservlet.webapp.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/registro")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String pais = req.getParameter("pais");
        String[] lenguajes = req.getParameterValues("lenguajes");
        String[] roles = req.getParameterValues("roles");
        String idioma = req.getParameter("idioma");
        String habilitar = req.getParameter("habilitar");
        String secreto = req.getParameter("secreto");

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE>");
            out.println("<html>");
            out.println("  <head>");
            out.println("    <meta charset=\"UTF-8\">");
            out.println("    <title>Registro formulario</title>");
            out.println("  </head>");
            out.println("  <body>");
            out.println("    <h1>Registro formulario!</h1>");
            out.println("    <ul>");
            out.println("       <li>Username: " + username + "</li>");
            out.println("       <li>Password: " + password + "</li>");
            out.println("       <li>Email: " + email + "</li>");
            out.println("       <li>Pais: " + pais + "</li>");
            out.println("       <li><ul>");
            Arrays.asList(lenguajes).forEach(lenguaje -> out.println("      <li>Lenguaje: " + lenguaje + "</li>"));
            out.println("       </ul></li>");
            out.println("       <li><ul>");
            Arrays.asList(roles).forEach(rol -> out.println("          <li>Rol: " + rol + "</li>"));
            out.println("       </ul></li>");
            out.println("       </li>");
            out.println("       <li>Idioma: " + idioma + "</li>");
            out.println("       <li>Habilitado: " + habilitar + "</li>");
            out.println("       <li>Secreto: " + secreto + "</li>");
            out.println("    </ul>");
            out.println("  </body>");
            out.println("</html>");
        }
    }
}
















