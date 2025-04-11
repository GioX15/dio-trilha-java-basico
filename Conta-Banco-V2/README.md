# Sistema Bancário Simples em Java

Este projeto implementa um sistema bancário básico em Java, onde o usuário pode criar uma conta, realizar operações como saque, depósito e transferência, e ter seu CPF validado.

## Funcionalidades

* **Cadastro de Usuário:**
    * O sistema solicita o nome, sobrenome e CPF do usuário.
    * Gera um número de identificação de conta aleatório.
    * Valida o CPF do usuário utilizando uma função externa.
* **Operações Bancárias:**
    * **Saque:** Permite ao usuário retirar um valor da conta.
    * **Depósito:** Permite ao usuário adicionar um valor à conta.
    * **Transferência:** Permite ao usuário transferir um valor para outra conta.
* **Encerramento:** Permite ao usuário finalizar o programa.

## Estrutura do Projeto

O projeto é composto por duas classes principais:

* `banco.java`:
    * Classe principal que interage com o usuário.
    * Recebe os dados do usuário e gera o número da conta.
    * Chama a função de validação de CPF da outra classe.
    * Apresenta o menu de opções para as operações bancárias.
    * Chama as funções de cada operação bancaria.
* `registrocpf.java`:
    * Classe responsável por validar o CPF do usuário.
    * Contem as funcoes para operações bancarias.

## Como Executar

1.  **Pré-requisitos:**
    * Certifique-se de ter o Java Development Kit (JDK) instalado.
2.  **Compilação:**
    * Abra o terminal e navegue até o diretório do projeto.
    * Compile os arquivos Java usando o comando: `javac banco.java registrocpf.java`
3.  **Execução:**
    * Execute o programa com o comando: `java Main`

## Utilização

1.  O programa solicitará que você insira seu nome, sobrenome e CPF.
2.  Após a validação do CPF, um número de identificação de conta será gerado.
3.  Um menu com as opções de operações bancárias será exibido:
    * Digite 1 para sacar.
    * Digite 2 para depositar.
    * Digite 3 para transferencia.
    * Digite 4 para finalizar o programa.
4.  Siga as instruções para realizar as operações desejadas.

## Observações

* Este é um sistema bancário simples para fins de demonstração.
* A validação de CPF é realizada por uma função externa.
* As funcoes de operações bancarias estão separadas.

## Contribuição

Contribuições são bem-vindas! Se você tiver alguma sugestão de melhoria ou encontrar algum bug, sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Observações

Este código é uma implementação básica para fins de aprendizado e demonstração. Em um cenário real, uma aplicação bancária seria muito mais complexa e robusta.

Sinta-se à vontade para explorar e modificar o código para aprimorar suas habilidades em Java.

## Autor

Este código foi desenvolvido por \Giox15 como parte do desafio do curso de Java Básico da DIO.