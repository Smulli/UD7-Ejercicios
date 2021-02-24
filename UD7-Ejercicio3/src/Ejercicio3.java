import java.util.Hashtable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Ejercicio3 {

	static Hashtable<String, Double> Stock = new Hashtable<String, Double>();
	static Hashtable<String, Integer> Catalogo = new Hashtable<String, Integer>();

	// Lista.add(StockNombre.get())
	// Insertar elementos.
	
	//Definimos las variables dentro de la clase que se asociaran con nombre y cantidad de productos.
	static public String nombre;
	static public int cantidad;

	public static void main(String args[]) {

		IntroducirStock();
		mostrarStock();

	}

	public static void IntroducirStock() {
		
		//Creamos un bucle do - while para repetir la introducción de nuevos datos en caso de que el usuario así lo requiera.
		boolean repeat = false;

		do {

			nombre = JOptionPane.showInputDialog("Introduzca nombre del producto");
			cantidad = Integer.parseInt(JOptionPane.showInputDialog("Introduzca cantidad de productos"));

			Catalogo.put(nombre, cantidad);

			String response = JOptionPane.showInputDialog("¿Quiere seguir añadiendo productos? [si=1/no=0]");
			/*Mediante esta condición se le pide al usuario si este desea continuar introduciendo nuevos datos, si su 
			 * respuesta es sí repeat se mantendrá en true y se le abrirá de nuevo el recuadro para introducir un nuevo dato
			 * si es no pasará a false y el bucle se cerrará. 
			 */
			if (Integer.parseInt(response) == 1) {

				repeat = true;
			} else
				repeat = false;

		} while (repeat);
		
		//Aqui almacenamos objetos con claves y valores por defecto.
		Stock.put("cinta", 0.5);
		Stock.put("platano", 0.3);
		Stock.put("aspiradora", 20.50);
		Stock.put("tornillo", 0.1);
		Stock.put("tigre", 1000.0);
		Stock.put("delfin", 20000.0);
		Stock.put("un amigo", 10.0);
		Stock.put("dron", 200.35);
		Stock.put("robot", 1550.40);
		Stock.put("pera", 0.6);

	}

	public static void mostrarStock() {

		//Recorremos todos los datos introducidos por defecto con el for-each.
		for (String producto : Stock.keySet()) {

			System.out.print(producto);
			System.out.println(" " + Stock.get(producto) + "\n");
		}
		
		//Creamos otro bucle for each pero esta vez para recorrer los datos que nosotros almacenemos en el bloque de do-while
		for (String nombre : Catalogo.keySet()) {

			System.out.println("El producto " + nombre + " tiene una cantidad de " + Catalogo.get(nombre) + "\n");
		}

		// Validar que existe.
		/*
		 * if( Stock.containsKey("cinta")) {
		 * 
		 * System.out.println("Cinta "+Stock.get("cinta")); }else {
		 * 
		 * System.out.println("No está en el inventario"); }
		 */
	}

}
