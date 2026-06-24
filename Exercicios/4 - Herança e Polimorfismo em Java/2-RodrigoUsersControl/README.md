# 👥 User Access Control System - Gestão de Autenticação e Perfis
Desenvolvido em: Java 26 | Contexto: Bootcamp Java Santander 2026.1

O **User Access Control System** é um sub-módulo de software focado em controle de acessos corporativos (RBAC - Role-Based Access Control) e auditoria de ações de funcionários. O projeto foi estruturado para solucionar o desafio de herança do Bootcamp Santander, aplicando encapsulamento rígido e blindagem de privilégios administrativos diretamente na camada de domínio.

O grande diferencial deste projeto é a imutabilidade de regras críticas de negócio (perfis administrativos) combinada com operações de segurança defensiva para manipulação e alteração de credenciais sensíveis de usuários.

---

## 📋 Requisitos do Desafio
O projeto foi desenvolvido seguindo estritamente os seguintes critérios propostos pelo curso:

*   **Perfil Gerente (`Manager`):** Contém os metadados de identificação corporativa e o atributo de privilégio administrativo definido obrigatoriamente como estrito e **sempre verdadeiro**.
*   **Perfil Vendedor (`Seller`):** Especialização funcional que rastreia a quantidade individual de vendas efetuadas, possuindo o atributo de privilégio administrativo **sempre falso**.
*   **Perfil Atendente (`Attendant`):** Especialização que gerencia de forma segura o valor financeiro contido em caixa, possuindo o atributo de privilégio administrativo **sempre falso**.

---

## 🎯 Desafios Técnicos Solucionados (Destaques para Recrutadores)

Durante o desenvolvimento deste ecossistema, foquei em aplicar padrões de Clean Code e segurança defensiva:

*   **Abstração de Domínio Concluída (`abstract class`):** Criação da superclasse abstrata `User`. Isso impede a instanciação espúria de entidades genéricas no sistema, obrigando o acoplamento de tipos especializados e consistentes de funcionários.
*   **Segurança Criptográfica Simulada:** Métodos de alteração de dados sensíveis (`changePersonalData` e `changePassword`) que exigem validação de senha prévia através de correspondência estrita (`.equals()`), mitigando brechas comuns de alteração não autorizada de dados.
*   **Injeção de Estado em Cascata (`super`):** Uso estratégico do construtor da superclasse para fixar de forma rígida o comportamento do atributo `isAdmin` de acordo com a função exercida, prevenindo erros operacionais de elevação de privilégios.
*   **Encapsulamento e Isolamento de Funções:** Métodos utilitários altamente acoplados ao seu contexto (ex: fechamento de caixa na classe `Attendant` e relatórios financeiros na classe `Manager`), respeitando o Princípio de Responsabilidade Única (SRP - SOLID).
*   **Main Implícita Modernizada (Java 26):** Execução do fluxo principal baseada nos novos padrões da linguagem para declaração limpa de escopo, otimizando o carregamento de rotinas de teste no console.

---

## ⚙️ Funcionalidades Principais

*   **Autenticação Segura:** Sistema integrado de login e logoff com chaveamento de estado de atividade (`logged`).
*   **Gestão Comercial de Vendas:** Incremento e auditoria em tempo real do volume de transações convertidas pelo vendedor.
*   **Fechamento de Caixa Auditado:** O atendente possui um mecanismo de conciliação bancária que bloqueia o encerramento do caixa se o valor informado divergir do saldo acumulado na memória física.
*   **Relatórios Gerenciais:** Geração dinâmica de balanços de entrada, saída e faturamento bruto restritos à classe de gerência.

---

## 🚀 Como Executar o Projeto

Este projeto é um sub-módulo que integra o meu portfólio completo de engenharia Java.

As instruções detalhadas de configuração do ambiente, instalação do JDK 26 e os passos exatos para rodar as aplicações constam no **README principal localizado na raiz do repositório**.

👉 [Acesse o README na Raiz do Repositório para Instruções de Execução](https://github.com/rodrigomgrassioto/BootcampSantander2026-01)

---

## 🛠️ Tecnologias e Conceitos Aplicados

*   **Java SE 26** (Implicitly Declared Classes, Modificadores Abstratos, Escopos de Visibilidade `private` e `protected`).
*   **Programação Orientada a Objetos Avançada** (Herança Abstrata, Polimorfismo de Construtores, Encapsulamento Rígido).
*   **Clean Code** (Cláusulas de Barreira para validação de senhas e saldos, nomenclatura baseada no domínio do problema, reuso de código).
