# ***Befunge-93*** **Trabalhando com Extrutura de Dados**

## Objetivo

Criar um interpretador da linguagem *Befunge-93* com java, aplicando e exercitando conceitos de estrutura de dados.

## Introdução

Befunge é uma linguagem de programação extremamente incomum e inovadora, criada pelo programador americano Chris Pressey em 1993. Diferentemente da maioria das linguagens que conhecemos, Befunge é uma linguagem esotérica, ou seja, ela foi criada para ser obscura, divertida e desafiadora para os programadores.


Seu nome "Befunge" é uma junção de "Best" (melhor) e "Funge" (uma corruptela da palavra "fungo" em inglês, significando um organismo simples e de crescimento rápido). Essa designação representa o objetivo de ser uma das melhores linguagens esotéricas já criadas.


## Características Principais

### Grade Bidimensional

A característica mais distintiva do Befunge é a sua execução em uma grade bidimensional infinita. Enquanto a maioria das linguagens possui uma linha de execução linear, o Befunge pode mover-se em quatro direções: para cima, para baixo, para a esquerda e para a direita. Isso permite uma abordagem única na escrita de programas.


### Instruções Únicas

Befunge possui apenas nove caracteres de comando, tornando-a uma das linguagens mais compactas já desenvolvidas. Cada caractere corresponde a uma instrução específica que altera o fluxo do programa. As instruções incluem coisas como mover a direção do ponteiro, empurrar ou pop valores da pilha, executar operações aritméticas e muito mais.


### Fluxo Aleatório

O fluxo de execução em Befunge é altamente não determinístico. O ponteiro do programa pode ser redirecionado a qualquer momento para qualquer direção, dependendo das instruções encontradas. Isso resulta em um comportamento caótico e imprevisível, desafiando os programadores a criar algoritmos e estruturas de controle criativas.


### Comandos ASCII

Além das instruções regulares, Befunge também possui comandos ASCII. Isso significa que os caracteres ASCII na grade têm seus próprios significados especiais e podem ser usados como instruções. Isso aumenta a flexibilidade e a complexidade do código.


### Exemplo de Programa

Aqui está um simples programa Befunge que imprime "Hello, World!" na tela

>"!dlroW ,olleH" ,,,,,,,,,, @

Neste programa, os caracteres entre as aspas são empurrados para a pilha e, em seguida, retirados um por um e impressos na tela em ordem reversa, graças ao uso inteligente de comandos.


### Sintaxe

Aqui está uma breve visão geral da sintaxe básica do Befunge-93:

1. **Grade**: O programa Befunge-93 é representado em uma grade bidimensional, na qual cada caractere é uma instrução ou um espaço em branco. O fluxo do programa pode ser alterado, direcionando o ponteiro horizontalmente ou verticalmente ao longo da grade.
2. **Ponteiro**: O programa começa com o ponteiro apontando para a direção direita (>) por padrão, mas pode ser alterado durante a execução. O ponteiro pode ser movido pelas setas: > (direita), < (esquerda), ^ (cima) e v (baixo).
3. **Instruções básicas**: Cada caractere é uma instrução, e elas são executadas sequencialmente a partir do ponto de entrada. Alguns exemplos de instruções básicas são:
    * 0-9 Empilhar o valor numérico no topo da pilha de dados.
    * + Adicionar os dois valores do topo da pilha e empilhar o resultado.
    * - Subtrair o valor no topo da pilha do próximo valor e empilhar o resultado.
    * \* Multiplicar os dois valores do topo da pilha e empilhar o resultado.
    * / Dividir o valor no topo da pilha pelo próximo valor e empilhar o resultado.
    * % Calcular o módulo do valor no topo da pilha pelo próximo valor e empilhar o resultado.
    * ! Inverter o valor no topo da pilha (se for zero, empilhará 1; caso contrário, empilhará 0).
    * `: Obtem os dois valores do topo da pilha e executa a operação lógica segundo>primeiro colocando o resultado no topo da lista.
    * : Duplica o primeiro valor da pilha.
    * \\ Inverte a posição dos 2 primeiros valores da pilha.
    * $ remove o primeiro valor da pilha.
4. **Controle de fluxo**:
    * _ Obtem o primeiro valor da pilha, se for 0, move pra direita, caso contrario move para esquerda.
    * | Obtem o primeiro valor da pilha, se for 0, move para baixo, caso contrario move para cima.
