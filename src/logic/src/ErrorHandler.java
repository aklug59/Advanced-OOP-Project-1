public class ErrorHandler {

    ErrorHandler() {}

    protected static void roverOutOfBounds() {
        System.out.println("This command would cause the rover to go off the Plateau! Rover movement is paused and all subsequent commands ignored!");
        Rover.finalCommand = true;
    }


}
