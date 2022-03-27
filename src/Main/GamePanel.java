package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;



import javax.swing.JPanel;

import state.MenuState;
import state.StateManager;

import audio.MusicBox;

public class GamePanel extends JPanel implements Runnable {

	/**
	 * 
	 */

	private GFrame gf;
//	Dimensions

	private static final long serialVersionUID = -2135705685294452991L;
	public static final int WIDTH = 1600;
	public static final int HEIGHT = 900;
	public static final int SCALE = 1;

//	Game loop

	private long start;
	private long elapsed;
	private long wait;

	private Thread thread;
	public boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;

//	Handlers

	private StateManager stateManager;
	private KeyManager keyManager = new KeyManager();

//	Graphics

	private BufferedImage image;
	private Graphics2D g;

	public GamePanel(GFrame x) {
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();
		this.gf = x;
	}

	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			addKeyListener(keyManager);
			thread.start();
		}
	}

	private void init() {

		Assets.init();
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		running = true;
		stateManager = new StateManager(this);

	}

	private void tick() {
		stateManager.tick();
		keyManager.tick();

	}

	private void draw() {
		stateManager.draw(g);
	}

	private void drawToScreen() {

		Graphics g2 = getGraphics();

		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}

	@Override
	public void run() {

		init();

		while (running) {

			start = System.nanoTime();
			tick();
			draw();
			drawToScreen();
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;

			keyPres();
			if (wait < 0)
				wait = 5;

			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void keyPres() {
		if (KeyManager.esc) {
			MusicBox.stop();
			gf.dispose();
			Main.window = new MenuState();
			Main.window.yitir();
		}
	}

}
