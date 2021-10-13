package week6;

import java.util.Scanner;

public class ForLoops {
    public static void main(String[] args) {
        exampleOne();
        test();
        getNumber();
    }

    private static void exampleOne() {
        for(int i = 2; i <= 100; i+=2){
            System.out.println(i);
        }
    }
    
    private static void test() {
        Scanner in = new Scanner(System.in);
        boolean playAgain = true;
        while(playAgain){
            System.out.println("Game is in progress...");
            System.out.println("Game has finished");

            System.out.print("Do you want to play again: ");
            playAgain = in.nextLine().equals("Yes");
            in.close();
        }

        System.out.println("Bye.");
    }

    private static int getNumber() {
        boolean validInput = false;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a number [1, 10]: ");
        while(!validInput){
            String input = in.nextLine();

            try{
                int result = Integer.parseInt(input);
                if(result >= 1 && result <= 10)
                    return result;
                System.out.println("Only numbers between 1 and 10 please");
            
            }catch(Exception ex){
                System.out.println("Only numbers between 1 and 10 please");                
            }
            in.close();
        }
        return 0;
        
    }
}
