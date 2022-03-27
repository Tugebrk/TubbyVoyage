package state;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Main.GFrame;
import Main.KeyManager;
import audio.MusicBox;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class MenuState {

	@SuppressWarnings("unused")
	private MusicBox musicBox;
	private JFrame frame;
	private JPanel credit;
	private JPanel settings;
	private JPanel play;
	public JPanel menu;
	private JLayeredPane layeredPane_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton_4;
	private JButton Return;
	private JLabel lblNewLabel_6;
	private JButton wasdButton;
	private JButton ArrowsB;
	@SuppressWarnings("unused")
	private JLabel wasd;
	@SuppressWarnings("unused")
	private JLabel arrow;
	public GFrame x = new GFrame();
	public final JPopupMenu poppop = new JPopupMenu();
	@SuppressWarnings("unused")
	private JMenuItem menIt = null;
	private JButton BothB;

	private JLabel HEAD;
	private JLabel MALI;
	private JLabel BRS;
	private JLabel DGKN;
	private JButton ReturnCredit;
	private JLabel BackGroundCredit;

	/**
	 * Launch the application.
	 */

//	public void keyPressed(KeyEvent k) {
//		int key = k.getKeyCode();
//		switch(key) {
//		case KeyEvent.VK_ESCAPE:
//
//			initialize();
//
//		}
//	}
	public void keyPress() {
		sP(menu);

	}

	public void yitir() {
		frame.setVisible(true);
	}

//public void popop(JFrame frame)
//{
//	menuIt = new JMenuItem();
//}
	public void sP(JPanel panel) {
		layeredPane_1.removeAll();
		layeredPane_1.add(panel);
		layeredPane_1.repaint();
		layeredPane_1.revalidate();
	}

	public void jP(JFrame frame) {
		x.dispose();
		this.initialize();

	}

	/**
	 * Create the application.
	 */
	public MenuState() {
		initialize();
	}

	public void playTrack() {
		MusicBox.setFilePath("Assets/Audio/menu.wav");
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public void initialize() {

		try {
			musicBox = new MusicBox("Assets/Audio/menu.wav");
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		playTrack();

		frame = new JFrame();
		frame.setTitle("TubbyVoyage");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(10, 11, 766, 541);
		frame.getContentPane().add(layeredPane_1);
		layeredPane_1.setLayout(new CardLayout(0, 0));

		menu = new JPanel();
		layeredPane_1.add(menu, "name_618912982208900");
		menu.setLayout(null);

		frame.setResizable(false);

		JButton PlayButton = new JButton("");
		PlayButton.setText("Play");
		PlayButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 84));
		PlayButton.setBackground(Color.GREEN);// import java.awt.Color;
		PlayButton.setForeground(new Color(154, 205, 50));

		PlayButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				PlayButton.setIcon(new ImageIcon(this.getClass().getResource("/img/meteor30.png")));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				PlayButton.setIcon(new ImageIcon(this.getClass().getResource("")));
			}
		});

		PlayButton.setOpaque(false);
		PlayButton.setContentAreaFilled(false);
		PlayButton.setBorderPainted(false);
		PlayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				x.start();

			}
		});

		PlayButton.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 30));
		PlayButton.setBounds(251, 112, 244, 58);
		menu.add(PlayButton);

		JButton SettingsButton = new JButton("Settings");
		SettingsButton.setForeground(Color.RED);
		SettingsButton.setOpaque(false);
		SettingsButton.setContentAreaFilled(false);
		SettingsButton.setBorderPainted(false);
		SettingsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sP(settings);
			}
		});

		SettingsButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				SettingsButton.setIcon(new ImageIcon(this.getClass().getResource("/img/meteor30.png")));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				SettingsButton.setIcon(new ImageIcon(this.getClass().getResource("")));
			}
		});

		SettingsButton.setBackground(new Color(50, 205, 50));
		SettingsButton.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 30));
		SettingsButton.setBounds(251, 182, 244, 58);
		SettingsButton.setFocusPainted(false);
		SettingsButton.setBorderPainted(false);
		menu.add(SettingsButton);

		JButton CreditButton = new JButton("Credit");
		CreditButton.setForeground(Color.MAGENTA);
		CreditButton.setOpaque(false);
		CreditButton.setContentAreaFilled(false);
		CreditButton.setBorderPainted(false);
		CreditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keyPress();
				sP(credit);
			}
		});

		CreditButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				CreditButton.setIcon(new ImageIcon(this.getClass().getResource("/img/meteor30.png")));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				CreditButton.setIcon(new ImageIcon(this.getClass().getResource("")));
			}
		});

		CreditButton.setBackground(new Color(255, 0, 255));
		CreditButton.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 30));
		CreditButton.setBounds(251, 252, 244, 58);
		CreditButton.setFocusPainted(false);
		CreditButton.setBorderPainted(false);
		menu.add(CreditButton);

		JButton ExitButton = new JButton("Exit");
		ExitButton.setForeground(Color.YELLOW);
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		ExitButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				ExitButton.setIcon(new ImageIcon(this.getClass().getResource("/img/meteor30.png")));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				ExitButton.setIcon(new ImageIcon(this.getClass().getResource("")));
			}
		});

		ExitButton.setBackground(new Color(255, 0, 0));
		ExitButton.setOpaque(false);
		ExitButton.setContentAreaFilled(false);
		ExitButton.setBorderPainted(false);
		ExitButton.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 30));
		ExitButton.setBounds(251, 322, 244, 58);
		ExitButton.setFocusPainted(false);
		ExitButton.setBorderPainted(false);
		menu.add(ExitButton);

		JLabel BackGround = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/img/menubg.png")).getImage();
		BackGround.setIcon(new ImageIcon(img));
		BackGround.setBounds(0, 0, 800, 600);
		menu.add(BackGround);

		play = new JPanel();
		layeredPane_1.add(play, "name_618915288650600");
		play.setLayout(null);

		settings = new JPanel();
		layeredPane_1.add(settings, "name_618917614656100");

		lblNewLabel_6 = new JLabel("Please choose how you want to play");
		lblNewLabel_6.setBounds(77, 11, 615, 69);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 36));
		settings.add(lblNewLabel_6);
		settings.setLayout(null);

		wasdButton = new JButton("");
		wasdButton.setContentAreaFilled(false);
		wasdButton.setBorderPainted(false);
		wasdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wasdButton.setIcon(new ImageIcon(this.getClass().getResource("/img/WASD.png")));
				ArrowsB.setIcon(new ImageIcon(this.getClass().getResource("/img/ARROWX.png")));
				KeyManager.arrowKeys = false;
				KeyManager.wasd = true;
			}
		});
		wasdButton.setBounds(334, 138, 205, 165);
		wasdButton.setIcon(new ImageIcon(this.getClass().getResource("/img/WASD.png")));
		settings.add(wasdButton);

		ArrowsB = new JButton("");
		ArrowsB.setOpaque(false);
		ArrowsB.setContentAreaFilled(false);
		ArrowsB.setBorderPainted(false);
		ArrowsB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrowsB.setIcon(new ImageIcon(this.getClass().getResource("/img/ARROW.png")));
				wasdButton.setIcon(new ImageIcon(this.getClass().getResource("/img/WASDX.png")));
				KeyManager.arrowKeys = true;
				KeyManager.wasd = false;
			}
		});

		JButton volume = new JButton("");
		volume.setBounds(119, 138, 62, 69);
		ImageIcon vol1 = new ImageIcon(this.getClass().getResource("/img/mute.png"));
		ImageIcon vol2 = new ImageIcon(this.getClass().getResource("/img/unmute.png"));
		volume.setIcon(vol1);
		volume.setOpaque(false);
		volume.setContentAreaFilled(false);
		volume.setBorderPainted(false);
		settings.add(volume);
		volume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (volume.getIcon() == vol1) {
					volume.setIcon(vol2);
					MusicBox.mute();
				} else {
					volume.setIcon(vol1);
					MusicBox.mute();
				}
			}
		});

		ArrowsB.setBounds(551, 138, 205, 165);
		ArrowsB.setIcon(new ImageIcon(this.getClass().getResource("/img/ARROWX.png")));
		settings.add(ArrowsB);

		settings.add(ArrowsB);
		BothB = new JButton("");
		BothB.setIcon(new ImageIcon(MenuState.class.getResource("/img/both.png")));
		BothB.setOpaque(false);
		BothB.setContentAreaFilled(false);
		BothB.setBorderPainted(false);
		BothB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wasdButton.setIcon(new ImageIcon(this.getClass().getResource("/img/WASD.png")));
				ArrowsB.setIcon(new ImageIcon(this.getClass().getResource("/img/ARROW.png")));
				KeyManager.arrowKeys = true;
				KeyManager.wasd = true;
			}
		});
		BothB.setBounds(396, 315, 310, 163);
		settings.add(BothB);

		JSlider slider = new JSlider((int) 0.02, (int) 6.004);
		slider.setBounds(6, 219, 278, 45);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setOpaque(false);
		settings.add(slider);

		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				MusicBox.setGain((double) slider.getValue() / 100);
				MusicBox.volumeSet();
			}
		});

		JButton ReturnSet = new JButton("Return to Menu");
		ReturnSet.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		ReturnSet.setBackground(Color.CYAN);
		ReturnSet.setForeground(new Color(255, 250, 240));
		ReturnSet.setOpaque(false);
		ReturnSet.setContentAreaFilled(true);
		ReturnSet.setBorderPainted(false);
		ReturnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sP(menu);
			}
		});
		ReturnSet.setBounds(417, 478, 349, 63);
		settings.add(ReturnSet);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(this.getClass().getResource("/img/menu2.jpg")));
		label.setBounds(0, 0, 789, 561);
		settings.add(label);

		credit = new JPanel();
		layeredPane_1.add(credit, "name_618942709405300");
		credit.setLayout(null);

		HEAD = new JLabel("Creators");
		HEAD.setHorizontalAlignment(SwingConstants.CENTER);
		HEAD.setFont(new Font("Informal Roman", Font.PLAIN, 68));
		HEAD.setBounds(10, 11, 746, 77);
		credit.add(HEAD);

		lblNewLabel_3 = new JLabel("Tu\u011Fberk Y\u0131lmaz");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 51));
		lblNewLabel_3.setBounds(161, 99, 445, 77);
		credit.add(lblNewLabel_3);

		MALI = new JLabel("Mehmet Ali EREL");
		MALI.setFont(new Font("Tahoma", Font.PLAIN, 51));
		MALI.setHorizontalAlignment(SwingConstants.CENTER);
		MALI.setBounds(161, 187, 445, 77);
		credit.add(MALI);

		BRS = new JLabel("Barýþ Sinaplý");
		BRS.setHorizontalAlignment(SwingConstants.CENTER);
		BRS.setFont(new Font("Tahoma", Font.PLAIN, 51));
		BRS.setBounds(161, 275, 445, 77);
		credit.add(BRS);

		ReturnCredit = new JButton("Return to Menu");
		ReturnCredit.setForeground(new Color(245, 245, 220));
		ReturnCredit.setOpaque(false);
		ReturnCredit.setContentAreaFilled(false);
		ReturnCredit.setBorderPainted(false);
		ReturnCredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sP(menu);
			}
		});
		ReturnCredit.setFont(new Font("Tahoma", Font.PLAIN, 50));
		ReturnCredit.setBounds(-50, 450, 521, 63);
		credit.add(ReturnCredit);

		BackGroundCredit = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/img/menu1.jpg")).getImage();
		BackGroundCredit.setIcon(new ImageIcon(img2));
		BackGroundCredit.setBounds(0, 0, 800, 600);
		credit.add(BackGroundCredit);

		menu.add(BackGround);

		JButton ret = new JButton("Return Menu");

	}
}