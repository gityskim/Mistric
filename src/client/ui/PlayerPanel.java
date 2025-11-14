package client.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


class PlayerPanel extends JPanel {
    public PlayerPanel(String name, boolean isHost) {
        setLayout(new BorderLayout());
        setBackground(new Color(250,250,250));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200,200,200)),
                BorderFactory.createEmptyBorder(10,10,10,10)));
        JLabel icon = new JLabel("", SwingConstants.CENTER);
        icon.setPreferredSize(new Dimension(120,120));
        icon.setIcon(createAvatarIcon());
        add(icon, BorderLayout.CENTER);


        JLabel nameLabel = new JLabel(name, SwingConstants.CENTER);
        add(nameLabel, BorderLayout.SOUTH);


        if (isHost) {
            JLabel hostLabel = new JLabel("(호스트)", SwingConstants.CENTER);
            hostLabel.setFont(hostLabel.getFont().deriveFont(Font.ITALIC, 11f));
            add(hostLabel, BorderLayout.NORTH);
        }
    }


    private Icon createAvatarIcon() {
// simple gray circle avatar
        int size = 80;
        BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(200,200,200));
        g.fillOval(0,0,size,size);
        g.dispose();
        return new ImageIcon(img);
    }
}
