package main;


import Entity.entity;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker (GamePanel gp) {
        this.gp = gp;

    }

    public void checkTile(entity Entity) {

        int entityLeftWorldX = Entity.worldX + Entity.solidArea.x;
        int entityRightWorldX = Entity.worldX + Entity.solidArea.x + Entity.solidArea.width;
        int entityTopWorldY = Entity.worldY + Entity.solidArea.y;
        int entityBottomWorldY = Entity.worldY + Entity.solidArea.y + Entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        switch (Entity.direction) {
            case "up" -> {
                entityTopRow = (entityTopWorldY - Entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    Entity.collisionOn = true;
                }
            }
            case "down" -> {
                entityBottomRow = (entityBottomWorldY + Entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    Entity.collisionOn = true;
                }
            }
            case "left" -> {
                entityLeftCol = (entityLeftWorldX - Entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    Entity.collisionOn = true;
                }
            }
            case "right" -> {
                entityRightCol = (entityRightWorldX + Entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    Entity.collisionOn = true;
                }
            }
        }
    }

    public int checkObject(entity Entity, boolean Player) {

        int index = 999;

        for(int i = 0; i < gp.obj.length; i++) {

            if(gp.obj[i] != null) {

                //Get entity's solid area position
                Entity.solidArea.x = Entity.worldX + Entity.solidArea.x;
                Entity.solidArea.y = Entity.worldY + Entity.solidArea.y;


                //Get the objects solid area position
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                switch (Entity.direction) {
                    case "up" -> {
                        Entity.solidArea.y -= Entity.speed;
                        if (Entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision == true) {
                                Entity.collisionOn = true;
                            }
                            if (Player == true) {
                                index = i;
                            }
                        }
                    }
                    case "down" -> {
                        Entity.solidArea.y += Entity.speed;
                        if (Entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision == true) {
                                Entity.collisionOn = true;
                            }
                            if (Player == true) {
                                index = i;
                            }
                        }
                    }
                    case "left" -> {
                        Entity.solidArea.x -= Entity.speed;
                            if (Entity.solidArea.intersects(gp.obj[i].solidArea)) {
                                if (gp.obj[i].collision == true) {
                                    Entity.collisionOn = true;
                                }
                                if (Player == true) {
                                    index = i;
                                }
                            }
                        }
                    case "right" -> {
                        Entity.solidArea.x += Entity.speed;
                        if (Entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision == true) {
                                Entity.collisionOn = true;
                            }
                            if (Player == true) {
                                index = i;
                            }
                        }
                    }
                }
                Entity.solidArea.x = Entity.solidAreaDefaultX;
                Entity.solidArea.y = Entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }
        }
        return index;
    }
}

