package Entities;

import java.awt.Graphics2D;

import Main.Assets;

public class Cookie extends Entity {

	private EntityManager entityManager;

	public Cookie(double x, double y, EntityManager entityManager) {
		super(x, y, 100, 100);
		this.entityManager = entityManager;
		this.activePortrait = Assets.cookie;
	}

	@Override
	public void tick() {

		if (this.boundaries.intersects(entityManager.getPlayer().boundaries)) {

			entityManager.getPlayer().setCollectedCookies(entityManager.getPlayer().getCollectedCookies() + 1);
			
			entityManager.getPlayer().collectEmAll();
			
			entityManager.getEntities().remove(this);
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
	
	public boolean isSolid(){
		
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

}
