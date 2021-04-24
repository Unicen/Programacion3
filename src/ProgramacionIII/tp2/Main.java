package ProgramacionIII.tp2;

public class Main {

	public static void main(String[] args) {
		

		TreeWithNode tree = new TreeWithNode();
		tree.add(10);
		tree.add(5);
		tree.add(15);
		tree.add(12);

		int altura = tree.getHeight();
		
		System.out.println(altura);
		
	}

}
