# INF1636-LudoGame

## TODO list:

### Jogador:
- [x] O jogador inicia o jogo com uma peça na casa de saída *Testar*
- [ ] Se todas as peças do jogador estão na final, ele ganha
- [ ] Se tirar 6 no dado, movimenta o peão e joga novamente
- [x] Se tirar 6 três vezes seguidas, o último peão movimentado volta pro início *Testar*
- [ ] Se tirar 6 e tiver uma barreira, é obrigado a mexer um de seus peões da barreira
- [ ] Se comer uma peça inimiga, avançar qualquer peça do jogador em 6
- [ ] Se chegar na casa final, avançar qualquer peça em 6
- [x] Se tirar 5, o jogador pode escolher um peão para sair da casa *Testar*
- [ ] Se tiver um peão seu na casa de saída, não pode sair com outro para não formar uma barreira, pois é proibido

### Casa:
- [ ] Barreira: Dois peões de uma mesma cor podem estar numa casa comum *Parcial*
- [ ] Abrigo: Dois peões de cores distintas podem estar numa casa de abrigo *Parcial*
- [ ] Partida: Dois peões de cores distintas podem estar numa casa de saída, desde que um deles seja da cor da casa
- [x] Somar a distância de cada a peça dos jogadores ao final para saber a colocação do resto

### Peça:
- [x] Se o dado é 5 ativar a Regra de saída (quando o dado for 5 pode tirar uma peça da casa inicial, Aquele hub de cada cor)
- [x] Se o jogador tirar um número igual a quantidade de casas restantes para o final, ele termina o jogo 
- [x] Peça não pode passar por uma barreira
- [ ] Se uma peça cair em uma casa comum ou casa inicial e encontrar uma peça de outra cor, a peça inimiga volta para casa inicial *PARCIAL*
