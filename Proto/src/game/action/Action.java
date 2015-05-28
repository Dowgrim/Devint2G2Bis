package game.action;

import java.awt.*;

import org.json.JSONObject;

/**
 * Created by Michael on 31/03/2015.
 */
public class Action {

    protected int shiftX;

    protected int shiftY;

    protected int shiftWidth;

    protected int shiftHeigt;

    protected int interval;

    protected boolean endAction = false;

    public Action(){
        interval = 0;
        shiftHeigt = 0;
        shiftWidth = 0;
        shiftX = 0;
        shiftY = 0;
    }

        public int getShiftX() {
        return shiftX;
    }

    public int getShiftY() {
        return shiftY;
    }

    public int getShiftWidth() {
        return shiftWidth;
    }

    public int getShiftHeigt() {
        return shiftHeigt;
    }

    public Image getImageBAS() {
        return null;
    }

    public Image getImageHAUT() {
        return null;
    }

    public boolean isEndAction() {
        return endAction;
    }

    public boolean onBonus() {
        return false;
    }

    public void forward() {}
    
}
