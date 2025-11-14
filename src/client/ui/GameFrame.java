package client.ui;

import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel container = new JPanel(cardLayout);


    private ConnectPanel connectPanel;
    private LobbyPanel lobbyPanel;
    private RoomPanel roomPanel;
    private GamePanel gamePanel;


    public GameFrame() {
        setTitle("아브라카왓 멀티 - UI Prototype");
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); // fixed size per requirement


        connectPanel = new ConnectPanel(this);
        lobbyPanel = new LobbyPanel(this);
        roomPanel = new RoomPanel(this);
        gamePanel = new GamePanel(this);


        container.add(connectPanel, "CONNECT");
        container.add(lobbyPanel, "LOBBY");
        container.add(roomPanel, "ROOM");
        container.add(gamePanel, "GAME");


        add(container);
        showConnect();
    }


    public void showConnect() { cardLayout.show(container, "CONNECT"); }
    public void showLobby() { cardLayout.show(container, "LOBBY"); }
    public void showRoom() { cardLayout.show(container, "ROOM"); }
    public void showGame() { cardLayout.show(container, "GAME"); }
}
