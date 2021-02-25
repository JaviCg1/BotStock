package Hilo1;

import java.util.ArrayList;

import Data.Tienda;
import Pruebas.PcComponentes;
import accion.ComprobarDisponibilidad;

public class HiloThread extends Thread{
	
	private ArrayList<Tienda> lista;
	public HiloThread(ArrayList<Tienda> lista) {
		this.lista = lista;
		ComprobarDisponibilidad hola = new ComprobarDisponibilidad();
	}
	
	@Override
	public void run() {

		//ComprobarDisponibilidad.stock(lista);
		
		
			
		
	}	
}
