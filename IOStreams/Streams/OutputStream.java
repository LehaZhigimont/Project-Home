package Streams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputStream extends InputStream{
    private FileWriter fr = null;
    private String alphabet = "";

    public void Output(String input){
        try {
            fr = new FileWriter(getFile(),true);
            fr.write(input);
            System.out.println("Recording chaned!");
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
            fr = new FileWriter(getFile(),false);
            fr.write(""); // очищаем, перезаписав поверх пустую строку
            fr.close();
            System.out.println("File is cleared!");
        } catch (Exception e)
            {System.err.println("Error in file cleaning: " + e.getMessage());
        }
    }
    public void WriteAlphabet(){
        try {
            fr = new FileWriter(getFile(),false);
            int letter = 65;
            while(true){
                if(letter>90){
                    break;
                }else {
                    alphabet = alphabet + (char)letter;
                    letter++;
                }
            }
            fr.write(alphabet);
            System.out.println("Recording chaned!");
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
}
