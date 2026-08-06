# 522-Marketplace-Eventos 🚀

![Java](https://img.shields.io/badge/Java-26-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.1.0-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-9.6.1-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-7.1-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-9.4-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-18-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-8.0-47A248?style=for-the-badge&logo=mongodb&logoColor=white)
![Redis](https://img.shields.io/badge/Redis-8.2-DC382D?style=for-the-badge&logo=redis&logoColor=white)


Este é um ecossistema corporativo de microsserviços de alto desempenho desenvolvido para gerenciar o catálogo, registro de clientes e bilheteria (ticketing) de um Marketplace de Eventos de grande escala.

O projeto foca em **Persistência Poliglota**, **Isolamento de Infraestrutura** e **Programação Concorrente de Baixa Latência** utilizando os recursos mais modernos do ecossistema Java.

---

## 🎯 Destaques Arquiteturais

*   **Persistência Poliglota & Multi-DataSources**: Configuração avançada de múltiplos `EntityManagerFactory` isolados na camada de infraestrutura. A aplicação gerencia transações concorrentes entre **MySQL** (Módulo de Registros), **PostgreSQL** (Módulo de Bilheteria) e **MongoDB** (Módulo de Catálogo/Metadados), blindando o domínio através de contextos delimitados (*Bounded Contexts*).
*   **Concorrência Massiva com Virtual Threads (Project Loom)**: Configuração nativa de servidores embarcados utilizando Threads Virtuais (`mcat-handler`). Isso garante processamento assíncrono e concorrente sem bloqueio de I/O em milissegundos para tarefas pesadas de enriquecimento de dados (*Data Enrichment*).
*   **Topologia de Cache Multi-Instância**: Isolamento estrito de cache utilizando instâncias do **Redis** em portas lógicas separadas (`6379` e `6380`) e uso de múltiplos bancos indexados para evitar colisões e garantir integridade entre contextos.
*   **Design de Código Limpo**: Arquitetura orientada a **Domain-Driven Design (DDD)**, com isolamento absoluto do modelo através do padrão *Repository*, desacoplamento via DTOs nativos (*Java Records*) e tratamento automatizado de persistência em tempo de execução via drivers configurados em `runtimeOnly`.

---

## 🛠️ Tecnologias e Ecossistema

*   **Java 21 / 25 / 26** (Utilização nativa de Virtual Threads)
*   **Spring Boot 4.x / Spring Data** (JPA, MongoDB, Redis, Data REST)
*   **Hibernate 6.x / 7.x** (Mapeamento e otimização de queries via Starter JPA)
*   **Jackson** (Serialização customizada de Value Objects globais)
*   **HAL Explorer** (Interface visual para navegação e testes de endpoints Hypermedia)

---

## 🏗️ Estrutura de Conexões e Infraestrutura

A aplicação está integrada com a seguinte malha de servidores locais:

| Módulo/Serviço        | Banco de Dados / Cache | Porta Padrão | Escopo dos Dados                                    |
|:----------------------| :--- |:-------------|:----------------------------------------------------|
| **Catalog**           | MongoDB | `27017`      | Metadados dinâmicos e árvores de assentos           |
| **Registration**      | MySQL | `3306`       | Dados críticos e registros de clientes (`@Primary`) |
| **Catalogy(eventos)** | MySQL | `3307`       | Dados críticos e registros dos eventos |
| **Ticketing**         | PostgreSQL | `5432`       | Bilheteria, controle de vendas e auditoria          |
| **Cache Principal**   | Redis (Cygwin) | `6379`       | Leituras rápidas do portfólio de vitrines           |
| **Cache Secundário**  | Redis (Cygwin) | `6380`       | Sessões de compra e bloqueios temporários           |

---

## ⚙️ Como Executar o Projeto Localmente

### Pré-requisitos
*   Java SDK instalado (versão compatível com Virtual Threads).
*   Gerenciador local de infraestrutura (como **Laragon** ou Docker).

### Passos para Inicialização

1.  **Configurar os Bancos Relacionais**:
    *   No MySQL, garanta que os esquemas locais estejam ativos nas portas `3306` e `3307`.
    *   No PostgreSQL, crie manualmente o banco de dados principal antes de rodar o projeto:
        ```sql
        CREATE DATABASE bcsantander_522_ticketing;
        ```
2.  **Iniciar as Instâncias Isoladas do Redis**:
    *   A padrão do Redis na porta `6379` e ainda uma segudna na pora `6381`.
    
3.  **Configurar o Ambiente**:
    *   Verifique se o seu arquivo `application.properties` está consumindo as credenciais modernas ajustadas (sem o prefixo legado `.data` para o Mongo).
4.  **Executar o Spring Boot**:
    ```bash
    ./gradlew bootRun
    ```

---

## 📩 Contato e Conexões

Desenvolvido por **Rodrigo Medeiros Grassioto**.  
Se você gostou deste projeto ou deseja trocar experiências sobre arquiteturas de alta performance com Java, vamos nos conectar!

Desenvolvido com ☕ e dedicação por [Rodrigo Medeiros Grassioto](https://www.linkedin.com/in/devrod).
