import java.util.*;

//subclass of Character
public class Monsters extends Character{
    private int[] health;
    private boolean dead;
    private String[] undead;
    Random random = new Random();
    private Boolean[] d;
    
    public Monsters(String name, int strength, String behaviour){
        super(name, strength, behaviour);
        this.health=new int[6];
        this.dead=false;
        this.undead = new String[6];
        d = new Boolean[]{false,false,false,false,false,false};
    }
    
    public void die(){
        this.dead = true;
    }
    
    public boolean isDead(Monsters m){
        int pos =0;
        for(int i =0;i<undead.length;i++){
            if(m.getName().equals(undead[i]))
                pos=i;
        }
        return d[pos];
    }
    
    //setters and getters methods
    public void addUndead(Monsters monter){
        this.undead[0]="Zombies";
        this.undead[1]="Witch";
        this.undead[2]="Demon";
        this.undead[3]="Shadow Warrior";
        this.undead[4]="Demon King";
        
    }
    
    public String getUndead(int value){
        return undead[value];
    }
    public void addHealth(){
        this.health[0]=20;
        this.health[1]=30;
        this.health[2]=40;
        this.health[3]=50;
        this.health[4]=110;
        
    }
   
    public int getHealth(Monsters a){
        int pos =0;
        for(int i =0;i<undead.length;i++){
            if(a.getName().equals(undead[i]))
                pos=i;
        }
        return health[pos];
    }
    
    public void damageTaken(Heroes hero, Monsters m){
        int pos =0;
        for(int i =0;i<undead.length;i++){
            if(m.getName().equals(undead[i]))
                pos=i;
        }
        
        this.health[pos]-=hero.getStrength();
        
        if(this.health[pos]<0)d[pos]=true;
         
        }
    
    //overriden method in the superclass
    @Override
    public int fight(Character c){
       int result=0;
        
        result = super.fight(c);
        if(result==1){
            System.out.println("You have greater strength than "+c.getName()+", so you dealt damage");
        }
        
        if(result<0){
            this.die();
        }
        return result;
    }
    }
