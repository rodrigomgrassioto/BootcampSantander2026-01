# 📐 Rodrigo Área Calc - Sistema Dinâmico de Cálculo Geométrico
Desenvolvido em: Java 26 | Contexto: Bootcamp Java Santander 2026.1

O **Rodrigo Área Calc** é uma aplicação interativa via console desenvolvida para solucionar desafios reais de modelagem matemática e arquitetura de software. O projeto foi estruturado durante o Bootcamp Santander para demonstrar a aplicação prática de polimorfismo, desacoplamento de código e a transição de paradigmas em Java: desde o uso clássico de classes imutáveis modernas (`Records`) até o desenvolvimento funcional de alto desempenho com **Expressões Lambda**.

O grande diferencial deste projeto é a capacidade de estender o sistema para novas formas geométricas sem a necessidade de alterar o fluxo de execução principal (`main`), seguindo estritamente os princípios de design de código limpo e escalável.

---

## 📋 Requisitos e Desafios do Domínio
O sistema simula um motor de cálculo geométrico que manipula diferentes estruturas de dados e regras matemáticas específicas para cada forma:

*   **Quadrado (`Square`):** Modelado através de dados imutáveis baseados em um único componente de comprimento lateral.
*   **Retângulo (`Rectangle`):** Estrutura bidimensional focada na correlação entre base e altura para cálculo de superfície.
*   **Círculo (`Circle`):** Aplicação de encapsulamento de constantes matemáticas (`static final double pi`) integrado a operações de potenciação de raio.
*   **Formas Dinâmicas:** Capacidade de injeção de novos comportamentos matemáticos em tempo de execução através de contratos abstratos.

---

## 🎯 Desafios Técnicos Solucionados (Destaques para Recrutadores e ATS)

Durante o desenvolvimento deste motor de cálculo, foquei em aplicar padrões de engenharia de software e recursos de ponta do ecossistema Java:

*   **Desacoplamento via Interfaces (`GeometricShape`):** Criação de um contrato de comportamento unificado. O fluxo principal não conhece as regras de cálculo internas de nenhuma forma, promovendo um design de software flexível e de baixo acoplamento.
*   **Polimorfismo Arquitetural:** Uso de uma única referência de interface para invocar dinamicamente o método `.getArea()` de diferentes objetos. Isso reduz drasticamente o uso de condicionais repetitivas e evita a duplicação do código de exibição (`System.out.printf`).
*   **Imutabilidade com Java Records:** Utilização de `records` para encapsular os dados das formas geométricas (`Square`, `Rectangle`, `Circle`). Essa abordagem elimina o código verboso (Boilerplate), garantindo construtores, getters amigáveis e imutabilidade de estado por padrão.
*   **Programação Funcional com Expressões Lambda (`->`):** Implementação prática do conceito de interfaces funcionais e funções anônimas (similar às *Arrow Functions* do JavaScript). O sistema permite a criação de novas regras matemáticas diretamente no fluxo, reduzindo a criação desnecessária de novos arquivos `.java` para fórmulas simples.
*   **Main Implícita e Recursos Modernos (Java 26):** Utilização de *Implicitly Declared Classes* e métodos principais flexibilizados para acelerar testes, além de uma lógica robusta de leitura de dados (`lerNumeroSeguro`) para evitar falhas de execução no terminal.

---

## ⚙️ Funcionalidades Principais

*   **Menu Interativo:** Interface via linha de comando (CLI) intuitiva para navegação entre as operações de cálculo.
*   **Cálculo Multiforma Unificado:** Processamento dinâmico que centraliza a formatação e exibição dos resultados com precisão de duas casas decimais.
*   **Entrada de Dados Blindada:** Mecanismo defensivo para leitura de dados no console (`lerNumeroSeguro`), validando e convertendo os tipos numéricos para prevenir exceções em tempo de execução.

---

## 🛠️ Tecnologias e Conceitos Aplicados

*   **Java SE 26** (Implicitly Declared Classes, Java Records, Expressões Lambda, Escopos de Visibilidade).
*   **Programação Funcional e Avançada** (Interfaces Funcionais, Polimorfismo Dinâmico, Encapsulamento de Constantes).
*   **Clean Code** (Princípio de Responsabilidade Única - SRP, eliminação de código duplicado, modularização de métodos de entrada/saída).

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
*   **Java Development Kit (JDK) 26** instalado e configurado nas variáveis de ambiente.
*   Uma IDE de sua preferência (IntelliJ IDEA, VS Code, Eclipse) ou acesso ao terminal do sistema.

### Passo a Passo no IntelliJ IDEA:

1. **Baixe ou Clone o Repositório:**
   ```bash
   git clone https://github.com/rodrigomgrassioto/BootcampSantander2026-01/tree/main/Exercicios/5%20-%20Dominando%20Interfaces%20e%20Lambda%20em%20Java/3-RodrigoArea
   ```
2. **Abra o Projeto:**
    * Abra o IntelliJ IDEA.
    * Vá em **File > Open** e selecione a pasta do projeto clonado.
3. **Configure o SDK (Java 26):**
    * Vá em **File > Project Structure > Project**.
    * Certifique-se de que o **Project SDK** está configurado para o **Amazon Corretto 26**.
4. **Execute a Aplicação:**
    * Localize o arquivo principal que contém o método `void main()`.
    * Clique no botão verde de **Play** (Run) ao lado do método ou no topo superior direito da IDE.
    * O menu interativo "Rodrigo Área Calc" será iniciado diretamente no terminal

---

## 💻 Exemplos de Código e Implementação

Veja abaixo a diferença prática entre a abordagem estruturada imutável (Records) e a abordagem funcional flexível (Lambdas) aplicadas neste motor de cálculo:

### 1. Modelagem com Java Records (Imutabilidade de Dados)
O uso do `record` permitiu definir a entidade geométrica de forma concisa, garantindo que as propriedades sejam `final` por padrão, com getters e construtores gerados automaticamente pelo compilador do Java 26:

```java
package com.devrodrigo.area;

// Dados 100% imutáveis e sem código verboso (boilerplate)
public record Rectangle(double base, double height) implements GeometricShape {

    @Override
    public double getArea() {
        return base * height;
    }
}
```

### 2. Injeção Dinâmica com Expressões Lambda (`->`)
Para fórmulas matemáticas diretas ou de última hora, o sistema elimina a necessidade de criar um novo arquivo `.java`. Abaixo, implementamos a fórmula do Triângulo "no ar" utilizando o paradigma funcional, de forma análoga às *Arrow Functions* do JavaScript:

```java
private void triangle() {
    double base = lerNumeroSeguro("Base do triângulo: ", "dou").doubleValue();
    double height = lerNumeroSeguro("Altura do triângulo: ", "dou").doubleValue();

    // Uma Interface Funcional sendo instanciada dinamicamente via Lambda
    geometricShape = () -> (base * height) / 2;
}
```

### 3. Consumo Unificado via Polimorfismo
Graças ao contrato estabelecido pela interface `GeometricShape`, o fluxo principal do programa invoca a execução correta da fórmula de forma transparente, centralizando a exibição do resultado:

```java
// Independentemente se foi criado via Record ou Lambda, o contrato é o mesmo
System.out.printf("A área é: %,.2f %n%n", geometricShape.getArea());
```

---

## 🤝 Conecte-se Comigo
Estou em constante evolução no ecossistema backend focado em Java e Engenharia de Software. Fique à vontade para explorar os outros sub-módulos do meu repositório ou entrar em contato!

👉 [Acesse meu perfil no LinkedIn para Networking](https://www.linkedin.com/in/devrod)
