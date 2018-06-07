package com.graworg.ad._2018.entrega.ordenamiento;

import java.util.Scanner;
import com.graworg.ad.util.Archivo;

public class Entrega {
    private static final String NOMBRE_ARCHIVO = "src/com/graworg/ad/_2018/entrega/ordenamiento/arreglo.txt"; // Ruta del archivo
	private static final int tamArrgelo = 9;
	private static Scanner sc;
	
	/**
	 * (1) Método de inserción
	 * 
	 * @param arreglo
	 */
	public static int[] inserción(int[] arreglo) {
		// Declaración de variables
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
	 * (2) Método de selección
	 * 
	 * @return
	 */
	public static int[] selección(int[] arreglo) {
		// Declaración de las variables
		int posiciónDelMenor, auxiliar;
	
		// Recorrer el arreglo para ordenar los elementos uno a uno
		// n es la longitud del arreglo
		for(int i=0;i<=arreglo.length-1;i++) {
			// Buscar el número más pequeño  desde i hasta la longitud del arreglo y guardar su índice
			posiciónDelMenor = i;
			
			// Recorrer el arreglo en busca del índice del elemento del mismo
			for(int j=i+1;j<=arreglo.length-1;j++) {
				// Si existe un elemento más pequeño guardar su índce
				if(arreglo[j] < arreglo[posiciónDelMenor]) {
					// Se encontró un elemento más pequeño aún
					posiciónDelMenor = j;
				}
			}
	
			// Almacenar el elemento de la posicón i
			auxiliar = arreglo[i];
			// Intercambiar las posiciones
			arreglo[i] = arreglo[posiciónDelMenor];
			arreglo[posiciónDelMenor] = auxiliar;
		}
		
		return arreglo;
	}
	
	public static void mostrarElementos(int[] arreglo) {
		// Declaración de variables
		int i;
		
		// Inicialización de variables
		i = 0;
		
		while(i<=arreglo.length-1) {
			System.out.println(arreglo[i]);
			i++;
		}
	}
	
	public static int[] cargaDesdeArchivo(String ruta, int longitud) {
		int[] arreglo = new int[longitud];
		String contenidoDelArchivo = Archivo.leer(ruta);
		
		sc = new Scanner(contenidoDelArchivo); // Asignación de tarea al scanner para analizar el contenido del archivo
		
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
		// Declaración de las variables
		int[] arreglo;
		boolean salir;
		int opción;
		
		// Inicialización de las variables
		salir = false;
		arreglo = cargaDesdeArchivo(NOMBRE_ARCHIVO, tamArrgelo);
		
		System.out.println("Bienvenido a la consola de la aplicación");
		
		while(!salir)
		{
			sc = new Scanner(System.in);
			
			// Mostrar el cartel de las opciones
			System.out.print(
					"[0] Salir (IMPLEMENTADO)\n" +
					"[1] Aplicar el método de inserción (IMPLEMENTADO)\n" +
					"[2] Aplicar el método selección (IMPLEMENTADO)\n"
					);
			
			// Leer opción para el menú principal
			opción = sc.nextInt();
			
			switch (opción) {
			case 0:
				salir = true;
				break;
			case 1:
				arreglo = inserción(arreglo);
				mostrarElementos(arreglo);
				break;
			case 2:
				arreglo = selección(arreglo);
				mostrarElementos(arreglo);
				break;			
			default:
				System.err.println("Esta opción no está definida. Seleccione una de las siguientes opciones: ");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		mostrarMenú();
	}
}
