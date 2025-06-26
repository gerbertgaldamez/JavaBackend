package cursoJavaBackend;

import java.util.HashMap;
import java.util.Map;

public class HashMapSinNulos<K,V> extends HashMap<K, V> {
	
	public V put(K llave, V valor) {
		validarNoNulo(llave, valor);
		
		return super.put(llave, valor);
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		for(Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
			validarNoNulo(entry.getKey(),entry.getValue());
				super.putAll(m);
			}
		}
	
	private void validarNoNulo(K llave, V valor) {
		if(valor == null) {
			throw new IllegalArgumentException("No se permiten valores nulos (llave:" + llave + ")");
		}
	}
	
	public static void main(String arg[]) {
		
		HashMapSinNulos<String, String>mapa = new HashMapSinNulos<>();
		
		mapa.put("uno", "valor1");
		mapa.put("dos", "valor2");
		
		System.out.println("Contenido del mapa:" + mapa);
		
		try {
			mapa.put("tres", null);
		}catch(IllegalArgumentException e) {
			System.out.println("Error:" +e.getMessage());
		}
		
		Map<String, String>mapa2 = new HashMap<>();
		mapa2.put("cuatro", "valor4");
		mapa2.put("Cinco", null);
		
		try {
			mapa.putAll(mapa2);
		}catch(IllegalArgumentException e) {
			System.out.println("Error:" +e.getMessage());
		}
	}
}
