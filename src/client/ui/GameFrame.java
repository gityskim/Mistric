package client.ui;

import client.network.ClientNetwork;
import common.GameMsg;

import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel container = new JPanel(cardLayout);


    private ConnectPanel connectPanel;
    private LobbyPanel lobbyPanel;
    private RoomPanel roomPanel;
    private GamePanel gamePanel;

    private ClientNetwork clientNetwork;

    public GameFrame() {
        setTitle("아브라카왓 멀티 - UI Prototype");
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); // fixed size per requirement
        clientNetwork = new ClientNetwork(this);

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
    /*
    // 로비 방 리스트 갱신
    public void updateLobbyRoomList(GameMsg msg) {
        if (msg.text != null) {
            String[] rooms = msg.text.split("\\|");
            lobbyPanel.updateRooms(rooms);
        }
    }

    // 방 내부 플레이어 목록 갱신
    public void updateRoomPlayers(GameMsg msg) {
        String[] players = msg.text.split("\\|");
        roomPanel.updatePlayers(players);
    }

    // 채팅 메시지 반영
    public void updateChat(GameMsg msg) {
        String line = msg.user + ": " + msg.text;
        gamePanel.addChat(line);
    }

    // 게임 상태 전체 갱신
    public void updateGameState(GameMsg msg) {
        gamePanel.updateBoard(msg); // 여기서 msg.hp, msg.stones 사용
    }
*/

    public void showConnect() { cardLayout.show(container, "CONNECT"); }
    public void showLobby() { cardLayout.show(container, "LOBBY"); }
    public void showRoom() { cardLayout.show(container, "ROOM"); }
    public void showGame() { cardLayout.show(container, "GAME"); }
}
