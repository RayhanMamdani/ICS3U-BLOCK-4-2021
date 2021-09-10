package week1;

/**
 * Escape Sequences
 */

 public class ExampleThree {
    public static void main(String[] args) {
        //System.out.println("This is "very" important!"); //double quotes encapsulate string literals - putting a quote in a string literal gets Java upset
        
        System.out.println("This is \"very\" importan!t"); //backslash (\) espaces a character - creates an escape sequence
    
        //System.out.println("This is \very important!"); //\v is not a valid escape sequence
    
        System.out.println("This is \\very important!");

        System.out.println("This\nis\nvery\nimportan!t");

        /**
         * AP Exam tests ONLY on \" \n and \\
         */
    }
}
