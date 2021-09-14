package week2;

public class HW9 {
    public static void main(String[] args) {
        double pennies = 3;
        double nickels = 3;
        double dimes = 6;
        double quarters = 7;
        double loonies = 3;
        double toonies = 4;

        double total = pennies * 0.01 + nickels * 0.05 + dimes * 0.1 + quarters * 0.25 + loonies + toonies * 2;

        System.out.println("The user has: $" + total);
    }
}
