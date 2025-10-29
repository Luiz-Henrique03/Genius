# Projeto Genius Game (Android)
Este é um clone simples do clássico jogo de memória "Genius" (conhecido como "Simon" em inglês), desenvolvido nativamente para Android usando Kotlin. O objetivo do jogador é memorizar e repetir a sequência de cores apresentada, que se torna progressivamente mais longa a cada rodada.

# 🕹️ Funcionalidades
O aplicativo é composto por três telas principais:

- Tela de Início (MainActivity)

Permite ao usuário definir quantas rodadas deseja jogar para vencer.
Se nenhum valor for inserido, o jogo assume um padrão (5 rodadas, conforme sua última modificação).

- Tela de Jogo (Genius)

Exibe os quatro botões coloridos (Vermelho, Verde, Azul, Amarelo).
Mostra um contador de rodadas atual (txtRound).
Gera uma sequência aleatória de cores.
Reproduz a sequência para o jogador, "piscando" os botões correspondentes.
Aguarda a entrada do jogador e verifica se a sequência está correta em tempo real.
Se o jogador errar, ele é enviado para a tela de resultado (derrota).
Se o jogador acertar a sequência e atingir o número de rodadas definido, ele é enviado para a tela de resultado (vitória).

- Tela de Resultado (ResultActivity)
Exibe uma mensagem de "🎉 Você venceu! 🎉" ou "😢 Você perdeu!".
Muda a cor do texto para verde (vitória) ou vermelho (derrota).
Oferece um botão "Jogar novamente" que reinicia o jogo, levando o usuário de volta à Genius Activity.

<img width="383" height="859" alt="image" src="https://github.com/user-attachments/assets/7a585e1c-8c7b-4a98-babb-1640fc9abd0e" />
