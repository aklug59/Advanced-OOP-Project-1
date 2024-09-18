import java.util.ArrayList;

public class Plateau {
    private int[] plateauDimensions = new int[2];

    public int plateauXMax = 0;
    public int PlateauYMax = 0;
    public boolean plateauMade = false;
    int intValue;

    public Plateau(ArrayList<Character> initialDimensions) {

        if (!plateauMade) {
            for(int i = 0; i < initialDimensions.size(); i++) {
                intValue = Integer.valueOf(initialDimensions.get(i));
                plateauDimensions[i] = intValue;
            }

            this.plateauMade = true;

        } else {
            //Throw some type of error to inform the user a plateau already exists.
        }



    }

    public int getPlateauXMax() {
        return plateauXMax;
    }

    public int getPlateauYMax() {
        return PlateauYMax;
    }

    //Return the arraylist with the current dimensions of the plateau.
    public int[] getPlateauDimensions() {
        return plateauDimensions;
    }

}
