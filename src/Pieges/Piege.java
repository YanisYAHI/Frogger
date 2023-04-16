package Pieges;

import gameCommons.Game;
import graphicalElements.Element;
import images.Images;
import util.Case;


public class Piege implements IPiege {
    private final Game game;
    private Case position;

    public Piege(Game game, Case position) {
        this.game = game;
        this.position = position;
    }

    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }

    public void addToGraphics() {
        game.getGraphic().add(new Element(position.absc, position.ord, Images.bombImage));

    }
    public boolean covers(Case c){
        if(c.ord == position.ord){
            return c.absc == position.absc;
        }
        return false;
    }

    public boolean action(){
        return false;
    }

    public boolean forbidden(Case c) {
        return false;
    }
}
