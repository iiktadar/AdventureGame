 

//Used java awt,swing,io and util library

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;


//UserInterface: 
//GUI, Load/Save, Collection classes, ActionListener Classes

//
public class UserInterface {
    //UI methods, to create the UserInteface
    private JFrame frame;
    Container container;
    
    //Font for the text inside the GUI
    Font titleFont = new Font("Time New Roman",Font.PLAIN,78);
    Font normalFont = new Font("Times New Roman",Font.PLAIN,28);
    
    //Handler to listen to user interaction and perform actions
    TitleHandler titleHandle = new TitleHandler();
    inventoryHandler ihandler = new inventoryHandler();
    choiceHandler cHandler = new choiceHandler();
    
    //UserInterface Widgets to display and interact 
    JPanel title, startButton, choiceButtonPanel, levelPanel, inventoryPanel;
    JTextArea textArea;
    JLabel titleName, stageLabel, stageNumber, strengthLabel, hpLabel, strengthNumber, hpNumber;
    JButton start,continueButton, choice1, choice2, choice3, inventoryButton, item1, item2, item3;
    
    //integer and string values to hold different data
    int stage, strength, hp, mhp1, mhp2, mhp3, mhp4, mhp5, mstr1, mstr2, mstr3, mstr4, mstr5;
    String pos, inventoryStatus;
    
    //Collection classes to implement the inventory
    String[] drops = new String[]{"STR potion","zombie flesh","Health potion"};
    ArrayList<String> items = new ArrayList<String>();
    
    //randomiser to randomise some values
    Random random = new Random();
    
    //File IO, to save and load data into a text file
    File file = new File("save.txt");
    
    
    //Main method to run the GUI
    public static void main(String[] args){
        new UserInterface();
    }
    
    public UserInterface(){
        
        //JFrame created
        frame = new JFrame("Adventure Game");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        frame.setVisible(true);
        container = frame.getContentPane();
        
        //creating JPanel and JLabel to store and display data
        title = new JPanel();
        title.setBounds(100,100,600,150);
        title.setBackground(Color.black);
        
        titleName = new JLabel("Adventure Game");
        titleName.setForeground(Color.white);
        titleName.setFont(titleFont);
        
        startButton = new JPanel();
        startButton.setBounds(300,400,200,100);
        startButton.setBackground(Color.black);
        
        //creating GUI widget JButton for user to interact with the GUI
        start = new JButton("START");
        start.setBackground(Color.black);
        start.setForeground(Color.white);
        start.setFont(normalFont);
        start.setFocusPainted(false);
        start.setBorder(null);
        start.setActionCommand("start");
        start.addActionListener(titleHandle);
        
        continueButton = new JButton("CONTINUE");
        continueButton.setBackground(Color.black);
        continueButton.setForeground(Color.white);
        continueButton.setFont(normalFont);
        continueButton.setFocusPainted(false);
        continueButton.setBorder(null);
        continueButton.setActionCommand("continue");
        continueButton.addActionListener(titleHandle);
        
        
        title.add(titleName);
        startButton.add(start);
        startButton.add(continueButton);
        
        container.add(title);
        container.add(startButton);
        
        
    }
    
