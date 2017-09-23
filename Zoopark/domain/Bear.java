package domain;

public class Bear extends Animals {

    private int lenghtClaws;

    public Bear(){
        super();
        this.lenghtClaws = (int)(Math.random()*15);
    }

    public Bear(char sex){
        super(sex);
        this.lenghtClaws = (int)(Math.random()*15);
    }

    public Bear(String name, char sex){
        super(name, sex);
        this.lenghtClaws = (int)(Math.random()*15);
    }


    public int getLenghtClaws() {
        return lenghtClaws;
    }
}
