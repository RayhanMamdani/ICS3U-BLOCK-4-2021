package week2;

public class HW3 {
    public static void main(String[] args) {
        int num = 56725;
        int digit4 = num / 10 % 10;
        int digit2 = num / 1000 % 10;

        System.out.println("The product of the second digit and fourth digit is: " + digit2*digit4);
    } 
}
