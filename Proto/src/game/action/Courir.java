package game.action;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Michael on 31/03/2015.
 */
public class Courir extends Action {

    private static ArrayList<Image> IMAGESBAS = new ArrayList<Image>();

    private static ArrayList<Image> IMAGESHAUT = new ArrayList<Image>();

    private int imageBAS = 0;

    private int imageHAUT = 0;

    @Override
    public void forward(){
       interval++;
        if(interval == 20){
            if(imageBAS == 7){
                imageBAS = 0;
            }
            imageBAS++;
            interval = 0;
        }

    }

    public static void initIMAGES(String chemin){
        File f;
        for (int i = 1; i <= 8; i++) {
            f = new File("../ressources/images/colo/Séparation/course" + i + ".png");
            try {
                IMAGESBAS.add(ImageIO.read(f));
            } catch (IOException e) {
                    e.printStackTrace();
            }
        }
        f = new File("../ressources/images/colo/Séparation/corps.png");
        try {
            IMAGESHAUT.add(ImageIO.read(f));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Image getImageBAS() {
        return IMAGESBAS.get(imageBAS);
    }

    @Override
    public Image getImageHAUT() {
        return IMAGESHAUT.get(imageHAUT);
    }
}
