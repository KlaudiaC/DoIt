package com.komputer.edit;
import com.komputer.AppGUI;
import javax.swing.event.UndoableEditListener;
import javax.swing.event.UndoableEditEvent;

public class UndoHandler implements UndoableEditListener{
    public void undoableEditHappened(UndoableEditEvent e){
            AppGUI.undoManager.addEdit(e.getEdit());
            AppGUI.undo.execute();
            AppGUI.redo.execute();
    }
}
