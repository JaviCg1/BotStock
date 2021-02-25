package Data;

import java.util.ArrayList;

import modelos.model;

public class Tienda {
	private String nombre;
	private ArrayList<model> listaProductos;
	
	public Tienda(String nombre) {
		super();
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<model> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(ArrayList<model> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
}
