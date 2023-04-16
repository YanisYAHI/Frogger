package Music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Classe auxilière ne servant qu'a lancer la musique
 */
public class PlayMusic {
    private String nom;
    public PlayMusic(String nom){
           this.nom = nom;
        }

        public void PlayMusicBonus(File file){
            AudioInputStream audioStream = null;
            try {
                audioStream = AudioSystem.getAudioInputStream(file);
            } catch (UnsupportedAudioFileException | IOException e) {
                e.printStackTrace();
            }
            Clip clip = null;
            try {
                clip = AudioSystem.getClip();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
            try {
                clip.open(audioStream);
            } catch (LineUnavailableException | IOException e) {
                e.printStackTrace();
            }
            clip.start();
        }

    }
