package Entities;

import java.awt.image.BufferedImage;

public abstract class Creature extends Entity {

	protected int health;
	protected double speed;
	protected double jumpStrength;
	protected double weight;
	protected boolean dx;
	protected boolean dy;
	protected BufferedImage[] portrait;
	
	public Creature(double x, double y, int width, int height) {
		super(x, y, width, height);
		portrait = new BufferedImage[2];
	}

	
	public abstract void move();


	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public double getSpeed() {
		return speed;
	}


	public void setSpeed(double speed) {
		this.speed = speed;
	}


	public double getJumpStrength() {
		return jumpStrength;
	}


	public void setJumpStrength(double jumpStrength) {
		this.jumpStrength = jumpStrength;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public boolean isDx() {
		return dx;
	}


	public void setDx(boolean dx) {
		this.dx = dx;
	}


	public boolean isDy() {
		return dy;
	}


	public void setDy(boolean dy) {
		this.dy = dy;
	}


	public BufferedImage[] getPortrait() {
		return portrait;
	}


	public void setPortrait(BufferedImage[] portrait) {
		this.portrait = portrait;
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
