package com.fallenblackbird.Servicio;

import java.util.List;

import com.fallenblackbird.Modelo.Cliente;

public abstract class Exportador {

	public abstract void exportar(String fileName, List <Cliente> listaClientes);
}
