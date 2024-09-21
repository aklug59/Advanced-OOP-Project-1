import java.util.ArrayList;

public class Rover {

    //Variable and Data structure declarations
    GUI localRoverGUI =  new GUI();
    static int maxXPosition = Plateau.getPlateauXMax();
    static int maxYPosition = Plateau.getPlateauYMax();
    public static boolean finalCommand = false;
    static Position position;


    //Rover constructor, takes an ArrayList containing the rovers starting position and heading

    public Rover(ArrayList<Character> newRover) {
        position = new Position(newRover.get(0), newRover.get(1), CardinalDirection.fromCharacter(newRover.get(2)));
        localRoverGUI.addGUIRoverIcon(position);
    }


    public static void moveRover(ArrayList<Character> moveCommand) {

        //Logic to move the rover by updating currPosition + currHeading AND send update the GUI.

        //For every character in the movement command, get the character and then perform appropriate logic is L, R or M
        for (int i = 0; i < moveCommand.size(); i++) {
            if (i == moveCommand.size() - 1) {
                finalCommand = true;
            }

            char currMovementCommand = moveCommand.get(i);

            switch(currMovementCommand) {

                case 'L':
                    position.heading = position.heading.ninetyDegreesLeft();
                case 'R':
                    position.heading = position.heading.ninetyDegreesRight();
                case 'M':
                default:
                    // code block
            }
        }
    if (finalCommand) {
        printRoverPosition();
    }

    }

    public static void printRoverPosition() {
        System.out.println("The rover is now at " + position.x + " " + position.y + ", Heading is " + position.heading);

    }
}
