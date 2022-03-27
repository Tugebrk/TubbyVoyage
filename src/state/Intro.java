package state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import Main.Assets;
import audio.MusicBox;
import map.BackGround;

public class Intro extends Level {

	private int index1 = 0;
	private int index2 = 0;
	private int index3 = 0;
	private int index4 = 0;
	private String text1 = "";
	private String text2 = "";
	private String text3 = "";
	private String text4 = "";
	private String line1 = "AFTER AN UNEXPECTED COMPLICATION, TUBBIES FOUND THEMSELVES SCATTERED AROUND THE SYSTEM. ";
	private String line2 = "DIPSY CAUGHT WITH GLIMPSE OF AN EYE THAT HE AND TINK-WINKY ARE FALLING TO THE SAME PLANET,";
	private String line3 = "HOPEFULLY NOT TO THEIR END. AFTER THE CRASH AND PRAYING TO THE SUN BABY THAT HE IS ALIVE, ";
	private String line4 = "DIPSY BEGAN HIS SEARCH FOR HIS FELLOW FALLEN TUBBY, TINKY-WINKY.";

	private BufferedImage shipImg = Assets.shipload3;
	private int count = 0;
	private int fontSize = 24;
	private int ssX = 1600;
	private int ssY = 0;
	private int yRadian = 0;
	private int rRadian = 0;
	private int pRadian = 0;
	private int shipx = 400;
	private int shipy = 200;
	private int shakec = 0;
	private int smokeC = 0;
	private int safeTime = 80;
	private int hitTime = 240;
	private int fadeTime = 500;
	private int endTime = 1500;
	private int shakemag = 50;
	private double shipRadian = 0;
	private double blackx = 800;
	private double blacky = 450;
	private double blackw = 0;
	private double blackh = 0;
	private double rx = 750;
	private double ry = 300;
	private double yx = 750;
	private double yy = 300;
	private double px = 750;
	private double py = 300;
	private double meteorx = 0;
	private double meteory = 0;
	private double radPlus = 5;
	private double meteorScale = 0;
	private double rTubbyScale = 0;
	private double yTubbyScale = 0;
	private double pTubbyScale = 0;

	private BufferedImage[] smokeAnim = new BufferedImage[] { Assets.smoke1, Assets.smoke2, Assets.smoke3 };

	private AffineTransform atMeteor = AffineTransform.getTranslateInstance(meteorx, meteory);
	private AffineTransform atShip = AffineTransform.getTranslateInstance(shipx, shipy);
	private AffineTransform atRed = AffineTransform.getTranslateInstance(rx, ry);
	private AffineTransform atYellow = AffineTransform.getTranslateInstance(yx, yy);
	private AffineTransform atPurple = AffineTransform.getTranslateInstance(px, py);

	public Intro(StateManager stateManager) {

		this.background = new BackGround(Assets.space, 1);
		background.setVector(-60, 0);
		background.setLocation(0, 0);
		this.stateManager = stateManager;
	}

	@Override
	public void init() {

	}

	@Override
	public void tick() {
		
		text1 = typeWriter1(line1, text1);
		text2 = typeWriter2(line2, text2);
		text3 = typeWriter3(line3, text3);
		text4 = typeWriter4(line4, text4);

		set();

		atMeteor.scale(meteorScale, meteorScale);
		atRed.scale(rTubbyScale, rTubbyScale);
		atYellow.scale(yTubbyScale, yTubbyScale);
		atPurple.scale(pTubbyScale, pTubbyScale);

		background.tick();
		impact();

		count++;
		if (count == endTime) {
			count = 0;
			StateManager.nextLevel();
		}
	}

	@Override
	public void draw(Graphics2D g) {

		background.draw(g);

		g.drawImage(shipImg, atShip, null);

		if (count <= hitTime + 50 && count >= safeTime) {

			meteorScale += 0.005;

		} else if (count > hitTime + 50) {
			meteory += 4;
			meteorx += 4;
			meteorScale += 0.005;
		}

		g.drawImage(Assets.meteor, atMeteor, null);

		smoke(g);

		g.drawImage(Assets.redTubbyR, atRed, null);
		g.drawImage(Assets.yellowTubbyR, atYellow, null);
		g.drawImage(Assets.purpleTubbyR, atPurple, null);
		warning(g);
		black(g);
	}

	public void set() {

		atMeteor = AffineTransform.getTranslateInstance(meteorx, meteory);
		atShip = AffineTransform.getTranslateInstance(shipx, shipy);
		atRed = AffineTransform.getTranslateInstance(rx, ry);
		atYellow = AffineTransform.getTranslateInstance(yx, yy);
		atPurple = AffineTransform.getTranslateInstance(px, py);

	}

