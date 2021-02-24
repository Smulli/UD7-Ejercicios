import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import javax.swing.JOptionPane;

public class Ejercicio1 {
	
	//Pasamos los datos en un Hashtable de tipo String para los nombres y Double para las notas de los alumnos.
	static Hashtable<String, Double> alumnos = new Hashtable<String, Double>();
	public static void main(String args[]) {
		
		IngresarDato();
		mostrarDatos();
	}
	
	public static void IngresarDato() {
		
		//Creamos una variable del tipo booleano para que repita la entrada de datos.
		boolean repeat = false;
		
		do {
			
			String name = JOptionPane.showInputDialog("Introduzca nombre del alumno");
			
			ArrayList <Double> notas = new ArrayList <Double>();
			
			notas.add(Double.parseDouble(JOptionPane.showInputDialog("Introduzca la nota1 del alumno")));
			notas.add(Double.parseDouble(JOptionPane.showInputDialog("Introduzca la nota2 del alumno")));
			notas.add(Double.parseDouble(JOptionPane.showInputDialog("Introduzca la nota3 del alumno")));
			notas.add(Double.parseDouble(JOptionPane.showInputDialog("Introduzca la nota4 del alumno")));
			
			double notaMax = 0;
			
			for (Double double1 : notas) {
				
				notaMax = notaMax + double1;
			}
			
			notaMax = notaMax/notas.size(); //
			alumnos.put(name, notaMax);
			String response = JOptionPane.showInputDialog("¿Desea ingresar otro alumno?[si = 1/no = 0]");
			
			if( Integer.parseInt (response) == 1) {
				
				repeat = true;
			}
			else repeat = false;
			
			
		}while (repeat);
	}
	
	public static void mostrarDatos() {
		
		for (String name: alumnos.keySet()) {
			
			System.out.println("Alumno: " +name+ " || promedio: " +alumnos.get(name));
		}
	}
}
			
		
		
		
		
		
		
		


	
