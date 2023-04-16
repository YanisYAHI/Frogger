package environment;

import gameCommons.Game;
import graphicalElements.Element;
import images.Images;
import util.Case;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Car implements IObstacle{
	private final Game game;
	private final boolean leftToRight;
	private final int length;
	private final ArrayList<Image> sprite;
	private Case leftPosition;


	//Constructor
	public Car(Game game, Case leftPosition, boolean leftToRight) {
		this.game = game;
		this.leftPosition = leftPosition;
		this.leftToRight = leftToRight;
		this.length = game.randomGen.nextInt(2)+1;
		Images imageClass = new Images();
		this.sprite = imageClass.giveObstacle(leftToRight, length, false);
	}


	public void setLeftPosition(Case c){
		this.leftPosition = c;
	}

	public Case getLeftPosition() {
		return leftPosition;
	}



	public void addToGraphics() {
		for (int i = 0; i < length; i++) {
			game.getGraphic().add(new Element(leftPosition.absc + i, leftPosition.ord, sprite.get(i)));
		}
	}


	public void move(){
		if(leftToRight) {
			this.leftPosition = new Case(leftPosition.absc + 1, leftPosition.ord);
		}
		else{
			this.leftPosition = new Case(leftPosition.absc - 1,leftPosition.ord);
		}
	}


	public boolean covers(Case c){
		if(c.ord == leftPosition.ord){
			for (int i = 0; i < length; i++) {
				if (leftPosition.absc + i == c.absc) {
					return true;
					}
				}
			}
		return false;
	}


	public boolean action() {
		game.music.PlayMusicBonus(new File("src/Music/Gta.wav"));
		return false;
	}


	public boolean action2(){
		game.music.PlayMusicBonus(new File("src/Music/Gta.wav"));
		return false;
	}

}
