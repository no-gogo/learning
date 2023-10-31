import java.util.Scanner;

public class Calculator_original {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] doubles = new double[]{0.0, 0.0};
        int[] ints = new int[]{0,0};
        String[] strings = new String[2];

        // Print a Welcome message and menu
        System.out.println("List of operations: add subtract multiply divide alphabetize");
        
        // Get the user's input, convert to lowercase
        System.out.println("Enter an operation:");
        String input = scanner.nextLine();
        String lowerCaseInput = input.toLowerCase();

        switch (lowerCaseInput) {
            case "add":
                System.out.print("Enter two integers:\n");
                if (scanner.hasNextInt()) {
                    ints[0] = scanner.nextInt();
                }
                else{
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
                if (scanner.hasNextInt()) {
                    ints[1] = scanner.nextInt();
                }
                else{
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }

                System.out.println("Answer: " + (ints[0] + ints[1]));
                break;
            case "subtract":
                System.out.print("Enter two integers:\n");
                if (scanner.hasNextInt()) {
                    ints[0] = scanner.nextInt();
                }
                else{
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
                if (scanner.hasNextInt()) {
                    ints[1] = scanner.nextInt();
                }
                else{
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
                System.out.println("Answer: " + (ints[0] - ints[1]));
                break;
            case "multiply":
                doubles = get2doubles(scanner);
                System.out.println("Answer: " + String.format("%.2f", (doubles[0] * doubles[1])));
                break;
            case "divide":
                doubles = get2doubles(scanner);
                if (doubles[1] != 0)
                    System.out.println("Answer: " + String.format("%.2f", (doubles[0] / doubles[1])));
                else
                    System.out.println("Invalid input entered. Terminating...");
                break;
            case "alphabetize":
                strings = get2strings(scanner, strings);

                if (strings[0].compareToIgnoreCase(strings[1]) < 0) {
                    System.out.println("Answer: " + "\"" + strings[0] + "\" comes before \"" + strings[1] + "\" alphabetically.");
                } else if (strings[0].compareToIgnoreCase(strings[1]) > 0) {
                    System.out.println("Answer: " + "\"" + strings[1] + "\" comes before \"" + strings[0] + "\" alphabetically.");
                } else {
                    System.out.println("Answer: Chicken or Egg.");
                }
                break;

            default:
                System.out.println("Invalid input entered. Terminating...");
                break;
        }

        scanner.close();
    }

    public static double[] get2doubles(Scanner scanner) {
        double[] nums = new double[2];
        System.out.print("Enter two doubles:\n");
        nums[0] = scanner.nextDouble();
        nums[1] = scanner.nextDouble();
        return nums;
    }

    public static int[] get2ints(Scanner scanner) {
        int[] nums = new int[2];
        System.out.print("Enter two integers:\n");
        nums[0] = scanner.nextInt();
        nums[1] = scanner.nextInt();
        return nums;
    }    


    public static String[] get2strings(Scanner scanner, String[] strings) {
        System.out.print("Enter two words:\n");
        strings[0] = scanner.next();
        strings[1] = scanner.next();
        return strings;
    }

}
