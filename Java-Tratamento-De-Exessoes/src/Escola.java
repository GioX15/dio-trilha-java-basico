import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

 class Aluno {

    // Atributos da classe Aluno
    public String nome;
    public int idade;
    public String curso;
    public double nota1, nota2, nota3, media;
    
   
    
    // Método para calcular a média das notas
    public void calcularMedia() {
        media = (nota1 + nota2 + nota3) / 3.0;
    }

}

public class Escola {

    public static void main(String[] args) throws Exception {

        double media1 = 50.0;
        double media2 = 70.0;

    
        Aluno aluno = new Aluno();
    
         Scanner scanner= new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Digite o seu nome: ");
        aluno.nome = scanner.nextLine();
        try { 
        System.out.println("Digite a sua idade: ");
        aluno.idade = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Erro:" + e.getMessage());
            scanner.next(); 
            System.err.println(" nao escreva a idade ou use ponto e virgula, digite apenas o número inteiro");
            System.out.println("Digite a sua idade: ");
            aluno.idade = scanner.nextInt(); 
        }
        System.out.println("Digite o seu curso: ");
        aluno.curso = scanner.next();

        try {
            System.out.println("Digite a primeira nota: ");
            aluno.nota1 = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Erro:" + e.getMessage());
            scanner.next(); 
            System.err.println(" nao escreva a nota ou use ponto e virgula, digite apenas o número inteiro");
            System.out.println("Digite a primeira nota: ");
            aluno.nota1 = scanner.nextDouble(); 
        }
        try {
            System.out.println("Digite a segunda nota: ");
            aluno.nota2 = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Erro:" + e.getMessage());
            scanner.next(); 
            System.err.println(" nao escreva a nota ou use ponto e virgula, digite apenas o número inteiro");
            System.out.println("Digite a segunda nota: ");
            aluno.nota2 = scanner.nextDouble(); 
        }
        try {
            System.out.println("Digite a terceira nota: ");
            aluno.nota3 = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Erro:" + e.getMessage());
            scanner.next(); 
            System.err.println(" nao escreva a nota ou use ponto e virgula, digite apenas o número inteiro");
            System.out.println("Digite a terceira nota: ");
            aluno.nota3 = scanner.nextDouble(); 
        }
        
        aluno.calcularMedia();
        System.out.println("A Sua Média Foi de " + aluno.media);
        if (aluno.media > media2) {
            System.out.println(aluno.nome + " voce foi Aprovado " + aluno.curso + " com media de " + aluno.media);
        } else if (aluno.media >= media1) {
            System.out.println(aluno.nome + " voce vai ter que fazer prova de recuperacao no curso " + aluno.curso + " sua media foi " + aluno.media);
        } else {
            System.out.println(aluno.nome + " voce foi Reprovado no curso " + aluno.curso + " com media de " + aluno.media);
        }
        scanner.close();
    }
}
