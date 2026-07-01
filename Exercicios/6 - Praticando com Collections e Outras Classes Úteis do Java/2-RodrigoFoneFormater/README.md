# 📱 Rodrigo Phone Formater - Mecanismo Avançado de Higienização e Validação Telefônica
Desenvolvido em: Java 26 | Contexto: Bootcamp Java Santander 2026.1

O **Rodrigo Phone Formater** é um motor utilitário desenvolvido via console para automatizar o processo de higienização, identificação e aplicação de máscaras dinâmicas sobre dados telefônicos brutos. O projeto foi projetado para demonstrar o tratamento avançado de Strings no Java moderno através da união de **Expressões Regulares (Regex)** com grupos de captura, estruturas de dados imutáveis com **Java Records** e o poder das **Classes Utilitárias Defensivas**.

O grande diferencial deste submódulo é a sua resiliência a entradas poluídas ou incorretas. O motor consegue extrair a essência numérica de qualquer string misturada com letras ou caracteres especiais, corrigindo máscaras corrompidas e deduzindo o tipo do dispositivo (Fixo ou Celular, Com ou Sem DDD) puramente com base na volumetria de dígitos remanescentes.

Este projeto é um sub-módulo que integra o meu portfólio completo de engenharia Java desenvolvido durante o Bootcamp.

👉 [Acesse o README na Raiz do Repositório para visualizar todos os projetos do Bootcamp](https://github.com/rodrigomgrassioto/BootcampSantander2026-01)

---

## 📋 Regras de Negócio e Cobertura do Desafio
O sistema processa entradas textuais e as categoriza em quatro padrões regulamentados de telecomunicação, gerando uma resposta padronizada estruturada em JSON:

*   **Celular com DDD (`DDD+CELULAR`):** Processamento de volumetria estrita de **11 dígitos**, aplicando a máscara unificada com o nono dígito integrado ao prefixo: `(xx)xxxxx-xxxx`.
*   **Telefone Fixo com DDD (`DDD+FIXO`):** Processamento de volumetria de **10 dígitos**, aplicando o padrão comercial brasileiro: `(xx)xxxx-xxxx`.
*   **Celular sem DDD (`APENAS_CELULAR`):** Processamento de volumetria isolada de **9 dígitos**, aplicando a máscara local: `xxxxx-xxxx`.
*   **Telefone Fixo sem DDD (`APENAS_FIXO`):** Processamento de volumetria isolada de **8 dígitos**, aplicando a máscara local: `xxxx-xxxx`.

---

## 🎯 Desafios Técnicos Solucionados (Destaques para Recrutadores e ATS)

Durante o desenvolvimento deste validador, apliquei padrões consolidados de arquitetura limpa e programação defensiva:

*   **Higienização e Extração via Caracteres Não-Numéricos (`\\D`):** Em vez de criar validações complexas e frágeis para cada caractere digitado pelo usuário, o sistema utiliza a Regex `\\D` para expurgar instantaneamente letras, espaços e símbolos. Isso resolve de forma nativa e por antecipação os requisitos de "MÁSCARA INCORRETA", "MÁSCARA CORRETA" ou "MISTURA DE NÚMEROS E LETRAS".
*   **Grupo de Captura Dinâmico em Regex:** A formatação final não reconcatena strings manualmente. Foram projetadas expressões regulares com múltiplos grupos de captura (ex: `(\\d{2})(\\d{5})(\\d{4})`), onde o método `.replaceAll` reorganiza as variáveis de memória de forma atômica através dos ponteiros `$1`, `$2` e `$3`.
*   **Design Pattern Utility Class com Construtor Trancado:** A classe `PhoneFormater` foi projetada para atuar puramente na memória estática de alta performance. O construtor privado `private` com lançamento de `UnsupportedOperationException` impede fisicamente a instanciação da classe via `new`, blindando o sistema contra vazamento de memória e desperdício de escopo.
*   **Envelope Pattern para Integração de APIs (JSON Nativo):** O transporte de dados utiliza o `PhoneResponse` (um Java Record imutável), contendo chaves universais em inglês no padrão *camelCase* (`success`, `type`, `formattedNumber`, `message`). O objeto expõe um método `.toJson()` baseado em **Text Blocks (`"""`)** para simular uma resposta de API Rest corporativa sem dependências externas.
*   **Imports Implícitos do Java Moderno:** Uso estratégico dos recursos de *Unnamed Classes* do Java 26. O ponto de entrada aproveita a importação automática de pacotes comuns de utilitários (como o `Scanner`), reduzindo o ruído visual de imports no cabeçalho.

---

## 💻 Exemplos de Código e Implementação

### 1. Higienização Defensiva e Aplicação de Máscara por Volumetria
Demonstração de como a classe limpa o input do usuário e usa grupos de captura para redesenhar a string telefônica com precisão:

```java
// Remove tudo que não for número, unificando qualquer tipo de entrada (com ou sem máscara)
String onlyNumbers = unformattedNumber.replaceAll("\\D", "");

// Captura exata: 2 dígitos do DDD, 5 do prefixo celular e 4 do sufixo
if (onlyNumbers.length() == 11) {
    String formatado = onlyNumbers.replaceAll("(\\d{2})(\\d{5})(\\d{4})", "(\$1) \$2-\$3");
    return new PhoneResponse(formatado, "DDD+CELULAR", true, "DDD + celular processado com sucesso.");
}
```

### 2. Barreira Defensiva no Construtor Utilitário
Garantia arquitetural de que a classe funcionará apenas como um catálogo de funções estáticas sem estado:

```java
public final class PhoneFormater {
    private PhoneFormater() {
        // Bloqueio físico contra instanciação indevida ou via reflexão
        throw new UnsupportedOperationException("Classe utilitária não pode ser instanciada.");
    }
    // ... métodos estáticos
}
```

---

## 🚀 Como Executar o Projeto

Este submódulo foi construído de forma nativa no IntelliJ IDEA, dependendo puramente dos recursos integrados da linguagem.

### Pré-requisitos
*   **Amazon Corretto 26** como JDK principal configurado.
*   **IntelliJ IDEA** instalado.

### Passo a Passo no IntelliJ IDEA

1. **Atualize o seu repositório local:**
   ```bash
   git clone https://github.com/rodrigomgrassioto/BootcampSantander2026-01/tree/main/Exercicios/6%20-%20Praticando%20com%20Collections%20e%20Outras%20Classes%20%C3%9Ateis%20do%20Java/2-RodrigoFoneFormater
   ```
2. **Abra o Projeto:**
    * No IntelliJ, vá em **File > Open** e selecione a pasta deste subprojeto.
3. **Validação do Ambiente:**
    * Pressione `Ctrl + Alt + Shift + S` e certifique-se de que o **Project SDK** está apontando para o **Java 26**.
4. **Execute e Teste inputs dinâmicos:**
    * Abra a classe contendo o método `void main()` e execute-a.
    * Digite cenários complexos no terminal como: `meu fone é (11)9-88887777` ou `33334444` e veja o JSON estruturado contendo a validação de sucesso e o tipo do dispositivo.

---

## 🤝 Conecte-se Comigo
Estou focado em projetar arquiteturas backend sólidas, aplicando as melhores atualizações do ecossistema Java. Sinta-se à vontade para analisar meus repositórios ou entrar em contato!

👉 [Acesse meu perfil no LinkedIn para Networking](https://www.linkedin.com/in/devrod)
