package Pieges;

import gameCommons.Game;
import graphicalElements.Element;
import images.Images;
import util.Case;

public class Tunnel implements IPiege {
    private final Game game;
    private Case position;


    public Tunnel(Game game, Case position) {
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
        game.getGraphic().add(new Element(position.absc, position.ord, Images.tunnelImage));
        game.getGraphic().add(new Element(position.absc+1, position.ord, Images.tunnelImage2));
    }

    public boolean action(){
        return true;
    }

    public boolean covers(Case c) {
        if(c.ord == position.ord){
            for (int i = 0; i < 2; i++) {
                if (position.absc + i == c.absc) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean forbidden(Case c) {
        return covers(c);
    }
}