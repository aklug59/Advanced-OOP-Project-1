public class ErrorHandler {

    ErrorHandler() {}

    /**
     * Method to inform the user that the rover had gone out of bounds and to set the Rover.finalCommand boolean to true
     * so all subsequent commands are ignored.
     */

    protected static void roverOutOfBounds() {
        System.out.println("This command would cause the rover to go off the Plateau! Rover movement is paused and all subsequent commands ignored!");
        Rover.finalCommand = true;
    }

    /**
     * Method to inform the user that a plateau already exists, should they try to instantiate another one.
     */
    protected static void plateauExists() {
        System.out.println("A plateau already exists!");
    }



}
