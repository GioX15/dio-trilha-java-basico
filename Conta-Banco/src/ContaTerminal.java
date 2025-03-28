import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public double Saldo;
    public String NomeClient;
    public String Agencia;
    public int Numero;

    public static void main(String[] args) {
        System.out.println("Criando sua conta bancaria");
        Scanner Scanner=new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Digite o seu primeiro nome: ");
        String MeuNome = Scanner.nextLine();
        System.out.println("Digite o seu sobrenome: ");
        String MeuSobrenome = Scanner.nextLine();
        System.out.println("Digite o número da sua agência: ");
        String MinhaAgencia = Scanner.nextLine();
        System.out.println("Digite o número da sua conta: ");
        int MeuNumero = Scanner.nextInt();
        System.out.println("Digite o valor do seu saldo: ");
        double MeuSaldo = Scanner.nextDouble();
        String MeuNomeCompleto = MeuNome + " " + MeuSobrenome;
        ContaTerminal Conta= new ContaTerminal();
        Conta.NomeClient = MeuNomeCompleto;
        Conta.Agencia = MinhaAgencia;
        Conta.Numero = MeuNumero;
        Conta.Saldo = MeuSaldo;

        System.out.println("ola sr(a)."+Conta.NomeClient + ",obrigado por criar uma conta em nosso banco, sua agência é: " + Conta.Agencia + ",o número da sua conta é: " + Conta.Numero + " e seu saldo: R$" + Conta.Saldo+"ja esta disponivel para saque");
    }
}



