package banco.modelo;

public class ContaCorrente extends ContaBancaria {
    private double limiteChequeEspecial;

    public ContaCorrente(String numero, String titular, double saldo, double limite) {
        super(numero, titular, saldo);
        this.limiteChequeEspecial = limite;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= (this.saldo + this.limiteChequeEspecial)) {
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso (sujeito ao limite de cheque especial se aplicável).");
            System.out.println("Valor sacado: " + valor);
            System.out.println("Saldo atual: " + this.saldo);
            return true;
        } else {
            System.out.println("Saldo e limite insuficientes ou valor inválido para o saque.");
            return false;
        }
    }
}
