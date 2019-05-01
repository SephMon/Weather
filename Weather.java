
import java.util.Scanner;
import java.util.InputMismatchException;

public class Weather{

   private static Scanner sc = new Scanner(System.in);
   private static final String NAME[] = {"Gerry","Evelyn","Joan","Vincent"};
   private static final String PASS[] = {"cyclone","sunshine","thunder","heat-wave"};
   private static final String DAYS[] = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
   private static boolean keepGoing = true;
   private static final int MAX_LOGIN_ATTEMPTS = 3;
   private static final int num_nums = 7;
   private int[] temps = new int[8];
   private int[] rainFall = new int [8];
   private int [] humidity = new int [8];
   private int total;
   private int max = Integer.MIN_VALUE;
   private int min = Integer.MAX_VALUE;
   private int choice;



    public void headerMessage(){
      System.out.println("**********************");
      System.out.println("* WELCOME TO THE MET *");
      System.out.println("* OFFICE LOGIN PAGE  *");
      System.out.println("**********************");
   }
   public void inputLoginDetails(){
      int nTries = 0;

      while(keepGoing){
        System.out.println("Please enter the correct login details: ");
        System.out.println();

        System.out.println("Please enter your username: ");
        String userName = sc.nextLine();

        System.out.println("Please enter your password:" );
        String passWord = sc.nextLine();

        if(isValidLogin(userName,passWord)){
           welcomeMessage();
           menuSelection();
           choiceSelector();
           break;
        }else{
          nTries++;
        }
        if(nTries >= MAX_LOGIN_ATTEMPTS){
           System.out.println("ALL ATTEMPTS USED!");
           keepGoing = false;
        }else{
          wrongPassWord();
        }
      }
   }
   public boolean isValidLogin(String userName,String passWord){
      if(userName.equals(NAME[0]) && passWord.equals(PASS[0]) || userName.equals(NAME[1]) && passWord.equals(PASS[1])
      || userName.equals(NAME[2]) && passWord.equals(PASS[2]) || userName.equals(NAME[3]) && passWord.equals(PASS[3])){
        return true;
      }else{
        return false;
      }
   }
    public void welcomeMessage(){
     System.out.println("**********************");
     System.out.println("*      Login         *");
     System.out.println("*    Successful      *");
     System.out.println("**********************");
   }
   public void menuSelection()
   {
   	 System.out.println("1) Temperature.");
   	 System.out.println("2) Rain.");
   	 System.out.println("3) Humidity.");
   	 System.out.println("0) Exit.");
   	 System.out.println();
   }
   public void choiceSelector(){
   	 do{
   	 	System.out.println("Please make a selection: ");
   	 	choice = checkInput();

   	 	switch(choice){
   	 		case 1: getTemps();
   	 		break;

   	 		case 2: getRainFallAmount();
   	 		break;

   	 		case 3: getHumidity();
   	 		break;

   	 		case 0: exitMessage();
   	 		break;

   	 		default:
   	 			System.out.println("INVALID SELECTION!!");
   	 	}

   	 }while(choice != 0);
   }
   public void getTemps(){
     int k;

    for(k = 0; k < 7; k++){
   	  System.out.print("Please enter the temps for day " + DAYS[k] +   ":");
   	  temps[k] = checkInput();
   	  total +=temps[k];
   	  if (temps[k] < min) min = temps[k];
	  if (temps[k] > max) max = temps[k];
    }
    System.out.printf("Monday  Tuesday    Wednesday   Thursday   Friday   Saturday    Sunday\n");
    System.out.printf("---------------------------------------------------------------------------\n");
    System.out.printf("%4d     %4d         %4d    %4d       %4d      %4d        %4d\n",temps[0],temps[1],temps[2],temps[3],temps[4],temps[5],temps[6],temps[7]);

    System.out.println("Avg Temperature: " +total / num_nums);
    System.out.println("Highest Temperature of the week was " + ":" + max );
    System.out.println("Lowest Temperature of the week was : " +min );

   }
   public void getRainFallAmount(){
   	 int i;

   	 for( i = 0; i < 7; i++){
   	 	System.out.println("Please enter the rainfall amounts for " + DAYS[i]+ ":");
   	 	rainFall[i] = checkInput();
   	 	total +=rainFall[i];
   	 }
   	   System.out.printf("Monday  Tuesday    Wednesday   Thursday   Friday   Saturday    Sunday\n");
       System.out.printf("---------------------------------------------------------------------------\n");
       System.out.printf("%4d     %4d         %4d    %4d       %4d      %4d        %4d\n",rainFall[0],rainFall[1],rainFall[2],rainFall[3],rainFall[4],rainFall[5],rainFall[6],rainFall[7]);

       System.out.println("Total RainFall: " +total);

   }
   public void getHumidity(){
   	 int j;
   	 String message1 = "So cold, wrap up warm";

   	 for(j = 0; j < 7; j++){
   	 	System.out.println("Please enter the Humidity for " + DAYS[j] + ":");
   	 	humidity[j] = checkInput();
   	 	total += humidity[j];
   	 	if(humidity[j] < 0 || humidity[j] <= 10)System.out.println(message1);
   	 }
   	 System.out.printf("Monday  Tuesday    Wednesday   Thursday   Friday   Saturday    Sunday\n");
     System.out.printf("---------------------------------------------------------------------------\n");
     System.out.printf("%4d     %4d         %4d    %4d       %4d      %4d        %4d\n",humidity[0],humidity[1],humidity[2],humidity[3],humidity[4],humidity[5],humidity[6],humidity[7]);

     System.out.println("Avg Humidity is : " +total / num_nums);
   }
   public int checkInput(){
     while(keepGoing){
       try{
         return sc.nextInt();
       }
       catch(InputMismatchException e)
       {
         sc.next();
         System.err.print("Invalid input");
       }
     }
     return sc.nextInt();
   }

   public void wrongPassWord(){
     System.out.println("Wrong password");
   }
   private void exitMessage(){
        System.out.println("Bye.");
    }



}