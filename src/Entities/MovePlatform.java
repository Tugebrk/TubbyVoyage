package Entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class MovePlatform extends Entity {

	private final int dx;
	private final int dy;
	private int speed;
	private double intx;
	private double inty;
	private double xend;
	private double yend;

	public MovePlatform(double x, double y, int dx, int dy, BufferedImage image) {
		super(x, y, 200, 50);

		this.dx = dx;
		this.dy = dy;
		intx = x;
		inty = y;
		xend = x + dx;
		yend = y + dy;
		speed = 5;
		this.moving = true;
		this.activePortrait = image;

	}

	@Override
	public void tick() {

		move();

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	public boolean isSolid() {

		return true;

	}

	@Override
	public void draw(Graphics2D g) {

		g.drawImage(activePortrait, (int) x, (int) y, (int) WIDTH, (int) HEIGHT, null);

	}

	public void set(double x, boolean moving) {
		if (moving) {
			this.intx = x;
			this.boundaries.x = (int) this.x;

			this.xend = this.intx + dx;
		}
	}

	@Override
	public void setX(double x) {

		this.x = x;
		this.boundaries.x = (int) x;

	}

	@Override
	public void setY(double y) {
		this.boundaries.y = (int) y;
		this.y = y;
		this.inty = y;
		this.yend = y - dy;
	}

	public void move() {

		if (dx != 0) {

			x += speed;

			this.boundaries.x = (int) x;
		}
		if (dy != 0) {

			y += speed;
			this.boundaries.y = (int) y;
		}
		if (dx != 0 && x >= xend) {

			speed = -speed;
		}

		else if (dx != 0 && x <= intx) {

			speed = -speed;
		}

		if (dy != 0 && y >= yend)

			speed = -speed;

		else if (dy != 0 && y <= inty)

			speed = -speed;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
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

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

}
