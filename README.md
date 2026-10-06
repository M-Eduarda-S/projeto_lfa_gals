# Projeto de Linguagens Formais e Autômatos - Interpretador GALS

## Descrição

Projeto desenvolvido para a disciplina de **Linguagens Formais e Autômatos**, com o objetivo de aplicar os conceitos de **Linguagens Livres de Contexto** sob a perspectiva de Compiladores.

O projeto consiste na implementação de uma linguagem de programação simples, utilizando o **GALS** (Gerador de Analisadores Léxicos e Sintáticos) para definir os **tokens** e a **gramática** da linguagem.

A partir do arquivo `interpretador.gals`, desenvolvido utilizando o **Web-GALS da UNIVALI**, foi gerado os arquivos em Java. Depois, foi criado o `Main.java` para executar o interpretador e o `Semantico.java` foi ajustado para realizar as operações e o armazenamento dos valores das variáveis.

A linguagem trabalha com **números binários inteiros sem sinal** e permite realizar operações matemáticas, atribuir valores a variáveis e exibir seus resultados.

## Disciplina:
Linguagens Formais e Autômatos

## Acadêmicas:
- Beatriz Pimentel Bagesteiro Alves
- Maria Eduarda Santos
- Yasmin Tarnovski Faccin

## Tecnologias

- Linguagem Java
- GALS / Web-GALS

## GALS
O arquivo interpretador.gals foi desenvolvido utilizando o **Web-GALS**, disponibilizado pela UNIVALI.

Web-GALS: https://lia-univali.github.io/Web-GALS/

O arquivo contém as definições dos **tokens** e da **gramática** da linguagem. A partir dele, foram **gerados os arquivos Java** utilizados no projeto.

## Requisitos de Execução

- Java JDK compatível com o projeto;
- Uma IDE ou ambiente com suporte à execução de projetos Java.

### Como executar

Abra o projeto em uma IDE, como **Apache NetBeans, IntelliJ IDEA ou Eclipse**, e execute a classe `Main`.

O programa solicita o código pelo terminal. Atualmente, o código deve ser informado em uma única linha.

Exemplo:

```text
A = 10; B = A + 11; Show(B);
```

Resultado:

```text
Resultado de B: 101 (decimal: 5)
Execução finalizada.
```

## Funcionamento

O projeto utiliza três etapas principais:

### Análise léxica

Realizada pela classe `Lexico`, responsável por identificar os tokens da linguagem, como números binários, operadores, variáveis e comandos.

### Análise sintática

Realizada pela classe `Sintatico`, que verifica se o código segue a gramática definida no arquivo `interpretador.gals`.

### Análise semântica

Realizada pela classe `Semantico`, responsável por executar as operações, armazenar os valores das variáveis e exibir os resultados.

As operações disponíveis são:

- Atribuição: `=`
- Soma: `+`
- Subtração: `-`
- Multiplicação: `*`
- Divisão: `/`
- Exponenciação: `^`
- Logaritmo na base 2: `log`
- Exibição: `Show`

## Exemplo da linguagem

```text
A = 10;
B = 11;
B = 111 + A * B;
Show(B);
```

Os valores são informados em **binário**, mas o resultado também é apresentado em decimal.

## Estrutura

```text
src/
└── gals/
    ├── AnalysysError.java
    ├── Constants.java
    ├── LexicalError.java
    ├── Lexico.java
    ├── Main.java
    ├── ParserConstants.java
    ├── ScannerConstants.java
    ├── SemanticError.java
    ├── Semantico.java
    ├── Sintatico.java
    ├── SyntaticError.java
    └── Token.java

README.md
interpretador.gals
```

## Observações
- Os números utilizados pela linguagem são binários e formados apenas por `0` e `1`.
- As variáveis precisam ser atribuídas antes de serem utilizadas.
- O `log` utiliza base 2.
- O resultado do `Show` é exibido em binário e decimal.
- O projeto foi desenvolvido para **fins didáticos** na disciplina de Linguagens Formais e Autômatos.
