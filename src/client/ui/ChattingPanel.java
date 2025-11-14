package client.ui;

import javax.swing.*;
import java.awt.*;

public class ChattingPanel extends JPanel {
    private JTextArea chatArea;
    private JTextField textField;
    public ChattingPanel() {
        setLayout(new BorderLayout());
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane chatScroll = new JScrollPane(chatArea);
        chatScroll.setPreferredSize(new Dimension(280, 0));
        add(chatScroll, BorderLayout.CENTER);
        textField = new JTextField();
        add(textField, BorderLayout.SOUTH);
    }
}
