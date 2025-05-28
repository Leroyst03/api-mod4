import java.util.*;

public class Inventario {
    private ArrayList<ProductoElectrico> productos = new ArrayList<>();


    public void guardarProductos(ProductoElectrico[] datos) {
        for(ProductoElectrico producto : datos) {
            if(producto.precio > 0) productos.add(producto);
        }
    }

    public void mostrarPorductos() {
        for(ProductoElectrico producto : productos) {
            System.out.println(producto.mostrarInfo());
        }
    }

}