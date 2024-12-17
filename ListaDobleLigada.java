public class ListaDobleLigada {
    private NodoDoble primero;
    private NodoDoble ultimo;

    public ListaDobleLigada() {
        this.primero=null;
        this.ultimo=null;
    }
    
    public boolean estavacia(){
        return this.primero==null && this.ultimo==null;
    }
    
    public boolean AgregarInicio(producto valor){
        NodoDoble nuevo = new NodoDoble(valor); 
        if(this.estavacia()){
            this.primero=nuevo;
            this.ultimo=nuevo;
            return true;
        }
        nuevo.setSiguiente(primero);
        primero.setAnterior(nuevo);
        primero=nuevo;
        return true;       
    }
    
    public boolean AgregarFin(producto valor){
        NodoDoble nuevo = new NodoDoble(valor);
        if(this.estavacia()){
            this.primero=nuevo;
            this.ultimo=nuevo;
            return true;
        }
        this.ultimo.setSiguiente(nuevo);
        nuevo.setAnterior(ultimo);
        this.ultimo=nuevo;
        return true;
    }
        public producto EliminarInicio() throws Exception {
    // Verificar si la lista está vacía
    if (this.estavacia()) {
        throw new Exception("Lista vacía");
    }

    // Obtener el primer producto
    producto Aux = (producto) this.primero.getDato();

    // Si hay solo un nodo (el primero no tiene siguiente)
    if (this.primero.getSiguiente() == null) {
        this.primero = null; // La lista queda vacía
    } else {
        // Si hay más de un nodo, actualizar el puntero 'primero'
        this.primero = this.primero.getSiguiente();
        this.primero.setAnterior(null);  // El nuevo primer nodo no tiene nodo anterior
    }

    return Aux;  // Retornamos el producto eliminado
}

    
    public producto EliminarFin() throws Exception {
    // Verificar si la lista está vacía
    if (this.estavacia()) {
        throw new Exception("Lista vacía");
    }

    // Obtener el último producto
    producto Aux = (producto) this.ultimo.getDato();

    // Caso cuando hay solo un nodo
    if (this.ultimo.getAnterior() == null) {
        // La lista queda vacía
        this.primero = null;  // El primer nodo se convierte en null
        this.ultimo = null;   // El último nodo se convierte en null
    } else {
        // Si hay más de un nodo, actualizamos el puntero 'ultimo'
        this.ultimo = this.ultimo.getAnterior();
        this.ultimo.setSiguiente(null);  // El nuevo último nodo no tiene siguiente
    }

    return Aux;  // Retornamos el producto eliminado
}
    public String toString() {
        NodoDoble iteradorinicio=primero;
        String salida="";
        while(iteradorinicio!=null ){
            salida+="-"+iteradorinicio.getDato();
            iteradorinicio=iteradorinicio.getSiguiente();
        }
        return salida;
    }
    public void imprimir() {
    NodoDoble iteradorInicio = primero;  // Comienza desde el primer nodo de la lista
    while (iteradorInicio != null) {     // Mientras haya un nodo en la lista
        // Se imprime el dato del nodo, casteándolo a 'producto'
        System.out.print(iteradorInicio.getDato() + "\n ");  
        
        iteradorInicio = iteradorInicio.getSiguiente();  // Avanza al siguiente nodo
    }
    System.out.println();  // Salto de línea al final de la impresión
    }   

    public void imprimirAlrrevez(){
        NodoDoble iteradorfinal=ultimo;
        while(iteradorfinal!=null){
            System.out.print(iteradorfinal.getDato()+" ");
            iteradorfinal=iteradorfinal.getAnterior();
        }
        System.out.println();
    }
    public void imprimirRnormal(){
        imprimirRecursion(primero);
    }
    private void imprimirRecursion(NodoDoble iterador){
        if(iterador==null){
            return;
        }
        System.out.print(iterador.getDato()+" ");
        imprimirRecursion(iterador.getSiguiente());
    }
    public void imprimirRalrrevez(){
        imprimirRecursionAlrevez(ultimo);
    }
    private void imprimirRecursionAlrevez(NodoDoble iterador){
        if(iterador==null){
            return;
        }
        System.out.print(iterador.getDato()+" ");
        imprimirRecursionAlrevez(iterador.getAnterior());      
    }
    public int tam(){
        int cont=0;
        NodoDoble ite=primero;
        while(ite!=null){
            cont++;
            ite=ite.getSiguiente();            
        }
        return cont;
    }

    
    public NodoDoble EncontrarNodoAnterior(int post){
        post--;
        NodoDoble Aux=primero;
        int cont=0;
        while(post!=cont){
            cont++;
            Aux=Aux.getSiguiente();
        }
        return Aux;
    }
    public NodoDoble EncontrarNodoSiguiente(int post){
        NodoDoble Aux=primero;
        int cont=0;
        while(post!=cont){
            cont++;
            Aux=Aux.getSiguiente();
        }
        return Aux;        
        
    }
    
    
}




