package com.supermarket.App.service;

import com.supermarket.App.moodel.Producto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductoService {

    List<Producto> getAll();
    void crearProducto(Producto producto);

    Producto getById(Long id);

    void borrarProducto(Long id);

    void actualizarProducto(Long id, Producto producto);
}
