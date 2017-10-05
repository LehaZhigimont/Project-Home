package Streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStream {
    private final File DEFOULTFILE = new File("c:/test.txt");
    private static File file = null;
    private int letter=0;
    private String Messeg = "";
    private FileInputStream fis = null;
    private InputStreamReader isr = null;

    public void Input(int indexFile){
        try {
            if(indexFile==0){
                fis = new FileInputStream(DEFOULTFILE);
            }else if (indexFile==1){
                fis = new FileInputStream(file);
            }
            isr = new InputStreamReader(fis);
            while((letter=isr.read())!=-1){
                Messeg = Messeg + (char)letter;
            }
            System.out.println(Messeg);
            Messeg = "";
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
