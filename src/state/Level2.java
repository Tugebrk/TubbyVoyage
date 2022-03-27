package state;

import java.awt.Graphics2D;

import Entities.Cookie;
import Entities.Enemy;
import Entities.EntityManager;
import Entities.MovePlatform;
import Entities.Platform;
import Entities.Ship;
import Entities.Trap;
import Entities.Tubby;
import Main.Assets;
import audio.MusicBox;
import map.BackGround;
import map.HUB;

public class Level2 extends Level {

	public Level2(StateManager stateManager) {

		this.stateManager = stateManager;
		
		init();

	}

	@Override
	public void init() {

		this.entityManager = new EntityManager();
		
		ship = new Ship(2, 3800, 200, 300, 250, stateManager);
		player = new Tubby("red", 0, 300, 120, 140, entityManager);
		
		entityManager.setPlayer(player);
		entityManager.setShip(ship);
		
		this.background = new BackGround(Assets.snow2, 0);
		this.background.setVector(0, 0);

//		y=300
		
		entityManager.add(new Platform(1050,300,Assets.snowyice));
		entityManager.add(new Platform(1200,300,Assets.ice));
		entityManager.add(new Platform(2250,300,Assets.snowyice));
		entityManager.add(new Platform(2400,300,Assets.ice));
		
//		y=450
		
		entityManager.add(new Platform(900,450,Assets.snowyice));
//		entityManager.add(new Platform(2550,Assets.snowyice));
		entityManager.add(new Platform(3300,450,Assets.snowyice));
		entityManager.add(new Platform(3450,450,Assets.snowyice));
		
//		y=600
		
		entityManager.add(new Platform(150,600,Assets.snowyice));
		entityManager.add(new Platform(750,600,Assets.snowyice));
//		entityManager.add(new Platform(1500,600,Assets.snowyice));
		entityManager.add(new Platform(2400,600,Assets.snowyice));
		entityManager.add(new Platform(2850,600,Assets.snowyice));
		entityManager.add(new Platform(3150,600,Assets.snowyice));
		entityManager.add(new Platform(3300,600,Assets.ice));
		entityManager.add(new Platform(3450,600,Assets.ice));
		
//		y=750
		
		entityManager.add(new Platform(0,750,Assets.snowyice));
		entityManager.add(new Platform(150,750,Assets.ice));
		entityManager.add(new Platform(300,750,Assets.ice));
		entityManager.add(new Platform(450,750,Assets.ice));
		entityManager.add(new Platform(600,750,Assets.ice));
		entityManager.add(new Platform(750,750,Assets.ice));
		entityManager.add(new Platform(900,750,Assets.snowyice));
		entityManager.add(new Platform(1050,750,Assets.snowyice));
		entityManager.add(new Platform(1200,750,Assets.snowyice));
		entityManager.add(new Platform(1500,750,Assets.ice));
		entityManager.add(new Platform(1650,750,Assets.snowyice));
		entityManager.add(new Platform(1800,750,Assets.ice));
		entityManager.add(new Platform(2100,750,Assets.snowyice));
		entityManager.add(new Platform(2250,750,Assets.ice));
		entityManager.add(new Platform(2400,750,Assets.snowyice));
		entityManager.add(new Platform(2550,750,Assets.snowyice));
		entityManager.add(new Platform(2700,750,Assets.snowyice));
		entityManager.add(new Platform(2850,750,Assets.ice));
		entityManager.add(new Platform(3000,750,Assets.ice));
		entityManager.add(new Platform(3150,750,Assets.ice));
		entityManager.add(new Platform(3300,750,Assets.ice));
		entityManager.add(new Platform(3450,750,Assets.ice));
		
//		Traps
		
		entityManager.add(new Trap(1200,250, 150, 50, Assets.icespikeup));
		entityManager.add(new Trap(1200,450, 150, 50,Assets.icespikedown));
		entityManager.add(new Trap(1800,600, 150, 150,Assets.icetrap));
		entityManager.add(new Trap(2400,250, 150, 50,Assets.icespikeup));
		entityManager.add(new Trap(3000,600, 150, 150,Assets.icetrap));
		
//		Collectibles
		
		entityManager.add(new Cookie(925, 625, entityManager));
		entityManager.add(new Cookie(2125, 625, entityManager));
		entityManager.add(new Cookie(2275, 175, entityManager));
		
//		Monsters
		
		entityManager.add(new Enemy("snow", 300,600,300,0,entityManager));
		
//		MovingPlatform
		
		entityManager.add(new MovePlatform(1400, 200, 600, 0, Assets.snowyice));
		
		hub = new HUB(entityManager);
	}

	@Override
	public void tick() {
		
		entityManager.tick();
		background.tick();
		hub.tick();
	}

	@Override
	public void draw(Graphics2D g) {

		background.draw(g);
		entityManager.draw(g);
		hub.draw(g);
	}

	@Override
	public void playTrack() {
		MusicBox.setFilePath("Assets/Audio/level2.wav");
		
	}

}
