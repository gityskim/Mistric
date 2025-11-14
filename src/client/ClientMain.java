package client;

import client.ui.GameFrame;

import javax.swing.SwingUtilities;


public class ClientMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameFrame frame = new GameFrame();
            frame.setVisible(true);
        });
    }
}