package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Michael on 01/04/2015.
 */
public class Win extends JPanel {

    Image image;

    public Win(){
        File file = new File("../ressources/images/gagne.png");
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JFrame f = new JFrame("Bien Joué");
        f.setContentPane(this);
        f.setSize(400, 200);
        f.setLocation(400, 400);
        f.setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-200, (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-100);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g){
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }
}
