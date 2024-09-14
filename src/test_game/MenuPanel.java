package test_game;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private JButton botonNuevoJuego;
    private JButton botonSalir;
    private JButton botonConfiguracion;

    public MenuPanel(Juego juego) {
        setLayout(null); // Layout manual para manejar la posición
        setOpaque(false); // Fondo transparente

        // Botón para comenzar el juego
        botonNuevoJuego = crearBotonConSprites("src/assets/botones/nuevoJuego.png", 540, 100);
        botonNuevoJuego.addActionListener(e -> juego.mostrarNoche1());
        add(botonNuevoJuego);

        // Botón para salir
        botonSalir = crearBotonConSprites("src/assets/botones/salir.png", 540, 160);
        botonSalir.addActionListener(e -> System.exit(0));
        add(botonSalir);

        // Botón de configuración
        botonConfiguracion = crearBotonConSprites("src/assets/botones/configuracion.png", 540, 220);
        botonConfiguracion.addActionListener(e -> mostrarConfiguracion());
        add(botonConfiguracion);
    }

    private JButton crearBotonConSprites(String rutaNormal, int x, int y) {
        JButton boton = new JButton();
        boton.setBounds(x, y, 200, 50);
        boton.setIcon(new ImageIcon(rutaNormal));
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(false);
        boton.setFocusPainted(false);
        return boton;
    }

    private void mostrarConfiguracion() {
        // Crear un dialogo de configuración
        JDialog configuracionDialog = new JDialog();
        configuracionDialog.setTitle("Configuración");
        configuracionDialog.setSize(400, 300);
        configuracionDialog.setLocationRelativeTo(this);
        
        JPanel panelConfiguracion = new JPanel();
        panelConfiguracion.setLayout(new GridLayout(3, 1));

        JLabel textoConfig = new JLabel("Configuraciones del juego", JLabel.CENTER);
        panelConfiguracion.add(textoConfig);

        // Otras configuraciones se pueden agregar aquí

        JButton botonCerrar = new JButton("Cerrar");
        botonCerrar.addActionListener(e -> configuracionDialog.dispose());
        panelConfiguracion.add(botonCerrar);

        configuracionDialog.add(panelConfiguracion);
        configuracionDialog.setVisible(true);
    }
}
