package states;

import graphics.Assets;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import main.Window;

public class Screens {

    public int selectionNum = 0;
    public int titleScreenState = 0;

    public Screens() {

    }

    public void drawPauseScreen(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        //g2d.setColor(new Color(0,0,0,50));
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);

        int x, x2, x3, y;
        String text, selectionLeft, selectionRight;

        g2d.setFont(Assets.primary.deriveFont(Font.PLAIN, 110f));

        selectionLeft = ">";
        selectionRight = "<";
        text = "PAUSED";
        g2d.setColor(Color.red.darker());
        x = getXForCenteredText(text, g);
        
        y = 270;
        g2d.drawString(text, x, y);

        g2d.setColor(Color.white);
        g2d.drawString(text, x - 5, y - 5);

        g2d.setFont(Assets.secondary.deriveFont(Font.PLAIN, 48));
        x2 = getXForCenteredText(selectionLeft, g);
        x3 = getXForCenteredText(selectionRight, g);
        //Resume
        g2d.setFont(Assets.secondary.deriveFont(Font.PLAIN, 45));
        text = "Resume";
        x = getXForCenteredText(text, g);
        y = 500;

        if (selectionNum == 0) {
            g2d.setFont(Assets.secondary.deriveFont(Font.PLAIN, 48));
            g2d.setColor(Color.red);
            x = getXForCenteredText(text, g);
            g2d.drawString(text, x, y);
            g2d.drawString(selectionLeft, x2 - 150, y);
            g2d.drawString(selectionRight, x3 + 150, y);

            g2d.setFont(Assets.secondary.deriveFont(Font.PLAIN, 45));
            g2d.setColor(Color.white);
        } else {
            g2d.drawString(text, x, y);
        }

        //Music toggle
        text = "Music";
        x = getXForCenteredText(text, g);
        y += 50;

        if (selectionNum == 1) {
            g2d.setFont(Assets.secondary.deriveFont(Font.PLAIN, 48));
            g2d.setColor(Color.red);
            x = getXForCenteredText(text, g);
            g2d.drawString(text, x, y);
            g2d.drawString(selectionLeft, x2 - 150, y);
            g2d.drawString(selectionRight, x3 + 150, y);

            g2d.setFont(Assets.secondary.deriveFont(Font.PLAIN, 45));
            g2d.setColor(Color.white);
        } else {
            g2d.drawString(text, x, y);
        }

        //Back to Title
        text = "Quit";
        x = getXForCenteredText(text, g);
        y += 50;

