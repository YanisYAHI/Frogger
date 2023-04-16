package gameCommons;

import environment.EnvInf;
import graphicalElements.FroggerGraphic;
import graphicalElements.IFroggerGraphics;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args)throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		//Caract�ristiques du jeu
		int width = 26;
		int height = 20;
		int tempo = 100;
		int minSpeedInTimerLoops = 3;
		double defaultDensity = 0.01;
		//Cr�ation de l'interface graphique
		IFroggerGraphics graphic = new FroggerGraphic(width, height);
		//Cr�ation de la partie
		Game game = new Game(graphic, width, height, minSpeedInTimerLoops, defaultDensity, false, true);

		//Boucle principale : l'environnement s'acturalise tous les tempo milisecondes
		File file = new File("src/Music/Doom.wav");

		// Musique
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();

		Timer timer = new Timer(tempo, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (game.isPartie()) {
					game.update();
					graphic.repaint();
					if (!game.isPartie() && !game.isTwoPlayers) {
						clip.stop();
						if (game.getEnvironment() instanceof EnvInf){
							game.music.PlayMusicBonus(new File("src/Music/Naruto.wav"));
						}
						if(game.testWin()){
							game.music.PlayMusicBonus(new File("src/Music/Victory.wav"));
						}
						if(game.testLose()){
							game.music.PlayMusicBonus(new File("src/Music/Naruto.wav"));
						}
					}
					if(game.isTwoPlayers) {
						if (game.testWinTwoPlayers() || (game.isTwoPlayers && !game.isPartie())) {
							clip.stop();
							game.music.PlayMusicBonus(new File("src/Music/Victory.wav"));
						}
					}
				}
			}
		});
		timer.setInitialDelay(0);
		timer.start();

	}
}