package graphicalElements;

import util.Case;

import java.awt.*;


public class Element extends Case {
    public Image image;


    /**
     * Prend une image comme affichage sur la fenetre
     * @param absc
     * @param ord
     * @param image
     */
    public Element(int absc, int ord, Image image) {
        super(absc, ord);
        this.image = image;
    }

    public Element(Case c, Image image) {
        super(c.absc, c.ord);
        this.image = image;
    }

}