        if (selectionNum == 2) {
            g2d.setFont(Assets.secondary.deriveFont(Font.PLAIN, 48));
            g2d.setColor(Color.red);
            x = getXForCenteredText(text, g);
            g2d.drawString(text, x, y);
            g2d.drawString(selectionLeft, x2 - 150, y);
            g2d.drawString(selectionRight, x3 + 150, y);

            g2d.setFont(Assets.secondary.deriveFont(Font.PLAIN, 45));
            g2d.setColor(Color.white);
        } else {
            g2d.drawString(text, x, y);
        }

    }

    public void drawGameOverScreen(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //g2d.setColor(new Color(0, 0, 0, 0.50f));
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);

        int x, x2, x3, y;
        String text, selectionLeft, selectionRight;

        g2d.setFont(Assets.primary.deriveFont(Font.PLAIN, 110f));

        selectionLeft = ">";
        selectionRight = "<";
        text = "YOU DIED";
        g2d.setColor(Color.red.darker());
        x = getXForCenteredText(text, g);
        y = 270;
        g2d.drawString(text, x, y);

        g2d.setColor(Color.white);
        g2d.drawString(text, x - 5, y - 5);

        g2d.setFont(Assets.secondary.deriveFont(Font.PLAIN, 48));
        x2 = getXForCenteredText(selectionLeft, g);
        x3 = getXForCenteredText(selectionRight, g);
        
        //Retry
        g2d.setFont(Assets.secondary.deriveFont(Font.PLAIN, 45));
        text = "Retry";
        x = getXForCenteredText(text, g);
        y = 500;

        if (selectionNum == 0) {
            g2d.setFont(Assets.secondary.deriveFont(Font.PLAIN, 48));
            g2d.setColor(Color.red);
            x = getXForCenteredText(text, g);
            g2d.drawString(text, x, y);
            g2d.drawString(selectionLeft, x2 - 150, y);
            g2d.drawString(selectionRight, x3 + 150, y);


            g2d.setFont(Assets.secondary.deriveFont(Font.PLAIN, 45));
            g2d.setColor(Color.white);
        } else {
            g2d.drawString(text, x, y);
        }

        //Back to Title
        text = "Quit";
        x = getXForCenteredText(text, g);
        y += 50;

        if (selectionNum == 1) {
            g2d.setFont(Assets.secondary.deriveFont(Font.PLAIN, 48));
            g2d.setColor(Color.red);
            x = getXForCenteredText(text, g);
            g2d.drawString(text, x, y);
            g2d.drawString(selectionLeft, x2 - 150, y);
            g2d.drawString(selectionRight, x3 + 150, y);


            g2d.setFont(Assets.secondary.deriveFont(Font.PLAIN, 45));
            g2d.setColor(Color.white);
        } else {
            g2d.drawString(text, x, y);
        }

    }

    public void drawTitleScreen(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        String selectionLeft, selectionRight;
        int x2, x3;
        selectionLeft = ">";
        selectionRight = "<";
        
        g2d.setFont(Assets.secondary.deriveFont(Font.PLAIN, 48));
        x2 = getXForCenteredText(selectionLeft, g);
        x3 = getXForCenteredText(selectionRight, g);

        if (titleScreenState == 0) {
            //TITLE
            g2d.setFont(Assets.primary);
            g2d.setFont(g2d.getFont().deriveFont(Font.PLAIN, 76));
            String text = "Outbreak Escape";
            int x = getXForCenteredText(text, g);
            int y = 270;

            //g2d.setColor(Color.red);
            //g2d.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);
            //TITLE BACKGROUND
            g2d.drawImage(Assets.titleBG, 0, 0, null);

            //TITLE NAME
            g2d.setColor(Color.black);
            g2d.drawString(text, x + 5, y + 5);
            g2d.setColor(Color.white);
            g2d.drawString(text, x, y);

            //LOGO
            x = Window.WIDTH / 2;
            y = 140;
            g2d.drawImage(Assets.logo, x - Assets.logo.getWidth() / 2, y - Assets.logo.getHeight() / 2, null);

            //MENU
            g2d.setFont(Assets.secondary);
            g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 48));

            text = "NEW GAME";
            x = getXForCenteredText(text, g);
            y = 400;

            if (selectionNum == 0) {
                g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 52));
                x = getXForCenteredText(text, g);
                g2d.setColor(Color.red);
                g2d.drawString(text, x, y);
                g2d.drawString(selectionLeft, x2 - 200, y);
                g2d.drawString(selectionRight, x3 + 200, y);

                g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 48));
                g2d.setColor(Color.white);
            } else {
                g2d.drawString(text, x, y);
            }

            text = "CREDITS";
            x = getXForCenteredText(text, g);
            y += 52;

            if (selectionNum == 1) {
                g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 52));
                x = getXForCenteredText(text, g);
                g2d.setColor(Color.red);
                g2d.drawString(text, x, y);
                g2d.drawString(selectionLeft, x2 - 220, y);
                g2d.drawString(selectionRight, x3 + 220, y);

                g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 48));
                g2d.setColor(Color.white);
            } else {
                g2d.drawString(text, x, y);
            }
            
            text = "HOW TO PLAY";
            x = getXForCenteredText(text, g);
            y += 52;

            if (selectionNum == 2) {
                g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 52));
                x = getXForCenteredText(text, g);
                g2d.setColor(Color.red);
                g2d.drawString(text, x, y);
                g2d.drawString(selectionLeft, x2 - 220, y);
                g2d.drawString(selectionRight, x3 + 220, y);

                g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 48));
                g2d.setColor(Color.white);
            } else {
                g2d.drawString(text, x, y);
            }

            text = "QUIT";
            x = getXForCenteredText(text, g);
            y += 52;

            if (selectionNum == 3) {
                g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 52));
                x = getXForCenteredText(text, g);
                g2d.setColor(Color.red);
                g2d.drawString(text, x, y);
                g2d.drawString(selectionLeft, x2 - 220, y);
                g2d.drawString(selectionRight, x3 + 220, y);
                
                g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 48));
                g2d.setColor(Color.white);
            } else {
                g2d.drawString(text, x, y);
            }
        } else if (titleScreenState == 1) {
            //TITLE
            g2d.setFont(Assets.primary);
            g2d.setFont(g2d.getFont().deriveFont(Font.PLAIN, 76));
            String text = "Outbreak Escape";
            int x = getXForCenteredText(text, g);
            int y = 270;

            //g2d.setColor(Color.red);
            //g2d.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);
            //TITLE BACKGROUND
            g2d.drawImage(Assets.titleBG, 0, 0, null);

            //TITLE NAME
            g2d.setColor(Color.black);
            g2d.drawString(text, x + 5, y + 5);
            g2d.setColor(Color.white);
            g2d.drawString(text, x, y);

            //LOGO
            x = Window.WIDTH / 2;
            y = 140;
            g2d.drawImage(Assets.logo, x - Assets.logo.getWidth() / 2, y - Assets.logo.getHeight() / 2, null);

            //HOW TO PLAY
            g2d.setFont(Assets.secondary);
            g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 48));

            text = "!ENDLESS MODE!";
            x = getXForCenteredText(text, g);
            y = 380;
            g2d.drawString(text, x, y);

            g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 45));

            text = "CONTROLS";
            x = getXForCenteredText(text, g);
            y += 50;
            g2d.drawString(text, x, y);

            g2d.setFont(g2d.getFont().deriveFont(Font.PLAIN, 40));

            text = "WASD - Walk";
            x = getXForCenteredText(text, g);
            y += 50;
            g2d.drawString(text, x, y);

            text = "Mouse - Aim";
            x = getXForCenteredText(text, g);
            y += 50;
            g2d.drawString(text, x, y);

            text = "Left Click - Shoot";
            x = getXForCenteredText(text, g);
            y += 50;
            g2d.drawString(text, x, y);

            text = "1 and 2 - Switch Guns";
            x = getXForCenteredText(text, g);
            y += 50;
            g2d.drawString(text, x, y);

            text = "R - Reload";
            x = getXForCenteredText(text, g);
            y += 50;
            g2d.drawString(text, x, y);

        } else if (titleScreenState == 2) {
            //TITLE
            g2d.setFont(Assets.primary);
            g2d.setFont(g2d.getFont().deriveFont(Font.PLAIN, 76));
            String text = "Outbreak Escape";
            int x = getXForCenteredText(text, g);
            int y = 270;

            //g2d.setColor(Color.red);
            //g2d.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);
            //TITLE BACKGROUND
            g2d.drawImage(Assets.titleBG, 0, 0, null);

            //TITLE NAME
            g2d.setColor(Color.black);
            g2d.drawString(text, x + 5, y + 5);
            g2d.setColor(Color.white);
            g2d.drawString(text, x, y);

            //LOGO
            x = Window.WIDTH / 2;
            y = 140;
            g2d.drawImage(Assets.logo, x - Assets.logo.getWidth() / 2, y - Assets.logo.getHeight() / 2, null);

            //CREDITS
            g2d.setFont(Assets.secondary);
            g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 48));

            text = "CREDITS";
            x = getXForCenteredText(text, g);
            y = 380;
            g2d.drawString(text, x, y);

            g2d.setFont(g2d.getFont().deriveFont(Font.PLAIN, 40));

            text = "Pellerin, John Joseph - Programming";
            x = getXForCenteredText(text, g);
            y += 80;
            g2d.drawString(text, x, y);

            text = "David, Jaysan - Art";
            x = getXForCenteredText(text, g);
            y += 50;
            g2d.drawString(text, x, y);

            text = "Jinayon, Reynier - Story";
            x = getXForCenteredText(text, g);
            y += 50;
            g2d.drawString(text, x, y);

            text = "Dela Pena, Jaye Melle - Music";
            x = getXForCenteredText(text, g);
            y += 50;
            g2d.drawString(text, x, y);

            text = "Madrona, Sherwin - Voiceovers";
            x = getXForCenteredText(text, g);
            y += 50;
            g2d.drawString(text, x, y);

        } else if (titleScreenState == 3) {
            //TITLE
            g2d.setFont(Assets.primary);
            g2d.setFont(g2d.getFont().deriveFont(Font.PLAIN, 76));
            String text = "Outbreak Escape";
            int x = getXForCenteredText(text, g);
            int y = 270;

            //g2d.setColor(Color.red);
            //g2d.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);
            //TITLE BACKGROUND
            g2d.drawImage(Assets.titleBG, 0, 0, null);

            //TITLE NAME
            g2d.setColor(Color.black);
            g2d.drawString(text, x + 5, y + 5);
            g2d.setColor(Color.white);
            g2d.drawString(text, x, y);

            //LOGO
            x = Window.WIDTH / 2;
            y = 140;
            g2d.drawImage(Assets.logo, x - Assets.logo.getWidth() / 2, y - Assets.logo.getHeight() / 2, null);

            //HOW TO PLAY
            g2d.setFont(Assets.secondary);
            g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 48));

            text = "CONTROLS";
            x = getXForCenteredText(text, g);
            y = 380;
            g2d.drawString(text, x, y);

            g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 45));

            text = "";
            x = getXForCenteredText(text, g);
            y += 50;
            g2d.drawString(text, x, y);

            g2d.setFont(g2d.getFont().deriveFont(Font.PLAIN, 40));

            text = "WASD - Walk";
            x = getXForCenteredText(text, g);
            y += 50;
            g2d.drawString(text, x, y);

            text = "Mouse - Aim";
            x = getXForCenteredText(text, g);
            y += 50;
            g2d.drawString(text, x, y);

            text = "Left Click - Shoot";
            x = getXForCenteredText(text, g);
            y += 50;
            g2d.drawString(text, x, y);

            text = "1 and 2 - Switch Guns";
            x = getXForCenteredText(text, g);
            y += 50;
            g2d.drawString(text, x, y);

            text = "R - Reload";
            x = getXForCenteredText(text, g);
            y += 50;
            g2d.drawString(text, x, y);
        }

    }

    public int getXForCenteredText(String text, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int length = (int) g2d.getFontMetrics().getStringBounds(text, g2d).getWidth();
        int x = Window.WIDTH / 2 - length / 2;
        return x;
    }
}
