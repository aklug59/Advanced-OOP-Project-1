/**
 * Class that represents the position of the rover on the plateau as a vector.
 */
public class Position {
    /**
     * The x position.
     */
    int x;

    /**
     * The y position.
     */
    int y;

    /**
     * The heading as a cardinal direction.
     */
    CardinalDirection heading;

    /**
     * @param x The horizontal position.
     * @param y The vertical position. (Higher numbers represent lower)
     * @param heading The heading as a cardinal direction.
     */
    public Position(int x, int y, CardinalDirection heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
    }
}

