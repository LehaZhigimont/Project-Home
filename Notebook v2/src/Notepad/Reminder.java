package Notepad;

import java.text.*;
import java.util.*;

public class Reminder extends Records {
    private String reminderDate;
    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    private String needDate = null;
    private Date date;

    public Reminder (String message, String reminderDate){
        super(message);
        if(reminderDate==null){
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY,12);
            cal.set(Calendar.MINUTE,00);
            cal.set(Calendar.SECOND,0);
            cal.set(Calendar.MILLISECOND,0);
            date = cal.getTime();
            date.setDate(date.getDate()+1);
            needDate = format.format(date);
            this.reminderDate = needDate;
        }else{
            this.reminderDate = reminderDate;
        }
    }

    public String getReminderDate() {
        if(reminderDate.length()<17){
            for(int i=0; reminderDate.length()<17;i++){
                reminderDate = reminderDate + " ";
            }
        }
        return reminderDate;

    }

    @Override
    public String getMessageToString() {
        String message = getMessage();
        if(message.length()>19){
            return message.substring(0, 15) + " ...";
        }else {
            for (int i=0; message.length()<19; i++){
                message = message + " ";
            }
        }
        return message;
    }

    @Override
    public String toString(){
        return "|" + getIdString() + "| |" + getDate() + "| |" + getMessageToString() + "| |" + getReminderDate()+ "|";
    }
}