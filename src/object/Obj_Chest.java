package object;

public class Obj_Chest extends SuperObject{

    public Obj_Chest() {

        name = "Chest";
        try {
            image = javax.imageio.ImageIO.read(getClass().getResource("/objects/chest.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
