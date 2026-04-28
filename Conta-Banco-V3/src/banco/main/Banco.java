package banco.main;

import banco.modelo.Cliente;
import banco.modelo.ContaBancaria;
import banco.modelo.ContaCorrente;
import banco.modelo.ContaPoupanca;
import banco.util.RegistroCPF;
import java.util.Locale;
import java.util.Scanner;

public class Banco {

    public static void main(String[] args) {
        RegistroCPF registro = new RegistroCPF();
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Criando sua conta no banco");
        
        System.out.println("Digite o seu nome: ");
        String mnome = scanner.nextLine();
        
        System.out.println("Digite os seus sobrenomes: ");
        String msnome = scanner.nextLine();
        
        System.out.println("Digite o seu cpf: ");
        String mcpf = scanner.nextLine();

        boolean resultado = registro.cpfverific(mcpf);
        if (resultado) {
            System.out.println("CPF valido.");
        } else {
            System.out.println("CPF invalido.");
            while (!resultado) {
                System.out.println("Digite um CPF valido: ");
                mcpf = scanner.nextLine();
                resultado = registro.cpfverific(mcpf);
            }
        }
        
        String nomeCompleto = mnome + " " + msnome;
        Cliente cliente = new Cliente(nomeCompleto, mcpf);
        
        String numeroConta = String.valueOf((int) (Math.random() * 1000));
        double saldoInicial = 0;
        
        ContaBancaria conta = null;
        
        System.out.println("Qual tipo de conta deseja criar?");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupanca");
        int tipoConta = scanner.nextInt();
        
        if (tipoConta == 1) {
            System.out.println("Digite o limite do cheque especial da sua nova Conta Corrente: ");
            double limite = scanner.nextDouble();
            conta = new ContaCorrente(numeroConta, cliente.getNome(), saldoInicial, limite);
            conta.setCliente(cliente);
        } else {
            System.out.println("Sua Conta Poupanca terá rendimento padrão de 0.5% ao mês.");
            conta = new ContaPoupanca(numeroConta, cliente.getNome(), saldoInicial, 0.5);
            conta.setCliente(cliente);
        }
        
        System.out.println("\nSr(a). " + conta.getCliente().getNome() + ", sua conta foi criada com sucesso!");
        System.out.println("Nome: " + conta.getCliente().getNome());
        System.out.println("CPF: " + conta.getCliente().getCpf());
        System.out.println("Número da Conta: " + conta.getNumeroConta());
        System.out.println("Saldo: " + conta.getSaldo());
        
        int opcao = 0;
        
        while (opcao != 4) {
            System.out.println("\nO que deseja fazer?");
            System.out.println("1 - Saque");
            System.out.println("2 - Deposito");
            System.out.println("3 - Transferencia");
            System.out.println("4 - Sair");
            
            opcao = scanner.nextInt();
            
            if (opcao == 1) {
                System.out.println("Digite o valor do saque: ");
                double valors = scanner.nextDouble();
                conta.sacar(valors);
            } else if (opcao == 2) {
                System.out.println("Digite o valor do deposito: ");
                double valord = scanner.nextDouble();
                conta.depositar(valord);
            } else if (opcao == 3) {
                System.out.println("Digite o valor da transferencia: ");
                double valort = scanner.nextDouble();
                // Transferência simplificada (apenas saca da conta atual)
                boolean sucesso = conta.sacar(valort);
                if (sucesso) {
                    System.out.println("Transferencia enviada com sucesso para o destinatario.");
                } else {
                    System.out.println("Falha na transferencia.");
                }
            } else if (opcao == 4) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Opçao invalida.");
            }
        }
        
        System.out.println("Obrigado sr(a). " + conta.getCliente().getNome() + " por usar nosso banco. Tenha um otimo dia!");
        scanner.close();
    }
}
