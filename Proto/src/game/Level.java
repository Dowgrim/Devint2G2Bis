package game;

import game.action.Banana;
import game.action.Crier;
import game.action.Glisser;
import game.action.Sauter;

import javax.swing.*;
import java.awt.List;
import java.util.*;

import game.item.Item;
import game.item.ItemCarac;
import game.item.Obstacle;
import t2s.SIVOXDevint;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

/**
 * Created by Michael on 06/03/2015.
 */
public class Level extends JFrame {

    private Player player;
    private Difficulty difficulty;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Item> items;
    private BackGroundL backGround;
    private int position = 0;

    private boolean sauterSons;


    private ArrayList<JPanel> hearts;

    private JLabel score;

    public Level(ArrayList<Obstacle> obstacles, String backGr, Difficulty dif, boolean sauterSons) {

        this.sauterSons = sauterSons;
        final Defilement t = new Defilement();
        difficulty = dif;
        items = new ArrayList<>();
        setSize(1200, 750);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP: {
                        if (!(player.getAction() instanceof Sauter)) {
                            player.setAction(new Sauter());
                            player.setKeyPressed(e.getKeyCode());
                        }
                        break;
                    }
                    case KeyEvent.VK_DOWN: {
                        player.setAction(new Glisser());
                        player.setKeyPressed(e.getKeyCode());
                        break;
                    }
                    case KeyEvent.VK_RIGHT: {
                        player.setAction(new Crier());
                        player.setKeyPressed(e.getKeyCode());
                        break;
                    }
                    case KeyEvent.VK_ENTER: {
                        if (!t.isAlive()) {
                            t.start();
                        }
                        break;
                    }
                    case KeyEvent.VK_1: {

                        break;
                    }
                    case KeyEvent.VK_2: {

                        break;
                    }
                    case KeyEvent.VK_3: {

                        break;
                    }
                    case KeyEvent.VK_4: {

                        break;
                    }
                    case KeyEvent.VK_SPACE: {
                        items.get(0).setAction(new Banana());
                        player.setKeyPressed(e.getKeyCode());
                        break;
                    }
                }
            }
        });

        player = new Player(difficulty.getLife());
        contentPane.add(player);
        player.forward();

        hearts = new ArrayList<>();
        for(int i = 0; i < difficulty.getLife(); i++){
            hearts.add(new Heart());
            contentPane.add(hearts.get(i));
            hearts.get(i).setBounds(i*50, 0, 50, 50);
        }

        score = new JLabel(player.getScore() + "");
        score.setFont(new Font("Arial", Font.PLAIN, 40));
        score.setBounds(getWidth() - 120, 0, 200, 30);
        contentPane.add(score);

        this.obstacles = obstacles;
        for (Obstacle o : obstacles) {
            if(o.getKey() > 0) {
                contentPane.add(o);
                o.setBounds(-400, 0, o.getCaracWidth(), o.getCaracHeight());
            }
        }

        Item banana = new Item(new ItemCarac(0, 0, 50, 50), null);
        items.add(banana);
        contentPane.add(banana);
        banana.setBounds(-500, 0, 80, 80);

        backGround = new BackGroundL(backGr);
        contentPane.add(backGround);
        backGround.setBounds(0, 0, getWidth(), getHeight());

        setVisible(true);

        while(true){
            player.afficher();
            for(Obstacle o : obstacles){
                if(o.getKey() > 0) {
                    o.afficher(position);
                }
            }
            for(Item i : items){
                i.afficher();
            }
            backGround.afficher(position);
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class Defilement extends Thread {

        Timer time = new Timer(this.getName());

        public Defilement(){
            super("unNom");
            time = new Timer(this.getName());
        }

        @Override
        public void run() {
            time.schedule(new TaskSechedul(), 0, difficulty.getSpeed());
        }
    }

    public class TaskSechedul extends TimerTask {

        @Override
        public void run() {
            position++;
            player.forward();
            for (Obstacle o : obstacles) {
                 o.forward(position, sauterSons);
                    if ((o.getCaracX() == (position + 150))) {
                        if (o.isFin()) {
                            new Win();
                            this.cancel();
                        } else {
                            if ((player.getAction().onBonus())) {
                                player.gg(1000);
                                score.setText(player.getScore() + "");
                            }
                        }
                    }
                    if (o.getCaracX() == (position + 300) && o.getKey() != player.getKeyPressed()) {
                        if (difficulty.isPause()) {
                            int i = 0;
                            while (o.getKey() != player.getKeyPressed()) {
                                if (i == 100) {
                                    o.playSound();
                                    i = 0;
                                }
                                try {
                                    Thread.sleep(30);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                i++;
                            }
                            player.gg(500);
                            score.setText(player.getScore() + "");
                            player.setKeyPressed(-1);
                        } else {
                            if (o.getKey() > 0) {
                                player.hit();
                                hearts.get(player.getlife()).setVisible(false);
                            }
                        }
                    } else {
                        if(o.getCaracX() == (position + 300) && o.getKey() == player.getKeyPressed()) {
                            player.gg(500);
                            score.setText(player.getScore() + "");
                            player.setKeyPressed(-1);
                        }
                    }

            }
            for(Item i : items){
                i.forward();
                if(i.getAction() != null && i.isEnd()){
                    i.setAction(null);
                }
            }
        }
    }

}