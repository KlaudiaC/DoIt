package com.komputer.edit;
import com.komputer.AppGUI;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import java.awt.event.ActionEvent;

public class Redo extends AbstractAction implements Command{
    public Redo(){
        super("Powtórz");
        setEnabled(false);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            AppGUI.undoManager.redo();
        }catch(CannotRedoException e){
            e.printStackTrace();
        }
        execute();
        AppGUI.undo.execute();
    }

    @Override
    public void execute(){
        if(AppGUI.undoManager.canRedo())
            setEnabled(true);
        else
            setEnabled(false);
    }
}
