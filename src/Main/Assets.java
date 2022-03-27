package Main;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage meteor, slideScreen1, slideScreen2;
	public static BufferedImage slideScreen3, slideScreenEnd, slideScreen0;
	public static BufferedImage smoke1, smoke2, smoke3;
	public static BufferedImage endingPlain , endingFinal, morning;
	public static BufferedImage shipload1, shipload2, shipload3, shipFirstHit;
	public static BufferedImage shipdamaged1, shipdamaged2, shipdamaged3, emptyDamaged;
	public static BufferedImage shipfine1, shipfine2, shipfine3;
	public static BufferedImage night2, desert2, desert, snow2, space;
	public static BufferedImage icespikeup, icespikedown, fourtrap;
	public static BufferedImage bg1, trap1, died, warning;
	public static BufferedImage icetrap, cactustrap, forvid;
	public static BufferedImage redScarfR, redScarfL;
	public static BufferedImage redTubbyR, redTubbyL;
	public static BufferedImage purpleTubbyR, purpleTubbyL;
	public static BufferedImage yellowTubbyR, yellowTubbyL;
	public static BufferedImage greenTubbyR, greenTubbyL;
	public static BufferedImage cookie, health, ship;
	public static BufferedImage dirtN, grassyN;
	public static BufferedImage sand, sandstone;
	public static BufferedImage dirt, grassydirt;
	public static BufferedImage ice, snowyice;
	public static BufferedImage desertbg, icebg, nightbg;
	public static BufferedImage redHurtR, redHurtL;
	public static BufferedImage purpleHurtR, purpleHurtL;
	public static BufferedImage yellowHurtR, yellowHurtL;
	public static BufferedImage greenHurtR, greenHurtL;
	public static BufferedImage yellowHijabR, yellowHijabL;
	public static BufferedImage yellowHijabHurtR, yellowHijabHurtL;
	public static BufferedImage purpleDamaged, purpleFine;
	public static BufferedImage enemy1l, enemy1r;
	public static BufferedImage enemy2l, enemy2r;
	public static BufferedImage enemy3l, enemy3r;
	
	public static void init() {

//		Tiles

		dirtN = ImageLoader.loadImage("/Planets/tile2.png");
		grassyN = ImageLoader.loadImage("/Planets/tile2grass.png");
		dirt = ImageLoader.loadImage("/Planets/tile1.png");
		grassydirt = ImageLoader.loadImage("/Planets/tile1grass.png");
		ice = ImageLoader.loadImage("/Planets/ice-tile.png");
		snowyice = ImageLoader.loadImage("/Planets/snowy-ice-tile.png");
		sand = ImageLoader.loadImage("/Planets/sand.png");
		sandstone = ImageLoader.loadImage("/Planets/sandrock.png");

//		Collectibles

		health = ImageLoader.loadImage("/img/kalp.png");
		cookie = ImageLoader.loadImage("/img/cookie.png");

//		Traps

		trap1 = ImageLoader.loadImage("/Traps/trap.png");
		icetrap = ImageLoader.loadImage("/Traps/icetrap.png");
		cactustrap = ImageLoader.loadImage("/Traps/cactustrap.png");
		icespikeup = ImageLoader.loadImage("/Traps/icespikeup.png");
		icespikedown = ImageLoader.loadImage("/Traps/icespikedown.png");
		fourtrap = ImageLoader.loadImage("/Traps/4trap.png");
		
//		Enemies
		
		enemy1l = ImageLoader.loadImage("/Enemies/enemy1l.png");
		enemy1r = ImageLoader.loadImage("/Enemies/enemy1r.png");
		enemy2l = ImageLoader.loadImage("/Enemies/enemy2l.png");
		enemy2r = ImageLoader.loadImage("/Enemies/enemy2r.png");
		enemy3l = ImageLoader.loadImage("/Enemies/enemy3L.png");
		enemy3r = ImageLoader.loadImage("/Enemies/enemy3R.png");
				
				
//		Misc

		forvid = ImageLoader.loadImage("/Ship/forVid.png");
		emptyDamaged = ImageLoader.loadImage("/Ship/emptyDamaged.png");
		died = ImageLoader.loadImage("/img/youdied.jpg");
		ship = ImageLoader.loadImage("/img/spaceship.png");
		warning = ImageLoader.loadImage("/img/alert.png");
		meteor = ImageLoader.loadImage("/img/meteor.png");
		smoke1 = ImageLoader.loadImage("/img/smoke1.png");
		smoke2 = ImageLoader.loadImage("/img/smoke2.png");
		smoke3 = ImageLoader.loadImage("/img/smoke3.png");
		slideScreen0 = ImageLoader.loadImage("/BackGround/level0Slide.png");
		slideScreen1 = ImageLoader.loadImage("/BackGround/level2Slide.png");
		slideScreen2 = ImageLoader.loadImage("/BackGround/level3Slide.png");
		slideScreen3 = ImageLoader.loadImage("/BackGround/level4Slide.png");
//		slideScreenEnd = ImageLoader.loadImage("/BackGround/endSlide.png");
		
//		ship
		
		shipFirstHit = ImageLoader.loadImage("/Ship/firstHit.png");
		
		shipload1 = ImageLoader.loadImage("/Ship/1end.png");
		shipload2 = ImageLoader.loadImage("/Ship/2end.png");
		shipload3 = ImageLoader.loadImage("/Ship/3end.png");
		
		shipdamaged1 = ImageLoader.loadImage("/Ship/1broken.png");
		shipdamaged2 = ImageLoader.loadImage("/Ship/2broken.png");
		shipdamaged3 = ImageLoader.loadImage("/Ship/3broken.png");
		
		shipfine1 = ImageLoader.loadImage("/Ship/1fine.png");
		shipfine2 = ImageLoader.loadImage("/Ship/2fine.png");
		shipfine3 = ImageLoader.loadImage("/Ship/3fine.png");
		
		

//		Backgrounds

		endingFinal = ImageLoader.loadImage("/BackGround/endingFinal.png");
		endingPlain = ImageLoader.loadImage("/BackGround/endingPlain.png");
		bg1 = ImageLoader.loadImage("/BackGround/bg1.png");
		desertbg = ImageLoader.loadImage("/BackGround/desert.png");
		icebg = ImageLoader.loadImage("/BackGround/snow.png");
		nightbg = ImageLoader.loadImage("/BackGround/night.png");
		night2 = ImageLoader.loadImage("/BackGround/night2.png");
		desert = ImageLoader.loadImage("/BackGround/desert.png");
		desert2 = ImageLoader.loadImage("/BackGround/desert2.png");
		snow2 = ImageLoader.loadImage("/BackGround/snow2.png");
		space = ImageLoader.loadImage("/BackGround/space.png");
		morning = ImageLoader.loadImage("/BackGround/morning.png");

//		Tubbies

		redTubbyR = ImageLoader.loadImage("/Tubbies/redTubbyR.png");
		redTubbyL = ImageLoader.loadImage("/Tubbies/redTubbyL.png");
		yellowTubbyR = ImageLoader.loadImage("/Tubbies/yellowTubbyR.png");
		yellowTubbyL = ImageLoader.loadImage("/Tubbies/yellowTubbyL.png");
		greenTubbyL = ImageLoader.loadImage("/Tubbies/greenTubbyL.png");
		greenTubbyR = ImageLoader.loadImage("/Tubbies/greenTubbyR.png");
		purpleTubbyL = ImageLoader.loadImage("/Tubbies/purpleTubbyL.png");
		purpleTubbyR = ImageLoader.loadImage("/Tubbies/purpleTubbyR.png");
		
		purpleDamaged = ImageLoader.loadImage("/Tubbies/damagedPurple.png");
		purpleFine = ImageLoader.loadImage("/Tubbies/purpleOk.png");
		
//		Adapted Tubbies
		
		redScarfR = ImageLoader.loadImage("/Tubbies/redScarfR.png");
		redScarfL = ImageLoader.loadImage("/Tubbies/redScarfL.png");
		yellowHijabR = ImageLoader.loadImage("/Tubbies/yellowHijabR.png");
		yellowHijabL = ImageLoader.loadImage("/Tubbies/yellowHijabL.png");
		
		
//		Hurt Tubbies
		redHurtR = ImageLoader.loadImage("/Tubbies/redHurtR.png");
		redHurtL = ImageLoader.loadImage("/Tubbies/redHurtL.png");
		purpleHurtR = ImageLoader.loadImage("/Tubbies/purpleHurtR.png");
		purpleHurtL = ImageLoader.loadImage("/Tubbies/purpleHurtL.png");
		yellowHurtR = ImageLoader.loadImage("/Tubbies/yellowHurtR.png");
		yellowHurtL = ImageLoader.loadImage("/Tubbies/yellowHurtL.png");
		greenHurtR = ImageLoader.loadImage("/Tubbies/greenHurtR.png");
		greenHurtL = ImageLoader.loadImage("/Tubbies/greenHurtL.png");
		yellowHijabHurtR = ImageLoader.loadImage("/Tubbies/yellowHijabHurtR.png");
		yellowHijabHurtL = ImageLoader.loadImage("/Tubbies/yellowHijabHurtL.png");
		
	}

}
