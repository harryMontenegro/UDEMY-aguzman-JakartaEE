package org.aguzman.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/cabeceras-request")
public class CabecerasHttpRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Métodos para obtener la inf de la cabecera del request
        String metodoHttp = req.getMethod();// Nombre de método de la petición http
        String requestUri = req.getRequestURI();//Devuelve lo que va después del puerto y del local host (nombre proyecto + el nombre del servlet)
        String requestUrl = req.getRequestURL().toString();//Devuelve tódo incluyendo htt://...
        String contexPath = req.getContextPath();// Nombre de proyecto o contexto.
        String servletPath = req.getServletPath();//Ruta del servlet
        String ipCliente = req.getRemoteAddr();//Ip del cliente desde donde se hace la petición.
        String ip = req.getLocalAddr();//ip del servidor local
        int port = req.getLocalPort();//Puerto del servidor local
        String schema = req.getScheme();//devuelve http o https
        String host = req.getHeader("host");//getHeader("nombreHeader") devuelve un header en específico: "host" devuelve localhost:8080
        String url = schema + "://" + host + contexPath + servletPath;
        String url2 = schema + "://" + ip + ":" + port + contexPath + servletPath;

        resp.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE>");
            out.println("<html>");
            out.println("  <head>");
            out.println("    <meta charset=\"UTF-8\">");
            out.println("    <title>Cabeceras Http Request</title>");
            out.println("  </head>");
            out.println("  <body>");
            out.println("    <h1>Cabeceras Http Request!</h1>");
            out.println("<ul>");
            out.println("<li>método http: " + metodoHttp + "</li>");
            out.println("<li>request uri: " + requestUri + "</li>");
            out.println("<li>request url: " + requestUrl + "</li>");
            out.println("<li>contex path: " + contexPath + "</li>");
            out.println("<li>servlet path: " + servletPath + "</li>");
            out.println("<li>ip local: " + ip + "</li>");
            out.println("<li>ip cliente: " + ipCliente + "</li>");
            out.println("<li>puerto local: " + port + "</li>");
            out.println("<li>scheme: " + schema + "</li>");
            out.println("<li>host: " + host + "</li>");
            out.println("<li>url: " + url + "</li>");
            out.println("<li>url2: " + url2 + "</li>");

            Enumeration<String> headerNames = req.getHeaderNames();//Se obtiene los nombres de las cabeceras
            while (headerNames.hasMoreElements()){
                String cabecera = headerNames.nextElement();
                out.println("<li>" + cabecera + ": " + req.getHeader(cabecera) + "</li>");
            }
            out.println("<ul>");
            out.println("  </body>");
            out.println("</html>");
        }
    }
}














