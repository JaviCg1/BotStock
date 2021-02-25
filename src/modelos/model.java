package modelos;

import java.util.ArrayList;

public class model {
public String nombre;
public ArrayList<String> listURLs;

public model(String nombre) {
	super();
	this.nombre = nombre;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public ArrayList<String> getListURLs() {
	return listURLs;
}

public void setListURLs(ArrayList<String> listURLs) {
	this.listURLs = listURLs;
}

@Override
public String toString() {
	return " \n model [nombre=" + nombre + ", listURLs= " + listURLs + " ]";
}



}
