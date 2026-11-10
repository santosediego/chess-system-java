# Chess System Java

![Java](https://img.shields.io/badge/Java-8%2B-orange)
![Interface](https://img.shields.io/badge/Interface-Console-lightgrey)
![Tipo](https://img.shields.io/badge/Tipo-Projeto%20de%20estudo-blue)

Jogo de xadrez para dois jogadores que roda no terminal, escrito em Java puro (sem frameworks e sem dependências). Foi feito como projeto de estudo de orientação a objetos durante o curso de Java do professor Nélio Alves, entre setembro de 2019 e fevereiro de 2020.

## O que o jogo faz

- Tabuleiro 8x8 com todas as peças em posição inicial (rei, dama, torres, bispos, cavalos e peões).
- Movimento de cada peça com as regras de captura.
- Destaque, no tabuleiro, das casas para onde a peça escolhida pode ir.
- Alternância de turnos entre brancas e pretas e lista de peças capturadas.
- **Xeque** e **xeque-mate**, impedindo jogadas que deixem o próprio rei em xeque.
- Jogadas especiais: **roque** (pequeno e grande), **en passant** e **promoção do peão**.

## Exemplo

Partida do "mate do louco" (4 lances), com o tabuleiro no terminal:

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

No terminal as peças brancas aparecem em branco, as pretas em amarelo, e as casas possíveis de movimento ganham fundo azul.

## Como executar

Requisito: JDK 8 ou superior.

```bash
git clone https://github.com/santosediego/chess-system-java.git
cd chess-system-java
mkdir out

# Linux, macOS ou Git Bash
javac -encoding UTF-8 -d out $(find src -name '*.java')

# PowerShell
# javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src -Filter *.java).FullName

java -cp out application.Program
```

Também abre direto no NetBeans (o projeto foi criado nele). A classe principal é `application.Program`.

## Como jogar

1. Digite a posição da peça que quer mover (`Source`), por exemplo `e2`.
2. O tabuleiro mostra as casas possíveis. Digite o destino (`Target`), por exemplo `e4`.
3. As posições vão de `a1` a `h8`. As brancas começam.
4. Na promoção do peão, escolha a nova peça: `B` (bispo), `N` (cavalo), `R` (torre) ou `Q` (dama).

## Estrutura

O código é dividido em três camadas, cada uma só conhece a de baixo:

```
src/
├── application/   # Interface com o usuário: leitura do teclado e impressão do tabuleiro
├── chess/         # Regras do xadrez: partida, xeque, jogadas especiais
│   └── pieces/    # Uma classe por peça (King, Queen, Rook, Bishop, Knight, Pawn)
└── boardgame/     # Camada genérica de jogo de tabuleiro (Board, Piece, Position)
```

A camada `boardgame` não sabe nada de xadrez: ela só entende posições e peças. Assim, as regras ficam todas em `chess`, e a interface não mexe diretamente no tabuleiro.

## Limitações conhecidas

- Não detecta empate (afogamento, repetição de posição, regra dos 50 lances e material insuficiente). Se a partida travar sem xeque-mate, é preciso encerrar com `Ctrl+C`.
- Só roda no console, com dois jogadores no mesmo terminal. Não há computador como adversário nem como salvar a partida.
- Usa cores ANSI. Em terminais sem suporte (como o `cmd` antigo do Windows) aparecem caracteres estranhos; no Windows Terminal, PowerShell recente ou Git Bash funciona normalmente.
- Mensagens da interface em inglês, como no curso.

## Créditos

Projeto desenvolvido durante o curso de Java do professor Nélio Alves na Udemy, seguindo a modelagem e a arquitetura em camadas das aulas. O histórico de commits mostra a evolução, uma funcionalidade por commit.