    public void gameScreen(String sc){
        
        //main game screen, this method initialises different GUI widgets and panels thar
        //are displayed in the main game screen
        title.setVisible(false);
        startButton.setVisible(false);
        
        JPanel mainText = new JPanel();
        mainText.setBounds(100,100,600,250);
        mainText.setBackground(Color.black);
        container.add(mainText);
        
        //main text area that changes as we go through the game being initialised
        textArea = new JTextArea();
        textArea.setBounds(100,100,600,250);
        textArea.setBackground(Color.black);
        textArea.setForeground(Color.white);
        textArea.setFont(normalFont);
        textArea.setLineWrap(true);
        mainText.add(textArea);
        
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250,350,300,150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        container.add(choiceButtonPanel);
        
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        
        //seperate panel for the inventory and buttons being initialised
        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(550,350,200,150);
        inventoryPanel.setBackground(Color.black);
        inventoryPanel.setLayout(new GridLayout(3,1));
        container.add(inventoryPanel);
        
        inventoryButton = new JButton("Inventory");
        inventoryButton.setBackground(Color.black);
        inventoryButton.setForeground(Color.orange);
        inventoryButton.setFont(normalFont);
        inventoryButton.setFocusPainted(false);
        inventoryButton.addActionListener(ihandler);
        inventoryButton.setActionCommand("inventoryButton");
        choiceButtonPanel.add(inventoryButton);
        
        item1 = new JButton();
        item1.setBackground(Color.black);
        item1.setForeground(Color.white);
        item1.setFont(normalFont);
        item1.setFocusPainted(false);
        item1.addActionListener(ihandler);
        item1.setActionCommand("item1");
        inventoryPanel.add(item1);
        
        item2 = new JButton();
        item2.setBackground(Color.black);
        item2.setForeground(Color.white);
        item2.setFont(normalFont);
        item2.setFocusPainted(false);
        item2.addActionListener(ihandler);
        item2.setActionCommand("item2");
        inventoryPanel.add(item2);
        
        item3 = new JButton();
        item3.setBackground(Color.black);
        item3.setForeground(Color.white);
        item3.setFont(normalFont);
        item3.setFocusPainted(false);
        item3.addActionListener(ihandler);
        item3.setActionCommand("item3");
        inventoryPanel.add(item3);
        
        inventoryPanel.setVisible(false);
        
        levelPanel = new JPanel();
        levelPanel.setBounds(100,15,600,50);
        levelPanel.setBackground(Color.black);
        levelPanel.setLayout(new GridLayout(1,6));
        container.add(levelPanel);
        
        stageLabel = new JLabel("Stage:");
        stageLabel.setFont(normalFont);
        stageLabel.setForeground(Color.white);
        levelPanel.add(stageLabel);
        
        stageNumber = new JLabel();
        stageNumber.setFont(normalFont);
        stageNumber.setForeground(Color.white);
        levelPanel.add(stageNumber);
        
        strengthLabel = new JLabel("STR:");
        strengthLabel.setFont(normalFont);
        strengthLabel.setForeground(Color.white);
        levelPanel.add(strengthLabel);
        
        strengthNumber = new JLabel();
        strengthNumber.setFont(normalFont);
        strengthNumber.setForeground(Color.white);
        levelPanel.add(strengthNumber);
        
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        levelPanel.add(hpLabel);
        
        hpNumber = new JLabel();
        hpNumber.setFont(normalFont);
        hpNumber.setForeground(Color.white);
        levelPanel.add(hpNumber);
        
        inventoryStatus = "close";
        if(sc.equals("start"))stats();
        if(sc.equals("continue"))loadData();
    }
    
    
    //Loading data from the text file using BufferedReader, also handles exception 
    public void loadData(){
        
        //Using try-catch clause to handle exception that are thrown from reading data from a text file
        //the exception used are FileNotFoundException and IOException
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            strength = Integer.parseInt(br.readLine());
            hp = Integer.parseInt(br.readLine());
            stage = Integer.parseInt(br.readLine());
            String a = br.readLine();
            String b = br.readLine();
            String c = br.readLine();
            
            if(a!=null && !a.equals(""))stringToList(a,0);
            if(b!=null && !b.equals(""))stringToList(b,1);
            if(c!=null && !c.equals(""))stringToList(c,2);
            br.close();
        }
        catch (java.io.FileNotFoundException e){}
        catch (java.io.IOException e){}
        catch (java.lang.NullPointerException e){
            stage =0;
        }
        catch (java.lang.NumberFormatException e){
            stage=0;
        }
        
        strengthNumber.setText(""+strength);
        hpNumber.setText(""+hp);
        
