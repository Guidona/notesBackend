package com.douwe.notes.service.document.impl;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author vincent
 */
public class ReleveDecorator extends PdfPageEventHelper {

    protected Paragraph pied;
    protected Paragraph pied2;
    protected Phrase GPA = new Phrase("GPA = Grade Point Average (moyenne par grade). A+=[3,6 4] (Excellent / First Class Hons.), A- = [3,2 3,6[ (Très Bien / Second Class Hons. Upper Division), B = [2,8 3,2[ (Bien / Second Class Hons. Lower Division), B- = [2,4 2,8[ (Assez-Bien / Third Class), C = [2 2,4[ (Passable / Pass)", new Font(Font.FontFamily.TIMES_ROMAN, 5, Font.NORMAL, BaseColor.BLACK));
    protected Image anotherWatermark;

    public ReleveDecorator() {
        try {
            pied = new Paragraph("Ce relevé de notes, pour être valide, ne doit contenir ni surcharge, ni rature. Le titulaire devra faire certifier les copies conformes en cas de besoin.", new Font(Font.FontFamily.TIMES_ROMAN, 5, Font.NORMAL, BaseColor.BLACK));
            pied2 = new Paragraph("This academic transcript is only valid when it contains neither overload neither cross off. The holder will have to make certified true copies when necessary.", new Font(Font.FontFamily.TIMES_ROMAN, 5, Font.ITALIC, BaseColor.BLACK));
            //pied = new Paragraph(builder.toString(), new Font(Font.FontFamily.TIMES_ROMAN, 5, Font.NORMAL, BaseColor.BLACK));
            URL url = new ClassPathResource("watermark.png").getURL();
            anotherWatermark = Image.getInstance(url);

        } catch (IOException | BadElementException ex) {
            Logger.getLogger(RelevetDocument.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        try {
            PdfContentByte canvas = writer.getDirectContentUnder();
            //ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, 298, 421, 45);
            //ColumnText.s
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, pied, 40, 50, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, pied2, 40, 46, 0);
            canvas.addImage(anotherWatermark, anotherWatermark.getWidth(), 0, 0, anotherWatermark.getHeight(), 110, 310);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, GPA, 575, 690, 270);
        } catch (DocumentException ex) {
            Logger.getLogger(RelevetDocument.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onGenericTag(PdfWriter writer, Document document, Rectangle rect, String text) {
        PdfContentByte canvas = writer.getDirectContent();
        // Paddings for the border
        int paddingHorizontal = 10;
        int paddingVertical = 5;
        // Width of the shadow
        int shadowwidth = 5;
        // Calculate border location and size
        float left = rect.getLeft() - paddingHorizontal;
        float bottom = rect.getBottom() - paddingVertical;
        float width = rect.getWidth() + 2 * paddingHorizontal;
        float height = rect.getHeight() + 2 * paddingVertical;
        canvas.saveState();
        canvas.setColorFill(BaseColor.LIGHT_GRAY);
        // Draw the shadow at the bottom
        canvas.rectangle(left + shadowwidth, bottom - shadowwidth, width, shadowwidth);
        canvas.fill();
        // Draw the shadow at the right
        canvas.rectangle(left + width, bottom - shadowwidth, shadowwidth, height);
        canvas.fill();
        canvas.setColorStroke(BaseColor.BLACK);
        // Draw the border
        canvas.rectangle(left, bottom, width, height);
        canvas.stroke();
        canvas.restoreState();
    }
}
