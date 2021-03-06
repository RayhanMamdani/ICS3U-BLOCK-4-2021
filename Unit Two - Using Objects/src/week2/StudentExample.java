package week2;

public class StudentExample {
    public static void main(String[] args) {
        Student fred = new Student("Fred", "654321", 10);
        Student max = new Student("Max", "123456", 10);
        Student muriel = fred; 
        muriel.increaseGrade();
        max.displayGrade();

        fred = null;
        // fred.displayName(); // fred = null -> java throws a NullPointerException

        max.addTest(87);
        max.addTest(94);
        max.addTest(98);
        max.addTest(67);
        double maxAverage = max.getAverage();
        max.displayAverage();

        System.out.println(max.getName() + "has an average of " + maxAverage);

        Student david = new Student("David", "56585");
        david.displayGrade();
    }
}
