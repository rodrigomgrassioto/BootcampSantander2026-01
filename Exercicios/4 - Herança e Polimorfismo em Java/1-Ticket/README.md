# 🎬 Cinema Ticket System - Hierarquia e Fábricas de Ingressos
Desenvolvido em: Java 26 | Contexto: Bootcamp Java Santander 2026.1

O **Cinema Ticket System** é um sub-módulo de software focado na gestão, precificação dinâmica e emissão de ingressos corporativos para salas de cinema. O projeto foi construído para solucionar o desafio de herança e polimorfismo do Bootcamp Santander, aplicando padrões criacionais modernos e encapsulamento em conformidade com as regras de negócio de bilheterias reais.

O grande diferencial deste projeto é a flexibilidade criacional de objetos, permitindo que tipos especializados de ingressos nasçam de forma independente ou sejam derivados dinamicamente a partir de um bilhete comum padrão, blindando o estado na memória.

---

## 📋 Requisitos do Desafio
O projeto foi desenvolvido seguindo estritamente os seguintes critérios propostos pelo curso:

*   **Entidade Concreta de Domínio:** Modelagem de uma classe pai (`Ticket`) não abstrata para representar o ingresso comum comercializável (inteira), encapsulando valor, nome do filme e tipo de áudio (dublado/legendado).
*   **Contrato de Precificação Real:** Implementação de um método unificado (`getRealPrice()`) encarregado de calcular o valor financeiro do bilhete sob demanda, sem alterar de forma destrutiva os atributos na memória.
*   **Regra de Meia-Entrada:** Especialização (`HalfTicket`) com redução matemática de 50% sobre o valor base informado no momento da criação.
*   **Regra de Ingresso Família:** Especialização (`FamilyTicket`) que multiplica o valor base pelo número total de integrantes do grupo, aplicando automaticamente uma redução de 5% de desconto promocional exclusivamente quando o volume de membros for maior do que 3.

---

## 🎯 Desafios Técnicos Solucionados (Destaques para Recrutadores)

Durante o desenvolvimento deste ecossistema, foquei em aplicar boas práticas de design pattern e Clean Code:

*   **Padrão Static Factory Method (Métodos de Fábrica Estáticos):** Implementação dos métodos `HalfTicket.fromTicket(ticket)` e `FamilyTicket.fromTicket(ticket, membros)`. Essa abordagem elimina o antipattern de instanciar objetos vazios (`null pointers`), permitindo polimorfismo limpo e mitigando totalmente a duplicação de strings (`DRY - Don't Repeat Yourself`) na camada de interface.
*   **Imutabilidade de Estado Financeiro:** O valor bruto do ingresso inserido no construtor nunca sofre mutação direta. A precificação promocional ou tributária ocorre de maneira puramente dinâmica através do método recalculado `getRealPrice()`, protegendo as regras fiscais do sistema contra falhas colaterais de concorrência.
*   **UX Avançada e Cálculo Proporcional:** A formatação do log de exibição no console (`infos()`) calcula em tempo real o preço unitário do ingresso família pós-desconto (`getRealPrice() / numberMembers`), fornecendo relatórios comerciais claros.
*   **Polimorfismo Baseado em Extensibilidade:** Arquitetura limpa que respeita o Princípio Aberto/Fechado (SOLID). Caso surjam novas categorias (como *Ingresso VIP* ou *Ingresso Idoso*), o sistema permite o acoplamento de novas subclasses sem impactar a assinatura estável da classe pai `Ticket`.

---

## ⚙️ Funcionalidades Principais

*   **Emissão Geral de Bilhetes:** Suporte para faturamento padrão de inteiras com controle explícito de metadados do filme.
*   **Desconto Progressivo em Grupo:** Modulador financeiro que analisa o tamanho do grupo familiar e decide se a transação deve herdar o preço cheio ou se qualifica para a cláusula de desconto de 5%.
*   **Fábricas de Derivação Dinâmica:** Capacidade de ler uma sessão configurada em um ingresso padrão e clonar perfeitamente os dados de exibição para novos portadores de meia-entrada ou ingressos coletivos instantaneamente.

---

## 📁 Estrutura de Classes

*   **`Ticket.java` (Camada de Domínio / Base Concreta):** Estabelece o estado original do tempo, preço cheio e fornece os pilares básicos de acesso (`getters/setters`).
*   **`HalfTicket.java` (Especialização):** Encapsula a lógica de desconto estudantil/conveniado através do override do método de cálculo.
*   **`FamilyTicket.java` (Especialização):** Gerencia a propriedade exclusiva `numberMembers`, operando as regras de multiplicação em lote e aplicação de taxas promocionais de desconto.
*   **`Main.java` (Orquestração / Teste):** Valida os dois fluxos criacionais suportados pelo sistema (instanciação construtora pura e instanciação por métodos de fábrica estáticos).

---

## 🚀 Como Executar o Projeto

Este projeto é um sub-módulo que integra o meu portfólio completo de engenharia Java.

As instruções detalhadas de configuração do ambiente, instalação do JDK 26 e os passos exatos para rodar as aplicações constam no **README principal localizado na raiz do repositório**.

👉 [Acesse o README na Raiz do Repositório para Instruções de Execução](https://github.com/rodrigomgrassioto/BootcampSantander2026-01)

---

## 🛠️ Tecnologias e Conceitos Aplicados

*   **Java SE 26** (Static Factory Methods, Métodos Modificadores de Escopo, Construtores com Sobrecarga Automática).
*   **Programação Orientada a Objetos** (Herança Concreta, Sobrescrita com `@Override`, Encapsulamento em Camadas de Visibilidade).
*   **Clean Code** (Princípio DRY, Nomenclatura baseada em domínio de negócio, Cláusulas Condicionais Simples).
