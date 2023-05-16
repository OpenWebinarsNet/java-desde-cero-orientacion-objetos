package disenioclases;

public class App {

	public static void main(String[] args) {
		
		double[] punto1 = new double[]{0,0};
		double[] punto2 = new double[]{10,0};
		double[] punto3 = new double[]{10,10};
		double[] punto4 = new double[]{0,10};
		
		
		Rectangulo r1 = new Rectangulo(punto1, punto2, punto3, punto4);
		System.out.println(r1);
		r1.dibujar('*');
		
		double[] p1 = new double[]{0,10};
		double[] p2 = new double[]{30,10};
		double[] p3 = new double[]{30,40};
		double[] p4 = new double[]{0,40};
		
		Rectangulo r2 = new Rectangulo(p1,p2,p3,p4);
		
		r2.dibujarVarios(r1, r2);

	}

}
