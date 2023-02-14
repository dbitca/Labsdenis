import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subject {
    private String name;
    private List<Integer> marks = new ArrayList<>();

    public Subject(String name) {
        this.name = name;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void addMark(int mark) {
        if (0 < mark && mark <= 150)
            marks.add(mark);
        else
            System.out.println("You entered the wrong mark");
    }

    public String getName() {
        return name;
    }

    public double getAverage() {
        if (marks.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.size();
    }

    public double getStandardDeviation() {
        if (marks.isEmpty()) {
            return 0.0;
        }
        double mean = getAverage();
        double sumOfSquares = 0.0;
        for (int mark : marks) {
            sumOfSquares += Math.pow(mark - mean, 2);
        }
        return Math.sqrt(sumOfSquares / marks.size());
    }

    public int getMinimum() {
        return Collections.min(marks);
    }

    public int getMaximum() {
        return Collections.max(marks);
    }

    public int getRange() {
        return getMaximum() - getMinimum();
    }

    public void generateGradeHistogram() {
        int[] gradeCounts = new int[10]; // assuming 10 grades ranging from 0-100
        for (int mark : marks) {
            int grade = mark / 10; // divide marks by 10 to get the grade (0-9)
            gradeCounts[grade]++;
        }
        System.out.println("Grade Histogram for " + name + ":");
        for (int i = 0; i < gradeCounts.length; i++) {
            System.out.printf("%d-%d: %d%n", i * 10, i * 10 + 9, gradeCounts[i]);
        }
    }
}