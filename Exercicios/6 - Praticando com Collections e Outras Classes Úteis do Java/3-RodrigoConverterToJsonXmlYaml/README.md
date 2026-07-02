# 📊 Rodrigo Multi-Format Generator - Motor Avançado de Serialização de Dados em Lote
Desenvolvido em: Java 26 | Contexto: Bootcamp Java Santander 2026.1

O **Rodrigo Multi-Format Generator** é um motor utilitário de ingestão e transformação de dados em lote via console. O projeto foi projetado para demonstrar o controle de fluxos de dados dinâmicos e conversão simultânea para as três principais estruturas de mercado: **JSON, XML e YAML**, unindo o poder de organização das **Java Collections (`LinkedHashMap`)**, imutabilidade via **Java Records (`DateField`)** e o processamento declarativo e performático da **Java Stream API**.

O grande diferencial deste submódulo é o desacoplamento arquitetural baseado no princípio de responsabilidade única. O sistema implementa uma esteira de processamento estruturada: os inputs textuais brutos e poluídos são normalizados em tokens previsíveis, os valores passam por rotinas de higienização por expressões regulares (*Regex*) para conversão em tipos nativos da linguagem (incluindo a moderna *Java Time API*) e, por fim, são serializados em lote através de Streams que gerenciam delimitadores complexos na unha, sem dependências de bibliotecas externas.

Este projeto é um sub-módulo que integra o meu portfólio completo de engenharia Java desenvolvido durante o Bootcamp.

