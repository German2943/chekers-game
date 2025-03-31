import javax.swing.*;
import java.awt.*;

public class TableroDamas {
    private static final int TAMANO = 8;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tablero de Damas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        JPanel panel = new JPanel(new GridLayout(TAMANO, TAMANO));

        for (int fila = 0; fila < TAMANO; fila++) {
            for (int columna = 0; columna < TAMANO; columna++) {
                Casilla casilla = new Casilla(fila, columna);
                panel.add(casilla);
            }
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}

// Clase que representa cada casilla del tablero
class Casilla extends JPanel {
    private int fila, columna;
    private Color colorFicha;

    public Casilla(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;

        if ((fila + columna) % 2 == 0) {
            setBackground(Color.WHITE);
        } else {
            setBackground(Color.BLACK);

            // Colocar fichas en posiciones iniciales
            if (fila < 3) {
                colorFicha = Color.RED; // Fichas rojas en la parte superior
            } else if (fila > 4) {
                colorFicha = Color.BLUE; // Fichas azules en la parte inferior
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar ficha si hay una en esta casilla
        if (colorFicha != null) {
            g.setColor(colorFicha);
            int margen = 10;
            g.fillOval(margen, margen, getWidth() - 2 * margen, getHeight() - 2 * margen);
        }
    }
}
