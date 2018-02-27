package com.komputer.file;
import com.komputer.AppGUI;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.io.IOException;

public class SaveAsPDF{
    static PDFont font = PDType1Font.HELVETICA;
    static PDDocument document = new PDDocument();
    static PDPage page = new PDPage();
    static PDPageContentStream content;

    static void save(){
        try{
            content = new PDPageContentStream(document, page);
            content.beginText();
            content.moveTextPositionByAmount(25, 770);
            content.setFont(font, AppGUI.fontSize);
            content.drawString(AppGUI.textArea.getText());

            content.endText();
            content.close();
            document.addPage(page);
            document.save("Do It - PDF.pdf");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
