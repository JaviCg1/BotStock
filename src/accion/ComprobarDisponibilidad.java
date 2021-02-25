package accion;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import Data.Tienda;
import modelos.model;

public class ComprobarDisponibilidad {

	public static String stock(ArrayList<model> lista) throws IOException {
		Document doc;
		for (model m : lista) {
			ArrayList <String>listaUrl= m.getListURLs();
			for (String url : listaUrl) {
				try{ Thread.sleep(300); }
				
				catch(InterruptedException e ) 
				{ System.out.println("Thread Interrupted");
					}
				doc = Jsoup.connect(url).get();
				String res = doc.getElementById("btnsWishAddBuy")
				.getElementsByClass("js-article-buy").first()
				.attr("id");
				
				if (res.equals("notify-me")) {
					System.out.println(m.getNombre()+" - No esta disponible");
				}else {
					String msg = m.getNombre() +" Esta Disponible URL: ---- "+  url;
					System.out.println(msg);
					return msg;
				}
				
				
			}
		}
		return null;
		
	}
}
