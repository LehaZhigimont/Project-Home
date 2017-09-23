package domain;

public class Cats extends Animals{

    private int lenghtFangs;
    private int lenghtTail;

    public Cats(){
        super();
        this.lenghtFangs = (int)Math.random()*20;
        this.lenghtTail = (int)Math.random()*40;
    }

    public Cats(char sex){
        super(sex);
        this.lenghtFangs = (int)Math.random()*20;
        this.lenghtTail = (int)Math.random()*40;
    }

    public Cats(String name, char sex){
        super(name, sex);
        this.lenghtFangs = (int)Math.random()*20;
        this.lenghtTail = (int)Math.random()*40;
    }

    public int getLenghtFangs() {
        return lenghtFangs;
    }
    public int getLenghtTail() {
        return lenghtTail;
    }
}
