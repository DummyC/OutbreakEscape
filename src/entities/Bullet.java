package entities;

import entities.creatures.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import entities.creatures.Zombie;
import graphics.Assets;
import graphics.Sound;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;
import main.Handler;
import particles.Particle;
import tiles.Tile;
import tiles.World;

public class Bullet extends Entity {

    private final Vector2D velocity;
    private final static int BULLETDIAMETER = 6;
    private final int bulletVelocity = 30;
    private Sound zombieHit1, zombieHit2, zombieHit3;
    private World world;
    private BufferedImage muzzle;
    private int tick = 0;
    private AffineTransform at;
    private double angle;

    public Bullet(Handler handler, Vector2D position, Vector2D velocity, World world) {
        super(handler, position, BULLETDIAMETER, BULLETDIAMETER);
        this.velocity = velocity;
        zombieHit1 = new Sound(Assets.zombieHit1);
        zombieHit2 = new Sound(Assets.zombieHit2);
        zombieHit3 = new Sound(Assets.zombieHit3);
        muzzle = Assets.muzzle;
        angle = Player.angle;
        this.world = world;

    }

    @Override
    public void update() {

        position.setX(position.getX() + (velocity.getX() * bulletVelocity));
        position.setY(position.getY() + (velocity.getY() * bulletVelocity));

        Point center = new Point((int) position.getX() - BULLETDIAMETER / 2, (int) position.getY() - BULLETDIAMETER / 2);

        for (int i = 0; i < world.getZombiesAndBullets().size(); i++) {

            if (world.getZombiesAndBullets().get(i) instanceof Bullet) {
                continue;
            }

            Zombie zombie = (Zombie) world.getZombiesAndBullets().get(i);

            if (zombie.getBounds().contains(center)) {
                int random = ThreadLocalRandom.current().nextInt(1, 3 + 1);

                switch (random) {
                    case 1:
                        zombieHit1.playSound();
                        break;
                    case 2:
                        zombieHit2.playSound();
                        break;
                    case 3:
                        zombieHit3.playSound();
                        break;
                }

                for (int j = 0; j <= 360; j += 15) {

                    int speed = (int) (Math.random() * 6);
                    int life = (int) (Math.random() * 20);
                    int size = (int) (Math.random() * 8);

                    world.getParticles().add(new Particle(new Vector2D(position.getX(), position.getY()),
                            size, life, speed, j, Color.RED));
                }
                zombie.hit();
                world.getZombiesAndBullets().remove(this);
            }
        }

        for (int i = 0; i < world.getObstacles().size(); i++) {
            Entity o = world.getObstacles().get(i);

            if (o.getBounds().contains(center)) {
                for (int j = 0; j <= 360; j += 15) {

                    int speed = (int) (Math.random() * 6);
                    int life = (int) (Math.random() * 30);
                    int size = (int) (Math.random() * 10);

                    world.getParticles().add(new Particle(new Vector2D(position.getX(), position.getY()),
                            size, life, speed, j, new Color(95, 45, 0)));
                }
                world.getZombiesAndBullets().remove(this);
            }
        }
        if (position.getX() > World.WIDTH * Tile.TILESIZE || position.getX() < 0) {
            world.getZombiesAndBullets().remove(this);
        }
        if (position.getY() > World.HEIGHT * Tile.TILESIZE || position.getY() < 0) {
            world.getZombiesAndBullets().remove(this);
        }

    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.BLACK);

        g.fillOval((int) (position.getX() - BULLETDIAMETER / 2),
                (int) (position.getY() - BULLETDIAMETER / 2),
                BULLETDIAMETER, BULLETDIAMETER);
        if (tick == 0) {
            g.drawImage(muzzle, (int) (position.getX() - muzzle.getWidth() / 2), (int) (position.getY() - muzzle.getHeight() / 2), null);
            tick++;
        }
    }
}
