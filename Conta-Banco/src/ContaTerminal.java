import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public double Saldo;
    public String NomeClient;
    public String Agencia;
    public int Numero;

/*
 * este programa busca criar uma conta bancaria, onde o usuario informa os dados cujo são
 * armazenados em variaveis, e depois são impressos na tela, com o nome do cliente, o numero da conta, o numero da agencia e o saldo.
 */
    public static void main(String[] args) {
        System.out.println("Criando sua conta bancaria");
        Scanner Scanner=new Scanner(System.in).useLocale(Locale.US); // Scanner para ler os dados do usuario
        System.out.println("Digite o seu primeiro nome: ");
        String MeuNome = Scanner.nextLine(); // Leitura do primeiro nome do cliente
        System.out.println("Digite o seu sobrenome: ");
        String MeuSobrenome = Scanner.nextLine(); // Leitura do sobrenome do cliente
        System.out.println("Digite o número da sua agência: ");
        String MinhaAgencia = Scanner.nextLine(); // Leitura do número da agência
        System.out.println("Digite o número da sua conta: ");
        int MeuNumero = Scanner.nextInt(); // Leitura do número da conta
        System.out.println("Digite o valor do seu saldo: ");
        double MeuSaldo = Scanner.nextDouble(); // Leitura do saldo da conta
        String MeuNomeCompleto = MeuNome + " " + MeuSobrenome; // Criação do nome completo do cliente
        ContaTerminal Conta= new ContaTerminal();
        Conta.NomeClient = MeuNomeCompleto; // Atribuição do nome completo à variável NomeClient
        Conta.Agencia = MinhaAgencia;  // Atribuição do número da agência à variável Agencia
        Conta.Numero = MeuNumero; // Atribuição do número da conta à variável Numero
        Conta.Saldo = MeuSaldo; // Atribuição do saldo à variável Saldo

        System.out.println("ola sr(a)."+Conta.NomeClient + ",obrigado por criar uma conta em nosso banco, sua agência é: " + Conta.Agencia + ",o número da sua conta é: " + Conta.Numero + " e seu saldo: R$" + Conta.Saldo+"ja esta disponivel para saque");
    }
}



