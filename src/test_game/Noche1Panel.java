package test_game;

import javax.swing.*;
import java.awt.*;

public class Noche1Panel extends JPanel {
    private JButton botonVolver;

    public Noche1Panel(Juego juego) {
        setLayout(new BorderLayout());

        JLabel textoNoche1 = new JLabel("¡Noche 1 - FNAF!", JLabel.CENTER);
        textoNoche1.setFont(new Font("Serif", Font.PLAIN, 30));
        add(textoNoche1, BorderLayout.CENTER);

        // Botón para volver al menú
        botonVolver = new JButton("Volver al Menú");
        botonVolver.addActionListener(e -> juego.volverAlMenu());
        add(botonVolver, BorderLayout.SOUTH);
    }
}
