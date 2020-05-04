 

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

//Aventure Game, all methods to run the game

public class Game {
    //behaviour is chosen from this array of String
    String[] behave = new String[]{
    "smart","mean","weird","charming","helpful",
        "lazy","volatile"};
    Random random = new Random();
    String name;
    Scanner scanner;
    String enemy;
    Heroes player;
    Drops drop = new Drops();
    File file = new File("savefile.txt");
    //creating players
    public void makeCharacters(){
        name = input("Name of the player: ");
        String behaviour =behave[random.nextInt(behave.length)];
        player = new Heroes(name,30,behaviour);
    }
    
    //Welcome Message
    public void WelcomeMessage(){
        print("Welcome Player!");
        print("This is a 5 Stage Adventure game, where you fight the Mosters in each stage");
        print("The difficutly of the stage increase as you go to higher stages");
        print("The 5th Stage, is the Boss Stage");
        print("Defeat the Boss and you cleared the game");
        print("Good Luck!");
    }
    
    //End Message
    public void exit(){
        print("Thanks for playing my adventure game. Good Bye");
        System.exit(0);
    }
    
    //level 1 of the game, use of polymorphism
    public void level1(){
        print("Ok "+name+", you're in Stage 1, defeat the monster and advance to the next level");
        int rgen = random.nextInt(15);
        
        //polymorphism and dynamic binding
        Monsters zombie = (Math.random()>5)? zombie = new Zombie("Zombie", rgen,"undead"):
                new Zombie("Zombie",rgen+2,"undead");
        
        
        print("test "+rgen);
        print("Stage 1: Kill the Zombies to advance!");
        print("The zombie has a strengh of "+zombie.getStrength());
        int advance = option(zombie);//passing the object using its superclass type, polymorphism
        if(advance==2){
            level2();
        }
    }
    
    //level 2 of the game, use of polymorphism
    public void level2(){
        print("Congrats "+name+", you have completed stage 1. Defeat the monsters to advance!");
        int rgen = random.nextInt(20);
        
        //polymorphism and dynamic binding
        Monsters witch = (Math.random()>5)? witch = new Witch("Witch", rgen,"undead"):
                new Witch("Zombie",rgen+2,"undead");
        
        print("Stage 2: Kill the Witch to advance");
        print("The witch has a strength of "+witch.getStrength());
        int advance = option(witch);//passing the object using its superclass type, polymorphism
        if(advance==2){
            level3();
        }
    }
    
    //level 3 of the game, use of polymorphism
    public void level3(){
        print("Congrats "+name+", you have completed stage 2. Defeat the monsters to advance!");
        int rgen = random.nextInt(30);
        
        //polymorphism and dynamic binding
        Monsters demon = (Math.random()>5)? demon = new Demon("Demon", rgen,"Strong"):
                new Demon("Demon",rgen+2,"Strong");
        print("Stage 3: Kill the demon to advance!");
        print("The demon has a strength of "+demon.getStrength());
        int advance = option(demon);//passing the object using its superclass type, polymorphism
        if(advance==2){
            level4();
        }
    }
    
    //level 4 of the game, use of polymorphism
    public void level4(){
        print("Congrats "+name+", you have completed stage 3. Defeats the monsters to advance!");
        int rgen = random.nextInt(40);
        
        //polymorphism and dynamic binding
        Monsters shadow = (Math.random()>5)? shadow = new Shadow("Shadow Warrior", rgen,"crafty"):
                new Shadow("Shadow Warrior",rgen+2,"crafty");
        print("Stage 4: Kill the Shadow Warrior to advance");
        print("The Shadow Warrior has a strength of "+shadow.getStrength());
        int advance = option(shadow);//passing the object using its superclass type, polymorphism
        print("test "+advance);
        if(advance==2){
            level5();
        }
    }
    
    //level 4 of the game, use of polymorphism
    public void level5(){
        print("Congrats "+name+", you have completed stage 4. Defeat the boss to complete the game!");
        Monsters one = new DemonKing("Demon King",45+random.nextInt(6),"crafty");
        int end = optionfinal(one);
        if(end==2){
            print("You have cleared the game, congrats");
            exit();
        }
    }
    
