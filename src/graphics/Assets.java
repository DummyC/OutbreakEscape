package graphics;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Assets {
    
    public static Font loadFont(String path) throws FontFormatException {
        try {
            InputStream is = Assets.class.getResourceAsStream(path);
            return Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(Assets.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Clip loadSound(String path) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Assets.class.getResource(path)));
            return clip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static BufferedImage[] pistolIdle = new BufferedImage[20];
    public static BufferedImage[] rifleIdle = new BufferedImage[20];

    public static BufferedImage[] pistolReload = new BufferedImage[15];
    public static BufferedImage[] rifleReload = new BufferedImage[20];

    public static BufferedImage[] pistolShootAnim = new BufferedImage[3];
    public static BufferedImage[] rifleShootAnim = new BufferedImage[3];

    public static BufferedImage[] zombie = new BufferedImage[17];
    public static BufferedImage[] zombieAttack = new BufferedImage[9];

    // blood splats
    public static BufferedImage blood1, blood2, blood3;

    // guns skin
    public static BufferedImage pistolSkin, rifleSkin;
    public static BufferedImage muzzle;

    //sounds
    public static Clip pistolShoot, rifleShoot, background, zombieHit1, zombieHit2, zombieHit3, pistolReloadSound,
            rifleReloadSound, emptyGun, zombieBite, reloadMarshal, hitMarshal, pickup, mainmenu, click, spawnMarshal1, spawnMarshal2, spawnMarshal3, gameOver;

    //tiles
    public static BufferedImage grass, dirt;

    //objects
    public static BufferedImage tree, crate, health, ammo;
    
    //ui
    public static BufferedImage hudTop, titleBG, logo;
    
    public static Font primary, secondary;

    //trees
    //public static BufferedImage[] trees = new BufferedImage[4];
    public static void init() throws FontFormatException {

        // animations
        for (int i = 0; i < pistolIdle.length; i++) {
            pistolIdle[i] = loadImage("/player/idle/pistolIdle/" + i + ".png");
        }

        for (int i = 0; i < rifleIdle.length; i++) {
            rifleIdle[i] = loadImage("/player/idle/rifleIdle/" + i + ".png");
        }

        for (int i = 0; i < pistolReload.length; i++) {
            pistolReload[i] = loadImage("/player/reload/pistol/" + i + ".png");
        }

        for (int i = 0; i < rifleReload.length; i++) {
            rifleReload[i] = loadImage("/player/reload/rifle/" + i + ".png");
        }

        for (int i = 0; i < pistolShootAnim.length; i++) {
            pistolShootAnim[i] = loadImage("/player/shoot/pistol/" + i + ".png");
        }

        for (int i = 0; i < rifleShootAnim.length; i++) {
            rifleShootAnim[i] = loadImage("/player/shoot/rifle/" + i + ".png");
        }

        for (int i = 0; i < zombie.length; i++) {
            zombie[i] = loadImage("/zombie/walk/" + i + ".png");
        }

        for (int i = 0; i < zombieAttack.length; i++) {
            zombieAttack[i] = loadImage("/zombie/attack/" + i + ".png");
        }

        //trees
        //for(int i = 0; i < trees.length; i++)
        //    trees[i] = loadImage("/tress/tree"+i+".png");
        //objects
        tree = loadImage("/obstacles/tree.png");
        crate = loadImage("/obstacles/crate.png");
        health = loadImage("/objects/health.png");
        ammo = loadImage("/objects/ammo.png");
        
        //hud
        hudTop = loadImage("/hud/top.png");
        logo = loadImage("/hud/logo.png");
        
        //screens
        titleBG = loadImage("/hud/titleBG.png");

        // tiles
        grass = loadImage("/tiles/grass.png");
        dirt = loadImage("/tiles/dirt.png");

        // gun skins
        pistolSkin = loadImage("/guns/pistol.png");
        rifleSkin = loadImage("/guns/ak-47.png");
        muzzle = loadImage("/guns/muzzle.png");
        //rifleLoader = loadImage("/guns/rifleLoader.png");

        // blood splats
        blood1 = loadImage("/zombie/blood/bloodsplat.png");
        blood2 = loadImage("/zombie/blood/bloodsplat2.png");
        blood3 = loadImage("/zombie/blood/bloodsplat3.png");

        //sounds
        pistolShoot = loadSound("/pistol.wav");
        rifleShoot = loadSound("/rifle.wav");
        background = loadSound("/background.wav");
        
        pistolReloadSound = loadSound("/pistolreload.wav");
        rifleReloadSound = loadSound("/riflereload.wav");
        emptyGun = loadSound("/emptygun.wav");
        zombieBite = loadSound("/zombieBite.wav");
        reloadMarshal = loadSound("/reloadMarshal.wav");
        hitMarshal = loadSound("/hitMarshal.wav");
        pickup = loadSound("/pickup.wav");
        mainmenu = loadSound("/mainmenu.wav");
        click = loadSound("/click.wav");
        
        spawnMarshal1 = loadSound("/spawnMarshal1.wav");
        spawnMarshal2 = loadSound("/spawnMarshal2.wav");
        spawnMarshal3 = loadSound("/spawnMarshal3.wav");
        
        gameOver = loadSound("/gameover.wav");
        
        zombieHit1 = loadSound("/zombiehit1.wav");
        zombieHit2 = loadSound("/zombiehit2.wav");
        zombieHit3 = loadSound("/zombiehit3.wav");
        

        //font
        primary = loadFont("/font/Futurot.ttf");
        secondary = loadFont("/font/Trade Gothic LT.ttf");
    }

}
