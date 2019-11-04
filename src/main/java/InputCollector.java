import java.util.Scanner;

public class InputCollector {
    public static String getUserInput(String prompt){
        System.out.println(prompt);
        String input = new Scanner(System.in).nextLine();
        while (Validator.isEmptyString(input)) {
            input = new Scanner(System.in).nextLine();
        }

        return input;
    }

    public static int getUserInputNumber(String prompt){
        System.out.println(prompt);
        String input = new Scanner(System.in).nextLine();

        while (Validator.isNotNumeric(input)) {
            input = new Scanner(System.in).nextLine();
        }

        return Integer.parseInt(input);
    }
}