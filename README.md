# 🏦 Sistema Bancário - Banco LB

Sistema bancário desenvolvido em Java como projeto prático de estudo de Programação Orientada a Objetos (POO).

## 📋 Funcionalidades

- Abertura de conta (Conta Corrente ou Conta Poupança)
- Autenticação por número de conta e senha (com limite de tentativas)
- Depósito e saque
- Fechamento de conta
- Exibição de informações da conta
- Cobrança de taxa mensal por tipo de conta

## 🛠️ Tecnologias

- Java 20
- IntelliJ IDEA

## 📚 Conceitos praticados

- Programação Orientada a Objetos (POO)
- Herança e Template Method (classe abstrata `Conta` define o fluxo, subclasses `ContaCorrente`/`ContaPoupanca` implementam as regras específicas de cada tipo)
- Encapsulamento (senha nunca é exposta, apenas verificada)
- Uso de enums para representar resultados de operações, separando a regra de negócio da apresentação ao usuário
- Métodos e atributos
- Reutilização de código
- Estruturas de repetição
- Switch case
- Validação de dados
- Organização de código em pacotes (model, enums, app)

## 📁 Estrutura do Projeto

~~~~
src/
└── sistemabancario/
    ├── app/
    │   └── Banco01.java         # Ponto de entrada e interação com o usuário
    ├── enums/
    │   ├── ResultadoAbertura.java
    │   ├── ResultadoDeposito.java
    │   ├── ResultadoFechamento.java
    │   ├── ResultadoSaque.java
    │   └── ResultadoStatus.java
    └── model/
        ├── Conta.java           # Classe abstrata com regras comuns (Template Method)
        ├── ContaCorrente.java   # Regras específicas de conta corrente
        └── ContaPoupanca.java   # Regras específicas de conta poupança
~~~~

## 🚀 Como executar

1. Clone o repositório
2. Abra o projeto no IntelliJ IDEA
3. Execute a classe `Banco01.java`

## 👨‍💻 Autor

Lucas Barros — [LinkedIn](https://www.linkedin.com/in/lucas-barros-3928761b0/) | [GitHub](https://github.com/Lucasbarros190504)