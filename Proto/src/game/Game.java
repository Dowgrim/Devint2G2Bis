package game;

import creatingConfig.FileInteraction;
import game.action.Banana;
import game.action.Courir;
import game.action.Glisser;
import game.action.Sauter;
import game.item.Obstacle;
import game.item.ItemCarac;
import game.Difficulty;
import game.Level;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;

/**
 * Created by Michael on 25/03/2015.
 */
public class Game {

    private static Game INSTANCE = null;

    private Difficulty difficulty = Difficulty.LOLLaisseTomber;
    private Level level;

    public static Game getINSTANCE(){
        return INSTANCE;
    }


    public Game(Difficulty d){
        Courir.initIMAGES("PetiteFille");
        Glisser.initIMAGES("lol");
        Sauter.initIMAGES("lol");
        Banana.initIMAGES("lol");
        difficulty = d;
        INSTANCE = this;
    }


    public void launchLevel() {
        ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
        int tailleLion = 250;
        int tailleAigle = 100;
        int posLion = 470;
        int posAigle = 300;
        obstacles.add(new Obstacle("../ressources/images/Obstacle/chien.gif", new ItemCarac(1300, 440, tailleLion, tailleLion), KeyEvent.VK_UP, "../ressources/sons/chien.wav"));
        obstacles.add(new Obstacle("../ressources/images/Obstacle/aigle.png", new ItemCarac(2400, posAigle, tailleAigle, tailleAigle), KeyEvent.VK_DOWN, "../ressources/sons/aigle.wav"));
        obstacles.add(new Obstacle("../ressources/images/Obstacle/lion.png", new ItemCarac(3000, posLion, tailleLion, tailleLion), KeyEvent.VK_RIGHT, "../ressources/sons/lion.wav"));
        obstacles.add(new Obstacle("../ressources/images/Obstacle/lion.png", new ItemCarac(3600, posLion, tailleLion, tailleLion), KeyEvent.VK_RIGHT, "../ressources/sons/lion.wav"));
        obstacles.add(new Obstacle("../ressources/images/Obstacle/lion.png", new ItemCarac(5000, posLion, tailleLion, tailleLion), KeyEvent.VK_RIGHT, "../ressources/sons/lion.wav"));
        obstacles.add(new Obstacle("../ressources/images/Obstacle/lion.png", new ItemCarac(6200, posLion, tailleLion, tailleLion), KeyEvent.VK_RIGHT, "../ressources/sons/lion.wav"));
        obstacles.add(new Obstacle("../ressources/images/Obstacle/aigle.png", new ItemCarac(7000, posAigle, tailleAigle, tailleAigle), KeyEvent.VK_DOWN, "../ressources/sons/aigle.wav"));
        obstacles.add(new Obstacle("../ressources/images/Obstacle/lion.png", new ItemCarac(8000, posLion, tailleLion, tailleLion), KeyEvent.VK_RIGHT, "../ressources/sons/lion.wav"));
        obstacles.add(new Obstacle("../ressources/images/Obstacle/aigle.png", new ItemCarac(8300, posAigle, tailleAigle, tailleAigle), KeyEvent.VK_DOWN, "../ressources/sons/aigle.wav"));
        obstacles.add(new Obstacle("../ressources/images/Obstacle/lion.png", new ItemCarac(9000, posLion, tailleLion, tailleLion), KeyEvent.VK_RIGHT, "../ressources/sons/lion.wav"));
        obstacles.add(new Obstacle("../ressources/images/Obstacle/the-end.jpg", new ItemCarac(9500, 250, 400, 400), KeyEvent.VK_RIGHT, "lol", true));

        HashMap<Integer, String> sons = new HashMap<>();
        sons.put(0, "../ressources/sons/musique.wav");
        sons.put(-1, "../ressources/sons/Histoire/Foret/1.wav");
        sons.put(-2, "../ressources/sons/Histoire/Foret/1.wav");


        level = new Level(obstacles, sons, "../ressources/images/backGround/Plaine.png", difficulty);
    }

    public void launchLevelV2(int l){
        JSONObject jsonLvl = FileInteraction.loadLevel("../ressources/json/Level"+l+".json");
        ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
        JSONArray array = jsonLvl.getJSONArray("Obstacles");
        JSONObject obj = null;
        for(int i = 0; i < array.length(); i++){
            obj = array.getJSONObject(i);
            obstacles.add(new Obstacle(obj.getString("imageOK"), new ItemCarac(obj.getInt("posX"), obj.getInt("posY"), obj.getInt("width"), obj.getInt("height")), obj.getInt("key"), obj.getString("sonOK")));
        }
        HashMap<Integer, String> sons = new HashMap<Integer, String>();
        array = jsonLvl.getJSONArray("Sons");
        for(int i = 0; i < array.length(); i++){
            obj = array.getJSONObject(i);
            sons.put(obj.getInt("index"), obj.getString("path"));
        }
        level = new Level(obstacles, sons, jsonLvl.getString("backGround"), difficulty);
    }

    public Difficulty getDifficulty(){
        return difficulty;
    }

    public static void main(String[] args) {
        //new menu.MenuJeu("AnimalEscape");
        Game game = new Game(Difficulty.Easy);
        game.launchLevelV2(1);
    }

}