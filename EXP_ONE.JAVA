import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WeatherModel {

    public static double calculateTemperature(double a, double b, double c, double t) {
        return a * t * t + b * t + c;
    }

    public static void hardcodedMode() {
        double a = -0.2, b = 2.5, c = 15, t = 5;
        double temperature = calculateTemperature(a, b, c, t);
        System.out.println("Hardcoded Mode:");
        System.out.println("At time t = " + t + ", temperature = " + temperature + "°C\n");
    }

    public static void keyboardInputMode(Scanner scanner) {
        System.out.println("Keyboard Input Mode:");
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();

        System.out.print("Enter time t: ");
        double t = scanner.nextDouble();

        double temperature = calculateTemperature(a, b, c, t);
        System.out.println("At time t = " + t + ", temperature = " + temperature + "°C\n");
    }

    public static void fileSingleInputMode() {
        System.out.println("File Input Mode (Single Set):");
        try {
            Scanner fileScanner = new Scanner(new File("input_single.txt"));
            double a = fileScanner.nextDouble();
            double b = fileScanner.nextDouble();
            double c = fileScanner.nextDouble();
            double t = fileScanner.nextDouble();

            double temperature = calculateTemperature(a, b, c, t);
            System.out.println("At time t = " + t + ", temperature = " + temperature + "°C\n");

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File 'input_single.txt' not found.\n");
        }
    }

    public static void fileMultipleInputMode() {
        System.out.println("File Input Mode (Multiple Sets):");
        try {
            Scanner fileScanner = new Scanner(new File("input_multiple.txt"));
            int set = 1;
            while (fileScanner.hasNextDouble()) {
                double a = fileScanner.nextDouble();
                double b = fileScanner.nextDouble();
                double c = fileScanner.nextDouble();
                double t = fileScanner.nextDouble();

                double temperature = calculateTemperature(a, b, c, t);
                System.out.println("Set " + set + ": At t = " + t + ", temperature = " + temperature + "°C");
                set++;
            }
            System.out.println();
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File 'input_multiple.txt' not found.\n");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----- Weather Modeling using Quadratic Equation -----");
            System.out.println("1. Hardcoded Input");
            System.out.println("2. Keyboard Input");
            System.out.println("3. File Input (Single Set)");
            System.out.println("4. File Input (Multiple Sets)");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    hardcodedMode();
                    break;
                case 2:
                    keyboardInputMode(scanner);
                    break;
                case 3:
                    fileSingleInputMode();
                    break;
                case 4:
                    fileMultipleInputMode();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.\n");
            }
        }
    }
}
