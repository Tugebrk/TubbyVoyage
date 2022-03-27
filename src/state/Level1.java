package state;

import java.awt.Graphics2D;

import Entities.Cookie;
import Entities.Enemy;
import Entities.EntityManager;

import Entities.Platform;
import Entities.Ship;
import Entities.Trap;
import Entities.Tubby;
import Main.Assets;
import audio.MusicBox;
import map.BackGround;
import map.HUB;

public class Level1 extends Level {

	public Level1(StateManager stateManager) {

		this.stateManager = stateManager;

		init();

	}

	@Override
	public void init() {

		this.entityManager = new EntityManager();

		ship = new Ship(1, 3820, 350, 300, 250, stateManager);
		player = new Tubby("purple", 0, 310, 125, 150, entityManager);

		entityManager.setPlayer(player);
		entityManager.setShip(ship);

		this.background = new BackGround(Assets.night2, 1);
		this.background.setVector(0, 0);

//		y=300

		entityManager.add(new Platform(1950, 300, Assets.grassyN));
		entityManager.add(new Platform(2100, 300, Assets.grassyN));

//		y=450

		entityManager.add(new Platform(600, 450, Assets.grassyN));
		entityManager.add(new Platform(1650, 450, Assets.grassyN));

//		y=600

		entityManager.add(new Platform(0, 600, Assets.grassyN));
		entityManager.add(new Platform(450, 600, Assets.grassyN));
		entityManager.add(new Platform(600, 600, Assets.dirtN));
		entityManager.add(new Platform(1200, 600, Assets.grassyN));
		entityManager.add(new Platform(2700, 600, Assets.grassyN));
		entityManager.add(new Platform(2850, 600, Assets.grassyN));
		entityManager.add(new Platform(3300, 600, Assets.grassyN));
		entityManager.add(new Platform(3450, 600, Assets.grassyN));

//		y = 750

		entityManager.add(new Platform(0, 750, Assets.dirtN));
		entityManager.add(new Platform(150, 750, Assets.grassyN));
		entityManager.add(new Platform(300, 750, Assets.grassyN));
		entityManager.add(new Platform(450, 750, Assets.dirtN));
		entityManager.add(new Platform(600, 750, Assets.dirtN));
		entityManager.add(new Platform(900, 750, Assets.dirtN));
		entityManager.add(new Platform(1050, 750, Assets.dirtN));
		entityManager.add(new Platform(1200, 750, Assets.dirtN));
		entityManager.add(new Platform(1350, 750, Assets.grassyN));
		entityManager.add(new Platform(1500, 750, Assets.grassyN));
		entityManager.add(new Platform(1650, 750, Assets.dirtN));
		entityManager.add(new Platform(1800, 750, Assets.grassyN));
		entityManager.add(new Platform(1950, 750, Assets.grassyN));
		entityManager.add(new Platform(2400, 750, Assets.grassyN));
		entityManager.add(new Platform(2550, 750, Assets.dirtN));
		entityManager.add(new Platform(2700, 750, Assets.dirtN));
		entityManager.add(new Platform(2850, 750, Assets.dirtN));
		entityManager.add(new Platform(3000, 750, Assets.dirtN));
		entityManager.add(new Platform(3300, 750, Assets.dirtN));
		entityManager.add(new Platform(3450, 750, Assets.dirtN));

//		Traps

		entityManager.add(new Trap(900, 600, 150, 150, Assets.trap1));
		entityManager.add(new Trap(2400, 600, 150, 150, Assets.trap1));
		entityManager.add(new Trap(3000, 600, 150, 150, Assets.trap1));

//		Collectibles

		entityManager.add(new Cookie(1075, 625, entityManager));
		entityManager.add(new Cookie(1975, 625, entityManager));
		entityManager.add(new Cookie(2575, 625, entityManager));

//		Monsters

		entityManager.add(new Enemy("night", 1350, 600, 600, 0, entityManager));

		this.hub = new HUB(entityManager);

	}

	@Override
	public void tick() {
		entityManager.tick();
		hub.tick();
		background.tick();

	}

	@Override
	public void draw(Graphics2D g) {

		background.draw(g);
		entityManager.draw(g);
		hub.draw(g);
	}

	@Override
	public void playTrack() {

		MusicBox.setFilePath("Assets/Audio/level1.wav");

	}

}
