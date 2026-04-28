# Guia de Execução: O Passo a Passo do Nosso Banco

Neste documento, vamos analisar o código do arquivo `Banco.java` (a nossa classe Principal) e entender exatamente a sequência de acontecimentos quando rodamos o programa. Em Java, a porta de entrada de qualquer aplicação de console é o famoso método `public static void main(String[] args)`.

---

## 1. O Ponto de Partida (`main`)

Assim que você aperta "Run" (ou executa `java banco.main.Banco`), o Java procura o método `main`. Ele funciona como a fundação de tudo:
```java
public static void main(String[] args) {
    RegistroCPF registro = new RegistroCPF();
    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    // ...
```
- **O que acontece aqui:** 
  1. Instanciamos a nossa classe auxiliar de validação (`RegistroCPF`) que criamos no pacote `util`.
  2. Inicializamos a classe nativa do Java `Scanner`. É ela que permite que o programa pare, espere você digitar no teclado e grave o resultado. `useLocale(Locale.US)` garante que números decimais sejam parseados com ponto `.` e não vírgula `,`.

---

## 2. Coletando Dados do Cliente

Em seguida, o código interage pedindo nome e sobrenome usando `scanner.nextLine()`.
Logo depois, há um loop do nosso algoritmo de CPF:

```java
boolean resultado = registro.cpfverific(mcpf);
if (resultado) {
    System.out.println("CPF valido.");
} else {
    while (!resultado) {
        System.out.println("Digite um CPF valido: ");
        mcpf = scanner.nextLine();
        resultado = registro.cpfverific(mcpf);
    }
}
```
- **O que acontece aqui:** A função retorna um `boolean` (`true` ou `false`). Se for `false` (inválido), ele prende o usuário em um laço de repetição (`while`) até que a pessoa insira uma sequência matemática que forme um CPF brasileiro.

---

## 3. Instanciando o Cliente: Conhecendo o Operador `new`

```java
Cliente cliente = new Cliente(nomeCompleto, mcpf);
```
Nessa linha ocorre a gravação de fato, em memória, dos dados básicos do usuário no objeto **Cliente**. Repare que não estamos associando uma "Conta" ainda, apenas a "Pessoa". Isso ilustra o Princípio de Responsabilidade Única da Programação Orientada a Objetos.

---

## 4. O Polimorfismo e a Instância da Conta

Eis a parte que o Java brilha com Orientação a Objetos:

```java
ContaBancaria conta = null;
int tipoConta = scanner.nextInt();

if (tipoConta == 1) { // Corrente
    conta = new ContaCorrente(numeroConta, cliente.getNome(), saldoInicial, limite);
    conta.setCliente(cliente);
} else { // Poupança
    conta = new ContaPoupanca(numeroConta, cliente.getNome(), saldoInicial, 0.5);
    conta.setCliente(cliente);
}
```

*Nuances do Java:* Repare que a variável declarada é **`ContaBancaria conta`**, e repare que `ContaBancaria` é uma classe abstrata (você não pode dar `new ContaBancaria(...)`). Porém, nós podemos preencher essa variável com qualquer classe "filha" dela (Herança). Isso se chama **Polimorfismo**.

Quando você fizer `conta.sacar(...)` depois, a Máquina Virtual do Java (JVM) vai verificar: "A variável guarda uma Poupança ou uma Corrente?". O Java executará automaticamente o código da classe correta responsável.

---

## 5. O Loop de Interação com a Conta (Operações)

```java
while (opcao != 4) {
    opcao = scanner.nextInt();
    if (opcao == 1) { // Saque
        double valors = scanner.nextDouble();
        conta.sacar(valors);
    }
    // ...
```
- **O que acontece aqui:** Temos um laço que mantém o console vivo esperando opções do usuário. Caso a opção escolhida seja 1, chamamos a função implementada lá dentro de `ContaCorrente` ou `ContaPoupanca`. A lógica financeira foi totalmente abstraída do `Banco.java`. Quem se encarrega de verificar limite, taxas e de debitar o `saldo` são os modelos da Conta.

---

## Resumo do fluxo
1. O Sistema Inicia.
2. É validado os dados físicos e criamos um objeto modelo do `Cliente`.
3. Questionamos qual o Tipo de Conta.
4. Vinculamos as características e limites dessa conta a um novo objeto que estenda `ContaBancaria`.
5. Entramos em um Loop de Sistema Infinito permitindo depósitos, saques e verificações, até que ele opte pela opção "Sair".
