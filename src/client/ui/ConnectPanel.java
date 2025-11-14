package client.ui;

import javax.swing.*;
import java.awt.*;


class ConnectPanel extends JPanel {
    private GameFrame parent;
    JTextField ipField, portField, nickField;
    JButton connectBtn, quickBtn;


    public ConnectPanel(GameFrame parent) {
        this.parent = parent;
        setLayout(new GridBagLayout());
        setBackground(new Color(230, 230, 230));


        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(8, 8, 8, 8);
        c.fill = GridBagConstraints.HORIZONTAL;


        JLabel title = new JLabel("아브라카왓 - 서버 접속");
        title.setFont(new Font("맑은고딕", Font.BOLD, 28));
        title.setHorizontalAlignment(SwingConstants.CENTER);


        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        add(title, c);


        c.gridwidth = 1; c.gridy++;
        add(new JLabel("Nick :"), c);
        nickField = new JTextField("Player");
        c.gridx = 1; add(nickField, c);


        c.gridx = 0; c.gridy++;
        add(new JLabel("Server IP :"), c);
        ipField = new JTextField("127.0.0.1");
        c.gridx = 1; add(ipField, c);


        c.gridx = 0; c.gridy++;
        add(new JLabel("Port :"), c);
        portField = new JTextField("5555");
        c.gridx = 1; add(portField, c);


        c.gridx = 0; c.gridy++;
        connectBtn = new RoundedButton("접속하기");
        connectBtn.setPreferredSize(new Dimension(200, 40));
        add(connectBtn, c);


        c.gridx = 1;
        quickBtn = new RoundedButton("빠른 시작");
        quickBtn.setPreferredSize(new Dimension(200, 40));
        add(quickBtn, c);


// Actions: for now just switch screens
        connectBtn.addActionListener(e -> parent.showLobby());
        quickBtn.addActionListener(e -> parent.showRoom());
    }
}
