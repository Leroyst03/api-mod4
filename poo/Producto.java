public class Producto {
    protected  String nombre;
    protected  double precio;
    protected  int cantidad;

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
        return "Nombre: " + nombre;
    }
    public String getPrecio() {
        return "Precio: " + precio;
    }
    public String getCantidad() {
        return "Nombre: " + cantidad;
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
