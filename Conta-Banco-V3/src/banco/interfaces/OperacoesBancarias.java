package banco.interfaces;

public interface OperacoesBancarias {
    boolean sacar(double valor);
    void depositar(double valor);
}
