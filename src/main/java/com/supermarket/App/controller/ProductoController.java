package com.supermarket.App.controller;

import com.supermarket.App.moodel.Producto;
import com.supermarket.App.service.ProductoService;
import com.supermarket.App.service.implement.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/producto")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping("/all")
    public ResponseEntity<List<Producto>> getAll(){
        List<Producto> productos = service.getAll();
        return new ResponseEntity<>(productos , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> crearProducto(@RequestBody Producto producto){
        service.crearProducto(producto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarProducto(@PathVariable("id") Long id, @RequestBody Producto producto){
        service.actualizarProducto(id ,producto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarProducto(@PathVariable("id") Long id) {
        service.borrarProducto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
