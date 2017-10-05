package Streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStream {
    // private java.io.InputStream inp = Check.class.getResourceAsStream("Streams/resources/1.txt");
    private File file = new File("./1.txt");
    private int letter=0;
    private String Messeg = "";
    private FileInputStream fis = null;
    private InputStreamReader isr = null;

    public void Input(){
        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            while((letter=isr.read())!=-1){
                Messeg = Messeg + (char)letter;
            }
            System.out.println(Messeg);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            while(true){
                try {
                    fis.close();
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            while(true){
                try {
                    isr.close();
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
