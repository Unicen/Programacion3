package ProgramacionIII.tp2;

public class Ej1 {

	
	public static void main(String[] args) {
		
		int[] arreglito = new int[]{ 1, 3, 6, 8 };
		
		boolean ordenado = estaOrdenadoIterativo(arreglito);

		System.out.println("Esta ordenado? " + (ordenado ? "si" : "no"));
		
		ordenado = estaOrdenadoRecursivo(arreglito, 0);

		System.out.println("Esta ordenado? " + (ordenado ? "si" : "no"));
		
	}

	private static boolean estaOrdenadoRecursivo(int[] arr, int index) {
		
		if (index == arr.length-1)
			return true;
		
		int siguiente = index+1;
		
		if (arr[index] > arr[siguiente]) {
			return false;
		} else { 
			boolean elRestoEstaOrdenado = estaOrdenadoRecursivo(arr, siguiente);
			return elRestoEstaOrdenado;
		}
		
	}
	
	private static boolean estaOrdenadoIterativo(int[] arr) {
		
		for (int index = 0; index < arr.length-1; index++) {
			if (arr[index] > arr[index+1])
				return false;
		}
		
		return true;
	}

}
