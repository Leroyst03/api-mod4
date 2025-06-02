public class App {
    
    public static void main(String[] args) {
        ProductoElectrico[] lis = new ProductoElectrico[5];
        Inventario inventario = new Inventario();

        for(int i = 0; i < 5; i++){
            lis[i] = new ProductoElectrico("Nombre" + i, i * 10, i, "Modelo" + i, "Marca" + i);
        }

        inventario.guardarProductos(lis);

        inventario.mostrarProductos();

    }

}
