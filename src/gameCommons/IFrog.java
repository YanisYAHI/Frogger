package gameCommons;

import util.Case;
import util.Direction;

import java.awt.*;

public interface IFrog {
	
	/**
	 * Donne la position actuelle de la grenouille
	 * @return
	 */
    Case getPosition();
	
	/**
	 * Donne la direction de la grenouille, c'est � dire de son dernier mouvement 
	 * @return
	 */
    Direction getDirection();

	/**
	 * Donne le score max qu'a fait la grenouille dans la partie
	 * @return scoreMax
	 */
	Integer getScoreMax();

	/**
	 * Donne le score lorsque la grenouille est morte
	 * @return score
	 */
	Integer getScore();

	/**
	 * Déplace la grenouille dans la direction donn�e et teste la fin de partie
	 * @param key
	 */
    void move(Direction key);

	/**
	 * Donne l'image de la grenouille en fonction de sa direction
	 * @return image de la grenouille
	 */
	Image getFrogImage();

	/**
	 * ajoute un bonus au score actuel selon la valeur du bonus
	 * @param bonus
	 */
	void setScore(int bonus);
}
