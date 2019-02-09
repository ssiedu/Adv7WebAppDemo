
import java.io.FileInputStream;
import java.io.IOException;

public class Utility {

public static byte[] readData(String filename) throws IOException{
    FileInputStream fis=new FileInputStream(filename);
    int n=fis.available();
    byte b[]=new byte[n];
    fis.read(b);
    fis.close();
    return b;
}
    
}
