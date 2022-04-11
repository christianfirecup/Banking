import java.util.Scanner;
import java.util.ArrayList;

class Main {
  static float  Balance = 0;
  static float  damount = 0;
  static float  wamount = 0;
  static float  Lastt = 0;
  static String lasttext = "null";
  static boolean firsttime = true;
  static ArrayList < String > thistory = new ArrayList < String >();
 static Scanner lmaohaha = new Scanner(System.in);
   // main menu code   
  public static void main(String[] args) {
    boolean ifcorrect = false;
    // loop for main menu
    while (ifcorrect == false){
    System.out.println(" do you want to deposit or withdraw in the bank 1 = deposit 2 = withdraw 3 = Balance 4 = last transaction");
    int cash = lmaohaha.nextInt();
    if(cash == 1){
    ifcorrect = true;
      Dpists();
      firsttime = false;
      
      
    }else if(cash == 2){
      ifcorrect = true;
      withdraw();
      firsttime = false;
      
    }else if(cash == 3){
      firsttime = false;
      Accountbalance();


      
      
    }else if(cash == 4){
      lasttransaction();


      
    }else{
      ifcorrect =false;


      
    }



      }
  }
   
  // deposit code
  static void Dpists(){
    
    boolean end = false;
    String ended;
    while (end == false){
    if(end == false){
System.out.println("how much do you want to deposit");

    damount = lmaohaha.nextFloat();
    if(Balance != 0){
      Balance = Balance + damount;
      Lastt = damount;
      lasttext = "Deposited";
      System.out.println("your Balance is "+ Balance + "$");
        System.out.println("do you want to stop banking yes or no");
      String test = lmaohaha.nextLine();
      test = lmaohaha.nextLine();
      if(test.equals("yes")){
        System.exit(0);
      end = true;
        
      }else{
       main(null);
      }
      
      
    }else if(Balance == 0){
      Balance = damount;
      Lastt = damount;
      lasttext = "Deposited";
      System.out.println("your Balance is "+ Balance + "$");

      System.out.println("do you want to stop banking yes or no");
      String test = lmaohaha.nextLine();
      test = lmaohaha.nextLine();
      if(test.equals("yes")){
        
      end = true;
        
        
      }else{
        main(null);
        end = true;
      }
      
    }
      
    }else if(end == true){
      System.out.println("thank you for using bank");
      System.exit(0);
      
    }
      }
    }




  // WITHDRAW SYSTEM
  static void withdraw(){
    boolean wloop = true;
    while(wloop = true){
    System.out.println("How much do you want to withdraw!?");
     wamount = lmaohaha.nextFloat();

    
    if(Balance == 0){
      System.out.println("You Have "+ Balance + "$ in your account");
      System.out.println("You a broke Bitch");
       System.out.println("do you want to stop banking yes.(1) or no.(2)");
      String test = lmaohaha.nextLine();
      test = lmaohaha.nextLine();
      if(test.equals("yes")){
        
      wloop = false;
        System.exit(0);
      }else if(test.equals("no")){
        main(null);
        wloop = false;




      }

      
    }else if(Balance >= wamount){
      Balance = Balance - wamount;
       Lastt = wamount;
      lasttext = "Withdrawn";
      System.out.println("Your new balance is " + Balance + "$");
      System.out.println("do you want to stop banking yes.(1) or no.(2)");
      int test = lmaohaha.nextInt();
      test = lmaohaha.nextInt();
      if(test == 1){
        System.exit(0);
      wloop = false;
        
      }else if(test == 2){
        main(null);
        wloop = false;




      }

      
    }else if(Balance <= wamount && Balance != 0){

    System.out.println("You do not have enough money to preform this transaction");
       System.out.println("do you want to stop banking yes.(1) or no.(2)");
      String test = lmaohaha.nextLine();
      test = lmaohaha.nextLine();
      if(test.equals("yes")){
        
      wloop = false;
        System.exit(0);
      }else if(test.equals("no")){
        main(null);
        wloop = false;




      }

      
    }
    
    }
  }
  static void Accountbalance(){
    System.out.println("Your Balance Is "+ Balance +"$");
    main(null);

    
    }
  static void lasttransaction(){
    if(firsttime = true){
   System.out.println(lasttext + " " + Lastt);
      main(null);
      
    }
    if(firsttime = false){
    System.out.println(lasttext + " " + Lastt);
    }
    }
}

