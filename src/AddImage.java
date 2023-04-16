import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AddImage {
    public static void main(String[] args) {

        //Création de JFrame
        JFrame frame = new JFrame("JLabel Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //URL de l'image
        String imgUrl="Y:\\Code\\Java\\Frogger\\src\\frog.jpg";
        ImageIcon icone = new ImageIcon(imgUrl);
        JLabel jlabel = new JLabel(icone);

        //Création de JLable avec un alignement gauche
        //JLabel jlabel = new JLabel(icone, JLabel.CENTER);

        //ajouter les deux JLabel a JFrame
        frame.getContentPane().add(jlabel);
        frame.validate();
    }
}
