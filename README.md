# INF1636-LudoGame

## TODO list:

Ao lançar o dado checkar se:

- [x]  é 5. Se for ativar a Regra de saída (quando o dado for 5 pode tirar uma peça da casa inicial, Aquele hub de cada cor)
- [ ]  Se as outras pecas do jogador podem se mexer.
- [ ]  Se um mesmo jogador jogar 6 ele joga de novo. Se ele jogar 6 3 vezes seguidas a última peça que ele mexeu volta para o hub
- [ ]  Se ele tiver uma peça em uma barreira e jogar 6 ele é obrigado a tirar a barreira (se ele puder se mexer até lá, já tem função para isso)

Coisas separadas:

Jogador:
- [ ]  Se todas as peças do jogador estão na final
- [ ]  Se comer uma peça inimiga avançar qualquer peça do jogador em 6
- [ ]  Se chegar na casa final avançar qualquer peca em 6

Casa:
- [ ]  Duas peças de cores distintas não podem estar na casa de saída de uma terceira cor
- [x]  Somar a distância de cada a peca dos jogadores ao final para saber a colocação do resto

Peça:
- [x]  Checkagem se a peça pode se mexer para a casa final (a do meio) quando estiver na reta final
