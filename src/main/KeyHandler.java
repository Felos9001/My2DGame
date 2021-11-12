package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); //get the key code associated with the key pressed

        if (code == KeyEvent.VK_W) { //if the key pressed is W
            upPressed = true;
        }
        if (code == KeyEvent.VK_A) { //if the key pressed is
            leftPressed = true;
        }
        if (code == KeyEvent.VK_S) { //if the key pressed is
            downPressed = true;
        }
        if (code == KeyEvent.VK_D) { //if the key pressed is
            rightPressed = true;
        }
    }

        @Override
        public void keyReleased (KeyEvent e){
            int code = e.getKeyCode();

            if (code == KeyEvent.VK_W) { //if the key pressed is W
                upPressed = false;
            }
            if (code == KeyEvent.VK_A) { //if the key pressed is
                leftPressed = false;
            }
            if (code == KeyEvent.VK_S) { //if the key pressed is
                downPressed = false;
            }
            if (code == KeyEvent.VK_D) { //if the key pressed is
                rightPressed = false;
            }
        }
    }

