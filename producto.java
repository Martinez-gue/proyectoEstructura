public class producto implements Comparable<producto> {
    public String nombre;
    public String marca;
    public String codigo;
    public Long precio;
    public producto(String nombre, String marca, String codigo,long precio) {
        this.nombre = nombre;
        this.marca = marca;
        this.codigo = codigo;
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }
    public String getMarca() {
        return marca;
    }
    public String getCantidad() {
        return codigo;
    }
    public long getPrecio() {
        return precio;
    }
    @Override
    public int compareTo(producto otroProducto) {
        return Long.compare(this.precio, otroProducto.precio);
    }
    public int compareNombre(producto otroProducto) {
        return this.nombre.compareTo(otroProducto.nombre);
    }
    public int comparePrecio(producto otroProducto) {
    return Long.compare(this.precio, otroProducto.precio); 
    }
    public String toCSV() {
        return String.format("\"%s\",\"%s\",\"%s\",%d", nombre, marca, codigo, precio);
    }
    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", marca=" + marca + ", codigo=" + codigo + ", precio=" + precio + "]";
    }
}



