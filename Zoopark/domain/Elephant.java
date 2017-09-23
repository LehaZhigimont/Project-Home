package domain;

import java.util.*;

public class Elephant extends Animals {

    private int lenghtHodot;

    public Elephant(){
        super();
        this.lenghtHodot = (int)Math.random()*50;
    }

    public Elephant(char sex){
        super(sex);
        this.lenghtHodot = (int)Math.random()*50;
    }

    public Elephant(String name, char sex){
        super(name, sex);
        this.lenghtHodot = (int)Math.random()*50;
    }

    public int getLenghtHodot() {
        return lenghtHodot;
    }
}
