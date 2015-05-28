package game;

import org.json.JSONObject;

/**
 * Created by Michael on 11/03/2015.
 */
public class PlayerCarac {
    private int life;
    private int MAXLIFE;
    private int score;

    /**
     * Constructor without parameters
     * We have 3 lives at the beginning
     */
    public PlayerCarac(){
        this(3);
    }
    
    /**
     * We can choose how many lives we have
     * @param life
     */
    public PlayerCarac(int life){
        this(life,life,0);
    }

    /**
     * We can choose how many lives we have,
     * the maximum lives, and the score
     * 
     * @param life
     * @param MAXLIFE
     * @param score
     */
    public PlayerCarac(int life, int MAXLIFE, int score){
        this.life=life;
        this.MAXLIFE=MAXLIFE;
        if(this.life>this.MAXLIFE) this.life = this.MAXLIFE;
        this.score = score;
        if(this.score<0) this.score=0;
    }
    
    //===============GETTERS & SETTERS==============================
    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
        if(life>this.MAXLIFE) this.life=MAXLIFE;
        else if(life<0) this.life=0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMAXLIFE() {
        return MAXLIFE;
    }
    //you can't set the MAXLIFE because we consider it as a constant
    
    //===============METHODS======================================
    
    /**
     * The player is dead if life <= 0
     * @return true if you haven't any lives left, false otherwise
     */
    public boolean isDead(){
        if(this.life<=0) return false;
        return true;
    }
    
    /**
     * The toJson method of Player
     * @return a JSONObject which describes this instance if Player
     */
    public JSONObject toJson(){
        JSONObject player = new JSONObject();
        player.put("life",life);
        player.put("MAXLIFE", MAXLIFE);
        player.put("score",score);
        return player;
    }
}
