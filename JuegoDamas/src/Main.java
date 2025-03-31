import controller.DamasControlador;
import model.DamasModelo;
import view.DamasVista;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DamasModelo modelo = new DamasModelo();
            DamasVista vista = new DamasVista(modelo);
            new DamasControlador(modelo, vista);

            JFrame frame = new JFrame("Juego de Damas");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(vista);
            frame.setSize(600, 600);
            frame.setVisible(true);
        });
    }
}