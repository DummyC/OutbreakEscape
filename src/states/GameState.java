package states;

import java.awt.Graphics;

import graphics.Assets;
import graphics.Sound;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Handler;
import tiles.World;

public class GameState extends State {


    private World world;
    public Sound background, mainmenu;
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int gameOverState = 3;

    public GameState(Handler handler) {
        super(handler);
        background = new Sound(Assets.background);
        mainmenu = new Sound(Assets.mainmenu);
        world = new World(handler, this);
        

    }

    @Override
    public void update() {
        
        try {
            world.update();
        } catch (InterruptedException ex) {
            Logger.getLogger(GameState.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        
        

    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }
}
