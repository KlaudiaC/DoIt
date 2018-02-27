package com.komputer;
import com.komputer.file.Save;
import javax.swing.*;

public class DecisionWindow{
    public void showWindow(AppGUI appGUI, boolean isMainWindow){
        Object[] options;
        String message;

        if(appGUI.isPolish){
            options = new Object[] {"Zapisz", "Nie zapisuj", "Anuluj"};
            message = "Czy chcesz zapisać plik?";
        }
        else{
            options = new Object[] {"Save", "Don't save", "Cancel"};
            message = "Do you want to save the file?";
        }

        int choice = JOptionPane.showOptionDialog(appGUI, message, "", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
        if(choice == 0){
            Save.saveFile(true, appGUI);
            if(isMainWindow)
                System.exit(0);
            else
                appGUI.textArea.setText("");
        }
        else if(choice == 1){
            if(isMainWindow)
                System.exit(0);
            else
                appGUI.textArea.setText("");
        }
    }
}
