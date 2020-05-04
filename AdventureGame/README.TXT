Student name: Ibtasum Iktadar (Skype name: iiktadar)
Student number: 150233473

LEVEL YOU WISH THE MINI-PROJECT TO BE MARKED FOR: 3 

Now complete the statements below for each level you wish to be marked. Replace all text in square brackets.

LEVEL THREE

[After a button is pressed, I have a different Handlers, such as TitleHandler, inventoryHandler and choiceHandler that implements the interface ActionListener to perform different action depending on the button that is being pressed. It overrides the actionPerformed method in the interface ActionListener, and uses decision statements to perform different actions. This Handler are then initialised in the GUI class and is set to the buttons that interacts with the user by using addActionListerner(handlerName).
-If you look at UserInterface line 710, you can find TitleHandler that handles the Start and Continue button after first opening the UserInterface GUI. Line 716-728, uses Switch cases (I know we were not taught this, but I find it easier to use this sometiems than if-else statement, and in this occasion, switch cases was more efficient and easier to write, and made the code more cleaner), to perform different actions.
-Similarly, line 736 is another class called inventoryHandler that again implments ActionListener, and like before, override actionPerformed method and uses switch case from line 742-784 to perform different actions.
-Lastly, I have another class, line 793 called choiceHandler (Could have put each handler in seperate source file, but found it easier to work with by having it in the same file, so I left it), that again override actionPerformed and uses Switch case from line 803-927 to perform different actions]

[UserInteface has many try-catch clauses:
-Line 266, method loadData(), uses try-catch clause to handle many exceptions, such as FileNotFoundException, IOExcpetion, NullPointerException, NumberFormatException. The try-catch clause are line 270-287
-Line 308, method saveData(), uses try-catch clause to handle exceptions such as FileNotFoundException, IOException. The try-catch clause are line 318-339.
-Lastly, line 652, method consume(), uses try-catch clause to handle NullPointerException, and IndexOutOfBoundsException. try-catch clause are line 656-660


[UserInterface: 
-I used ArrayList for the inventory. It was used to store monster drops and are used in the following lines: 56, 344-346, 643-644, 666, 675, 684, 755-762
-Also interface used are ActionListener, which are used in line 716, 742,799]

[It uses BufferedWriter, FileWriter and File from Java IO library. BufferedWriter.write() is used to write the data into the text file, and BufferedWriter.close() is used to close the file after writing to file is finished. Lastly, a try-catch clause is used to handle exception that are thrown, more commonly IOExceptions]

ANYTHING ELSE

[My level 3 (GUI, Save/Load, ArrayList) are in the class UserInterface. It also has the main method to run the GUI, so please run UserInterface to test out my GUI.
I have completed the GUI in NetBeans and converted to BlueJ. However, the GUI sometime does not load when run on BlueJ, the GUI window has to be maximised for it to load. It works perfectly fine when run from NetBeans. I don't know if this issue is with my computer, so in-case you face a similar issue, please maximise the screen. Or maybe re-run the main method.]
