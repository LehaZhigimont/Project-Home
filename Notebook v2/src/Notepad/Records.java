package Notepad;

import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Records extends Notebook {
    private static long currentId = 0;
    private String idString;
    private String message;
    private Date date;
    private long id;

    public Records(String message){
        currentId++;
        this.id = currentId;
        this.idString = "" + currentId;
        for(int i=idString.length(); i<6;i++){
            idString = idString + " ";
        }
        this.message = message;
        this.date = new Date();
    }

    public String getIdString() {
        return idString;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageToString() {
        if(message.length()>37){
            if(!(message.substring(34, message.length()).equals("    "))){
                return message.substring(0, 34) + " ...";
            }else {
                return message;
            }
        }else {
            for (int i=0; message.length()<=37; i++){
                message = message + " ";
            }
        }
        return message;
    }

    public long getId() {
        return id;
    }

    public String getDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return format.format(date);
    }

    @Override
    public String toString(){
        return "|" + getIdString() + "| |" + getDate() + "| |" + getMessageToString() + " |";
    }
}
