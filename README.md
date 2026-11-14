# Chess System Java

![Java](https://img.shields.io/badge/java_8-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![NetBeans](https://img.shields.io/badge/netbeans_8.1-%231B6AC6.svg?style=for-the-badge&logo=apachenetbeanside&logoColor=white)
![Console](https://img.shields.io/badge/interface-console-%234EAA25.svg?style=for-the-badge&logo=gnubash&logoColor=white)

## Sobre o projeto

Chess System Java é um jogo de xadrez para dois jogadores que roda no terminal, escrito em Java puro, sem frameworks e sem dependências.

Foi construído como o projeto bônus da **Seção 23** (Sistema jogo de xadrez) do curso [Java COMPLETO Programação Orientada a Objetos + Projetos](https://www.udemy.com/course/java-curso-completo/ "Curso na Udemy"), do professor [Nélio Alves](https://github.com/acenelio "GitHub do Nélio Alves"). O objetivo do projeto é praticar orientação a objetos: herança, polimorfismo, tratamento de exceções e separação em camadas. O desenvolvimento aconteceu entre setembro de 2019 e fevereiro de 2020, e o histórico de commits mostra a evolução, uma funcionalidade por vez.

## O que o jogo faz

- Tabuleiro 8x8 com todas as peças na posição inicial (rei, dama, torres, bispos, cavalos e peões).
- Movimento de cada peça com as regras de captura.
- Destaque, no tabuleiro, das casas para onde a peça escolhida pode ir.
- Alternância de turnos entre brancas e pretas e lista de peças capturadas.
- **Xeque** e **xeque-mate**, impedindo jogadas que deixem o próprio rei em xeque.
- Jogadas especiais: **roque** (pequeno e grande), **en passant** e **promoção do peão**.

## Telas

Partida do "mate do louco" (4 lances), como aparece no terminal:

```
8 R N B - K B N R
7 P P P P - P P P
6 - - - - - - - -
5 - - - - P - - -
4 - - - - - - P Q
3 - - - - - P - -
2 P P P P P - - P
1 R N B Q K B N R
  a b c d e f g h

Turn : 4
CHECKMATE!
Winner: BLACK
```

No terminal, as peças brancas aparecem em branco, as pretas em amarelo, e as casas possíveis de movimento ganham fundo azul.

## Tecnologias utilizadas

- Java 8 (funciona também em versões mais novas)
- Programação orientada a objetos
- NetBeans 8.1
- Git
- Cores ANSI para a impressão do tabuleiro no terminal

## Estrutura do código

O código é dividido em três camadas, e cada uma só conhece a de baixo:

```
src/
├── application/   # Interface com o usuário: leitura do teclado e impressão do tabuleiro
├── chess/         # Regras do xadrez: partida, xeque, jogadas especiais
│   └── pieces/    # Uma classe por peça (King, Queen, Rook, Bishop, Knight, Pawn)
└── boardgame/     # Camada genérica de jogo de tabuleiro (Board, Piece, Position)
```

A camada `boardgame` não sabe nada de xadrez, só entende posições e peças. Por isso as regras ficam todas em `chess`, e a interface não mexe diretamente no tabuleiro.

## Como executar o projeto

Pré-requisito: JDK 8 ou superior.

```bash
# clonar repositório
git clone https://github.com/santosediego/chess-system-java.git

# entrar na pasta do projeto
cd chess-system-java

# compilar (Linux, macOS ou Git Bash)
mkdir out
javac -encoding UTF-8 -d out $(find src -name '*.java')

# no PowerShell, compile com:
# javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src -Filter *.java).FullName

# executar
java -cp out application.Program
```

O projeto também abre direto no NetBeans, e a classe principal é `application.Program`.

### Como jogar

1. Digite a posição da peça que quer mover (`Source`), por exemplo `e2`.
2. O tabuleiro mostra as casas possíveis. Digite o destino (`Target`), por exemplo `e4`.
3. As posições vão de `a1` a `h8`, e as brancas começam.
4. Na promoção do peão, escolha a nova peça: `B` (bispo), `N` (cavalo), `R` (torre) ou `Q` (dama).

## Limitações conhecidas

- Não detecta empate (afogamento, repetição de posição, regra dos 50 lances e material insuficiente). Se a partida travar sem xeque-mate, é preciso encerrar com `Ctrl+C`.
- Só roda no console, com dois jogadores no mesmo terminal. Não há computador como adversário nem como salvar a partida.
- Usa cores ANSI. Em terminais sem suporte (como o `cmd` antigo do Windows) aparecem caracteres estranhos; no Windows Terminal, no PowerShell recente ou no Git Bash funciona normalmente.
- Mensagens da interface em inglês, como no curso.

## Aluno

[Diego Santos](https://www.linkedin.com/in/santosediego/ "Perfil Linkedin Diego Santos")
