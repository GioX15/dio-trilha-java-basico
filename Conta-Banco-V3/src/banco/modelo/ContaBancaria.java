package banco.modelo;

import banco.interfaces.OperacoesBancarias;

public abstract class ContaBancaria implements OperacoesBancarias {
    protected double saldo;
    private String titular;
    private String numeroConta;
    private Cliente cliente;

    public ContaBancaria(String numero, String titular, double saldo) {
        this.numeroConta = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getTitular() {
        return titular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito realizado com sucesso.");
            System.out.println("Valor depositado: " + valor);
            System.out.println("Saldo atual: " + this.saldo);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void depositar(double valor, double taxa) {
        if (valor > 0) {
            this.saldo += (valor - taxa);
            System.out.println("Depósito com taxa realizado com sucesso.");
            System.out.println("Valor depositado (líquido): " + (valor - taxa));
            System.out.println("Saldo atual: " + this.saldo);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso.");
            System.out.println("Valor sacado: " + valor);
            System.out.println("Saldo atual: " + this.saldo);
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para o saque.");
            return false;
        }
    }
}
