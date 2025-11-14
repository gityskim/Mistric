package client.ui;

import javax.swing.*;
import java.awt.*;

class LobbyPanel extends JPanel {

    private GameFrame parent;

    public LobbyPanel(GameFrame parent) {
        this.parent = parent;

        setLayout(null);
        setBackground(new Color(230, 230, 230));

        // ==========================
        // 1) 타이틀
        // ==========================
        JLabel title = new JLabel("게임 로비", SwingConstants.CENTER);
        title.setFont(new Font("맑은고딕", Font.BOLD, 32));
        title.setBounds(0, 20, 1280, 50);
        add(title);

        // ==========================
        // 2) 방 리스트 패널
        // ==========================
        int startY = 100;

        for (int i = 0; i < 4; i++) {

            JPanel row = new JPanel(null);
            row.setBackground(new Color(250, 250, 250));
            row.setBounds(140, startY + i * 80, 1000, 70);
            row.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 2));
            add(row);

            // 방 번호 + 방 이름
            JLabel roomLabel = new JLabel("[" + (1000 + i * 1000) + "] 예시 게임방");
            roomLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
            roomLabel.setBounds(20, 20, 350, 30);
            row.add(roomLabel);

            // 인원 수
            JLabel count = new JLabel((i + 1) + "/4", SwingConstants.CENTER);
            count.setFont(new Font("맑은 고딕", Font.BOLD, 20));
            count.setBounds(450, 20, 100, 30);
            row.add(count);

            // 입장 버튼
            JButton enter = new RoundedButton("입장하기");
            enter.setBounds(800, 15, 150, 40);
            enter.addActionListener(e -> parent.showRoom());
            row.add(enter);
        }

        // ==========================
        // 3) 하단 두 개 버튼
        // ==========================
        JButton createBtn = new RoundedButton("새로운 방 만들기");
        createBtn.setBounds(350, 460, 250, 50);
        createBtn.addActionListener(e -> parent.showRoom());
        add(createBtn);

        JButton quickBtn = new RoundedButton("빠른 시작");
        quickBtn.setBounds(680, 460, 250, 50);
        quickBtn.addActionListener(e -> parent.showRoom());
        add(quickBtn);
    }
}
