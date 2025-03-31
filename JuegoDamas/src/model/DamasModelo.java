package model;

public class DamasModelo {
    private final int[][] tablero;
    public static final int VACIO = 0, PEON_BLANCO = 1, PEON_NEGRO = 2;

    public DamasModelo() {
        tablero = new int[8][8];
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                if ((fila + col) % 2 == 1) {
                    if (fila < 3) tablero[fila][col] = PEON_NEGRO;
                    else if (fila > 4) tablero[fila][col] = PEON_BLANCO;
                }
            }
        }
    }

    public int getPieza(int fila, int col) {
        return tablero[fila][col];
    }

    public void moverPieza(int filaOrigen, int colOrigen, int filaDestino, int colDestino) {
        tablero[filaDestino][colDestino] = tablero[filaOrigen][colOrigen];
        tablero[filaOrigen][colOrigen] = VACIO;
    }
}
