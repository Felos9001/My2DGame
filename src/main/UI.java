package main;

import object.Obj_Key;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gp;
    Font arial_40;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";


    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.BOLD, 40);
        Obj_Key key = new Obj_Key();
        keyImage = key.image;
    }

    public void ShowMessage(String message) {
        this.message = message;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {

        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);
        g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2.drawString("x = " +gp.player.hasKey, 74, 65 );

    }
}

