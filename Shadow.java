 
public class Shadow extends Monsters{
    private int health;
    private int damageTaken;
    private int damageOut;
    
    public Shadow(String name, int strength, String behaviour){
        super(name,strength,behaviour);
        this.health = 70;
    }
    
    public int getHealth(){
        return this.health;
    }
    public void setHealth(int hp){
        this.health -=hp;
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
