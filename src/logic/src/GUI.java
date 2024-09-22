import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GUI {

    private static GUI guiInstance;
    private JFrame frame = new JFrame();
    private JPanel plateauPanel = new JPanel();
    private JLabel roverIcon = new JLabel();
    private final Color[] COLOR_ARRAY = {Color.decode("#660000"), Color.decode("#744700")};
    ArrayList<JTile> tileList = new ArrayList<JTile>();

    private GUI() {}

    public static GUI getGUI() {
        if (GUI.guiInstance == null) {
            guiInstance = new GUI();
        }

        return guiInstance;
    }



    public void createPlateau(int plateauXMax, int plateauYMax) {
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        plateauPanel.setSize(1000,1000);
        plateauPanel.setLayout(new GridLayout(plateauYMax,plateauXMax));


        int currColor = 1;
        boolean isOdd = (plateauXMax % 2 == 1) ? true:false;

        for (int i = 0; i < plateauYMax; i++) {
            currColor = (currColor == 0) ? 1:0;

            for (int j = 0; j < plateauXMax; j++) {
                JTile currTile = new JTile(COLOR_ARRAY[currColor]);
                plateauPanel.add(currTile);
                tileList.add(currTile);
                currColor = (currColor == 0) ? 1:0;
                if (j == plateauXMax - 1 & isOdd) {
                    currColor = (currColor == 0) ? 1:0;
                }


            }
        }
        frame.add(plateauPanel);
        frame.setVisible(true);
    }

    public void addGUIRoverIcon(final Position position) {



        ImageIcon imageIcon = new ImageIcon("C:/Users/aklug/OneDrive/Desktop/473 - Advanced OOP/Project 1/Advanced-OOP-Project-1/Pictures/Rover.png");
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);  // transform it back

        roverIcon.setIcon(imageIcon);
        roverIcon.setSize(100,100);
        roverIcon.setVisible(true);
        plateauPanel.remove(tileList.get(5));




        plateauPanel.add(roverIcon, 5);
        plateauPanel.validate();
        plateauPanel.repaint();

    }

    public void updateRoverGUI(char currCommand) {
        //Logic to update the rovers position on the GUI

    }

    static class JTile extends JLabel {
        JTile(Color color) {
            setPreferredSize(new Dimension(100,100));
            setOpaque(true);
            setBackground(color);
        }
    }

}
