package game.action;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Michael on 11/05/2015.
 */
public class Banana extends Action {

    private static ArrayList<Image> IMAGES = new ArrayList<Image>();

    private int image;

    public Banana(int position){
        shiftX = position;
        shiftY = 400;
    }

    @Override
    public void forward(){
        interval++;
        if(interval == 20){
            if(image == 5){
                image = 0;
            }
            image++;
            interval = 0;
        }
        shiftX++;
        shiftY--;
        if(shiftY < -100){
            endAction = true;
        }
    }

    public static void initIMAGES(String chemin){
        File f;
        for (int i = 0; i <= 5; i++) {
            f = new File("../ressources/images/Banana/Banane" + i + ".png");
            try {
                IMAGES.add(ImageIO.read(f));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Image getImageBAS() {
        return IMAGES.get(image);
    }
}
