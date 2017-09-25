import java.util.*;

public class ManySet{
    private  HashSet<People> Stado = new HashSet<People>();
    private  Set<People> Child = new HashSet<>();
    private  Set<People> Junior = new HashSet<>();
    private  Set<People> Adult = new HashSet<>();
    private  Set<People> Old = new HashSet<>();
    private  HashMap SortAge = new HashMap();
    private String child = "child000";
    private String junior = "junior000";
    private String adult = "adult000";
    private String old = "old000";


    public void ManySet(){
        People men;
        /*
        Создание стада людей разного пола и возраста
         */
        for (int i = 0; i<60; i++){
            men = new People();
            Stado.add(men);
        }

        Iterator<People> s = Stado.iterator();

        /*
        Создаем множество множеств в мапе и делаем уникальные ключи
        соответствующие возрасту нашего стада
         */
        while(s.hasNext()){
            People o = s.next();
            if(o.getAge()<18){
                    child = addNumber(child);
                    o.setKey(child);
                    SortAge.put(o.getKey(), o);
                    o.toString(child);
            }else if(o.getAge()<30){
                    junior = addNumber(junior);
                    o.setKey(junior);
                    SortAge.put(junior, o);
                    o.toString(junior);
            }else if(o.getAge()<60){
                    adult = addNumber(adult);
                    o.setKey(adult);
                    SortAge.put(adult, o);
                    o.toString(adult);
            }else if(o.getAge()>=60){
                    old = addNumber(old);
                    o.setKey(old);
                    SortAge.put(old, o);
                    o.toString(old);
            }
        }
    }
    /*
    Этот метод генерирует уникальные ключи для разного возраста,
    чтобы все ключи шли по порядку в своей категории.
    */
    private String addNumber (String ageAdd){
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

    /*
    Создание списков с ключами по возрасту и выводом их по порядку,
    чтобы можно было ими оперировать в дальнейшем
     */
    private void NoteKey (People o){
        if(o.getKey().contains("child")){
            Child.add(o);
        }else if(o.getKey().contains("junior")){
            Junior.add(o);
        }else if(o.getKey().contains("adult")){
            Adult.add(o);
        }else if(o.getKey().contains("old")){
            Old.add(o);
        }
    }
}
