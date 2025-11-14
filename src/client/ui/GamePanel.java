package client.ui;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private GameFrame parent;

    private JPanel chatPanel;
    private JPanel centerBoard;
    private JPanel rightPanel;

    public GamePanel(GameFrame parent) {
        this.parent = parent;

        setLayout(null);  // 절대 배치
        setPreferredSize(new Dimension(1280, 720));

        // =============================
        // 1. 채팅 패널 (왼쪽 고정)
        // =============================
        chatPanel = new JPanel(new BorderLayout());
        chatPanel.setBounds(0, 0, 280, 720);
        chatPanel.setBackground(new Color(230, 230, 230));

        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setBackground(new Color(240,240,240));
        JScrollPane chatScroll = new JScrollPane(chatArea);

        JPanel chatInputPanel = new JPanel(new BorderLayout());
        JTextField chatInput = new JTextField();
        JButton sendBtn = new JButton("전송");

        chatInputPanel.add(chatInput, BorderLayout.CENTER);
        chatInputPanel.add(sendBtn, BorderLayout.EAST);
        chatInputPanel.setBackground(new Color(220,220,220));

        chatPanel.add(chatScroll, BorderLayout.CENTER);
        chatPanel.add(chatInputPanel, BorderLayout.SOUTH);
        add(chatPanel);

        // =============================
        // 2. 중앙 보드 영역 (플레이어 4명)
        // =============================
        centerBoard = new JPanel();
        centerBoard.setLayout(new GridLayout(4, 1));
        centerBoard.setBounds(280, 0, 740, 720);
        centerBoard.setBackground(new Color(240,240,240));

        for (int i = 0; i < 4; i++) {
            centerBoard.add(createPlayerRow(i));
        }
        add(centerBoard);

        // =============================
        // 3. 오른쪽 패널: 비밀의 돌 + 남은 돌
        // =============================
        rightPanel = new JPanel(null);
        rightPanel.setBackground(new Color(245,245,245));
        rightPanel.setBounds(1020, 0, 260, 720);

        JLabel remainLabel = new JLabel("남은 돌 : 12");
        remainLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        remainLabel.setBounds(40, 20, 200, 30);
        rightPanel.add(remainLabel);

        // =============================
        // 비밀의 돌 4개 — 2×2 배치
        // =============================
        int startX = 40;
        int startY = 80;
        int w = 80, h = 110;
        int gapX = 20;
        int gapY = 20;

        for (int i = 0; i < 4; i++) {
            JLabel stone = new JLabel();
            stone.setOpaque(true);
            stone.setBackground(new Color(90,90,90));

            int row = i / 2; // 0,0,1,1
            int col = i % 2; // 0,1,0,1

            int x = startX + (col * (w + gapX));
            int y = startY + (row * (h + gapY));

            stone.setBounds(x, y, w, h);
            rightPanel.add(stone);
        }

        add(rightPanel);
    }


    private JPanel createPlayerRow(int index) {
        JPanel row = new JPanel(null);
        row.setBackground(new Color(250,250,250));

        // 생명력 표시
        JLabel heartLabel = new JLabel("❤ 5");
        heartLabel.setFont(new Font("맑은 고딕", Font.BOLD, 26));
        heartLabel.setBounds(10, 20, 120, 40);
        row.add(heartLabel);

        // 마법의 돌 5개
        int startX = 140;
        for (int i = 0; i < 5; i++) {
            JLabel stone = new JLabel();
            stone.setOpaque(true);
            stone.setBackground(new Color(180,180,180));
            stone.setBounds(startX + (i * 110), 10, 100, 140);
            row.add(stone);
        }

        return row;
    }
}
