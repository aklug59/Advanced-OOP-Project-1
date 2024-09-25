import java.util.ArrayList;

public class Rover {

    //Variable and Data structure declarations
    GUI localRoverGUI = GUI.getGUIInstance();
    public static boolean finalCommand = false;
    static Position position;


    /**
     * Rover constructor
     * @param newRover Arraylist containing the starting position and starting heading of the new rover
     */

    public Rover(ArrayList<Character> newRover) {
        position = new Position(Character.digit(newRover.get(0), 10), Character.digit(newRover.get(1), 10), CardinalDirection.fromCharacter(newRover.get(2)));
        localRoverGUI.addGUIRoverIcon(position);
        printRoverPosition();
    }

    /**
     * Method to move the rover by updating currPosition, currHeading AND send a movement update to the GUI.
     * @param moveCommand Arraylist of VALID movement commands: L, R, M
     */
    public static void moveRover(ArrayList<Character> moveCommand) {

        //For every character in the movement command, get the character and then perform appropriate logic is L, R or M
        for (int i = 0; i < moveCommand.size(); i++) {

            if (i == moveCommand.size() - 1) {
                finalCommand = true;
            }

            char currMovementCommand = moveCommand.get(i);

            switch(currMovementCommand) {

                case 'L':
                    position.heading = position.heading.ninetyDegreesLeft();
                    break;
                case 'R':

                    position.heading = position.heading.ninetyDegreesRight();
                    break;
                case 'M':
                    position.moveOne();
                    break;
                default:
                    // code block
            }

            if (finalCommand) {
                printRoverPosition();
                finalCommand = false;
                break;
            }
        }


    }

    /**
     * Method to print the rovers final position.
     */
    public static void printRoverPosition() {
        System.out.println("The rover is now at " + position.x + " " + position.y + ", Heading is " + position.heading);

    }
}
