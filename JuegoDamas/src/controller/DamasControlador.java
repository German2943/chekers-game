package controller;

import model.DamasModelo;
import view.DamasVista;

public class DamasControlador {
    private final DamasModelo modelo;
    private final DamasVista vista;

    public DamasControlador(DamasModelo modelo, DamasVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setControlador(this);
    }

    public void moverPieza(int filaOrigen, int colOrigen, int filaDestino, int colDestino) {
        modelo.moverPieza(filaOrigen, colOrigen, filaDestino, colDestino);
        vista.actualizarVista();
    }
}
