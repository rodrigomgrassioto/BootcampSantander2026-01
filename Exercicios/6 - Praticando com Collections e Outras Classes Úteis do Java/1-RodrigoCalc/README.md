# 🧮 Rodrigo Calc - Motor Avançado de Processamento em Lote com Stream API
Desenvolvido em: Java 26 | Contexto: Bootcamp Java Santander 2026.1

O **Rodrigo Calc** é um motor de processamento matemático automatizado desenvolvido via console para realizar operações aritméticas em lote (múltiplos valores simultâneos). O projeto foi projetado para demonstrar o controle de fluxos de dados complexos através da união de três pilares do Java moderno: o poder de encapsulamento de comportamentos em **Enums Avançados**, a flexibilidade do padrão *Callback* com **Interfaces Funcionais (`@FunctionalInterface`)**, e a eficiência de alta performance da **Java Stream API**.

O grande diferencial deste submódulo é o desacoplamento completo da lógica de cálculo. O fluxo de controle interage puramente com abstrações e delegados funcionais, permitindo que novas operações matemáticas sejam acopladas à arquitetura sem a necessidade de alterar a estrutura do menu ou o fluxo principal do sistema.

Este projeto é um sub-módulo que integra o meu portfólio completo de engenharia Java desenvolvido durante o Bootcamp.

👉 [Acesse o README na Raiz do Repositório para visualizar todos os projetos do Bootcamp](https://github.com/rodrigomgrassioto/BootcampSantander2026-01)

---

## 📋 Requisitos e Comportamentos do Desafio
O sistema processa entradas dinâmicas em uma única linha de comando, tratando strings formatadas e convertendo-as em operações matemáticas lineares baseadas nas seguintes diretrizes de domínio:

*   **Operação de Soma (`SUM`):** Processamento cumulativo em lote que utiliza a identidade nula (`0`) da adição para consolidar coleções de dados via Streams.
*   **Operação de Subtração (`SUBTRACTION`):** Computação linear complexa baseada na ordem de inserção do usuário, onde o primeiro elemento atua como minuendo invariável e os subsequentes como subtraendos, evitando efeitos colaterais de inversão de sinal através de redução sem identidade (`OptionalLong`).
*   **Entrada de Dados Unificada:** Captura de múltiplos números em formato texto delimitados estritamente por vírgulas (ex: `10,20,30`), realizando o *parsing*, higienização de espaços e conversão em tempo de execução.

---

## 🎯 Desafios Técnicos Solucionados (Destaques para Recrutadores e ATS)

Durante o desenvolvimento deste mecanismo de processamento em lote, apliquei padrões avançados de design de código limpo, imutabilidade e engenharia defensiva:

*   **Programação Funcional Acumulativa (`Stream.reduce`):** Substituição de loops imperativos tradicionais (`for`/`while`) e variáveis temporárias de estado por pipelines declarativos da Stream API. A lógica de subtração resolve com precisão o problema da identidade matemática ao utilizar o `reduce((n1, n2) -> n1 - n2)` isolando o primeiro operando de forma nativa.
*   **Encapsulamento de Comportamento em Constantes (`Enum` Avançado):** O enum `Operation` atua como um catálogo vivo de estratégias (*Strategy Pattern*). Cada constante injeta seu próprio caractere de exibição visual (`signal`) e seu respectivo contrato de execução matemática (`Calc`), eliminando estruturas condicionais aninhadas (`if/else` ou `switch` complexos) no fluxo principal.
*   **Padrão Callback via Interfaces Funcionais (`@FunctionalInterface`):** Criação da interface customizada `Calc` com suporte a argumentos variáveis (*Varargs* de `long...`). Isso permite o desacoplamento de chamadas e garante assinaturas limpas baseadas em expressões lambda puras.
*   **Higienização e Engenharia Defensiva de Inputs:** Implementação de rotinas de tratamento de strings através de encadeamentos como `.nextLine().replace(" ", "")`. Essa abordagem limpa e remove espaços em branco acidentais inseridos pelo usuário, garantindo a integridade dos dados antes do início da conversão numérica.
*   **Instâncias de Método Ocultas (Java 21+):** Utilização do recurso de *Unnamed Classes* através da declaração direta do método `void main()`. Essa abordagem reduz o *boilerplate code* visual e foca estritamente na legibilidade estrutural do ponto de entrada do sistema.

---

## 💻 Exemplos de Código e Implementação

### 1. Arquitetura do Enum de Operações com Injeção Funcional
Demonstração de como as regras de negócio matemáticas e os metadados visuais são encapsulados de forma imutável e desacoplada:

```java
public enum Operation {
    // Na soma, a identidade 0 inicia o pipeline com segurança
    SUM(n -> LongStream.of(n).reduce(0, Long::sum), " + ") ,
    
    // Na subtração, a ausência de identidade força o Java a usar o primeiro item como base
    SUBTRACTION(n -> LongStream.of(n).reduce((n1, n2) -> n1 - n2).orElse(0), " - ");

    private final Calc operationCallback;
    private final String signal;

    Operation(final Calc operationCallback, String signal) {
        this.operationCallback = operationCallback;
        this.signal = signal;
    }
    // ... getters encapsulados
}
```

### 2. Pipeline de Processamento em Lote com Stream API
Higienização de dados textuais e conversão segura de tipos de forma declarativa e paralelizável:

```java
// Leitura defensiva e transformação da string delimitada em array de primitivos
var numbers = scanner.nextLine().replace(" ", ""); 

var numberArray = Arrays.stream(numbers.split(","))
        .mapToLong(Long::parseLong)
        .toArray();

// Execução dinâmica via callback injetado pelo Enum selecionado
var result = selectedOperation.getOperationCallback().exec(numberArray);
```

---

## 🚀 Como Executar o Projeto

Este submódulo foi construído de forma limpa e nativa, dependendo exclusivamente dos recursos embutidos na linguagem Java.

### Pré-requisitos
*   **Amazon Corretto 26** como JDK principal instalado.
*   **IntelliJ IDEA** (Configurado com o sistema de build nativo da IDE).

### Passo a Passo no IntelliJ IDEA

1. **Baixe ou atualize o seu repositório local:**
   ```bash
   git clone https://github.com/rodrigomgrassioto/BootcampSantander2026-01/tree/main/Exercicios/6%20-%20Praticando%20com%20Collections%20e%20Outras%20Classes%20%C3%9Ateis%20do%20Java/1-RodrigoCalc
   ```
2. **Abra o Projeto:**
    * Abra o IntelliJ IDEA.
    * Vá em **File > Open** e selecione a pasta deste projeto específico.
3. **Validação do JDK 26:**
    * Pressione `Ctrl + Alt + Shift + S` (Project Structure).
    * Certifique-se de que o **Project SDK** e o **Language Level** estejam definidos como **Java 26 (Corretto)**.
4. **Execute e Teste:**
    * Abra o arquivo que contém o método `void main()`.
    * Clique no botão verde de **Play** (Run) ou utilize o atalho `Shift + F10`.
    * Insira múltiplos valores separados por vírgula no console para validar o processamento em lote.

---

## 🤝 Conecte-se Comigo
Estou focado em projetar arquiteturas backend sólidas, aplicando as melhores atualizações do ecossistema Java. Sinta-se à vontade para analisar meus repositórios ou entrar em contato!

👉 [Acesse meu perfil no LinkedIn para Networking](https://www.linkedin.com/in/devrod)
