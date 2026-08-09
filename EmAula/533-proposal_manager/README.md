# 📑 Proposal Manager (Gerenciador de Propostas)

O **Proposal Manager** é uma API REST corporativa de alta performance desenvolvida para o gerenciamento centralizado, seguro e auditável de propostas comerciais. Este projeto foi concebido e refinado como critério de elite dentro do **Bootcamp Santander**, aplicando padrões avançados de arquitetura de software para garantir escalabilidade, segurança rigorosa e total desacoplamento da lógica de negócio.

---

## 🚀 Tecnologias e Ferramentas
![Java](https://img.shields.io/badge/Java-26-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.0-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring%20Security-7.1.0-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)
![Spring Framework](https://img.shields.io/badge/Spring%20Framework-7.0.8-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-7.4.1.Final-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-9.7.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

---

## 🏛️ Arquitetura e Estrutura do Projeto

O sistema adota os princípios da **Clean Architecture (Arquitetura Limpa)** combinada com a **Arquitetura Hexagonal (Ports and Adapters)**. O domínio da aplicação é isolado de frameworks, garantindo que regras de negócio sejam imutáveis perante trocas de tecnologias externas (como bancos de dados ou bibliotecas de segurança).

### 📁 Estrutura de Pastas e Arquivos

```text
533-proposal_manager/
├── .gitattributes
├── .gitignore
├── build.gradle                          # Gerenciamento de dependências da aplicação
├── settings.gradle                       # Definição do nome do projeto (proposal_manager)
├── gradlew                               # Script de execução Gradle (Linux/macOS)
├── gradlew.bat                           # Script de execução Gradle (Windows)
└── src/
    ├── main/
    │   ├── java/com/devrodrigo/proposal_manager/
    │   │   ├── Application.java          # Classe principal (Bootstrapping do Spring Boot)
    │   │   │
    │   │   ├── auth/                     # Bounded Context de Autenticação e Usuários
    │   │   │   ├── domain/
    │   │   │   │   └── UserRole.java     # Enum contendo os papéis de acesso (ADMIN, USER)
    │   │   │   └── infrastructure/
    │   │   │       ├── http/
    │   │   │       │   └── TestController.java
    │   │   │       ├── persistence/
    │   │   │       │   ├── entity/
    │   │   │       │   │   └── User.java # Entidade de persistência do usuário
    │   │   │       │   └── repository/
    │   │   │       │       └── UserRepository.java
    │   │   │       └── security/
    │   │   │           ├── JpaUserDetailsService.java
    │   │   │           ├── RestUsernamePasswordAuthenticationFilter.java
    │   │   │           └── SecurityConfig.java # Centralização das políticas de segurança
    │   │   │
    │   │   └── proposal/                 # Bounded Context do Gerenciamento de Propostas
    │   │       ├── application/          # Casos de Uso (Camada de Aplicação Pura)
    │   │       │   ├── CreateProposalUseCase.java
    │   │       │   ├── ListProposalUseCase.java
    │   │       │   ├── input/
    │   │       │   │   └── CreateProposalInput.java
    │   │       │   ├── output/
    │   │       │   │   └── ProposalOutput.java
    │   │       │   └── list/             # Implementação do Pattern Strategy para Escopo
    │   │       │       ├── AccessScope.java
    │   │       │       ├── AllStrategy.java
    │   │       │       ├── OwnStrategy.java
    │   │       │       ├── Strategy.java
    │   │       │       └── Factory.java
    │   │       ├── domain/               # Entidades de Domínio e Contratos (Core)
    │   │       │   ├── Owner.java
    │   │       │   ├── OwnerId.java
    │   │       │   ├── Proposal.java     # Entidade rica de negócio
    │   │       │   ├── ProposalId.java
    │   │       │   └── ProposalRepository.java # Interface/Port de persistência
    │   │       └── infrastructure/       # Detalhes de infraestrutura e frameworks
    │   │           ├── http/             # Controladores REST e DTOs
    │   │           │   ├── ProposalController.java
    │   │           │   ├── request/
    │   │           │   │   └── CreateProposalRequest.java
    │   │           │   └── response/
    │   │           │       └── ProposalResponse.java
    │   │           └── persistence/      # Mapeamento relacional e Adapters de Banco
    │   │               ├── entity/
    │   │               │   └── ProposalEntity.java
    │   │               └── repository/
    │   │                   ├── JpaProposalRepository.java
    │   │                   └── ProposalEntityRepository.java
    │   └── resources/
    │       └── application.properties    # Configurações do ambiente (MySQL, JPA, Portas)
    └── test/
        ├── http/                         # Arquivos de testes rápidos de requisição HTTP
        │   ├── login.http                # Scripts para testar autenticação
        │   └── proposal.http             # Scripts para testar rotas de propostas
        └── java/com/devrodrigo/proposal_manager/
            └── ApplicationTests.java     # Teste de carregamento de contexto (Sanity Check)
```

---

## ⚙️ Regras de Negócio & Padrões de Projeto Avançados

### 🧩 Padrão Strategy com Factory para Controle de Acesso
Para evitar condicionais complexas (`if/else`) baseadas em permissões dentro da camada de aplicação, o sistema implementa os padrões **Strategy** e **Factory** no fluxo de listagem de propostas (`src/.../proposal/application/list/`):
* **`AccessScope`**: Define o nível de permissão baseado no token autenticado do usuário.
* **`AllStrategy`**: Executado quando o usuário possui privilégios administrativos (`ADMIN`), retornando a totalidade de propostas da base de dados.
* **`OwnStrategy`**: Executado para usuários padrão (`USER`), injetando uma cláusula de filtro em nível de aplicação para expor exclusivamente os registros cujo `OwnerId` seja equivalente ao ID da sessão atual.
* **`Factory`**: Avalia o contexto de segurança em tempo de execução e injeta dinamicamente a estratégia correta no `ListProposalUseCase`.

---

## 🔒 Camada de Segurança (Spring Security Corporativo)

O fluxo de proteção da API foi construído de forma robusta e desacoplada dos padrões básicos de formulário web:
* **Filtro Customizado (`RestUsernamePasswordAuthenticationFilter`)**: Intercepta payloads JSON de login diretamente no corpo da requisição REST, adaptando o mecanismo padrão do Spring Security para APIs Stateless.
* **Provedor Baseado em Banco (`JpaUserDetailsService`)**: Conecta o motor de autenticação ao `UserRepository`, validando as credenciais diretamente contra a tabela de usuários persistidos no MySQL.
* **Autorização Granular**: Configurado na classe `SecurityConfig` para blindar endpoints sensíveis e aplicar as restrições baseadas nos enums do `UserRole`.

---

## 🛠️ Como Executar a Aplicação

### Pré-requisitos
* Java JDK 26 instalado.
* Instância ativa do banco de dados **MySQL** (local ou em container).

### Configuração do Banco de Dados
A aplicação está configurada para criar o schema automaticamente (`createDatabaseIfNotExist=true`). Por padrão, tentará se conectar em `localhost:3306`.

Se precisar apontar para um banco externo ou alterar as credenciais, você pode injetar a variável de ambiente correspondente ou ajustar as propriedades no `application.properties`:
```properties
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

### Execução via Linha de Comando

1. **Clonar o Repositório:**
   ```bash
   git clone https://github.com
   cd proposal_manager/533-proposal_manager
   ```

2. **Compilar e buildar os artefatos:**
   ```bash
   ./gradlew build
   ```

3. **Subir o servidor Spring Boot:**
   ```bash
   # Opcional: injetar uma URL personalizada via variável de ambiente
   # export DB_URL=jdbc:mysql://seu-host:3306/bcsantander_533aula_proposal_manager
   
   ./gradlew bootRun
   ```
   A aplicação subirá no endereço local `http://localhost:8080`.

---

## 🧪 Validação da API (Ambiente de Testes)

O repositório disponibiliza automações de requisição HTTP dentro da pasta `src/test/http/`. Você pode executar chamadas diretamente por IDEs como IntelliJ IDEA ou VS Code (com a extensão REST Client):

* **Autenticação (`login.http`)**: Envia as credenciais em formato JSON para obtenção da sessão ou token de segurança.
* **Operações de Propostas (`proposal.http`)**: Contém payloads estruturados para validação instantânea dos endpoints de criação (`POST`) e listagem filtrada (`GET`).

---

## 🏆 Contexto de Desenvolvimento: Bootcamp Santander
Este projeto foi desenvolvido sob as diretrizes e critérios de avaliação do **Bootcamp Santander**. Ele reflete a aplicação prática de padrões arquiteturais de nível corporativo, com foco em segurança robusta, desacoplamento e design patterns voltados para cenários de alta escalabilidade no setor financeiro e de tecnologia.

---

## 📩 Contato e Conexões

Desenvolvido por **Rodrigo Medeiros Grassioto**.  
Se você gostou deste projeto ou deseja trocar experiências sobre arquiteturas de alta performance com Java, vamos nos conectar!

Desenvolvido com ☕ e dedicação por [Rodrigo Medeiros Grassioto](https://www.linkedin.com/in/devrod).
