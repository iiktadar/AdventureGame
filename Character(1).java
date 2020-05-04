 
import java.util.*;

//super class
public class Character {
    private String name;
    private int strength;
    private String behaviour;
    
    public Character(String name, int strength, String behaviour){
        this.name=name;
        this.strength=strength;
        this.behaviour=behaviour;
    }
    
    //getters
    public String getName(){
        return this.name;
    }
    public int getStrength(){
        return this.strength;
    }
    public String getBehaviour(){
        return this.behaviour;
    }
    
    //method that gets overrriden
    public int fight(Character c){
        int difference = this.strength-c.strength;
        if(difference>0){
            return 1;
        }
        else if(difference==0){
            return 0;
        }
        else{
            return -1;
        }
    }
    
    //setters
    public void setStrength(int S){
        this.strength+=S;
    }
    
    @Override //overriding toString method
    public String toString(){
        return "Character name: "+this.getName()+"\nStrength: "+this.getStrength();
    }
}
