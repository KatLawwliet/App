package com.supermarket.App.service.implement;

import com.supermarket.App.mapper.ProductoMapper;
import com.supermarket.App.moodel.Producto;
import com.supermarket.App.repository.ProductoRepository;
import com.supermarket.App.repository.entity.ProductoEntity;
import com.supermarket.App.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository repo;
    @Override
    public List<Producto> getAll() {


        return repo.findAll()
                .stream()
                .map(ProductoMapper::toProducto)
                .sorted(Comparator.comparing(Producto::getNombre))
                .collect(Collectors.toList());
    }

    @Override
    public void crearProducto(Producto producto) {
        ProductoEntity entity = ProductoMapper.toProductoEntity(producto);
        repo.save(entity);
    }

    @Override
    public Producto getById(Long id) {
        return ProductoMapper.toProducto(repo.findById(id).orElseThrow( () -> new RuntimeException("No se pudo")));
    }

    @Override
    public void borrarProducto(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void actualizarProducto(Long id, Producto producto) {
        ProductoEntity entity = ProductoMapper.toProductoEntity(producto);
        entity.setId(id);
        repo.save(entity);
    }
}
