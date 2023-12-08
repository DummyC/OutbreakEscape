package tiles;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import blood.Blood;
import entities.Entity;
import entities.Obstacle;
//import entities.Object;
import entities.Vector2D;
import entities.creatures.Player;
import entities.creatures.Zombie;
import graphics.Assets;
import graphics.Sound;
import input.KeyManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.concurrent.ThreadLocalRandom;
import main.Handler;
import main.Window;
import particles.Particle;
import states.GameState;
import states.Screens;
//import states.State;

//import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

public class World {

    Graphics2D g2d;
    public static int WIDTH;
    public static int HEIGHT;

    private int[][] tiles = new int[][]{
        {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}

    };

    /*
	private int[][] tiles = new int[][]{
		{0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
		{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		{0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0},
		{0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0},
		{0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0},
		{0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		{0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
	};
     */
    private final Handler handler;
    public final GameState gameState;
    private final Screens screens;
    private KeyManager keyManager;
    private ArrayList<Entity> zombiesAndBullets;
    private ArrayList<Particle> particles;
    private ArrayList<Entity> obstacles;
    private ArrayList<Blood> bloodSplats;
    private ArrayList<Entity> objects;

    private Player player;
    private Sound click;
    public int points;
    public int musicAndWaveFlag = 0;

    private long waveStartTimer;
    private long waveStartTimerDiff;
    private int waveCount;
    private boolean waveStart;
    private int waveDelay = 2000;
    private int waveSpawnCount = 8;
    
    //private EmbeddedMediaPlayerComponent trailerVideo;

    public World(Handler handler, GameState gameState) {
        this.handler = handler;
        this.gameState = gameState;
        this.keyManager = handler.getKeyManager();
        screens = new Screens();
        WIDTH = tiles[0].length;
        HEIGHT = tiles.length;
        zombiesAndBullets = new ArrayList<Entity>();
        particles = new ArrayList<Particle>();
        obstacles = new ArrayList<Entity>();
        bloodSplats = new ArrayList<Blood>();
        objects = new ArrayList<Entity>();
        player = new Player(new Vector2D(1728, 1216), 4, this);
        points = 0;
        this.click = new Sound(Assets.click);

        waveStartTimer = 0;
        waveStartTimerDiff = 0;
        waveStart = false;
        waveCount = 0;

        this.gameState.gameState = gameState.titleState;

        drawObstacles();

    }

