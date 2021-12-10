package object;

public class Obj_Door extends SuperObject{
    public Obj_Door() {

        name = "Door";
        try {
            image = javax.imageio.ImageIO.read(getClass().getResource("/objects/door.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        collision = true;
    }
}
