package polimorfismo;

public class Rectangulo extends Poligono {
	
	Punto p1, p2, p3, p4;

	public Rectangulo(Punto p1, Punto p2, Punto p3, Punto p4) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
	}
	
	public Rectangulo(double x1, double y1,
					  double x2, double y2,
					  double x3, double y3,
					  double x4, double y4) {
		this.p1 = new Punto(x1, y1);
		this.p2 = new Punto(x2, y2);
		this.p3 = new Punto(x3, y3);
		this.p4 = new Punto(x4, y4);
	}
	
	public Rectangulo(double base, double altura) {
		this.p1 = new Punto(0,0);
		this.p2 = new Punto(base, 0);
		this.p3 = new Punto(base, altura);
		this.p4 = new Punto(0, altura);
	}
	
	public double base() {
		return p3.getX() - p4.getX();
	}
	
	public double altura() {
		return p3.getY() - p2.getY();
	}

	@Override
	public void pintar() {
		int base = (int) Math.round(this.base());
		int altura = (int) Math.round(this.altura());

		String pintura = "*";
		
		System.out.println(pintura.repeat(base));

		if (altura > 2) {
			for (int i = 0; i < altura - 2; i++) {
				System.out.print(pintura);
				if (base > 2) {
					System.out.print(" ".repeat(base - 2));
				}
				System.out.println(pintura);
			}
		}

		System.out.println(pintura.repeat(base));

	}

	@Override
	public String toString() {
		return "Rectangulo [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + ", p4=" + p4 + "]";
	}
	
	
	
	

}
