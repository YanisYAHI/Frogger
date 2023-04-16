package environment;

import Pieges.*;
import gameCommons.Game;
import graphicalElements.Element;
import util.Case;
import images.*;


import java.util.ArrayList;

public class Lane {
	private final Game game;
	private int ord;
	private int speed;
	private final ArrayList<IObstacle> obstacles = new ArrayList<>();
	private final boolean leftToRight;
	private double density;
	private int compteur = 0;
	private final ArrayList<IPiege> pieges = new ArrayList<>();
	private final boolean isRoad;
	private  boolean isGrass = false;

	/**
	 * Constructeur de lignes vides sans obstacles pour les deux environements
	 * @param game
	 * @param ord
	 */
	public Lane(Game game, int ord) {
		this.game = game;
		this.ord = ord;
		this.leftToRight = true;
		this.speed = 0;
		this.isRoad= true;
		this.isGrass = true;
	}

	/**
	 * Constructeur de lignes de jeu pour environement normal
	 * @param game
	 * @param ord
	 * @param speed
	 * @param leftToRight
	 * @param density
	 * @param isRoad
	 */
	public Lane(Game game, int ord, int speed, boolean leftToRight, double density, boolean isRoad) {
		this.game = game;
		this.ord = ord;
		this.speed = speed;
		this.leftToRight = leftToRight;
		this.density = density;
		this.isRoad = isRoad;

		// Générateur aléatoire de pièges selon la configuration

		if (game.randomGen.nextInt(10) == 1) {
			pieges.add(new Piege(game, new Case(game.randomGen.nextInt(game.width) - 1, ord)));
			return;
		}
		if (game.randomGen.nextInt(10) == 1 && pieges.isEmpty()) {
			pieges.add(new Tremplin(game, new Case(game.randomGen.nextInt(game.width) - 1, ord)));
		}
		if (game.randomGen.nextInt(20) == 1) {
			pieges.add(new Bonus(game, new Case(game.randomGen.nextInt(game.width) - 1, ord)));
		}
		if (game.randomGen.nextInt(15) == 1 && isRoad) {
			pieges.add(new Tunnel(game, new Case(game.randomGen.nextInt(game.width) - 1, ord)));
		}
	}

	/**
	 * Constructeur de lignes pour environement infini
	 * @param game
	 * @param ord
	 * @param speed
	 * @param leftToRight
	 * @param density
	 */
	public Lane(Game game, int ord, int speed, boolean leftToRight, double density) {
		this.game = game;
		this.ord = ord;
		this.speed = speed;
		this.leftToRight = leftToRight;
		this.density = density;
		this.isRoad = game.randomGen.nextInt(10) != 1;

		// Si ligne d'eau, densité et vitesse prédéfinie.
		if(!this.isRoad){
			this.density = 0.15;
			this.speed = 2;
		}

		// Générateur aléatoire de pièges selon la configuration + ajout d'une piece de 8 à chaque ligne d'eau

		if (game.randomGen.nextInt(10) == 1) {
			pieges.add(new Piege(game, new Case(game.randomGen.nextInt(game.width) - 1, ord)));
		}
		if (game.randomGen.nextInt(10) == 1 && pieges.isEmpty()) {
			pieges.add(new Tremplin(game, new Case(game.randomGen.nextInt(game.width) - 1, ord)));
		}
		if (game.randomGen.nextInt(20) == 1) {
			pieges.add(new Bonus(game, new Case(game.randomGen.nextInt(game.width) - 1, ord)));
		}
		if (game.randomGen.nextInt(15) == 1 && isRoad) {
			pieges.add(new Tunnel(game, new Case(game.randomGen.nextInt(game.width) - 1, ord)));
		}
		if(!isRoad){
			pieges.add(new Bonus(game, new Case(game.randomGen.nextInt(game.width) - 1, ord),8));
		}
	}

	public int getOrd() {
		return ord;
	}

	public ArrayList<IObstacle> getObstacles() {
		return obstacles;
	}

	public ArrayList<IPiege> getPieges() {
		return pieges;
	}

	public void setOrd(int ord) {
		this.ord = ord;
	}

	/**
	 * Vérifie si la case c est une case tunnel
	 * @param c
	 * @return true si tunnel sinon false
	 */
	public boolean forbidden(Case c) {
		for (IPiege p : pieges) {
			if (p.forbidden(c)) {
				return true;
			}
		}
		return false;
	}


	/**
	 * Met a jour la lane et tous ses composant en les réaffichant.
	 */
	public void update() {
		compteur++;
		paintWindow();
		if (compteur == speed) {
			for (IObstacle obs : obstacles) {
				obs.move();
			}
			this.compteur = 0;
		}
		mayAddObstacle();
		for (IPiege p : pieges) {
			p.addToGraphics();
		}
		for (IObstacle obs : obstacles) {
			obs.addToGraphics();
		}
		for (IPiege p : pieges) {
			if( p instanceof Tunnel ) {
				p.addToGraphics();
			}
		}
	}


	/**
	 * Ajoute un obstacle à l'ArrayList d'obstacles si l'ajout de l'obstacle n'en chevauche pas un autre
	 */
	private void mayAddObstacle(){
		if (isSafeObstacle(getFirstCase()) && isSafeObstacle(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < density) {
				if (!isRoad) {
					obstacles.add(new Log(game, getFirstCase(),leftToRight));
				}else {
					obstacles.add(new Car(game, getBeforeFirstCase(), leftToRight));
				}
			}
		}
	}


	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	private Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else
			return new Case(game.width, ord);
	}


	/**
	 * Vérifie si la case est déjà occupée par un obstacle ou un piège
	 * @param c
	 * @return true si possible, false sinon
	 */
	public boolean isSafeObstacle(Case c) {
			for (IPiege p : pieges) {
				if (p.covers(c)) {
					return true;
				}
			}
		for (IObstacle obs : obstacles ) {
			if((obs.covers(c))){
				return false;
			}
		}
		return true;
	}


	/**
	 * Vérifie si la case de la grenouille requiert une action (mort, ou autre action de piège)
	 * @param c
	 * @return true si case sans danger, false sinon
	 */
	public boolean isSafeFrog(Case c) {
		if(c.ord != ord){
			return true;
		}
			for (IPiege p : pieges) {
				if (p.covers(c)) {
					pieges.remove(p);
					return p.action();
				}
			}
		for (IObstacle obs : obstacles ) {
			if(obs.covers(c)){
				return obs.action();
			}
		}
		return isRoad;
	}


	/**
	 * Vérifie si la case de la grenouille 2 requiert une action (mort, ou autre action de piège)
	 * @param c
	 * @return true si case sans danger, false sinon
	 */
	public boolean isSafeFrog2(Case c) {
		if(c.ord != ord){
			return true;
		}
		for (IPiege p : pieges) {
			if (p.covers(c)) {
				pieges.remove(p);
				System.out.println("Piege");
				return (p.action());
			}
		}
		for (IObstacle obs : obstacles ) {
			if(obs.covers(c)){
				return obs.action2();
			}
		}
		return isRoad;
	}


	/**
	 * ajoute les elements graphique à la fenêtre
	 */
	public void paintWindow() {
		for (int i = 0; i < game.width; i++) {
			if (!isRoad)
				game.getGraphic().add(new Element(i, ord, Images.water));
			if(isRoad){
				game.getGraphic().add(new Element(i, ord, Images.road));
			}
			if(isGrass){
				game.getGraphic().add(new Element(i, ord, Images.grassImage));
			}
		}
	}
}
