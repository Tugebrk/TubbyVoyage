package state;

import java.awt.Graphics2D;

import Entities.Cookie;
import Entities.Enemy;
import Entities.EntityManager;
import Entities.Health;
import Entities.Platform;
import Entities.Ship;
import Entities.Trap;
import Entities.Tubby;
import Main.Assets;
import audio.MusicBox;
import map.BackGround;
import map.HUB;

public class Level0 extends Level {

	public Level0(StateManager stateManager) {

		this.stateManager = stateManager;

		init();

	}

	@Override
	public void init() {

		this.entityManager = new EntityManager();

		ship = new Ship(0, 3900, 150, 130, 150, stateManager);
		player = new Tubby("green", 0, 300, 125, 140, entityManager);

		entityManager.setPlayer(player);
		entityManager.setShip(ship);

		this.background = new BackGround(Assets.morning, 1);
		this.background.setVector(0, 0);

//		y=300

		entityManager.add(new Platform(1050, 300, Assets.dirt));
		entityManager.add(new Platform(1200, 300, Assets.dirt));
		entityManager.add(new Platform(1350, 300, Assets.dirt));
		entityManager.add(new Platform(2250, 300, Assets.dirt));
		entityManager.add(new Platform(3300, 300, Assets.dirt));
		entityManager.add(new Platform(3450, 300, Assets.dirt));

//		y=450

		entityManager.add(new Platform(2650, 450, Assets.dirt));

//		y=600

		entityManager.add(new Platform(0, 600, Assets.grassydirt));
		entityManager.add(new Platform(150, 600, Assets.grassydirt));
		entityManager.add(new Platform(750, 600, Assets.grassydirt));
		entityManager.add(new Platform(1650, 600, Assets.grassydirt));
		entityManager.add(new Platform(1950, 600, Assets.grassydirt));
		entityManager.add(new Platform(3150, 600, Assets.grassydirt));

//		y = 750

		entityManager.add(new Platform(0, 750, Assets.dirt));
		entityManager.add(new Platform(150, 750, Assets.dirt));
		entityManager.add(new Platform(600, 750, Assets.dirt));
		entityManager.add(new Platform(1650, 750, Assets.dirt));
		entityManager.add(new Platform(1950, 750, Assets.dirt));
		entityManager.add(new Platform(3000, 750, Assets.dirt));
		entityManager.add(new Platform(3150, 750, Assets.dirt));

		entityManager.add(new Platform(300, 750, Assets.grassydirt));
		entityManager.add(new Platform(1050, 750, Assets.grassydirt));

		entityManager.add(new Platform(1200, 750, Assets.grassydirt));
		entityManager.add(new Platform(2250, 750, Assets.grassydirt));
		entityManager.add(new Platform(2400, 750, Assets.grassydirt));
		entityManager.add(new Platform(2850, 750, Assets.grassydirt));

//		Traps

		entityManager.add(new Trap(600, 600, 150, 150, Assets.trap1));
		entityManager.add(new Trap(3000, 600, 150, 150, Assets.trap1));

//		Collectibles

		entityManager.add(new Cookie(325, 625, entityManager));
		entityManager.add(new Cookie(1225, 175, entityManager));
		entityManager.add(new Cookie(1225, 625, entityManager));
		entityManager.add(new Cookie(2150, 625, entityManager));

		entityManager.add(new Health(2275, 175, entityManager));

//		Monsters

		entityManager.add(new Enemy("night", 1050, 150, 300, 0, entityManager));

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

		MusicBox.setFilePath("Assets/Audio/level0.wav");

	}

}
