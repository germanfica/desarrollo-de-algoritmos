package xyz.germanfica.util;

import java.util.Scanner;

/**
 * 
 * @author German Fica
 *
 */
public class MatrizEntero {
	private static Scanner sc;
	private static Scanner scFila;
	private static Scanner scColumna;
	
	/*
	 * Muestra todos los elementos de una matriz de enteros
	 */
	public static void mostrar(int[][] enteros) {
		// Declaraci�n de variables
		int cantFilas, cantColumnas;
		
		// Inicializaic�n de variables
		cantFilas = enteros.length;
		cantColumnas = enteros[0].length;
		for (int i = 0; i <= cantFilas-1; i++) {
			for (int j = 0; j <= cantColumnas-1; j++) {
				System.out.print(enteros[i][j]);
			}
			System.out.println();
		}
	}
	
	/*
	 * Se requiere para el m�dulo 'dimensiones(contenidoDelArchivo)'.
	 */
	private static int cantFilas(String contenidoFila) {
		// Declaraci�n de variables
		int cantFilas;
		
		// Inicializaci�n de variables
		cantFilas = 0;
		
		scFila = new Scanner(contenidoFila); // Le digo al scanner que me analice el contenido del archivo
		
		scFila.useDelimiter("\\s*,\\s*"); // Clasifica los elementos cuando encuntra una coma
		
		int i = 0;
		
		// Almacenar los elementos uno por uno
		while(scFila.hasNext()) {
			scFila.next(); // Importante, se debe llamar para verificar si hay un nuevo elemento en el contenido de la fila
			cantFilas++;
			i=i+1;
		}
		
		return cantFilas;
	}
	
	/*
	 * Determina las dimensiones debe tener la matriz de enteros
	 * con los elementos de un archivo dado
	 * 
	 * Se requiere para el m�dulo 'cargaDesdeArchivo(ARCHIVO)'.
	 */
	private static int[] dimensiones(String contenidoDelArchivo) {
		// Declaraci�n de variables
		int[] dimensiones;
		int cantFilas, cantColumnas, mayorCantFilas;
		String contenidoFila;
		
		// Inicializaci�n de variables
		dimensiones = new int[2];
		cantFilas = 0;
		cantColumnas = 0;
		mayorCantFilas = 0;
		
		scColumna = new Scanner(contenidoDelArchivo); // Le digo al scanner que me analice el contenido del archivo
		scColumna.useDelimiter("\\s*;\\s*"); // Clasifica los elementos cuando encuntra un punto y coma
		
		// Almacenar los elementos uno por uno
		while(scColumna.hasNext()) {
			contenidoFila = scColumna.next();
			cantFilas = cantFilas(contenidoFila);
			if(cantFilas>mayorCantFilas) {
				mayorCantFilas=cantFilas;
			}
			cantFilas = 0;
			cantColumnas++;
		}
		dimensiones[0] = mayorCantFilas;
		dimensiones[1] = cantColumnas;
		return dimensiones;
	}
	
	/**
	 * 
	 * 
	 * Este m�dulo solo funciona con el siguiente formato:
	 *  . Los elementos de cada fila deben ir separados con una ','.
	 *  . Al final de cada columna debe terminar con un ';'.
	 *  
	 * Ejemplo:
	 * Fila 0: 0,2,3,4,5,8;
	 * Fila 1: 0,2,3,4,5,8;
	 * Fila 2: 1,2,2,3,2,8;
	 * 
	 * Por defecto, si existe una fila con mayor cantidad de elementos que
	 * las demas, la dimension de las filas ser� de dicha dimensi�n,
	 * es decir la de mayor cantidad de elementos.
	 * 
	 * @param ARCHIVO ruta del archivo. Ac� no va el contenido del archivo.
	 * @return devuelve una matriz de enteros cargada con los elementos
	 * del archivo
	 */
	public static int[][] cargaDesdeArchivo(String ARCHIVO) {
		// Declaraci�n de variables
		int[][] enteros;
		int[] dimensiones;
		int cantFilas;
		int cantColumnas;
		String contenidoDelArchivo;
		
		// Inicializaci�n de variables
		contenidoDelArchivo = Archivo.leer(ARCHIVO);
		dimensiones = dimensiones(contenidoDelArchivo);// Determinar la cantidad de filas y columnas
		cantFilas = dimensiones[0];
		cantColumnas = dimensiones[1];
		enteros = new int[cantFilas][cantColumnas];
		System.out.println("Cantidad de filas: " + cantFilas);
		System.out.println("Cantidad de columnas: " + cantColumnas);
		return enteros;
	}
	
