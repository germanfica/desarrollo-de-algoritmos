package xyz.germanfica.ad._2018._1st.ordenamiento;

import java.util.Scanner;

import xyz.germanfica.ad.util.Archivo;

public class Entrega {
    private static final String NOMBRE_ARCHIVO = "src/com/graworg/ad/_2018/entrega/ordenamiento/arreglo.txt"; // Ruta del archivo
	private static final int tamArrgelo = 9;
	private static Scanner sc;
	
	/**
	 * (1) Metodo de insercion
	 * 
	 * @param arreglo
	 */
	public static int[] insercion(int[] arreglo) {
		// Declaracion de variables
		int auxiliar, j;
		
		// Recorrer el arreglo
		for(int i=1;i<=arreglo.length-1;i++) {
			// Reubicar los elementos
			auxiliar = arreglo[i];
			j = i;
			
			// Recorrer el arreglo
			while(j>0 && auxiliar<arreglo[j-1]) {
				// Hacer el corrimiento
				arreglo[j] = arreglo[j-1];
				j--;
			}
			
			arreglo[j] = auxiliar;
		}
		
		return arreglo;
	}
	
	/**
	 * (2) Metodo de seleccion
	 * 
	 * @return
	 */
	public static int[] seleccion(int[] arreglo) {
		// Declaracion de las variables
		int posicionDelMenor, auxiliar;
	
		// Recorrer el arreglo para ordenar los elementos uno a uno
		// n es la longitud del arreglo
		for(int i=0;i<=arreglo.length-1;i++) {
			// Buscar el número mas pequeño  desde i hasta la longitud del arreglo y guardar su índice
			posicionDelMenor = i;
			
			// Recorrer el arreglo en busca del índice del elemento del mismo
			for(int j=i+1;j<=arreglo.length-1;j++) {
				// Si existe un elemento mas pequeño guardar su índce
				if(arreglo[j] < arreglo[posicionDelMenor]) {
					// Se encontro un elemento mas pequeño aún
					posicionDelMenor = j;
				}
			}
	
			// Almacenar el elemento de la posicon i
			auxiliar = arreglo[i];
			// Intercambiar las posiciones
			arreglo[i] = arreglo[posicionDelMenor];
			arreglo[posicionDelMenor] = auxiliar;
		}
		
		return arreglo;
	}
	
	public static void mostrarElementos(int[] arreglo) {
		// Declaracion de variables
		int i;
		
		// Inicializacion de variables
		i = 0;
		
		while(i<=arreglo.length-1) {
			System.out.println(arreglo[i]);
			i++;
		}
	}
	
	public static int[] cargaDesdeArchivo(String ruta, int longitud) {
		int[] arreglo = new int[longitud];
		String contenidoDelArchivo = Archivo.leer(ruta);
		
		sc = new Scanner(contenidoDelArchivo); // Asignacion de tarea al scanner para analizar el contenido del archivo
		
		sc.useDelimiter("\\s*,\\s*"); // Esto clasifica los colores cuando se encuntra una coma
		
		int i = 0;
		
		// Objetivo: almacenar los colores de a uno por uno
		while(sc.hasNext()) {
			arreglo[i] = sc.nextInt();
			i=i+1;
		}
		
		return arreglo;
	}
	
	/**
	 * Mostrar menú de opciones
	 */
	public static void mostrarMenú() {
		// Declaracion de las variables
		int[] arreglo;
		boolean salir;
		int opcion;
		
		// Inicializacion de las variables
		salir = false;
		arreglo = cargaDesdeArchivo(NOMBRE_ARCHIVO, tamArrgelo);
		
		System.out.println("Bienvenido a la consola de la aplicacion");
		
		while(!salir)
		{
			sc = new Scanner(System.in);
			
			// Mostrar el cartel de las opciones
			System.out.print(
					"[0] Salir (IMPLEMENTADO)\n" +
					"[1] Aplicar el método de insercion (IMPLEMENTADO)\n" +
					"[2] Aplicar el método seleccion (IMPLEMENTADO)\n"
					);
			
			// Leer opcion para el menú principal
			opcion = sc.nextInt();
			
			switch (opcion) {
			case 0:
				salir = true;
				break;
			case 1:
				arreglo = insercion(arreglo);
				mostrarElementos(arreglo);
				break;
			case 2:
				arreglo = seleccion(arreglo);
				mostrarElementos(arreglo);
				break;			
			default:
				System.err.println("Esta opcion no esta definida. Seleccione una de las siguientes opciones: ");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		mostrarMenú();
	}
}
