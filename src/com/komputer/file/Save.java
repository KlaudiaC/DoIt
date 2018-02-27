package com.komputer.file;
import com.komputer.AppGUI;

public class Save{
    public static void saveFile(boolean toTxt, AppGUI appGUI){
        if(toTxt)
            SaveAsTxt.save(appGUI);
        else
            SaveAsPDF.save();
    }
}
