package state;

import java.awt.Graphics2D;

import java.util.ArrayList;

import Main.Assets;
import Main.GamePanel;

public class StateManager {

	private static ArrayList<Level> states;
	public static ArrayList<String> playList;
	private static int previousState;
	private static int currentState;
	public static int currentTrack;

	private GamePanel gamePanel;
	private MenuState menuPanel;

	private int deathCount = 0;
	private static final int intro = 0;
	private static final int level0 = 1;
	private static final int level0Load = 2;
	private static final int level1 = 3;
	private static final int level2load = 4;
	private static final int level2 = 5;
	private static final int level3load = 6;
	private static final int level3 = 7;
	private static final int level4load = 8;
	private static final int outro = 9;
	private static final int deadState = 10;

	public StateManager(GamePanel gamePanel) {

		this.gamePanel = gamePanel;

		playList = new ArrayList<String>();
		states = new ArrayList<Level>();

		states.add(new Intro(this));
		states.add(new Level0(this));
		states.add(new Level0Load(Assets.slideScreen1, this));
		states.add(new Level1(this));
		states.add(new LoadingScreen(Assets.shipload1, Assets.slideScreen2, this));
		states.add(new Level2(this));
		states.add(new LoadingScreen(Assets.shipload2, Assets.slideScreen3, this));
		states.add(new Level3(this));
		states.add(new LoadingScreen(Assets.shipload3, null, this));
		states.add(new Outro());
		states.add(new DeadState(this));

		currentTrack = 0;
		currentState = intro;
		states.get(currentState).playTrack();
	}

	public static void setState(int state) {

		previousState = currentState;
		currentState = state;
		states.get(state).init();

	}

	public static void nextLevel() {

		currentState++;
		currentTrack++;
		states.get(currentState).playTrack();
	}

	public void tick() {

		states.get(currentState).tick();
	}

	public void draw(Graphics2D g) {
		states.get(currentState).draw(g);

	}

	public ArrayList<Level> getStates() {
		return states;
	}

	public void setStates(ArrayList<Level> states) {
		StateManager.states = states;
	}

	public int getCurrentState() {
		return currentState;
	}

	public void setCurrentState(int currentState) {
		StateManager.currentState = currentState;
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	public MenuState getMenuPanel() {
		return menuPanel;
	}

	public void setMenuPanel(MenuState menuPanel) {
		this.menuPanel = menuPanel;
	}

	public static int getLevel1() {
		return level1;
	}

	public static int getLevel2() {
		return level2;
	}

	public static int getLevel3() {
		return level3;
	}

	public int getPreviousState() {
		return previousState;
	}

	public void setPreviousState(int previousState) {
		StateManager.previousState = previousState;
	}

	public int getDeathCount() {
		return deathCount;
	}

	public void setDeathCount(int deathCount) {
		this.deathCount = deathCount;
	}

	public static ArrayList<String> getPlayList() {
		return playList;
	}

	public static void setPlayList(ArrayList<String> playList) {
		StateManager.playList = playList;
	}

	public static int getCurrentTrack() {
		return currentTrack;
	}

	public static void setCurrentTrack(int currentTrack) {
		StateManager.currentTrack = currentTrack;
	}

	public static int getIntro() {
		return intro;
	}

	public static int getLevel2load() {
		return level2load;
	}

	public static int getLevel3load() {
		return level3load;
	}

	public static int getLevel4load() {
		return level4load;
	}

	public static int getDeadstate() {
		return deadState;
	}

	public static int getOutro() {
		return outro;
	}

	public static int getLevel0() {
		return level0;
	}

	public static int getLevel0load() {
		return level0Load;
	}

}
