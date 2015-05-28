/*  Classe de menu de lancement de l'exemple de jeu.
 *  Cette classe hérite de la classe abstraite MenuAbstrait en définissant les méthodes :
 *     - nomOptions qui renvoie la liste des options possibles pour le menu 
 *     - lancerOption qui associe une action à chaque option du menu
 *     - wavAccueil() qui renvoie le nom du fichier wav lu lors de l'accueil dans le menu
 *     - wavAide() qui renvoie le nom du fichier wav lu lors de l'activation de la touche F1
 */

package menu; 

import game.Difficulty;
import game.Game;
import APIDevint.MenuAbstrait;

public class MenuChoixDifficulte extends MenuAbstrait {

    /** constructeur
     * @param title : le nom du jeu 
     */
    public MenuChoixDifficulte(String title) {
        super(title);
    }

    /** renvoie le nom des options du menu
     * vous pouvez définir autant d'options que vous voulez
     **/
    protected String[] nomOptions() {
        String[] noms = {"Tr�s Facile","Facile","Moyen","Difficile", "Retour"};
        return noms;
    }

    /** lance l'action associée au bouton
     * la numérotation est celle du tableau renvoyé par nomOption
     */
    protected void lancerOption(int i) {
        switch (i){  
        case 0 : new Game(Difficulty.VeryEasy, false);break;
        case 1 : new Game(Difficulty.Easy, false);break;
        case 2 : new Game(Difficulty.Normal, false);break;
        case 3 : new Game(Difficulty.Difficile, false);break;
        case 4 : new MenuJeu(nomJeu);break;
        default: System.err.println("action non d�finie");
        }
        new MenuChoixNiveau(nomJeu);
        this.dispose();
    } 

    // renvoie le fichier wave contenant le message d'accueil
    // ces fichiers doivent être placés dans ressources/sons/
    protected  String wavAccueil() {
        return "../ressources/sons/accueil.wav";
    }

    // renvoie le fichier wave contenant la règle du jeu
    protected  String wavRegleJeu() {
        return "../ressources/sons/accueil.wav";
    }
    
}
