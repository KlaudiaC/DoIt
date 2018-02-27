package com.komputer.options;
import com.komputer.AppGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Options extends JMenu{
    public JMenuItem find = new JMenuItem();
    public JMenuItem language = new JMenuItem();

    public Options(AppGUI appGUI){
        add(find);
        find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
        find.addActionListener(appGUI);

        add(language);
        language.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
        language.addActionListener(appGUI);
    }

    public void setLabels(){
        if(AppGUI.isPolish){
            setText("Opcje");
            find.setText("Wyszukaj");
            language.setText("Zmień język");
        }
        else{
            setText("Options");
            find.setText("Search");
            language.setText("Change language");
        }
    }
}
