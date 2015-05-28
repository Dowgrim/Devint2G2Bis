package game;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.json.JSONObject;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Michael on 25/03/2015.
 */
public class BackGroundL extends JPanel{

    private Image background;

    public BackGroundL(String backGround) {
        File f = new File(backGround);
        try {
            background = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BackGroundL(JSONObject backGround){
        File f = new File(backGround.getString("image"));
    }

    public void setImage(String image){
        File f = new File(image);
        try {
            background = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        g.drawImage(background, 0, 0, 7000, 750, null);
        g.drawImage(background, 7000, 0, 7000, 750, null);
    }

    public void afficher(int pos){
        setBounds(-(pos % 7000), 0, 9000, 750);
    }
}
