package frog;


import gameCommons.Game;
import gameCommons.IFrog;
import images.Images;
import util.Case;
import util.Direction;

import java.awt.*;

public class Frog implements IFrog {

	private Case position;
	private Direction direction = Direction.up;
	private Game game;
	private int score;
	private Integer scoreMax = 0;
	private boolean playerTwo;

	public Frog(Game game){
		this.position = new Case(game.width/2,0 );
		this.game = game;
		this.score = 0;
	}

	public Frog(Game game, boolean playerTwo){
		this.position = new Case(game.width /2 -3,0 );
		this.game = game;
		this.playerTwo = true;
	}

	public Case getPosition() {
		return position;
	}

	public Direction getDirection() {
		return direction;
	}

    public Integer getScoreMax() {
        return scoreMax;
    }

	public void setScore(int score) {
		this.score += score;
	}

    public Integer getScore() {
        return score;
    }


	public void move(Direction key){
		switch (key) {
			case right:
				this.direction = Direction.right;
				if (!game.getEnvironment().getLane(position.ord).forbidden(new Case(position.absc + 1, position.ord))) {
					if (position.absc + 1 < game.width) {
						this.position = new Case(position.absc + 1, position.ord);
					}
				}
				// Verif si en dehors de l'ecran
				break;
			case left:
				this.direction = Direction.left;
				if(!game.getEnvironment().getLane(position.ord).forbidden(new Case(position.absc-1, position.ord))){
					if(position.absc-1 >= 0) {
						this.position = new Case(position.absc - 1, position.ord);
					}
				}
				break;
			case up:
				this.direction = Direction.up;
				if(!game.getEnvironment().getLane(position.ord+1).forbidden(new Case(position.absc, position.ord+1))) {
						score++;
						if(scoreMax< score){ scoreMax = score;}
						if (position.ord + 1 <= game.height) {
							this.position = new Case(position.absc, position.ord + 1);
						}
					}
				break;
			case down:
				if(!game.getEnvironment().getLane(position.ord-1).forbidden(new Case(position.absc, position.ord - 1))) {
					if (position.ord - 1 >= 0) {
						this.position = new Case(position.absc, position.ord - 1);
					}
					if (score > 0) {
						score--;
					}
					this.direction = Direction.down;
				}

				break;
		}
	}


	public Image getFrogImage(){
		if(playerTwo){
			switch (this.direction){
				case up:
					return Images.frogImage2;
				case down:
					return Images.frogDownImage2;

				case left:
					return Images.frogLeftImage2;

				case right:
					return Images.frogRightImage2;
			}
		}
		switch (direction) {
			case up:
				return Images.frogImage;

			case down:
				return Images.frogDownImage;

			case left:
				return Images.frogLeftImage;
		}
		return Images.frogRightImage;
	}


}
