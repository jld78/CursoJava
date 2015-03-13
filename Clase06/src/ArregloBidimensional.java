
public class ArregloBidimensional {

	public static void main(String[] args) {
		
	
	int [][] arr2 = new int[2][2];
	int filas = arr2.length;
	
	System.out.println("Filas: " + filas);
	
	int columnas = arr2[0].length;
	
	System.out.println("Columnas: " + columnas);
	
	arr2[0][1] = 10;
	
	System.out.println(arr2[0][1]);
	
	int[][] arr3 = new int[2][];
	
	System.out.println(arr3[0]);
	System.out.println(arr3[1]);
	
	arr3[0] = new int[2];
	
	System.out.println(arr3[0][0]);
	System.out.println(arr3[0][1]);
	
	arr3[1] = new int[3];
	
	
	
	}
	
}
