package main;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.*;
import javax.sound.sampled.AudioSystem;

public class Sound {
    Clip clip;
    URL[] soundURL = new URL[30];

    public Sound() {

        soundURL[0] = getClass().getResource("/sounds/ZeldaTheme.wav");
        soundURL[1] = getClass().getResource("/sounds/coin.wav");
        soundURL[2] = getClass().getResource("/sounds/powerup.wav");
        soundURL[3] = getClass().getResource("/sounds/unlock.wav");
        soundURL[4] = getClass().getResource("/sounds/fanfare.wav");
    }

    public void setFile(int i) {
        try {
                AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
                clip = AudioSystem.getClip();
                clip.open(ais);
            } catch (Exception e) {
            }
        }

    public void play() {

        clip.start();

    }
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }
    public void stop() {
            clip.stop();
        }
    }

