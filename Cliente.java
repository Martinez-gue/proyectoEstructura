
public class Cliente {
    private String nombre;
    private PilaDinamica pedido;  // Pila dinámica de productos

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.pedido = new PilaDinamica();  // Crea una nueva pila dinámica
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarProducto(producto producto) {
        pedido.push(producto);  // Agregar producto a la pila
    }

    public producto procesarProducto() throws Exception {
        return (producto) pedido.pop();  // Remover y retornar el último producto
    }

    public boolean tienePedido() {
        return !pedido.estavacia();  // Verifica si el cliente tiene productos
    }
    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + "]";
    }
}
