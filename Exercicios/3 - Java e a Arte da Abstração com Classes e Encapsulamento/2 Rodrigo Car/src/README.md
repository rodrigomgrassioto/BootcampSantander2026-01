# 🏎️ Rodrigo Car - Sistema de Controle de Veículo Simulado
Desenvolvido em: Java 26 | Contexto: Bootcamp Java Santander 2026.1

📋 Requisitos do Desafio
O projeto foi desenvolvido seguindo estritamente os seguintes critérios propostos pelo curso:

💻 Menu Interativo: Interface funcional via terminal com loop contínuo e opção dedicada de saída para finalização da execução.  
🎮 Funções Obrigatórias: Ligar, desligar, acelerar, diminuir velocidade, virar para a esquerda/direita, verificar velocidade e trocar de marcha.  
🛠️ Regra de Inicialização: O veículo inicia obrigatoriamente desligado, em ponto morto (marcha 0) e com velocidade zerada (0 km/h).  
🔐 Restrição de Estado: O carro desligado é um objeto estático e não pode realizar nenhuma função operacional.  
📈 Regra de Aceleração/Desaceleração: Incrementos e decrementos contínuos de 1 em 1 km/h, respeitando o piso de 0 km/h e o teto físico de 120 km/h.  
⚙️ Relação Estrita de Transmissão (Marcha x Velocidade):
* Marcha 0 (Ponto Morto): Bloqueio absoluto de aceleração (0 km/h).
* 1ª Marcha: Operação restrita entre 0 km/h e 20 km/h.
* 2ª Marcha: Operação restrita entre 21 km/h e 40 km/h.
* 3ª Marcha: Operação restrita entre 41 km/h e 60 km/h.
* 4ª Marcha: Operação restrita entre 61 km/h e 80 km/h.
* 5ª Marcha: Operação restrita entre 81 km/h e 100 km/h.
* 6ª Marcha: Operação restrita entre 101 km/h e 120 km/h.  
🔄 Bloqueio de Câmbio: Sistema sequencial obrigatório. É expressamente proibido pular marchas.  
🛑 Desligamento Seguro: O motor só pode ser desligado se o veículo estiver totalmente imobilizado (0 km/h) e em ponto morto (marcha 0).  
↩️ Física de Manobra: Curvas (esquerda/direita) possuem trava de segurança ativa; só são permitidas com o carro em movimento (mínimo 1 km/h) e em velocidade segura (máximo 40 km/h).

---

O **Rodrigo Car** é uma aplicação de console de alta fidelidade que modela o comportamento mecânico e a física de transmissão de um veículo de passeio manual. O projeto foi construído para demonstrar o domínio em encapsulamento rígido, programação defensiva e controle preciso de fluxo de dados.

O grande diferencial do projeto é o gerenciamento dinâmico de sincronia. Para evitar travar o usuário nas faixas estritas de transição (como a barreira dos 21 km/h), o sistema implementa um assistente inteligente de câmbio que calibra a velocidade milimetricamente nas reduções e subidas, sem violar as regras de negócio ou corromper o estado das variáveis.

🎯 Desafios Técnicos Solucionados (Destaques para Recrutadores)
Durante o desenvolvimento do ecossistema do Rodrigo Car, foquei em mitigar problemas clássicos de lógica e concorrência de estados:

*   **Sincronização de Transmissão Sem Travamentos (Edge Case Handling):** A divisão estrita das faixas de marcha (ex: 1ª marcha até 20 km/h, 2ª marcha a partir de 21 km/h) criava um cenário de bloqueio mútuo nas reduções de velocidade. Apliquei uma engenharia de transição onde os métodos `gearUp()` e `gearDown()` ajustam automaticamente a velocidade em ±1 km/h nos pontos críticos, permitindo um encaixe perfeito e contínuo nas faixas adjacentes sem travar o motorista.
*   **Encapsulamento Rígido e Defesa de Estado:** A classe `Car` protege suas propriedades internas (`status`, `speed`, `gear`) contra modificações externas inválidas. Cada método atua como uma cláusula de barreira (*Guard Clause*), impedindo abusos como acelerar na banguela para desperdiçar combustível ou acionar o freio com o veículo desligado.
*   **Centralização e Reutilização de Código (Generics & Polymorphism):** Integração com a classe utilitária `ConsoleUtils.lerNumeroSeguro`. Usando polimorfismo com a classe abstrata `Number`, o sistema centralizou a captura de dados do terminal, tratando de forma genérica tanto entradas do menu (`int`) quanto possíveis parâmetros flutuantes (`double`).
*   **Tratamento Defensivo contra Quebra de Fluxo (Buffer Safety):** Eliminação de bugs causados por resíduos no teclado através da substituição de leituras parciais por varreduras de linha inteira (`scanner.nextLine()`). Falhas como `NumberFormatException` ou strings vazias são tratadas silenciosamente, blindando a aplicação contra crashs.
*   **Uso de Recursos Modernos do Ecossistema Java:** A arquitetura utiliza recursos contemporâneos da linguagem, como estruturas switch modernas baseadas em *Arrow Labels* (`case X -> ...`) e inicialização limpa via *Implicitly Declared Classes*, reduzindo o código boilerplate.

