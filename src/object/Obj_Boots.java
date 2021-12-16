package object;

public class Obj_Boots extends SuperObject{
    public Obj_Boots() {

        name = "Boots";
        try {
            image = javax.imageio.ImageIO.read(getClass().getResource("/objects/boots.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        collision = true;
    }
}
