class NodoDoble {
    private Object dato;  
    private NodoDoble siguiente;  
    private NodoDoble anterior;   

    public NodoDoble(Object dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public Object getDato() {
        return this.dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoDoble getSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return this.anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
}

