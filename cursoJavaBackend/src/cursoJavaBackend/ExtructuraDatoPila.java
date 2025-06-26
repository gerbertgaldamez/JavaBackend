package cursoJavaBackend;

import java.util.Collection;
import java.util.Stack;

public class ExtructuraDatoPila<E> extends Stack<E> {
	
	public void pushAll(Collection<? extends E>elementos) {
		for(E elemento: elementos) {
			this.push(elemento);
		}
	}
	
	public Stack<E>popAll(){
		Stack<E>elementosExtraidos = new Stack<>();
		while(!this.isEmpty()) {
			elementosExtraidos.push(this.pop());
			
		}
		return elementosExtraidos;
	}
	
	public static void main(String arg[]) {
		ExtructuraDatoPila<Integer> pila = new ExtructuraDatoPila<>();
		
		pila.pushAll(java.util.List.of(1,2,3,4,5));
		
		System.out.println("Uso de pushAll:" + pila);
		
		Stack<Integer>extraidos = pila.popAll();
		
		System.out.println("Uso del popAll:" + extraidos);
	}

}