    //final Boss options
    public int optionfinal(Monsters a){
        int result=0;
        print("What do you wish to do:");
        print("1: Fight");
        print("2: Check inventory");
        print("3: Quit");
        String input= scanner.nextLine();
        
        while(!input.equals("1") && !input.equals("2") && !input.equals("3")){
            print("Sorry that command is not recognised, please enter 1,2 or 3");
            input = scanner.nextLine();
        }
        if(input.equals("1")){
            result=fight(a);
            if(result==1){
                System.out.println("You killed the demon king!!!");
            }
            else if(result<0){
                print("you died");
                exit();
            }
        }
            
        else if(input.equals("2")){
            inventory();
            optionfinal(a);
        }
        else{
            exit();
        }
        result=2;
        return result;
    }
    
    //options use of polymorphism to pass the arguments 
    public int option(Monsters a){
        int result=0;
        print("What do you wish to do:");
        print("1: Fight");
        print("2: Check inventory");
        print("3: Quit");
        String input= scanner.nextLine();
        
        while(!input.equals("1") && !input.equals("2") && !input.equals("3")){
            print("Sorry that command is not recognised, please enter 1,2 or 3");
            input = scanner.nextLine();
        }
        if(input.equals("1")){
            result = fight(a);
            
            while(result!=2){
                if(result==1){
                    if(a.isDead(a)){
                        print("You have killed "+a.getName());
                        result =2;
                    }
                
                }
                else if(result<0){
                    print("You died");
                    exit();
                }
            }
        }
        else if(input.equals("2")){
            inventory();
            option(a);
        }
        else{
            exit();
        }
        result=2;
        return result;
    }
    
    //use of polymorphism
    public int fight(Monsters a){
        int attack =0;
        int result=player.fight(a);
        if(result==1){
            a.damageTaken(player, a);
            if(a.isDead(a)==true){
                print("You have killed the monster");
                a.die();
                int dropchance = random.nextInt(11);
                if(dropchance<5){
                    String d = drop.getDrop();
                    print("The "+a.getName()+" has dropped a "+d);
                    drop.adddrops(d);
                }
            }
            else{
                print("The monster hp is " + a.getHealth(a));
                
                if(random.nextInt(10)>5){
                    print("The monster has attacked you!");
                    attack = a.fight(player);
                    if(attack==1){
                       player.damageTaken(player, a);
                       if(player.isDead()){
                           print("You died");
                           exit();
                       }
                    }
                    else{
                        print("You have taken damage!");
                        print("You health is "+player.getHP());
                    }
                }  
            }
        }
        else if(result==0){
            print("Both yours and the monster strength is equal");
            
        }
        else if(result<0){
            print("You died");
            exit();
        }
        return result;
    }
    
    //inventory
    public void inventory(){
        if(drop.inventorySize()!=0){
            dropOption(drop);
        }else{
            print("You do not have anything in the inventory");
        }
    }
    public void dropOption(Drops drops){
        print("You have the followings in the inventory:");
        for(String d: drops.inventory()){
            System.out.println(d);
        }
        print("Choose what you would like to consume (write exit to go back)");
        String consume = scanner.nextLine();
        if(!consume.equalsIgnoreCase("exit")){
            Heroes p =(Heroes) player;
            p.consume(consume);
            drop.useDrops(consume);
            print("You have successfully cosumed "+ consume);
            print("Your strength is: "+p.getStrength());
            print("You health is "+p.getHP());
        }
        
    }
    public void savedata(){
         
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(player.getStrength()+"\n");
            bw.write(player.getHP()+"\n");
            
            
            bw.close();
        }
        catch (java.io.FileNotFoundException e){}
        catch (java.io.IOException e){}
    }
    
    public String input(String message){
        scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
    public void print(String message){
        System.out.println(message);
    }
    public int inputint(String message){
        return Integer.parseInt(input(message));
    }
}
