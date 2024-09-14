package test_game;

import javax.swing.*;

public class Juego {
    private JFrame ventana;
    private FondoAnimado fondoAnimado;
    private MenuPanel menuPanel;
    private Noche1Panel noche1Panel;
    private JLayeredPane layeredPane;

    public void start() {
        ventana = new JFrame("FNAF Java Game");
        ventana.setSize(1280, 720);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);

        // Crear un JLayeredPane para manejar capas (background, menú, etc.)
        layeredPane = new JLayeredPane();
        layeredPane.setSize(1280, 720);
        ventana.setContentPane(layeredPane);

        // Inicializar el fondo animado
        fondoAnimado = new FondoAnimado();
        fondoAnimado.setBounds(0, 0, 1280, 720);
        layeredPane.add(fondoAnimado, JLayeredPane.DEFAULT_LAYER); // Fondo en la capa más baja

        // Inicializar el menú y agregarlo a la ventana
        menuPanel = new MenuPanel(this);
        menuPanel.setBounds(0, 0, 1280, 720);
        layeredPane.add(menuPanel, JLayeredPane.PALETTE_LAYER); // Menú en una capa superior

        ventana.setVisible(true);
        fondoAnimado.iniciarAnimacion(); // Iniciar la animación del fondo
    }

    public void mostrarNoche1() {
        layeredPane.remove(menuPanel);
        noche1Panel = new Noche1Panel(this);
        noche1Panel.setBounds(0, 0, 1280, 720);
        layeredPane.add(noche1Panel, JLayeredPane.PALETTE_LAYER);
        layeredPane.revalidate();
        layeredPane.repaint();
    }

    public void volverAlMenu() {
        layeredPane.remove(noche1Panel);
        layeredPane.add(menuPanel, JLayeredPane.PALETTE_LAYER);
        layeredPane.revalidate();
        layeredPane.repaint();
    }
}
