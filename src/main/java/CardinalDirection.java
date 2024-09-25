/**
 * Represents the four cardinal directions.
 */
public enum CardinalDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    /**
     * Converts a character ('N', 'E', 'S', 'W') to the corresponding CardinalDirection value.
     * @param character The character to convert.
     * @return The CardinalDirection value corresponding to the provided character, or null for an invalid character.
     */
    static CardinalDirection fromCharacter(final char character) {
        switch (character) {
            case 'N': return NORTH;
            case 'E': return EAST;
            case 'S': return SOUTH;
            case 'W': return WEST;
            default: return null;
        }
    }

    CardinalDirection ninetyDegreesLeft() {
        switch (this) {
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            default:
                return null; // This statement should never theoretically be reached since all of the enumeration cases are covered.
        }
    }

    CardinalDirection ninetyDegreesRight() {
        switch (this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                return null; // This statement should never theoretically be reached since all of the enumeration cases are covered.
        }
    }


}
