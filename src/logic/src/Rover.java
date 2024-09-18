import java.util.ArrayList;

public class Rover {

    static char noHeading = 't';
    private static int[] currPosition = new int[2];
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
        //Logic to move the rover by updating currPosition + currHeading AND send update the GUI.

        int maxXPosition = Plateau.getPlateauXMax();
        int maxYPosition = Plateau.getPlateauYMax();

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
                            break;
                        }
                    }
                    break;

                case 'M':
                    int currXPosition = currPosition[0];
                    int currYPosition = currPosition[1];
                    switch(currHeading) {
                        case 'N':
                            if (currYPosition + 1 <= maxYPosition) {
                                currPosition[1]++;
                            } else {
                                //Throw Error
                                System.out.println("You killed the rover!");
                            }
                            break;
                        case 'E':
                            if (currXPosition + 1 <= maxXPosition) {
                                currPosition[0]++;
                            } else {
                                //Throw Error
                                System.out.println("You killed the rover!");
                            }
                            break;
                        case 'S':
                            if (currYPosition - 1 >= 0) {
                                currPosition[1]--;
                            } else {
                                //Throw Error
                                System.out.println("You killed the rover!");
                            }
                            break;
                        case 'W':
                            if (currXPosition - 1 >= 0) {
                                currPosition[0]--;
                            } else {
                                //Throw Error
                                System.out.println("You killed the rover!");
                            }
                            break;
                        default:
                            // code block
                    }
                    break;
                default:
                    // code block
            }
            System.out.println("The rover is now at " + currPosition[0] + " " + currPosition[1] + " Heading is " + currHeading);
        }


    }
}
