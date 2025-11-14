package client.ui;

import javax.swing.*;
import java.awt.*;


import javax.swing.*;
import java.awt.*;


class LobbyPanel extends JPanel {
            private GameFrame parent;


    public LobbyPanel(GameFrame parent) {
                this.parent = parent;
                setLayout(new BorderLayout());


// Top title
        JLabel title = new JLabel("게임 로비", SwingConstants.CENTER);
        title.setFont(new Font("맑은고딕", Font.BOLD, 26));
        title.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        add(title, BorderLayout.NORTH);


// Center panel: room list styled to look like the screenshot
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBackground(new Color(90, 90, 90));
        center.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));


        for (int i = 0; i < 4; i++) {
                JPanel row = new JPanel(new BorderLayout());
                row.setMaximumSize(new Dimension(1000, 60));
                row.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
                row.setBackground(new Color(220, 220, 220));


            JLabel roomLabel = new JLabel("[" + (1000 + i*1000) + "] " + "예시 게임방");
            roomLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
            row.add(roomLabel, BorderLayout.WEST);


            JLabel count = new JLabel((i+1) + "/4", SwingConstants.CENTER);
            row.add(count, BorderLayout.CENTER);


            JButton enter = new RoundedButton("입장하기");
            enter.addActionListener(e -> parent.showRoom());
            row.add(enter, BorderLayout.EAST);


            center.add(row);
            center.add(Box.createRigidArea(new Dimension(0,8)));
        }


        add(center, BorderLayout.CENTER);


        JPanel bottom = new JPanel(new GridLayout(1,2));
        bottom.setPreferredSize(new Dimension(0, 70));


        RoundedButton create = new RoundedButton("새로운 방 만들기");
        create.addActionListener(e -> parent.showRoom());
        RoundedButton quick = new RoundedButton("빠른 시작");
        quick.addActionListener(e -> parent.showRoom());


        bottom.add(create);
        bottom.add(quick);
        add(bottom, BorderLayout.SOUTH);
    }
}