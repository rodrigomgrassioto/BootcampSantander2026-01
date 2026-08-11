# 🛡️ 542-Compliance - Sistema de Análise de Risco Corporativo

![OpenFeign](https://img.shields.io/badge/OpenFeign-4.3.0-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Clean Architecture](https://img.shields.io/badge/Clean%20Architecture-Design-6DB33F?style=for-the-badge)
![Java](https://img.shields.io/badge/Java-26-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.0-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Framework](https://img.shields.io/badge/Spring%20Framework-7.0.8-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

Esta é uma aplicação robusta focada no Gerenciamento de Conformidade (Compliance) e Análise de Risco Financeiro. O sistema automatiza a triagem de empresas parceiras e clientes consumindo dados de serviços externos para mitigar riscos de fraudes.

O projeto foi desenvolvido seguindo os princípios rígidos da **Arquitetura Limpa (Clean Architecture)** e **Domain-Driven Design (DDD)**, garantindo desacoplamento de frameworks, facilidade de testes unitários e alta manutenibilidade.

---

## 🎯 Funcionalidades Principais

* **Triagem Automatizada de Empresas:** Execução de políticas de conformidade configuráveis baseadas no perfil do negócio.
* **Avaliação de Risco Multicamada:** Motor de regras de negócio (`AnalyzeCompanyRiskUseCase`) que classifica o nível de risco (`RiskLevel`) corporativo.
* **Consumo de APIs Externas com OpenFeign:** Integração declarativa e resiliente com serviços externos de segurança:

  * **AntiMoneyLaunderingClient (AML):** Verificação de Prevenção à Lavagem de Dinheiro.
    * **SanctionClient:** Varredura em listas de sanções globais e restrições comerciais.
* **Persistência desacoplada:** Suporte a repositórios em memória para testes dinâmicos e Spring Data JPA para ambiente produtivo.

---

## 🏗️ Estrutura do Projeto (Clean Architecture)

A árvore de diretórios reflete a separação clara de responsabilidades e a inversão de dependências:

```text
542-compliance/src/main/java/com/devrodrigo/_542_compliance/
│
├── domain/                          # Núcleo de Negócio (Lógica Pura, Sem Frameworks)
│   ├── Company.java                 # Entidade de Domínio
│   ├── CompanyId.java               # Value Object
│   ├── CompanyRepository.java       # Interface (Porta de Saída)
│   ├── CompliancePolicy.java        # Regras de Negócio e Políticas
│   ├── ComplianceScreening.java     # Modelagem de Triagem
│   ├── RiskAssessment.java          # Processamento da Avaliação
│   ├── RiskAssessmentStatus.java    # Enum de Status
│   └── RiskLevel.java               # Enum de Níveis de Risco (Baixo, Médio, Alto)
│
├── application/                     # Casos de Uso (Orquestração)
│   └── AnalyzeCompanyRiskUseCase.java # Coordena o fluxo de execução da análise
│
├── infrastructure/                  # Adaptadores e Detalhes Técnicos
│   ├── persistence/                 # Implementações de Banco de Dados
│   │   ├── entity/CompanyEntity.java
│   │   ├── event/CompanyEventHandler.java
│   │   └── repository/              # Adaptadores JPA e InMemory
│   └── rest/                        # Comunicação Externa (Clientes HTTP)
│       ├── client/                  # Clientes declarativos Spring Cloud OpenFeign
│       └── dto/                     # Objetos de Transferência de Dados (AML e Sanções)
│
└── ComplianceApplication.java       # Classe de Inicialização do Spring Boot
```

---

## 🛠️ Tecnologias e Especificações

* **Java 26** (OpenJDK)
* **Spring Boot 4.1.0** & **Spring Framework 7.0.8**
* **Spring Cloud OpenFeign** (Clientes REST declarativos)
* **Spring Data Commons 4.1.0** (Camada de abstração de dados)
* **Tomcat Embed 11.0.22** (Servidor de aplicação nativo)
* **Jackson BOM 3.1.4** (Serialização e desserialização de JSON de alta performance)
* **Gradle** (Gerenciador de dependências e automação de builds)

---

## 🚀 Como Executar o Projeto

Este projeto está localizado dentro de um repositório consolidado de estudos (`EmAula/`). Para interagir com ele via terminal de forma isolada, siga as etapas abaixo:

### 1. Navegar até a raiz do projeto
Abra o seu terminal e mude para a pasta específica do microsserviço:
```bash
cd EmAula/542-compliance
```

### 2. Compilar o projeto
Execute o build do Gradle utilizando o wrapper incluso para baixar as dependências e compilar o código fonte:
```bash
./gradlew build
```

### 3. Executar a Aplicação Spring Boot
Inicie o servidor embutido localmente:
```bash
./gradlew bootRun
```
A aplicação inicializará por padrão na porta `8080`.

### 4. Testar os Endpoints
Na pasta `src/test/http/` você encontrará os arquivos `companies.http` e `index.http`. Caso utilize o IntelliJ IDEA ou a extensão HTTP Client no VS Code, você pode abrir esses arquivos e disparar as requisições de teste diretamente contra a API local.

---

## 🧠 Diferenciais Técnicos Destacados
* **Inversão de Dependência:** O domínio não conhece o Spring Data ou o OpenFeign. Ele define interfaces, e a infraestrutura implementa essas portas.
* **Resiliência:** Prontidão para lidar com quedas de APIs parceiras usando padrões de engenharia de software voltados para a tolerância a falhas.

---

## 👨‍💻 Desenvolvedor

* **Nome:** Rodrigo Medeiros Grassioto
* **LinkedIn:** [Acesse meu perfil profissional]([https://linkedin.com](https://www.linkedin.com/in/devrod/))

---

## 📄 Licença

Este projeto foi desenvolvido para fins didáticos e de estudo de conformidade arquitetural. Sinta-se à vontade para clonar, estudar e sugerir melhorias!