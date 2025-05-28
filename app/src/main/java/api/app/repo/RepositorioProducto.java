package api.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import api.app.entities.Producto;

public interface RepositorioProducto extends JpaRepository<Producto, Long>{
        
}
