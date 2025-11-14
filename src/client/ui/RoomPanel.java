package client.ui;

import javax.swing.*;
import java.awt.*;


class RoomPanel extends JPanel {
    private GameFrame parent;


    public RoomPanel(GameFrame parent) {
        this.parent = parent;
        setLayout(new BorderLayout());


// Left: chat area
        JPanel chatingPanel = new ChattingPanel();
        add(chatingPanel, BorderLayout.WEST);


// Center: 2x2 player boxes
        JPanel center = new JPanel(new GridLayout(2,2,16,16));
        center.setBorder(BorderFactory.createEmptyBorder(24,24,24,24));
        center.setBackground(new Color(240,240,240));


        for (int i = 1; i <= 4; i++) {
            PlayerPanel p = new PlayerPanel("플레이어 " + i, i==1);
            center.add(p);
        }


        add(center, BorderLayout.CENTER);


        JPanel bottom = new JPanel();
        RoundedButton start = new RoundedButton("게임 시작");
        start.addActionListener(e -> parent.showGame());
        bottom.add(start);
        add(bottom, BorderLayout.SOUTH);
    }
}