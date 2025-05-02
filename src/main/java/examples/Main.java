package examples;

import com.harium.suneidesis.math.SequenceSolver;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SequenceSolver solver = new SequenceSolver();

        System.out.println("Enter a sequence of numbers separated by spaces:");
        String input = scanner.nextLine();
        String[] terms = input.split(" ");

        SequenceSolver.PatternType result = solver.detectPattern(terms);
        System.out.println("Detected pattern: " + result);

        scanner.close();
    }
}
