package com.komputer.file;
import com.komputer.AppGUI;
import com.komputer.DecisionWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.util.Scanner;

public class File extends JMenu{
    public JMenuItem create = new JMenuItem();
    public JMenuItem open = new JMenuItem();
    public JMenuItem saveTxt = new JMenuItem();
    public JMenuItem savePDF = new JMenuItem();

    public File(AppGUI appGUI){
        add(create);
        create.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
        create.addActionListener(appGUI);

        add(open);
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
        open.addActionListener(appGUI);

        add(this.saveTxt);
        saveTxt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
        saveTxt.addActionListener(appGUI);

        add(this.savePDF);
        savePDF.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
        savePDF.addActionListener(appGUI);
    }

    public void createFile(AppGUI appGUI){
        DecisionWindow decision = new DecisionWindow();
        decision.showWindow(appGUI, true);
    }

    public void openFile(AppGUI appGUI){
        JFileChooser chooser = new JFileChooser();
        int option = chooser.showOpenDialog(appGUI);

        if(option == JFileChooser.APPROVE_OPTION){
            appGUI.textArea.setText("");
            try{
                Scanner scan = new Scanner(new FileReader(chooser.getSelectedFile().getPath()));
                while(scan.hasNext())
                    appGUI.textArea.append(scan.nextLine());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void setLabels(){
        if(AppGUI.isPolish){
            setText("Plik");
            create.setText("Nowy");
            open.setText("Otwórz");
            saveTxt.setText("Zapisz");
            savePDF.setText("Zapisz jako PDF");
        }
        else{
            setText("File");
            create.setText("New");
            open.setText("Open");
            saveTxt.setText("Save");
            savePDF.setText("Save as PDF");
        }
    }
}
