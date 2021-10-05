package week3;

public class ExtraPractice {
    public static void main(String[] args) {
        exampleOne();
        exampleTwo();
        System.out.println(exampleThree());
        System.out.println(exampleFour(6, 19));
        System.out.println(exampleFive("lawnmower"));
        System.out.println(exampleSix("Television", "ele"));
        System.out.println(exampleSeven("tourist", "tree"));
        System.out.println(exampleEight(4.0, 8.0, 19.0, 27.0));
        System.out.println(exampleNine(5.3, 9.0));
        System.out.println(exampleTen("Keyboard"));
    }

    public static void exampleOne() {
        int num = (int) (Math.random() * 100) + 1;
        // (int)(Math.random() * numPossibilities) + lowest value
        System.out.println(num);
    }
    public static void exampleTwo() {
        int num = (int) (Math.random() * 100) - 50;
        System.out.println(num);
    }
    public static int exampleThree() {
        int diceRoll = (int) (Math.random() * 6) + 1;
        return diceRoll;
    }
    public static int exampleFour(int lowest, int highest) {
        int num = (int) (Math.random() * (highest - lowest + 1)) + lowest;
        return num;
    }
    public static String exampleFive(String str) {
        return str.substring(0, str.indexOf("e")) + str.substring(str.indexOf("e") + 1);
    }
    public static String exampleSix(String str, String remove) {
        return str.substring(0, str.indexOf(remove)) + str.substring(str.indexOf(remove) + remove.length());
    }
    public static int exampleSeven(String str1, String str2) {
        return str1.length() + str2.length();
    }
    public static double exampleEight(double x1, double x2, double y1, double y2) {
        return ((x1 - x2) / (y1 - y2));
    }
    public static double exampleNine(double radius, double height) {
        return radius * radius * Math.PI * height;
    }
    public static String exampleTen(String str) {
        int randomChar = (int) (Math.random() * str.length()) + 1;
        return str.substring(0, randomChar) + str.substring(randomChar + 1);
    }
}
