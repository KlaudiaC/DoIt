package com.komputer;
import com.komputer.edit.*;
import com.komputer.file.*;
import com.komputer.style.*;
import com.komputer.options.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;

public class AppGUI extends JFrame implements ActionListener{
    public static JTextArea textArea = new JTextArea(" ", 0, 0);
    private JMenuBar menuBar = new JMenuBar();
    private JToolBar editBar = new JToolBar();

    public File fileMenu = new File(this);
    public Edit editMenu = new Edit(this);

    private Options optionsMenu = new Options(this);
    private FontOptions fontMenu = new FontOptions(this);
    private Background backgroundSetter = new Background(this);

    public static String fontType = "Times New Roman";
    public static int fontStyle = Font.PLAIN;
    public static int fontSize = 12;
    public static boolean isBold;
    public static boolean isItalic;

    private Document editorPaneDocument;
    public UndoHandler undoHandler = new UndoHandler();
    public static UndoManager undoManager = new UndoManager();
    public static Undo undo = new Undo();
    public static Redo redo = new Redo();

    public static boolean isPolish = true;

    public AppGUI(){
        this.setTitle("Do It");
        this.setSize(1000, 500);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(textArea);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        textArea.setFont(new Font(fontType, fontStyle,fontSize));
        textArea.setForeground(Color.black);
        textArea.setLineWrap(true);

        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(optionsMenu);

        add(editBar, BorderLayout.NORTH);
        editBar.add(fontMenu.type);
        editBar.addSeparator();
        editBar.add(fontMenu.size);
        editBar.addSeparator();
        editBar.add(fontMenu.bold);
        editBar.addSeparator();
        editBar.add(fontMenu.italic);
        editBar.addSeparator();
        editBar.add(fontMenu.underline);
        editBar.addSeparator();
        editBar.add(backgroundSetter.background);

        editorPaneDocument = textArea.getDocument();
        editorPaneDocument.addUndoableEditListener(undoHandler);
    }

    public void actionPerformed (ActionEvent e){
        if(e.getSource() == fileMenu.create)
            fileMenu.createFile(this);
        else if(e.getSource() == fileMenu.open)
            fileMenu.openFile(this);
        else if(e.getSource() == fileMenu.saveTxt)
            Save.saveFile(true,this);
        else if(e.getSource() == fileMenu.savePDF)
            Save.saveFile(false,this);
        else if(e.getSource() == fontMenu.bold)
            fontMenu.setBold();
        else if(e.getSource() == fontMenu.italic)
            fontMenu.setItalic();
        else if(e.getSource() == backgroundSetter.background){
            try{
                Background.decorate(textArea);
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
        else if(e.getSource() == optionsMenu.find){
            new Find(textArea);
        }
        else if(e.getSource() == optionsMenu.language){
            new Language().changeLanguage(isPolish);
            fileMenu.setLabels();
            editMenu.setLabels();
            optionsMenu.setLabels();
            fontMenu.setLabels();
            backgroundSetter.setLabel();
        }
    }

    @Override
    protected void processWindowEvent(WindowEvent e){
        if(e.getID() == WindowEvent.WINDOW_CLOSING){
            DecisionWindow decision = new DecisionWindow();
            decision.showWindow(this, true);
        }
    }
}
