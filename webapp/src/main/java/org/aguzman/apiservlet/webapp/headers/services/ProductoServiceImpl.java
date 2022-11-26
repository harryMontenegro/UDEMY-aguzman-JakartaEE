package org.aguzman.apiservlet.webapp.headers.services;

import org.aguzman.apiservlet.webapp.headers.models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImpl implements ProductoService{
    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "notebok", "computacion",175000),
                new Producto(2L, "mesa escritorio", "oficina", 1000000),
                new Producto(3L, "teclado mecánico", "computacion", 40000));
    }
}
