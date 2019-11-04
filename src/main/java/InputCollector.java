import java.util.Scanner;

public class InputCollector {
    public static String getUserInput(String prompt){
        System.out.println(prompt);
        String input = new Scanner(System.in).nextLine();
        while (input.isEmpty()) {
            System.out.println("You must enter this filed");
            input = new Scanner(System.in).nextLine();
        }
        return input;
    }
}