---

## 📁 Estrutura de Classes

```text
src/
│
├── br.com.rodrigo.car/
│   └── Car.java               # Camada de Domínio: Armazena o estado do veículo e executa as regras mecânicas.
│
├── br.com.rodrigo.utils/
│   └── ConsoleUtils.java      # Camada de Infra: Isolamento do Scanner e tratamento seguro de exceções de IO.
│
├── Main.java                  # Camada de Interface: Orquestração do menu interativo e controle do loop do simulador.
│
└── README.md                  # Documentação Técnica: Visão de negócios e engenharia voltada para recrutadores.
```

---

## ⚙️ Funcionalidades Principais

*   **Painel de Instrumentos Dinâmico (UX Avançada):** Menu contextual baseado no estado real do carro. Se o veículo estiver desligado, apenas as opções "Ligar" e "Sair" ficam disponíveis. Opções de risco, como "Freada de Emergência", são exibidas dinamicamente apenas se o carro estiver em movimento.
*   **Controle de Câmbio Assistido:** Trocas de marchas inteligentes. Sair do repouso (0 km/h) e engatar a 1ª marcha atualiza o sistema de forma limpa. Reduzir marchas em velocidades mais altas atua como um simulador de freio motor controlado.
*   **Física de Manobra Protegida:** Tentativas de virar o volante com o carro parado ou acima de 40 km/h disparam um alerta de manobra recusada, simulando a perda de aderência e protegendo a integridade da simulação.
*   **Gerenciamento Ecológico na Banguela:** O sistema permite colocar o carro em ponto morto (marcha 0) em movimento. O acelerador é bloqueado automaticamente para simular economia de combustível, mas o sistema mantém a segurança liberando o reengate de marchas (`gearUp`) ou o uso do freio de emergência a qualquer momento.

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
*   Java JDK 25+ ou superior instalado.
*   IDE de sua preferência (IntelliJ IDEA, VS Code ou Eclipse).

### Passo a passo
1. Clone este repositório em sua máquina:
   ```bash
   git clone https://github.com/rodrigomgrassioto/BootcampSantander2026-01
   ```
   * Obs: Projeto com todos os sub-projetos do curso.
2. Abra o projeto em sua IDE predileta.
3. Certifique-se de que a conformidade do compilador está definida para o Java 25+.
4. Execute a classe `Main.java` localizada na raiz da pasta `src/`.

---

## 🛠️ Tecnologias e Conceitos Aplicados

*   **Java SE Contemporâneo:** Tipagem estrita, estruturas condicionais limpas, loops de controle `do-while` e gerenciamento estrito de escopo de métodos.
*   **Orientação a Objetos de Alta Coesão:** Encapsulamento absoluto de atributos, ocultação de regras de implementação e delegação clara de responsabilidades entre classes.
*   **Programação Defensiva (Clean Code):** Emprego extensivo de *Guard Clauses* para eliminar o aninhamento excessivo de blocos `else`, nomenclatura expressiva em inglês padrão internacional e uso de `System.out.printf` com `%n` para garantir portabilidade entre sistemas operacionais (Windows, Mac, Linux).

---

## 👤 Desenvolvedor

*   **Rodrigo** - *Desenvolvedor Java Backend*
*   Projeto prático desenvolvido para o **Bootcamp Santander 2026.1**.
