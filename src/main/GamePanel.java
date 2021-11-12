package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //Screen Settings
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3; //set the scale to 3 for 3x3 tiles

    final int tileSize = originalTileSize * scale; //16x16 tile * 3 = 48x48 tile
    final int maxScreenCol = 16; //16 tiles wide
    final int maxScreenRow = 12; //12 tiles high
    final int screenWidth = maxScreenCol * tileSize; //16 tiles * 48 = 768
    final int screenHeight = maxScreenRow * tileSize; //12 tiles * 48 = 576


    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //set player default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //sets the size of the game panel
        this.setBackground(Color.BLACK);   //sets the background color to black
        this.setDoubleBuffered(true); //sets the game panel to double buffered. this ca improve game rendering performance
        this.addKeyListener(keyH); //adds the key listener to the game panel
        this.setFocusable(true); //allows the game panel to be "focused" to recieve key imputs

    }

    public void startGameThread() {
        gameThread = new Thread(this); //passes the run method to the thread
        gameThread.start(); //starts the thread
    }

    @Override
    public void run() {

        while (gameThread != null) {//while the game thread is alive, it repeats the following code

            //System.out.println("Game loop is running");
            //1.UPDATE: update information such as character position
            update();
            //2.DRAW: draw the screen with the updated information
            repaint();
        }
    }

        public void update() {

        if (keyH.upPressed == true) {
         playerY -=  playerSpeed;
         }
        if (keyH.downPressed == true) {
            playerY += playerSpeed;
        }
        if (keyH.leftPressed == true) {
            playerX -= playerSpeed;
        }
        if (keyH.rightPressed == true) {
            playerX += playerSpeed;
        }
    }
        public void paintComponent(Graphics g) {

            super.paintComponent(g); //calls the paint component method of the parent class

            Graphics2D g2 = (Graphics2D) g; //converts the graphics object to a 2D graphics object
            g2.setColor(Color.WHITE);
            g2.fillRect(playerX, playerY, tileSize, tileSize); //draws a white rectangle over the entire screen
            g2.dispose(); //disposes of the graphics object


    }

}
