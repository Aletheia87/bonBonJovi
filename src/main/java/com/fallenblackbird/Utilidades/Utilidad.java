package com.fallenblackbird.Utilidades;

public class Utilidad {

	public static void limpiarPantalla() {
		for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }
	
	public static void tiempoEspera() {
		try {
			System.out.println("Abandonando el sistema de productos...");
			Thread.sleep(2000);
			System.out.println("Acaba de salir del Sistema");
		} catch (Exception e) {
			System.out.println(e);
		
		}
	}
	
}
