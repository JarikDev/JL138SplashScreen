package com;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SplashScreen ss = SplashScreen.getSplashScreen();
  /*      Rectangle rec = ss.getBounds();
        Graphics2D g2 = ss.createGraphics();
        g2.setColor(Color.GREEN);
        for (int i = 0; i < 100; i++) {
            g2.fillRect(0, 0, rec.width * i / 100, 20);
            ss.update();
            Thread.sleep(100);
        }*/
        final Image img = new ImageIcon(ss.getImageURL()).getImage();
        final JFrame sF = new JFrame();
        final JPanel sP = new JPanel();
        sP.add(new JComponent() {
            public void paintComponent(Graphics g) {
                g.drawImage(img,  0,  0,null);
            }
        });

        final JProgressBar jpb = new JProgressBar();
        jpb.setStringPainted(true);
        sP.setLayout(new BorderLayout());
        sP.add(jpb, BorderLayout.NORTH);
        sF.add(sP);
        sF.setBounds(ss.getBounds());
        sF.setVisible(true);
        try {
            for (int i = 0; i <= 100; i++) {
                jpb.setString("Loading module " + i);
                jpb.setValue(i);
                sP.repaint();
                Thread.sleep(100);

            }
        } catch (InterruptedException ex) {
        }
        sF.setVisible(false);
    }
}


















