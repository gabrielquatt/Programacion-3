package Tp_2;

public class Recursividad {

	void imprimirRec(int x) {
		if (x > 0) {
			System.out.println(x);
			imprimirRec(x - 1);
			System.out.println(x);
		}
	}

	public static void main(String[] ar) {
		Recursividad re = new Recursividad();
		re.imprimirRec(5);
		System.out.println("resultado: " + calcular(5,3));
	}

	public static int calcular(int x, int n) {
		if (n <= 0) {
			return 1;
		} else {
			return x * calcular(x, n - 1);
		}
	}

}
