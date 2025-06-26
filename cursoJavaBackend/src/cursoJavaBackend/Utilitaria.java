package cursoJavaBackend;

import java.util.List;

public class Utilitaria {
	
	public static <T> void addOddElements(List<T> fuente, List<T> destino) {
		for(int i = 1; i < fuente.size(); i+=2) {
			destino.add(fuente.get(i));
		}
	}
	
	public static void main(String arg []) {
		
		List<String> lista = List.of("a","b","c","d","e","f");
		List<String>listaDestino = new java.util.ArrayList<>();
		
		Utilitaria.addOddElements(lista, listaDestino);
		
		System.out.println("Lista: " + lista);
		System.out.println("Lita destino: " + listaDestino);
	}

}
