
public class People {
    private final String[] ALLNAME = {"Вова", "Петя", "Дима", "Вася", "Максим",
            "Артём", "Саня", "Лёха", "Игорь", "Витя", "Гена", "Егор", "Олег", "Эдгар",
            "Коля", "Сергей", "Илья", "Никита", "Роберт", "Тимур", "Федя", "Чарльз",
            "Маша", "Оля", "Наташа", "Ира", "Таня", "Юля", "Диана", "Даша",
            "Кристина", "Тоня", "Вика", "Алиса", "Аня","Варвара", "Жанна",
            "Инна", "Ксения", "Карина", "Люда", "Лена", "Нина", "Роза"};
    private final String[] MALENAME = {"Вова", "Петя", "Дима", "Вася", "Максим",
            "Артём", "Саня", "Лёха", "Игорь", "Витя", "Гена", "Егор", "Олег", "Эдгар",
            "Коля", "Сергей", "Илья", "Никита", "Роберт", "Тимур", "Федя", "Чарльз"};
    private final String[] FEMALENAME = {"Маша", "Оля", "Наташа", "Ира", "Таня", "Юля", "Диана", "Даша",
            "Кристина", "Тоня", "Вика", "Алиса", "Аня","Варвара", "Жанна",
            "Инна", "Ксения", "Карина", "Люда", "Лена", "Нина", "Роза"};
    private String name;
    private char sex;
    private int age;
    private int weight;
    private int height;

    public People(){
        this.name = ALLNAME[(int)(1+Math.random()*40)];
        this.sex = getSex(name);
        this.age = (int)(1+Math.random()*80);
        this.weight = (int)(25+Math.random()*100);
        this.height = (int)(120+Math.random()*80);
    }


    /*
    Перезагруженный метод toString для вызова сокращенной версии
    с минимальными параметрами. Принимает значение String для
    уточнения к какому возрасту относится человек
     */
    public String toString(String age){
        if(age.contains("child")){
            if(getSex()=='M'){
                System.out.println("Мальчик " + getName() + ", ему " + getAge() + " лет");
            }else {
                System.out.println("Девочка " + getName() + ", ей " + getAge() + " лет,");
            }
        }else if(age.contains("junior")){
            if(getSex()=='M'){
                System.out.println("Юноша " + getName() + ", ему " + getAge() + " лет");
            }else {
                System.out.println("Девушка " + getName() + ", ей " + getAge() + " лет");
            }
        }else if(age.contains("adult")) {
            if (getSex() == 'M') {
                System.out.println("Мужчина " + getName() + ", ему " + getAge() + " лет");
            } else {
                System.out.println("Женщина " + getName() + ", ей " + getAge() + " лет");
            }
        }else if(age.contains("old")) {
            if (getSex() == 'M') {
                System.out.println("Дедушка " + getName() + ", ему " + getAge() + " лет");
            } else {
                System.out.println("Бабушка " + getName() + ", ей " + getAge() + " лет");
            }
        }
        return "";
    }

    /*
    Переопределен метод toString - подробная версия
     */
    public String toString(){
        if(getAge()<18){
            if(getSex()=='M'){
                System.out.println("Мальчик " + getName() + ", ему "
                        + getAge() + " лет, его рост и вес " + getHeight() + " / " +getWeight());
            }else {
                System.out.println("Девочка " + getName() + ", ей "
                        + getAge() + " лет, её рост и вес " + getHeight() + " / " +getWeight());
            }
        }else if(getAge()>17 && getAge()<30){
            if(getSex()=='M'){
                System.out.println("Юноша " + getName() + ", ему "
                        + getAge() + " лет, его рост и вес " + getHeight() + " / " +getWeight());
            }else {
                System.out.println("Девушка " + getName() + ", ей "
                        + getAge() + " лет, её рост и вес " + getHeight() + " / " +getWeight());
            }
        }else if(getAge()>29 && getAge()<60) {
            if (getSex() == 'M') {
                System.out.println("Мужчина " + getName() + ", ему "
                        + getAge() + " лет, его рост и вес " + getHeight() + " / " + getWeight());
            } else {
                System.out.println("Женщина " + getName() + ", ей "
                        + getAge() + " лет, её рост и вес " + getHeight() + " / " + getWeight());
            }
        }else if(getAge()>59 && getAge()<160) {
            if (getSex() == 'M') {
                System.out.println("Дедушка " + getName() + ", ему "
                        + getAge() + " лет, его рост и вес " + getHeight() + " / " + getWeight());
            } else {
                System.out.println("Бабушка " + getName() + ", ей "
                        + getAge() + " лет, её рост и вес " + getHeight() + " / " + getWeight());
            }
        }
        return " ";
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }






    /*
    По имени определяет пол человека
     */
    private char getSex (String name){
        char result = 'M';
        for(int i=0; i<MALENAME.length; i++){
            if(MALENAME[i].equals(name)){
                result = 'M';
                break;
            }else {
                result = 'F';
            }
        }
        return result;
    }


}
