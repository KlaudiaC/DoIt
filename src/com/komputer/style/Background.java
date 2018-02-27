package com.komputer.style;
import com.komputer.AppGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Background extends JMenu{
    private final ImageIcon backgroundIcon = new ImageIcon("icons/Background.png");
    public JMenuItem background = new JMenuItem("", backgroundIcon);

    public Background(AppGUI appGUI){
        setLabel();
        background.addActionListener(appGUI);
    }

    public static void decorate(JTextArea area) throws IOException{
        BufferedImage image = ImageIO.read(AppGUI.class.getResource("cat-background.png"));
        area.setUI(new javax.swing.plaf.basic.BasicTextAreaUI(){
            @Override
            protected void paintBackground(Graphics g){
                g.drawImage(image, 0, 0, null);
            }
        });
        area.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        area.setForeground(Color.white);
        area.setCaretColor(Color.lightGray);
    }

    public void setLabel(){
        if(AppGUI.isPolish)
            background.setToolTipText("Dodaj tło");
        else
            background.setToolTipText("Add background");
    }
}
