import java.util.ArrayList;

public class InputFilter {

    public static void inputIdentifier(String currInput) {

        ArrayList<Character> characterList = new ArrayList<Character>();


        for(int i = 0; i < currInput.length(); i++) {
            if (currInput.charAt(i) != ' ') {
                characterList.add(currInput.charAt(i));
            }
        }

        //If the first character in the character list is a digit, we have either a plateau or an initial rover position
        if (Character.isDigit(characterList.get(0))) {
            int characterListLength = characterList.size();

            //If the last character in the list is a digit, plateau, else rover position
            if (Character.isDigit(characterList.get(characterListLength - 1))) {
                System.out.println("We have a new plat!");
                new Plateau(characterList);

            } else {
                System.out.println("We have a new rover!");
                new Rover(characterList);
                //NEW ROVER CASE
            }

        //If the first character is a char, we have a movement command.
        } else {
            System.out.println("We have a movement command!");
            Rover.moveRover(characterList);



        }

    }
}
