package com.fallenblackbird.Servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.fallenblackbird.Modelo.Cliente;
import com.fallenblackbird.Modelo.CategoriaEnum;



public class ArchivoServicio {
	
	private ClienteServicio cs;
	
	public ArchivoServicio (ClienteServicio cs) {
		this.cs = cs;
	}
	
	Cliente cliente;
	
	public void importarDatos(File archivo) {
		
			try {
				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);
				String linea = br.readLine();
				ArrayList<Cliente> clientesImportados = new ArrayList<Cliente>();
				CategoriaEnum actividad;
				
				while (linea != null) {
					linea.split(",");
					String[] datos = linea.split(",");
					if (datos[4].equals("Activo"))
						actividad = CategoriaEnum.ACTIVO;
					else
						actividad = CategoriaEnum.INACTIVO;
					
					cliente = new Cliente(datos[0], datos[1], datos[2], datos[3],actividad);
					
					clientesImportados.add(cliente);
					linea= br.readLine();
				}	
				cs.agregarCliente(clientesImportados);
				br.close();
				System.out.println("Datos cargados correctamente en la lista.\n");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Datos no pudieron ser cargados correctamente en la lista.\n");
			}
		}
	
	
	public void exportarDatos(String opcion, String nombre) {
		Exportador exportador = null;
		switch(opcion) {
			case "1":
				exportador = new ExportadorCsv();
				break;
			case "2":
				exportador = new ExportadorTxt();
				break;
		}	
		exportador.exportar(nombre, cs.getListaClientes());
	}
	

}
