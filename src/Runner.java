import java.util.Scanner;

public class Runner {

    private static Scanner scan;
    private static String instruct;
    private static GameWheel wheel;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        wheel = new GameWheel();
        instruct = "";
        while (!instruct.equals("q")) {
            System.out.println("Type \"t\" to test GameWheel methods, \"q\" to quit.");
            instruct = scan.nextLine();
            if (instruct.equals("t"))
                testMethods();
            else if (!instruct.equals("q"))
                System.out.print("Instruction not recognized");
            System.out.println();
        }
    }

    private static void testMethods() {
        while (!instruct.equals("q") && !instruct.equals("m")) {
            System.out.println("Choose an option:");
            System.out.println("1. Display the wheel");
            System.out.println("2. Scramble the wheel");
            System.out.println("3. Sort the wheel");
            System.out.println("4. Create a new wheel");
            System.out.println("5. Run a random prize test");
            System.out.println("6. Return to main menu");
            System.out.println("7. Quit");

            instruct = scan.nextLine();
            switch (instruct) {
                case "1":
                    System.out.println(wheel);
                    break;
                case "2":
                    wheel.scramble();
                    System.out.println("Wheel scrambled!");
                    break;
                case "3":
                    wheel.sort();
                    System.out.println("Wheel sorted!");
                    break;
                case "4":
                    wheel = new GameWheel();
                    System.out.println("New wheel created!");
                    break;
                case "5":
                    ranTest();
                    break;
                case "6":
                    return;
                case "7":
                    System.exit(0);
                default:
                    System.out.println("Option not recognized");
            }
        }
    }

    private static void ranTest() {
        int numLines = getIntInput("Enter the number of tests:");
        for (int i = 0; i < numLines; i++) {
            wheel.scramble();
            for (int j = 0; j < 20; j++)
                System.out.print(wheel.getSlice(j).getPrizeAmount() + " ");
            System.out.println();
        }
    }

    private static int getIntInput(String prompt) {
        int input = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println(prompt);
                input = Integer.parseInt(scan.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return input;
    }
}
