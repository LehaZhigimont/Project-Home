package Notepad;

import java.util.*;

public class Notebook {
    private Set<Records> record = new HashSet<Records>();

    public boolean isEmpy (){
        if(record.isEmpty()){
            return true;
        }
        return false;
    }

    public void addRecords(Records r){
        record.add(r);
    }

    public void removeRecords(Long id){
        Iterator<Records> n = record.iterator();
        while(n.hasNext()){
            if(n.next().getId()==id){
                n.remove();
                return;
            }
        }
    }

    public Set<Note> getNotes() {
        Set<Note> result = new HashSet<Note>();
        for (Records r : record) {
            if (r instanceof Note) {
                result.add((Note) r);
            }
        }
        return result;
    }

    public Set<Reminder> getReminders(){
        Set<Reminder> result = new HashSet<Reminder>();
        for (Records r : record) {
            if (r instanceof Reminder) {
                result.add((Reminder) r);
            }
        }
        return result;
    }

    public Records getRecordById(long id) {
        for (Records r : record) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }


}
