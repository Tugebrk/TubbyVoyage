package state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Main.Assets;

public class DeadState extends Level {

	private int count;
	private int previousState;

	public DeadState(StateManager stateManager) {

		this.stateManager = stateManager;

	}

	@Override
	public void init() {
		stateManager.setDeathCount(stateManager.getDeathCount() + 1);
		count = 0;
		previousState = stateManager.getPreviousState();

	}

	@Override
	public void tick() {

		count++;
		if (count >= 60) {
			StateManager.setState(previousState);
		}

	}

	@Override
	public void draw(Graphics2D g) {
		g.clearRect(0, 0, 1600, 900);
		g.drawImage(Assets.died, 200, 185, 1200, 527, null);
		g.setColor(new Color(210,0,0));
		g.setFont(new Font("Vagabond", Font.BOLD, 50));
		g.drawString(Integer.toString(stateManager.getDeathCount()) + " Times", 675, 670);

	}

	@Override
	public void playTrack() {
		// TODO Auto-generated method stub
		
	}

}
