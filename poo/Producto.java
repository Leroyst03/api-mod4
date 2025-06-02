public class Producto {
    private  String nombre;
    private  double precio;
    private  int cantidad;

    public Producto (String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String mostrarInfo() {
        return  "Nombre: " + nombre + "\n" 
        + "Precio: " + precio + "\n" +
        "Cantidad: " + cantidad;
    }

    public String getNombre() {
        return nombre;
    }
    public Double getPrecio() {
        return precio;
    }
    public Integer getCantidad() {
        return cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
