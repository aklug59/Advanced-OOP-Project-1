import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class InputFilterTests {
    @Test
    public void inputFilterTester() {
        int[] expected = {0,0};
        InputFilter inputFilterTestObject = new InputFilter();
        //Create a new plateau of size 5 x 5
        inputFilterTestObject.inputIdentifier("5 5");
        //Put a rover on the plateau at position 2 2 facing N
        inputFilterTestObject.inputIdentifier("2 2 N");
        //Move the rover left, then 2 spaces, then left again and 2 spaces.
        inputFilterTestObject.inputIdentifier("LMMLMM");
        //Expected output should be (0 0 S), Check Rover currPosition Array and currHeading Char
        assertArrayEquals(expected, Rover.currPosition);
        assertTrue('S'== Rover.currHeading);

    }
}
