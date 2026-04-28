package banco.modelo;

public class ContaPoupanca extends ContaBancaria {
    private double percentualRendimento;

    public ContaPoupanca(String numero, String titular, double saldo, double percentualRendimento) {
        super(numero, titular, saldo);
        this.percentualRendimento = percentualRendimento;
    }

    public double getPercentualRendimento() {
        return percentualRendimento;
    }

    public void setPercentualRendimento(double percentualRendimento) {
        this.percentualRendimento = percentualRendimento;
    }

    @Override
    public boolean sacar(double valor) {
        // Conta Poupança não possui limite extra, usa a lógica padrão mas podemos sobrescrever 
        // para dar um comportamento diferenciado se necessário, conforme pedia o UML.
        // Aqui usaremos o mesmo comportamento, mas garantindo a chamada personalizada.
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque da Conta Poupança realizado com sucesso.");
            System.out.println("Valor sacado: " + valor);
            System.out.println("Saldo atual: " + this.saldo);
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para o saque na Conta Poupança.");
            return false;
        }
    }
}
