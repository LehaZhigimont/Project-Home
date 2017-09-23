import java.util.*;

public class ValueIn {
    private static Scanner input = new Scanner(System.in);
    private static String example;
    private static boolean test = false;
    /*
    Данный метод принимает строку примера и
    вызывает метод inValid для проверки его на
    корректность.
    Имеет переменную типа String example.

     */
    public static void Value (){
        ArrayList <String> StringCalculator = new ArrayList();
        while(!test) {
            System.out.println("Enter your example:");
            example = input.nextLine();
            inValid(example);
        }
        System.out.println(test);
        System.out.println(example);
    }
    /*
    Данный метод принимает значение типа String и
    проверяет его на корректность ввода значения
    и возвращает true или false.
     */
    private static boolean inValid (String value){
        char[] array;
        array = value.toCharArray();
        for (int i = 0; i < array.length; i++) {
            for (char j = 1; j < 255; j++) {
                if (j <= 39 && j >= 58) {
                    if (j == array[i]) {
                        System.out.println(j);
                        test = false;
                        return test;
                    }
                }
                if (j >= 40 && j <= 57 || j==136) {
                    if (j == array[i]) {
                        test = true;
                    }
                }
            }
        }
        System.out.println(test);
        return test;
    }

}