	/**
	 * Lee la cantidad de filas y cantidad de columnas para una
	 * matriz. La posicion 0 es la cantidad de filas y la
	 * posicion 1 es la cantidad de columnas.
	 * 
	 * @param primerMensaje este es el mensaje que se mostraria cuando se ingresa
	 * la cantidad de filas
	 * @param segundoMensaje este es el mensaje que se mostraria cuando se ingresa
	 * la cantidad de columnas
	 * @return retorna la cantidad de filas y cantidad de columnas
	 */
	public static int[] dimensiones(String primerMensaje, String segundoMensaje) {
		// Declaracion de variables
		int[] dimensiones;
		
		// Inicializacion de variables
		dimensiones = new int[2]; // Creacion de la matriz
		
		sc = new Scanner(System.in);
		System.out.println(primerMensaje);
		dimensiones[0] = sc.nextInt(); // Lee la cantidad de filas
		System.out.println(segundoMensaje);
		dimensiones[1] = sc.nextInt(); // Lee la cantidad de columnas
		return dimensiones;
	}
	
	/**
	 * Lee la cantidad de filas y cantidad de columnas para una
	 * matriz. La posicion 0 es la cantidad de filas y la
	 * posicion 1 es la cantidad de columnas.
	 * 
	 * @return retorna la cantidad de filas y cantidad de columnas
	 */
	public static int[] dimensiones() {
		return dimensiones("", "");
	}
	
	public static int[][] cargaCompleta(int[] dimensiones, String mensaje) {
		// Declaracion de variables
		int[][] matrizEnteros;
		int cantFilas, cantColumnas;
		
		// Inicializacion de variables
		cantFilas = dimensiones[0]; // Cantidad de filas
		cantColumnas = dimensiones[1]; // Cantidad de columnas
		matrizEnteros = new int[cantFilas][cantColumnas];
		
		// Carga de elementos
		for (int i = 0; i <= cantFilas-1; i++) {
			//System.out.print("Fila " + i + ". "); // Estaba depurando
			matrizEnteros[i] = cargaFila(dimensiones, i, mensaje)[i]; // Carga la fila i de elementos
		}
		
		return matrizEnteros;
	}
	
	/**
	 * Carga de de n elementos la fila i-esima a una matriz
	 * de enteros
	 * 
	 * @param dimensiones representa la cantidad de filas y cantidad de
	 * columnas para la matriz. La posicion 0 es la cantidad de filas y la
	 * posicion 1 es la cantidad de columnas
	 * @param fila es la fila i-esima a la que se le aplica la carga de elementos
	 * @param mensaje es el mensaje que se muestra cada vez que se le
	 * pide al usuario agregar un nuevo elemento a la matriz
	 * @return matriz de enteros cargada de n enteros en la fila i-esima
	 */
	public static int[][] cargaFila(int[] dimensiones, int fila, String mensaje) {
		// Declaracion de variables
		int[][] matrizEnteros;
		int num, cantFilas, cantColumnas;

		// Inicializacion de variables
		cantFilas = dimensiones[0];
		cantColumnas = dimensiones[1];
		matrizEnteros = new int[cantFilas][cantColumnas];

		// Agrega elementos a la matriz
		for (int i = 0; i <= cantColumnas - 1; i++) {
			System.out.println(mensaje);
			sc = new Scanner(System.in);
			num = sc.nextInt();
			matrizEnteros[fila][i] = num;
		}
		return matrizEnteros;
	}
	
	/**
	 * Carga de de n elementos la fila i-esima a una matriz
	 * de enteros
	 * 
	 * @param dimensiones representa la cantidad de filas y cantidad de
	 * columnas para la matriz. La posicion 0 es la cantidad de filas y la
	 * posicion 1 es la cantidad de columnas
	 * @param fila es la fila i-esima a la que se le aplica la carga de elementos
	 * @return matriz de enteros cargada de n enteros en la fila i-esima
	 */
	public static int[][] cargaFila(int[] dimensiones, int fila) {
		return cargaFila(dimensiones,fila,"");
	}
}
