
import java.io.FileOutputStream;
import java.io.IOException;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
 
public class Concatenate {
 
    /** The resulting PDF file. */
    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException
     */
    public static void main(String[] args)
        throws IOException, DocumentException {

        if (args.length < 2) {
           println("USAGE duplicatepages outputfile inputfile1 [inputfile2 ...]")
           System.exit 1
        }
        String outputfilepath = args[0]
        List<String> files        = args[1..-1]

        Document document = new Document();

        PdfCopy newpdf = new PdfCopy(document, new FileOutputStream(outputfilepath));

        document.open();

        PdfReader reader;

        int n;

        files.each{ file ->
            reader = new PdfReader(file);
            n = reader.getNumberOfPages();
            for (int page = 0; page < n; ) {
                page++
                newpdf.addPage(newpdf.getImportedPage(reader, page));
                newpdf.addPage(newpdf.getImportedPage(reader, page));
            }
            newpdf.freeReader(reader);
            reader.close();
        }
        document.close();
    }
}

