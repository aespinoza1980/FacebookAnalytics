package IO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alexis on 10/09/15.
 * Reads the elements of a file into an ArrayList
 */
public class ReadFile {
    private static  BufferedReader br = null;
    public static ArrayList<String> readFileIntoArrayList (String fileName){
        ArrayList<String> arrayListFile=new ArrayList<String>();
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(fileName));
            int i=0;
            while ((sCurrentLine = br.readLine()) != null) {
                arrayListFile.add(i,sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return arrayListFile;
    }
}
