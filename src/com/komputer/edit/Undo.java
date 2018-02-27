package com.komputer.edit;
import com.komputer.AppGUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.undo.CannotUndoException;

public class Undo extends AbstractAction implements Command{
    public Undo(){
        super("Cofnij");
        setEnabled(false);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            AppGUI.undoManager.undo();
        }catch(CannotUndoException e){
            e.printStackTrace();
        }
        execute();
        AppGUI.redo.execute();
    }

    @Override
    public void execute(){
        if(AppGUI.undoManager.canUndo())
            setEnabled(true);
        else
            setEnabled(false);
    }
}
