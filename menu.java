import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class menu
{
    public static void main (String [] Args)throws Exception{
        ordenamiento ord =new ordenamiento();
        Scanner scanner=new Scanner(System.in);
        ArbolAVL arbol = new ArbolAVL();
        ArbolAVL arbol2 = new ArbolAVL();
        ListaDobleLigada ventas = new ListaDobleLigada();
        leerArchivoCSVYAgregarAlArbolPorNombre("productos_audio.csv", arbol);
        leerArchivoCSVYAgregarAlArbolPorDuracion("productos_audio.csv", arbol2);
        producto[] arr=new producto[2000];
        ColaClientes colaClientes = new ColaClientes();
        Grafo grafo=new Grafo();
        leerArchivoCSVYAgregarAArreglo("productos_audio.csv", arr);
        int opc=0;
        while(opc!=-1){

            System.out.println(" \n 1.-Buscar producto por nombre \n 2.-Buscar producto por precio "
            + "\n 3.-Ordenar productos por nombre \n 4.-Ordenar productos por precio \n 5.-Agregar nuevo producto" 
            +"\n 6.-Eliminar producto del inventario \n___________________________ \n 7.-Crear lista ventas \n 8.eliminar productos de la lista \n"
            +" 9.Imprimir lista de ventas \n ___________________________ \n 10.-Ordenar productos  quicksort \n"
            +" 11.-Ordenar productos Burbuja \n ___________________________ \n 12.- Registrar un nuevo pedido \n 13.-Ver pedidos registrados \n"
            +"___________________________ \n 14.-Registrar un cliente en el grafo \n 15.-Agregar un producto a un cliente \n"
            +" 16.-Mostrar clientes y productos \n");
            opc=scanner.nextInt();
            switch(opc){
                case 1:
                    if(arbol.estaVacio()){
                            System.out.println("el arbol esta vacio!");
                    }
                    if(!arbol.estaVacio()){
                        scanner.nextLine();
                        System.out.println("Ingresa el nombre del producto...");
                        String cadena = scanner.nextLine();  
                        if(arbol.BuscarProductoPorNombre(cadena)){
                            long tiempoinicial = System.nanoTime();
                            arbol.BuscarProductoPorNombre(cadena);
                            long tiempofinal = System.nanoTime();
                            long duracion = tiempofinal - tiempoinicial;
                            System.out.println("Se encontro el producto!..."+ " El tiempo de busqueda fue: " + duracion + " Ns" + 
                            "Se recorrieron " + arbol.BuscarProductoPorNombreCalcularNodos(cadena)+" nodos");
                        } else {
                            System.out.println("No se encontró el producto.");
                        }
                    }
                    break;
                case 2:
                    if(arbol.estaVacio()){
                        System.out.println("el arbol esta vacio!");
                    }
                    if(!arbol.estaVacio()){
                        scanner.nextLine();
                        System.out.println("Ingresa el precio del producto...");
                        long a = scanner.nextLong();  
                        scanner.nextLine();  
                        if(arbol2.BuscarProductoPorPrecio(a)){
                            long tiempoinicial = System.nanoTime();
                            arbol2.BuscarProductoPorPrecio(a);
                            long tiempofinal = System.nanoTime();
                            long duracion = tiempofinal - tiempoinicial;
                            System.out.println("Se encontro el producto!..."+ " el tiempo de busqueda fue: " + duracion + " Ns" + 
                            " Se recorrieron " + arbol2.BuscarProductoPorDuracionCalcularNodos(a)+"nodos");
                        } else {
                            System.out.println("No se encontró el producto.");
                        }
                    }
                    break;
                case 3:
                    arbol.ImprimirEnOrden();
                    break;
                case 4:
                    arbol2.ImprimirEnOrden();
                    break;
                case 5: 
                    scanner.nextLine();
                    System.out.println("Ingresa el nombre de el producto!...");
                    String nombre = scanner.nextLine().trim();  
                    System.out.println("Ingresa la marca del producto!...");
                    String album = scanner.nextLine();  
                    System.out.println("Ingresa el codigo del producto!...");
                    String artista = scanner.nextLine();  
                    long duracion = 0;
                    boolean validDuration = false;
                    while (!validDuration) {
                        System.out.println("Ingresa el precio del producto!...");
                        if (scanner.hasNextLong()) {
                            duracion = scanner.nextLong();  
                            validDuration = true;  
                        } else {
                            System.out.println("Por favor, ingresa un precio valido.");
                            scanner.next();  
                        }
                    }
                    scanner.nextLine();  
                    producto nuevoProducto = new producto(nombre, album, artista, duracion);
                    System.out.println("Producto creado: " + nuevoProducto.nombre + " de marca " + nuevoProducto.marca + 
                    " de " + nuevoProducto.codigo + " con precio de " + nuevoProducto.precio + " $");
                    arbol.InsertarPorNombre(nuevoProducto);
                    arbol2.InsertarPorPrecio(nuevoProducto); 
                    break;
                case 6:
                    System.out.println("Cómo deseas eliminar el producto?");
                    System.out.println("1.- Por nombre");
                    System.out.println("2.- Por precio");
                    int opcionEliminar = scanner.nextInt();
                    scanner.nextLine(); 
                    if (opcionEliminar == 1) {
                        System.out.println("Ingresa el nombre del producto que deseas eliminar:");
                        String nombreCancion = scanner.nextLine();
                        producto p1 = new producto(nombreCancion, "", "", 0);  
                        arbol.EliminarPorNombre(p1);
                        arbol2.EliminarPorNombre(p1); 
                        System.out.println("El producto " + nombreCancion + " fue eliminado");
                    } else if (opcionEliminar == 2) {
                        System.out.println("Ingresa el precio del producto que deseas eliminar:");
                        long duracionCancion = scanner.nextLong();
                        producto p2 = new producto("", "", "", duracionCancion);  
                        arbol.EliminarPorPrecio(p2);
                        arbol2.EliminarPorPrecio(p2); 
                        System.out.println("El producto con precio de " + duracionCancion + " $ fue eliminado de ambos árboles.");
                    } else {
                            System.out.println("Opción inválida.");
                    }
                    break; 
                case 7:
                    int valesi = 0;
                    scanner.nextLine();
                    do {
                        System.out.println("Ingresa el nombre de el producto!..."); 
                        String nombrel = scanner.nextLine().trim();
                        System.out.println("Ingresa la marca del producto!...");
                        String albuml = scanner.nextLine();  
                        System.out.println("Ingresa el codigo del producto!...");
                        String artistal = scanner.nextLine();  
                        long duracionl = 0;
                        boolean validDurationl = false;
        
                        while (!validDurationl) {
                            System.out.println("Ingresa el precio del producto!...");
                            if (scanner.hasNextLong()) {
                                duracionl = scanner.nextLong();  
                                validDurationl = true;  
                            } else {
                                System.out.println("Por favor, ingresa un precio valido.");
                                scanner.next();  
                            }
                        }
                        scanner.nextLine();  
                        producto nuevoProductol = new producto(nombrel, albuml, artistal, duracionl);
                        System.out.println("Producto creado: " + nuevoProductol.nombre + " de marca " + nuevoProductol.marca + 
                        " de " + nuevoProductol.codigo + " con precio de " + nuevoProductol.precio + " $"); 
        
                        System.out.println("Cómo deseas Agregar el producto a la lista?");
                        System.out.println("1.- Agregar al inicio");
                        System.out.println("2.- Agregar al final");
                        int opcionlistaventas = scanner.nextInt();
                        scanner.nextLine();  
                        if (opcionlistaventas == 1) {
                            ventas.AgregarInicio(nuevoProductol);  
                            System.out.println("Se agrega correctamente al inicio");
                        } else if (opcionlistaventas == 2) {
                            ventas.AgregarFin(nuevoProductol);  
                            System.out.println("Se agrega correctamente al final");
                        }

                        
                        System.out.println("Desea seguir agregando datos? \n 1.-Seguir Agregando \n 2.-Salir ");
                        valesi = scanner.nextInt();
                        scanner.nextLine();  
                    } while (valesi != 2); 
    
                          break;

                case 8:
                    
                    scanner.nextLine(); 
                    System.out.println("¿Deseas eliminar un producto?");
                    System.out.println("1. Eliminar al inicio");
                    System.out.println("2. Eliminar al final");
                    int opcionEliminar12 = scanner.nextInt();
                    scanner.nextLine(); 

                    if (opcionEliminar12 == 1) {                    
                        if (ventas.estavacia()) {
                                System.out.println("La lista está vacía, no se puede eliminar.");
                        } else {
                                System.out.println("Se eliminó el producto al inicio.");
                    }
                    } else if (opcionEliminar12 == 2) {
                        if (ventas.estavacia()) {
                            System.out.println("La lista está vacía, no se puede eliminar.");
                        } else {
                            ventas.EliminarFin();
                            System.out.println("Se eliminó el producto al final.");
                
                            }
                    } else {
                        System.out.println("Opción no válida.");
                    }
    
                        break;
                case 9:
                    if(ventas.estavacia()){
                        System.out.println("La lista esta vacia");
                    }
                    if(!ventas.estavacia()){
                        ventas.imprimir();
                    }
                        break;
                case 10:

                    long startTime = System.nanoTime();

                    ord.quicksortt(arr, 0, arr.length - 1);

                    
                    long endTime = System.nanoTime();

                    long durationInNs = endTime - startTime;
                    double durationInMs = durationInNs / 1_000_000.0;

                    for(int i=0;i<arr.length;i++){
                        System.out.println(arr[i]);
                    }
                    System.out.println("Tiempo de ejecución del quicksortt: " + durationInMs + " Ms");
                    
                        break;
                case 11:
                           
                     startTime = System.nanoTime();

                    
                    ord.burbuja(arr);

                    
                     endTime = System.nanoTime();

                    
                     durationInNs = endTime - startTime;
                     durationInMs = durationInNs / 1_000_000.0;

                    for(int i=0;i<arr.length;i++){
                        System.out.println(arr[i]);
                    }
                    System.out.println("Tiempo de ejecución Metodo Burbuja: " + durationInMs + " Ms");
                            break;
                case 12:
                    scanner.nextLine(); 
                    System.out.println("Registrar un nuevo pedido:");
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    Cliente cliente = new Cliente(nombreCliente);
                    
                    boolean agregarProducto = true;
                    while (agregarProducto) {
                        System.out.println("Ingresa el nombre del producto: ");
                        String nombreProducto = scanner.nextLine().trim();
                        System.out.println("Ingresa la marca del producto: ");
                        String marcaProducto = scanner.nextLine();  
                        System.out.println("Ingresa el código del producto: ");
                        String codigoProducto = scanner.nextLine();  
                
                        long precioProducto = 0;
                        boolean validPrecio = false;
                
                        while (!validPrecio) {
                            System.out.println("Ingresa el precio del producto: ");
                            if (scanner.hasNextLong()) {
                                precioProducto = scanner.nextLong();  
                                validPrecio = true;  
                            } else {
                                System.out.println("Por favor, ingresa un precio válido.");
                                scanner.next();  
                            }
                        }
                        scanner.nextLine();  
                        
                        producto nuevoProducto123 = new producto(nombreProducto, marcaProducto, codigoProducto, precioProducto);
                        cliente.agregarProducto(nuevoProducto123);
                
                        
                        System.out.print("¿Desea agregar otro producto? (sí/no): ");
                        String respuesta = scanner.nextLine();
                        if (respuesta.equalsIgnoreCase("no")) {
                            agregarProducto = false;
                        }
                    }
                
                    
                    colaClientes.agregarCliente(cliente);
                    System.out.println("Cliente " + cliente.getNombre() + " registrado exitosamente.");
                    break;
                case 13:
                    System.out.println("\nPedidos registrados:");
                    colaClientes.procesarClientes();
                    break;
                case 14:
                    
                    scanner.nextLine();
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreClienteA = scanner.nextLine().trim(); 
                    
                    
                    Cliente cliente321 = new Cliente(nombreClienteA);
                    
                    
                    if (!grafo.registrarCliente(cliente321)) {
                        System.out.println("Error al registrar al cliente.");
                    } else {
                        System.out.println("Cliente registrado: " + nombreClienteA);
                    }
                    break;
                case 15:
                     
                    scanner.nextLine(); 
                    System.out.print("\n Ingrese el nombre del cliente:\n ");
                    String clienteNombre123 = scanner.nextLine().trim(); 
                
                    NodoGrafo clienteNodo = grafo.buscarNodo(clienteNombre123); 
                    if (clienteNodo == null) {
                        System.out.println("El cliente " + clienteNombre123 + " no existe en el sistema.");
                        break;
                    }
                
                    System.out.print("Ingresa el nombre del producto: ");
                    String nombreProducto = scanner.nextLine().trim();
                    System.out.print("Ingresa la marca del producto: ");
                    String marcaProducto = scanner.nextLine().trim();
                    System.out.print("Ingresa el código del producto: ");
                    String codigoProducto = scanner.nextLine().trim();
                
                    long precioProducto = 0;
                    boolean precioValido = false;
                    while (!precioValido) {
                        System.out.print("Ingresa el precio del producto: ");
                        if (scanner.hasNextLong()) {
                            precioProducto = scanner.nextLong();
                            if (precioProducto > 0) {  
                                precioValido = true;
                            } else {
                                System.out.println("El precio debe ser un número positivo.");
                            }
                        } else {
                            System.out.println("Por favor, ingresa un precio válido.");
                            scanner.next();  
                        }
                    }
                    scanner.nextLine();  
                
                    
                    producto nuevoProducto321 = new producto(nombreProducto, marcaProducto, codigoProducto, precioProducto);
                
                    
                    if (!grafo.agregarProductoACliente(clienteNombre123, nuevoProducto321)) {
                        System.out.println("Error al agregar el producto al cliente.");
                    } else {
                        System.out.println("Producto agregado exitosamente al cliente: " + clienteNombre123);
                    }
                    
                 
                    break;
                    case 16:

                    System.out.println("Clientes y sus productos:");
                    grafo.mostrarClientesYProductos();  
                    break;

            }
        }
    }  
        public static void leerArchivoCSVYAgregarAlArbolPorNombre(String archivo, ArbolAVL arbol) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",", -1); 
                String nombre = partes[0].replace("\"", "");
                String marca = partes[1].replace("\"", "");
                String cantidad = partes[2].replace("\"", "");
                long precio = Long.parseLong(partes[3]);
                producto cancion = new producto(nombre, marca, cantidad, precio);
                arbol.InsertarPorNombre(cancion);
            }
            System.out.println("se agregaron los productos al inventario por nombre!...");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir la duración: " + e.getMessage());
        }
    }
    public static void leerArchivoCSVYAgregarAlArbolPorDuracion(String archivo, ArbolAVL arbol) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",", -1); 
                if (partes.length != 4) {
                    System.out.println("Línea inválida: " + linea);
                    continue; 
                }
                String nombre = partes[0].replace("\"", "");
                String marca = partes[1].replace("\"", "");
                String cantidad = partes[2].replace("\"", "");
                long precio;
                try {
                    precio = Long.parseLong(partes[3]);  
                } catch (NumberFormatException e) {
                    System.out.println("Error al convertir la duración en la línea: " + linea);
                    continue; 
                }
                producto cancion = new producto(nombre, marca, cantidad, precio);
                arbol.InsertarPorPrecio(cancion);
            }
            System.out.println("se agregaron los productos al inventario por precio!...");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
    public static void leerArchivoCSVYAgregarAArreglo(String archivo, producto[] productos) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine();  // Lee y descarta la primera línea (encabezado)
            int index = 0;  // Variable para saber en qué posición estamos en el arreglo
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",", -1);  // -1 para que no se recorten los valores vacíos
                if (partes.length != 4) {
                    System.out.println("Línea inválida: " + linea);
                    continue;
                }

                String nombre = partes[0].replace("\"", "");
                String marca = partes[1].replace("\"", "");
                String cantidad = partes[2].replace("\"", "");
                long precio;

                try {
                    precio = Long.parseLong(partes[3].trim());  // Convertir precio a tipo long
                } catch (NumberFormatException e) {
                    System.out.println("Error al convertir el precio en la línea: " + linea);
                    continue;
                }

                // Crear un nuevo objeto Producto
                producto producto1 = new producto(nombre, marca, cantidad, precio);

                // Insertar el producto en el arreglo
                if (index < productos.length) {
                    productos[index] = producto1;  // Agregar producto al arreglo
                    index++;
                } else {
                    System.out.println("El arreglo está lleno, no se pueden agregar más productos.");
                    break;
                }
            }

            System.out.println("Se han agregado los productos al arreglo.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }

 

}

