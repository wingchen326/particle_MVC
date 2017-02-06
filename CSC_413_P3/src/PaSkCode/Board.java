package PaSkCode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private final int DELAY = 20;

    private int bdWidth = 400;
    private int bdHeight = 300;
    private int radius = 10;

    private int px;
    private int py;

    private int velX;
    private int velY;

    private int frame;
    private int logCycle;

    PSysModel pSystem; // Particle system model
    PSysView pSysView; // Particle system view

    public Board(int bw, int bh, ArrayList <String> pl) {

        initBoard(bw, bh, pl);
    }
    
    private void initBoard(int bw, int bh,
			   ArrayList <String> pl) {
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);

	bdWidth = bw;
	bdHeight = bh;
	px = bdWidth/2;
	py = bdHeight/2;
	frame = 0;

	setupPS(pl);
        timer = new Timer(DELAY, this);
        timer.start();        
    }

    @Override
	public void actionPerformed(ActionEvent e) {

	if (frame % 30 == 0)
	    System.out.println("Frame: " + frame);
	frame++;
	// all simulation state change code should be wrapped here
	if (frame == logCycle) {
	    pSysView.dump(pSystem, logCycle);
	    // This block replaced by pSysView.dump()
	    /*
	    System.out.println("Frame " + logCycle);
	    System.out.println(radius + " " + px + " " + py + " " + velX + " " + velY);
	    */
	}
	update();
        repaint();  
    }

    @Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g);

	// all drawing code should be wrapped here
        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void update() {
	pSystem.update(bdWidth, bdHeight);

	// This block replaced by pSystem.update()
	/*
	px += velX;
	py += velY;

	if (px >= bdWidth-radius && velX > 0) {
	    velX = -velX;
	}
	else if (px < radius && velX < 0) {
	    velX = -velX;
	}

	if (py >= bdHeight-radius && velY > 0) {
	    velY = -velY;
	}
	else if (py < radius && velY < 0) {
	    velY = -velY;
	}
	*/
	
    }

    private void doDrawing(Graphics g) {
	pSysView.draw(pSystem, g);

	// This block replaced by pSysView()
	/*
        Graphics2D g2d = (Graphics2D) g;
	//	g2d.setRenderingHints(
	//	    new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
	//			       RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
	g2d.setColor(Color.RED);
	g2d.fillOval(px-radius, py-radius, radius*2, radius*2);
	*/
    }

    private class TAdapter extends KeyAdapter {

        @Override
	    public void keyReleased(KeyEvent e) {
            //when key is released, run this code
        }

        @Override
	    public void keyPressed(KeyEvent e) {
            //when key is pressed, run this code.
	    radius *= 2;
        }
    }

    void setupPS(ArrayList <String> pl) {
	logCycle = Integer.parseInt(pl.get(0));
	System.out.println("Log: " + logCycle);

	pSystem = new PSysModel();

	for (int i=1; i<pl.size(); i++) {
	    String [] tokens = pl.get(i).split(" ");
	    if (tokens.length != 5) {
		System.out.println("Illegal file format; exit");
		break;
	    }
	    int rad = (int) (Double.parseDouble(tokens[0]) * bdWidth);
	    int npx = (int) (Double.parseDouble(tokens[1]) * bdWidth);
	    int npy = (int) (Double.parseDouble(tokens[2]) * bdHeight);
	    int nvx = (int) (Double.parseDouble(tokens[3]) * bdWidth);
	    int nvy = (int) (Double.parseDouble(tokens[4]) * bdHeight);
	    pSystem.add(rad, npx, npy, nvx, nvy);

	    pSysView = new PSysView();

	    // This block has been replaced by pSystem.add()
	    /*
	    if (i==1) {
		radius = rad;
		px = npx;
		py = npy;
		velX = nvx;
		velY = nvy;
	    }
	    System.out.println("Added: " + rad + " " + px + " " + py);
	    */
	}

    }

}
