import java.util.ArrayList;

public class Plateau {

    public static int plateauXMax = 0;
    public static int plateauYMax = 0;
    public boolean plateauMade = false;
    int intValue;

    public Plateau(ArrayList<Character> initialDimensions) {

        if (!plateauMade) {
            plateauXMax = Character.getNumericValue(initialDimensions.get(0));
            plateauYMax = Character.getNumericValue(initialDimensions.get(1));
            this.plateauMade = true;

        } else {
            //Throw some type of error to inform the user a plateau already exists.
        }



    }

    public static int getPlateauXMax() {
        return plateauXMax;
    }

    public static int getPlateauYMax() {
        return plateauYMax;
    }

    //Return the arraylist with the current dimensions of the plateau.


}
