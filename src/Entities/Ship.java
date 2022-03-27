package Entities;


import java.awt.Graphics2D;

import java.awt.image.BufferedImage;

import Main.Assets;

import state.StateManager;

public class Ship extends Entity {

	private boolean doorOpen;
	private StateManager stateManager;
	private int level;
	private BufferedImage image[] = new BufferedImage[2];

	public Ship(int level, double x, double y, int width, int height, StateManager stateManager) {
		super(x, y, width, height);
		this.stateManager = stateManager;
		doorOpen = false;

		this.level = level;
		chooseImage();
		setImage();

	}

	@Override
	public void tick() {

		if (doorOpen) {

			stateManager.getStates().get(stateManager.getCurrentState()).getEntityManager().getPlayer()
					.setActivePortrait(Assets.cookie);
			stateManager.getStates().get(stateManager.getCurrentState()).getEntityManager().remove(
					stateManager.getStates().get(stateManager.getCurrentState()).getEntityManager().getPlayer());
			StateManager.nextLevel();
		}

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(activePortrait, (int) x, (int) y, (int) WIDTH, (int) HEIGHT, null);

	}

	public void chooseImage() {

		if (this.level == 0) {
			this.image[0] = Assets.purpleDamaged;
			this.image[1] = Assets.purpleFine;

		}

		if (this.level == 1) {
			this.image[0] = Assets.shipdamaged1;
			this.image[1] = Assets.shipfine1;
		}
		if (this.level == 2) {
			this.image[0] = Assets.shipdamaged2;
			this.image[1] = Assets.shipfine2;
		}
		if (this.level == 3) {
			this.image[0] = Assets.shipdamaged3;
			this.image[1] = Assets.shipfine3;
		}
	}

	public void setImage() {

		if (doorOpen)
			this.activePortrait = image[1];
		else
			this.activePortrait = image[0];

	}

	public void openDoor() {

		this.doorOpen = true;

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
