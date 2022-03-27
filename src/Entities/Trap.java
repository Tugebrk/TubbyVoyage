package Entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Trap extends Platform {



	public Trap(double x, double y, int WIDTH, int HEIGHT, BufferedImage portrait) {
		super(x, y, portrait);

		setHEIGHT(HEIGHT);
		setWIDTH(WIDTH);
		boundaries.height = HEIGHT;
		boundaries.width = WIDTH;
		
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(activePortrait, (int) x, (int) y, (int) WIDTH, (int) HEIGHT, null);

	}

	public boolean isSolid(){
		
		return false;
		
	}
	
}
