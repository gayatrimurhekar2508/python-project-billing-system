import java.util.Scanner;

class Calculator {
    public double add(double a, double b) { return a + b; }
    public double subtract(double a, double b) { return a - b; }
    public double multiply(double a, double b) { return a * b; }
    public double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero.");
        return a / b;
    }
}

public class CalculatorWithExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();
        System.out.println("===== CALCULATOR =====");
        try {
            System.out.print("Enter first number: ");
            double a = Double.parseDouble(sc.nextLine());
            System.out.print("Enter second number: ");
            double b = Double.parseDouble(sc.nextLine());

            System.out.println("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division");
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            double result;
            switch (choice) {
                case 1: result = calc.add(a,b); break;
                case 2: result = calc.subtract(a,b); break;
                case 3: result = calc.multiply(a,b); break;
                case 4: result = calc.divide(a,b); break;
                default: throw new IllegalArgumentException("Invalid operation choice.");
            }
            System.out.printf("Result = %.2f%n", result);
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid numbers.");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("Calculator program completed.");
        }
    }
}
