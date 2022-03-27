package state;

import java.awt.Graphics2D;

import Entities.Cookie;
import Entities.Enemy;
import Entities.EntityManager;
import Entities.Health;
import Entities.MovePlatform;
import Entities.Platform;
import Entities.Ship;
import Entities.Trap;
import Entities.Tubby;
import Main.Assets;
import audio.MusicBox;
import map.BackGround;
import map.HUB;

public class Level3 extends Level {

	public Level3(StateManager stateManager) {

		this.stateManager = stateManager;
		init();

	}

	@Override
	public void init() {

		this.entityManager = new EntityManager();

		ship = new Ship(3, 4150, 350, 350, 250, stateManager);
		player = new Tubby("yellowHijab", 100, 300, 120, 140, entityManager);

		entityManager.setPlayer(player);
		entityManager.setShip(ship);

		this.background = new BackGround(Assets.desert, 0);
		this.background.setVector(0, 0);
		

//		y=150

		entityManager.add(new Platform(900, 150, Assets.sandstone));

//		y=300

		entityManager.add(new Platform(1650, 300, Assets.sandstone));
		entityManager.add(new Platform(2400, 300, Assets.sandstone));

//		y=450

		entityManager.add(new Platform(1500, 450, Assets.sandstone));
		entityManager.add(new Platform(2250, 450, Assets.sandstone));

//		y=600

		entityManager.add(new Platform(300, 600, Assets.sandstone));
		entityManager.add(new Platform(1350, 600, Assets.sandstone));
		entityManager.add(new Platform(2850, 600, Assets.sandstone));
		entityManager.add(new Platform(3750, 600, Assets.sandstone));
		entityManager.add(new Platform(3900, 600, Assets.sandstone));

//		y=750

		entityManager.add(new Platform(0, 750, Assets.sandstone));
		entityManager.add(new Platform(150, 750, Assets.sandstone));
		entityManager.add(new Platform(300, 750, Assets.sand));

		entityManager.add(new Platform(900, 750, Assets.sandstone));
		entityManager.add(new Platform(1050, 750, Assets.sand));
		entityManager.add(new Platform(1200, 750, Assets.sandstone));
		entityManager.add(new Platform(1350, 750, Assets.sand));
		entityManager.add(new Platform(1500, 750, Assets.sandstone));
		entityManager.add(new Platform(1650, 750, Assets.sandstone));
		entityManager.add(new Platform(1800, 750, Assets.sandstone));
		entityManager.add(new Platform(1950, 750, Assets.sand));
		entityManager.add(new Platform(2100, 750, Assets.sandstone));
		entityManager.add(new Platform(2250, 750, Assets.sandstone));
		entityManager.add(new Platform(2400, 750, Assets.sandstone));
		entityManager.add(new Platform(2550, 750, Assets.sandstone));
		entityManager.add(new Platform(2700, 750, Assets.sand));
		entityManager.add(new Platform(2850, 750, Assets.sand));

		entityManager.add(new Platform(3750, 750, Assets.sand));
		entityManager.add(new Platform(3900, 750, Assets.sand));

//		Traps

		entityManager.add(new Trap(1070, 600, 125, 150, Assets.cactustrap));
		entityManager.add(new Trap(1970, 600, 125, 150, Assets.cactustrap));
		entityManager.add(new Trap(2720, 600, 125, 150, Assets.cactustrap));

//		Collectibles

		entityManager.add(new Cookie(925, 625, entityManager));
		entityManager.add(new Cookie(1525, 625, entityManager));
		entityManager.add(new Cookie(2575, 625, entityManager));
		entityManager.add(new Cookie(925, 25, entityManager));
		
		entityManager.add(new Health(1225, 625, entityManager));

//		Monsters

		entityManager.add(new Enemy("desert", 2100, 600, 450, 0, entityManager));

//		MovingPlatform

		MovePlatform move1 = new MovePlatform(750, 300, 0, 100, Assets.sandstone);
		move1.setSpeed(2);
		move1.setWIDTH(125);

		MovePlatform move2 = new MovePlatform(475, 450, 140, 0, Assets.sandstone);
		move2.setSpeed(3);
		move2.setWIDTH(115);
		
		MovePlatform move3 = new MovePlatform(3050, 450, 300, 0, Assets.sandstone);
		move3.setSpeed(3);
		move3.setWIDTH(100);
		
		entityManager.add(move1);
		entityManager.add(move2);
		entityManager.add(move3);

		hub = new HUB(entityManager);
	}

	@Override
	public void tick() {

//		System.out.println(entityManager.getEntities().get(entityManager.getEntities().size() -2));
		
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
		MusicBox.setFilePath("Assets/Audio/level3.wav");
		
	}

}
