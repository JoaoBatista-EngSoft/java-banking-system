import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n===== BANCO =====");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Ver saldo");
            System.out.println("6 - Listar contas");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Nome do titular: ");
                    String nome = scanner.nextLine();

                    Conta novaConta = new ContaCorrente(nome);
                    banco.adicionarConta(novaConta);

                    System.out.println("Conta criada! Número: " + novaConta.getNumeroConta());
                    break;

                case 2:
                    System.out.print("Número da conta: ");
                    int numDep = scanner.nextInt();
                    scanner.nextLine();

                    Conta contaDep = banco.buscarConta(numDep);

                    if (contaDep != null) {
                        System.out.print("Valor: ");
                        double valorDep = scanner.nextDouble();
                        scanner.nextLine();

                        contaDep.depositar(valorDep);
                        System.out.println("Depósito realizado!");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Número da conta: ");
                    int numSaq = scanner.nextInt();
                    scanner.nextLine();

                    Conta contaSaq = banco.buscarConta(numSaq);

                    if (contaSaq != null) {
                        System.out.print("Valor: ");
                        double valorSaq = scanner.nextDouble();
                        scanner.nextLine();

                        contaSaq.sacar(valorSaq);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Conta de origem (número): ");
                    int origem = scanner.nextInt();

                    System.out.print("Conta de destino (número): ");
                    int destino = scanner.nextInt();

                    scanner.nextLine();

                    Conta contaOrigem = banco.buscarConta(origem);
                    Conta contaDestino = banco.buscarConta(destino);

                    if (contaOrigem != null && contaDestino != null) {

                        System.out.print("Valor: ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();

                        if (contaOrigem.getSaldo() >= valor) {
                            contaOrigem.sacar(valor);
                            contaDestino.depositar(valor);

                            System.out.println("Transferência realizada!");
                        } else {
                            System.out.println("Saldo insuficiente.");
                        }

                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 5:
                    System.out.print("Número da conta: ");
                    int numSal = scanner.nextInt();
                    scanner.nextLine();

                    Conta contaSal = banco.buscarConta(numSal);

                    if (contaSal != null) {
                        System.out.println("Saldo: R$ " + contaSal.getSaldo());
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 6:
                    banco.listarContas();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}