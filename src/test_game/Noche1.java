package test_game;

import javax.swing.*;
import java.awt.*;

public class Noche1 {
    private JFrame ventana;

    public Noche1(JFrame ventana) {
        this.ventana = ventana;
    }

    public void iniciar() {
        ventana.getContentPane().removeAll();
        ventana.repaint();

        JPanel panelJuego = new JPanel();
        JLabel textoJuego = new JLabel("¡Comienza la Noche 1!", JLabel.CENTER);
        textoJuego.setFont(new Font("Serif", Font.PLAIN, 30));
        panelJuego.setLayout(new BorderLayout());
        panelJuego.add(textoJuego, BorderLayout.CENTER);

        ventana.add(panelJuego);
        ventana.revalidate();
    }
}
