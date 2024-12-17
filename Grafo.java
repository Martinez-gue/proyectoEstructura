public class Grafo {
    private NodoGrafo primero;
    private NodoGrafo ultimo;
    public Grafo() {
        this.primero = null;
        this.ultimo = null;
    }
    public boolean estaVacio() {
        return this.primero == null && this.ultimo == null;
    }
    public boolean existeVertice(Object dato) {
        if (estaVacio()) return false;
        NodoGrafo actual = primero;
        while (actual != null) {
            if (actual.getDato().equals(dato)) 
                return true;
            actual = actual.getSiguiente();
        }
        return false;
    }
    public boolean agregarNodo(Object dato) {
        if (existeVertice(dato)) return false; 
        NodoGrafo nodo = new NodoGrafo(dato);
        if (estaVacio()) {
            this.primero = nodo;
            this.ultimo = nodo;
        } else {
            this.ultimo.setSiguiente(nodo);
            this.ultimo = nodo;
        }
        return true;
    }
    public boolean agregarArista(Object origen, Cliente destino) {
        if (!existeVertice(origen) || !existeVertice(destino)) {
            System.out.println("No se puede agregar la arista. Uno de los vértices no existe.");
            return false;
        }

        NodoGrafo actual = primero;
        while (actual != null) {
            if (actual.getDato().equals(origen)) {  
                actual.getListaAdyacencia().agregarAdyacencia(destino);
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
    public boolean registrarCliente(Cliente cliente) {
    return agregarNodo(cliente);  
    }
    public NodoGrafo buscarNodo(String nombreCliente) {
        NodoGrafo actual = primero;
        while (actual != null) {
            Cliente cliente = (Cliente) actual.getDato();  
            if (cliente.getNombre().equals(nombreCliente)) {
                return actual;  
            }
            actual = actual.getSiguiente();
        }
        return null;  
    }
    public boolean agregarProductoACliente(String nombreCliente, producto producto1) {
        NodoGrafo actual = primero;
        while (actual != null) {
            if (actual.getDato() instanceof Cliente) {
                Cliente cliente = (Cliente) actual.getDato();  
                if (cliente.getNombre().equals(nombreCliente)) {
                    actual.getListaAdyacencia().agregarAdyacencia(producto1);  
                    return true;
                }
            }
            actual = actual.getSiguiente();
        }
        System.out.println("El cliente no existe en el grafo.");
        return false;
    }

    // Mostrar todos los clientes y los productos asociados
    public void mostrarClientesYProductos() {
        NodoGrafo actual = primero;
        while (actual != null) {
            if (actual.getDato() instanceof Cliente) {
                Cliente cliente = (Cliente) actual.getDato();
                System.out.println("Cliente: " + cliente.getNombre());
                System.out.println("Productos: " + actual.getListaAdyacencia());
            }
            actual = actual.getSiguiente();
        }
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        NodoGrafo actual = primero;
        while (actual != null) {
            cadena.append(actual.getDato().toString())
                  .append(" -> ")
                  .append(actual.getListaAdyacencia().toString())
                  .append("\n");
            actual = actual.getSiguiente();
        }
        return cadena.toString();
    }
}
