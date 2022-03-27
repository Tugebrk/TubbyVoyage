package state;

import java.awt.Color;
import java.awt.Font;

import java.awt.Graphics2D;

import Entities.AnimatedTubby;
import Main.Assets;
import Main.KeyManager;
import audio.MusicBox;

public class Outro extends Level {

	private boolean animationPhase = true;
	private int count = 0;
	private float r = 0.999f;
	private float g = 0.37f;
	private float b = 0.33f;
	private float alpha = 0.0f;
	private Color color = new Color(r, g, b, alpha);
	AnimatedTubby purple = new AnimatedTubby("purple", -100, 600, 150, 180);
	AnimatedTubby yellow = new AnimatedTubby("yellow", 1700, 600, 160, 175);
	AnimatedTubby green = new AnimatedTubby("green", -200, 600, 150, 180);
	AnimatedTubby red = new AnimatedTubby("red", 1700, 600, 150, 170);

	@Override
	public void init() {

	}

	@Override
	public void tick() {


		if (count <= 90 && purple.getX() <= 500) {
			purple.skip();
			purple.move("right");
		} else
			purple.move("stop");

		if (count >= 75 && yellow.getX() >= 1010) {

			yellow.skip();
			yellow.move("left");

		} else {
			yellow.move("stop");

		}

		if (count >= 200 && green.getX() <= 550) {
			green.skip();
			green.move("right");

		} else {
			green.move("stop");

		}

		if (count >= 400 && red.getX() >= 900) {
			red.skip();
			red.move("left");

		} else {
			red.move("stop");

		}

		count++;

	}

	@Override
	public void draw(Graphics2D g) {

		if (animationPhase) {

			g.drawImage(Assets.endingPlain, 0, -40, 1600, 900, null);

			red.draw(g);
			green.draw(g);
			yellow.draw(g);
			purple.draw(g);

			g.setColor(color);

			g.fillRect(0, 0, 1600, 900);

			alpha += 0.001f;

			if (alpha >= 1.0f) {
				alpha = 1.0f;
			}

			dimLight();

			color = new Color(r, this.g, b, alpha);

			if (count == 1192) {
				animationPhase = false;
				MusicBox.setFilePath("Assets/Audio/lp2.wav");

			}
		} else
			lastPage(g);

	}

	public void dimLight() {

		r -= 0.001f;

		if (r <= 0.0f)
			r = 0.0f;

		g -= 0.0004f;

		if (g <= 0.0f)
			g = 0.0f;

		b -= 0.0004f;

		if (b <= 0.0f)
			b = 0.0f;

	}

	public void lastPage(Graphics2D g) {

		if (animationPhase == false) {

			alpha -= 0.004f;

			if (alpha <= 0.0f) {
				alpha = 0.0f;
			}

			color = new Color(r, this.g, b, alpha);

			g.drawImage(Assets.endingFinal, 0, -39, 1600, 900, null);

			g.setColor(color);

			if (count <= 1500)

				g.fillRect(0, 0, 1600, 900);

			else {

				g.setFont(new Font("Vagabond", Font.ITALIC, 32));

				if (count >= 1500 && count <= 1800) {

					alpha += 0.01f;

					if (alpha >= 1.0f)
						alpha = 1.0f;

					color = new Color(r, this.g, b, alpha);

					g.setColor(color);

					g.drawString("TUÐBERK YILMAZ", 400, 100);

					g.drawString("MEHMET ALÝ EREL", 400, 200);

					g.drawString("BARIÞ SÝNAPLI", 400, 300);

				} else if (count >= 1600 && count <= 1700) {

					alpha -= 0.01f;

					if (alpha <= 0.0f) {
						alpha = 0.0f;
					}
					color = new Color(r, this.g, b, alpha);

					g.setColor(color);

					g.drawString("TUÐBERK YILMAZ", 400, 100);

					g.drawString("MEHMET ALÝ EREL", 400, 200);

					g.drawString("BARIÞ SÝNAPLI", 400, 300);
				}

				else if (count >= 1900 && count <= 1999) {

					alpha += 0.05f;

					if (alpha >= 1.0f) {
						alpha = 1.0f;

					}
					color = new Color(r, this.g, b, alpha);
					g.setColor(color);
					g.fillRect(0, 0, 1600, 900);

				}

				else if (count >= 2000) {

					g.setColor(Color.BLACK);
					g.fillRect(0, 0, 1600, 900);
					g.setColor(Color.WHITE);
					g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 512));
					g.drawString("FIN", 300, 600);

				}

				if (count == 2100)
					KeyManager.esc = true;

			}
		}
	}

	@Override
	public void playTrack() {

		MusicBox.setFilePath("Assets/Audio/credits.wav");

	}

}
