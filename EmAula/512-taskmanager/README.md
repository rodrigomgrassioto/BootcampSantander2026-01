# 🚀 TaskManager API - Spring Boot
![Java](https://img.shields.io/badge/Java-26-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.1.0-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-9.6.1-02303A?style=for-the-badge&logo=gradle&logoColor=white)

Um gerenciador de tarefas robusto desenvolvido em **Java 26** e **Spring Boot 4.1.0**. O projeto foi construído do zero aplicando conceitos avançados de arquitetura desacoplada, validações estritas de contratos e geração de documentação automatizada viva (Living Documentation) orientada a testes.

---

## 🛠️ Tecnologias e Ferramentas

*   **Linguagem Principal:** Java 26 (Uso pioneiro de recursos modernos de Records e herança)
*   **Framework Core:** Spring Boot 4.1.0 (Web, Validation)
*   **Gerenciador de Build:** Gradle (Sintaxe moderna com `tasks.named`)
*   **Testes & Mocks:** JUnit 5, Mockito
*   **Documentação Automatizada:** Spring REST Docs + Asciidoctor (AsciidoctorJ 3.0.0)

---

## 🏗️ Arquitetura e Boas Práticas

O projeto segue princípios de **Clean Architecture** e **Domain-Driven Design (DDD)**, garantindo que as regras de negócio permaneçam isoladas de detalhes de infraestrutura e provedores de persistência.

*   **Inversão de Dependências (SOLID):** A camada de domínio dita o contrato através da interface `TaskRepository`. A infraestrutura implementa esse contrato (ex: `InMemoryTaskRepository`), permitindo a troca de banco de dados sem alterar a lógica de negócios.
*   **Value Objects & Imutabilidade:** Uso de Java `Records` (como `TaskId`) protegidos com asserções estritas (`Assert.notNull`) para impedir estados inconsistentes em memória.
*   **Tratamento Global de Erros:** Captura cirúrgica de exceções de domínio (como `TaskNotFoundException`) mapeadas para respostas HTTP sem expor detalhes internos da aplicação via `@RestControllerAdvice`.
*   **DTOs Seguros:** Uso de Records dedicados (`CreateTaskRequest`, `TaskResponse`) com anotações do Bean Validation (`@NotBlank`, `@Size`) para filtragem e barreira de dados na entrada da API.

---

## 📄 Documentação Viva (Spring REST Docs)

Diferente do Swagger tradicional, que polui os controladores com metadados, esta API utiliza o **Spring REST Docs**. A documentação é gerada automaticamente a partir da execução de **Testes de Integração** com `MockMvc`. Se um contrato de API mudar e o teste não for atualizado, o build falha!

### Como os documentos são gerados:
1. Os testes unitários/integração rodam via JUnit e MockMvc.
2. O Spring REST Docs captura os payloads reais de requisição e resposta e gera snippets Asciidoc em `build/generated-snippets/`.
3. O plugin do Asciidoctor processa o arquivo mestre `index.adoc` e compila os pedaços em uma página HTML estática e elegante.

### Código de Integração Automatizada (`build.gradle`)

O motor de compilação da documentação está configurado de forma isolada e moderna no Gradle, centralizando as tarefas e removendo redundâncias:

```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '4.1.0'
    id 'io.spring.dependency-management' version '1.1.7'
    id 'org.asciidoctor.jvm.convert' version '4.0.5'
}

asciidoctorj {
    version = '3.0.0'
}

configurations {
    asciidoctorExt
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'

    // Validação de inputs do usuário
    implementation 'org.springframework.boot:spring-boot-starter-validation'
    implementation 'org.springframework.boot:spring-boot-starter-web'

    // Spring REST Docs
    asciidoctorExt 'org.springframework.restdocs:spring-restdocs-asciidoctor'
    testImplementation 'org.springframework.restdocs:spring-restdocs-mockmvc'
}

ext {
    snippetsDir = file('build/generated-snippets')
}

tasks.named('test') {
    useJUnitPlatform()
    outputs.dir snippetsDir
}

tasks.named('asciidoctor') {
    inputs.dir snippetsDir
    setConfigurations([configurations.asciidoctorExt])
    dependsOn test
}
```

---

## 🚀 Como Rodar o Projeto e Gerar a Documentação

### Pré-requisitos
*   Java JDK 26 instalado.

### 1. Clonar o repositório
```bash
git clone https://github.com/rodrigomgrassioto/BootcampSantander2026-01
cd BootcampSantander2026-01\EmAula\512-taskmanager
```

### 2. Rodar a aplicação
```bash
./gradlew bootRun
```

### 3. Executar os testes e compilar a documentação HTML
Para rodar a bateria de testes integrados e gerar a página final com todos os contratos da API atualizados, execute:
```bash
./gradlew asciidoctor
```

O arquivo HTML interativo completo contendo exemplos em cURL, payloads de entrada/saída e status HTTP estruturados estará disponível em:
👉 `build/docs/asciidoc/index.html`

🌍 [Exemplo Documentação gerada automáticamente](https://htmlpreview.github.io/?https://github.com/rodrigomgrassioto/BootcampSantander2026-01/blob/512task-manager/EmAula/512-taskmanager/src/docs/asciidoc/index.html)

---

Desenvolvido com ☕ e dedicação por [Rodrigo Medeiros Grassioto](https://www.linkedin.com/in/devrod).
