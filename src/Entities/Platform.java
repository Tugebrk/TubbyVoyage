package Entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Platform extends Entity {

	public Platform(double x, double y, BufferedImage portrait) {
		super(x, y, 150, 150);
		this.activePortrait = portrait;
	}

	@Override
	public void tick() {
		

	}

	@Override
	public void init() {
		

	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(activePortrait,(int)x, (int)y, (int)WIDTH, (int)HEIGHT, null);

	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(double x) {
		this.boundaries.x = (int) x;
		this.x = x;
		
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setY(double y) {
		this.y = y;
		
	}

	@Override
	public void set(double x, boolean t) {
		this.boundaries.x = (int) x;
		this.x = x;
		
	}

}
