package Entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Entity {

	protected boolean moving = false;
	protected double x;
	protected double y;
	protected double WIDTH;
	protected double HEIGHT;
	protected boolean isSolid = true;
	
	protected BufferedImage activePortrait;

	Rectangle boundaries;

	public Entity(double x, double y, int width, int height) {

		this.x = x;
		this.y = y;
		this.HEIGHT = height;
		this.WIDTH = width;

		boundaries = new Rectangle((int) x, (int) y, width, height);

	}

	public abstract double getX();

	

	public abstract void setX(double x); 

	public abstract void set(double x, boolean t);

	public abstract double getY();

	public abstract void setY(double y); 

	

	public double getWIDTH() {

		return WIDTH;
	}

	public void setWIDTH(double WIDTH) {
		this.boundaries.width = (int) WIDTH;
		this.WIDTH = WIDTH;
	}

	public double getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(double hEIGHT) {
		this.boundaries.height = (int) hEIGHT;
		HEIGHT = hEIGHT;
	}

	public Rectangle getBoundaries() {
		return boundaries;
	}

	public abstract void tick();

	public abstract void init();

	public abstract void draw(Graphics2D g);

	public boolean isSolid() {

		return isSolid;

	}
	
	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}

	public BufferedImage getActivePortrait() {
		return activePortrait;
	}

	public void setActivePortrait(BufferedImage activePortrait) {
		this.activePortrait = activePortrait;
	}

	public void setBoundaries(Rectangle boundaries) {
		this.boundaries = boundaries;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

}
