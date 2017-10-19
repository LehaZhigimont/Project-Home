package Notepad;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.*;

public class MainMenu {
    private File file;
    private Scanner scr = new Scanner(System.in);
    private int selectNumbersByMeny = 0;
    private boolean itsTrue = true;
    private int openAndRemove;
    private Notebook notepad;
    private String input;



    public MainMenu(){
        notepad = new Notebook();
    }

    public Notebook getNotepad() {
        return notepad;
    }

    public void start(){
        this.Menu();
    }

    private void Menu(){
        while(true){
            if (notepad.isEmpy()){
                System.out.println("=============================");
                System.out.println("|        ГЛАВНОЕ МЕНЮ       |");
                System.out.println("=============================");
                System.out.println("|1. Меню заметок            |");
                System.out.println("|2. Меню напоминаний        |");
                System.out.println("|3. Импорт/экспорт записей  |");
                System.out.println("|4. Выход                   |");
                System.out.println("=============================");
                System.out.println("Сделай свой выбор же наконец: ");
                selectNumbersByMeny =4;
                subMenu(selectNumbersByMeny);
            }else {
                System.out.println("=============================");
                System.out.println("|        ГЛАВНОЕ МЕНЮ       |");
                System.out.println("=============================");
                System.out.println("|1. Меню заметок            |");
                System.out.println("|2. Меню напоминаний        |");
                System.out.println("|3. Импорт/экспорт записей  |");
                System.out.println("|4. Заметки и напоминания   |");
                System.out.println("|5. Выход                   |");
                System.out.println("=============================");
                selectNumbersByMeny =5;
                subMenu(selectNumbersByMeny);
            }
        }
    }

    private void subMenu(int selectNumbersByMenu){
            inValidCorretSelectByMenu(scr, selectNumbersByMenu);
            switch (input){
                case "1":{
                    subNoteAndReminder(NotepadConst.NOTE);
                    break;
                }
                case "2":{
                    subNoteAndReminder(NotepadConst.REMINDER);
                    break;
                }
                case "3":{
                        IOStream();
                        break;
                }
                case "4" : {
                    if(notepad.isEmpy()){
                        System.err.println("=============================");
                        System.err.println("|>>>>>>>>>>Bye-Bye<<<<<<<<<<|");
                        System.err.println("=============================");
                        System.exit(0);
                    }else{
                        System.out.println("                                ЗАМЕТКИ");
                        printAllNotes();
                        System.out.println("                              НАПОМИНАНИЯ");
                        printAllReminders();
                        subNoteRemind();
                        break;
                    }
                }
                case "5":  {
                    System.err.println("=============================");
                    System.err.println("|>>>>>>>>>>Bye-Bye<<<<<<<<<<|");
                    System.err.println("=============================");
                    System.exit(0);
                }
            }
    }

    private void subNoteRemind(){
        System.out.println("=============================");
        System.out.println("|1.Открыть запись по ID     |");
        System.out.println("|2.Удалить запись по ID     |");
        System.out.println("|3.Вернуться в главное меню |");
        System.out.println("=============================");
        selectNumbersByMeny =3;
        inValidCorretSelectByMenu(scr, selectNumbersByMeny);
        switch (input){
            case "1":{
                openAndRemove=0;
                openOrRemoveMesseg(openAndRemove);
                break;
            }
            case "2": {
                if (notepad.isEmpy()){
                    System.out.println("ЗАПИСЕЙ НЕТ!");
                    break;
                }else{
                    openAndRemove=1;
                    openOrRemoveMesseg(openAndRemove);
                    break;
                }
            }
            case "3":{return;}
        }
    }

