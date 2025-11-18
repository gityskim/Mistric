package client.ui;

import common.GameMsg;

import javax.swing.*;
import java.awt.*;

class RoomPanel extends JPanel {
    private GameFrame parent;

    private JPanel centerPanel;

    public RoomPanel(GameFrame parent) {
        this.parent = parent;

        setLayout(null);
        setBackground(new Color(240,240,240));

        ChattingPanel chat = new ChattingPanel();
        chat.setBounds(20, 20, 260, 600);
        add(chat);
        // 방 채팅까지 서버와 묶으려면 여기서도 setSendListener 써서 GameMsg.CHAT 전송하면 됨.

        centerPanel = new JPanel(null);
        centerPanel.setBounds(310, 20, 920, 600);
        centerPanel.setBackground(new Color(230,230,230));
        centerPanel.setBorder(BorderFactory.createLineBorder(new Color(200,200,200), 2));
        add(centerPanel);

        // 처음 들어갔을 땐 빈 상태여도 OK. (서버에서 ROOM_UPDATE 오면 updatePlayers로 그림)

        JButton startBtn = new RoundedButton("게임 시작");
        startBtn.setBounds(440, 630, 200, 40);
        startBtn.addActionListener(e -> {
            GameMsg msg = new GameMsg(GameMsg.GAME_START, parent.getNick(), null);
            parent.getNetwork().send(msg);
        });
        add(startBtn);

        JButton backBtn = new RoundedButton("로비로 나가기");
        backBtn.setBounds(660, 630, 200, 40);
        // 네트워크 상 ROOM_LEAVE를 아직 안 만들었다면, 일단 UI만 로비로 보내기
        backBtn.addActionListener(e -> parent.showLobby());
        add(backBtn);
    }

    public void updatePlayers(String[] players) {
        centerPanel.removeAll();

        int boxW = 420, boxH = 260;
        int[][] pos = {
                {30,  30},
                {470, 30},
                {30,  320},
                {470, 320}
        };

        for (int i = 0; i < players.length && i < 4; i++) {
            PlayerPanel p = new PlayerPanel(players[i], i == 0);
            p.setBounds(pos[i][0], pos[i][1], boxW, boxH);
            centerPanel.add(p);
        }

        centerPanel.revalidate();
        centerPanel.repaint();
    }
}
