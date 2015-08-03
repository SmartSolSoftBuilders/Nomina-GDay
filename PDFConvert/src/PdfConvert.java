import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PdfConvert {
    
      	    public void ITextHelloWorld() throws Exception{
    	        Document document = new Document();        
    	        Calendar cal = Calendar.getInstance();
    	        Date fecha = new Date( cal.getTimeInMillis() );
    	        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    	        
    	        String parrafo = "Usaremos este parrafo como ejemplo de lo sencillo que es el uso de la libreria, pues como podria observar en el codigo esta cadena no lleva saltos de linea, mismos que la libreria agrego.";
    	        
    	        String parrafo2 = "A su vez podemos agregar datos con una simple concatenación, como ejemplo ponemos la fecha del dia en el formato deseado: ” + formato.format(fecha) + ” y como podemos ver tambien hacer uso de las diversas funciones de formateo de fecha y numeros, incluso formatos personalidades.";
    	        
    	        PdfWriter.getInstance(document, new FileOutputStream("C://Users//Doraly Hernández//Documents//estrategasFam//estrategas-fam//PDFConvert//src//ReporteFAM.pdf"));
    	        document.open();
    	        document.add(new Paragraph(parrafo));
    	        document.add(new Paragraph(parrafo2));
    	        document.close();
    	            
    	    }
    	    
    	    public static void main(String args[]){
    	        try{
    	        	PdfConvert p = new PdfConvert();
    	            
    	            p.ITextHelloWorld();
    	            
    	        }catch(Exception e){
    	            System.out.println(e);
    	        }
    	    }
       
}