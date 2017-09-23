import domain.*;

import java.util.*;


public class Zoopark{
    private Scanner input = new Scanner(System.in);
    private static List<String> param = new LinkedList<String>();
    private Set AnimalsZoo = new HashSet<>();
    private String currentSelect;


    public void Zoopark () {
        System.out.println("Welcom to Zoopark!");
        System.out.println("Now your zoo is empty!");
        while(true) {
            System.out.println("What do you want to do?");
            System.out.println("1.Let's add some other animal!");
            if(!AnimalsZoo.isEmpty()){
                System.out.println("2.Feed the animal.");
                System.out.println("3.Kill the animal.");
                System.out.println("4.View all animals.");
                System.out.println("5.Close Zoopark!");
            }else {
                System.out.println("2.Close Zoopark!");
            }
            currentSelect = input.nextLine();
            DialogMenu(currentSelect);
        }
    }


    private void DialogMenu(String select){
        switch (select){
            case "1":{
                bornToAnimal();
                break;
            }
            case "2":{
                if(!AnimalsZoo.isEmpty()){
                    feedAnimal();
                    break;
                }else {
                    System.out.println("Zoopark is closed!");
                    System.out.println("Bye-Bye");
                    System.exit(0);
                }
            }
            case "3":{
                bornToAnimal();
                break;
            }
            case "4":{
                bornToAnimal();
                break;
            }
            case "5":{
                if(!AnimalsZoo.isEmpty()) {
                    System.exit(0);
                }else{
                    return;
                }
            }
        }
    }



    private void bornToAnimal(){
        String choice=null;
        System.out.println("Let's add some other animal!");
        System.out.println("1.Tiger");
        System.out.println("2.Lion");
        System.out.println("3.Elephant");
        System.out.println("4.Panda");
        System.out.println("5.Grizzly");
        System.out.println("6.Back to menu");
        choice = input.nextLine();
        if(!choice.equals("6")){
        dialogBornToBeast();
        }else {
            return;
        }
        switch (choice){
            case "1":
                {
                    if(!param.get(0).equals(null)){
                        Cats tigr = new Tiger(param.get(0),param.get(1).charAt(0));
                        AnimalsZoo.add(tigr);
                        System.out.println("Наверное создалса");
                        return;
                    }else if(!param.get(1).equals(null)){
                        Cats tigr = new Tiger(param.get(1).charAt(0));
                        AnimalsZoo.add(tigr);
                        System.out.println("Наверное создалса");
                        return;
                    }else return;
                }
            case "2":
                {
                    if(!param.get(0).equals(null)){
                        Cats lion = new Lion(param.get(0),param.get(1).charAt(0));
                        AnimalsZoo.add(lion);
                        System.out.println("Наверное создалса");
                        return;
                    }else if(!param.get(1).equals(null)){
                        Cats lion = new Lion(param.get(1).charAt(0));
                        AnimalsZoo.add(lion);
                        System.out.println("Наверное создалса");
                        return;
                    }else return;
            }
            case "3":
                {
                    if(!param.get(0).equals(null)) {
                        Animals elephant = new Elephant(param.get(0), param.get(1).charAt(0));
                        AnimalsZoo.add(elephant);
                        System.out.println("Наверное создалса");
                        return;
                    }else if(!param.get(1).equals(null)){
                        Animals elephant = new Elephant(param.get(1).charAt(0));
                        AnimalsZoo.add(elephant);
                        System.out.println("Наверное создалса");
                        return;
                    }
                }
            case "4":
                {

                    if(!param.get(0).equals(null)) {
                        Bear panda = new Panda(param.get(0), param.get(1).charAt(0));
                        AnimalsZoo.add(panda);
                        System.out.println("Наверное создалса");
                        return;
                    }else if(!param.get(1).equals(null)){
                        Bear panda = new Panda(param.get(1).charAt(0));
                        AnimalsZoo.add(panda);
                        System.out.println("Наверное создалса");
                        return;
                    }else return;
                }
            case "5":
                {

                    if(!param.get(0).equals(null)){
                        Bear grizzly = new Grizzly(param.get(0),param.get(1).charAt(0));
                        AnimalsZoo.add(grizzly);
                        System.out.println("Наверное создалса");
                        return;
                    }else if(!param.get(1).equals(null)){
                        Bear grizzly = new Grizzly(param.get(1).charAt(0));
                        AnimalsZoo.add(grizzly);
                        System.out.println("Наверное создалса");
                        return;
                    }else return;
                }
            case "6": {return;}
        }
    }



    private void dialogBornToBeast (){
        String value = null;
        param.clear();
        System.out.println("If you want, you can give him a name, sex!");
        System.out.println("Else, enter '0' and created random beast!");
        System.out.println("Enter his name: ");
        //input.nextLine();
        value = input.nextLine();
        if(!value.equals("0")){
            param.add(0,""+value);
        }else{
           param.add(0,null);
        }
        System.out.println("Enter his sex(M or F): ");
        value = input.nextLine();
        if(!value.equals("0")){
            param.add(1,""+value);
        }else{
        param.add(1,null);
        }
        System.out.println(param + "exit to param!");
    }

    private void feedAnimal(){

    }
}
