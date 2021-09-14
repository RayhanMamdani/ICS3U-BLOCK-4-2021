package week2;
/**
 * (- b + Math.Sqrt(b * b - (4 * a * c)))/2 * a
 * (- b - Math.Sqrt(b * b - (4 * a * c)))/2 * a
 */
public class HW10 {
    public static void main(String[] args) {
        double a = 2;
        double b = 13;
        double c = 2;
        double root1 = - b + (Math.sqrt(b * b - (4 * a * c)))/(2 * a);
        double root2 = - b - (Math.sqrt(b * b - (4 * a * c)))/(2 * a);

        System.out.println(root1);
        System.out.println(root2);
    }
    
}
