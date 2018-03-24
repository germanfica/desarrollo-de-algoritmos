package tp1_2018;

import java.util.Scanner;

public class Ej1 {
	
	public static boolean esPar(int número)
	{
		boolean esPar = false;
		if(número%2==0)
			esPar = true;
		
		return esPar;
	}
	
	/*
	 * Determinar la cantidad de divisores enteros de un número entero.
	 */
	public static int divisoresEnteros(int número)
	{
		int índice, resultado;
		
		resultado = 0; // Inicializar entero
				
		// Determinar divisores
		for(índice = número; índice>1;índice--)
		{
			if(número%índice==0)
			{
				resultado = resultado + 1;
			}
		}
		
		return resultado;
	}
	
	public static int[] cargarPrimos(int n) 
	{
		int índice, primosEncontrados;
		int[] primo, resultado;
		
		primosEncontrados = 0; // Inicializar entero
		primo = new int[n]; // Inicializar arreglo
		
		// Buscar posible primo
		for(índice = 2; índice<=primo.length;índice++) {	
			if(divisoresEnteros(índice) == 1) {
				primosEncontrados = primosEncontrados + 1;
				primo[primosEncontrados-1] = índice;
			}
		}
		
		// Crear nuevo arreglo con la cantidad correcta de número primos.
		resultado = new int[primosEncontrados];
		for(índice = 0; índice < resultado.length; índice++) {
			resultado[índice] = primo[índice];
		}
		
		return resultado;
	}
	
	/* Condición A: Cargar los códigos de los productos en las posiciones pares.
	 * @param pieza Arreglo principal
	 */
	public static int[] cargarDatos(int[] pieza)
	{
		int índice;
		
		// Crear scanner
		Scanner sc = new Scanner(System.in);
		
		for(índice = 0; índice< pieza.length-1;índice++)
		{
			if(esPar(índice)) {
				pieza[índice] = sc.nextInt(); // Código de la pieza
			}else {
				pieza[índice] = sc.nextInt(); // Cantidad usada de esa pieza
			}
		}
		
		return pieza;
	}
	
	public static int raízCuadradaEntera(int número) 
	{
		return número;
	}
	
	public static int esPrimo(int n)
	{
		int respuesta, índice;
		respuesta = 1;
		// Teorema fundamental de la aritsmética
		if(n!=1 || n!=-1 || n!=0)
		{
			//Como n > 1, si n no es primo entonces existe un primo p
			// tal que p|n y p<=raizCuadradaEntera(n)
			int [] p;
			p = cargarPrimos(raízCuadradaEntera(n));
			
			for(índice = 0;índice < p.length;índice++)
			{
				//System.out.println("n: " + n + " índice: " + índice);
				if(n%p[índice]==0 && n!=p[índice])
				{
					respuesta = 0;
					//System.out.println(n);
				}
			}
		}
		
		return respuesta;
	}
		
	/*
	 * Leer n piezas y mostrar menú con opciones.
	 */
	public static void main(String[] args) {
		boolean terminarPrograma;
		int opción, longitud, cn;
		int[] pieza;
		
		Scanner sc = new Scanner(System.in); // Crear scanner
		
		System.out.println("Bienvenido! Porfavor cargue la cantidad incial de piezas para"
				+ "esta sesión."); // Mostrar cartel de bienvenida
		
		cn = sc.nextInt(); // Leer cantidad de piezas		
		longitud = cn *2; // Calcular la longitud del arreglo
		
		pieza = new int[longitud]; // Inicilizar arreglo
				
		// Menú principal
		terminarPrograma = false;
		while(terminarPrograma==false)
		{
			// Carteles del menú principal
			System.out.println("0- Salir del programa.");
			System.out.println("1- Cargar datos.");
			System.out.println("2- Verificar regla de la compañía.");
			opción = sc.nextInt(); // Leer opción
			
			switch(opción)
			{
				case 0:
					terminarPrograma = true;
					break;
				case 1:
					pieza = cargarDatos(pieza); // Cargar datos
					break;
				case 2:
					System.out.println("Es primo: " + esPrimo(5));
					break;
				default:
					System.out.println("Solo están disponibles las opciones del menú.");
					break;
			}
		}
	}
}