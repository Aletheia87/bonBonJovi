package com.fallenblackbird.Servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fallenblackbird.Modelo.Cliente;


public class ClienteServicio {

		public List<Cliente> listaClientes = new ArrayList<Cliente>();

	public ClienteServicio() {

	}
	
	public ClienteServicio(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	@Override
	public String toString() {
		return "ClienteServicio [listaClientes=" + listaClientes + "]";
	}

	public void agregarCliente(Cliente cliente) {
		listaClientes.add(cliente);
	}
	
	public List<String> retornoListarClientes() {
		
		List<String> lista = listaClientes.stream().map(cliente -> "-------------Datos del Cliente-------------\n"
				+ "RUN del Cliente: " + cliente.getRunCliente() + "\n"
				+ "Nombre del Cliente: " + cliente.getNombreCliente() + "\n"
				+ "Apellido del Cliente: " + cliente.getApellidoCliente() + "\n"
				+ "Años como Cliente: " + cliente.getAniosCliente()+ "\n"
				+ "Categoría del Cliente: " + cliente.getNombreCategoria()+ "\n"
				+ "-------------------------------------------\n").collect(Collectors.toList());
        
        return lista;
		
    }
	
	public void mostrarCliente(String run) {
		
		listaClientes.stream().filter(cliente -> cliente.getRunCliente().equals(run))
				.map(cliente -> "----Actualizando datos del Cliente-----\n"
						+ "1.- El RUN del Cliente es: " + cliente.getRunCliente() + "\n"	 
						+ "2.- El Nombre del Cliente es: " + cliente.getNombreCliente() + "\n"
						+ "3.- El Apellido del Cliente es: " + cliente.getApellidoCliente() + "\n"
						+ "4.- Los Años como Cliente es: " + cliente.getAniosCliente()
						+ "-------------------------------------------\n")
				.forEach(cliente -> System.out.println(cliente));
  	}
	
	
	public boolean buscarCliente(String run) {
		boolean encontrado = false;
		for(Cliente cliente: listaClientes) {
			if(cliente.getRunCliente().equals(run))
				encontrado = true;
		}
		return encontrado;
	}
	
	public Cliente getCliente(String run) {
		for(Cliente cliente: listaClientes) {
			if(cliente.getRunCliente().equals(run))
				return cliente;
		}
		return null;
	}

	public void editarCliente(String run, String opcion, String actualizacion) {
		Cliente cliente = getCliente(run); 
		switch (opcion) {
		case "1":
			cliente.setRunCliente(actualizacion);
			break;
		case "2":
			cliente.setNombreCliente(actualizacion);
			break;
		case "3":
			cliente.setApellidoCliente(actualizacion);
			break;
		case "4":
			cliente.setAniosCliente(actualizacion);
			break;
		default:
			System.out.println("La opción ingresada no es válida\n");
			break;
		}
	}

	public void agregarCliente(ArrayList<Cliente> listaImportada) {
		listaClientes.addAll(listaImportada);
	}
	
}