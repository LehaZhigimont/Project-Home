package Streams;

import java.io.File;
import java.util.Scanner;

public class StreamsMenu{
    private Scanner scr = new Scanner(System.in);
    private String input = null;
    private InputStream in = new InputStream();
    private OutputStream out = new OutputStream();
    private File file = null;
    private boolean valid = true;


    public void Streams(){
        while(true){
            System.out.println();
            System.out.println("Choose from the list:");
            System.out.println("1.Open file with your path(e.g. \"c:/1.txt\").");
            System.out.println("2.Open the file of this project.");
            System.out.println("3.Write a text to the file.");
            System.out.println("4.Write the alphabet to file.");
            System.out.println("5.Clear this file.");
            System.out.println("6.Exit.");
            System.out.println("Enter your select:");
            Menu(scr.nextLine());
        }
    }


    private void Menu(String value){
        if(validationCurrentChoise(value)==null){
            return;
        }else {
            validationCurrentChoise(value);
        }
        switch (value){
            case "1":{
                ValidFile(1);
                return;
            }
            case "2":{
                /*
                Открыватье наш дефолтный файл, indexFile = 0 - default file
                 */
                in.Input(0);
                return;
            }
            case "3":{
                if(in.getFile()==null){
                    ValidFile(2);
                    return;
                }else {
                    out.Output(scr.nextLine());
                    return;
                }
            }
            case "4":{
                if(in.getFile()==null){
                    ValidFile(3);
                    return;
                }else {
                    out.WriteAlphabet();
                    return;
                }
            }
            case "5":{
                out.ClearFile();
                return;
            }
            case "6":{
                System.exit(0);
            }
        }
    }

    private File ValidFile(int currentCase){
        /*
        currentCase = 1  -  open path
        currentCase = 2  -  write user text
        currentCase = 3  -  write alphabet
         */
        valid = true;
        while(valid) {
            System.out.println("Enter path with your file:");
            input = scr.nextLine();
            if(!("".equals(input)) && !(input.length()<8)){
                if(':'==input.charAt(1) && '/'==input.charAt(2)
                        && ".txt".equals(input.substring(input.length()-4,input.length()))){
                    file = new File(input);
                    in.setFile(file);
                    valid=false;
                    // indexFile = 1 - user path
                    if(currentCase==1){
                        in.Input(1);
                        break;
                    }else if(currentCase==2){
                        System.out.println("Enter your text:");
                        out.Output(scr.nextLine());
                        break;
                    }else if (currentCase==3){
                        out.WriteAlphabet();
                    }
                }
            }
            System.out.println("No correct path!");
            System.out.println("(e.g. \"c:/1.txt\")");
        }
        return file;
    }


    private String validationCurrentChoise(String currentValue){
        for(int i=1; i<7; i++){
            if((""+i).equals(currentValue)){
                return currentValue;
            }
        }
        System.out.println("No correct!");
        return null;
    }
}
