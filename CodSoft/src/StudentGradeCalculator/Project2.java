package StudentGradeCalculator;
//--STUDENT GRADE CALCULATOR TASK--//
import java.util.Scanner;

class Project2 {
    private int[] marks;
    Project2(int numOfSubjects) {
        marks = new int[numOfSubjects];
    }
    public void inputMarks() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
    }
    public int getTotalMarks() {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return totalMarks;
    }
    public double getAveragePercentage() {
        int totalMarks = getTotalMarks();
        return totalMarks / (double) marks.length;
    }
    public String getGrade() {
        double averagePercentage = getAveragePercentage();
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
    public void displayResults() {
        int totalMarks = getTotalMarks();
        double averagePercentage = getAveragePercentage();
        String grade = getGrade();

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numOfSubjects = scanner.nextInt();

        Project2 project = new Project2(numOfSubjects);

        project.inputMarks();
        project.displayResults();
    }
}
