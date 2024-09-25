import javax.swing.*;
import java.awt.*;

public class GUI {

    private static GUI singleGUI;
    private JPanel plateauPanel;
    private final Color[] COLOR_ARRAY = {Color.decode("#660000"), Color.decode("#744700")};

    /**
     * Singleton pattern to ensure there is only ever one instance of GUI
     */
    private GUI() {}

    /**
     * GetGui method to allow outside classes to access the GUI instance.
     *
     * @return The one and only instance of a GUI
     */
    public static GUI getGUIInstance() {
        if (GUI.singleGUI == null) {
            singleGUI = new GUI();
        }
        return singleGUI;

    }

    /**
     * Method for creating a plateau out of Swing components, JFrame, JPanel, JTile.
     * @param plateauXMax The x dimension of the plateau to be created
     * @param plateauYMax The y dimension of the plateau to be created
     */
    public void createPlateau(int plateauXMax, int plateauYMax) {
        JFrame frame = new JFrame();
        frame.setSize(1000,1000);
        JPanel daPanel = new JPanel();
        //daPanel.setSize(1000,1000);

        daPanel.setLayout(new GridLayout(plateauYMax,plateauXMax));
        int currColor = 1;
        boolean isOdd = (plateauXMax % 2 == 1) ? true:false;

        for (int i = 0; i < plateauYMax; i++) {
            currColor = (currColor == 0) ? 1:0;

            for (int j = 0; j < plateauXMax; j++) {
                daPanel.add(new Tile(COLOR_ARRAY[currColor]));
                currColor = (currColor == 0) ? 1:0;
                if (j == plateauXMax - 1 & isOdd) {
                    currColor = (currColor == 0) ? 1:0;
                }


            }
        }
        frame.add(daPanel);
        frame.setVisible(true);


        //Logic to create a JFrame out of Plateau dimensions
    }

    /**
     * Once a rover has been instantiated by the user, this method will put a rover icon onto the JPanel @ the position
     * @param position the position of the rover.
     */
    public void addGUIRoverIcon(final Position position) {
        //Logic to add a rover icon to the current GUI
    }


    /**
     * Method to move the rover around the GUI.
     * @param currCommand The movement command for the rover from the user
     */
    public void updateRoverGUI(char currCommand) {
        //Logic to update the rovers position on the GUI

    }

    /**
     * Jcomponent tile to assist the createPlateau method above in creation of the JPanel.
     */
    class Tile extends JLabel {

        Tile(Color color) {
            setPreferredSize(new Dimension(100,100));
            setOpaque(true);
            setBackground(color);
        }
    }

}
