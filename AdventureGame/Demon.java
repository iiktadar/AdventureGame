 
public class Demon extends Monsters{
    private int health;
    private int damageTaken;
    private int damageOut;
    
    public Demon(String name, int strength, String behaviour){
        super(name,strength,behaviour);
        this.health = 26;
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
