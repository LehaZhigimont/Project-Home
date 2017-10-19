package Notepad;

public enum NotepadConst {

    NOTE, REMINDER, FILENOTE, FILEREMINDER;

    private String path = null;

    public String filePath(){
        switch (this) {
            case FILENOTE: {
                path = "resources/Note.txt";
                return path;
            }
            case FILEREMINDER: {
                path = "resources/Reminder.txt";
                return path;
            }
        }
        return path;
    }
}
