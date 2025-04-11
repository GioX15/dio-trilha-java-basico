import java.util.Locale;
import java.util.Scanner;

public class Banco {
    //atributos da classe banco, sendo eles: saldo, nome, cpf e id
    public double Saldo;
    public String nome;
    public String cpf;
    public int id;


   /**
    * 
    * @param valor valor que o usuario deseja sacar
    * "faz um teste se o valor do saque é menor ou igual ao saldo
    * se for menor ou igual, o valor é subtraido do saldo e o saldo atualizado"
    * @return void
    * , pois ele altera uma variavel da classe
    */
    public void saque(double valor) {
        if (valor <= Saldo) {
            Saldo -= valor;
            System.out.println("Saque realizado com sucesso");
            System.out.println("valor sacado: " + valor);
            System.out.println("Saldo atual: " + Saldo);
        }
        else {
            System.out.println("Saldo insuficiente");
        }
    }

    /**
     * 
     * @param valor valor que o usuario deseja depositar
     * @return void
     * , pois ele altera uma variavel da classe
     */
    public void deposito(double valor) {
        Saldo += valor;
        System.out.println("Deposito realizado com sucesso");
        System.out.println("valor depositado: " + valor);
        System.out.println("Saldo atual: " + Saldo);
    }

    /**
     * 
     * @param valor valor que o usuario deseja transferir
     * "faz um teste se o valor da transferencia é menor ou igual ao saldo
     * se for menor ou igual, o valor é subtraido do saldo e o saldo atualizado"
     * @return void
     * , pois ele altera uma variavel da classe
     */
    public void transferencia(double valor) {
        if (valor <= Saldo) {
            Saldo -= valor;
            System.out.println("Transferencia realizada com sucesso");
            System.out.println("valor transferido: " + valor);
            System.out.println("Saldo atual: " + Saldo);
        }
        else {
            System.out.println("Saldo insuficiente");
        }
    }

    public static void main(String[] args) {
        RegistroCPF registro = new RegistroCPF(); 
        int opcao= 0; 
        System.out.println("criando sua conta no banco ");
        Scanner scanner= new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Digite o seu nome: ");
        String mnome= scanner.nextLine();
        System.out.println("Digite o seus sobrenomes: ");
        String msnome= scanner.nextLine();
        System.out.println("Digite o seu cpf: ");
        String mcpf= scanner.nextLine();
        int mid= (int) (Math.random() * 1000);
        double msaldo= 0;
        String mnomec= mnome + " " + msnome;
        Banco conta = new Banco();
        conta.Saldo = msaldo;
        conta.nome = mnomec;
        conta.cpf = mcpf;
        registro.cpf = mcpf;
        boolean resultado = registro.cpfverific(mcpf);
        if (resultado) {
            System.out.println("cpf valido");
        } else {
            System.out.println("cpf invalido");
            while (!resultado) {
                System.out.println("digite um cpf valido");
                mcpf= scanner.nextLine();
                resultado = registro.cpfverific(mcpf);
            }
        }
        conta.id = mid;
        System.out.println("sr." + conta.nome + " sua conta foi criada com sucesso");
        System.out.println("Nome: " + conta.nome);
        System.out.println("CPF: " + conta.cpf);
        System.out.println("ID: " + conta.id);
        System.out.println("Saldo: " + conta.Saldo);
        System.out.println("O que deseja fazer?");
        System.out.println("1- saque");
        System.out.println("2- deposito");
        System.out.println("3- transferencia");
        System.out.println("4- sair");

        //aqui o usuario escolhe a opcao que deseja fazer, sendo 1- saque, 2- deposito, 3- transferencia e 4- sair
        //assim que o usuario escolhe a opcao, o programa executa a funcao correspondente
        //e depois pergunta se o usuario deseja fazer outra operacao, se sim, o programa volta a perguntar a opcao
        //se o usuario escolher a opcao 4, o programa encerra
        

        while (opcao!=4) {
            opcao= scanner.nextInt();
        if (opcao == 1) {
            System.out.println("Digite o valor do saque: ");
            double valors= scanner.nextDouble();
            conta.saque(valors);
        }
        else if (opcao == 2) {
            System.out.println("Digite o valor do deposito: ");
            double valord= scanner.nextDouble();
            conta.deposito(valord);
        }
        else if (opcao == 3) {
            System.out.println("Digite o valor da transferencia: ");
            double valort= scanner.nextDouble();
            conta.transferencia(valort);
        }
        else {
            System.out.println("Opção invalida");
        }
        System.out.println("deseja fazer outra operacao?");
        System.out.println("1- saque");
        System.out.println("2- deposito");
        System.out.println("3- transferencia");
        System.out.println("4- sair");
        }
        System.out.println("obrigado sr." + conta.nome  + "por usar nosso banco, tenha um bom dia!");
        scanner.close();
    }
    
}
