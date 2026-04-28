# Guia de OOP: Encapsulamento

Uma das mudanças drásticas que aplicamos ao seu código comparado à versão base, foi o **Encapsulamento**.

## O Que é Encapsulamento em Java?
Encapsular significa juntar, guardar e trancar o estado interno de um objeto, de modo que partes externas do código não consigam intervir sem permissão. Você não diz à uma televisão "mude o brilho para 13", você aperta um botão no controle remoto ou acessa o menu. Em programação, esse é o papel dos **Modificadores de Acesso**, as famosas palavras `public`, `private` e `protected`.

Na antiga aplicação, você tinha atributos assim dentro da classe Principal:
```java
public double Saldo;
public String nome;
public String cpf;
```
Qualquer outra classe poderia simplesmente quebrar o seu código escrevendo `conta.Saldo = -5000;`. O banco estaria falido.

## Como Aplicamos No Seu Projeto?

### Passo 1: Private (Privado)

Nós escondemos todos os detalhes. Observe o nosso modelo `Cliente.java`:
```java
public class Cliente {
    private String nome;
    private String cpf;
```
Ao usar `private`, **nenhuma outra classe**, nem sequer a Classe Principal `Banco.java`, consegue "ver" nem encostar diretamente nas variáveis `nome` e `cpf`.

### Passo 2: O Controle Remoto (Getters e Setters)

Para podermos alterar os dados, o Java costuma usar um padrão chamado `Get` (Pegar) e `Set` (Configurar). Estes métodos são `public`.

```java
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
```
"Onde está a vantagem nisso se de toda forma eu leio e escrevo usando uma função public?"
- **Filtros e Validações:** Você pode, futuramente, adicionar dentro do `setNome(...)` do banco uma regra: `if (nome == "") { // não permite criar sem nome }`.
- **Protegendo a conta:** O Saldo do cliente na classe `ContaBancaria` que criamos **NÃO POSSUI** um `setSaldo(double)`. Somente os métodos `depositar(valor)` e `sacar(valor)` alteram a variável através de regras estritas (só deposita valor acima de zero). É um código perfeito. Ninguém pode forjar um `conta.setSaldo(100000)`.


## Conclusão de Nuances: `protected`

Nosso modelo base `ContaBancaria.java` tem a linha:
```java
protected double saldo;
```
O que é `protected` e qual a diferença para o `private` e `public`?

- `public`: Acesso livre universal do projeto inteiro.
- `private`: Acesso **exclusivamente** trancado para dentro do arquivo em questão (`.java`). Nem as filhas herdeiras enxergam.
- `protected`: Apenas as classes contidas no **mesmo pacote (pasta)** e/ou as **classes filhas (extends)** podem acessar essa variável. 

Nós utilizamos o `protected` para que a `ContaPoupanca` e a `ContaCorrente` conseguissem visualizar internamente o saldo (exemplo: `this.saldo += valor;`) para deduzir limites, visto que elas herdam de `ContaBancaria`. Porém, como o `Banco.java` está na pasta `banco.main`, ele continua **bloqueado de alterar o saldo diretamente e só tem à disposição o public getSaldo()!**. Essa é uma bela demonstração do poder do encapsulamento no Java.
