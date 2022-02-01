package com.fallenblackbird.Vistas;


import java.io.File;
import java.util.Scanner;
import com.fallenblackbird.Modelo.CategoriaEnum;
import com.fallenblackbird.Modelo.Cliente;
import com.fallenblackbird.Servicio.ArchivoServicio;
import com.fallenblackbird.Servicio.ClienteServicio;
import com.fallenblackbird.Servicio.ExportadorCsv;
import com.fallenblackbird.Servicio.ExportadorTxt;
import com.fallenblackbird.Utilidades.Utilidad;


public class Menu extends MenuTemplate  {

	Scanner sc = new Scanner(System.in);
	ClienteServicio cs = new ClienteServicio();
	ArchivoServicio as = new ArchivoServicio(cs);
	ExportadorCsv ExportadorCvs;
	ExportadorTxt ExportarTxt;
	Cliente cliente;
	String fileName1 = "Clientes";
	String fileName2 = "DBCliente.csv";
	String run;
	String nombre;
	String apellido;
	String anios;
	String opcion;

	@Override
	public void listarCliente() {
		cs.retornoListarClientes().forEach(clienteI -> System.out.println(clienteI));

	}

	@Override
	public void agregarCliente() {
		System.out.println("-------------Crear Cliente-------------");
		System.out.println("Ingresa RUN del Cliente:");
		run = sc.nextLine();
		System.out.println("Ingresa Nombre del Cliente:");
		nombre = sc.nextLine();
		System.out.println("Ingresa Apellido del Cliente:");
		apellido = sc.nextLine();
		System.out.println("Ingresa años como Cliente:");
		anios = sc.nextLine();
		System.out.println("---------------------------------------\n");
		Cliente cliente = new Cliente(run, nombre, apellido, anios, CategoriaEnum.ACTIVO);
		cs.agregarCliente(cliente);

	}

	@Override
	public void editarCliente() {
		String actualizacion = "";

		System.out.println("-------------Editar Cliente-------------\n" + "Seleccione qué desea hacer:\n"
				+ "1.- Cambiar el estado del Cliente\n" + "2.- Editar los datos ingresados del Cliente\n"
				+ "----------------------------------------\n" + "Ingrese opcion:\n");
		sc.nextLine();
		System.out.println("Ingrese RUN del Cliente a editar:");
		run = sc.nextLine();
		if (cs.buscarCliente(run)) {
			cliente = cs.getCliente(run);

			if (opcion.equals("1")) {
				System.out.println("-----Actualizando estado del Cliente----\n" + "El estado actual es:"
						+ cliente.getNombreCategoria() + "\n" + "1.-Si desea cambiar el estado del Cliente a Inactivo\n"
						+ "2.-Si desea mantener el estado del cliente Activo\n"
						+ "----------------------------------------\n" + "Ingrese opcion:\n");
				opcion = sc.nextLine();

				if (opcion.equals("1")) {
					cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
				} else if (opcion.equals("2")) {
					cliente.setNombreCategoria(CategoriaEnum.ACTIVO);
				} else
					System.out.println("Ingrese una opción válida");

			} else if (opcion.equals("2")) {
				cs.mostrarCliente(run);
				System.out.println("Ingrese opcion a editar de los datos del cliente:");
				opcion = sc.nextLine();

				switch (opcion) {
				case "1":
					System.out.println("Ingrese el nuevo run del cliente: ");
					actualizacion = sc.nextLine();
					System.out.println("Datos cambiados con éxito");
					break;
				case "2":
					System.out.println("Ingrese el nuevo nombre del cliente: ");
					actualizacion = sc.nextLine();
					System.out.println("Datos cambiados con éxito");
					break;
				case "3":
					System.out.println("Ingrese el nuevo apellido del cliente: ");
					actualizacion = sc.nextLine();
					System.out.println("Datos cambiados con éxito");
					break;
				case "4":
					System.out.println("Ingrese los años del cliente: ");
					actualizacion = (sc.nextLine());
					System.out.println("Datos cambiados con éxito");
					break;
				default:
					System.out.println("La opción ingresada no es válida");
					break;
				}
				cs.editarCliente(run, opcion, actualizacion);
			}
		}
	}

	@Override
	public void importarDatos() {
		
		System.out.println("Ingresa la ruta donde se encuentra el archivo DBClientes.csv");
		String ruta = sc.nextLine();
		File fichero = new File(ruta);
		File archivo = new File(ruta + "/DBClientes.csv");
//		File archivo = new File(ruta + "/" + fileName2);
		
		if(fichero.exists()) {
			if(archivo.exists()) {
				as.importarDatos(archivo);
			}else {
				System.out.println("El archivo no existe");
			}
		}else {
			System.out.println("El directorio no existe");
	}
}
		
	@Override
	public void exportarDatos() {
		System.out.println("Elija un tipo de datos a exportar:\n"
			+ "1.- CSV\n"
			+ "2.- TXT\n"
			+ "Ingrese una opción para exportar:\n"
			+ "---------------------------------------");
		opcion = sc.nextLine();

		if (opcion.equals("1") | opcion.equals("2")) {
			as.exportarDatos(opcion, fileName1);
		} else {
			System.out.println("La opción ingresada no es válida");
		}
	}

	@Override
	public void terminarPrograma() {
		Utilidad.limpiarPantalla();
		Utilidad.tiempoEspera();
	}

}
