# Desafio Contador DIO Bradesco

Este repositório contém a solução para o desafio do contador proposto no bootcamp DIO Bradesco. O desafio consiste em criar um programa Java que recebe dois números inteiros do usuário e realiza a contagem do primeiro número até o segundo.

## Funcionalidades

-   Solicita ao usuário que digite dois números inteiros.
-   Realiza a contagem do primeiro número até o segundo, exibindo cada número no console.
-   Implementa tratamento de exceção para garantir que o segundo número seja maior que o primeiro.
-   Caso o segundo número seja menor que o primeiro, exibe uma mensagem de erro e realiza a contagem invertida.

## Como Executar

1.  Clone este repositório para sua máquina local:

    ```bash
    clone o repositorio
    ```

2.  Navegue até o diretório do projeto:

    ```bash
    cd [dio-trilha-java-basico/Contador-Java]
    ```

3.  Compile o código Java:

    ```bash
    javac Contador.java
    ```

4.  Execute o programa:

    ```bash
    java Contador
    ```

## Tratamento de Exceções

O programa inclui um tratamento de exceções para garantir que o segundo número digitado pelo usuário seja maior que o primeiro. Caso contrário, uma exceção `ParametrosInvalidosException` será lançada e a seguinte mensagem de erro será exibida no console:


Além disso, o programa realizará a contagem de forma invertida, do segundo número até o primeiro.

## Estrutura do Projeto

-   `Contador.java`: Contém a classe principal `Contador` com a lógica do programa.
-   `ParametrosInvalidosException.java`: Define a exceção personalizada `ParametrosInvalidosException`.
-   `README.md`: Este arquivo, contendo a documentação do projeto.

## Atualizações

-   **1.1:** Adicionado tratamento de exceção para contagem invertida. Agora, caso o segundo número seja menor que o primeiro, o programa exibe uma mensagem de erro e realiza a contagem de forma invertida.

## Contribuição

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões de melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Autor

-   \GioX15
