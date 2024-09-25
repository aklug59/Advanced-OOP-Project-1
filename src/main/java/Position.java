import java.util.Objects;

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

    /**
     * Method to update the position of the rover
     */
    final void moveOne() {
        switch (heading) {
            case CardinalDirection.NORTH:
                if (y < Plateau.getPlateauYMax()) {
                    y += 1;
                } else {
                    ErrorHandler.roverOutOfBounds();
                }
                break;
            case CardinalDirection.EAST:
                if (x < Plateau.getPlateauXMax()) {
                    x += 1;
                } else {
                    ErrorHandler.roverOutOfBounds();
                }
                break;
            case CardinalDirection.SOUTH:
                if (y > 0) {
                    y -= 1;
                } else {
                    ErrorHandler.roverOutOfBounds();
                }
                break;
            case CardinalDirection.WEST:
                if (x > 0) {
                    x -= 1;
                } else {
                    ErrorHandler.roverOutOfBounds();
                }
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y && heading == position.heading;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, heading);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", heading=" + heading +
                '}';
    }
}

