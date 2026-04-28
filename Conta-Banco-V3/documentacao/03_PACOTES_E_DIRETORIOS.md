# Guia de Criptografia Java: Separação por Pastas (Packages)

No princípio de cada arquivo do seu projeto refatorado, aplicamos os famigerados "pacotes" através de declarações como:
```java
package banco.main;
```

Essa foi a terceira peça chave de nossa modernização. Aqui vamos entender de maneira simples por que é essencial separar o seu código.

## Por Que Pacotes Não São Apenas "Pastas"?

Numa estrutura organizacional padrão de computadores, pastas servem para agrupar coisas pro humano se achar. No Java, pacotes (`packages`) representam um **Filtro Lógico** e um **Namespace** do ecossistema de compilação.
Existem duas motivações chaves:

1. **Evitar Conflitos de Nome:** Você até poderia ter mil arquivos soltos na pasta `src`, mas não poderia ter duas classes denominadas de forma idêntica (Ex: Uma classe de log interno do bando de dados chamada `File.java`, conflitaria com o `File.java` das dezenas de imports do Java para gravar texto nativo do C:). Com pacotes, você ganha acesso seguro usando nomes completos: `java.io.File` versus `meubanco.banco.util.File`.
2. **Camadas Visuais (MVC / Clean Architecture):** Separar os arquivos cria barreiras semânticas e arquitetônicas. No nosso caso, desenhamos camadas.

## Analisando Como o Seu Projeto Está Separado

Observe que toda primeira linha dos nossos códigos contêm o `package br.sua_assinatura;`:

- `banco.interfaces` (Contrato/Acordo)
  - Aqui está o `OperacoesBancarias.java`. Essa pasta guarda todas as regras puramente verbais ("Quais funções um modelo desse sistema têm obrigação de implementar?"). Uma interface não executa código; ela apenas estipula regras e contratos, funcionando como um esqueleto do projeto.
- `banco.modelo` (Entidades do Domínio)
  - Tem nossa `ContaBancaria.java`, `Cliente.java`, `ContaPoupanca.java` e `Corrente.java`. É a raiz de estrutura em código vivo. Modelos tratam unicamente na base estrutural da memória humana do teu projeto (quem é quem, onde guardar propriedades).
- `banco.util` (Utilidades)
  - Aqui está o `RegistroCPF.java`. Funções de máscara, formatadores de data, ou ferramentas soltas que auxiliam cálculos e conversões residem normalmente num pacote "util" (utilities - utilitários genéricos). Elas podem ser jogadas para qualquer outro projeto novo do seu computador sem causar avaria as outras entidades, não possuem lógicas interligadas fortes!
- `banco.main` (Controller / A Porta de Entrada)
  - Temos o `Banco.java`, o maestro do sistema. Se fôssemos utilizar Spring Boot (o maior canivete de Backend), esta camada provavelmente seria nomeada de `banco.controller` onde criariam-se os intermédios com a Internet (APIs). Nela o servidor é levantado e a intersecção de modelos e as "páginas web" ocorreriam.

## Usando o `import` para as pontes inter-pacotes

Por a nossa aplicação estar fragmentada na rede de pastas, no nosso `banco/main/Banco.java` precisamos declarar que queremos **importar** da pasta paralela para usar os comandos, que resulta no topo do arquivo que temos:
```java
package banco.main;

import banco.modelo.Cliente;
import banco.modelo.ContaBancaria;
import banco.modelo.ContaCorrente;
import banco.modelo.ContaPoupanca;
import banco.util.RegistroCPF;
```

> **Curiosidade do Java:** Só é preciso usar a cláusula `import` se o arquivo estiver fora da sua pasta atual! Como a `ContaCorrente` está na mesma pasta da `ContaPoupanca` (ambas no pacote `banco.modelo`), as instâncias fluem livremente entre as filhas sem precisar importar na primeira linha!
