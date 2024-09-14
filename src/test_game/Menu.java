package test_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class Menu {
    private JFrame ventana;
    private JPanel panelMenu;
    private JLabel labelFondo;
    private ArrayList<ImageIcon> animFrames = new ArrayList<>();
    private Timer animacionTimer;
    private int frameActual = 0;

    private JButton botonNuevoJuego;
    private JButton botonContinuar;
    private JButton botonConfiguracion;
    private JButton botonSalir;

    public Menu(JFrame ventana) {
        this.ventana = ventana;
    }

    public void iniciar() {
        ventana.setSize(1280, 720);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(null);

        // Configurar fondo animado
        labelFondo = new JLabel();
        labelFondo.setBounds(0, 0, 1280, 720);
        cargarAnimaciones("src/assets/animaciones");
        labelFondo.setIcon(animFrames.get(0));
        ventana.add(labelFondo);

        // Configurar el panel del menú
        panelMenu = new JPanel();
        panelMenu.setBounds(0, 0, 1280, 720);
        panelMenu.setLayout(null);
        panelMenu.setOpaque(false);

        // Inicializar los botones
        botonNuevoJuego = crearBotonConSprites("src/assets/botones/nuevoJuego.png", 540, 100);
        botonContinuar = crearBotonConSprites("src/assets/botones/continuar.png", 540, 160);
        botonConfiguracion = crearBotonConSprites("src/assets/botones/configuracion.png", 540, 220);
        botonSalir = crearBotonConSprites("src/assets/botones/salir.png", 540, 280);

        // Añadir funcionalidad a los botones
        botonSalir.addActionListener(e -> System.exit(0));
        botonNuevoJuego.addActionListener(e -> new Noche1(ventana).iniciar()); // Cambio de pantalla
        botonConfiguracion.addActionListener(e -> mostrarPantallaConfiguracion());

        panelMenu.add(botonNuevoJuego);
        panelMenu.add(botonContinuar);
        panelMenu.add(botonConfiguracion);
        panelMenu.add(botonSalir);

        ventana.add(panelMenu);
        iniciarAnimacion();
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

    private void cargarAnimaciones(String rutaCarpeta) {
        File carpeta = new File(rutaCarpeta);
        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles((dir, name) -> name.endsWith(".png"));
            if (archivos != null) {
                for (File archivo : archivos) {
                    animFrames.add(new ImageIcon(archivo.getPath()));
                }
            }
        }
    }

    private void iniciarAnimacion() {
        animacionTimer = new Timer(100, e -> {
            frameActual = (frameActual + 1) % animFrames.size();
            labelFondo.setIcon(animFrames.get(frameActual));
        });
        animacionTimer.start();
    }

    private void mostrarPantallaConfiguracion() {
        ventana.getContentPane().removeAll();
        ventana.repaint();

        JPanel panelConfiguracion = new JPanel();
        panelConfiguracion.setLayout(null);

        JLabel labelTitulo = new JLabel("Configuración", JLabel.CENTER);
        labelTitulo.setBounds(540, 50, 200, 50);
        labelTitulo.setFont(new Font("Serif", Font.PLAIN, 30));
        panelConfiguracion.add(labelTitulo);

        JButton botonFullscreen = new JButton("Pantalla Completa");
        botonFullscreen.setBounds(540, 150, 200, 50);
        panelConfiguracion.add(botonFullscreen);

        botonFullscreen.addActionListener(e -> toggleFullScreen());

        JButton botonVolver = new JButton("Volver al Menú");
        botonVolver.setBounds(540, 220, 200, 50);
        panelConfiguracion.add(botonVolver);

        botonVolver.addActionListener(e -> volverAlMenu());

        ventana.add(panelConfiguracion);
        ventana.revalidate();
    }

    private void toggleFullScreen() {
        if (ventana.isUndecorated()) {
            ventana.dispose();
            ventana.setUndecorated(false);
            ventana.setSize(1280, 720);
            ventana.setVisible(true);
        } else {
            ventana.dispose();
            ventana.setUndecorated(true);
            ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
            ventana.setVisible(true);
        }
    }

    private void volverAlMenu() {
        ventana.getContentPane().removeAll();
        ventana.repaint();
        ventana.add(labelFondo);
        ventana.add(panelMenu);
        ventana.revalidate();
    }
}
