import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class PlateauTests {

    @Test
    public void plateauDimensionsTest() {
        // Instantiate & populate plateau dimensions
        ArrayList<Character> characterList = new ArrayList<>();
        characterList.add('7');
        characterList.add('7');
        Plateau plateauTestObject = new Plateau(characterList);
        // Expected dimensions are 7 x 7
        int expected = 7;
        assertEquals(expected, plateauTestObject.plateauXMax);
        assertEquals(expected, plateauTestObject.plateauYMax);
    }
}
