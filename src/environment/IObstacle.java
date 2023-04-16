package environment;

import util.Case;

public interface IObstacle {

    void setLeftPosition(Case c);
    Case getLeftPosition();

    /**
     * Ajout de l'element graphique à la fenêtre
     */
    void addToGraphics();

    /**
     * Lance une musique de mort
     * Déplace la grenouille si c'est un rondin
     * @return true ou false si ça tue
     */
    boolean action();
    boolean action2();

    /**
     * Déplacement de l'obstacle
     */
    void move();

    /**
     * Vérifie si une des cases de l'obstacle couvre la case c prise en paramètre
     * @param c
     * @return true ou false si la case est couverte ou non
     */
    boolean covers(Case c);

}
