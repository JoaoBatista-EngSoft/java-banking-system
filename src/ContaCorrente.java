public class ContaCorrente extends Conta {

    public ContaCorrente(String titular) {
        super(titular);
    }

    @Override
    public void sacar(double valor) {

        if(valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}