package com.komputer.file;
import com.komputer.AppGUI;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class SaveAsTxt{
    static void save(AppGUI appGUI){
        JFileChooser chooser = new JFileChooser();
        int option = chooser.showSaveDialog(appGUI);

        if(option == JFileChooser.APPROVE_OPTION){
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(chooser.getSelectedFile().getPath()));
                writer.write(appGUI.textArea.getText());
                writer.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
