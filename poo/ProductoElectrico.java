public class ProductoElectrico extends Producto{
    private String modelo;
    private String marca;

    public ProductoElectrico (String nombre, double precio, int cantidad, String modelo, String marca) {
        super(nombre, precio, cantidad);
        this.modelo = modelo;
        this.marca = marca;
    }

    @Override
   public String mostrarInfo() {
        return  "Nombre: " + nombre + "\n" 
        + "Precio: " + precio + "\n" +
        "Cantidad: " + cantidad + "\n" +
        "Modelo: " + modelo + "\n" + 
        "Marca: " + marca + "\n";
    }


}
