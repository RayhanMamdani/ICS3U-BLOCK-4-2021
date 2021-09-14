package testStuff;

public class modulusTest {
    public static void main(String[] args) {
        int num = 5672;
        int num1 = num / 1000;  //5
        int num4 = 5672 % 10;
        int num2 = 5672 % 1000 / 100; //5672 % 1000 => 672   672 / 100 => 6
        int num3 = num % 100 / 10; //7

        System.out.println(num1+num2+num3+num4);
    }
    
}
