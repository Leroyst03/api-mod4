package api.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import api.app.entities.Producto;
import api.app.exceptions.HttpException;
import api.app.repo.RepositorioProducto;

@Service
public class ServicioProducto {
    private final RepositorioProducto repo;

    public ServicioProducto(RepositorioProducto repo) {
        this.repo = repo;
    }

    public List<Producto> getProductos() {
        return repo.findAll();
    } 

    public Producto setProducto(Producto producto) {
        if(producto.getNombre() == null || producto.getNombre().isEmpty()) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "El nombre del producto no puede estar vacío");
        }
    
        if(producto.getCantidad() == null || producto.getCantidad() <= 0) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "La cantidad debe ser mayor a 0");
        }   

        if(producto.getPrecio() <= 0) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "El precio debe ser mayor a 0");
        }
        
        return repo.save(producto);
    }

    public Producto getProductoById(Long id) {
        return repo.findById(id).orElseThrow(() -> new HttpException (HttpStatus.NOT_FOUND, "Producto no encontrado con ID: " + id));
    }

    public void deleteProducto(Long id) {
        if (!repo.existsById(id)) {  // Verifica si el producto existe antes de eliminarlo
            throw new HttpException(HttpStatus.NOT_FOUND, "Producto no encontrado con ID: " + id);
        }
        repo.deleteById(id);
    }

    public Producto updateProducto(Long id, Producto nuevoProducto) {
        if(!repo.existsById(id)) {
            throw new HttpException(HttpStatus.NOT_FOUND, "Producto no encontrado con ID: " + id);
        }

        Optional<Producto> productoOpt = repo.findById(id);

        Producto producto = productoOpt.get();

        if(nuevoProducto.getNombre() == null && nuevoProducto.getNombre().length() <= 0) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Los datos proporcionados son invalidos");
        } else{
            producto.setNombre(nuevoProducto.getNombre());
        }
        
        if(nuevoProducto.getCantidad() == null && nuevoProducto.getCantidad() <= 0) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Los datos proporcionados son invalidos");
        }  else{
            producto.setCantidad(nuevoProducto.getCantidad());
        }

        if(nuevoProducto.getPrecio() != producto.getPrecio() && nuevoProducto.getPrecio() > 0) {
            producto.setPrecio(nuevoProducto.getPrecio());
            return repo.save(producto);
        }
        else{
            throw new HttpException(HttpStatus.BAD_REQUEST, "Los datos proporcionados son invalidos");
        }
    }

}
