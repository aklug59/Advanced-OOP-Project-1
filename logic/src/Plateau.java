public class Plateau {
    private int[] plateauDimensions = new int[2];

    public boolean plateauMade = false;

    private Plateau(String initialDimensions) {
        //Logic to populate plateauDimensions array from input string here.
        //if statement to check if a plateau has already been made.
        this.plateauMade = true;

    }

    //Return the arraylist with the current dimensions of the plateau.
    public int[] getPlateauDimensions() {
        return plateauDimensions;
    }

}
