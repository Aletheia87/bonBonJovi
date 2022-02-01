package com.fallenblackbird.Servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.fallenblackbird.Modelo.Cliente;

public class ExportadorTxt extends Exportador {

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		
		try {
			File archivo = new File("src/main/java/recursos/" + fileName + ".txt");
			archivo.createNewFile();
			PrintWriter pw = new PrintWriter(new FileWriter(archivo));

			for (Cliente cliente : listaClientes) {
				pw.write(cliente.toString());
				pw.println();
			}
			System.out.println("Datos de clientes exportados correctamente en formato .txt\n");
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
