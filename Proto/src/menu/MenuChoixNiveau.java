package menu;

import APIDevint.MenuAbstrait;
import game.Difficulty;
import game.Game;

/**
 * Created by Michael on 27/05/2015.
 */
public class MenuChoixNiveau extends MenuAbstrait {

    /** constructeur
     * @param title : le nom du jeu
     */
    public MenuChoixNiveau(String title) {
        super(title);
    }

    @Override
    protected String[] nomOptions() {
        String[] noms = {"La Forêt", "La Savane","Les Montagnes"};
        return noms;
    }

    @Override
    protected void lancerOption(int i) {
        switch (i){
            case 0 : Game.getINSTANCE().launchLevel(1);break;
            case 1 : Game.getINSTANCE().launchLevelV2(2);break;
            case 2 : Game.getINSTANCE().launchLevelV2(3);break;
            case 3 : new MenuJeu(nomJeu);break;
            default: System.err.println("action non définie");
        }
        this.dispose();
    }

    @Override
    protected String wavAccueil() {
        return null;
    }

    @Override
    protected String wavRegleJeu() {
        return null;
    }
}
