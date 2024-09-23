import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        String userInput = "";

        while(!userInput.equals("x")) {
            System.out.print("Please enter a command: ");
            userInput = inputScanner.next();
            System.out.println("Good input!");

            if (userInput.equals("x")) {
                System.out.println("Thanks f");
            }
        }




    }
}