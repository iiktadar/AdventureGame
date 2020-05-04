 
public class Witch extends Monsters{
    private int health;
    private int damageTaken;
    private int damageOut;
    
    public Witch(String name, int strength, String behaviour){
        super(name,strength,behaviour);
        this.health = 35;
    }
    
    public int getHealth(){
        return this.health;
    }
    
    //overrides method in monster
    @Override
    public int fight(Character c){
        int result = super.fight(c);
        if(result<0){
            super.die();
        }
        return result;
    }
}
