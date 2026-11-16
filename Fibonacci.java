
import java.util.Scanner;

public class Fibonacci {

    static int recursiveSteps = 0;

    // Recursive method
    static int fibonacciRecursive(int n) {

        recursiveSteps++;

        if (n <= 1) {
            return n;
        }

        return fibonacciRecursive(n - 1)
             + fibonacciRecursive(n - 2);
    }

    // Iterative method
    static void fibonacciIterative(int n) {

        int a = 0, b = 1;
        int steps = 0;

        System.out.println("Iterative Fibonacci:");

        for (int i = 0; i < n; i++) {

            System.out.print(a + " ");

            int c = a + b;
            a = b;
            b = c;

            steps++;
        }

        System.out.println("\nIterative Steps: " + steps);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        fibonacciIterative(n);

        System.out.println("\nRecursive Fibonacci:");

        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }

        System.out.println("\nRecursive Steps: " + recursiveSteps);

        sc.close();
    }
}
