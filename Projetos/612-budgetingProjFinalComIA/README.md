# 💰 Budgeting Project — Inteligência Artificial para Controle de Gastos

> Projeto final desenvolvido durante o Bootcamp Santander 2026, explorando **Java + Spring Boot + Spring AI + IA generativa + processamento de áudio + persistência com MySQL**.

## 🚀 Tecnologias e Ferramentas

![Java](https://img.shields.io/badge/Java-26-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.0-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring AI](https://img.shields.io/badge/Spring%20AI-2.0.0-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-9.7.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-9.0.0-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![JPA](https://img.shields.io/badge/JPA-7.0.0-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-7.4.1.Final-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-5-25A162?style=for-the-badge&logo=junit5&logoColor=white)

---

O projeto implementa uma API de controle de transações financeiras que pode ser utilizada de forma tradicional, por meio de endpoints REST, ou por meio de uma **interface conversacional baseada em IA**.

A proposta central é transformar uma frase ou um áudio como:

> 🎙️ “Gastei 125 reais no mercado.”

em uma operação estruturada de negócio e devolver uma resposta que também pode ser convertida em áudio:

```text
🎙️ Usuário
   ↓
🎧 Áudio
   ↓
Whisper / Speech-to-Text
   ↓
📝 Texto
   ↓
🧠 Spring AI / LLM
   ↓
🛠️ Tool Calling
   ↓
PersistTransactionUseCase
   ↓
Transaction
   ↓
Repository
   ↓
🗄️ MySQL
   ↓
📤 Resultado da operação
   ↓
🧠 Resposta do LLM
   ↓
🔊 Text-to-Speech
   ↓
🎧 Áudio
   ↓
👤 Usuário
```

Além de registrar transações, a IA também pode utilizar uma ferramenta para consultar gastos por categoria e produzir uma resposta em linguagem natural, que pode novamente ser convertida em áudio.

---

## 🎯 Objetivo

Construir uma aplicação de **budgeting (controle financeiro)** que demonstre, na prática, como integrar uma aplicação Java/Spring com recursos modernos de Inteligência Artificial.

O projeto combina:

- API REST;
- domínio de transações financeiras;
- persistência com JPA/MySQL;
- Spring AI;
- modelos de chat;
- **Tool Calling**;
- transcrição de áudio com Whisper;
- Text-to-Speech;
- processamento de linguagem natural;
- testes de integração;
- separação entre domínio, aplicação, infraestrutura e entrada/saída.

---

## ✨ Principais funcionalidades

### 💳 Cadastro de transações

Permite registrar uma transação informando:

- descrição;
- categoria;
- valor.

O valor financeiro é armazenado internamente em **centavos**, evitando a perda de precisão associada ao armazenamento direto de valores monetários em `double`.

Exemplo:

```json
{
  "description": "Compra no mercadinho",
  "category": "GROCERIES",
  "amount": 12534
}
```

Nesse modelo:

```text
12534 centavos = R$ 125,34
```

Na saída da aplicação, o valor é convertido para a representação monetária com duas casas decimais.

---

### 🔎 Consulta por categoria

É possível consultar as transações de uma categoria específica:

```http
GET /transactions/GROCERIES
```

Categorias atualmente disponíveis:

```text
GROCERIES
PHARMA
AUTO
```

---

### 🧠 Chat com Inteligência Artificial

O projeto utiliza o **Spring AI `ChatClient`** para interagir com modelos de linguagem.

Também existe um endpoint separado demonstrando o uso direto do `OpenAiChatModel`.

Exemplos:

```http
GET /api/chat-client?prompt=Boa tarde, tudo bem?
```

```http
GET /api/chat-model?prompt=Explique o que é controle financeiro.
```

---

### 🛠️ Tool Calling

Essa é uma das partes centrais do projeto.

Os casos de uso da aplicação são expostos ao modelo de IA como ferramentas:

```text
persist-transaction
list-transaction-by-category
```

Assim, o modelo não precisa apenas "responder" ao usuário. Ele pode identificar a intenção e **acionar uma operação real da aplicação**.

Exemplo conceitual:

```text
Usuário:
"Gastei 50 reais na farmácia."

          ↓

        LLM

          ↓

Tool Calling:
persist-transaction

          ↓

description = "Compra na farmácia"
amount      = 5000
category    = PHARMA

          ↓

Transaction

          ↓

Repository

          ↓

MySQL
```

Essa abordagem demonstra a integração entre **IA generativa e regras/operações reais de negócio**.

---

## 🎙️ Entrada por voz

O projeto possui dois caminhos de transcrição de áudio.

### Whisper via serviço externo

O endpoint:

```http
POST /api-whisper-puro/transcribe
```

envia o arquivo de áudio para uma instância externa do Whisper configurada no projeto.

### Transcrição via Spring AI

O endpoint:

```http
POST /api-consulta-api-oficial/transcribe
```

utiliza a abstração `TranscriptionModel` do Spring AI.

A configuração atual utiliza uma API compatível com OpenAI, mas o endereço configurado no projeto aponta para uma infraestrutura local/rede privada.

---

## 🔊 Text-to-Speech

Também existe suporte à conversão de texto para áudio:

```http
POST /api/sinthesize
```

Exemplo:

```json
{
  "text": "Sua transação foi registrada com sucesso."
}
```

A resposta é um arquivo `audio/mp3`.

---

## 🤖 Fluxo completo com IA + voz

O diferencial do projeto é combinar IA generativa, operações de negócio e áudio.

### 🎙️ Fluxo de entrada

```text
🎧 Áudio
   ↓
Whisper / Speech-to-Text
   ↓
📝 Texto
   ↓
🧠 ChatClient / LLM
   ↓
🛠️ Tool Calling
   ↓
PersistTransactionUseCase
   ↓
Transaction
   ↓
Repository
   ↓
🗄️ MySQL
```

### 🔊 Fluxo de resposta

```text
🗄️ MySQL
   ↓
Resultado da operação
   ↓
🧠 LLM
   ↓
📝 Resposta em texto
   ↓
🔊 Text-to-Speech
   ↓
🎧 Áudio
   ↓
👤 Usuário
```

O resultado é uma aplicação em que a IA funciona como uma **interface natural para operações reais do sistema**, em vez de atuar apenas como um gerador de texto.

---

# 🏗️ Arquitetura

O código foi organizado separando responsabilidades entre domínio, aplicação, infraestrutura e interfaces de entrada/saída.

```text
src/main/java
└── com.devrodrigo._612budgetingprojfinalcomia
    │
    ├── application
    │   ├── input
    │   ├── output
    │   ├── PersistTransactionUseCase
    │   └── ListTransactionsByCategoryUseCase
    │
    ├── domain
    │   ├── Category
    │   ├── Transaction
    │   ├── TransactionId
    │   └── TransactionRepository
    │
    └── infrastructure
        ├── http
        │   ├── request
        │   └── response
        │
        └── persistence
            ├── entity
            └── repository
```

Além dessa estrutura, os controllers relacionados à IA e áudio ficam na camada principal da aplicação:

```text
ChatClientController
ChatModelController
TranscriptionApiOficialController
TranscriptionWhisperController
TextToSpeechController
```

### Separação de responsabilidades

**Domain**

Contém as regras e modelos centrais da aplicação, como `Transaction`, `Category` e `TransactionRepository`.

**Application**

Contém os casos de uso:

- persistência de transações;
- consulta por categoria.

Esses casos de uso também são expostos como ferramentas para o modelo de IA.

**Infrastructure**

Implementa:

- HTTP/REST;
- DTOs de request/response;
- persistência JPA;
- integração com MySQL.

**IA e áudio**

Utiliza as abstrações do Spring AI para:

- chat;
- transcrição;
- Text-to-Speech;
- Tool Calling.

---

# 🧩 Tecnologias utilizadas

| Tecnologia | Utilização |
|---|---|
| ☕ Java 26 | Linguagem principal |
| 🌱 Spring Boot 4.1.0 | Framework da aplicação |
| 🤖 Spring AI 2.0.0 | Integração com IA |
| 🧠 Modelos compatíveis com OpenAI | Chat e processamento de linguagem |
| 🎙️ Whisper | Transcrição de áudio |
| 🔊 Text-to-Speech | Conversão de texto para áudio |
| 🗄️ MySQL | Banco de dados |
| 🔗 Spring Data JPA | Persistência |
| 🛠️ Gradle | Build e gerenciamento de dependências |
| 🧪 JUnit / Spring Boot Test | Testes |
| 🧰 Lombok | Redução de código repetitivo |

---

# 💰 Tratamento de valores monetários

Um detalhe importante da implementação é o armazenamento do valor em **centavos**.

O domínio utiliza:

```java
long amount;
```

e a aplicação documenta explicitamente que esse valor representa centavos.

Exemplo:

```text
R$ 1,00   → 100
R$ 15,99  → 1599
R$ 125,34 → 12534
```

Na camada de saída, o valor é convertido para a representação monetária:

```text
12534 → 125.34
```

Essa decisão evita trabalhar diretamente com valores monetários em ponto flutuante durante o armazenamento e processamento principal.

---

# ⚙️ Configuração dos serviços de IA

O arquivo principal de configuração da aplicação está em:

```text
src/main/resources/application.properties
```

É nesse arquivo que devem ser revisadas as configurações do banco de dados e dos serviços de IA antes de executar o projeto em outro ambiente.

## 🗄️ Banco de dados

Revise as propriedades:

```properties
spring.datasource.url=...
spring.datasource.username=...
spring.datasource.password=...
```

O banco utilizado pelo projeto é o MySQL.

## 🧠 Chat / LLM

Revise as propriedades do Spring AI relacionadas ao provedor de chat e à chave de API.

O projeto pode ser configurado para utilizar a **API oficial da OpenAI** ou um serviço compatível com a API da OpenAI.

### Utilizando a API oficial da OpenAI

Se você utilizar diretamente a API oficial da OpenAI, as propriedades `base-url` específicas do ambiente local/rede privada não são necessárias.

Nesse cenário:

1. configure sua chave da OpenAI;
2. remova ou comente as propriedades `base-url` customizadas;
3. mantenha a configuração padrão do starter/provedor da OpenAI;
4. confira os modelos configurados para chat, transcrição e síntese de voz.

> ⚠️ **Importante:** não remova propriedades `base-url` indiscriminadamente sem verificar qual componente as utiliza. A remoção é apropriada para os componentes que serão atendidos diretamente pela API oficial da OpenAI; serviços locais, como o Whisper externo utilizado no projeto, possuem configuração própria.

## 🎙️ Whisper

O projeto demonstra dois caminhos para transcrição:

- `TranscriptionModel` do Spring AI;
- um serviço Whisper externo.

O serviço externo atualmente utilizado pelo projeto aponta para um endereço de rede privada, como:

```text
http://192.168.100.10:8080
```

Esse endereço é específico do ambiente original de desenvolvimento. Em outro ambiente, ele deverá ser substituído pelo endereço do seu serviço Whisper ou pelo fluxo de transcrição escolhido.

## 🔊 Text-to-Speech

A integração de Text-to-Speech também depende da configuração do serviço utilizado pelo ambiente.

Revise as propriedades relacionadas ao speech/TTS no:

```text
src/main/resources/application.properties
```

## ⚠️ Configurações locais

O projeto contém `base-url` apontando para serviços da infraestrutura utilizada durante o desenvolvimento.

Essas configurações **não representam endpoints públicos do projeto**.

Antes de executar em outra máquina, revise todas as ocorrências de:

```text
base-url
192.168.100.10
```

e adapte-as à infraestrutura disponível.

> 🔐 Nunca versione chaves reais de API, senhas de banco ou outros segredos no repositório.

---

# ⚙️ Requisitos

Para executar o projeto localmente, é necessário ter:

- **Java 26**
- **Gradle** (ou utilizar o Gradle Wrapper incluído)
- **MySQL**
- acesso a um modelo de chat compatível com a configuração do projeto;
- serviço de transcrição/Whisper para os fluxos de áudio;
- serviço de Text-to-Speech para geração de áudio.

> **Observação:** os recursos de IA não são autossuficientes apenas com o código deste repositório. A configuração atual aponta alguns serviços de IA para endereços de rede privada (`192.168.100.10`). Para executar em outro ambiente, esses endpoints deverão ser adaptados.

---

# 🔐 Configuração

O projeto utiliza variáveis de ambiente para informações sensíveis e configurações do banco.

Exemplo:

```bash
OPENAI_API_KEY=sua-chave
DB_URL=jdbc:mysql://localhost:3306/bcsantander_612proj?createDatabaseIfNotExist=true&serverTimezone=UTC
DB_USER=root
DB_PASS=sua-senha
```

Como referência, a configuração do banco pode utilizar:

```text
localhost:3306
bcsantander_612proj
root
```

O Hibernate está configurado atualmente com:

```properties
spring.jpa.hibernate.ddl-auto=update
```

### ⚠️ Serviços de IA

A configuração atual contém endpoints locais/rede privada para:

- Chat;
- Whisper;
- Text-to-Speech.

Por exemplo:

```text
http://192.168.100.10:1234/v1
http://192.168.100.10:8002/v1
http://192.168.100.10:8880/v1
http://192.168.100.10:8080
```

Esses endereços são específicos do ambiente utilizado durante o desenvolvimento e **não devem ser considerados endpoints públicos do projeto**.

---

# ▶️ Executando

Entre na pasta do projeto:

```bash
cd Projetos/612-budgetingProjFinalComIA
```

No Linux/macOS:

```bash
./gradlew bootRun
```

No Windows:

```powershell
.\gradlew.bat bootRun
```

A aplicação será iniciada, por padrão, em:

```text
http://localhost:8080
```

---

# 🔌 API

## Criar uma transação

```http
POST /transactions
Content-Type: application/json
```

Body:

```json
{
  "description": "Compra no mercadinho",
  "category": "GROCERIES",
  "amount": 12534
}
```

Resposta esperada:

```json
{
  "id": "uuid-da-transacao",
  "category": "GROCERIES",
  "description": "Compra no mercadinho",
  "amount": 125.34
}
```

---

## Consultar transações por categoria

```http
GET /transactions/GROCERIES
```

Também é possível utilizar:

```http
GET /transactions/PHARMA
```

```http
GET /transactions/AUTO
```

---

## ChatClient

```http
GET /api/chat-client?prompt=Boa tarde, tudo bem?
```

---

## ChatModel

```http
GET /api/chat-model?prompt=Explique controle financeiro
```

---

## Transcrição com Whisper

```http
POST /api-whisper-puro/transcribe
Content-Type: multipart/form-data
```

Campo:

```text
file
```

---

## Transcrição via Spring AI

```http
POST /api-consulta-api-oficial/transcribe
Content-Type: multipart/form-data
```

Campo:

```text
file
```

---

## Text-to-Speech

```http
POST /api/sinthesize
Content-Type: application/json
```

Body:

```json
{
  "text": "Sua transação foi registrada."
}
```

Retorno:

```text
audio/mp3
```

---

## Registrar transação usando voz + IA

### Whisper próprio

```http
POST /transactions/ai-api-whisper-puro
Content-Type: multipart/form-data
```

O fluxo é:

```text
Áudio
→ Whisper
→ Texto
→ ChatClient
→ Tool Calling
→ operação de negócio
→ resposta da IA
→ Text-to-Speech
→ MP3
```

### Transcrição via Spring AI

```http
POST /transactions/ai-api-openai
Content-Type: multipart/form-data
```

O fluxo é semelhante, mas utiliza o `TranscriptionModel` configurado no Spring AI para realizar a transcrição.

---

# 🧪 Testes e exemplos

O projeto contém testes de integração relacionados a:

- inicialização da aplicação;
- ChatModel;
- ChatClient;
- Tool Calling;
- Speech Model;
- transcrição com OpenAI/Spring AI;
- transcrição com Whisper;
- processamento de arquivos de áudio.

Também existe um arquivo de requisições HTTP em:

```text
src/test/http/api.http
```

e arquivos de áudio de teste em:

```text
src/test/resources/audio/
```

Esses recursos permitem reproduzir os principais fluxos do projeto durante o desenvolvimento.

Para executar os testes:

```bash
./gradlew test
```

> Alguns testes de integração dependem dos serviços/modelos de IA configurados no ambiente. Portanto, testes que utilizam IA ou áudio podem exigir que essas dependências externas estejam disponíveis.

---

# 🧠 Conceitos demonstrados

Este projeto reúne diversos conceitos estudados ao longo do Bootcamp:

### Java

- Records;
- Enums;
- Optional/Streams;
- UUID;
- tratamento de valores monetários;
- organização em camadas.

### Spring Boot

- REST Controllers;
- Dependency Injection;
- configuração por properties;
- Spring Data JPA;
- integração com MySQL;
- testes de integração.

### Arquitetura

- separação entre Domain, Application e Infrastructure;
- casos de uso;
- DTOs;
- Repository Pattern;
- conversão Domain ↔ Entity;
- isolamento das regras de negócio.

### Inteligência Artificial

- Spring AI;
- ChatClient;
- ChatModel;
- prompts;
- Tool Calling;
- integração de LLM com operações reais de negócio;
- transcrição de áudio;
- Text-to-Speech.

### Integração multimodal

O projeto demonstra um fluxo que combina:

```text
Áudio
↓
Speech-to-Text
↓
LLM
↓
Tool Calling
↓
Sistema de negócio
↓
Text-to-Speech
```

---

# 📁 Estrutura resumida

```text
612-budgetingProjFinalComIA/
│
├── build.gradle
├── settings.gradle
├── gradlew
├── gradlew.bat
│
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/devrodrigo/
    │   │       └── _612budgetingprojfinalcomia/
    │   │
    │   └── resources/
    │       ├── application.properties
    │       └── prompts/
    │           └── system-message.st
    │
    └── test/
        ├── java/
        │   └── ... testes de integração
        │
        ├── http/
        │   └── api.http
        │
        └── resources/
            └── audio/
                ├── recording-1.m4a
                ├── recording-2.m4a
                ├── recording-3.m4a
                ├── recording-4.m4a
                ├── recording-5.m4a
                └── recording-6.m4a
```

---

# 🚀 O que este projeto demonstra profissionalmente

Mais do que um CRUD financeiro, este projeto demonstra a integração de uma aplicação Java tradicional com recursos de Inteligência Artificial.

Entre os principais pontos estão:

- desenvolvimento de API REST com Spring Boot;
- modelagem de domínio;
- persistência relacional com JPA/MySQL;
- arquitetura organizada em camadas;
- criação de casos de uso;
- integração de LLM com aplicação Java;
- **Tool Calling para execução de operações de negócio**;
- processamento de voz;
- integração com Whisper;
- geração de áudio;
- testes de integração;
- uso de serviços compatíveis com APIs OpenAI;
- construção de uma experiência de interação por linguagem natural.

O diferencial está principalmente em utilizar a IA não apenas para gerar texto, mas como **interface capaz de interpretar uma intenção e acionar funcionalidades reais do sistema**.

---

# 📌 Status

**Projeto final do Bootcamp Santander 2026 — em evolução.**

A implementação atual concentra-se em:

- registro de transações;
- consulta por categoria;
- interação com LLM;
- Tool Calling;
- transcrição de áudio;
- Text-to-Speech;
- persistência em MySQL.

Possíveis evoluções incluem autenticação de usuários, novas categorias, relatórios financeiros, orçamento mensal, dashboard, filtros por período e análises financeiras realizadas pela IA.

---

## 👨‍💻 Autor

**Rodrigo Medeiros Grassioto**

Projeto desenvolvido como parte do portfólio do **Bootcamp Santander 2026**.

> Este projeto representa uma etapa prática de estudos em Java, Spring Boot, arquitetura de software e integração de aplicações com Inteligência Artificial.
