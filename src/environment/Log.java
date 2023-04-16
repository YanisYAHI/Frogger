package environment;

import gameCommons.Game;
import graphicalElements.Element;
import images.Images;
import util.Case;
import util.Direction;

import java.awt.*;
import java.util.ArrayList;

public class Log implements IObstacle{

    private final Game game;
    private final int length = 3;
    private Case leftPosition;
    private final boolean leftToRight;
    private final ArrayList<Image> sprite;

    public Log(Game game,Case leftPosition,boolean leftToRight){
        this.game = game;
        this.leftPosition = leftPosition;
        this.leftToRight = leftToRight;
        Images imageClass = new Images();
        this.sprite = imageClass.giveObstacle(leftToRight, length, true);
    }


    public void setLeftPosition(Case c){
        this.leftPosition = c;
    }

    public Case getLeftPosition() {
        return leftPosition;
    }


    public void addToGraphics() {
        for(int i = 0; i < length; i++){
            game.getGraphic().add(new Element(leftPosition.absc+i, leftPosition.ord, sprite.get(i)));
        }
    }

    /**
     * Bouge la grenouille sur le rondin
     * @param sndFrog
     */
    private void moveGrenouille(boolean sndFrog){
        if (!sndFrog) {
            if (leftToRight) {
                game.getFrog().move(Direction.right);
            } else {
                game.getFrog().move(Direction.left);
            }
        }
        else{
            if (leftToRight) {
            game.getFrogTwo().move(Direction.right);
        } else {
            game.getFrogTwo().move(Direction.left);
        }
        }
    }


    public boolean action(){
        return true;
    }

    public boolean action2(){
        return true;
    }


    public void move(){
        if(covers(game.getFrog().getPosition())){
            moveGrenouille(false);
        }
        if(game.isTwoPlayers) {
            if (covers(game.getFrogTwo().getPosition())) {
                moveGrenouille(true);
            }
        }
        if(leftToRight) {
            this.leftPosition = new Case(leftPosition.absc + 1, leftPosition.ord);
        }

        else {
            this.leftPosition = new Case(leftPosition.absc - 1, leftPosition.ord);
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

}