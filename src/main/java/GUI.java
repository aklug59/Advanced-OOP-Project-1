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

    public static GUI getGUIInstance() {
        if (GUI.singleGUI == null) {
            singleGUI = new GUI();
        }
        return singleGUI;

    }


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

    public void addGUIRoverIcon(final Position position) {
        //Logic to add a rover icon to the current GUI
    }

    public void updateRoverGUI(char currCommand) {
        //Logic to update the rovers position on the GUI

    }

    class Tile extends JLabel {

        Tile(Color color) {
            setPreferredSize(new Dimension(100,100));
            setOpaque(true);
            setBackground(color);
        }
    }

}