	public void black2(Graphics2D g) {

		if (count >= fadeTime) {
			g.fillRect((int) blackx, 0, 1620, 900);
			g.setColor(Color.black);
			if (blackx >= 0)
				blackx -= 16;
			else if (blackx < 0)
				blackx = 0;

		}
	}

	public void black(Graphics2D g) {

		if (count >= fadeTime) {
			g.fillRect((int) blackx, (int) blacky, (int) blackw, (int) blackh);
			g.setColor(Color.black);
			blackw += 32;
			blackh += 16;
			blackx -= 16;
			blacky -= 8;
		}

		if (count == 600)
			crawl();
		if (count >= 600) {

			g.setFont(new Font("News Gothic MT", Font.BOLD, fontSize));
			g.setColor(Color.yellow);
			if (fontSize < 25)
				fontSize++;
			g.drawString(text1, 100, 200);
			g.drawString(text2, 100, 300);
			g.drawString(text3, 100, 400);
			g.drawString(text4, 100, 500);

			g.setColor(Color.black);

		}

		if (count >= 1350) {
			g.drawImage(Assets.slideScreen0, ssX, ssY, null);
			ssX -= 15;
			if (ssX <= 0)
				ssX = 0;

		}

	}

	public void smoke(Graphics2D g) {

		if (count >= hitTime) {

			g.drawImage(smokeAnim[smokeC], (int) atShip.getShearX() + 150, (int) atShip.getShearY() - 50,
					smokeAnim[smokeC].getWidth(), smokeAnim[smokeC].getHeight(), null);

			if (count % 10 == 0)
				smokeC++;

			if (smokeC == 3)
				smokeC = 0;
		}
	}

	public void warning(Graphics2D g) {

		if (count > safeTime && count <= hitTime && count % 50 <= 25) {

			g.drawImage(Assets.warning, 1150, 150, 300, 300, null);

		}
	}

	public void tubbyEject() {

		rRadian -= radPlus;

		yRadian += radPlus;

		pRadian += radPlus;

		rTubbyScale += 0.005;
		yTubbyScale += 0.005;
		pTubbyScale += 0.001;

		rx -= 3.9;
		ry -= 4;
		yx -= 2.5;
		yy += 2.5;
		px += 4.0;
		py += 0.4;

		atRed.rotate(Math.toRadians(rRadian), Assets.redTubbyR.getWidth() / 2, Assets.redTubbyR.getHeight() / 2);
		atYellow.rotate(Math.toRadians(yRadian), Assets.yellowTubbyR.getWidth() / 2,
				Assets.yellowTubbyR.getHeight() / 2);
		atPurple.rotate(Math.toRadians(pRadian), Assets.purpleTubbyR.getWidth() / 2,
				Assets.purpleTubbyR.getHeight() / 2);
	}

	public void impact() {

		if (count == 160) {
			rTubbyScale = 0.3;
			yTubbyScale = 0.3;
			pTubbyScale = 0.2;
		}
		if (count >= 160) {

			this.shipImg = Assets.shipFirstHit;

			atShip.rotate(Math.toRadians(shipRadian), shipImg.getWidth() / 2, shipImg.getHeight() / 2);

			shipRadian += 3;

			tubbyEject();

			shipRadian += 0.005;

			if (shakec == 0) {

				shipx += shakemag;
				shipy -= shakemag;

			}

			else if (shakec == 3) {
				shipx -= shakemag;
				shipy += shakemag;
				shakec = -1;

			}

			shakec++;
		}
	}

	@Override
	public void playTrack() {
		// TODO Auto-generated method stub

	}

	public void crawl() {

		MusicBox.setFilePath("Assets/Audio/crawl.wav");


	}

	public String typeWriter1(String fullText, String text) {

		if (count >= 600 && count % 2 == 0 && index1 < fullText.length()) {
			text += fullText.charAt(index1);

			index1 = index1 + 1;

		}

		return text;

	}

	public String typeWriter2(String fullText, String text) {

		if (count >= 725 && count % 2 == 0 && index2 < fullText.length()) {
			text += fullText.charAt(index2);

			index2 = index2 + 1;

		}

		return text;

	}

	public String typeWriter3(String fullText, String text) {

		if (count >= 850 && count % 2 == 0 && index3 < fullText.length()) {
			text += fullText.charAt(index3);

			index3 = index3 + 1;

		}

		return text;

	}

	public String typeWriter4(String fullText, String text) {

		if (count >= 975 && count % 2 == 0 && index4 < fullText.length()) {
			text += fullText.charAt(index4);

			index4 = index4 + 1;

		}

		return text;

	}

}
