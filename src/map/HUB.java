package map;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Entities.EntityManager;
import Main.Assets;

public class HUB {

	private int healthStatus;
	private int collectedCookie;
	private int totalCookie;
	EntityManager entityManager;
	Color color;
	Font font;

	public HUB(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.healthStatus = entityManager.getPlayer().getHealth();
		this.totalCookie = entityManager.getCookieCount();
		color = new Color(128, 0, 0);
		font = new Font("Arial", Font.BOLD, 24);

	}

	public void tick() {

		this.healthStatus = entityManager.getPlayer().getHealth();
		this.collectedCookie = entityManager.getPlayer().getCollectedCookies();
	}

	public void draw(Graphics2D g) {

		g.drawImage(Assets.health, 10, 10, 80, 70, null);
		g.setColor(color);
		g.setFont(font);
		g.drawString("X " + Integer.toString(healthStatus), 100, 50);
		g.drawImage(Assets.cookie, 180, 10, 80, 70, null);
		g.drawString(Integer.toString(collectedCookie) + " / " + Integer.toString(totalCookie), 280, 50);

	}
}
