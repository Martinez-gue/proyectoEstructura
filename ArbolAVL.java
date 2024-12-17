public class ArbolAVL{
    private NodoAVL raiz;
    public ArbolAVL() {
        this.raiz=null;
    }
    public boolean estaVacio() {
        return raiz == null;
    }
    public void InsertarPorNombre(producto valor) {
        this.raiz = GenerarNodoPorNombre(valor, raiz);
    }
    private NodoAVL GenerarNodoPorNombre(producto valor, NodoAVL nodo) {
        if (nodo == null) {
            return new NodoAVL(valor); 
        }
        if (valor.compareNombre((producto) nodo.getDato()) < 0) {
            nodo.setIzq(GenerarNodoPorNombre(valor, nodo.getIzq())); 
        } 
        if (valor.compareNombre((producto) nodo.getDato()) > 0) {
            nodo.setDer(GenerarNodoPorNombre(valor, nodo.getDer())); 
        }
        int nuevaAltura = 1 + Math.max(DetAltura(nodo.getIzq()), DetAltura(nodo.getDer()));
        nodo.setAltura(nuevaAltura);
        int balance = DetAltura(nodo.getDer()) - DetAltura(nodo.getIzq());
        if (balance >= 2) {
            if (valor.compareNombre((producto) nodo.getDer().getDato()) > 0) {
                nodo = RotacionIzq(nodo); 
            } else {
                nodo = RotacionIzqDer(nodo); 
            }
        } else if (balance == -2) {
            if (valor.compareNombre((producto) nodo.getIzq().getDato()) < 0) {
                nodo = RotacionDer(nodo); 
            } else {
            nodo = RotacionDerIzq(nodo); 
            }
        }
        return nodo;
    }
    public void InsertarPorPrecio(producto valor) {
        this.raiz = GenerarNodoPorPrecio(valor, raiz);
    }

    private NodoAVL GenerarNodoPorPrecio(producto valor, NodoAVL nodo) {
        if (nodo == null) {
            return new NodoAVL(valor); 
        }
        if (valor.comparePrecio((producto) nodo.getDato()) < 0) {
            nodo.setIzq(GenerarNodoPorPrecio(valor, nodo.getIzq())); 
        } 
        if (valor.comparePrecio((producto) nodo.getDato()) > 0) {
            nodo.setDer(GenerarNodoPorPrecio(valor, nodo.getDer())); 
        }
        int nuevaAltura = 1 + Math.max(DetAltura(nodo.getIzq()), DetAltura(nodo.getDer()));
        nodo.setAltura(nuevaAltura);
        int balance = DetAltura(nodo.getDer()) - DetAltura(nodo.getIzq());
        if (balance >= 2) {
            if (valor.comparePrecio((producto) nodo.getDer().getDato()) > 0) {
                nodo = RotacionIzq(nodo); 
            } else {
                nodo = RotacionIzqDer(nodo); 
            }
        } else if (balance == -2) {
            if (valor.comparePrecio((producto) nodo.getIzq().getDato()) < 0) {
                nodo = RotacionDer(nodo); 
            } else {
            nodo = RotacionDerIzq(nodo); 
            }
        }
        return nodo;
    }
    private NodoAVL RotacionIzq(NodoAVL x){
        NodoAVL y=x.getDer();
        NodoAVL z=y.getIzq();
        y.setIzq(x);
        x.setDer(z);  
        int Alturax=1+Math.max(DetAltura(x.getIzq()),DetAltura(x.getDer()));
        x.setAltura(Alturax);
        int balancex = DetAltura(x.getDer()) - DetAltura(x.getIzq());  
        int Alturay=1+Math.max(DetAltura(y.getIzq()),DetAltura(y.getDer()));
        y.setAltura(Alturay);
        int balancey = DetAltura(y.getDer()) - DetAltura(y.getIzq());
        return y;     
    } 
    private NodoAVL RotacionDer(NodoAVL y) {
        NodoAVL x = y.getIzq();  
        NodoAVL z = x.getDer();      
        x.setDer(y);  
        y.setIzq(z);  
        int Alturay = 1 + Math.max(DetAltura(y.getIzq()), DetAltura(y.getDer()));
        y.setAltura(Alturay);
        int balancey = DetAltura(y.getDer()) - DetAltura(y.getIzq());
        int Alturax = 1 + Math.max(DetAltura(x.getIzq()), DetAltura(x.getDer()));
        x.setAltura(Alturax);
        int balancex = DetAltura(x.getDer()) - DetAltura(x.getIzq());
        return x;
    }
    private NodoAVL RotacionIzqDer(NodoAVL nodo) {
        nodo.setDer(RotacionDer(nodo.getDer()));  
        return RotacionIzq(nodo);  
    } 
    private NodoAVL RotacionDerIzq(NodoAVL nodo) {
        nodo.setIzq(RotacionIzq(nodo.getIzq()));  
        return RotacionDer(nodo);  
    }
    private int DetAltura(NodoAVL nodo){
        if(nodo==null)
            return 0;   
        return nodo.getAltura();
    }
    public boolean BuscarProductoPorPrecio(long valor){
        return BuscarValorD(valor,raiz);
    }
    private boolean BuscarValorD(long valor, NodoAVL nodo) {
        if (nodo == null) {
            return false;
        }
        double PrecioProducto = ((producto) nodo.getDato()).getPrecio();
        if (PrecioProducto==valor) {
            return true;
        }
        if (valor<PrecioProducto ){
            return BuscarValorD(valor, nodo.getIzq());
        }
        return BuscarValorD(valor, nodo.getDer());
    }
    public boolean BuscarProductoPorNombre(String valor) {
        int contador=0;
        return BuscarValorN(valor, raiz,contador);  
        
    }
    private boolean BuscarValorN(String valor, NodoAVL nodo, int contador) {
        if (nodo == null) {
            return false;  
        }
        String nombreProducto = ((producto) nodo.getDato()).getNombre();
        if (compararNombreProducto(valor, nombreProducto)) {
            return true;  
        }
        if (valor.compareTo(nombreProducto) < 0) {
            return BuscarValorN(valor, nodo.getIzq(),contador);
        }
        return BuscarValorN(valor, nodo.getDer(),contador);
    }
    private boolean compararNombreProducto(String valor, String nombreCancion) {
        valor = normalizarString(valor);
        nombreCancion = normalizarString(nombreCancion);
        if (valor.length() != nombreCancion.length()) {
            return false;
        }
        for (int i = 0; i < valor.length(); i++) {
            if (valor.charAt(i) != nombreCancion.charAt(i)) {
                return false;  
            }
        }
        return true;
    }
    private String normalizarString(String texto) {
        return texto.trim().replaceAll("\\s+", " ").toLowerCase();  
    }   
    public int BuscarProductoPorNombreCalcularNodos(String valor) {
        return BuscarValorNCalcularNodos(valor, raiz, 0);  
    }
    private int BuscarValorNCalcularNodos(String valor, NodoAVL nodo, int contador) {
        if (nodo == null) {
            return 0;  
        }
        contador++;
        String nombreCancion = ((producto) nodo.getDato()).getNombre();
        if (compararNombreProducto(valor, nombreCancion)) {
            return contador;  
        }
        if (valor.compareTo(nombreCancion) < 0) {
            return BuscarValorNCalcularNodos(valor, nodo.getIzq(), contador);  
        }
        return BuscarValorNCalcularNodos(valor, nodo.getDer(), contador);  
    }
    public int BuscarProductoPorDuracionCalcularNodos(long valor){
        return BuscarValorDCalcularNodos(valor,raiz,0);
    }
    private int BuscarValorDCalcularNodos(long valor, NodoAVL nodo,int contador) {
        if (nodo == null) {
            return 0;
        }
        contador++;
        double precioProducto = ((producto) nodo.getDato()).getPrecio();
        if (precioProducto==valor) {
            return contador;
        }
        if (valor<precioProducto ){
            return BuscarValorDCalcularNodos(valor, nodo.getIzq(),contador);
        }
        return BuscarValorDCalcularNodos(valor, nodo.getDer(),contador);
    }
    public void ImprimirEnOrden() {
        imprimirEnOrdenDescendenteConRetraso(raiz);  
    }

    public void imprimirEnOrdenDescendenteConRetraso(NodoAVL nodo) {
        if (nodo != null) {
            imprimirEnOrdenDescendenteConRetraso(nodo.getDer()); 
            System.out.println(nodo.getDato());  
            imprimirEnOrdenDescendenteConRetraso(nodo.getIzq()); 
        }
    }
    public void EliminarPorNombre(producto valor) {
        this.raiz = EliminarPorNombre(valor, raiz);
    }
    private NodoAVL EliminarPorNombre(producto valor, NodoAVL nodo) {
        if (nodo == null) {
            return null; 
        }
        if (valor.compareNombre((producto) nodo.getDato()) < 0) {
            nodo.setIzq(EliminarPorNombre(valor, nodo.getIzq()));
        }
        else if (valor.compareNombre((producto) nodo.getDato()) > 0) {
            nodo.setDer(EliminarPorNombre(valor, nodo.getDer()));
        }
        else {
            if (nodo.getIzq() == null && nodo.getDer() == null) {
                nodo = null;  
            }
            else if (nodo.getIzq() == null) {
                nodo = nodo.getDer();  
            }
            else if (nodo.getDer() == null) {
                nodo = nodo.getIzq();  
            }
            else {
                NodoAVL nodoMinimo = EncontrarMinimo(nodo.getDer());
                nodo.setDato(nodoMinimo.getDato());  
                nodo.setDer(EliminarPorNombre((producto) nodoMinimo.getDato(), nodo.getDer()));
            }
        }
        if (nodo != null) {
            int nuevaAltura = 1 + Math.max(DetAltura(nodo.getIzq()), DetAltura(nodo.getDer()));
            nodo.setAltura(nuevaAltura);
            int balance = DetAltura(nodo.getDer()) - DetAltura(nodo.getIzq());
            if (balance >= 2) {
                if (DetAltura(nodo.getDer().getDer()) >= DetAltura(nodo.getDer().getIzq())) {
                    nodo = RotacionIzq(nodo); 
                } else {
                    nodo = RotacionIzqDer(nodo); 
                }
            } else if (balance == -2) {
                if (DetAltura(nodo.getIzq().getIzq()) >= DetAltura(nodo.getIzq().getDer())) {
                    nodo = RotacionDer(nodo); 
                } else {
                    nodo = RotacionDerIzq(nodo); 
                }
            }
        }
        return nodo;  
    }
    private NodoAVL EncontrarMinimo(NodoAVL nodo) {
        while (nodo.getIzq() != null) {
            nodo = nodo.getIzq();
        }
        return nodo;
    }
    public void EliminarPorPrecio(long duracion) {
        this.raiz = EliminarNodoPorDuracion(raiz, duracion);
    }
    private NodoAVL EliminarNodoPorDuracion(NodoAVL nodo, long duracion) {
        if (nodo == null) {
            return null;  
        }
        if (duracion < ((producto) nodo.getDato()).getPrecio()) {
            nodo.setIzq(EliminarNodoPorDuracion(nodo.getIzq(), duracion));
        } else if (duracion > ((producto) nodo.getDato()).getPrecio()) {
            nodo.setDer(EliminarNodoPorDuracion(nodo.getDer(), duracion));
        } else {
            if (nodo.getIzq() == null && nodo.getDer() == null) {
                return null; 
            } else if (nodo.getIzq() == null) {
                return nodo.getDer();  
            } else if (nodo.getDer() == null) {
                return nodo.getIzq();  
            } else {
                NodoAVL nodoMinimo = EncontrarMinimo(nodo.getDer());
                nodo.setDato(nodoMinimo.getDato());
                nodo.setDer(EliminarNodoPorDuracion(nodo.getDer(), ((producto) nodoMinimo.getDato()).getPrecio()));
            }
        }
        int nuevaAltura = 1 + Math.max(DetAltura(nodo.getIzq()), DetAltura(nodo.getDer()));
        nodo.setAltura(nuevaAltura);
        return balancear(nodo);
    }
    private NodoAVL balancear(NodoAVL nodo) {
        int balance = DetAltura(nodo.getDer()) - DetAltura(nodo.getIzq());
        if (balance >= 2) {
            if (DetAltura(nodo.getDer().getDer()) > DetAltura(nodo.getDer().getIzq())) {
                return RotacionIzq(nodo);  
            } else {
                return RotacionIzqDer(nodo);  
            }
        }
        if (balance <= -2) {
            if (DetAltura(nodo.getIzq().getIzq()) > DetAltura(nodo.getIzq().getDer())) {
                return RotacionDer(nodo);  
            } else {
                return RotacionDerIzq(nodo);  
            }
        }
        return nodo;  
    }
    public void EliminarPorPrecio(producto cancion) {
        this.raiz = EliminarPorDuracionRecursivo(cancion, raiz);
    }
    private NodoAVL EliminarPorDuracionRecursivo(producto cancion, NodoAVL nodo) {
        if (nodo == null) {
            return null;
        }
        if (cancion.getPrecio() < ((producto) nodo.getDato()).getPrecio()) {
            nodo.setIzq(EliminarPorDuracionRecursivo(cancion, nodo.getIzq()));
        } else if (cancion.getPrecio() > ((producto) nodo.getDato()).getPrecio()) {
            nodo.setDer(EliminarPorDuracionRecursivo(cancion, nodo.getDer()));
        } else {
            if (nodo.getIzq() == null && nodo.getDer() == null) {
                return null;
            }
            if (nodo.getIzq() == null) {
                return nodo.getDer();
            } else if (nodo.getDer() == null) {
                return nodo.getIzq();
            }
            NodoAVL sucesor = obtenerMinimo(nodo.getDer());
            nodo.setDato(sucesor.getDato());  
            nodo.setDer(EliminarPorDuracionRecursivo((producto) sucesor.getDato(), nodo.getDer()));  
        }
        int nuevaAltura = 1 + Math.max(DetAltura(nodo.getIzq()), DetAltura(nodo.getDer()));
        nodo.setAltura(nuevaAltura);
        return balancear(nodo);
    }
    public NodoAVL obtenerMinimo(NodoAVL nodo) {
        while (nodo.getIzq() != null) {
            nodo = nodo.getIzq();
        }
        return nodo;
    }  

}
