package disenioclases;

public class Cartera {
    private double saldo;

    public Cartera() {
        this.saldo = 0.0;
    }

    public Cartera(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void sacarDinero(double cantidad) {
        if (saldo == 0) {
            System.out.println("NO TIENES SALDO DISPONIBLE.");
        } else if (cantidad <= saldo) {
            saldo -= cantidad;
        } else {
            System.out.println("TU SALDO SE HA QUEDADO A 0.");
            saldo = 0;
        }
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void meterDinero(double cantidad) {
        saldo += cantidad;
    }
}

