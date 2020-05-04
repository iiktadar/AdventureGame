 
import java.util.*;
public class Drops {
    String[] drops = new String[]
    {"Super Strength potion","strenghtpotion", 
        "rotten mushrooms","zombie flesh","healthpotion"
            ,"Super Health Potion"
    };
    private ArrayList<String> storage;
    private int dropnum;
    Random random = new Random();
    
    public Drops(){
        dropnum=0;
        storage = new ArrayList<String>();
    }
    
    //using a ramdomizer we get any random drops
    public String getDrop(){
        String drop = drops[random.nextInt(drops.length)];
        return drop;
    }
    
    //setters and getters
    public int getNum(){
        return this.dropnum;
    }
    public void adddrops(String d){
        this.storage.add(d);
    }
    public void useDrops(String drop){
        this.storage.remove(drop);
    }
    public int inventorySize(){
        return this.storage.size();
    }
    public ArrayList<String> inventory(){
        return this.storage;
    }
    
}
