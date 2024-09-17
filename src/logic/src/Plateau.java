import java.util.ArrayList;

public class Plateau {
    private int[] plateauDimensions = new int[2];

    public boolean plateauMade = false;

    public Plateau(ArrayList<Character> initialDimensions) {

        if (!plateauMade) {
            for(int i = 0; i < initialDimensions.size(); i++) {
                int intValue = Integer.valueOf(initialDimensions.get(i));
                plateauDimensions[i] = intValue;
            }
            this.plateauMade = true;

        } else {
            //Throw some type of error to inform the user a plateau already exists.
        }



    }


    //Return the arraylist with the current dimensions of the plateau.
    public int[] getPlateauDimensions() {
        return plateauDimensions;
    }

}
