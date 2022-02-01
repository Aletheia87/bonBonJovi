package com.fallenblackbird.Vistas;

import java.util.Scanner;

public abstract class MenuTemplate {

	protected Scanner sc = new Scanner(System.in);

	public abstract void listarCliente();

	public abstract void agregarCliente();

	public abstract void editarCliente();

	public abstract void importarDatos();

	public abstract void exportarDatos();

	public abstract void terminarPrograma();

	public final void iniciarMenu() {
		String opcion;
		
		do {
			System.out.println("---------Bon Bon Jovi---------\n" 
					+ "1. Listar Cliente\n"
					+ "2. Agregar Cliente\n" 
					+ "3. Editar Cliente\n" 
					+ "4. Importar Datos\n" 
					+ "5. Exportar Datos\n"
					+ "6. Salir\n" + "-----------------------------\n" 
					+ "Ingrese una opción:");
			
			opcion = sc.nextLine();

			switch (opcion) {
			case "1":
				listarCliente();
				break;
			case "2":
				agregarCliente();
				break;
			case "3":
				editarCliente();
				break;
			case "4":
				importarDatos();
				break;
			case "5":
				exportarDatos();
				break;
			case "6":
				terminarPrograma();
				break;
			default:
			System.out.println("Ingrese una opción válida");
			}
		} while (!opcion.equals("6"));

	}
}
