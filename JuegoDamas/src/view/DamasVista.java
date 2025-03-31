package view;
import controller.DamasControlador;
import model.DamasModelo;
import javax.swing.*;
import java.awt.*;

public class DamasVista extends JPanel {
    private final DamasModelo modelo;
    private final JButton[][] casillas = new JButton[8][8];
    private int filaSeleccionada = -1, colSeleccionada = -1;
    private DamasControlador controlador;

    public DamasVista(DamasModelo modelo) {
        this.modelo = modelo;
        setLayout(new GridLayout(8, 8));
        inicializarTablero();
    }

    public void setControlador(DamasControlador controlador) {
        this.controlador = controlador;
    }

    private void inicializarTablero() {
        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                JButton boton = new JButton();
                boton.setOpaque(true);
                boton.setBorderPainted(false);
                boton.setBackground((fila + col) % 2 == 0 ? Color.RED : Color.BLUE);
                int f = fila, c = col;
                boton.addActionListener(e -> manejarClick(f, c));
                casillas[fila][col] = boton;
                add(boton);
            }
        }
        actualizarVista();
    }

    private void manejarClick(int fila, int col) {
        if (filaSeleccionada == -1) {
            filaSeleccionada = fila;
            colSeleccionada = col;
        } else {
            if (controlador != null) {
                controlador.moverPieza(filaSeleccionada, colSeleccionada, fila, col);
            }
            filaSeleccionada = -1;
            colSeleccionada = -1;
        }
        actualizarVista();
    }

    ImageIcon blanca = new ImageIcon(getClass().getResource("/blanca.png"));
    ImageIcon negra = new ImageIcon(getClass().getResource("/negra.png"));


    public void actualizarVista() {
        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                JButton boton = casillas[fila][col];
                int pieza = modelo.getPieza(fila, col);

                boton.setIcon(null); // Limpia el icono anterior


                if (pieza == DamasModelo.PEON_BLANCO) {
                    boton.setIcon(blanca);
                } else if (pieza == DamasModelo.PEON_NEGRO) {
                    boton.setIcon(negra);
                }
            }
        }
    }
}
