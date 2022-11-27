package org.aguzman.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/redirigir")
public class RedirigirServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Se setea al response la cabecera "Location" para especificar que se va a redirigir a la ruta que se especifica como segundo argumento
        /*resp.setHeader("Location", req.getContextPath() + "/productos.html");
        //Se le setea el HttpServletResponse.SC_FOUND para especificar que fue encontrada (302)
        resp.setStatus(HttpServletResponse.SC_FOUND);*/
        //NOTA: Al usar el resp.setHeader("Location", req.getContextPath() + "/productos.html") se redirige a la ruta especificada en el navegador


        //resp.sendRedirect(req.getContextPath() + "/productos.html") hace lo mismo que el código comentado en las lineas 17 y 19, modifica la cabecera y el estatus a SC_FOUND y la ruta que se pasa por argumento
        resp.sendRedirect(req.getContextPath() + "/productos.html");
    }
}














