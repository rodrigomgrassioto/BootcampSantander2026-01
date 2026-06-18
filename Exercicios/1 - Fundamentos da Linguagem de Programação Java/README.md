# 📂 Módulo 1: Fundamentos da Linguagem de Programação Java

Este repositório contém as soluções dos exercícios práticos propostos no **Módulo 1** do **Santander Bootcamp 2026.1**. As resoluções exploram os conceitos fundamentais de sintaxe, entrada e saída de dados, operadores aritméticos e manipulação de variáveis na linguagem Java.

Todas as atividades foram centralizadas e estruturadas em um único arquivo de execução (`Main.java`) utilizando marcadores de comentários descritivos.

---

## 📋 Enunciados e Desafios Propostos

### 🔹 Exercício 1: Cálculo de Idade Dinâmico
*   **Enunciado:** Escreva um código que receba o nome e o ano de nascimento de alguém e imprima na tela a seguinte mensagem: `"Olá 'Fulano' você tem 'X' anos"`.
*   **Destaque do código:** Uso da API `java.time.OffsetDateTime` para capturar o ano atual do sistema operacional automaticamente, garantindo que o cálculo de idade não fique defasado com o passar dos anos.

### 🔹 Exercício 2: Área do Quadrado
*   **Enunciado:** Escreva um código que receba o tamanho do lado de um quadrado, calcule sua área e exiba na tela. *(Fórmula: área = lado x lado)*.
*   **Destaque do código:** Uso do tipo de dado `float` via `scanner.nextFloat()` para permitir o cálculo exato com números decimais.

### 🔹 Exercício 3: Área do Retângulo
*   **Enunciado:** Escreva um código que receba a base e a altura de um retângulo, calcule sua área e exiba na tela. *(Fórmula: área = base x altura)*.
*   **Destaque do código:** Captura consecutiva de múltiplas entradas numéricas pelo console para processamento matemático composto.

### 🔹 Exercício 4: Diferença de Idade Absoluta
*   **Enunciado:** Escreva um código que receba o nome e a idade de 2 pessoas e imprima a diferença de idade entre elas.
*   **Destaque do código:** Implementação de lógica para garantir que a diferença de idade seja sempre um valor absoluto (positivo), independentemente de quem teve a maior idade digitada primeiro.

---

## 🛠️ Tecnologias e Recursos Explorados

*   **Palavra-chave `var`**: Utilização da inferência de tipos locais introduzida nas versões modernas do Java, deixando a leitura do código mais limpa.
*   **Classe `Scanner`**: Captura e tratamento de dados digitados via teclado diretamente pelo terminal (`System.in`).
*   **Formatação de Texto**: Uso combinado de concatenação tradicional de strings e interpolação avançada via `System.out.printf()` com especificadores de formato (`%s`).
