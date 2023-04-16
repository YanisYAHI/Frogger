package Pieges;

import gameCommons.Game;
import graphicalElements.Element;
import images.Images;
import util.Case;

import java.io.File;

public class Bonus implements IPiege{
    private final Game game;
    private Case position;
    private final int valeur;

    public Bonus(Game game, Case position) {
        this.game = game;
        this.position = position;
        this.valeur = 3;
    }
    public Bonus(Game game, Case position,int valeur) {
        this.game = game;
        this.position = position;
        this.valeur = valeur;
    }


    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }

    public void addToGraphics(){
        game.getGraphic().add(new Element(position.absc,position.ord, Images.pieceImage));
    }

    public boolean action(){
        game.music.PlayMusicBonus(new File("src/Music/sonic_ring.wav"));
        game.getFrog().setScore(valeur);
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
