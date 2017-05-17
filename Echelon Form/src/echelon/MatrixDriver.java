package echelon;

public class MatrixDriver {
	public static void main(String[] args){
		Matrix a = new Matrix(2,2);
		Matrix b = new Matrix(2,1);
		System.out.println(a);
		System.out.println('\n');
		System.out.println(b);
		
		Matrix c = a.multiply(b);
		System.out.println('\n');
		System.out.println(c);
	}

}
