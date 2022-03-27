package state;

import java.awt.Graphics2D;

import Entities.EntityManager;
import Entities.Ship;
import Entities.Tubby;
import map.BackGround;
import map.HUB;

public abstract class Level {

	protected HUB hub;
	protected EntityManager entityManager;
	protected Ship ship;
	protected Tubby player;
	
	protected StateManager stateManager;

	protected BackGround background;

	public abstract void init();

	public abstract void tick();

	public abstract void draw(Graphics2D g);
	
	public abstract void playTrack();

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public Tubby getPlayer() {
		return player;
	}

	public void setPlayer(Tubby player) {
		this.player = player;
	}

	public StateManager getStateManager() {
		return stateManager;
	}

	public void setStateManager(StateManager stateManager) {
		this.stateManager = stateManager;
	}

	public BackGround getBackground() {
		return background;
	}

	public void setBackground(BackGround background) {
		this.background = background;
	}

	
}
