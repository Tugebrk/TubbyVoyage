package Main;

import java.awt.EventQueue;

import state.MenuState;

public class Main {
	public static GFrame frame;
	public static MenuState window;
	public GFrame as;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new MenuState();
					window.yitir();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
