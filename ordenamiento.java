public class ordenamiento{
    public static void quicksortt(producto[] productos, int inicio, int fin) {
    if (inicio < fin) {  // Asegurarse de que haya al menos dos elementos a ordenar
        int posD = particionar(productos, inicio, fin);
        quicksortt(productos, inicio, posD - 1);  // Ordenar la sublista izquierda
        quicksortt(productos, posD + 1, fin);    // Ordenar la sublista derecha
    }
}

private static int particionar(producto[] productos, int inicio, int fin) {
    long pivote = productos[(inicio + fin) / 2].getPrecio(); // Elegimos el pivote como el precio del medio
    int posI = inicio;
    int posD = fin;

    while (posI <= posD) {
        // Mover posI hacia la derecha hasta encontrar un precio mayor o igual al pivote
        while (productos[posI].getPrecio() < pivote) {
            posI++;
        }

        // Mover posD hacia la izquierda hasta encontrar un precio menor o igual al pivote
        while (productos[posD].getPrecio() > pivote) {
            posD--;
        }

        // Si posI es menor o igual a posD, intercambiar los productos
        if (posI <= posD) {
            intercambiar(productos, posI, posD);
            posI++;
            posD--;
        }
    }

    return posI; // posI ahora es la posición donde se debe dividir el arreglo
}

private static void intercambiar(producto[] productos, int posI, int posD) {
    producto aux = productos[posI];
    productos[posI] = productos[posD];
    productos[posD] = aux;
}
public static void burbuja(producto[] productos) {
    int n = productos.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - 1 - i; j++) {
            // Comparar precios de productos[j] y productos[j+1]
            if (productos[j].getPrecio() > productos[j + 1].getPrecio()) {
                // Si el precio de productos[j] es mayor que productos[j+1], intercambiar
                intercambiar(productos, j, j + 1);
            }
        }
    }
}





    
}