package audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicBox {

	static float dB;
	static double prevGain = 0.0f;
	static double gain = 0.02;
	static double maxDb = 6.0206;
	// to store current position
	Long currentFrame;
	static Clip clip;

	// current status of clip
	String status;

	static AudioInputStream audioInputStream;
	static String filePath;

	// constructor to initialize streams and clip
	public MusicBox(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// create AudioInputStream object
		MusicBox.filePath = filePath;
		audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

		// create clip reference
		clip = AudioSystem.getClip();

		// open audioInputStream to the clip
		clip.open(audioInputStream);

		volumeSet();

		clip.loop(Clip.LOOP_CONTINUOUSLY);

	}

	public static String getFilePath() {
		return filePath;
	}

	public static void stop() {

		clip.stop();

	}
	
	public static void mute() {
		
		
		double temp = gain;
		
		gain = prevGain;
		
		prevGain = temp;
		
		volumeSet();
		
	}

	public static void setFilePath(String filePath) {

		stop();

		MusicBox.filePath = filePath;

		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// create clip reference
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// open audioInputStream to the clip
		try {
			clip.open(audioInputStream);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		volumeSet();
				
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
	}

	public static void open() {

		try {
			clip.open();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void volumeSet() {

		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

		dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);

		gainControl.setValue(dB);

	}

	public static void volumeUP() {

		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

		// set the gain (between 0.0 and 1.0)

		if (!((float) (Math.log(gain + 0.2) / Math.log(10.0) * 20.0) >= maxDb))
			gain += 0.15;

		dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
		gainControl.setValue(dB);
	}

	public static void volumeDOWN() {

		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

		// set the gain (between 0.0 and 1.0)

		gain -= 0.15;

		dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);

		gainControl.setValue(dB);

	}

	public static double getGain() {
		return gain;
	}

	public static void setGain(double gain) {
		MusicBox.gain = gain;
	}
	
	
}
