public class colaDinamica {
    private Nodo primero;
    private Nodo ultimo;

    public colaDinamica() {
        this.primero = null;
        this.ultimo = null;
    }

    public boolean estavacia() {
        return this.primero == null;
    }

    public boolean agregar(Cliente cliente) {  // Cambié el tipo a Cliente
        Nodo nuevo = new Nodo(cliente);  // Aquí también cambiamos el valor a Cliente
        if (this.estavacia()) {
            this.primero = nuevo;
            this.ultimo = nuevo;
            return true;
        }
        this.ultimo.setSiguiente(nuevo);
        this.ultimo = nuevo;
        return true;
    }

    public Object eliminar() throws Exception {
        if (this.estavacia()) {
            throw new Exception("cola vacia");
        }
        Object AuxValor = primero.getValor();
        this.primero = this.primero.getSiguiente();
        return AuxValor;
    }

    public Object verprimero() throws Exception {
        if (this.estavacia()) {
            throw new Exception("cola vacia");
        }
        return this.primero.getValor();
    }
}

