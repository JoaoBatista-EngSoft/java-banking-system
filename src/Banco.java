import java.util.ArrayList;

public class Banco {

    private ArrayList<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarConta(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numero) {
                return conta;
            }
        }
        return null;
    }

    public void listarContas() 
    {
        for (Conta conta : contas) 
        {
            System.out.println(
            "Conta: " + conta.getNumeroConta() +
            " | Titular: " + conta.getTitular() +
            " | Saldo: R$ " + conta.getSaldo()
            );
        }
    }   
}