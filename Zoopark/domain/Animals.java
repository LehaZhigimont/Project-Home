package domain;


public abstract class Animals {
    private String name;
    private int weight;
    private int age;
    private char sex;
    private long id;

    public Animals(){
        this.id=this.id*(int)Math.random()*9999;
        this.name ="Noname";
        this.age = (int) (Math.random()*5);
        if((int)Math.random()>0.5){
            this.sex='M';
        }else this.sex='F';
        this.weight=(int)(Math.random()*20);
    }

    public Animals(char sex){
        this.id=this.id*(int)Math.random()*9999;
        this.name ="Noname";
        this.age = (int) (Math.random()*5);
        this.sex = sex;
        this.weight=(int)(Math.random()*20);
    }

    public Animals(String name, char sex){
        this.id=this.id*(int)Math.random()*9999;
        this.name = name;
        this.age = (int) (Math.random()*5);
        this.sex=sex;
        this.weight=(int)(Math.random()*20);
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }


    public int getAge() {
        return age;
    }

    public char getSex() {
        return sex;
    }


}
