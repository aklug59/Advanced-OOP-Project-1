import org.junit.Test;
import static org.junit.Assert.*;

public class InputFilterTests {
    InputFilter inputFilterTestObject = new InputFilter();
    @Test
    public void inputFilterPlateauTest() {
        int[] expected = {0,0};

        //Create a new plateau of size 5 x 5
        inputFilterTestObject.inputIdentifier("5 5");
        
        //Confirm that the created Plateau has x and y values of 5 and 5 respectively.
        assertEquals(5, Plateau.plateauXMax);
        assertEquals(5, Plateau.plateauYMax);

    }

    @Test
    public void inputFilterRoverCreationTest() {
        final var expectedPosition = new Position(2,2, CardinalDirection.NORTH);

        //Put a rover on the plateau at position 2 2 facing N
        inputFilterTestObject.inputIdentifier("2 2 N");

        //Expected output should be (0 0) and 'N', Check Rover currPosition Array and currHeading Char
        assertEquals(expectedPosition, Rover.position);
    }


   @Test
   public void inputFilterRoverMoveTest() {
       final var expectedPosition = new Position(0,0, CardinalDirection.SOUTH);

       //Put a rover on the plateau at position 2 2 facing N
       inputFilterTestObject.inputIdentifier("2 2 N");

       //Turn the rover left, then move 2 spaces, then turn left again and move 2 spaces.
       inputFilterTestObject.inputIdentifier("LMMLMM");

       //Expected output should be (0 0 S), Check Rover currPosition Array and currHeading Char
       assertEquals(expectedPosition, Rover.position);
   }

   @Test
    public void inputFilterRoverBottomBoundaryTest() {
        final var expectedPosition = new Position(3,0,CardinalDirection.SOUTH);
        // Create plateau size 5x5
        inputFilterTestObject.inputIdentifier("5 5");
        // Put a rover on plateau, top right of 5x5
        inputFilterTestObject.inputIdentifier("3 3 S");
        // Turn rover towards 'S', then move past bottom boundary
        inputFilterTestObject.inputIdentifier("MMMMMM");
        // Should stay at y=0
        assertEquals(expectedPosition, Rover.position);
   }

    @Test
    public void inputFilterRoverTopBoundaryTest() {
        final var expectedPosition = new Position(3,5,CardinalDirection.NORTH);
        // Create plateau size 5x5
        inputFilterTestObject.inputIdentifier("5 5");
        // Put a rover on plateau, bottom right of 5x5
        inputFilterTestObject.inputIdentifier("3 3 N");
        // Turn rover towards 'S', then move past bottom boundary
        inputFilterTestObject.inputIdentifier("MMMMMM");
        // Should stay at y=5
        assertEquals(expectedPosition, Rover.position);
    }

    @Test
    public void inputFilterRoverLeftBoundaryTest() {
        final var expectedPosition = new Position(0,3,CardinalDirection.WEST);
        // Create plateau size 5x5
        inputFilterTestObject.inputIdentifier("5 5");
        // Put a rover on plateau, bottom right of 5x5
        inputFilterTestObject.inputIdentifier("3 3 W");
        // Turn rover towards 'S', then move past bottom boundary
        inputFilterTestObject.inputIdentifier("MMMMMM");
        // Should stay at y=5
        assertEquals(expectedPosition, Rover.position);
    }

    @Test
    public void inputFilterRoverRightBoundaryTest() {
        final var expectedPosition = new Position(5,3,CardinalDirection.EAST);
        // Create plateau size 5x5
        inputFilterTestObject.inputIdentifier("5 5");
        // Put a rover on plateau, bottom right of 5x5
        inputFilterTestObject.inputIdentifier("3 3 E");
        // Turn rover towards 'S', then move past bottom boundary
        inputFilterTestObject.inputIdentifier("MMMMMM");
        // Should stay at y=5
        assertEquals(expectedPosition, Rover.position);
    }
}
