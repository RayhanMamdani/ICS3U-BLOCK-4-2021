package week3;

public class RandomNumberExamples {
    public static void main(String[] args) {

        double r = Math.random();

        //System.out.println(r);

        /**
        for (int i = 0; i < 100; i++){
            System.out.println(Math.random());
        */

        int lower = -5;
        int upper = 5;
        int numPossibilities = (upper - lower + 1);

        int rand = (int) (r * numPossibilities) + 1;
        System.out.println(rand);

        String str = "Random Numbers";      //Change a random character in str to "x"

        int index = (int) (Math.random() * str.length());
        str = str.substring(0, index) + "x" + str.substring(index + 1);
        }
    }
    

