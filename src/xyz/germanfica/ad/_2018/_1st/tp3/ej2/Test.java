package xyz.germanfica.ad._2018._1st.tp3.ej2;

public class Test {
	public static void main (String [] args){
		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setNombre("Harina");
		ingrediente.setCantidad(2);
		ingrediente.setUnidadDeMedida("taza");
		System.out.println(ingrediente.toString());
	}
}