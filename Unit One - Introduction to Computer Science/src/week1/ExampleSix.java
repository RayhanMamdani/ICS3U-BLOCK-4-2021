package week1;

public class ExampleSix {
    public static void main(String[] args) {
        
        int x = 1;
        int y = 2;

        x = x + 1; // (x = 2)
        y = y - 1; // (y = 1)
        
        x += 1; // equivalent to x = x + 1
        y -= 1; // equivalent to y = y - 1

        int s = 5;
        s++;
        ++s;
        s--;
        --s;
        
        int g = 3;
        int f = 3;

        int test1 = 2 * g++; //test1 = 6, g = 4 (adds after)
        int test2 = 2* ++f;  //test2 = 8, f = 4 (adds before)
    
    }
}
