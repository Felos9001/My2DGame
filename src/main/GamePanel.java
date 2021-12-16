package main;

import Entity.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GamePanel extends JPanel implements Runnable {

    //Screen Settings
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3; //set the scale to 3 for 3x3 tiles

    public int tileSize = originalTileSize * scale; //16x16 tile * 3 = 48x48 tile
    public int maxScreenCol = 16; //16 tiles wide
    public int maxScreenRow = 12; //12 tiles high
    public int screenWidth = maxScreenCol * tileSize; //16 tiles * 48 = 768
    public int screenHeight = maxScreenRow * tileSize; //12 tiles * 48 = 576

    //World Settings
    public final int maxWorldCol = 50; //50 tiles wide
    public final int maxWorldRow = 50; //50 tiles high

    //FPS
    int FPS = 60;

    //SYSTEM
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Sound sound = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    Thread gameThread;

    //ENTITY AND OBJECT
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[10];


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //sets the size of the game panel
        this.setBackground(Color.BLACK);   //sets the background color to black
        this.setDoubleBuffered(true); //sets the game panel to double buffered. this ca improve game rendering performance
        this.addKeyListener(keyH); //adds the key listener to the game panel
        this.setFocusable(true); //allows the game panel to be "focused" to recieve key imputs

    }

    public void setUpGame() {
        aSetter.setObject();

        playMusic(0);
    }

    public void startGameThread() {
        gameThread = new Thread(this); //passes the run method to the thread
        gameThread.start(); //starts the thread
    }

    @Override
    public void run() {

        while (gameThread != null) {//while the game thread is alive, it repeats the following code

            double drawInterval = 1000000000.0 / FPS; //sets the draw interval to 0.1666 FPS
            double drawNextTime = System.nanoTime() + drawInterval; //sets the draw next time to the current time plus the draw interval

            //1.UPDATE: update information such as character position
            update();

            //2.DRAW: draw the screen with the updated information
            repaint();

            try {
                double remainingTime = drawNextTime - System.nanoTime(); //calculates the remaining time
                remainingTime = remainingTime / 1000000; //converts the remaining time to milliseconds

                if ( remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime); //sleeps the thread for the remaining time

                drawNextTime += drawInterval; //sets the draw next time to the current time plus the draw interval


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

        public void update() {

            player.update();

        }

        public void paintComponent(Graphics g) {

            super.paintComponent(g); //calls the paint component method of the parent class

            Graphics2D g2 = (Graphics2D) g; //converts the graphics object to a 2D graphics object

            //TILES
            tileM.draw(g2);

            //OBJECTS
            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null) {
                    obj[i].draw(g2, this);
                }
            }

            //PLAYER
            player.draw(g2);
            //UI
            ui.draw(g2);

            g2.dispose(); //disposes of the graphics object


    }

    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    public void stopMusic() {
        sound.stop();
    }
    public void playSE(int i) {
        sound.setFile(i);
        sound.play();
    }

}
