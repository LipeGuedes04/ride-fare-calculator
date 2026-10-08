# 🏢 Sistema de Cálculo de Tarifa de Viagens por Aplicativo

## 🎯 O que o projeto faz?

O sistema simula o cálculo de tarifas para uma plataforma de viagens compartilhadas (estilo Uber). O usuário seleciona a categoria do veículo (**Econômica**, **Confort** ou **Black**), informa a **distância da viagem em KM** e o **horário de embarque**. O programa processa essas variáveis aplicando taxas base diferenciadas, adicionais para viagens de longa distância e uma taxa de **adicional noturno** caso a corrida aconteça de madrugada.

### 🔄 Fluxo da Aplicação
```text
[ Categoria do Veículo ] ➔ [ Distância em KM ] ➔ [ Horário de Embarque ] ➔ [ Cálculo de Taxas e Adicionais ] ➔ [ Tarifa Total ]
```

---

## 🎨 Design do Código (Como as regras conversam)

Este projeto foi estruturado utilizando controle de fluxo baseado em **Múltipla Escolha (Switch-Case)** para isolar as regras de cada categoria de veículo, seguido por **Estruturas Condicionais Aninhadas** para avaliar taxas de horário e distância. Veja o desenho limpa do fluxo logico:

```text
       ┌────────────────────────┐
       │   Escolha do Veículo   │ (Menu de opções via Switch-Case)
       └───────────┬────────────┘
                   │
         ┌─────────┼─────────┐
         ▼         ▼         ▼
     [Case 1]   [Case 2]  [Case 3]
     Econômica  Confort    Black
         │         │         │
         └─────────┼─────────┘
                   │
                   ▼
       ┌────────────────────────┐
       │ Verificação de Horário │ (Aplica +25% de taxa se entre 22h e 5h)
       └───────────┬────────────┘
                   │
                   ▼
       ┌────────────────────────┐
       │ Validação de Distância │ (Aplica +15 reais fixos se maior que 30KM)
       └────────────────────────┘
```

### 📋 Mapeamento de Variáveis e Estruturas

| Estrutura / Variável | O que ela faz no código? |
| :--- | :--- |
| 🚀 `main.java` | Classe principal que executa a interface de terminal, captura as entradas e processa a lógica de negócios. |
| 🚘 `opcaoVeiculo` | Inteiro que define a categoria escolhida (1 - Econômica, 2 - Confort, 3 - Black) para direcionar o cálculo. |
| 📏 `distancia` | Ponto flutuante (double) que armazena a quilometragem total para calcular a tarifa por KM. |
| ⏰ `horario` | Inteiro que representa a hora do embarque (0 a 23), usado para ativar o gatilho da taxa noturna. |
| 🌙 `addNoturno` | Armazena o valor calculado correspondente a 25% da tarifa base do veículo quando aplicável. |
| 📦 `addDistancia` | Constante interna (15) que penaliza viagens longas acima de 30 KM com uma taxa fixa de suporte. |

---

## 🧠 Conceitos de Programação Praticados

* **Estrutura de Seleção Switch-Case:** Utilizada para ramificar o fluxo do programa de forma limpa e legível sem a necessidade de múltiplos `if/else` encadeados na raiz.
* **Condicionais Aninhadas com Operadores Lógicos:** Uso do operador `||` (OU) para validar intervalos de tempo não lineares (ex: maior ou igual a 22 horas **OU** menor ou igual a 5 horas).
* **Formatação Numérica de Precisão:** Uso de `System.out.printf` com a diretiva `%.2f` para garantir que os valores monetários sejam exibidos corretamente com duas casas decimais.

---

## 💻 Exemplo Prático de Uso

Imagine a seguinte simulação de uma corrida executada tarde da noite de longa distância pelo terminal:

```text
Qual classe voce quer escolher para sua corrida? 
1- Classe Econômica 
2- Classe Confort 
3- Classe black
2
Qual será o seu destino em KM?
35
Que horas será o embarque? 
23

Você escolheu a classe Confort as 23 horas
Teve um adicional noturno de 28.13 reais
Valor total da corrida: 155.62 reais
```
