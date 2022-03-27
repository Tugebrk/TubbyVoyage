package state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import audio.MusicBox;

public class Level0Load extends Level {

	private int count = 0;
	private int endTime = 600;
	private BufferedImage slideScreen;
	private int ssX = 1600;
	private int ssY = 0;
	private int index1 = 0;
	private int index2 = 0;
	private int index3 = 0;
	private int index4 = 0;
	private String text1 = "";
	private String text2 = "";
	private String text3 = "";
	private String text4 = "";
	private String line1 = "After Dipsy found Tink-Winky and filled his tummy,";
	private String line2 = "Tinky-Winky nursed backed to health quickly.";
	private String line3 = "Tinky-Winky wasted no time to fix the ship";
	private String line4 = "so they can go on an adventure and unite the tubbies.";

	public Level0Load(BufferedImage slideScreen, StateManager stateManager) {
		this.stateManager = stateManager;
		this.slideScreen = slideScreen;
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

		if (count == endTime)
			StateManager.nextLevel();
		else
			count++;

		if (count == 420)
			MusicBox.stop();
	}

	@Override
	public void draw(Graphics2D g) {

		g.setColor(new Color(0, 0, 0, 0.01f));

		g.fillRect(0, 0, 1600, 900);
		
		g.setFont(new Font("Vagabond", Font.BOLD, 50));
		g.setColor(Color.YELLOW);
		g.drawString(text1, 100, 250);
		g.drawString(text2, 100, 350);
		g.drawString(text3, 100, 450);
		g.drawString(text4, 100, 550);

		if (count >= 475 && this.slideScreen != null) {
			g.drawImage(this.slideScreen, ssX, ssY, null);
			ssX -= 15;
			if (ssX <= 0)
				ssX = 0;

		}

	}

	@Override
	public void playTrack() {

		MusicBox.setFilePath("Assets/Audio/type.wav");

	}

	public String typeWriter1(String fullText, String text) {

		if (count % 2 == 0 && index1 < fullText.length()) {
			text += fullText.charAt(index1);

			index1 = index1 + 1;

		}

		return text;

	}

	public String typeWriter2(String fullText, String text) {

		if (count >= 125 && count % 2 == 0 && index2 < fullText.length()) {
			text += fullText.charAt(index2);

			index2 = index2 + 1;

		}

		return text;

	}

	public String typeWriter3(String fullText, String text) {

		if (count >= 225 && count % 2 == 0 && index3 < fullText.length()) {
			text += fullText.charAt(index3);

			index3 = index3 + 1;

		}

		return text;

	}

	public String typeWriter4(String fullText, String text) {

		if (count >= 300 && count % 2 == 0 && index4 < fullText.length()) {
			text += fullText.charAt(index4);

			index4 = index4 + 1;

		}

		return text;

	}

}
