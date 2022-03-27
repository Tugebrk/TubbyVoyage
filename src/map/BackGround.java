package map;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


import Main.GamePanel;

public class BackGround {

	private double x;
	private double y;
	private double WIDTH;
	private double HEIGHT;
	private double moveScale;
	private double dx;
	private double dy;
	private double diff;
	private BufferedImage bg;

	public BackGround(BufferedImage image, double moveScale) {
		this.moveScale = moveScale;
		this.bg = image;
		this.WIDTH = bg.getWidth();
		this.HEIGHT = bg.getHeight();
		this.diff = this.WIDTH - GamePanel.WIDTH;
		
	}

	public void setLocation(double x, double y) {

		this.x = (x * moveScale) % GamePanel.WIDTH;
		this.y = (y * moveScale) % GamePanel.HEIGHT;
		;

	}

	public void setVector(double dx, double dy) {

		this.dx = dx;
		this.dy = dy;

	}

	public void tick() {

		x += dx;
		y += dy;

	}

	public void draw(Graphics2D g) {
		g.drawImage(bg, (int) x, (int) y, null);
		if (x <= -diff) {
			x = GamePanel.WIDTH;
		} else if (x > -diff) {
			g.drawImage(bg, (int) x - GamePanel.WIDTH, (int) y, null);
		}
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(double wIDTH) {
		WIDTH = wIDTH;
	}

	public double getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(double hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public double getMoveScale() {
		return moveScale;
	}

	public void setMoveScale(double moveScale) {
		this.moveScale = moveScale;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public double getDiff() {
		return diff;
	}

	public void setDiff(double diff) {
		this.diff = diff;
	}

	public BufferedImage getBg() {
		return bg;
	}

	public void setBg(BufferedImage bg) {
		this.bg = bg;
	}
	
	
}
