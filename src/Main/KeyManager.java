package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keyStates;
	public static boolean arrowKeys = false;
	public static boolean wasd = true;
	public static boolean up;
	public static boolean down;
	public static boolean left;
	public static boolean right;
	public static boolean esc;
	public static boolean space;

	public KeyManager() {

//		Since there are 256 keys we create an array with size 256
		keyStates = new boolean[256];
	}

	public void tick() {

		esc = keyStates[KeyEvent.VK_ESCAPE];
		
		if (arrowKeys && wasd) {
			up = keyStates[KeyEvent.VK_W] || keyStates[KeyEvent.VK_SPACE] || keyStates[KeyEvent.VK_UP];
			left = keyStates[KeyEvent.VK_A] || keyStates[KeyEvent.VK_LEFT];
			down = keyStates[KeyEvent.VK_S] || keyStates[KeyEvent.VK_DOWN];
			right = keyStates[KeyEvent.VK_D] || keyStates[KeyEvent.VK_RIGHT];
		} else if (wasd) {
			up = keyStates[KeyEvent.VK_W] || keyStates[KeyEvent.VK_SPACE];
			left = keyStates[KeyEvent.VK_A];
			down = keyStates[KeyEvent.VK_S];
			right = keyStates[KeyEvent.VK_D];
		}
		else if (arrowKeys) {
			up =  keyStates[KeyEvent.VK_SPACE] || keyStates[KeyEvent.VK_UP];
			left = keyStates[KeyEvent.VK_LEFT];
			down = keyStates[KeyEvent.VK_DOWN];
			right =  keyStates[KeyEvent.VK_RIGHT];
		}
	}

	@Override
	public void keyPressed(KeyEvent k) {
		keyStates[k.getKeyCode()] = true;

	}

	@Override
	public void keyReleased(KeyEvent k) {
		keyStates[k.getKeyCode()] = false;

	}

	@Override
	public void keyTyped(KeyEvent k) {
		// TODO Auto-generated method stub

	}


}
