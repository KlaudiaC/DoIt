package com.komputer.edit;
import com.komputer.AppGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.text.DefaultEditorKit;

public class Edit extends JMenu{
    private JMenuItem cut = new JMenuItem(new DefaultEditorKit.CutAction());
    private JMenuItem copy = new JMenuItem(new DefaultEditorKit.CopyAction());
    private JMenuItem paste = new JMenuItem(new DefaultEditorKit.PasteAction());
    private JMenuItem undo = new JMenuItem(AppGUI.undo);
    private JMenuItem redo = new JMenuItem(AppGUI.redo);

    public Edit(AppGUI appGUI){
        add(cut);
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        cut.addActionListener(appGUI);

        add(copy);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        copy.addActionListener(appGUI);

        add(paste);
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        paste.addActionListener(appGUI);

        add(undo);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        add(redo);
        redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        setLabels();
    }

    public void setLabels(){
        if(AppGUI.isPolish){
            setText("Edycja");
            cut.setText("Wytnij");
            copy.setText("Kopiuj");
            paste.setText("Wklej");
            undo.setText("Cofnij");
            redo.setText("Powtórz");
        }
        else{
            setText("Edit");
            cut.setText("Cut");
            copy.setText("Copy");
            paste.setText("Paste");
            undo.setText("Undo");
            redo.setText("Redo");
        }
    }
}
