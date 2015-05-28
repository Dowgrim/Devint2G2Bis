package game;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Michael on 31/03/2015.
 */
public enum Difficulty {
    VeryEasy(true, 5, false, 0),
    Easy(false, 4, false, 0),
    Normal(false, 4, true, 5),
    Difficile(false, 3, true, 3),
    Insane(false, 2, true, 3),
    Badass(false, 2, true, 1),
    LOLLaisseTomber(false, 1, true, 1);

    private static ArrayList<Difficulty> difficulties = new ArrayList<Difficulty>(Arrays.asList(Difficulty.VeryEasy, Difficulty.Easy));

    private boolean pause;

    private int speed;

    private boolean bonus;

    private int life;

    public boolean isPause() {
        return pause;
    }

    public int getTime() {
        return 1;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLife() { return life; }

    Difficulty( boolean p, int s, boolean b, int l){
        pause = p;
        speed = s;
        bonus = b;
        life = l;
    }

    public static Difficulty getDifficulty(boolean pause, int time, int speed){
        for(Difficulty d : difficulties){
            if(d.getSpeed() == speed && d.getTime()==time && d.isPause()==pause){
                return d;
            }
        }
        return null;
    }
}
