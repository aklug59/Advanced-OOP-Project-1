import org.junit.Test;
import org.junit.Assert;

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
        int[] expectedPosition = {2,2};

        //Put a rover on the plateau at position 2 2 facing N
        inputFilterTestObject.inputIdentifier("2 2 N");

        //Expected output should be (0 0) and 'N', Check Rover currPosition Array and currHeading Char
        assertArrayEquals(expectedPosition, Rover.currPosition);
        assertEquals('N',Rover.currHeading);
    }


   @Test
   public void inputFilterRoverMoveTest() {
       int[] expectedPosition = {0,0};

       //Put a rover on the plateau at position 2 2 facing N
       inputFilterTestObject.inputIdentifier("2 2 N");

       //Turn the rover left, then move 2 spaces, then turn left again and move 2 spaces.
       inputFilterTestObject.inputIdentifier("LMMLMM");

       //Expected output should be (0 0 S), Check Rover currPosition Array and currHeading Char
       assertArrayEquals(expectedPosition, Rover.currPosition);
       assertEquals('S', Rover.currHeading);


   }

}