        //depending on the data read, we go to different part of the program
        if(stage==1) stage1();
        else if (stage==2) stage2();
        else if (stage==3) stage3();
        else if (stage==4) stage4();
        else if (stage==5) stage5();
        else intro();
    }
    
    
    //Saving data into the text file using BufferedWriterm also handles exception
    public void saveData(){
        pos = "saveData";
        textArea.setText("Your progress has been saved!");
        choice1.setText("Quit");
        choice2.setText("");
        choice3.setText("");
        
        
        //writing out data into the text file using BufferedWriter
        //Exception that are being thrown are FileNotFoundException and IOException
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(""+strength+"\n");
            bw.write(""+hp+"\n");
            bw.write(""+stage+"\n");
            
            if(items.size()==3){
                bw.write(items.get(0)+"\n");
                bw.write(items.get(1)+"\n");
                bw.write(items.get(2)+"\n");
            }
            else if(items.size()==2){
                bw.write(items.get(0)+"\n");
                bw.write(items.get(1)+"\n");
            }
            else if(items.size()==1){
                bw.write(items.get(0)+"\n");
            }
            bw.close();
        }
        catch (java.io.FileNotFoundException e){}
        catch (java.io.IOException e){}
    }
    
    
    //converting data read from the text file to ArrayList for the inventory
    public void stringToList(String name, int slot){
        items.add(slot,name);
    }
    
    
    //stats being initialised before the game starts
    public void stats(){
        strength = 30;
        hp = 100;
        strengthNumber.setText(""+strength);
        hpNumber.setText(""+hp);
        intro();
    }
    
    
    //introduction
    public void intro(){
        pos = "intro";
        textArea.setText("Welcome to 5 stage Adventure Game! \nKill the Monsters in each Stage to advance!");
        
        choice1.setText("Next");
        choice2.setText("");
        choice3.setText("Quit");
    }
    
    
    //stage 1, strength is set using a random value
    public void stage1(){
        pos = "s1";
        stage = 1;
        stageNumber.setText(""+stage);
        mhp1 = 20;
        mstr1 = 10 + random.nextInt(5);
        textArea.setText("Stage 1: Kill the Zombies to advance! \nThe Zombie has a health of "+mhp1+"\nand strength of "+mstr1);
        
        choice1.setText("Fight");
        choice2.setText("Save");
        choice3.setText("Quit");
    }
    
    
    //stage 2, strength is set using a random value
    public void stage2(){
        pos = "s2";
        stage = 2;
        stageNumber.setText(""+stage);
        mhp2 = 30;
        mstr2 = 15+ random.nextInt(5);
        textArea.setText("Congratulation, you cleared stage 1\n\nStage 2: Kill the Witch to advance! \nThe Witch has a health of "+mhp2+"\nand strength of "+mstr2);
        
        choice1.setText("Fight");
        choice2.setText("Save");
        choice3.setText("Quit");
    }
    
    
    //stage 3, strength is set using a random value
    public void stage3(){
        pos = "s3";
        stage = 3;
        stageNumber.setText(""+stage);
        mhp3 = 50;
        mstr3 = 20+ random.nextInt(5);
        textArea.setText("Congratulation, you cleared stage 2\n\nStage 3: Kill the Demon to advance! \nThe Demon has a health of "+mhp3+"\nand strength of "+mstr3);
        
        choice1.setText("Fight");
        choice2.setText("Save");
        choice3.setText("Quit");
    }
    
    
    //stage 4, strength is set using a random value
    public void stage4(){
        pos = "s4";
        stage = 4;
        stageNumber.setText(""+stage);
        mhp4 = 70;
        mstr4 = 25 + random.nextInt(5);
        textArea.setText("Congratulation, you cleared stage 3\n\nStage 4: Kill the Shadow Warrior to advance! \nThe Shadow Warrior has a health of "+mhp4+"\nand strength of "+mstr4);
        
        choice1.setText("Fight");
        choice2.setText("Save");
        choice3.setText("Quit");
    }
    
    
    //stage 5, strength is set using a random value
    public void stage5(){
        pos = "s5";
        stage = 5;
        stageNumber.setText(""+stage);
        mhp5 = 100;
        mstr5 = 30+ random.nextInt(5);
        textArea.setText("Congratulation, you cleared stage 4\n\nBoss Stage: Kill the Boss Demon King to advance! \nThe Demon King has a health of "+mhp5+"\nand strength of "+mstr5);
        
        choice1.setText("Fight");
        choice2.setText("Save");
        choice3.setText("Quit");
    }
    
    
    //fight methods for each monsters:
    
    public void fight1(){
        pos="fight1";
        if(strength>0){
            textArea.setText("You have greater strength than the Zombie\nYou have attacked the Zombie!");
            mhp1 -= strength;
            if(mhp1<=0){
                killed1();
            }
            else{
                textArea.setText("You damaged the Zombie for "+strength+"\nThe Zombie has " +mhp1+" health\nThe Zombie attacked you!\nYou lost "+mstr1+" health");
                hp -= mstr1;
                hpNumber.setText(""+hp);
                if(hp<=0){
                    die();
                }
                else{
                    choice1.setText("Fight");
                    choice2.setText("");
                    choice3.setText("Quit");
                }
            }
        }
    }
    
    public void fight2(){
        pos="fight2";
        if(strength>0){
            textArea.setText("You have greater strength than the Witch\nYou have attacked the Witch!");
            mhp2 -= strength;
            if(mhp2<=0){
                killed2();
            }
            else{
                textArea.setText("You damaged the Witch for "+strength+"\nThe Witch has " +mhp2+" health\nThe Witch attacked you!\nYou lost "+mstr2+" health");
                hp -= mstr2;
                hpNumber.setText(""+hp);
                if(hp<=0){
                    die();
                }
                else{
                    choice1.setText("Fight");
                    choice2.setText("");
                    choice3.setText("Quit");
                }
            }
        }
    }
    
    public void fight3(){
        pos="fight3";
        if(strength>0){
            textArea.setText("You have greater strength than the Demon\nYou have attacked the Demon!");
            mhp3 -= strength;
            if(mhp3<=0){
                killed3();
            }
            else{
                textArea.setText("You damaged the Demon for "+strength+"\nThe Demon has " +mhp3+" health\nThe Demon attacked you!\nYou lost "+mstr3+" health");
                hp -= mstr3;
                hpNumber.setText(""+hp);
                if(hp<=0){
                    die();
                }
                else{
                    choice1.setText("Fight");
                    choice2.setText("");
                    choice3.setText("Quit");
                }
            }
        }
    }
    
    public void fight4(){
        pos="fight4";
        if(strength>0){
            textArea.setText("You have greater strength than the Shadow Warrior\nYou have attacked the Shadow Warrior!");
            mhp4 -= strength;
            if(mhp4<=0){
                killed4();
            }
            else{
                textArea.setText("You damaged the Shadow Warrior for "+strength+"\nThe Shadow Warroior has " +mhp4+" health\nThe Shadow Warrior attacked you!\nYou lost "+mstr4+" health");
                hp -= mstr4;
                hpNumber.setText(""+hp);
                if(hp<=0){
                    die();
                }
               else{
                    choice1.setText("Fight");
                    choice2.setText("");
                    choice3.setText("Quit");
                }
            }
        }
    }
    
    public void fight5(){
        pos="fight5";
        if(strength>0){
            textArea.setText("You have greater strength than the Demon King\nYou have attacked the Demon King!");
            mhp5 -= strength;
            if(mhp5<=0){
                killed5();
            }
            else{
                textArea.setText("You damaged the Demon King for "+strength+"\nThe Demon King has " +mhp5+" health\nThe Demon King attacked you!\nYou lost "+mstr5+" health");
                hp -= mstr5;
                hpNumber.setText(""+hp);
                if(hp<=0){
                    die();
                }
                else{
                    choice1.setText("Fight");
                    choice2.setText("");
                    choice3.setText("Quit");
                }
            }
        }
    }
    
    //Killed methods for each monster, and their drops
    
    public void killed1(){
        pos = "killed1";
        String d = drop();
        textArea.setText("You damaged the Zombie for "+strength+" health\nYou killed the Zombie!\nThe zombie has dropped "+d);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("Quit");
    }
    
    public void killed2(){
        pos = "killed2";
        String d = drop();
        textArea.setText("You damaged the Witch for "+strength+" health\nYou killed the Witch!\nThe witch has dropped "+d);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("Quit");
    }
    
    public void killed3(){
        pos = "killed3";
        String d = drop();
        textArea.setText("You damaged the Demon for "+strength+" health\nYou killed the Demon!\nThe Demon has dropped "+d);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("Quit");
    }
    public void killed4(){
        pos = "killed4";
        String d = drop();
        textArea.setText("You damaged the Shadow Warrior for "+strength+" health\nYou killed the Shadow Warrior!\nThe shadow warrior has dropped "+d);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("Quit");
    }
    
    public void killed5(){
        pos = "killed5";
        textArea.setText("You damaged the Demon King for "+strength+" health\nYou killed the Demon!");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("Quit");
    }
    
    
    //die method when the player dies
    public void die(){
        pos = "dead";
        textArea.setText("GAME OVER!!!!\n\nYou have Died!\nThank you for playing the game");
        levelPanel.setVisible(false);
        inventoryButton.setVisible(false);
        choice1.setText("");
        choice2.setText("");
        choice3.setText("Quit");
    }
    
    
    //victory method for when the player wins
    public void win(){
        pos = "won";
        textArea.setText("YOU COMPLETED THE GAME\n\nCongratulations!!!\nYou have completed the game\nThanks for playing");
        levelPanel.setVisible(false);
        inventoryButton.setVisible(false);
        choice1.setText("");
        choice2.setText("");
        choice3.setText("Quit");
    }
    
    
    //inventory methods: drop, consume
    
    //drop uses randomiser to have drops after killing
    public String drop(){
        int d = random.nextInt(4);
        if(d<=2){
            String monsterDrop = drops[d];
            items.add(monsterDrop);
            return monsterDrop;
        }
        else return "nothing";
    }
    
    
    //drops consumed after user interacts
    public void consume(int slot){
        String d = "";
        
        //using a try-catch clause to handle NullPointerException that is being thrown from empty ArrayList
        try{
            d = items.get(slot);
        }
        catch(NullPointerException e){}
        catch(IndexOutOfBoundsException e){}
        
        //Decision-Statements to perform different action
        if(d.equals("STR potion")){
            textArea.setText("You have consumed Strength potion, your strength increased by 5");
            strength +=5;
            strengthNumber.setText(""+strength);
            items.remove("Strength potion");
        }
        else if(d.equals("Health potion")){
            if(hp+10>100){
                 textArea.setText("You have consumed Health potion\nHowever you had max health, so it had not affect");
            }else{
                textArea.setText("You have consumed Health potion\nYour health increased by 10");
                hp +=10;
                hpNumber.setText(""+hp);
                items.remove("Health potion");
            } 
        }
        else if(d.equals("zombie flesh")){
            if(hp+3>100){
                textArea.setText("You have consumed Zombie Flesh, your strength increased by 3\nHowever your HP is already max so your HP stayed the same");
            }else{
                textArea.setText("You have consumed Zombie Flesh\nYour strength decreased by 3\nYour health increased by 3");
                strength -=3;
                hp += 3;
                hpNumber.setText(""+hp);
                strengthNumber.setText(""+strength);
                items.remove("zombie flesh");
            }
            
        }
        else if(d.equals("")){}
    }
    
    
    //exit the game
    public void exit(){
        textArea.setText("Thank you for playing the game!");
        System.exit(0);
    }
    
    
    //getter
    public JFrame getFrame(){
        return frame;
    }
    
    ///////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    //classes
    
    
    //TitleHandler to handle Title GUI widgets
    //it implements the interface ActionListener
    public class TitleHandler implements ActionListener{
       
        
        //Overriding the actionPerformed method in the ActionListener interface
        //actionPerformed uses Switch cases (easier for me to use than if-else statements)
        //depending on the user interaction, different actions are performed
        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            String yourChoice = e.getActionCommand();
            
            switch(yourChoice){
                case "start":
                    gameScreen("start");
                    break;
                case "continue":
                    gameScreen("continue");
                    break;
            }
        }
    }
    
    
    //InventoryHandler to handle the Inventory GUI widgets
    //it implemets the interface ActionListener
    public class inventoryHandler implements ActionListener{
        
        
        //Overriding the actionPerformed method in the ActionListener interface
        //actionPerformed uses Switch cases (easier for me to use than if-else statements)
        //depending on the user interaction, different actions are performed
        @Override
        public void actionPerformed(ActionEvent e) {
            String yourChoice = e.getActionCommand();
            
            switch(yourChoice){
                case "inventoryButton":
                    if(inventoryStatus.equals("close")){
                        choice1.setVisible(false);
                        choice2.setVisible(false);
                        choice3.setVisible(false);
                        inventoryPanel.setVisible(true);
                        inventoryStatus = "open";
                        
                        if(items.size()<=3){
                            if(items.size()==1)item1.setText(items.get(0));
                            else if(items.size()==2){
                                item1.setText(items.get(0));item2.setText(items.get(1));
                            }
                            else if(items.size()==3){
                                item1.setText(items.get(0));item2.setText(items.get(1)); item3.setText(items.get(2));
                            }
                        }
                    }
                    else if(inventoryStatus.equals("open")){
                        choice1.setVisible(true);
                        choice2.setVisible(true);
                        choice3.setVisible(true);
                        inventoryPanel.setVisible(false);
                        inventoryStatus = "close";
                    }
                    break;
                case "item1":
                    item1.setText("");
                    consume(0);
                    break;
                case "item2":
                    item2.setText("");
                    consume(1);
                    break;
                case "item3":
                    item3.setText("");
                    consume(2);
                    break;  
            }
        }
    }
    
    
    //choiceHandler to perform action for the buttons the user press
    //again implements ActionListener interface to perform action
    //again used Switch Cases statements instead of if-else statement as preference
    public class choiceHandler implements ActionListener{
        
        
        //Overriding the actionPerformed method in the ActionListener interface
        //actionPerformed uses Switch cases (easier for me to use than if-else statements)
        //depending on the user interaction, different actions are performed
        @Override
        public void actionPerformed(ActionEvent e) {
            String yourChoice = e.getActionCommand();
            
            switch(pos){
                case "intro":
                    switch(yourChoice){
                        case "c1": stage1(); break;
                        case "c2": break;
                        case "c3": exit();
                    }
                    break;
                case "s1":
                    switch(yourChoice){
                        case "c1": fight1(); break;
                        case "c2": saveData();break;
                        case "c3": exit(); break;
                    }
                    break;
                case "fight1":
                    switch(yourChoice){
                        case "c1": fight1();break;
                        case "c2": break;
                        case "c3": exit(); break;
                    }
                    break;
                case "s2":
                    switch(yourChoice){
                        case "c1": fight2(); break;
                        case "c2": saveData();break;
                        case "c3": exit(); break;
                    }
                    break;
                case "fight2":
                    switch(yourChoice){
                        case "c1": fight2(); break;
                        case "c2": break;
                        case "c3": exit(); break;
                    }
                    break;
                case "s3":
                    switch(yourChoice){
                        case "c1": fight3(); break;
                        case "c2": saveData();break;
                        case "c3": exit(); break;
                    }
                    break;
                case "fight3":
                    switch(yourChoice){
                        case "c1": fight3(); break;
                        case "c2": break;
                        case "c3": exit(); break;
                    }
                    break;
                case "s4":
                    switch(yourChoice){
                        case "c1": fight4(); break;
                        case "c2": saveData();break;
                        case "c3": exit(); break;
                    }
                    break;
                case "fight4":
                    switch(yourChoice){
                        case "c1": fight4(); break;
                        case "c2": break;
                        case "c3": exit(); break;
                    }
                    break;
                case "s5":
                    switch(yourChoice){
                        case "c1": fight5(); break;
                        case "c2": saveData();break;
                        case "c3": exit(); break;
                    }
                    break;
                case "fight5":
                    switch(yourChoice){
                        case "c1": fight5(); break;
                        case "c2": break;
                        case "c3": exit(); break;
                    }
                    break;
                case "killed1":
                    switch(yourChoice){
                        case "c1": stage2(); break;
                        case "c2": break;
                        case "c3": exit(); break;
                    }
                    break;
                case "killed2":
                    switch(yourChoice){
                        case "c1": stage3(); break;
                        case "c2": break;
                        case "c3": exit(); break;
                    }
                    break;
                case "killed3":
                    switch(yourChoice){
                        case "c1": stage4(); break;
                        case "c2": break;
                        case "c3": exit(); break;
                    }
                    break;
                case "killed4":
                    switch(yourChoice){
                        case "c1": stage5(); break;
                        case "c2": break;
                        case "c3": exit(); break;
                    }
                    break;
                case "killed5":
                    switch(yourChoice){
                        case "c1": win(); break;
                        case "c2": break;
                        case "c3": exit(); break;
                    }
                    break;
                case "dead":
                    switch(yourChoice){
                        case "c1": break;
                        case "c2": break;
                        case "c3": exit();break;
                    }
                    break;
                case "saveData":
                    switch(yourChoice){
                        case "c1": exit();break;
                    }
                    break;
                    
            }
        }
        
    }
    
}


