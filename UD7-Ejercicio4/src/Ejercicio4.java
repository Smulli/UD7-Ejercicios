import java.util.Hashtable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Ejercicio4 {
	
	//Llamamos a la clase producto para que esté dentro de nuestra base de datos.
	static Hashtable<Integer, Producto> Productos = new Hashtable<Integer, Producto>();

	static double dinero = 100;

	public static void main(String args[]) {

		IntroducirStock();
		mostrarStock();
	}

	public static void IntroducirStock() {
		
		//Repetimos el método de introducción de datos de ejercicios anteriores.
		boolean repeat = false;
		//Creamos la variable id para poder asociarla en cada producto.
		int id = 1;
		
		//Llamamos a los atributos de nuestra clase producto definiendolos como variables.
		String Nombre = "";
		double Precio = 0;
		double IVA = 0.21;

		do {

			//Ahora podremos introducir datos en los atributos.
			Nombre = JOptionPane.showInputDialog("Introduzca nombre del producto");
			Precio = Double.parseDouble(JOptionPane.showInputDialog("Introduzca precio del producto"));

			Productos.put(id, new Producto(Nombre, Precio, IVA));

			String response = JOptionPane.showInputDialog("Quieres seguir añadiendo productos? [si = 1/no = 0");

			if (Integer.parseInt(response) == 1) {

				repeat = true;
				id ++;
			} else
				repeat = false;

		} while (repeat);

		// IVA.put(1, 0.21);
		// IVA.put(2, 0.04);

	}

	public static void mostrarStock() {

		double PrecioTotal = 0;
		
		//Por cada id de producto me recorre los datos asociados de productos.
		for (Integer id : Productos.keySet()) {

			String Catalogo = "";
			String PrecioFinal = "";
			double PreciomasIVA = 0;

			Producto producto = Productos.get(id);

			String Nombre = producto.Nombre;
			double Precio = producto.Precio;
			double IVA = producto.IVA;
			
			//Como en el ejercicio anterior sumamos precio e IVA se lo pasamos a precio total.
			PreciomasIVA = (Precio + (Precio * IVA));
			PrecioTotal = (PrecioTotal + PreciomasIVA);

			Catalogo = Catalogo + "El producto " + Nombre + " Tiene un precio de " + Precio + " Y tiene un IVA de "
					+ IVA;
			PrecioFinal = PrecioFinal + "El precio total es: " + PreciomasIVA;

			System.out.println(Catalogo);
			System.out.println(PrecioFinal + "\n");

		}
		
		//Decrementamos la variable dinero con el valor de precio total.
		System.out.println("Total a devolver " + (dinero - PrecioTotal));
	}

}
