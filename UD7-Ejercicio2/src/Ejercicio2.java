import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class Ejercicio2 {
	/*
	 * Catálogos de productos: Key id_producto[precio, idIVA] {1 [10, 1], 2 [20, 2],
	 * 3 [30, 1]}
	 */

	/*
	 * Compra de productos[id_producto, cantidad, id_producto, cantidad] [2, 3, 3,
	 * 1]
	 */
	//Aquí se crea la base de datos donde registraremos los productos de nuestro stock así como los precios y su IVA.
	static Hashtable<Integer, String> Productos = new Hashtable<Integer, String>();
	static Hashtable<Integer, Double> IVA = new Hashtable<Integer, Double>();
	static Hashtable<Integer, Double> Precios = new Hashtable<Integer, Double>();
	
	//Definimos las variables que se sumaran a los valores de nuestros objetos precios e IVA.
	static double precio_masIVA = 0;
	static double precioTotalIVA = 0;
	static double precioTotal = 0;
	//El dinero se decrementará con el valor que le pasemos en precio total mas IVA.
	static double dinero = 100;
	//Definimos el Arraylist dentro de la clase para poder llamarlo en cualquier método.
	static ArrayList<Integer> carrito;

	public static void main(String args[]) {

		IntroducirDatos();
		/*Intenta comprobar si los valores introducidos corresponden con los id asociados en cada put si no es así 
		 * nos muestra un mensaje de error definido en catch.
		 */
		try {

			mostrarDatos();
		} catch (Exception e) {

			System.out.println("No se pudo mostrar los datos" + e);
		}
	}

	public static void IntroducirDatos() {

		/*
		 * Registramos la información de los productos, precios e IVA con una key de enteros que será
		 * el ID y el tipo que será un String para el objeto de Productos con el nombre de producto, 
		 * y Double para el de precios e IVA.
		 */
		Productos.put(1, "Plancha");
		Productos.put(2, "Cinta");
		Productos.put(3, "Aspiradora");
		IVA.put(1, 0.21);
		IVA.put(2, 0.04);
		IVA.put(3, 0.21);
		Precios.put(1, 10.50);
		Precios.put(2, 3.50);
		Precios.put(3, 14.30);
		
		/*En este string se muestra la lista de productos registrados en el HashMap y los llamamos directamente 
		 * con la variable text.
		 */
		String text = "Lista de productos: \n";

		text = text + " [1] " + Productos.get(1) + "\n";
		text = text + " [2] " + Productos.get(2) + "\n";
		text = text + " [3] " + Productos.get(3) + "\n";
		
		//Pasamos los datos de cada id a un ArrayList.
		carrito = new ArrayList<Integer>();

		carrito.add(Integer.parseInt(JOptionPane.showInputDialog(text)));
		carrito.add(Integer.parseInt(JOptionPane.showInputDialog(text)));
		carrito.add(Integer.parseInt(JOptionPane.showInputDialog(text)));

		// idDeProductos.add(id_producto.get(4989));
		/*
		 * productos.add(id_producto2); productos.add(id_producto3);
		 */

		// precios.add(catalogo.get(3.50));

		// for(Double precio : productos)

	}

	public static void mostrarDatos() {
		
		/*
		 * Por cada id de carrito me mostrarás la suma de precios e IVA y sus nombres.
		 */
		for (Integer id : carrito) {

			precioTotal = precioTotal + Precios.get(id);
			precio_masIVA = (IVA.get(id) + 2) * Precios.get(id);
			//Pasamos el valor de precio mas IVA a precio total IVA.
			precioTotalIVA = precio_masIVA + precioTotalIVA;

			System.out.println("Producto: " + Productos.get(id) + ",Precio: " + Precios.get(id) + ",IVA: " + IVA.get(id));
		}
		
		System.out.println("Precio total: " + precioTotal + " mas IVA " + precioTotalIVA);
		System.out.println("Total a devolver: " + (dinero - precioTotalIVA));
		
	}
}
			