    private void subNoteAndReminder(NotepadConst menu){
        while(true){
            System.out.println("=============================");
            if(menu.equals(NotepadConst.NOTE)) {
                System.out.println("|       МЕНЮ \"ЗАМЕТКИ\"      |");
            }else{
                System.out.println("|     МЕНЮ \"НАПОМИНАНИЯ\"    |");
            }
            System.out.println("=============================");
            System.out.println("|1.Создать запись           |");
            if((notepad.getNotes().isEmpty() && menu.equals(NotepadConst.NOTE))
                    || (notepad.getReminders().isEmpty() && menu.equals(NotepadConst.REMINDER))){
                System.out.println("|2.Вернуться в главное меню |");
                System.out.println("=============================");
                selectNumbersByMeny =2;
            }else {
                System.out.println("|2.Удалить запись           |");
                System.out.println("|3.Посмотреть все записи    |");
                System.out.println("|4.Вернуться в главное меню |");
                System.out.println("=============================");
                selectNumbersByMeny =4;
            }
            inValidCorretSelectByMenu(scr, selectNumbersByMeny);
            switch (input){
                case "1":{
                    if(menu.equals(NotepadConst.NOTE)) {
                        addNote();
                    }else {
                        addReminder();
                    }
                    break;
                }
                case "2":{
                    if (selectNumbersByMeny ==2){
                        return;
                    }else if(menu.equals(NotepadConst.NOTE)){
                        removeNote();
                        break;
                    }else {
                        removeReminder();
                        break;
                    }
                }
                case "3": {
                    if (menu.equals(NotepadConst.NOTE)) {
                        printAllNotes();
                        break;
                    } else {
                        printAllReminders();
                        break;
                    }
                }
                case "4": {return;}
            }
        }
    }

    private void IOStream() {
        System.out.println("=============================");
        System.out.println("|1. Экспорт всех записей    |");
        System.out.println("|2. Импорт всех записей     |");
        System.out.println("|3. Вернуться в главное меню|");
        System.out.println("=============================");
        selectNumbersByMeny =3;
        inValidCorretSelectByMenu(scr, selectNumbersByMeny);
        switch (input){
            case "1":{
                if (notepad.isEmpy()){
                    System.out.println("Нечего экспортировать!");
                    break;
                } else {
                    exportNotebook();
                    break;
                }
            }
            case "2": {
                if (notepad.isEmpy()){
                    System.out.println("Нечего импортировать!");
                    System.out.println("Записей нет!");
                    return;
                } else {
                    importNotebook();
                    break;
                }
            }
            case "3":{return;}
        }

    }

    private void exportNotebook() {
        if(notepad.getNotes().isEmpty()){
        }else {
            writeFile(notepad.getNotes(), NotepadConst.FILENOTE.filePath());
        }
        if (notepad.getReminders().isEmpty()){
        } else{
            writeFile(notepad.getReminders(), NotepadConst.FILEREMINDER.filePath());
        }
    }