    public void update() throws InterruptedException {
        if (keyManager.pause) {
            if (gameState.gameState == gameState.playState) {
                Thread.sleep(200);
                gameState.gameState = gameState.pauseState;
            } else if (gameState.gameState == gameState.pauseState) {
                Thread.sleep(200);
                gameState.gameState = gameState.playState;
            }
        }

        if (gameState.gameState == gameState.playState) {

            //wave system
            if (waveStartTimer == 0 && zombiesAndBullets.isEmpty()) {
                waveCount++;
                waveStart = false;
                waveStartTimer = System.nanoTime();
            } else {
                waveStartTimerDiff = (System.nanoTime() - waveStartTimer) / 1000000;
                if (waveStartTimerDiff > waveDelay) {
                    waveStart = true;
                    waveStartTimer = 0;
                    waveStartTimerDiff = 0;
                }
            }

            //new wave
            if (waveStart && zombiesAndBullets.isEmpty()) {
                createNewWave();
            }

            if (musicAndWaveFlag == 1) {
                this.gameState.mainmenu.stopSound();
                this.gameState.background.changeVolume(-10);
                this.gameState.background.loopSound();
                //timer.start();
                musicAndWaveFlag--;
            }
            player.update();

            for (int i = 0; i < zombiesAndBullets.size(); i++) {
                zombiesAndBullets.get(i).update();
            }
            for (int i = 0; i < particles.size(); i++) {
                if (particles.get(i).update()) {
                    particles.remove(i);
                }
            }
            for (int i = 0; i < obstacles.size(); i++) {
                obstacles.get(i).update();
            }

            for (int i = 0; i < objects.size(); i++) {
                objects.get(i).update();
            }

        } else if (gameState.gameState == gameState.titleState) {
            if (musicAndWaveFlag == 0) {
                this.gameState.background.stopSound();
                this.gameState.mainmenu.changeVolume(-10);
                this.gameState.mainmenu.loopSound();
                musicAndWaveFlag++;
            }

            if (screens.titleScreenState == 0) {
                if (keyManager.up) {
                    click.playSound();
                    screens.selectionNum--;
                    Thread.sleep(200);
                    if (screens.selectionNum < 0) {
                        screens.selectionNum = 3;
                    }
                }
                if (keyManager.down) {
                    click.playSound();
                    screens.selectionNum++;
                    Thread.sleep(200);
                    if (screens.selectionNum > 3) {
                        screens.selectionNum = 0;
                    }
                }
                if (keyManager.enter) {
                    click.playSound();
                    Thread.sleep(200);
                    if (screens.selectionNum == 0) {

                        screens.titleScreenState = 1;
                    }
                    if (screens.selectionNum == 1) {

                        screens.titleScreenState = 2;
                    }
                    if (screens.selectionNum == 2) {

                        screens.titleScreenState = 3;
                    }
                    if (screens.selectionNum == 3) {
                        System.exit(0);
                    }

                }
            } else if (screens.titleScreenState == 1) {

                if (keyManager.pause) {
                    click.playSound();
                    Thread.sleep(200);
                    screens.titleScreenState = 0;
                }
                if (keyManager.enter) {
                    click.playSound();
                    Thread.sleep(200);
                    playReset();
                    screens.titleScreenState = -1;
                }
            } else if (screens.titleScreenState == 2) {

                if (keyManager.pause) {
                    click.playSound();
                    Thread.sleep(200);
                    screens.titleScreenState = 0;
                }
                if (keyManager.enter) {
                    click.playSound();
                    Thread.sleep(200);
                    screens.titleScreenState = 0;
                }
            } else if (screens.titleScreenState == 3) {

                if (keyManager.pause) {
                    click.playSound();
                    Thread.sleep(200);
                    screens.titleScreenState = 0;
                }
                if (keyManager.enter) {
                    click.playSound();
                    Thread.sleep(200);
                    screens.titleScreenState = 0;
                }
            }

        } else if (gameState.gameState == gameState.gameOverState) {
            if (keyManager.up) {
                click.playSound();
                screens.selectionNum--;
                Thread.sleep(200);
                if (screens.selectionNum < 0) {
                    screens.selectionNum = 1;
                }
            }
            if (keyManager.down) {
                click.playSound();
                screens.selectionNum++;
                Thread.sleep(200);
                if (screens.selectionNum > 1) {
                    screens.selectionNum = 0;
                }
            }
            if (keyManager.enter) {
                click.playSound();
                Thread.sleep(200);
                if (screens.selectionNum == 0) {
                    this.gameState.background.playSound();
                    playReset();
                } else if (screens.selectionNum == 1) {
                    gameState.gameState = gameState.titleState;
                    screens.titleScreenState = 0;
                }
            }
        } else if (gameState.gameState == gameState.pauseState) {
            if (keyManager.up) {
                click.playSound();
                screens.selectionNum--;
                Thread.sleep(200);
                if (screens.selectionNum < 0) {
                    screens.selectionNum = 2;
                }
            }
            if (keyManager.down) {
                click.playSound();
                screens.selectionNum++;
                Thread.sleep(200);
                if (screens.selectionNum > 2) {
                    screens.selectionNum = 0;
                }
            }
            if (keyManager.enter) {
                click.playSound();
                Thread.sleep(200);
                if (screens.selectionNum == 0) {
                    gameState.gameState = gameState.playState;
                } else if (screens.selectionNum == 1) {
                    if (this.gameState.background.isRunning()) {
                        this.gameState.background.stopSound();
                    } else {
                        this.gameState.background.playSound();
                    }
                } else if (screens.selectionNum == 2) {
                    gameState.gameState = gameState.titleState;
                    screens.titleScreenState = 0;
                }
            }
        }

    }

