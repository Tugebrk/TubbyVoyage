package Entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Main.Assets;
import Main.KeyManager;

public class AnimatedTubby extends Creature {

	private double acceleration;
	private String type;
	private boolean skipping;
	private boolean moving = false;
	private int groundLevel = 600;
	private BufferedImage activeHurtPortrait;
	private BufferedImage[] hurtPortrait = new BufferedImage[2];
	private BufferedImage portraitToDraw;

	public AnimatedTubby(String type, double x, double y, int width, int height) {
		super(x, y, width, height);

		this.type = type;

		setColor(type);

		activePortrait = portrait[0];
		portraitToDraw = activePortrait;

		acceleration = 0.5;
		speed = 0;
		jumpStrength = 0;
		weight = 1.0;

	}

	@Override
	public void tick() {

		jump();
		skip();

	}

	@Override
	public void init() {

	}

	public void jump() {

		if (KeyManager.up) {

			if (x == groundLevel) {
				jumpStrength = 40;
			}
			y -= jumpStrength;
			jumpStrength -= weight;
		}

	}

	@Override
	public void draw(Graphics2D g) {

		g.drawImage(activePortrait, (int) this.x, (int) this.y, (int) WIDTH, (int) HEIGHT, null);

	}

	public void move(String direction) {

		switch (direction) {

		case "stop":
			moving = false;
			deAccelerate();
			descend();
			break;

		case "right":

			skip();
			moving = true;
			activePortrait = portrait[0];
			activeHurtPortrait = hurtPortrait[0];
			speed++;
			break;

		case "left":

			moving = true;
			skip();
			activePortrait = portrait[1];
			activeHurtPortrait = hurtPortrait[1];
			speed--;

		}

//		Speed Limit

		if (speed < -6)
			speed = -6;
		if (speed > 6)
			speed = 6;

//		Makes the move
		

		x += speed;

	}

	public void skip() {

		if (y == groundLevel) {
			jumpStrength = 20;
		}
		y -= jumpStrength;
		
		jumpStrength -= weight;

	}
	
	public void descend() {
		
		if (y == groundLevel) {
			return;
		}
		y -= jumpStrength;
		
		jumpStrength -= weight;
		
	}

	public void accelerate() {

		speed /= acceleration;

	}

	public void deAccelerate() {

		speed *= acceleration;

	}

	public void setColor(String color) {

		if (color.equals("red")) {

			this.portrait[0] = Assets.redTubbyR;
			this.portrait[1] = Assets.redTubbyL;
			this.hurtPortrait[0] = Assets.redHurtR;
			this.hurtPortrait[1] = Assets.redHurtL;

		} else if (color.equals("purple")) {

			this.portrait[0] = Assets.purpleTubbyR;
			this.portrait[1] = Assets.purpleTubbyL;
			this.hurtPortrait[0] = Assets.purpleHurtR;
			this.hurtPortrait[1] = Assets.purpleHurtL;

		} else if (color.equals("yellow")) {

			this.portrait[0] = Assets.yellowTubbyR;
			this.portrait[1] = Assets.yellowTubbyL;
			this.hurtPortrait[0] = Assets.yellowHurtR;
			this.hurtPortrait[1] = Assets.yellowHurtL;

		} else if (color.equals("green")) {

			this.portrait[0] = Assets.greenTubbyR;
			this.portrait[1] = Assets.greenTubbyL;
			this.hurtPortrait[0] = Assets.greenHurtR;
			this.hurtPortrait[1] = Assets.greenHurtL;
		}

		else if (color.equals("yellowHijab")) {

			this.portrait[0] = Assets.yellowHijabR;
			this.portrait[1] = Assets.yellowHijabL;
			this.hurtPortrait[0] = Assets.yellowHijabHurtR;
			this.hurtPortrait[1] = Assets.yellowHijabHurtL;
		}
	}

	public double getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isSkipping() {
		return skipping;
	}

	public void setSkipping(boolean skipping) {
		this.skipping = skipping;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public BufferedImage getActiveHurtPortrait() {
		return activeHurtPortrait;
	}

	public void setActiveHurtPortrait(BufferedImage activeHurtPortrait) {
		this.activeHurtPortrait = activeHurtPortrait;
	}

	public BufferedImage[] getHurtPortrait() {
		return hurtPortrait;
	}

	public void setHurtPortrait(BufferedImage[] hurtPortrait) {
		this.hurtPortrait = hurtPortrait;
	}

	public BufferedImage getPortraitToDraw() {
		return portraitToDraw;
	}

	public void setPortraitToDraw(BufferedImage portraitToDraw) {
		this.portraitToDraw = portraitToDraw;
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(double x) {
		this.x = x;

	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setY(double y) {
		this.y = y;

	}

	@Override
	public void set(double x, boolean t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

}
