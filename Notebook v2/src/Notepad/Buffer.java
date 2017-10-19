package Notepad;

import java.util.Scanner;

public class Buffer {
    private static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) {
        String a = scr.nextLine();
        System.out.println(a);
        StringBuilder gl = new StringBuilder(
        "=============================\n" +
        "|        ГЛАВНОЕ МЕНЮ       |\n" +
        "=============================\n" +
        "|1. Меню заметок            |\n" +
        "|2. Меню напоминаний        |\n" +
        "|3. Выход                   |\n" +
        "=============================\n" +
        "Сделай свой выбор же наконец:\n");
        System.out.println(gl);
        a = scr.nextLine();
        System.out.println(a);
        System.out.println("А теперь проверим стрынги:");
        gl.delete(0,gl.length());
        a = scr.nextLine();
        System.out.println(a);
        StringBuilder gl2 = new StringBuilder(
                        "=============================\n" +
                        "|1. Меню заметок            |\n" +
                        "|2. Меню напоминаний        |\n" +
                        "|3. Выход                   |\n" +
                        "=============================");
        System.out.println(gl2);
        a = scr.nextLine();
        System.out.println(a);
        System.out .println("Удалить все нафик!");
        a = scr.nextLine();
        System.out.println(a);
        gl2.delete(0, gl2.length());
        a = scr.nextLine();
        System.out.println(a);
        System.out.println("Bye-bey");

    }
}
