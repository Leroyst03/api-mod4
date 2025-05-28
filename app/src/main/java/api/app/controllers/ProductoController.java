package api.app.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.app.entities.Producto;
import api.app.exceptions.HttpException;
import api.app.services.ServicioProducto;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final ServicioProducto service; 

    public ProductoController(ServicioProducto service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getProductos() {
       try {
            return ResponseEntity.ok(service.getProductos());
        } 
        catch(Exception e) {
            return ResponseEntity.status(500).body(null);
        }   
       
    }

    @PostMapping
    public ResponseEntity<?> setProducto(@RequestBody Producto producto) {
        try{
            return ResponseEntity.ok(service.setProducto(producto));
        }
        catch(HttpException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProducto(@PathVariable Long id, @RequestBody Producto nuevoProducto) {
        try{
            return ResponseEntity.ok(service.updateProducto(id, nuevoProducto));
        }
        catch(HttpException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> geProductoBydId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getProductoById(id));
        }
        catch(HttpException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable Long id) {
        try{
            service.deleteProducto(id);
            return ResponseEntity.status(200).body("Producto eliminado con exito!");
        }
        catch(HttpException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

}
