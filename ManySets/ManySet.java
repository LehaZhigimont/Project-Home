import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ManySet{

    public static void main(String[] args){
        HashSet<People> Stado = new HashSet<People>();
        HashMap SortAge = new HashMap();
        People men;
        for (int i = 0; i<60; i++){
            men = new People();
            Stado.add(men);
        }

        Iterator<People> s = Stado.iterator();
        String child = "child000";
        String junior = "junior000";
        String adult = "adult000";
        String old = "old000";

        while(s.hasNext()){
            People o = s.next();
            if(o.getAge()<18){
                    child = addNumber(child);
                    SortAge.put(child, o);
                    System.out.print("key - " + child + "  ||| ");
                    o.toString(child);
            }else if(o.getAge()<30){
                junior = addNumber(junior);
                    SortAge.put(junior, o);
                    System.out.print("key - " + junior + "  ||| ");
                    o.toString(junior);
            }else if(o.getAge()<60){
                adult = addNumber(adult);
                    SortAge.put(adult, o);
                 System.out.print("key - " + adult + "   ||| ");
                 o.toString(adult);
            }else if(o.getAge()>=60){
                    old = addNumber(old);
                    SortAge.put(old, o);
                    System.out.print("key - " + old + "     ||| ");
                    o.toString(old);
            }
        }


    }
    /*
    Этот метод принимает значение ключа и возвращает его на +1 больше,
    чтобы все ключи ишли по порядку в своей категории.
    */
    private static String addNumber (String ageAdd){
        int i = Integer.parseInt(ageAdd.substring(ageAdd.length()-2, ageAdd.length()));
        i++;
        if(i<100){
            if(i<10){
                return ageAdd = ageAdd.substring(0, ageAdd.length()-1) + i;
            }else {
                return ageAdd = ageAdd.substring(0, ageAdd.length()-2) + i;
            }
        }
        return ageAdd = ageAdd.substring(0, ageAdd.length()-3) + i;
    }
}
