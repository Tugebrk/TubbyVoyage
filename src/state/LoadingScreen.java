package state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Main.Assets;
import audio.MusicBox;
import map.BackGround;

public class LoadingScreen extends Level {

	private int index1 = 0;
	private int index2 = 0;


	private int count = 0;
	private int endTime = 600;
	private BufferedImage slideScreen;
	private BufferedImage shipImage;
	private int ssX = 1600;
	private int ssY = 0;
	private float alpha = 0.0f;
	private Color color = new Color(0, 0, 0, alpha);
	private String text1 = "";
	private String text2 = "";

	private String line1 = "Once again all tubbies were together with a loaded tummy.";
	private String line2 = "Sure was the tubby toasts are pretty, pretty yummy.";

	public LoadingScreen(BufferedImage shipImage, BufferedImage slideScreen, StateManager stateManager) {

		this.background = new BackGround(Assets.space, 0);
		background.setVector(-80, 0);
		background.setLocation(0, 0);
		this.stateManager = stateManager;
		this.shipImage = shipImage;
		this.slideScreen = slideScreen;
	}

	@Override
	public void init() {

	}

	@Override
	public void tick() {

		text1 = typeWriter1(line1, text1);
		text2 = typeWriter2(line2, text2);

		background.tick();
		if (count == endTime)
			StateManager.nextLevel();
		else
			count++;

	}

	@Override
	public void draw(Graphics2D g) {

		g.clearRect(0, 0, 1600, 900);
		background.draw(g);
		g.drawImage(shipImage, 400, 200, 661, 491, null);

		if (count >= 475 && this.slideScreen != null) {
			g.drawImage(this.slideScreen, ssX, ssY, null);
			ssX -= 15;
			if (ssX <= 0)
				ssX = 0;

		}

		if (this.slideScreen == null && count >= 500) {

			this.endTime = 850;

			g.setColor(color);

			g.fillRect(0, 0, 1600, 900);

			alpha += 0.0105f;

			if (alpha >= 1.0f) {
				alpha = 1.0f;
			}

			color = new Color(0, 0, 0, alpha);

			g.drawString(text1, 100, 200);
			g.drawString(text2, 100, 300);

			g.setColor(Color.yellow);

			g.setFont(new Font("Vagabond", Font.BOLD, 50));
			g.drawString(text1, 100, 400);
			g.drawString(text2, 100, 500);

		}

	}

	@Override
	public void playTrack() {
		MusicBox.setFilePath("Assets/Audio/elevator.wav");

	}

	public String typeWriter1(String fullText, String text) {

		if (count >= 550 && count % 2 == 0 && index1 < fullText.length()) {
			text += fullText.charAt(index1);

			index1 = index1 + 1;

		}

		return text;

	}

	public String typeWriter2(String fullText, String text) {

		if (count >= 650 && count % 2 == 0 && index2 < fullText.length()) {
			text += fullText.charAt(index2);

			index2 = index2 + 1;

		}

		return text;

	}

}
