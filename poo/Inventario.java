import java.util.ArrayList;
import java.util.List;

public class Inventario {
    List<Producto> productos = new ArrayList<>();

    public void guardarProductos(Producto[] datos) {
        for (Producto producto : datos) {
            if (producto.getPrecio() > 0 && producto.getCantidad() > 0) {
                productos.add(producto);
            }
        }
    }

    public void mostrarProductos() {
        for (Producto producto : productos) {
            System.out.println(producto.mostrarInfo());
        }
    }
}
