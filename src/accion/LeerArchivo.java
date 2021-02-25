package accion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import Data.Tienda;
import modelos.model;

public class LeerArchivo {

	public HashMap<String, ArrayList<model>> mapTiendas;

	public LeerArchivo() {
		this.mapTiendas = new HashMap<String, ArrayList<model>>();

	}

	public void setListaTiendas() throws IOException {

		ArrayList<Tienda> lista = new ArrayList<Tienda>();
		File archivo = new File("/home/pi/Documents/GPUShops/orden.txt");
		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);

		String linea;

		while ((linea = br.readLine()) != null) {
			mapTiendas.put(linea, new ArrayList<model>());

		}

	}

	public HashMap<String, ArrayList<model>> getMapTiendas() {
		return mapTiendas;
	}

	public void setListaComponentes() throws IOException {

		for (HashMap.Entry<String, ArrayList<model>> entry : mapTiendas.entrySet()) {
			System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
			File archivo = new File("/home/pi/Documents/GPUShops/" + entry.getKey() + "/orden.txt");
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			
			
			String linea;
			String linea1;
			while ((linea = br.readLine()) != null) {
				model m = new model(linea);

				BufferedReader br2 = new BufferedReader(
						new FileReader(new File("/home/pi/Documents/GPUShops/" + entry.getKey() + "/" + linea + ".txt")));
				ArrayList<String> url = new ArrayList<String>();

				while ((linea1 = br2.readLine()) != null) {
					url.add(linea1);

				}
				m.setListURLs(url);
				entry.getValue().add(m);

			}

		}

	}

	

	public void setMapTiendas(HashMap<String, ArrayList<model>> mapTiendas) {
		this.mapTiendas = mapTiendas;
	}
	
	public ArrayList<String> getListaUrlModelo(String key, String modelo) {
		
		for (model i : mapTiendas.get(key)) {
			if (i.getNombre().equals(modelo)) {
				return i.listURLs;
			}
		}
		return null;
		
	}
	public ArrayList<model> getListaModelosTienda(String key) {			
			return mapTiendas.get(key);
			
		}

	@Override
	public String toString() {
		return "LeerArchivo [mapTiendas=" + mapTiendas + ", getMapTiendas()=" + getMapTiendas() + "]";
	}
	

}
