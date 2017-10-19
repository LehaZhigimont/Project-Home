package Notepad;

import java.io.*;
import java.util.*;

public class IOStream extends MainMenu{
    private Scanner scr = new Scanner(System.in);

    private void exportNotebook() {
        if(getNotepad().getNotes().isEmpty()){
        }else {
            writeFile(getNotepad().getNotes(), NotepadConst.FILENOTE.filePath());
        }
        if (getNotepad().getReminders().isEmpty()){
        } else{
            writeFile(getNotepad().getReminders(), NotepadConst.FILEREMINDER.filePath());
        }
    }

    private void importNotebook() {
        if(getNotepad().getNotes().isEmpty()){
        }else {
            readFile(NotepadConst.FILENOTE.filePath());
        }
        if (getNotepad().getReminders().isEmpty()){
        } else{
            readFile(NotepadConst.FILEREMINDER.filePath());
        }
    }

    private void writeFile(Set notebook, String path){
        Iterator node = notebook.iterator();
        String temp = "" + node;
        try {
            FileWriter writer = new FileWriter(path, false);
            while(node.hasNext()){
                node.next();
                writer.write(temp.toString()  + "\r\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile(String path){
        String lines;
        String[] line = new String[4];
        try {
            scr = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("WTF?! Where file?");
        }
        while(scr.hasNext()) {
            lines = scr.nextLine();
            line = lines.split(" ");
            if(line[1].substring(2,3).equals(":")){
                addReminder();
            }else {
                addNote();
            }
        }
        scr.close();
    }



}
