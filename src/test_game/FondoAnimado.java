package test_game;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class FondoAnimado extends JPanel {
    private ArrayList<ImageIcon> animFrames = new ArrayList<>();
    private int frameActual = 0;
    private Timer animacionTimer;

    public FondoAnimado() {
        cargarAnimaciones("src/assets/animaciones");
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

    public void iniciarAnimacion() {
        animacionTimer = new Timer(100, e -> {
            frameActual = (frameActual + 1) % animFrames.size();
            repaint(); // Repintar el panel para mostrar el siguiente frame
        });
        animacionTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!animFrames.isEmpty()) {
            ImageIcon frame = animFrames.get(frameActual);
            g.drawImage(frame.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    }
}
