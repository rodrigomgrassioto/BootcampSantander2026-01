# 🧮 Rodrigo Tax Calc - Motor Dinâmico de Tributação de Produtos
Desenvolvido em: Java 26 | Contexto: Bootcamp Java Santander 2026.1

O **Rodrigo Tax Calc** é um motor de cálculo fiscal corporativo desenvolvido via console para automatizar a simulação e aplicação de alíquotas de impostos sobre produtos comerciais. O projeto foi projetado para demonstrar o controle de fluxo financeiro através da união de dois mundos no Java moderno: a estabilidade e imutabilidade dos **Java Records** e o alto desempenho da **Programação Funcional com Expressões Lambda**.

O grande diferencial deste submódulo é o isolamento completo da lógica tributária. O fluxo principal interage exclusivamente com abstrações, garantindo conformidade fiscal e facilitando a auditoria de regras de negócio sem acoplamento rígido.

Este projeto é um sub-módulo que integra o meu portfólio completo de engenharia Java desenvolvido durante o Bootcamp.

👉 [Acesse o README na Raiz do Repositório para visualizar todos os projetos do Bootcamp](hhttps://github.com/rodrigomgrassioto/BootcampSantander2026-01)


---

## 📋 Requisitos e Alíquotas do Desafio
O sistema simula o cálculo de impostos de categorias de varejo regulamentadas, aplicando estritamente as regras de taxação com base no estado do objeto:

*   **Alimentação (`Alimentation`):** Isenção parcial com aplicação de alíquota estrita de **1%**.
*   **Saúde e Bem-Estar (`Health`):** Categoria essencial taxada dinamicamente em **1.5%** através de closures e injeção funcional em tempo de execução.
*   **Vestuário (`Clothing`):** Segmento de bens de consumo com aplicação de taxa fixa de **2.5%**.
*   **Cultura (`Culture`):** Alíquota de fomento e regulação fixada em **4%**.

---

## 🎯 Desafios Técnicos Solucionados (Destaques para Recrutadores e ATS)

Durante o desenvolvimento deste mecanismo de tributação, apliquei padrões avançados de design de código limpo e engenharia defensiva:

*   **Polimorfismo Baseado em Interfaces (`TaxCalc`):** Centralização do algoritmo de cálculo. O fluxo de controle principal (`main`) manipula apenas referências abstratas, o que limpa o código e unifica a saída de dados formatados com precisão decimal (`%,.2f`).
*   **Pattern Matching com `instanceof` Moderno (Java 14+):** No módulo de comparação, utilizei a introspecção de tipos de forma segura e elegante. A substituição de validações frágeis por strings (`toString().contains()`) pelo operador nativo `instanceof` garante que o sistema identifique as entidades de forma robusta e à prova de refatorações.
*   **Injeção via Expressões Lambda (`->`):** Demonstração prática do paradigma funcional no cálculo da categoria de Saúde. A interface funcional foi instanciada "no ar" direto no fluxo do menu, eliminando o *boilerplate code* (código repetitivo) e mimetizando o comportamento das *Arrow Functions* do ecossistema JavaScript.
*   **Uso Estratégico de Records Estáticos:** O valor base é injetado diretamente no momento da instanciação dos Records, gerando objetos altamente coesos e imutáveis, o que previne efeitos colaterais em ambientes com concorrência de dados.
*   **Interface Baseada em Estados:** O menu interativo utiliza cláusulas condicionais inteligentes para esconder ou liberar opções apenas se um valor base maior que zero já tiver sido inserido, melhorando a experiência do usuário final e impedindo o cálculo de valores inválidos.

---

## 💻 Exemplos de Código e Implementação

### 1. Introspecção de Tipos Segura (`instanceof` Moderno)
Demonstração de como o loop varre a lista polimórfica de categorias e extrai os relatórios fiscais sem depender de strings ou casting manual antigo:

```java
// Código limpo, legível e seguro contra falhas de digitação
for (TaxCalc servico : category) {
    if (servico instanceof Alimentation) {
        msgTodos += "Alimentação: " + servico.calcTax() + "%n";
    }
    if (servico instanceof Health) {
        msgTodos += "Saúde e bem estar: " + servico.calcTax() + "%n";
    }
    // ... replicado para as demais regras de domínio
}
```

### 2. Implementação Funcional com Lambda (`->`)
Instanciação dinâmica de regras de negócio sem a necessidade de criar arquivos físicos adicionais para fórmulas matemáticas simples:

```java
// A interface funcional TaxCalc sendo instanciada sob demanda no switch
case 3 -> taxCalc = () -> value * 0.015;
```

---

## 🚀 Como Executar o Projeto

Este submódulo foi construído de forma limpa e nativa, dependendo exclusivamente dos recursos embutidos na linguagem.

### Pré-requisitos
*   **Amazon Corretto 26** como JDK principal.
*   **IntelliJ IDEA** instalado.

### Passo a Passo no IntelliJ IDEA

1. **Baixe ou atualize o seu repositório local:**
   ```bash
   git clone https://github.com/rodrigomgrassioto/BootcampSantander2026-01/tree/main/Exercicios/5%20-%20Dominando%20Interfaces%20e%20Lambda%20em%20Java/2-RodrigoTaxCal
   ```
2. **Abra o Projeto:**
    * Abra o IntelliJ IDEA.
    * Vá em **File > Open** e aponte para a pasta deste projeto específico.
3. **Validação do JDK 26:**
    * Pressione `Ctrl + Alt + Shift + S` (Project Structure).
    * Garanta que o **Project SDK** e o **Language Level** estejam marcados como **Java 26 (Corretto)**.
4. **Execute e Teste:**
    * Abra o arquivo que contém o método `void main()`.
    * Clique no botão verde de **Play** (Run).
    * Defina um valor base no menu interativo e teste as simulações fiscais em lote.

---

## 🤝 Conecte-se Comigo
Estou focado em projetar arquiteturas backend sólidas, aplicando as melhores atualizações do ecossistema Java. Sinta-se à vontade para analisar meus repositórios ou entrar em contato!

👉 [Acesse meu perfil no LinkedIn para Networking](https://www.linkedin.com/in/devrod)
