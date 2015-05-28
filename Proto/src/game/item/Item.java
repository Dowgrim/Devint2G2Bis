package game.item;

import game.action.Action;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Michael on 11/03/2015.
 */
public class Item extends JPanel{

    private ItemCarac carac;

    private Action action;

    public void paintComponent(Graphics g){
        g.drawImage(action.getImageBAS(), 0, 0, getWidth(), getHeight(), null);
    }

    public Item(ItemCarac carac, Action action){
        this.carac = carac;
        this.action = action;
    }

    public boolean isEnd(){
        return action.isEndAction();
    }

    public void afficher(){
        if(action != null) {
            this.setBounds(carac.getPosX() + action.getShiftX(), carac.getPosY() + action.getShiftY(), carac.getWidth(), carac.getHeight());
        }
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void forward() {
        if(action != null) {
            action.forward();
        }
    }

    public Action getAction() {
        return action;
    }
}
