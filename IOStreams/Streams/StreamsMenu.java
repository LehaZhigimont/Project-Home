package Streams;

import java.util.Scanner;

public class StreamsMenu {
    private Scanner scr = new Scanner(System.in);
    private String input = null;
    private InputStream in = new InputStream();
    private OutputStream out = new OutputStream();


    public void Streams(){
        while(true){
            System.out.println("Choose from the list:");
            System.out.println("1.Open file with your directories(e.g. \"c:/1.txt\").");
            System.out.println("2.Open the file of this project.");
            System.out.println("3.Write a text to the file.");
            System.out.println("4.Write the alphabet to file.");
            System.out.println("5.Clear this file.");
            System.out.println("Enter the text:");
            Menu(scr.nextLine());
        }
    }

    private void Menu(String value){
        switch (value){
            case "1":{
                //добавить проверку на правильность введенного пути
                in.Input();
            }
            case "2":{
                /*
                Открыватье наш дефолтный файл
                 */
                in.Input();
            }
            case "3":{
                /*
                Запись всякой лабуды в файл
                 */
                out.Output(scr.nextLine());
            }
            case "4":{

            }
            case "5":{
                out.ClearFile();
            }
        }

    }
}
