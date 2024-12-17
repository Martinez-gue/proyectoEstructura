public class Nodo {
    private Object valor;
    private Nodo siguiente;
    public Nodo(Object valor){
        this.valor=valor;
        this.siguiente=null;
    }

    public Object getValor() {
        return valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
   
}