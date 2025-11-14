package client.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;


class RoundedButton extends JButton {
    private Color background = new Color(200,230,190);
    private Color hover = new Color(180,210,170);


    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setForeground(Color.DARK_GRAY);
        setFont(getFont().deriveFont(Font.BOLD, 14f));
        setMargin(new Insets(8,12,8,12));


        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) { setBackground(hover); }
            public void mouseExited(java.awt.event.MouseEvent evt) { setBackground(new Color(200,230,190)); }
        });
    }


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(background);
        g2.fill(new RoundRectangle2D.Float(0,0,getWidth(),getHeight(),16,16));
        super.paintComponent(g2);
        g2.dispose();
    }


    @Override
    public void setBackground(Color bg) {
        this.background = bg;
        repaint();
    }
}