    public void render(Graphics g) {
        int x = (int) handler.getWindow().getCamera().getOffset().getX();
        int y = (int) handler.getWindow().getCamera().getOffset().getY();

        Graphics2D g2d = (Graphics2D) g;

        int xStart = (int) Math.max(0, x / Tile.TILESIZE);
        int yStart = (int) Math.max(0, y / Tile.TILESIZE);
        int xEnd = (int) Math.min(WIDTH, (x + Window.WIDTH) / Tile.TILESIZE + 1);
        int yEnd = (int) Math.min(HEIGHT, (y + Window.WIDTH) / Tile.TILESIZE + 1);

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (gameState.gameState == gameState.titleState) {
            screens.drawTitleScreen(g);
        } else if (gameState.gameState == gameState.playState) {
            for (int i = yStart; i < yEnd; i++) {
                for (int j = xStart; j < xEnd; j++) {
                    getTile(i, j).render(g, new Vector2D(j * Tile.TILESIZE - x, i * Tile.TILESIZE - y));
                }
            }

            for (int i = 0; i < bloodSplats.size(); i++) {
                bloodSplats.get(i).render(g);
            }

            for (int i = 0; i < particles.size(); i++) {
                particles.get(i).render(g);
            }

            for (int i = 0; i < obstacles.size(); i++) {
                obstacles.get(i).render(g);
            }

            for (int i = 0; i < objects.size(); i++) {
                objects.get(i).render(g);
            }

            for (int i = 0; i < zombiesAndBullets.size(); i++) {
                zombiesAndBullets.get(i).render(g);
            }

            player.render(g);

            drawWaveCount(g);

            //draw wave
            if (waveStartTimer != 0) {
                g.setFont(Assets.primary.deriveFont(Font.PLAIN, 70));
                String text = "WAVE " + waveCount;
                int x2 = screens.getXForCenteredText(text, g);
                int alpha = (int) (255 * Math.sin(3.14 * waveStartTimerDiff / waveDelay));
                if (alpha > 255) {
                    alpha = 255;
                }
                g.setColor(new Color(255, 0, 0, alpha).darker());
                g.drawString(text, x2, Window.HEIGHT / 2);

            }

            player.getCurrentGun().render(g);
        } else if (gameState.gameState == gameState.pauseState) {
            screens.drawPauseScreen(g);
        } else if (gameState.gameState == gameState.gameOverState) {

            screens.drawGameOverScreen(g);

            g2d.setFont(Assets.secondary.deriveFont(Font.BOLD, 50));
            String text = "Total Points: " + points;
            int x2 = screens.getXForCenteredText(text, g);
            int y2 = 380;

            g2d.drawString(text, x2, y2);

            text = "Waves Lasted: " + waveCount;
            x2 = screens.getXForCenteredText(text, g);
            y2 = 430;

            g2d.drawString(text, x2, y2);
        }
    }

    private void playReset() {
        zombiesAndBullets.clear();
        player.setDefaults();
        player.spawn();
        objects.clear();
        gameState.gameState = gameState.playState;
        waveStartTimer = 0;
        waveStartTimerDiff = 0;
        waveStart = true;
        waveCount = 0;
        points = 0;
        waveSpawnCount = 8;
    }

    private void drawWaveCount(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(Assets.secondary.deriveFont(Font.BOLD, 35));
        g2d.setColor(Color.white);
        String text = "Wave: " + waveCount;

        g2d.drawString(text, 25, Window.HEIGHT - 25);
    }

    private void createNewWave() {
        zombiesAndBullets.clear();

        for (int i = 0; i < waveSpawnCount; i++) {
            spawnNewZombies();
        }

        waveSpawnCount += 2;

        System.out.println("waveSpawnCount: " + waveSpawnCount);
        System.out.println("Wave Spawn Successful");
    }

