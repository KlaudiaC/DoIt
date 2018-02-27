package com.komputer.options;
import com.komputer.AppGUI;
import com.komputer.edit.Edit;

public class Language{
    public void changeLanguage(boolean isPolish){
        AppGUI.isPolish = !isPolish;
    }
}
