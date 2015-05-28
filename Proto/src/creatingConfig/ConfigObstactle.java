package creatingConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import game.Level;
import org.json.JSONArray;
import org.json.JSONObject;

import game.Difficulty;
import game.item.Obstacle;
import game.item.ItemCarac;

/**
 * Created by Michael on 31/03/2015.
 */
public abstract class ConfigObstactle {

    public static Obstacle configObstacle(JSONObject obstacle){
        JSONObject carac = obstacle.getJSONObject("carac");
        
        if(carac==null){
            throw new IllegalArgumentException("Error with the JSONObject obstacle in ConfigObstactle.configObstacle."
                    + " No 'carac' in it.");
        }
        
        ItemCarac caracObstacle;
        try{
            caracObstacle = new ItemCarac(carac.getInt("posX"),carac.getInt("posY"),carac.getInt("width"),carac.getInt("height"));
        }catch(Exception e){
            throw new IllegalArgumentException("Error with the JSONObject obstacle in ConfigObstactle.configObstacle."
                    + " The argument hasn't 'posX', 'posY', 'width', 'height' or they aren't int");
        }
        
        String img,snd;
        int key;
        
        try{
            img = obstacle.getString("image");
            snd = obstacle.getString("sound");
            key = obstacle.getInt("key");
        }catch(Exception e){
            throw new IllegalArgumentException("Error with the JSONObject obstacle in ConfigObstactle.configObstacle."
                    + " The argument hasn't 'image', 'sound', 'state', 'key' or they aren't String for the first three"
                    + "and int for the last one");
        }
        
        Obstacle obst = new Obstacle(img,caracObstacle,key,snd);
        return obst;
    }
    
    public static Level levelConfig(JSONObject level, Difficulty  dif){
        Level l = null;
        JSONArray obstacles = level.getJSONArray("obstacles");
        List<Obstacle> obst = new ArrayList<Obstacle>();
        for(int i=0; i<obstacles.length();i++){
            obst.add(ConfigObstactle.configObstacle(obstacles.getJSONObject(i)));
        }
        HashMap<Integer, String> sons = new HashMap<>();
        JSONArray ss = level.getJSONArray("sons");
        int pos;
        String path;
        for(int i=0; i<ss.length();i++){
            pos = ss.getJSONObject(i).getInt("pos");
            path = ss.getJSONObject(i).getString("path");
            sons.put(pos, path);
        }
        path = level.getString("backGround");
        l = new Level((ArrayList)obst, sons, path, dif);
        return l;
    }
}
