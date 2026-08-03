public abstract class Conta {

    protected static int contador = 1;

    protected int numeroConta;
    protected String titular;
    protected double saldo;

    public Conta(String titular) {
        this.numeroConta = contador++;
        this.titular = titular;
        this.saldo = 0;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public abstract void sacar(double valor);
}