package game.action;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Michael on 28/05/2015.
 */
public class Crier extends Action {
    private static ArrayList<Image> IMAGESBAS = new ArrayList<Image>();

    private static ArrayList<Image> IMAGESHAUT = new ArrayList<Image>();

    private int imageBAS = 0;

    private int imageHAUT = 0;

    private boolean sens = true;

    @Override
    public void forward(){
        interval++;
        if(interval == 20){
            if(imageBAS == 7){
                imageBAS = 0;
            }
            imageBAS++;
            interval = 0;


            if(imageHAUT == 5){
                sens = false;
            }
            if(imageBAS % 4 == 1) {
                if (sens) {
                    imageHAUT++;
                } else{
                    if(imageHAUT == 0){
                        endAction = true;
                    }
                    imageHAUT--;
                }
            }
        }

    }

    public static void initIMAGES(){
        File f;
        for (int i = 1; i <= 8; i++) {
            f = new File("../ressources/images/colo/Course/course" + i + ".png");
            try {
                IMAGESBAS.add(ImageIO.read(f));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i <= 5; i++) {
            f = new File("../ressources/images/colo/Crie/crie" + i + ".png");
            System.out.println("ImageHaut!");
            try {
                IMAGESHAUT.add(ImageIO.read(f));
            } catch (IOException e) {
                e.printStackTrace();
            }
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
