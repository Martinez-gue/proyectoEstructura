public class PilaDinamica {
    private Nodo tope;
    public PilaDinamica(){
        this.tope=null;
    }
    public boolean estavacia(){
        return this.tope==null;
    }
    public boolean push(producto valor){
        if(estavacia()){
            Nodo n=new Nodo(valor);
            tope=n;
            return true;
        }else{
            Nodo n=new Nodo(valor);
            n.setSiguiente(tope);
            tope=n;
            return true;
        }
    }
    public Object pop() throws Exception{
        if(estavacia()){
            throw new Exception("pila vacia");
        }
        Object valor=tope.getValor();
        this.tope=this.tope.getSiguiente();
        return valor;
    }
    
    
}
