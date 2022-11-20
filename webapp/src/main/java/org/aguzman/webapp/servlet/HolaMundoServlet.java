package org.aguzman.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//Las clases servlet se identifican con el sufijo servlet
//Para asocia a un servlet a una tuta url se anota la clase con la anotación WebServlet, cada ruta consumida por al navegador va a estar asociado a un servlet
@WebServlet("/hola-mundo")
//Para usar los métodos http la clase servlet debe extender de HttpServlet
public class HolaMundoServlet extends HttpServlet {

    @Override
    //doGet(HttpServletRequest request, HttpServletResponse response): métodos asociados a los métodos http, esos mapean el tipo de petición del endpoint
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");//Definimos el tipo de contenido de la respuesta

        PrintWriter out = response.getWriter();// Es como System.out.println, pero no escribe en la consola, escribe en el html del response.

        out.println("<!DOCTYPE>");//si se usa print(""), no identará el html del response (ver código fuente en el html del navegador)
        out.println("<html>");
        out.println("  <head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <title>Hola mundo servlet!</title>");
        out.println("  </head>");
        out.println("  <body>");
        out.println("    <h1>Hola mundo servlet!</h1>");
        out.println("  </body>");
        out.println("</html>");
        out.close();//Se puede cerrar el recurso de forma manual, es opcional.
    }
}























