package blood;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import entities.Vector2D;
import graphics.Assets;
import java.util.concurrent.ThreadLocalRandom;
import tiles.World;

public class Blood {

    private Vector2D position;
    private float alpha;
    private World world;
    private int randomNum;

    public Blood(Vector2D position, World world) {
        this.position = position;
        this.world = world;
        alpha = 1;
        randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
    }

    public void render(Graphics g) {

        int x = (int) world.getHandler().getWindow().getCamera().getOffset().getX();
        int y = (int) world.getHandler().getWindow().getCamera().getOffset().getY();

        Graphics2D g2d = (Graphics2D) g;

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        switch (randomNum) {
            case 1:
                g2d.drawImage(Assets.blood1, (int) (position.getX() - x), (int) (position.getY() - y), null);
                break;
            case 2:
                g2d.drawImage(Assets.blood2, (int) (position.getX() - x), (int) (position.getY() - y), null);
                break;
            case 3:
                g2d.drawImage(Assets.blood3, (int) (position.getX() - x), (int) (position.getY() - y), null);
                break;
            default:
                break;
        }

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));

        alpha -= 0.001f;
        if (alpha < 0) {
            world.getBloodSplats().remove(this);
        }
    }

}