    private void importNotebook() {
        if(notepad.getNotes().isEmpty()){
        }else {
            readFile(NotepadConst.FILENOTE.filePath());
        }
        if (notepad.getReminders().isEmpty()){
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
                notepad.addRecords(remind);
            }else {
                Note note = new Note(scr.nextLine());
                notepad.addRecords(note);
            }
        }
        scr.close();
    }

    private void addNote() {
        System.out.println("=============================");
        System.out.println("|       Новая заметка       |");
        System.out.println("=============================");
        System.out.println("|Введите текст заметки:     |");
        Note note = new Note(scr.nextLine());
        notepad.addRecords(note);
        System.out.println("=============================");
        System.out.print("|  Заметка № ");
        System.out.println(note.getId() + "             |");
        System.out.println("|      успешно создана      |");
        System.out.println("=============================");
        System.out.println();
    }

    private void removeNote() {
        printAllNotes();
        openAndRemove=2;
        openOrRemoveMesseg(openAndRemove);
    }

    private void printAllNotes() {
        System.out.println("=====================================================================");
        System.out.println("|  id  | |      Data      | |                 Messege               |");
        System.out.println("=====================================================================");
        Set<Note> set = notepad.getNotes();
        if(notepad.getNotes().isEmpty()){
            System.out.println("                        ЗАМЕТОК НЕТ");
        }
        for (Note note : set){
            System.out.println(note);
        }
        System.out.println("=====================================================================");
        System.out.println();
    }

    private void addReminder(){
        System.out.println("=============================");
        System.out.println("|Введите дату напоминания:  |");
        System.out.println("|(Пример = 12.12.2012 12:12)|");
        System.out.println("|по умолчанию завтра в 12:00|");
        String needDate = scr.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date date = new Date();
        try {
            date = format.parse(needDate);
            needDate = format.format(date);
        } catch (ParseException ex) {
            System.err.println("Вы ввели не корректную дату!");
            System.out.println("Ваше напоминание сработает");
            System.out.println("завтра в 12:00 (по МСК)");
            date = null;
            needDate = null;
        }
        System.out.println("=============================");
        System.out.println("|Введите теск напоминания:  |");
        Reminder remind = new Reminder(scr.nextLine(), needDate);
        notepad.addRecords(remind);
        System.out.println("=============================");
        System.out.println("|Напоминание № ");
        System.out.println(remind.getId() + "             |");
        System.out.println("|      успешно создано      |");
        System.out.println("=============================");
        System.out.println();
    }

    private void removeReminder() {
        printAllReminders();
        openAndRemove=3;
        openOrRemoveMesseg(openAndRemove);
    }

    private void printAllReminders() {
        System.out.println("=====================================================================");
        System.out.println("|  id  | |      Data      | |      Messege      | |  Reminder Data  |");
        System.out.println("=====================================================================");
        Set<Reminder> set = notepad.getReminders();
        if(notepad.getReminders().isEmpty()){
            System.out.println("                            НАПОМИНАНИЙ НЕТ");
        }
        for (Reminder reminder : set){
            System.out.println(reminder);
        }
        System.out.println("=====================================================================");
        System.out.println();
    }

    private void openOrRemoveMesseg(int openAndRemove){
        itsTrue = true;
        while (itsTrue) {
            System.out.println("=============================");
            if(openAndRemove==0) {
                System.out.println("| Введите ID записи:        |");
                System.out.println("| (no - отмена):            |");
            }else if(openAndRemove==1){
                System.out.println("| Введите ID для удаления   |");
                System.out.println("| (no - отмена):            |");
            }else if(openAndRemove==2){
                System.out.println("| Введите ID заметки для её |");
                System.out.println("| удаления(no - Отмена):    |");
            }else if(openAndRemove==3){
                System.out.println("| Введите ID напоминания для|");
                System.out.println("| её удаления(no - Отмена): |");
            }
            String idString = scr.nextLine();
            if(idString.equals("no") || idString.equals("No")){
                itsTrue = false;
                if (openAndRemove == 0 || openAndRemove == 1) {
                    subNoteRemind();
                }
                return;
            }else {
                long id = 0;
                try {
                    id = Long.parseLong(idString);
                } catch (NumberFormatException e) {
                    //check at the afte bottom
                }
                if (notepad.getRecordById(id) != null) {
                    System.out.println();
                    if (openAndRemove == 0) {
                        System.out.println("                        ЗАПИСЬ id " + id);
                        System.out.println("=====================================================================");
                        System.out.println(notepad.getRecordById(id).getMessage());
                        System.out.println("=====================================================================");
                        System.out.println();
                        subNoteRemind();
                        return;
                    } else if (openAndRemove == 1
                            || (openAndRemove == 2 && notepad.getNotes().contains(notepad.getRecordById(id)))
                            || (openAndRemove == 3 && notepad.getReminders().contains(notepad.getRecordById(id)))) {
                        notepad.removeRecords(id);
                        System.out.println("=============================");
                        System.out.println("|  Запись № " + id + "          |");
                        System.out.println("        успешно удалена!    |");
                        System.out.println("=============================");
                        System.out.println();
                        itsTrue = false;
                        if (openAndRemove == 1) {
                            subNoteRemind();
                        }
                        return;
                    }
                }
                if(openAndRemove == 2) {
                    if (!notepad.getNotes().contains(notepad.getRecordById(id))) {
                        System.err.println("Нет такого ID заметки!");
                        System.err.println("Попробуй корректно ввести!");
                        itsTrue = true;
                    }
                }else if(openAndRemove == 3){
                    if(!notepad.getReminders().contains(notepad.getRecordById(id))){
                        System.err.println("Нет такого ID напомнинания!");
                        System.err.println("Попробуй корректно ввести!");
                        itsTrue = true;
                    }
                }else {
                    System.err.println("Нет такого ID!");
                    System.err.println("Попробуй нормально ввести!");
                    itsTrue = true;
                }
            }
            itsTrue = true;
        }
    }

    private String inValidCorretSelectByMenu (Scanner scr, int numbersInMenu){
        String parsMenu="1";
        input = scr.nextLine();
        while(!parsMenu.equals(input)){
            for (int i= numbersInMenu; i > 0; i--) {
                parsMenu = "";
                parsMenu = "" + i;
                if (parsMenu.equals(input)) {
                    return input;
                }
            }
            System.err.println("Попробуй нормально ввести!");
            input = scr.nextLine();
            parsMenu="1";
        }
        return input;
    }
}
