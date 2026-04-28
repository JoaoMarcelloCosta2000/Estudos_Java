package xadrez.aplication;

import java.util.Scanner;

import xadrez.entities.Bispo;
import xadrez.entities.Cavalo;
import xadrez.entities.Dama;
import xadrez.entities.Peao;
import xadrez.entities.Peca;
import xadrez.entities.Rei;
import xadrez.entities.Torre;
import xadrez.enums.Cores;

public class App {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);

        Peca [][] tabuleiro = null;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (i == 0) {
                    switch (j) {
                        case 0:
                        case 7:
                            tabuleiro[i][j] = new Torre(Cores.BRANCO, i, j);
                            break;
                        case 1:
                        case 6:
                            tabuleiro[i][j] = new Cavalo(Cores.BRANCO, i, j);
                            break;
                        case 2:
                        case 5:
                            tabuleiro[i][j] = new Bispo(Cores.BRANCO, i, j);
                            break;
                        case 3:
                            tabuleiro[i][j] = new Dama(Cores.BRANCO, i, j);
                            break;
                        case 4:
                            tabuleiro[i][j] = new Rei(Cores.BRANCO, i, j);
                            break;
                    }
                }

                else if (i == 1) {
                    tabuleiro[i][j] = new Peao(Cores.BRANCO, i, j,0);
                }

                else if (i == 6) {
                    tabuleiro[i][j] = new Peao(Cores.PRETO, i, j,0);
                }

                else if (i == 7) {
                    switch (j) {
                        case 0:
                        case 7:
                            tabuleiro[i][j] = new Torre(Cores.PRETO, i, j);
                            break;
                        case 1:
                        case 6:
                            tabuleiro[i][j] = new Cavalo(Cores.PRETO, i, j);
                            break;
                        case 2:
                        case 5:
                            tabuleiro[i][j] = new Bispo(Cores.PRETO, i, j);
                            break;
                        case 3:
                            tabuleiro[i][j] = new Dama(Cores.PRETO, i, j);
                            break;
                        case 4:
                            tabuleiro[i][j] = new Rei(Cores.PRETO, i, j);
                            break;
                    }
                }

                else {
                    tabuleiro[i][j] = null;
                }
            }
        }

    }
}
