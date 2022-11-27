package org.aguzman.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/despachar")
public class DespacharServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Al usar getServletContext().getRequestDispatcher("/productos.html").forward(req, resp) se modifica el recurso o carga dentro del request actual otro servlet existente o otra jsp
        //es como un join, unir el request actual a otro recurso de la aplicación, este debe ser un recurso interno de la aplicación y no externo por lo tanto se carga y no se redirige
        //como en el caso al redirigir, por lo que la ruta en el navegador no cambia, se le conoce como dispacher
        getServletContext().getRequestDispatcher("/productos.html").forward(req, resp);
    }
}













