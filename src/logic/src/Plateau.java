import java.util.ArrayList;

public class Plateau {

    public static int plateauXMax = 0;
    public static int plateauYMax = 0;
    int intValue;
    public static Character[][] plateauMatrix;

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

    public static int getPlateauXMax() {
        return plateauXMax;
    }

    public static int getPlateauYMax() {
        return plateauYMax;
    }

    public static Character[][] getMatrix() { return plateauMatrix; }
}
