# 🏦 Rodrigo Bank - Sistema Bancário Simulado
**Desenvolvido em:** Java 26 | **Contexto:** Bootcamp Java Santander 2026.1


## 📋 Requisitos do Desafio

O projeto foi desenvolvido seguindo estritamente os seguintes critérios propostos pelo curso:

* 💻 **Menu Interativo:** Menu funcional com opção de saída para finalização da execução.
* 💳 **Operações Obrigatórias:** Consultar saldo, consultar cheque especial, depositar, sacar, pagar boleto e verificar uso do cheque especial.
* 🛠️ **Regra de Criação de Conta:**
    * Se o depósito inicial for menor ou igual a R\$ 500,00 -> Cheque especial fixo de R\$ 50,00.
    * Se o depósito inicial for maior que R\$ 500,00 -> Cheque especial de 50% do valor depositado.
* 📈 **Regra de Taxação:** Cobrança automatizada de uma taxa de 20% sobre o valor utilizado do cheque especial assim que um depósito for realizado.

O **Rodrigo Bank** é uma aplicação de console desenvolvida em Java que simula o funcionamento core de uma conta corrente bancária. O projeto foi construído como parte prática do **Bootcamp Santander**, com o objetivo de aplicar conceitos sólidos de Programação Orientada a Objetos (POO), arquitetura de software e tratamento robusto de fluxos de dados.

O grande diferencial deste projeto é a fidelidade às regras de negócios complexas do mundo real, incluindo a gestão de limites dinâmicos de cheque especial, cobrança de taxas de juros proporcionais inversas em depósitos picados e blindagem contra falhas de entrada do usuário.

---

## 🎯 Desafios Técnicos Solucionados (Destaques para Recrutadores)

Durante o desenvolvimento do ecossistema do Rodrigo Bank, foquei em resolver gargalos comuns de engenharia de software:

* **Arquitetura de Defesa em Camadas (Defense in Depth):** Implementação de validações críticas tanto na camada de Interface de Usuário (`Main`) quanto na camada de Domínio/Regras de Negócio (`CheckingAccount`), garantindo que o sistema nunca processe estados financeiros inválidos.
* **Cálculo de Juros Imune a Frações (Taxa Proporcional Inversa):** Correção de um erro clássico de lógica financeira linear. O sistema utiliza a operação inversa da taxa (divisão por `1.20`) para garantir cobranças de juros estritamente proporcionais e justas, independentemente de o cliente quitar sua dívida de uma vez ou por meio de múltiplos depósitos parciais.
* **Centralização e Reutilização de Código (Generics & Polymorphism):** Criação de um método mestre utilitário (`lerNumeroSeguro`) que utiliza herança com a classe `Number` para centralizar o tratamento de erros do console, eliminando duplicações de blocos `try/catch` no sistema.
* **Blindagem Total contra Travamentos (Buffer Safety):** Substituição de leituras parciais do teclado por leituras de linhas completas (`scanner.nextLine()`), tratando falhas críticas como `InputMismatchException` e entradas vazias de forma silenciosa para o usuário.
* **Portabilidade de Plataforma:** Padronização das quebras de linha com `%n` via `System.out.printf`, garantindo comportamento visual idêntico se executado em ambientes Windows, Linux ou macOS.

---

## ⚙️ Funcionalidades principais

1. **Abertura de Conta Corrente:** Definição automatizada do limite do cheque especial com base no aporte inicial (50% do valor para depósitos acima de R$ 500,00 ou R$ 50,00 fixos para valores menores).
2. **Consulta de Extrato Transparente (UX Avançada):** Exibição condicional e detalhada do status da conta, separando saldo pessoal, limite utilizado, taxas acumuladas e o valor exato necessário para quitação do débito.
3. **Depósito e Amortização:** Sistema inteligente de recepção de valores que prioriza a quitação do cheque especial com taxa de 20% antes de direcionar o saldo para a conta corrente.
4. **Saque e Pagamento de Boletos:** Fluxo de débito integrado que realiza a transição automática e limpa entre o uso do saldo real e o acionamento do limite de crédito disponível.
5. **Monitoramento do Cheque Especial:** Consulta rápida do valor exato em uso do teto de crédito contratado.

---

## 📁 Estrutura de Classes

* **`CheckingAccount.java` (Camada de Domínio):** Centraliza os atributos (`balance`, `specialLimit`, `overdraftLimitAvailable`) e encapsula rigidamente as regras de cálculo financeiro e métodos de mutação segura de estado.
* **`Main.java` (Camada de Interface/Console):** Responsável pela interação direta com o usuário, controle de fluxo por menus interativos com padrões modernos de Java (*Arrow Labels*) e saneamento de dados de entrada do teclado.

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
* Java JDK 17 ou superior instalado.
* IDE de sua preferência (recomendado IntelliJ IDEA).

### Passo a passo
1. Clone este repositório:
   ```bash
   git clone https://github.com
   ```
2. Abra o projeto na sua IDE.
3. Execute a classe `Main.java`.

---

> 💡 **Obs:** Recomendo a leitura do [README.md Raiz](https://github.com/rodrigomgrassioto/BootcampSantander2026-01) para conhecer todos os projetos e o progresso completo desenvolvido ao longo do curso.


---

## 🛠️ Tecnologias e Conceitos Aplicados

* **Java SE** (Tipagem Estrita, Estruturas de Repetição `do-while`, Controle Condicional Aninhado).
* **Orientação a Objetos** (Encapsulamento, Construtores, Delegação de Responsabilidade).
* **Tratamento de Exceções** (`try-catch`, `NumberFormatException`).
* **Polimorfismo e Classes Abstratas** (Uso de `java.lang.Number`).
* **Clean Code** (Uso de *Guard Clauses* para evitar aninhamento de `else`, nomenclatura expressiva em inglês para métodos e variáveis).

---

💡 *Este projeto demonstra minha capacidade de traduzir regras complexas de negócio em código limpo, seguro, performático e estruturado sob as melhores práticas do mercado de desenvolvimento Java.*
