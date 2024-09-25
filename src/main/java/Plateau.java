import java.util.ArrayList;

public class Plateau {

    public static int plateauXMax = 0;
    public static int plateauYMax = 0;
    private final GUI plateauLocalGUI =  GUI.getGUIInstance();
    int intValue;

    /**
     * Plateau constructor.
     * @param initialDimensions 2 variable arraylist of the x and y dimensions of the plateau
     */

    public Plateau(ArrayList<Character> initialDimensions) {


        if (!CreationChecks.plateauMade) {
            plateauXMax = Character.getNumericValue(initialDimensions.get(0));
            plateauYMax = Character.getNumericValue(initialDimensions.get(1));
            CreationChecks.plateauMade = true;
            plateauMatrix = new Character[plateauXMax][plateauYMax];
            for (int i = 0; i < Plateau.getPlateauXMax(); i++) {
                for (int j = 0; j < Plateau.getPlateauYMax(); j++) {
                    plateauMatrix[i][j] = 'O';
                }
            }
        } else {
            ErrorHandler.plateauExists();
        }

    }

    /**
     * Method for outside classes to access the x dimension of the plateau
     * @return returns the x dimension of the plateau
     */
    public static int getPlateauXMax() {
        return plateauXMax;
    }

    /**
     * Method for outside classes to access the y dimension of the plateau
     * @return returns the y dimension of the plateau
     */
    public static int getPlateauYMax() {
        return plateauYMax;
    }

    public static Character[][] getMatrix() { return plateauMatrix; }
}
