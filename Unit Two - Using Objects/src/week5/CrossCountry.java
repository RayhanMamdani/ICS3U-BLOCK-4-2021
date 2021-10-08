package week5;

import java.util.Scanner;

//The class with all the methods for the assignment
//Display Format = mm:ss.sss
public class CrossCountry {
    /**
     * Creates an instance of the Scanner class
     * Calls the processRunner method 3 times using the "in" as a param
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        processRunner(in);
        processRunner(in);
        processRunner(in);
        in.close();
    }
    /**
     * Process data for a runner
     * Creates dialoge to gather information using Scanner
     * Uses information to do math and find times for each split using the subtract time method
     * @param in imports the scanner so we can use it to store user inputs
     */
    private static void processRunner(Scanner in) {

        String firstName, lastName;
        System.out.print("Please input the first name of the runner: ");
        firstName = in.nextLine();
        System.out.print("Thank you. Please input the last name of the runner: ");
        lastName = in.nextLine();
        String mileOne, mileTwo, finish;
        System.out.print("Input the time that it took " + firstName + " to finish the first mile in the format of \"mm:ss.sss\": ");
        mileOne = in.nextLine();
        System.out.print("Thank you. Input the time that it took " + firstName + " to finish the second mile in the format of \"mm:ss.sss\": ");
        mileTwo = in.nextLine();
        System.out.print("Thank you. Input the time that it took " + firstName + " to finish the race in the format of \"mm:ss.sss\": ");
        finish = in.nextLine();
        String splitTwo, splitThree;
        /**
         * get the first and last name of the runner
         * get the mileOne, mileTwo and finish times for the runner
         */
         splitTwo = subtractTime(mileTwo, mileOne);
         splitThree = subtractTime(finish, mileTwo);
         System.out.println("--- Runner Summary ---");
         System.out.println("Runner Name: " + lastName + ", " + firstName);
         System.out.println("Split One: " + mileOne);
         System.out.println("Split Two: " + splitTwo);
         System.out.println("Split Three: " + splitThree);
         System.out.println("Finish Time: " + finish);
         System.out.println("--- End of Runner Summary ---");
         /**
          * Display a summary for the runner
          */
    }
    /**
     * This method takes two times and subtracts them to get the difference
     * @param endTime the time being subtracted from (the larger one) as a String
     * @param startTime the time we are subtracting (the smaller one) as a String
     * @return the difference of the params as a String in display format
     */
    private static String subtractTime(String endTime, String startTime) {
        double endSeconds = convertToSeconds(endTime);
        double startSeconds = convertToSeconds(startTime);
        double diffInSeconds = endSeconds - startSeconds;
        return convertToTime(diffInSeconds);
    }
    /**
     * Takes a time and converts it from a double to the display format to return
     * @param origTimeSeconds the time we want to convert to the display format as a double
     * @return the time in the mm:ss.sss display format as a String
     */
    private static String convertToTime(double origTimeSeconds) {
        int minutes = (int) origTimeSeconds / 60;
        double seconds = origTimeSeconds % 60;

        return String.format("%d:%06.3f", minutes, seconds);
    }
    /**
     * This method takes the time from the display format and changes it to a double so we can do math on it
     * @param origTime the display format we want to change as a String
     * @return the time in seconds that we can do math on as a double
     */
    private static double convertToSeconds(String origTime) {
        double min = Double.parseDouble(origTime.substring(0, origTime.indexOf(":")));
        double sec = Double.parseDouble(origTime.substring(origTime.indexOf(":") + 1, origTime.indexOf(".")));
        double milsec = (Double.parseDouble(origTime.substring(origTime.indexOf(".") + 1))) / 1000;
        return min * 60 + sec + milsec;
    } 
}
