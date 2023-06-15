package disenioclases;

public class Ejercicio03 {
    public static void main(String[] args) {
        Cartera miCartera = new Cartera(50.0);
        System.out.println("Mi saldo actual es: " + miCartera.consultarSaldo());
        miCartera.sacarDinero(20.0);
        System.out.println("Mi saldo actual es: " + miCartera.consultarSaldo());
        miCartera.meterDinero(10.0);
        System.out.println("Mi saldo actual es: " + miCartera.consultarSaldo());
        miCartera.sacarDinero(100.0);
        System.out.println("Mi saldo actual es: " + miCartera.consultarSaldo());
    }
}
