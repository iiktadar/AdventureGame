 
import java.util.*;
public class Heroes extends Character {
    private int hp;
    private boolean death;
    private int consume;
    
    Random random=new Random();
    
    public Heroes(String name, int strength, String behaviour){
        super(name,strength,behaviour);
        this.hp=100;
        
    }
    
    //overrides getter method in character
    @Override
    public int getStrength(){
        return super.getStrength();
    }
    
    //getters and setters method
    public int getHP(){
        return this.hp;
    }
    public void die(){
        this.death = true;
    }
    
    public boolean isDead(){
        return this.death;
    }
    
    public void consume(String drop){
        if(drop.equalsIgnoreCase("strengthpotion")){
            super.setStrength(5);
         
            }
        else if(drop.equals("Super Strength potion")){
            super.setStrength(15);
            
        }
        
        else if(drop.equalsIgnoreCase("rotten mushrooms")){
            super.setStrength(-5);
            
        }
        else if(drop.equalsIgnoreCase("healthpotion")){
            if(this.hp+20>100){
                this.hp=100;
            }
            else{
                this.hp+=20;
            }
        }
        else if(drop.equalsIgnoreCase("Super Health Potion")){
            if(this.hp+50>100){
                this.hp=100;
            }
            else{
                this.hp+=50;
            }
        }
        else{
            super.setStrength(-3);
            
        }
    }
    public void damageTaken(Heroes h , Monsters m){
            this.hp -= m.getStrength();
            if(this.hp<0){
                this.die();
            }
    }
    
    //overrides fight in character
    @Override
    public int fight(Character c){
        int result=0;
        
        result = super.fight(c);
        if(result>=1){
            System.out.println("You have greater strength than "+c.getName()+", so you dealt damage");
        }
        
        if(result<0){
            this.hp-= c.getStrength();
            this.die();
        }
        return result;
    }
    
    //overrides toString in character
    @Override
    public String toString(){
        if(isDead()){
            return super.toString()+ " is dead";
        }
        else{
            return super.toString();
        }
    }
    
    
}
