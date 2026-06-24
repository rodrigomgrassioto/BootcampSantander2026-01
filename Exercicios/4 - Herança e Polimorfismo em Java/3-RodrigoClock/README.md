# 🕰️ World Clock Architecture - Sistema de Relógios Internacionais
Desenvolvido em: Java 26 | Contexto: Bootcamp Java Santander 2026.1

O **World Clock Architecture** é um sub-módulo de software que simula o funcionamento, a sincronização e a regionalização de relógios internacionais. O projeto foi construído para solucionar o desafio de herança e polimorfismo do Bootcamp Santander, aplicando conceitos rígidos de programação defensiva e padrões modernos de design de código.

O grande diferencial deste projeto é lidar com as regras complexas de conversão entre o sistema de 24 horas (padrão brasileiro) e o sistema de 12 horas (padrão americano AM/PM), garantindo consistência mutável na memória e blindagem do domínio contra estados inválidos.

---

## 📋 Requisitos do Desafio
O projeto foi desenvolvido seguindo estritamente os seguintes critérios propostos pelo curso:

*   **Superclasse Abstrata:** Criação de uma classe pai que gerencia o núcleo do tempo (Hora, Minuto, Segundo), aplicando encapsulamento rígido com getters e setters.
*   **Formatação Estrita:** Implementação de um método centralizado para retornar o tempo formatado estritamente no padrão `HH:MM:SS`.
*   **Especialização Regional:** Criação de duas implementações concretas: `BRClock` (formato 24h) e `USClock` (formato 12h com restrição e tratamento para o intervalo de 13 às 24 horas).
*   **Sincronização Polimórfica:** Implementação de um método abstrato de conversão na classe pai. As classes filhas devem receber qualquer instância de relógio (independente da região), extrair os dados de tempo e realizar a sincronização adaptativa baseada em suas próprias regras regionais.

---

## 🎯 Desafios Técnicos Solucionados (Destaques para Recrutadores)

Durante o desenvolvimento do ecossistema de relógios, foquei em mitigar acoplamentos e aplicar recursos de última geração da plataforma Java:

*   **Arquitetura Selada (Sealed Classes - Java 17+):** Uso de `sealed abstract class Clock permits BRClock, USClock`. Essa abordagem blinda o domínio de software, permitindo o controle estrito de quem pode estender as regras de tempo e evitando extensões maliciosas ou não autorizadas no ecossistema.
*   **Pattern Matching para Switch (Java 21+):** Eliminação de códigos legados baseados em múltiplos blocos `if (obj instanceof Class)` e conversões manuais (*casts*). O método `convert()` faz a correspondência de padrões fortemente tipada diretamente no `switch`, limpando a legibilidade e garantindo segurança em tempo de execução.
*   **Abstração com Record-Level Thinking (Java 26):** Utilização da vanguarda da linguagem para validar herança restrita e manter a compatibilidade com os novos fluxos de compilação do ecossistema Java moderno.
*   **Encapsulamento e Cláusulas de Barreira (Guard Clauses):** Proteção absoluta do estado interno das propriedades (`protected` com acesso controlado por métodos). Os modificadores barram automaticamente transições numéricas inválidas (como minutos ou segundos maiores ou iguais a 60, redefinindo-os para 0).
*   **Polimorfismo Bidirecional Puro:** O relógio americano não apenas bloqueia valores inválidos, ele **adapta o dado de entrada**. Ao receber uma hora militar (ex: 23h), a classe calcula automaticamente o deslocamento para o formato de 12h e chaveia o estado do indicador para `PM`, respeitando o Princípio de Substituição de Liskov (SOLID).

---

## ⚙️ Funcionalidades Principais

*   **Controle de Tempo Genérico:** Gerenciamento centralizado de horas, minutos e segundos com formatação automática de dois dígitos (`05:09:08` em vez de `5:9:8`).
*   **Tratamento de Período Americano:** Conversão automática de horas civis e militares. O sistema mapeia `00:00` para `12:00 AM`, horas entre `13` e `23` para o formato reduzido com a flag `PM`, mantendo a precisão internacional.
*   **Sincronização Adaptativa Global:** Capacidade de instanciar um relógio brasileiro, configurá-lo no formato de 24h e, com uma única chamada (`convert()`), gerar uma nova instância americana perfeitamente sincronizada e formatada com seu respectivo indicador de período.

---

## 📁 Estrutura de Classes

*   **`Clock.java` (Camada de Domínio / Abstrata):** Centraliza o estado central do tempo, valida os limites matemáticos de minutos/segundos e dita o contrato polimórfico de conversão regional.
*   **`BRClock.java` (Especialização):** Implementa a lógica brasileira, revertendo relógios `PM` americanos para o formato somado de 24h e tratando o caso crítico de `12 AM` para `00h`.
*   **`USClock.java` (Especialização):** Estende o comportamento para gerenciar o estado da propriedade isolada `periodIndicator` (`AM/PM`), alterando a saída do método `getTime()`.
*   **`Main.java` (Orquestração):** Demonstra o fluxo de execução, instanciando os objetos e validando a conversão de dados em tempo real no console.

---

## 🚀 Como Executar o Projeto

Este projeto é um sub-módulo que integra o meu portfólio completo de engenharia Java.

As instruções detalhadas de configuração do ambiente, instalação do JDK 26 e os passos exatos para rodar as aplicações constam no **README principal localizado na raiz do repositório**.

👉 [Acesse o README na Raiz do Repositório para Instruções de Execução](https://github.com/rodrigomgrassioto/BootcampSantander2026-01)

---

## 🛠️ Tecnologias e Conceitos Aplicados

*   **Java SE 26** (Sealed Classes, Permits Modifiers, Pattern Matching para estruturas Switch).
*   **Programação Orientada a Objetos Avançada** (Sobrescrita de métodos com `@Override`, Polimorfismo de parâmetros, herança selada e encapsulamento em camadas).
*   **Clean Code** (Nomenclatura expressiva, eliminação de complexidade ciclomática via *Guard Clauses*, reutilização estruturada de comportamento via `super`).
