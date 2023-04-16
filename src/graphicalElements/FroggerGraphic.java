package graphicalElements;

import gameCommons.IFrog;
import util.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class FroggerGraphic extends JPanel implements IFroggerGraphics, KeyListener {


	private ArrayList<Element> elementsToDisplay;
	private int pixelByCase = 20;
	private int width;
	private int height;
	private IFrog frog;
	private IFrog frogTwo;
	private JFrame frame;


	public FroggerGraphic(int width, int height) {
		this.width = width;
		this.height = height;
		elementsToDisplay = new ArrayList<Element>();

		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(width * pixelByCase, height * pixelByCase));

		JFrame frame = new JFrame("Frogger");
		this.frame = frame;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Element e : elementsToDisplay) {
			g.drawImage(e.image, pixelByCase * e.absc,pixelByCase * (height - 1 - e.ord),20,20,this);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			// Fleches
			case KeyEvent.VK_UP:
				frog.move(Direction.up);
				break;
			case KeyEvent.VK_DOWN:
				frog.move(Direction.down);
				break;
			case KeyEvent.VK_LEFT:
				frog.move(Direction.left);
				break;
			case KeyEvent.VK_RIGHT:
				frog.move(Direction.right);
				break;
			// ZQSD
			case KeyEvent.VK_Z:
				frogTwo.move(Direction.up);
				break;
			case KeyEvent.VK_S:
				frogTwo.move(Direction.down);
				break;
			case KeyEvent.VK_Q:
				frogTwo.move(Direction.left);
				break;
			case KeyEvent.VK_D:
				frogTwo.move(Direction.right);
		}
	}

	public void clear() {
		this.elementsToDisplay.clear();
	}

	public void add(Element e) {
		this.elementsToDisplay.add(e);
	}

	public void setFrog(IFrog frog) {
		this.frog = frog;
	}

	public void setFrogTwo(IFrog frogTwo){
		this.frogTwo = frogTwo;
	}

	public void endGameScreen(String s) {
		frame.remove(this);
		JLabel label = new JLabel(s);
		label.setFont(new Font("Verdana", 1, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setSize(this.getSize());
		frame.getContentPane().add(label);
		frame.repaint();

	}

}