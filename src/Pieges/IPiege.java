package Pieges;

import util.Case;


public interface IPiege {

     Case getPosition();

     void setPosition(Case position);

     /**
      * Ajout de l'element graphique à la fenêtre
      */
     void addToGraphics();

     /**
      * Lance l'action associée au piège
      * @return true ou false selon sa létalité
      */
     boolean action();

     /**
      * Vérifie si une des cases de l'obstacle couvre la case c prise en paramètre
      * @param c
      * @return true ou false si la case est couverte ou non
      */
     boolean covers(Case c);

     /**
      * Vérifie si un tunnel couvre la case c
      * @param c
      * @return true si tunnel, false sinon
      */
     boolean forbidden(Case c);
}