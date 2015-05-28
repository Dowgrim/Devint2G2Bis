package game.action;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Michael on 31/03/2015.
 */
public class Sauter extends Action {

    protected static ArrayList<Image> IMAGES = new ArrayList<Image>();

    private int image = 0;

    private boolean descent = false;

    private int delay = 1;

    @Override
    public void forward() {
        delay++;
        if (delay == 2) {
            delay = 0;
            if (!descent && shiftY > -200) {
                if (shiftY > -50) {
                    shiftY -= 3;
                } else if (shiftY > -125) {
                    shiftY -= 2;
                } else {
                    shiftY--;
                }
            } else {
                descent = true;
                if (shiftY < 0)
                    if (shiftY > -50) {
                        shiftY += 3;
                    } else if (shiftY > -125) {
                        shiftY += 2;
                    } else {
                        shiftY++;
                    }
                else {
                    endAction = true;
                }
            }
        }
    }

    @Override
    public Image getImageBAS(){
        return IMAGES.get(image);
    }

    public static void initIMAGES(String chemin){
        File f;
        if(chemin.equals("troll")){
            for(int i = 1; i <= 10; i++){
                f = new File("../ressources/images/Perso/frame-"+i+".gif");
                try {
                    IMAGES.add(ImageIO.read(f));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else{
                f = new File("../ressources/images/colo/saut1.png");
                try {
                    IMAGES.add(ImageIO.read(f));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    @Override
    public boolean onBonus() {
        if (descent && shiftY > -150 && shiftY < -20) {
            descent = false;
            return true;
        }
        return false;
    }
}
