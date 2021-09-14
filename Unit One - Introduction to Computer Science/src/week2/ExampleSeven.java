package week2;

/**
 * final modifier
 */
public class ExampleSeven {
    public static void main(String[] args) {
     final int x = 7;
     //x = 6; //cannot reassign a value to a final variable
     
     final int y;
    y =8;
    //y++; //cannot modify a value to a final variable once constant

    //name constants using all CAPITALS_AND_UNDERSCORES
    final int NUM_STUDENTS = 18;

    System.out.println(x+y+NUM_STUDENTS);

    }
}
