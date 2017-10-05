package Streams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputStream extends InputStream{
    private FileWriter fr = null;

    public void Output(String input){
        try {
            fr = new FileWriter(getFile(),true);
            fr.write(input);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            while(true){
                try {
                    fr.close();
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void ClearFile(){
        try {
            fr = new FileWriter(getFile());
            BufferedWriter clear = new BufferedWriter(fr); //  создаём буферезированный поток
            clear.write(""); // очищаем, перезаписав поверх пустую строку
            clear.close();
        } catch (Exception e)
            {System.err.println("Error in file cleaning: " + e.getMessage());
        }
    }
    public void WriteAlphabet(){
        try {
            fr = new FileWriter(getFile());
            BufferedWriter alpha = new BufferedWriter(fr); //  создаём буферезированный поток
            alpha.write(""); // очищаем, перезаписав поверх пустую строку
            alpha.close();
        } catch (Exception e)
        {System.err.println("Error in file cleaning: " + e.getMessage());
        }
    }
}
