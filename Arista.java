public class Arista {
    private Object destino;  
    private float peso;      
    private Arista siguiente;  

    // Constructor con destino y peso
    public Arista(Object destino, float peso) {
        this.destino = destino;
        this.peso = peso;
        this.siguiente = null;  
    }

    public Arista(Object destino) {
        this(destino, 0);  
    }
    public Object getDestino() {
        return destino;
    }
    public Arista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Arista siguiente) {
        this.siguiente = siguiente;
    }
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    @Override
    public String toString() {
        return destino.toString() + " (peso: " + peso + ")";  
    }
}

