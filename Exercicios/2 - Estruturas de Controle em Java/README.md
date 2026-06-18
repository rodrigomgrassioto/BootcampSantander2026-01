# 📂 Módulo 2: Estruturas de Controle em Java

Este diretório centraliza a resolução das 4 atividades práticas focadas em fluxos de decisão, controle de loops e tomadas de decisão condicionais avançadas, propostas pelo **Santander Bootcamp 2026.1 (DIO)**.

---

## ⚠️ Requisito Técnico Obrigatório (Java 26)

Este projeto utiliza **recursos experimentais de vanguarda** da linguagem Java. Para compilar e executar o código sem erros, certifique-se de configurar seu ambiente de desenvolvimento exatamente com as seguintes especificações:

*   **SDK/JDK Mínimo:** Java 26 ou superior.
*   **Configuração no IntelliJ IDEA:**
    *   Acesse `File` > `Project Structure` > `Project`.
    *   Defina o campo **Language Level** obrigatoriamente como: **`26 (Preview) - Primitive types in patterns (4th preview)`**.
*   *Nota: Caso essa configuração não seja aplicada, o compilador emitirá um erro de sintaxe no primeiro bloco `switch` do Exercício 2, por ele utilizar correspondência de padrões com tipos primitivos e cláusulas guardas (`when`).*

---

## 📋 Atividades Desenvolvidas (Enunciados)

1. **Gerador de Tabuada:** Escreva um código onde o usuário entra com um número e seja gerada a tabuada de 1 até 10 desse número.
2. **Cálculo de IMC Avançado:** Escreva um código onde o usuário entra com sua altura e peso, calcula o IMC ($peso / altura^2$) e classifica o resultado conforme a tabela oficial (Abaixo do peso até Obesidade Mórbida).
3. **Filtro de Intervalo Decrescente:** Escreva um código que receba dois números (garantindo que o segundo seja maior) e filtre o intervalo em ordem decrescente, exibindo apenas os pares ou ímpares de acordo com a escolha do usuário.
4. **Validador de Múltiplos com Loops:** Escreva um código com um divisor inicial que aceita consecutivamente múltiplos dividendos. O fluxo ignora números menores que o divisor e encerra a execução no primeiro número que gerar resto de divisão diferente de zero.

---

## 🛠️ Recursos de Destaque Implementados

*   **Pattern Matching para `switch` (Java 26 Preview):** Implementação pioneira do uso de tipos primitivos diretamente nos braços do `switch`, utilizando expressões guardas (`case double v when v <= 18.5 ->`) para avaliar faixas numéricas de IMC sem a necessidade de múltiplos blocos `if/else`.
*   **Switch Expressions Modernas:** Uso da sintaxe de seta (`->`) que elimina a necessidade mecânica do comando `break` e previne vazamentos de escopo (*fall-through*).
*   **Loops com Guardas de Escopo:** Uso estruturado de loops `while(true)` combinados com diretivas `continue` e `break` para controle dinâmico e validação robusta de entradas do usuário.

---

## 💻 Como Executar

1. Abra esta subpasta no IntelliJ IDEA.
2. Certifique-se de ativar o **Language Level 26 (Preview)** conforme as instruções acima.
3. Execute o arquivo `Main.java` e acompanhe os testes interativos no terminal.
