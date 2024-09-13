import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean valid = true;
        do {
            System.out.println("Select the BMI calculator: 1(kg/m)) or 2(lb/feet.inch)");
            switch (sc.nextInt()) {
                case 1:
                    bmiV1();
                    valid = false;
                    break;
                case 2:
                    bmiV2();
                    valid = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while (valid);
    }

    // Weight (kg) / Height (m)^2
    public static void bmiV1() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your weight in kilogram:");
        double weightKg = input.nextInt();

        System.out.println("Enter your weight in metre:");
        double height = input.nextDouble();

        double bmi = weightKg / Math.pow(height, 2);
        DecimalFormat df = new DecimalFormat("#.#");

        System.out.println("Your BMI is " + df.format(bmi));
    }

    // Weight (lb) / Height (in)^2 * 703
    public static void bmiV2() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your weight in pounds:");
        double weightLb = input.nextDouble();

        System.out.println("Enter your height in feet:");
        int heightFeet = input.nextInt();

        System.out.println("Enter your height in inches:");
        double heightInches = input.nextDouble();
        input.close();

//  w 66 kg -> 145.505 lb / h 1.75 m -> 175 cm -> 68.9 inch -> 5 feet + 8.9 inch
        double totalHeightInInches = (heightFeet * 12) + heightInches;

//      double bmi = weight / (height * height) * 703;
        double bmi = weightLb / Math.pow(totalHeightInInches, 2) * 703;
        DecimalFormat df = new DecimalFormat("#.#");

        System.out.println("Your BMI is " + df.format(bmi));
    }
}