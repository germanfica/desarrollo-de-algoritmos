//<<<<<<< HEAD:src/xyz/germanfica/_2019/trailend/PracticaInsercion.java
//package xyz.germanfica._2019.trailend;
//=======
package xyz.germanfica._2019.preparacionfinal;
//>>>>>>> aa7053f22433a98639ef4a27764a9b8d55132e95:src/xyz/germanfica/_2019/preparacionfinal/PracticaInsercion.java

import xyz.germanfica.util.ArregloEntero;

public class PracticaInsercion {
	/**
	 * Ordena un arreglo de enteros de forma decreciente.
	 * 
	 * @param arreglo es el arreglo a ordenar
	 */
	public static void insercion(int[] arreglo, int n) {
		int pivote, j;

		for (int i = 1; i <= n - 1; i++) {
			j = i;
			pivote = arreglo[j];

			while (j > 0 && arreglo[j - 1] > pivote) {
				arreglo[j] = arreglo[j - 1]; // Cambia posici�n
				j--;
			}
			arreglo[j] = pivote; // Reubica pivote, enviarlo a su nueva casa
		}
	}

	public static void main(String[] args) {
		// int[] numeros = { 7, 2, 8, 1 };
		// int[] numeros = { 2, 7, 8, 1 };
		int[] numeros = { 3, 7, 5, 1 };
		// int[] numeros = { 5, 3, 4, 1 };
		insercion(numeros, numeros.length);
		ArregloEntero.mostrar(numeros);

	}
}
