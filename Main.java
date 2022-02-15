import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //User input : User choice of operation

        Main obj = new Main();
        //
        int choice=1;
        Scanner sc = new Scanner(System.in);
        fooSwitch: do {
            System.out.println("1. Find palindrome of number.\n"
                    + "2. Print Pattern for a given no.\n" + "3. Check whether the no is a prime number.\n"
                    + "4. Print Fibonacci series.\n" + "--> Enter 0 to Exit.\n");
            System.out.print("Enter your choice of Operation from the above list Options(0,1,2,3,4)  :");
            choice = sc.nextInt();
            switch (choice) {
                case 0: choice = 0;
                        break;
                case 1: {
                    obj.checkPalindrome();
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Do you want to try different operation?: Y/N");
                    String numString1 = sc1.nextLine();
                    if ( numString1.toLowerCase().equals("n")){
                        //System.out.println("NO option chosen");
                        choice = 0;
                    }
                    break;
                }

                case 2: {
                    obj.printPattern();
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("Do you want to try different operation?: Y/N");
                    String numString2 = sc2.nextLine();
                    if (numString2.toLowerCase().equals("n")) {
                        //System.out.println("NO option chosen");
                        choice = 0;
                    }
                }
                break;
                case 3: {
                    obj.checkPrimeNumber();
                    Scanner sc3 = new Scanner(System.in);
                    System.out.println("Do you want to try different operation?: Y/N");
                    String numString3 = sc3.nextLine();
                    if (numString3.toLowerCase().equals("n")) {
                        //System.out.println("NO option chosen");
                        choice = 0;
                    }
                }
                break;
                case 4: {
                    obj.printFibonacciSeries();
                    Scanner sc3 = new Scanner(System.in);
                    System.out.println("Do you want to try different operation?: Y/N");
                    String numString3 = sc3.nextLine();
                    if (numString3.toLowerCase().equals("n")) {
                        //System.out.println("NO option chosen");
                        choice = 0;
                    }
                }
                break;

                default:
                    System.out.println("Invalid choice. Enter a valid no.\n");
            }
        }while (choice != 0);
        System.out.println("Exited Successfully!!!");
        sc.close();
    }


    /**
     * Palindrome number:
     * The numbers which give the same value when reversed are called palindrome numbers.
     * Example:
     * 121, 12321, 512215, etc.,
     */
    private void checkPalindrome(){

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Type your int number, Check for Palindrome: ");
        String numString = sc1.nextLine();

        //Converting to char array to reverse the string/number
        char[] numChars=numString.toCharArray();
        // System.out.println("char array"+numChars+" length"+numChars.length);

        String numReverse ="";
        //Reversing
        for (int j=numChars.length-1;j>=0;j--){
            numReverse=numReverse+numChars[j];
        }
        System.out.println("When the number is reversed: "+numReverse);

        if (numString.equals(numReverse)) {
            System.out.println(numString + " is a Palindrome.");
        } else {
            System.out.println(numString+" is not a Palindrome.");
        }
        System.out.println("***********************");

    }

    /**
     * Pattern of stars:
     * Based on the input integer, the levels in the pattern and the number of stars in each level aredecided. At every level, the number of stars is 1 less than the previous level.
     * Example:
     * If the input number is 4, then the output will be
     * ****
     * ***
     * **
     * *
     */
    private void printPattern(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type your int number between 0-100,Options:(100>n>0), to print the pattern: ");
        int starCount = sc.nextInt();
        if (starCount != 0) {
            do {
                for (int i = 0; i < starCount; i++) {
                    System.out.print('*');
                }
                starCount--;
                System.out.println("");
            } while (starCount > 0);
        }else {
            System.out.println("Please specify a valid number.");
        }
    }

    /**
     * Prime number:
     * The numbers which are only divisible by 1 & themselves are called prime numbers.
     * (Or)
     * The numbers which have factors as 1 and themselves are called prime numbers.
     *

     */

    private void checkPrimeNumber(){
        //Number to check prime
        Scanner sc = new Scanner(System.in);
        System.out.println("Type your int number, to check Prime or Composite: ");

        int numCheck = sc.nextInt();

        if (numCheck==0){
            System.out.println("0 is neither Prime nor Composite.");
        } else if (numCheck==1){
            System.out.println("1 is a Prime number.");
        }
        int numFactors=2;
        for (int i=2;i<numCheck;i++){
            if (numCheck%i==0){
                numFactors++;
            }
        }

        if (numFactors>2){
            System.out.println("The number "+numCheck+" is Composite, not Prime.");
        } else if (numFactors==2){
            System.out.println("The number "+numCheck+" is a Prime number.");
        }
    }

    /**
     * Fibonacci series:
     * The series of numbers whose next number is the sum of its previous two numbers is called theFibonacci series.
     * Example_1:
     * If the input number is 5,
     * The Fibonacci series is: 0, 1, 1, 2, 3 (by default first two numbers are 0,1 (
     * hardcoded
     * ), and we need to calculate the other nos in series)
     */

    private void printFibonacciSeries(){
        //Print the Series count
        Scanner sc = new Scanner(System.in);
        System.out.println("Type your int number, how many numbers in the series?: ");
        try {
            int numCount = sc.nextInt();
            int num1=0, num2=1;
            System.out.print(num1+", "+num2);

            //Print the remaining numbers
            for (int i=2;i<numCount;i++){
                int newNumber=num1+num2;
                num1=num2;
                num2=newNumber;
                System.out.print(", ");
                System.out.print(newNumber);
            }
        }catch(InputMismatchException e){
            e.printStackTrace();
            System.out.println("Enter a valid number.");
        }
        System.out.println(" ");
    }

}
