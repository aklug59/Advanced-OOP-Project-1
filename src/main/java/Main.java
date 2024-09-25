import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    /**
     * Simple while loop to continually prompt the user for input, character "x" may be entered to stop the program.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Mars Rover Control Console!");
        Scanner inputScanner = new Scanner(System.in);
        String userInput = "";
        InputFilter input =  new InputFilter();

        while(!userInput.equals("x")) {
            System.out.print("Please enter a command: ");
            userInput = inputScanner.nextLine();

            if (userInput.equals("x")) {
                System.out.println("Thanks for using the Mars Rover Control Console! The program will now terminate");
                System.exit(0);
            }
            input.validInput(userInput);
        }
    }
}