package Pieges;

import gameCommons.Game;
import graphicalElements.Element;
import images.Images;
import util.Case;

import java.io.File;


public class Tremplin implements IPiege {
    private final Game game;
    private Case position;


    public Tremplin(Game game, Case position) {
        this.game = game;
        this.position = position;
    }

    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }


    public void addToGraphics(){
        game.getGraphic().add(new Element(position.absc,position.ord, Images.tremplinImage));
    }

    public boolean action(){
        game.music.PlayMusicBonus(new File("src/Music/boing.wav"));
        if(game.isTwoPlayers) {
            if (covers(game.getFrogTwo().getPosition())) {
                game.getFrogTwo().move(game.getFrogTwo().getDirection());
                return true;
            }
        }
        game.getFrog().move(game.getFrog().getDirection());
        return true;
    }

    public boolean covers(Case c){
        if(c.ord == position.ord){
            return c.absc == position.absc;
        }
        return false;
    }

    public boolean forbidden(Case c) {
        return false;
    }
}