package Main;

import javax.swing.JFrame;
import state.MenuState;
public class GFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private MenuState men=null;
	@SuppressWarnings("unused")
	private GamePanel x;
	public GFrame()
	{
	}

	public void GFrameDispose()
	{
		this.dispose();
	}
	
	public void start() {
		this.add(new GamePanel(this));
		this.setTitle("Tubby Voyage");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setSize(1600,900);
		
	}

	public MenuState getMen() {
		return men;
	}

	public void setMen(MenuState men) {
		this.men = men;
	}
}

