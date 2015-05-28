package game.item;

import javax.imageio.ImageIO;
import javax.swing.*;

import game.Win;
import t2s.SIVOXDevint;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Michael on 11/03/2015.
 */
public class Obstacle extends JPanel {

    private ArrayList<Image> images = new ArrayList<Image>();

    private ItemCarac carac;

    private int key;

    private String sound;

    private boolean fin = false;

    private game.action.Action action;

    public Obstacle(String image, ItemCarac carac, int key, String sound, boolean isFin){
        this(image, carac, key, sound);
        fin = isFin;
    }


    public Obstacle(String image, ItemCarac carac, int key, String sound){
        if(image != null) {
            File f = new File(image);
            try {
                images.add(ImageIO.read(f));
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.carac = carac;
            this.setSize(carac.getWidth(), carac.getHeight());
        }
        this.key = key;
        this.sound = sound;
    }
    
    public void paintComponent(Graphics g){
        g.drawImage(images.get(0), 0, 0, getWidth(), getHeight(), null);
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public int getKey() {
        return key;
    }

    public String getSound() {
        return sound;
    }

    public int getCaracX(){
        return carac.getPosX();
    }

    public int getCaracY(){
        return carac.getPosY();
    }

    public int getCaracWidth(){
        return carac.getWidth();
    }

    public int getCaracHeight(){
        return carac.getHeight();
    }

    public void playSound(){
        SIVOXDevint s = new SIVOXDevint();
        s.playWav(sound, true);
    }

    public boolean isFin(){
        return fin;
    }

    public void forward(int position){
        if (this.getCaracX() < position + 2000 && this.getCaracX() > position - 1000) {
            if (this.getCaracX() == position + 500) {
                this.playSound();
            }
        }
    }

    public void afficher(int position){
        this.setBounds((this.getCaracX() - position), this.getCaracY(), this.getCaracWidth(), this.getCaracHeight());
    }
}
