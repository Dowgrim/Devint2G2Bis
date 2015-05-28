package game.item;

import org.json.*;

/**
 * Created by Michael on 06/03/2015.
 */
public class ItemCarac {
    
    //x coordinate of the obstacle
    public int posX;
    //y coordinate of the obstacle
    private int posY;

    //width of the obstacle
    private int width;
    //height of the obstacle
    private int height;


    public ItemCarac(int x){
        posX = x;
    }

    /**
     * Constructor of an obstacle.
     * We need its position, its width and its height
     * These values can't be negative, so we convert them to positive ones.
     * @param x
     *          the x position
     * @param y
     *          the y position
     * @param w
     *          the width
     * @param h
     *          the height
     */
    public ItemCarac(int x, int y, int w, int h){
        posX = x;
        posY = y;
        width = w;
        height = h;
        
        if(x<0){
            posX = -x;
        }
        if(y<0){
            posY=-y;
        }
        if(w<0){
            width=-w;
        }
        if(h<0){
            height=-h;
        }
    }

    
    //====================GETTER AND SETTER==========================
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
        if(posX<0) this.posX=-posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
        if(posY<0) this.posY=-posY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        if(width<0) this.width=-width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        if(height<0) this.height= -height;
    }

    //========================METHODS===================================
    /**
     * toJson method for an obstacle
     * @return the JSON object with all the Obstacle characteristics
     */
    public JSONObject toJson(){
        JSONObject obstacle = new JSONObject();
        obstacle.put("posX",posX);
        obstacle.put("posY",posY);
        obstacle.put("width",width);
        obstacle.put("height",height);
        return obstacle;
    }
    
    /**
     * Equals method of Obstacle
     */
    @Override
    public boolean equals(Object obj){
        if(obj!=this){
            if(obj instanceof ItemCarac){
                ItemCarac obs = (ItemCarac) obj;
                if(this.posX!=obs.getPosX() || this.posY!=obs.getPosY()) return false;
                else if(this.width!=obs.getWidth() || this.height!=obs.getHeight()) return false;
            }
        }
        return true;
    }
    
    /**
     * Transform the object in string as this : 
     * posX : 
     * posY :
     * width :
     * height :
     * @return the String as before
     */
    @Override
    public String toString(){
        String obs = "posX : "+posX+"\n";
        obs+="posY : "+posY+"\n";
        obs+="width : "+width+"\n";
        obs+="height : "+height+"\n";
        return obs;
    }
}
