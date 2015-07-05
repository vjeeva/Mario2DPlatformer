/*
 Sound.Java (for Super Mario: The Zakaryan Strikes Back)
 By: Varjitt J, Rushil P, Bassem S, Francis Z
 To: Mr. D'Addario
 Due Date: January 27, 2014
 Period 1

 Program Description: This is a rendition of the famous Super Mario made by Nintendo.
 It has small & big mario, numerous types of enemies, and 7 levels. You must clear
 each level to finish the game. You do so by getting your character to the end of the map.
 You only get one run, starting with 20 lives. You get another life when you reach
 100 coins. No saves, no cheats. Good Luck.
 */

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Sound {

	static Clip clip; //clip for background music or music that loops continously
	static Clip actionClip; //clip for sound effects

	public static void playMusic(String m) throws Exception {
		File music = new File("resources/" + m); //makes .wav file into a File object
		AudioInputStream ais = AudioSystem.getAudioInputStream(music); //obtains .wav file from resource folder

		AudioFormat af = ais.getFormat(); //converts .wav file into data that Java can read
		DataLine.Info info = new DataLine.Info(Clip.class, af);
		clip = (Clip) AudioSystem.getLine(info);

		clip.open(ais); //opens .wav file
		clip.loop(Clip.LOOP_CONTINUOUSLY); //plays music continuously
		clip.start(); //starts playing music
	}
	
	public static void playActionMusic(String am) throws Exception {
		File actionMusic = new File("resources/" + am); //makes .wav file into a File object
		AudioInputStream ais = AudioSystem.getAudioInputStream(actionMusic); //obtains .wav file from resource folder

		AudioFormat af = ais.getFormat();
		DataLine.Info info = new DataLine.Info(Clip.class, af); //converts .wav file into data that Java can read
		actionClip = (Clip) AudioSystem.getLine(info);

		actionClip.open(ais); //opens .wav file
		actionClip.start(); //starts playing sound effect
	}
	
	public static void resume() {
		clip.start(); //resumes background music
	}

	public static void pauseMusic() {
		clip.stop(); //pauses background music	
	}
}
