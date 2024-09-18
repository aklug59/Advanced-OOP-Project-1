import java.util.ArrayList;

public class Rover {

    static char noHeading = 't';
    private int[] currPosition = new int[2];
    static char currHeading = noHeading;
    GUI localRoverGUI =  new GUI();
    private static char[] headingsList = {'N','E','S','W'};

    public Rover(ArrayList<Character> newRover) {
        currPosition[0] = Character.getNumericValue(newRover.get(0));
        currPosition[1] = Character.getNumericValue(newRover.get(1));
        currHeading = newRover.get(2);

        localRoverGUI.addGUIRoverIcon(currPosition, currHeading);

        System.out.println("The rovers position is " + currPosition[0] + " " + currPosition[1] + " " + currHeading);
    }

    public static void moveRover(ArrayList<Character> moveCommand) {
        System.out.println("sent");

        //Logic to move the rover by updating currPosition + currHeading AND send update the GUI.

        for (int i = 0; i < moveCommand.size(); i++) {

            char currMovementCommand = moveCommand.get(i);

            switch(currMovementCommand) {

                case 'L':
                    for (int m = 0; m < headingsList.length; m++) {
                        if (headingsList[m] == currHeading) {
                            if(m == 0) {
                                currHeading = headingsList[3];
                            } else {
                                currHeading = headingsList[m-1];
                            }
                            //System.out.println(currHeading + " ");
                            break;
                        }
                    }
                    break;

                case 'R':
                    for (int m = 0; m < headingsList.length; m++) {
                        if (headingsList[m] == currHeading) {
                            if(m == 3) {
                                currHeading = headingsList[0];
                            } else {
                                currHeading = headingsList[m+1];
                            }
                            //System.out.println(currHeading + " ");
                            break;
                        }
                    }
                    break;

                case 'M':
                    switch(currHeading) {
                        case 'N':
                            if ()
                            break;
                        case 'E':
                            // code block
                            break;
                        case 'S':
                            // code block
                            break;
                        case 'W':
                            // code block
                            break;
                        default:
                            // code block
                    }
                    break;
                default:
                    // code block
            }
        }


    }
}
