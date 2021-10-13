package week6;

public class EquivalentExpressions {
    public static void main(String[] args) {
        int x = 6;
        boolean result = (x > 7); // result = false
        //simple boolean expression (x > 8)
        //compound boolean expression (x > 7) && (x < 10) --> uses || / &&
        
        System.out.println(result);
    }
}