public class ColaClientes {
    private colaDinamica cola;

    public ColaClientes() {
        cola = new colaDinamica();  // Crea una nueva cola dinámica
    }

    // Agregar cliente a la cola
    public void agregarCliente(Cliente cliente) {
        try {
            cola.agregar(cliente);  // Agregar cliente a la cola
        } catch (Exception e) {
            System.out.println("Error al agregar cliente: " + e.getMessage());
        }
    }

    // Procesar clientes en la cola
    public void procesarClientes() {
        while (!cola.estavacia()) {
            try {
                Cliente cliente = (Cliente) cola.eliminar();  // Obtener el primer cliente
                System.out.println("Atendiendo a: " + cliente.getNombre());

                // Procesar productos del cliente (LIFO)
                while (cliente.tienePedido()) {
                    producto producto = cliente.procesarProducto();  // Obtener el último producto
                    System.out.println("Procesando el producto: " + producto);
                }

                System.out.println("Pedido completo para: " + cliente.getNombre() + "\n");

            } catch (Exception e) {
                System.out.println("Error al procesar cliente: " + e.getMessage());
            }
        }
    }
    
}
