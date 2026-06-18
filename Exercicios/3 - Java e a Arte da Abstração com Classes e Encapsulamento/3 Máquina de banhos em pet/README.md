# 📂 Exercício 3-3: Java e a Arte da Abstração com Classes e Encapsulamento

## 🐕 Projeto Prático: Máquina Automatizada de Banhos (PetShop)

Este projeto consiste em um sistema interativo via console desenvolvido como desafio prático do **Santander Bootcamp 2026.1 (DIO)**. O objetivo principal é simular o controle operacional de uma máquina de lavar animais de estimação, aplicando conceitos rígidos de **Programação Orientada a Objetos (POO)** e **Encapsulamento de Regras de Negócio**.

---

## 📋 Regras de Negócio Implementadas

O sistema foi blindado para respeitar rigorosamente as seguintes restrições de funcionamento:

*   **Capacidade Única:** A máquina permite rigorosamente apenas **1 pet por vez**.
*   **Gestão de Insumos (Banho):** Cada banho realizado com sucesso consome **10 litros de água** e **2 litros de shampoo**.
*   **Limites de Armazenamento:** A máquina possui tanques com capacidades máximas fixas de **30 litros de água** e **10 litros de shampoo**.
*   **Lógica de Abastecimento:** Cada comando de reabastecimento injeta rigidamente **2 litros por vez**, bloqueando a ação caso o limite do tanque seja violado.
*   **Contaminação e Higiene:** Se um pet for retirado da máquina antes do término do banho (sem estar limpo), a máquina entra em estado de **contaminação (suja)**. Nesses casos, nenhuma nova entrada de animal é permitida até que o ciclo de limpeza seja acionado.
*   **Custo de Higienização:** A rotina de limpeza do equipamento consome **3 litros de água** e **1 litro de shampoo**.

---

## 🏗️ Arquitetura do Software

O projeto é composto por três classes principais que dividem as responsabilidades do domínio de forma isolada:

1.  **`Main.java`**: Gerencia a interface de texto (I/O) via console, renderiza o menu interativo de opções e delega os comandos para o motor de execução.
2.  **`PetMachine.java`**: Funciona como o núcleo (core) do sistema. Centraliza os atributos privados (estados de limpeza, tanques e referência do pet) e expõe métodos públicos seguros que processam as regras do negócio.
3.  **`Pet.java`**: Modelo de dados (POJO) que representa a entidade do animal de estimação, carregando as propriedades básicas de identificação (`name`) e o estado físico de higiene (`clean`).

---

## 🛠️ Conceitos Avançados de POO Demonstrados

*   **Encapsulamento Estrito:** Todos os campos sensíveis (`water`, `shampoo`, `clean`) foram definidos como `private`. O acesso e modificação ocorrem exclusivamente através de métodos de validação com cláusulas guarda (*Guard Clauses*).
*   **Gerenciamento de Referências Ocultas (`null`):** O sistema utiliza verificações contínuas para impedir erros do tipo `NullPointerException`, garantindo mensagens amigáveis no terminal caso o usuário tente dar banho ou remover um animal inexistente.
*   **Controle de Fluxo Interativo:** Implementação de menu robusto baseado em estruturas `do-while` sincronizado com entrada segura via `Scanner(System.in)` configurado com delimitador de quebra de linha (`\n`).
