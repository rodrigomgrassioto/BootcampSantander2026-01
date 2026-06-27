# 📢 Rodrigo Múltiplos Envios - Sistema Dinâmico de Mensageria de Marketing
Desenvolvido em: Java 26 | Contexto: Bootcamp Java Santander 2026.1

O **Rodrigo Múltiplos Envios** é um motor de mensageria omni-channel desenvolvido via console para automatizar campanhas de marketing digital. O projeto foi projetado para solucionar o desafio de distribuição simultânea de conteúdo, aplicando o padrão de projeto arquitetural **Strategy** combinado com recursos modernos de **Programação Funcional** do ecossistema Java.

O grande diferencial técnico deste submódulo é o desacoplamento absoluto dos serviços de entrega: a aplicação é capaz de injetar dinamicamente novas mídias de envio (como canais baseados em Expressões Lambda ou Records) sem impactar o fluxo de controle principal.

---

## 📋 Requisitos do Desafio
O sistema simula uma central de disparos em massa que atende estritamente aos seguintes critérios de arquitetura:

*   **Abstração de Contrato (`MessageSender`):** Interface que obriga a passagem do conteúdo da mensagem estritamente como **parâmetro de método**, permitindo que os serviços operem de forma stateless (sem retenção desnecessária de estado na memória).
*   **Disparos Isolados:** Suporte a chaveamento dinâmico para envios individuais via **SMS**, **E-mail**, **Redes Sociais (Facebook)** e **WhatsApp**.
*   **Disparo Omni-channel (`todos()`):** Algoritmo centralizado que consome a mesma mensagem e a propaga simultaneamente através de todos os canais de comunicação ativos de maneira agnóstica.

---

## 🎯 Desafios Técnicos Solucionados (Destaques para Recrutadores e ATS)

Durante o desenvolvimento desta aplicação, os seguintes padrões de engenharia e boas práticas de código limpo foram consolidados:

*   **Padrão Polimórfico Strategy:** A interface principal encapsula o algoritmo de envio. O menu principal (`switch`) apenas altera a estratégia de execução (`messageSender = novaEstrategia`), promovendo um código livre de condicionais aninhadas de validação de tipo.
*   **Segurança Defensiva na Inicialização de Strings:** Tratamento cirúrgico de concatenação em loops para evitar a inicialização literal de strings como `"null"`, utilizando reinicialização estrita de buffers (`msgTodos = ""`).
*   **Validação de Presença com Java 11+:** Uso de estruturas condicionais inteligentes (`msg.isBlank()`) para ocultar ou exibir opções do menu baseando-se no estado real do preenchimento da mensagem, blindando o sistema contra disparos nulos ou vazios.
*   **Injeção Dinâmica Baseada em Lambdas (`->`):** Demonstração de interoperabilidade de paradigmas ao instanciar o canal de E-mail de forma anônima diretamente no fluxo, utilizando a sintaxe funcional nativa do Java (similar às *Arrow Functions* do ecossistema JavaScript).
*   **Gerenciamento Eficiente de Memória:** Estruturação de Records sem atributos de instância fixos, permitindo o reaproveitamento de componentes e evitando vazamento de memória (*memory leaks*) em cenários de alta concorrência de IO.

---

## 💻 Exemplos de Código e Implementação

### 1. Contrato Abstrato com Passagem de Parâmetro (Stateless)
A interface define que o dado trafega exclusivamente pelo método, cumprindo o requisito de flexibilidade do motor de marketing:

```java
package com.devrodrigo.messagessender;

public interface MessageSender {
    // Cumprindo o requisito: a mensagem entra estritamente como parâmetro
    String sendMessage(String msg); 
}
```

### 2. Implementação Concreta via Java Records
Utilização de Records focados em comportamento, garantindo imutabilidade estrutural e legibilidade:

```java
package com.devrodrigo.messagessender;

public record SocialMedia() implements MessageSender {
    @Override
    public String sendMessage(String msg) {
        return "✅ Enviado: " + msg + " via Facebook.%n"; 
    }
}
```

### 3. Loop de Disparo Multicanal (Omni-channel)
Abordagem limpa e extensível para disparar mensagens simultâneas em lote sem repetição de código estrutural:

```java
private void todos() {
    // Lista polimórfica contendo todos os canais ativos
    java.util.List<MessageSender> servicos = java.util.List.of(
        new Sms(), new Email(), new SocialMedia(), new Whatsapp()
    );
    
    msgTodos = ""; // Inicialização contra o comportamento "null" do compilador
    for (MessageSender servico : servicos) {
        msgTodos += servico.sendMessage(msg); // Acumula o log de envios bem-sucedidos
    }
}
```

---

## 🚀 Como Executar o Projeto

Este projeto foi construído de forma nativa e enxuta, sem dependências de ferramentas externas de build como Maven ou Gradle.

### Pré-requisitos
*   **Amazon Corretto 26** instalado localmente.
*   **IntelliJ IDEA** (ou qualquer IDE Java de mercado).

### Passo a Passo no IntelliJ IDEA

1. **Clone o Repositório:**
   ```bash
   git clone https://github.com/rodrigomgrassioto/BootcampSantander2026-01/tree/main/Exercicios/5%20-%20Dominando%20Interfaces%20e%20Lambda%20em%20Java/1-RodrigoMess
   ```
2. **Abra o Projeto:**
    * Inicie o IntelliJ IDEA.
    * Selecione **File > Open** e escolha a pasta deste submódulo.
3. **Configure o Java 26:**
    * Vá em **File > Project Structure > Project**.
    * Confirme se o **Project SDK** está apontando para o **Amazon Corretto 26**.
4. **Rode a Aplicação:**
    * Abra o arquivo que contém a classe principal com o método `void main()`.
    * Clique no ícone verde de **Play** (Run) ao lado do método.
    * Interaja com a central de marketing diretamente pelo terminal integrado da IDE.

---

## 🤝 Conecte-se Comigo
Busco constantemente aplicar os melhores padrões de arquitetura de software focados em escalabilidade e performance no ecossistema Backend. Sinta-se à vontade para se conectar ou explorar meus códigos!

👉 [Visite meu perfil no LinkedIn para Networking](https://www.linkedin.com/in/devrod)
