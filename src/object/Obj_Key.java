package object;

public class Obj_Key extends SuperObject {

    public Obj_Key() {

        name = "Key";
        try {
            image = javax.imageio.ImageIO.read(getClass().getResource("/objects/key.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