👉 [Acesse o README na Raiz do Repositório para visualizar todos os projetos do Bootcamp](https://github.com/rodrigomgrassioto/BootcampSantander2026-01)

---

## 📋 Regras de Domínio e Tipos Suportados
O motor opera em um ciclo contínuo de recepção ("N Vezes"), capturando chaves e valores inseridos em linha única delimitados por ponto e vírgula (`NOME_CAMPO;VALOR;TIPO;`) e aplicando regras estritas de serialização com base nos metadados do tipo:

*   **Texto (`str` / `1`):** Cadeias de caracteres puras tratadas com aspas no JSON/YAML e encapsuladas por tags no XML.
*   **Inteiro (`int` / `2`):** Valores numéricos primitivos encapsulados em `Integer`, serializados de forma literal (sem aspas).
*   **Decimal (`dec` / `3`):** Pontos flutuantes de dupla precisão (`Double`), estruturados sem aspas.
*   **Booleano (`bool` / `4`):** Flags lógicas de alta usabilidade e tolerância gramatical (mapeia `true`, `verdade`, `sim`, `v` ou `1`), serializadas sem aspas.
*   **Data (`date` / `5`):** Objetos temporais `LocalDate` processados defensivamente a partir de qualquer padrão digitado e convertidos com o padrão `dd/MM/yyyy`.
*   **Data e Hora (`datetime` / `6`):** Carimbos de tempo `LocalDateTime` com rotina automática de autocompletar segundos caso omitidos pelo usuário (`dd/MM/yyyy HH:mm:ss`).

---

## 🎯 Desafios Técnicos Solucionados (Destaques para Recrutadores e ATS)

Durante o desenvolvimento deste mecanismo de serialização, apliquei padrões avançados de design de código limpo e tolerância a falhas:

*   **Preservação Cronológica via `LinkedHashMap`:** A escolha da coleção `LinkedHashMap` garante que a disposição física dos elementos gerados no JSON, XML e YAML respeite rigorosamente a ordem em que o usuário inseriu os dados no console, evitando o comportamento de ordenação aleatória de tabelas de espalhamento tradicionais (`HashMap`).
*   **Pipeline de Redução Declarativa com `Stream API`:** A conversão estrutural do mapa foi centralizada no método `FormatExporter` utilizando o pipeline `.entrySet().stream()`. A lógica substitui loops imperativos (`for`) por mapeamentos declarativos e delega a montagem complexa dos delimitadores dinâmicos ao método `Collectors.joining(",\n")`, garantindo a integridade sintática das saídas.
*   **Ajuste Fino de Processamento (Esteira de Tipos):** Implementação do padrão *Pipe and Filter* na classe utilitária `TypeConverter`. O método `normalizarTipo` atua como um filtro inicial que uniformiza atalhos numéricos ou palavras por extenso, permitindo que o método `converter` possua uma *switch expression* (Java 14+) ultra limpa, coesa e focada estritamente no *parsing* final.
*   **Higienização Avançada de Strings com Regex (`\\D`):** As entradas de data e hora foram blindadas contra ruídos de digitação. Ao expurgar caracteres não-numéricos, o sistema tolera inputs como `23p03o1982` ou `15-04-2026`, isolando os dígitos e reconstruindo a semântica de formatação por meio de grupos de captura e retrovisores ordenados (`$1`, `$2`, `$3`).
*   **Tratamento Defensivo e Resiliência do Loop:** O ponto de entrada principal (`void main`) encapsula a chamada de transformação de dados dentro de um bloco `try/catch` interno ao laço `while(true)`. Caso ocorra uma falha de conversão (ex: data inválida), o sistema reporta o erro de forma amigável no console, descarta o lixo da memória e mantém a aplicação rodando para novas inserções.

---

## 💻 Exemplos de Código e Implementação

### 1. Ingestão Defensiva de Datas por Fatiamento de Regex
Demonstração de como o motor remove ruídos textuais e reestrutura os blocos numéricos de forma estável para a *Java Time API*:

```java
case "date" -> {
    // Mantém apenas os caracteres numéricos purificados
    String apenasNumeros = valorBruto.replaceAll("\\D", "");

    if (apenasNumeros.length() != 8) {
        throw new IllegalArgumentException("❌ Data inválida. Precisa conter exatamente 8 dígitos numéricos.");
    }

    // Remonta a string injetando os delimitadores padrão do formatador
    String dataFormatada = apenasNumeros.replaceAll("(\\d{2})(\\d{2})(\\d{4})", "\$1/\$2/\$3");
    yield LocalDate.parse(dataFormatada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
}
```

### 2. Tratamento e Condicional de Aspas Duplas no Fluxo da Stream
Processamento de metadados baseado nas tags semânticas do Record `DateField` para montagem de chaves JSON válidas:

```java
String mioloJson = map.entrySet().stream()
        .map(entry -> {
            String chave = entry.getKey();
            Object valor = entry.getValue().valorConvertido();
            String tipo = entry.getValue().tipoOriginal();

            // Strings, datas e timestamps necessitam obrigatoriamente de aspas duplas
            if (tipo.equals("str") || tipo.equals("date") || tipo.equals("datetime")) {
                return "  \"%s\": \"%s\"".formatted(chave, valor);
            }
            // Tipos numéricos e booleanos literais
            return "  \"%s\": %s".formatted(chave, valor);
        })
        .collect(Collectors.joining(",\n"));
```

---

## 🚀 Como Executar o Projeto

Este submódulo foi construído de forma nativa e pura, sem acoplamento com gerenciadores de dependência externos, utilizando os recursos nativos do Amazon Corretto 26.

### Passo a Passo no IntelliJ IDEA

1. **Abra o seu terminal corporativo e sincronize o repositório:**
   ```bash
   git clone https://github.com/rodrigomgrassioto/BootcampSantander2026-01/tree/main/Exercicios/6%20-%20Praticando%20com%20Collections%20e%20Outras%20Classes%20%C3%9Ateis%20do%20Java/3-RodrigoConverterToJsonXmlYaml
   ```
2. **Abra a pasta deste subprojeto específico no IntelliJ IDEA (File > Open).**
3. **Valide a conformidade das propriedades do projeto (`Ctrl + Alt + Shift + S`) garantindo a seleção do Java 26.**
4. **Localize o arquivo principal que expõe o método `void main()` e execute-o (`Shift + F10`).**
5. **Simule entradas dinâmicas misturando padrões e atalhos de tipo, como por exemplo:**
    * `name;Carla Thais;texto;`
    * `idade;43;2;` (Uso do atalho numérico para inteiros)
    * `dormindo;verdade;bool;` (Uso da flexibilidade gramatical booleana)
    * `agora;01-07-2026 20:59;6;` (Autocomplemento automático de segundos ativado)
    * Digite `sair` ou `0` para interromper o fluxo e visualizar a renderização multiformato imediata.

---

## 🤝 Conecte-se Comigo
Estou focado em projetar arquiteturas backend sólidas, aplicando as melhores atualizações do ecossistema Java. Sinta-se à vontade para analisar meus repositórios ou entrar em contato!

👉 [Acesse meu perfil no LinkedIn para Networking](https://www.linkedin.com/in/devrod)
