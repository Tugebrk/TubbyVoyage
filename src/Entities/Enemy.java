package Entities;

import java.awt.Graphics2D;

import Main.Assets;

public class Enemy extends Creature {

	EntityManager entityManager;

	private int dx;
	private int dy;
	private double xend;
	private double yend;
	private double intx;
	private double inty;
	private int speed;
	private String type;

	public Enemy(String enemyType, double x, double y, int dx, int dy, EntityManager entityManager) {
		super(x, y, 150, 150);
		this.entityManager = entityManager;
		this.activePortrait = Assets.enemy1l;
		this.dx = dx;
		this.dy = dy;
		this.intx = x;
		this.inty = y;
		this.xend = x + dx;
		this.yend = y + dy;
		this.type = enemyType;
		speed = 3;
		choosePortraitArray();
	}

	@Override
	public void tick() {

		move();
		setPortrait();
		
		if (this.boundaries.intersects(entityManager.getPlayer().boundaries)) {

			entityManager.getPlayer().setHealth(entityManager.getPlayer().getHealth() - 1);
		}
	}

	@Override
	public void init() {
		

	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(activePortrait, (int) x, (int) y, (int) WIDTH, (int) HEIGHT, null);

	}

	@Override
	public void move() {
		if (dx != 0) {

			x += speed;
			this.boundaries.x = (int) x;
		}
		if (dy != 0) {

			y += speed;
			this.boundaries.y = (int) y;
		}
		if (x >= xend)

			speed = -speed;

		else if (x <= intx)

			speed = -speed;

	}

	public void choosePortraitArray() {

		if (type.equals("night")) {

			portrait[0] = Assets.enemy2r;
			portrait[1] = Assets.enemy2l;

		}
		
		else if (type.equals("snow")) {

			portrait[0] = Assets.enemy1r;
			portrait[1] = Assets.enemy1l;

		}
		
		else if (type.equals("desert")) {

			portrait[0] = Assets.enemy3r;
			portrait[1] = Assets.enemy3l;

		}

	}

	public void setPortrait() {

		if (Integer.signum(speed) == 1) {
			activePortrait = portrait[0];

		} else
			activePortrait = portrait[1];

	}

	public boolean isSolid() {

		return false;

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

	public double getXend() {
		return xend;
	}

	public void setXend(double xend) {
		this.xend = xend;
	}

	public double getYend() {
		return yend;
	}

	public void setYend(double yend) {
		this.yend = yend;
	}

	public double getIntx() {
		return intx;
	}

	public void setIntx(double intx) {
		this.intx = intx;
	}

	public double getInty() {
		return inty;
	}

	public void setInty(double inty) {
		this.inty = inty;
	}

}
