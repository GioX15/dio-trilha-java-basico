# Calculadora de Média Escolar em Java

Este programa Java calcula a média de notas de um aluno e determina se ele foi aprovado, reprovado ou precisa fazer prova de recuperação.

## Funcionalidades

* Solicita ao usuário que insira o nome, idade, curso e três notas do aluno.
* Calcula a média das notas.
* Exibe a média do aluno.
* Informa se o aluno foi aprovado, reprovado ou precisa fazer prova de recuperação, com base nas seguintes condições:
    * Aprovado: média superior a 70.0
    * Recuperação: média entre 50.0 e 70.0
    * Reprovado: média inferior a 50.0

## Tratamento de Exceções

O programa inclui tratamento de exceções para lidar com entradas inválidas do usuário. Especificamente, ele captura a exceção `InputMismatchException` que pode ocorrer quando o usuário insere um valor que não corresponde ao tipo esperado (por exemplo, inserir uma string em vez de um número inteiro para a idade).

**Como o tratamento de exceções funciona:**

1. O código que pode lançar a exceção é colocado dentro de um bloco `try`.
2. Se a exceção `InputMismatchException` ocorrer, o bloco `catch` correspondente é executado.
3. Dentro do bloco `catch`, uma mensagem de erro é exibida, informando ao usuário sobre a entrada inválida.
4. O buffer do `Scanner` é limpo usando `scanner.next()` para evitar que a entrada inválida cause problemas em leituras futuras.
5. O programa solicita novamente ao usuário que insira a entrada correta.

Essa abordagem garante que o programa não falhe devido a entradas inválidas e fornece feedback claro ao usuário sobre como corrigir o problema.

## Como Executar

1. Certifique-se de ter o Java Development Kit (JDK) instalado em seu sistema.
2. Clone este repositório Git.
3. Compile o código Java usando o comando `javac Escola.java`.
4. Execute o programa usando o comando `java Escola`.

## Requisitos

* Java Development Kit (JDK) 8 ou superior.

## Observações

Este código é uma implementação básica para fins de aprendizado e demonstração.

Sinta-se à vontade para explorar e modificar o código para aprimorar suas habilidades em Java.

## Autor

Este código foi desenvolvido por \Giox15.