    private void spawnNewZombies() {

        int randomVelocity = ThreadLocalRandom.current().nextInt(2, 6 + 1);
        int randomSpawn = ThreadLocalRandom.current().nextInt(1, 4 + 1);
        int randomX = 0, randomY = 0;

        switch (randomSpawn) {
            case 1:
                randomX = ThreadLocalRandom.current().nextInt(0, 300);
                randomY = ThreadLocalRandom.current().nextInt(0, 300);
                zombiesAndBullets.add(new Zombie(new Vector2D(randomX, randomY), randomVelocity, player));
                break;
            case 2:
                randomX = ThreadLocalRandom.current().nextInt(3250, 3450);
                randomY = ThreadLocalRandom.current().nextInt(0, 300);
                zombiesAndBullets.add(new Zombie(new Vector2D(randomX, randomY), randomVelocity, player));
                break;
            case 3:
                randomX = ThreadLocalRandom.current().nextInt(0, 300);
                randomY = ThreadLocalRandom.current().nextInt(2150, 2430);
                zombiesAndBullets.add(new Zombie(new Vector2D(randomX, randomY), randomVelocity, player));
                break;
            case 4:
                randomX = ThreadLocalRandom.current().nextInt(3250, 3450);
                randomY = ThreadLocalRandom.current().nextInt(2150, 2430);
                zombiesAndBullets.add(new Zombie(new Vector2D(randomX, randomY), randomVelocity, player));
                break;

        }

        //zombiesAndBullets.add(new Zombie(new Vector2D(randomX, randomY), randomVelocity, player));
        System.out.println("Zombie Spawned at " + randomX + ", " + randomY + " with speed " + randomVelocity);
    }

    private void drawObstacles() {
        ArrayList<Integer> randomXList = new ArrayList<Integer>();
        ArrayList<Integer> randomYList = new ArrayList<Integer>();

        for (int i = 0; i < 30; i++) {
            int randomX = ThreadLocalRandom.current().nextInt(400, 3250);
            int randomY = ThreadLocalRandom.current().nextInt(400, 2150);

            if (!randomXList.contains(randomX) && !randomYList.contains(randomY) && 1150 < randomX && randomX > 1300 && 1650 < randomY && randomY > 1800) {
                obstacles.add(new Obstacle(handler, new Vector2D(randomX, randomY), Assets.tree));
                System.out.println("Obstacle spawned at " + randomX + ", " + randomY);
            } else {
                obstacles.add(new Obstacle(handler, new Vector2D(randomX + 200, randomY + 200), Assets.tree));
                System.out.println("Obstacle spawned at " + randomX + ", " + randomY);
            }

            randomXList.add(randomX);
            randomYList.add(randomY);

        }

        for (int i = 0; i < 30; i++) {
            int randomX = ThreadLocalRandom.current().nextInt(200, 3250);
            int randomY = ThreadLocalRandom.current().nextInt(200, 2150);

            if (!randomXList.contains(randomX) && !randomYList.contains(randomY) && 1150 < randomX && randomX > 1300 && 1650 < randomY && randomY > 1800) {
                obstacles.add(new Obstacle(handler, new Vector2D(randomX, randomY), Assets.crate));
                System.out.println("Obstacle spawned at " + randomX + ", " + randomY);
            } else {
                obstacles.add(new Obstacle(handler, new Vector2D(randomX + 200, randomY + 200), Assets.crate));
                System.out.println("Obstacle spawned at " + randomX + ", " + randomY);
            }

            randomXList.add(randomX);
            randomYList.add(randomY);
        }

        randomXList.clear();
        randomYList.clear();

    }

    public Tile getTile(int x, int y) {
        Tile tile = Tile.tiles[tiles[x][y]];
        return tile;
    }

    public Handler getHandler() {
        return handler;
    }

    public ArrayList<Entity> getZombiesAndBullets() {
        return zombiesAndBullets;
    }

    public ArrayList<Particle> getParticles() {
        return particles;
    }

    public ArrayList<Entity> getObstacles() {
        return obstacles;
    }

    public ArrayList<Blood> getBloodSplats() {
        return bloodSplats;
    }

    public ArrayList<Entity> getObjects() {
        return objects;
    }

    public int getPoints() {
        return points;
    }
}
