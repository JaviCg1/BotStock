import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Data.Tienda;

import Hilo1.HiloThread;
import Pruebas.PcComponentes;
import accion.ComprobarDisponibilidad;
import accion.Email;
import accion.LeerArchivo;
import modelos.model;

public class ClasePrincipal {

	public static void main(String[] args) throws IOException, InterruptedException {
		HashMap<String, ArrayList<model>> mapTiendas;
		//Hola
		// TODO Auto-generated method stub
		
		
	//	HiloThread htd = new HiloThread(new ArrayList<Tienda>());
	//	htd.setName("HiloThread");
		//htd.start(); 
		LeerArchivo l1= new LeerArchivo();
		 l1.setListaTiendas();
		 String hola;
		l1.setListaComponentes();
		mapTiendas = l1.getMapTiendas();
		System.out.println(l1.toString());
		while(true) {
			String t =  ComprobarDisponibilidad.stock(l1.getListaModelosTienda("PcComponentes"));
			if (t!=null) {
				Email.enviarEmail(t);
			}
		}
		
		
	}

}
