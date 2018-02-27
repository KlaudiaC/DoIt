package com.komputer.options;
import com.komputer.AppGUI;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Find extends JFrame implements ActionListener{
    private int startIndex = 0;
    private int startSelection = -1;
    private int endSelection = -1;

    private int labelHeight = 20;
    private int labelWidth = 100;
    private JLabel searchLabel = new JLabel();
    private JLabel replaceLabel = new JLabel();

    private JTextField searchingField = new JTextField();
    private JTextField replacingField =  new JTextField();

    private JButton findNextButton = new JButton();
    private JButton replaceButton = new JButton();
    private JButton replaceAllButton = new JButton();

    private JTextArea area;

    public Find(JTextArea textArea){
        area = textArea;
        setLayout(null);
        setSize(425, 150);
        setLocationRelativeTo(area);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        searchLabel.setBounds(10, 25, labelWidth, labelHeight);
        add(searchLabel);
        searchingField.setBounds(labelWidth, 25, 120, 20);
        add(searchingField);

        replaceLabel.setBounds(10, labelHeight + 30, labelWidth, labelHeight);
        add(replaceLabel);
        replacingField.setBounds(labelWidth, labelHeight + 30, 120, 20);
        add(replacingField);

        findNextButton.setBounds(250, 10, 140, 20);
        add(findNextButton);
        findNextButton.addActionListener(this);

        replaceButton.setBounds(250, 40, 140, 20);
        add(replaceButton);
        replaceButton.addActionListener(this);

        replaceAllButton.setBounds(250, 70, 140, 20);
        add(replaceAllButton);
        replaceAllButton.addActionListener(this);

        setLabels();
    }

    private void setLabels(){
        if(AppGUI.isPolish){
            searchLabel.setText("Znajdź");
            replaceLabel.setText("Zastąp");
            findNextButton.setText("Znajdź następny");
            replaceButton.setText("Zastąp");
            replaceAllButton.setText("Zastąp wszystkie");
        }
        else{
            searchLabel.setText("Find");
            replaceLabel.setText("Replace");
            findNextButton.setText("Find next");
            replaceButton.setText("Replace");
                replaceAllButton.setText("Replace all");
        }
    }

    public void find(){
        startSelection = area.getText().toLowerCase().indexOf(searchingField.getText().toLowerCase());
        endSelection = startSelection + searchingField.getText().length();

        if(startSelection == -1){
            if(AppGUI.isPolish)
                JOptionPane.showMessageDialog(null, "Nie znaleziono.");
            else
                JOptionPane.showMessageDialog(null, "Not found.");
            startIndex = 0;
            return;
        }
        area.select(startSelection, endSelection);
    }

    private void findNext(){
        String selection = area.getSelectedText();

        try{
            selection.equals("");
        }catch(NullPointerException e){
            selection = searchingField.getText();
            try{
                selection.equals("");
            }catch(NullPointerException ex){
                selection = JOptionPane.showInputDialog("");
                searchingField.setText(selection);
            }
        }

        try{
            startSelection = area.getText().toLowerCase().indexOf(selection.toLowerCase(), startIndex);
            endSelection = startSelection + selection.length();
            area.select(startSelection, endSelection);
            startIndex = endSelection + 1;

            if(startSelection == area.getText().toLowerCase().lastIndexOf(selection.toLowerCase()))
                startIndex = 0;
        }catch(NullPointerException ignored){

        }
    }

    private void replace(){
        try{
            find();
            if(startSelection != -1)
                area.replaceSelection(replacingField.getText());
        }catch(NullPointerException e){
            System.out.print("Null Pointer Exception: " + e);
        }
    }

    private void replaceAll(){
        area.setText(area.getText().toLowerCase().replaceAll(searchingField.getText().toLowerCase(), replacingField.getText()));
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == findNextButton)
            findNext();
        else if(e.getSource() == replaceButton)
            replace();
        else if(e.getSource() == replaceAllButton)
            replaceAll();
    }
}
