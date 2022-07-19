package com.supermarket.App.mapper;

import com.supermarket.App.moodel.Producto;
import com.supermarket.App.repository.entity.ProductoEntity;

public class ProductoMapper {

    public static Producto toProducto(ProductoEntity entity){
        Producto producto = new Producto();
        producto.setNombre(entity.getNombre());
        producto.setPrecio(entity.getPrecio());

        return producto;
    }

    public static ProductoEntity toProductoEntity(Producto producto){
        ProductoEntity entity = new ProductoEntity();
        entity.setNombre(producto.getNombre());
        entity.setPrecio(producto.getPrecio());

        return entity;
    }
}
