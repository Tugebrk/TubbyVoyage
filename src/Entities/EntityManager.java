package Entities;

import java.awt.Graphics2D;

import java.util.ArrayList;

import state.StateManager;

public class EntityManager {

	private ArrayList<Entity> entities;

	private Tubby player;
	private Ship ship;
	private int cookieCount = 0;

	public EntityManager() {
		entities = new ArrayList<Entity>();
	}

	public void add(Entity e) {
		entities.add(e);
		if (e instanceof Cookie) {
			cookieCount++;
		}
	}

	public void init() {

		for (Entity e : entities)
			e.init();
	}

	public void remove(Entity e) {
		entities.remove(e);
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void draw(Graphics2D g) {

		for (Entity e : entities)
			e.draw(g);

		player.draw(g);
		ship.draw(g);
	}

	public void checkAllCollected() {

		if (player.getCollectedCookies() == cookieCount)
			ship.openDoor();

	}

	public void tick() {

		ship.setImage();

		if (player.getBoundaries().intersects(ship.getBoundaries())) {

			ship.tick();
		}

		checkForHurt();

		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).tick();
		}

		camera();

		player.tick();

		checkForFall();

		checkAllCollected();
	}

	public void checkForHurt() {
		for (Entity t : entities)
			if (t instanceof Trap || t instanceof Enemy) {

				if (player.boundaries.intersects(t.boundaries)) {
					player.health--;
					player.setHurt(true);
					checkForDeath();
					player.jumpStrength = -30;
				}

			}

	}

	public void checkForDeath() {

		if (player.health <= 0 || player.y >= 900) {

			StateManager.setState(StateManager.getDeadstate());
		}
	}

	public void camera() {

		if (player.getX() <= 500) {
			player.setX(player.getX() + player.getSpeed());
		}

		else {
			for (Entity e : entities) {
				if (e.isMoving()) {
					((MovePlatform) e).setIntx(((MovePlatform) e).getIntx() - player.getSpeed());
					((MovePlatform) e).setX(((MovePlatform) e).getX() - player.getSpeed());
					((MovePlatform) e).setXend(((MovePlatform) e).getXend() - player.getSpeed());
				}

				else if (e instanceof Enemy) {
					((Enemy) e).setIntx(((Enemy) e).getIntx() - player.getSpeed());
					((Enemy) e).setX(((Enemy) e).getX() - player.getSpeed());
					((Enemy) e).setXend(((Enemy) e).getXend() - player.getSpeed());
				} else
					e.set(e.getX() - player.getSpeed(), player.isMoving());

			}

		}

		ship.setX(ship.getX() - player.getSpeed());

	}

	public void setPlayer(Tubby player) {
		this.player = player;
	}

	public Tubby getPlayer() {
		return player;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public int getCookieCount() {
		return cookieCount;
	}

	public void setCookieCount(int cookieCount) {
		this.cookieCount = cookieCount;
	}

	public void checkForFall() {

		if (player.y >= 900)
			StateManager.setState(StateManager.getDeadstate());

	}

}
