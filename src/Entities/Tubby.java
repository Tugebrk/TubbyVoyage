package Entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Main.Assets;
import Main.KeyManager;

public class Tubby extends Creature {

	private int hurtCount = 0;
	private int collectedCookies;
	private boolean hurt;
	private boolean readyToGo;
	private double acceleration;
	private String type;
	private boolean skipping;
	private boolean moving = false;
	private boolean atGround = true;
	private EntityManager entityManager;
	private BufferedImage activeHurtPortrait;
	private BufferedImage[] hurtPortrait = new BufferedImage[2];
	private BufferedImage portraitToDraw;

	public Tubby(String type, double x, double y, int width, int height, EntityManager entityManager) {
		super(x, y, width, height);

		this.entityManager = entityManager;
		readyToGo = false;
		collectedCookies = 0;
		this.type = type;

		setColor(type);

		activePortrait = portrait[0];
		portraitToDraw = activePortrait;

		hurt = false;
		health = 3;
		acceleration = 0.92;
		speed = 0;
		jumpStrength = 0;
		weight = 2.5;

	}

	@Override
	public void tick() {

		move();
		jump();
		skip();
		gravity();
		hurt();
		collectEmAll();

	}

	@Override
	public void init() {

	}

	public void jump() {

		if (KeyManager.up) {
			checkIfGround();
			if (atGround) {
				jumpStrength = -40;
			}

		}

	}

	public void hurtDodge() {

		checkIfGround();
		if (atGround) {
			jumpStrength = -40;

		}

	}

	@Override
	public void draw(Graphics2D g) {

		g.drawImage(portraitToDraw, (int) this.x, (int) this.y, (int) WIDTH, (int) HEIGHT, null);

	}

	@Override
	public void move() {

		if (KeyManager.left && KeyManager.right || !KeyManager.left && !KeyManager.right) {
			moving = false;
			deAccelerate();
		}

		else if (KeyManager.left) {
			moving = true;
			activePortrait = portrait[1];
			activeHurtPortrait = hurtPortrait[1];
			speed--;
		} else if (KeyManager.right) {
			moving = true;
			activePortrait = portrait[0];
			activeHurtPortrait = hurtPortrait[0];
			speed++;
		}

//		Speed Limit

		if (speed < -15)
			speed = -15;
		if (speed > 15)
			speed = 15;

//		Makes the move

		checkCollision();

		y += jumpStrength;

		boundaries.y = (int) y;
		boundaries.x = (int) x;

	}

	public void gravity() {

		jumpStrength += weight;

	}

	public void skip() {

		if (moving && KeyManager.up)
			jump();

		else if (moving) {
			checkIfGround();
			if (atGround) {
				jumpStrength = -20;
			}

		}

	}

	public void collectEmAll() {

		if (collectedCookies == 3)
			readyToGo = true;
		else
			readyToGo = false;
	}

	public boolean isAtGround() {
		return atGround;
	}

	public void setAtGround(boolean atGround) {
		this.atGround = atGround;
	}

	public void checkIfGround() {

		boundaries.y++;
		for (Entity e : entityManager.getEntities()) {
			if (e.boundaries.intersects(boundaries)) {
				atGround = true;
				break;
			} else {
				atGround = false;

			}
		}
		boundaries.y--;
	}

	public void checkCollision() {

//		Horizontal Collision Check

		boundaries.x += speed;

		for (Entity e : entityManager.getEntities()) {

			if (boundaries.intersects((e.boundaries)) && e.isSolid()) {

				boundaries.x -= speed;
				while (!e.boundaries.intersects(boundaries))
					boundaries.x += Math.signum(speed);
				boundaries.x -= Math.signum(speed);
				speed = 0;
				x = boundaries.x;

			}

		}

//		Vertical Collision Check

		boundaries.y += jumpStrength;

		for (Entity e : entityManager.getEntities()) {
			if (boundaries.intersects((e.boundaries)) && e.isSolid()) {

				boundaries.y -= jumpStrength;
				while (!e.boundaries.intersects(boundaries))
					boundaries.y += Math.signum(jumpStrength);
				boundaries.y -= Math.signum(jumpStrength);
				jumpStrength = 0;
				y = boundaries.y;

			}

		}

	}

	public void hurt() {

		portraitToDraw = activePortrait;

		if (hurt) {

			hurtCount++;

			if (hurtCount <= 20)
				portraitToDraw = activeHurtPortrait;

			else if (hurtCount <= 50) {
				portraitToDraw = activePortrait;
				hurtCount = 0;
				hurt = false;
			} else if (hurtCount <= 40)
				portraitToDraw = activeHurtPortrait;

			else if (hurtCount <= 30)
				portraitToDraw = activePortrait;
		}
	}

	public void accelerate() {

		speed /= acceleration;

	}

	public void deAccelerate() {

		speed *= acceleration;

	}

	public void setColor(String color) {
		if (color.equals("red")) {

			this.portrait[0] = Assets.redScarfR;
			this.portrait[1] = Assets.redScarfL;
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

	public int getCollectedCookies() {
		return collectedCookies;
	}

	public void setCollectedCookies(int collectedCookies) {
		this.collectedCookies = collectedCookies;
	}

	public boolean isReadyToGo() {
		return readyToGo;
	}

	public void setReadyToGo(boolean readyToGo) {
		this.readyToGo = readyToGo;
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

	public int getHurtCount() {
		return hurtCount;
	}

	public void setHurtCount(int hurtCount) {
		this.hurtCount = hurtCount;
	}

	public boolean isHurt() {
		return hurt;
	}

	public void setHurt(boolean hurt) {
		this.hurt = hurt;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void set(double x, boolean t) {
		// TODO Auto-generated method stub

	}

}
