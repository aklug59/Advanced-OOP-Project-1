import java.util.ArrayList;

public class InputFilter {

    public void validInput(String userInput) {
        if (userInput.matches("\\d{1} \\d{1}") || userInput.matches("\\d{1} \\d{1} [NESW]") || userInput.matches("[LMR]*")) {
            System.out.println("Valid input");
            System.out.println("Input was " + userInput);
            inputIdentifier(userInput);
        } else {
            System.out.println("That is not a valid Input!");
        }


    }

    public static void inputIdentifier(String currInput) {

        ArrayList<Character> characterList = new ArrayList<Character>();

        for(int i = 0; i < currInput.length(); i++) {
            if (currInput.charAt(i) != ' ') {
                characterList.add(currInput.charAt(i));
            }
        }

        //If the first character in the character list is a digit, we have either a plateau or an initial rover position
        if (Character.isDigit(characterList.getFirst())) {
            int characterListLength = characterList.size();

            //If the last character in the list is a digit, plateau, else rover position
            if (Character.isDigit(characterList.get(characterListLength - 1))) {
                new Plateau(characterList);
            } else {
                new Rover(characterList);
            }

        //If the first character is a char, we have a movement command.
        } else {
            Rover.moveRover(characterList);
        }

    }
}
