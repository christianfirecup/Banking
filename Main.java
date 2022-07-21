import java.util.Scanner;
import java.util.ArrayList;
import java.io.File; // Import the File class
import java.io.IOException; // Import the IOException class to handle errors
import java.io.FileWriter;
import java.io.FileNotFoundException;  // Import this class to handle errors
import javax.swing.*;    
import java.awt.*;  
import java.awt.event.*;  

class Main {
    static float Balance = 0;
    static float damount = 0;
    static float wamount = 0;
    static float Lastt = 0;
    static String lasttext = "null";
    static boolean firsttime = true;
    static Scanner lmaohaha = new Scanner(System.in);
   static boolean firstload  = true;
   static boolean Gamestop = false;
   
    // main menu code   
    public static void main(String[] args) {
      boolean ifcorrect = false;
    
      if(firstload == true ){
        readfile();
        firstload = false;
        System.out.println("haha");
      }
       filecreate();
      
        
        // loop for main menu
        while (ifcorrect == false) {
            System.out.println(" do you want to deposit or withdraw in the bank 1 = deposit 2 = withdraw 3 = Balance 4 = last transaction, 5 = save bal, 6 = Open Game");
            int cash = lmaohaha.nextInt();
            if (cash == 1) {
                ifcorrect = true;
                Dpists();
                firsttime = false;


            } else if (cash == 2) {
                ifcorrect = true;
                withdraw();
                firsttime = false;

            } else if (cash == 3) {
                firsttime = false;
                Accountbalance();




            } else if (cash == 4) {
                lasttransaction();



            } else if(cash == 5){
                savetofile();



            }else if(cash == 6){
              ifcorrect = true;
              
              gamemenu();
              
            }else{
              ifcorrect = false;
            }



        }
    }

    // deposit code
    static void Dpists() {

        boolean end = false;
        String ended;
        while (end == false) {
            if (end == false) {
                System.out.println("how much do you want to deposit");

                damount = lmaohaha.nextFloat();
                if (Balance != 0) {
                    Balance = Balance + damount;
                    Lastt = damount;
                    lasttext = "Deposited";
                    System.out.println("your Balance is " + Balance + "$");
                    System.out.println("do you want to stop banking yes or no");
                    String test = lmaohaha.nextLine();
                    test = lmaohaha.nextLine();
                    if (test.equals("yes")) {
                        System.exit(0);
                        end = true;

                    } else {
                        main(null);
                    }


                } else if (Balance == 0) {
                    Balance = damount;
                    Lastt = damount;
                    lasttext = "Deposited";
                    System.out.println("your Balance is " + Balance + "$");

                    System.out.println("do you want to stop banking yes or no");
                    String test = lmaohaha.nextLine();
                    test = lmaohaha.nextLine();
                    if (test.equals("yes")) {

                        end = true;


                    } else {
                        main(null);
                        end = true;
                    }

                }

            } else if (end == true) {
                System.out.println("thank you for using bank");
                System.exit(0);

            }
        }
    }




    // WITHDRAW SYSTEM
    static void withdraw() {
        boolean wloop = true;
        while (wloop = true) {
            System.out.println("How much do you want to withdraw!?");
            wamount = lmaohaha.nextFloat();


            if (Balance == 0) {
                System.out.println("You Have " + Balance + "$ in your account");
                System.out.println("You a broke Bitch");
                System.out.println("do you want to stop banking yes.(1) or no.(2)");
                String test = lmaohaha.nextLine();
                test = lmaohaha.nextLine();
                if (test.equals("yes")) {

                    wloop = false;
                    System.exit(0);
                } else if (test.equals("no")) {
                    main(null);
                    wloop = false;




                }


            } else if (Balance >= wamount) {
                Balance = Balance - wamount;
                Lastt = wamount;
                lasttext = "Withdrawn";
                System.out.println("Your new balance is " + Balance + "$");
                System.out.println("do you want to stop banking yes.(1) or no.(2)");
                int test = lmaohaha.nextInt();
                if (test == 1) {
                    System.exit(0);
                    wloop = false;

                } else if (test == 2) {
                    main(null);
                    wloop = false;




                }


            } else if (Balance <= wamount && Balance != 0) {

                System.out.println("You do not have enough money to preform this transaction");
                System.out.println("do you want to stop banking yes.(1) or no.(2)");
                String test = lmaohaha.nextLine();
                test = lmaohaha.nextLine();
                if (test.equals("yes")) {

                    wloop = false;
                    System.exit(0);
                } else if (test.equals("no")) {
                    main(null);
                    wloop = false;




                }


            }

        }
    }
    static void Accountbalance() { // check balance
        System.out.println("Your Balance Is " + Balance + "$");
        main(null);


    }
    static void lasttransaction() {
        if (firsttime = true) {
            System.out.println(lasttext + " " + Lastt + "$");
            main(null);

        }
        if (firsttime = false) {
            System.out.println(lasttext + " " + Lastt);
        }
    }

  // Game States
    static void gamemenu() {
        System.out.println("Welcome to the game section");
        System.out.println("do you want to start the game"); 
      String option = lmaohaha.nextLine();
        option = lmaohaha.nextLine();
        if (option.equals("yes")) {
            System.out.println("lets start");
          gamesinstance1();
        } else {
          
        }
    }
    static void gamesinstance1() {
      while(Gamestop = false){
        
      }
    Frame f=new Frame("stop game");  
    tf.setBounds(50,50, 150,20);  
    Button b=new Button("Click Here");  
    b.setBounds(50,100,60,30);  
  
    b.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
            Gamestop = true;
            if(Gamestop = true)
            {
              System.out.println("is TRUE!!!");
            }  
    }  
    });  
    f.add(b);f.add(tf);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);   
    }





  //Save file portion
    public void savebal(int balsave) {
        if (balsave != Balance) {
            savetofile();
            Balance = balsave;
        }
    }
    static void filecreate() {
        try {
            File myObj = new File("balancesave.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    static void savetofile() {
        try {
            FileWriter myWriter = new FileWriter("balancesave.txt");
            myWriter.write(Balance + "");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
  static void readfile(){
    try {
      File myObj = new File("balancesave.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String balanceload = myReader.nextLine();
        float bal=Float.parseFloat(balanceload);  
        Balance = bal;
        
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
   

}