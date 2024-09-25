import java.util.ArrayList;

public class Plateau {

    public static int plateauXMax = 0;
    public static int plateauYMax = 0;
    private final GUI plateauLocalGUI =  GUI.getGUIInstance();
    int intValue;

    public Plateau(ArrayList<Character> initialDimensions) {


        if (!CreationChecks.plateauMade) {
            plateauXMax = Character.getNumericValue(initialDimensions.get(0));
            plateauYMax = Character.getNumericValue(initialDimensions.get(1));
            CreationChecks.plateauMade = true;
            plateauLocalGUI.createPlateau(plateauXMax,plateauYMax);

        } else {
            ErrorHandler.plateauExists();
        }

    }

    public static int getPlateauXMax() {
        return plateauXMax;
    }

    public static int getPlateauYMax() {
        return plateauYMax;
    }


}
