package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import main.Handler;

public class Object extends Entity {

    private BufferedImage texture;
    private int cameraXoffset, cameraYoffset;

    public Object(Handler handler, Vector2D position, BufferedImage texture, String type) {
        super(handler, position, texture.getWidth(), texture.getHeight());
        this.texture = texture;
        this.type = type;

        bounds.x = bounds.x + 25;
        bounds.y = bounds.y + 20;
        bounds.width = bounds.width - 50;
        bounds.height = bounds.height - 50;

    }

    @Override
    public void update() {
        cameraXoffset = (int) handler.getWindow().getCamera().getOffset().getX();
        cameraYoffset = (int) handler.getWindow().getCamera().getOffset().getY();

        bounds.x = (int) position.getX() + 25 - cameraXoffset;
        bounds.y = (int) position.getY() + 20 - cameraYoffset;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(texture, (int) position.getX() - cameraXoffset + width / 2, (int) position.getY() - cameraYoffset + height / 2, 64, 64, null);
        //g.drawImage(texture, (int) position.getX() + width / 2, (int) position.getY() + height / 2, 64, 64, null);
    }

    public Vector2D getCenter() {
        return new Vector2D(position.getX() + width / 2, position.getY() + height / 2);
    }

    public double getRadius() {
        return width / 2;
    }

}
