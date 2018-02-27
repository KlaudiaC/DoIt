package com.komputer.style;
import com.komputer.AppGUI;
import javax.swing.*;
import java.awt.*;

public class FontOptions extends JMenu{
    private final ImageIcon boldIcon = new ImageIcon("icons/Bold.png");
    private final ImageIcon italicIcon = new ImageIcon("icons/Italic.png");
    private final ImageIcon underlineIcon = new ImageIcon("icons/Underline.png");

    public JComboBox<String> type = new JComboBox<>();
    public JComboBox<Integer> size = new JComboBox<>();
    public JMenuItem bold = new JMenuItem("", boldIcon);
    public JMenuItem italic = new JMenuItem("", italicIcon);
    public JMenuItem underline = new JMenuItem("", underlineIcon);

    public FontOptions(AppGUI appGUI){
        add(type);
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(String f : fonts)
            type.addItem(f);
        type.addActionListener(ev -> setFontType(type.getSelectedItem().toString()));

        add(size);
        for(int i = 1; i <= 100; i++)
            size.addItem(i);
        size.addActionListener(ev -> setFontSize(Integer.parseInt(size.getSelectedItem().toString())));

        add(bold);
        bold.addActionListener(appGUI);

        add(italic);
        italic.addActionListener(appGUI);

        add(underline);
        underline.addActionListener(appGUI);

        setLabels();
    }

    public void setBold(){
        AppGUI.isBold = !AppGUI.isBold;
        updateFont();
    }

    public void setItalic(){
        AppGUI.isItalic = !AppGUI.isItalic;
        updateFont();
    }

    private void setFontType(String name){
        AppGUI.fontType = name;
        updateFont();
    }

    private void setFontSize(int size){
        AppGUI.fontSize = size;
        updateFont();
    }

    private void updateFont(){
        if(AppGUI.isBold && AppGUI.isItalic)
            AppGUI.fontStyle = Font.BOLD + Font.ITALIC;
        else if(AppGUI.isBold)
            AppGUI.fontStyle = Font.BOLD;
        else if(AppGUI.isItalic)
            AppGUI.fontStyle = Font.ITALIC;
        else
            AppGUI.fontStyle = Font.PLAIN;

        AppGUI.textArea.setFont(new Font(AppGUI.fontType, AppGUI.fontStyle, AppGUI.fontSize));
    }

    public void setLabels(){
        if(AppGUI.isPolish){
            type.setToolTipText("Typ czcionki");
            size.setToolTipText("Wielkość czcionki");
            bold.setToolTipText("Pogrubienie");
            italic.setToolTipText("Kursywa");
            underline.setToolTipText("Podkreślenie");
        }
        else{
            type.setToolTipText("Font type");
            size.setToolTipText("Font size");
            bold.setToolTipText("Bold");
            italic.setToolTipText("Italic");
            underline.setToolTipText("Underline");
        }
    }
}
