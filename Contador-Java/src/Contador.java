import java.util.Scanner;

// Este programa deve receber dois parâmetros inteiros e imprimir todos os números entre eles, inclusive os próprios parâmetros.
// Caso o primeiro parâmetro seja maior que o segundo, deve lançar uma exceção personalizada chamada ParametrosInvalidosException.
// A exceção deve ser tratada no método main, onde o programa deve imprimir uma mensagem de erro informando que o segundo parâmetro deve ser maior que o primeiro.
public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.println("Digite o primeiro parâmetro");
        int parametroUm = terminal.nextInt();
        System.out.println("Digite o segundo parâmetro");
        int parametroDois = terminal.nextInt();

        try {
            contar(parametroUm, parametroDois);

        } catch (ParametrosInvalidosException exception) {
            System.out.println("ERRO!! O segundo parâmetro deveria ser maior que o primeiro");
            
            //atualização do programa...

            System.out.println("contudo o programa irá continuar a execução");
            System.out.println("Contando de " + parametroUm + " até " + parametroDois);
            System.out.println("de forma invertida");
            
            // Aqui o programa deve contar de parametroUm até parametroDois, mesmo que o primeiro parâmetro seja maior que o segundo.
            // O programa deve imprimir todos os números entre os dois parâmetros, inclusive os próprios parâmetros.    

            int contando = parametroUm - parametroDois;
            for (int i = 0; i <= contando; i++) {
                System.out.println(parametroUm - i);
            }
        }

        terminal.close();
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException();
        }

        int contagem = parametroDois - parametroUm;
        for (int i = 0; i <= contagem; i++) {
            System.out.println(parametroUm + i);
        }
    }
}

class ParametrosInvalidosException extends Exception {
}