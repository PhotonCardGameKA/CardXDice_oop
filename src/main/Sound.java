package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import java.net.URL;

public class Sound {
	
	Clip track;
	Clip sfx;
	URL trackURL[] = new URL[4];
	URL sfxURL[] = new URL[20];
	float trackCurrentVolume = -6;
	float trackPreviousVolume = -6;
	float sfxCurrentVolume = -12;
	float sfxPreviousVolume = -12;
	FloatControl tFC;
	FloatControl sfxFC;
	public boolean trackMuted = false;
	public boolean sfxMuted = false;
			
	public Sound() {
		trackURL[0] = getClass().getResource("/music/Track/main-menu-theme.wav");
		trackURL[1] = getClass().getResource("/music/Track/high-spirit.wav");
		trackURL[2] = getClass().getResource("/music/Track/danger.wav");
		trackURL[3] = getClass().getResource("/music/Track/boss-battle.wav");
		
		sfxURL[0] = getClass().getResource("/music/SFX/button.wav");			// 0 = button
		sfxURL[1] = getClass().getResource("/music/SFX/dice-rolling.wav");		// 1 = dice roll
		sfxURL[2] = getClass().getResource("/music/SFX/card-drawing.wav");		// 2 = card draw
		sfxURL[3] = getClass().getResource("/music/SFX/hit.wav");				// 3 = hit
		sfxURL[4] = getClass().getResource("/music/SFX/big-hit.wav");			// 4 = big hit
		sfxURL[5] = getClass().getResource("/music/SFX/heavy-hit.wav");			// 5 = heavy hit
		sfxURL[6] = getClass().getResource("/music/SFX/heal.wav");				// 6 = heal
		sfxURL[7] = getClass().getResource("/music/SFX/shield.wav");			// 7 = shield
		sfxURL[8] = getClass().getResource("/music/SFX/death.wav");				// 8 = death
		sfxURL[9] = getClass().getResource("/music/SFX/victory.wav");			// 9 = win
		sfxURL[10] = getClass().getResource("/music/SFX/6-roll.wav");			// 10 = 6 dice roll
	}
	
	// Play and stop music
	public void playTrack(int i) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(trackURL[i]);
			track = AudioSystem.getClip();
			track.open(ais);
			tFC = (FloatControl)track.getControl(FloatControl.Type.MASTER_GAIN);
		}catch(Exception e) {
			
		}
		tFC.setValue(trackCurrentVolume);
		track.start();
		track.loop(Clip.LOOP_CONTINUOUSLY);
	}
	public void playSFX(int i) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(sfxURL[i]);
			sfx = AudioSystem.getClip();
			sfx.open(ais);
			sfxFC = (FloatControl)sfx.getControl(FloatControl.Type.MASTER_GAIN);
		}catch(Exception e) {
			
		}
		if(!sfxMuted) sfxFC.setValue(sfxCurrentVolume);
		else sfxFC.setValue(-80);
		sfx.start();
	}
	public void stopTrack() {
		if(track != null)	track.stop();
	}
	public void stopSFX() {
		if(sfx != null)	sfx.stop();
	}
	
	// Sound Volume
	public void trackVolumeUp() {
		if(!trackMuted) {
			if(trackCurrentVolume <= -18.0f) {
				trackCurrentVolume = -18.0f;
			}
			trackCurrentVolume += 2.4f;
			if(trackCurrentVolume > 6.0f) trackCurrentVolume = 6.0f;
			tFC.setValue(trackCurrentVolume);
			trackPreviousVolume = trackCurrentVolume;
		}else {
			trackPreviousVolume += 2.4f;
			if(trackPreviousVolume > 6.0f) trackPreviousVolume = 6.0f;
			trackCurrentVolume = trackPreviousVolume;
		}
	}
	public void trackVolumeDown() {
		if(!trackMuted) {
			trackCurrentVolume -= 2.4f;
			if(trackCurrentVolume <= -18.0f) {
				trackCurrentVolume = -80.0f;
			}
			tFC.setValue(trackCurrentVolume);
			trackPreviousVolume = trackCurrentVolume;
		}else {
			trackPreviousVolume -= 2.4f;
			if(trackPreviousVolume <= -18.0f) {
				trackPreviousVolume = -80.0f;
			}
			trackCurrentVolume = trackPreviousVolume;
		}
	}
	public void trackMute() {
		if(!trackMuted) {
			trackPreviousVolume = trackCurrentVolume;
			trackCurrentVolume = -80.0f;
			tFC.setValue(trackCurrentVolume);
		}else {
			trackCurrentVolume = trackPreviousVolume;
			tFC.setValue(trackCurrentVolume);
		}
		trackMuted = !trackMuted;
	}
	
	public void sfxVolumeUp() {
		if(!sfxMuted) {
			if(sfxCurrentVolume <= -30.0f) {
				sfxCurrentVolume = -30.0f;
			}
			sfxCurrentVolume += 3.6f;
			if(sfxCurrentVolume > 6.0f) sfxCurrentVolume = 6.0f;
			sfxFC.setValue(sfxCurrentVolume);
			sfxPreviousVolume = sfxCurrentVolume;
		}else {
			sfxPreviousVolume += 3.6f;
			if(sfxPreviousVolume > 6.0f) sfxPreviousVolume = 6.0f;
			sfxCurrentVolume = sfxPreviousVolume;
		}
	}
	public void sfxVolumeDown() {
		if(!sfxMuted) {
			sfxCurrentVolume -= 3.6f;
			if(sfxCurrentVolume <= -30.0f) {
				sfxCurrentVolume = -80.0f;
			}
			sfxFC.setValue(sfxCurrentVolume);
			sfxPreviousVolume = sfxCurrentVolume;
		}else {
			sfxPreviousVolume -= 3.6f;
			if(sfxPreviousVolume <= -30.0f) {
				sfxPreviousVolume = -80.0f;
			}
			sfxCurrentVolume = sfxPreviousVolume;
		}
	}
	public void sfxMute() {
		if(!sfxMuted) {
			sfxPreviousVolume = sfxCurrentVolume;
			sfxCurrentVolume = -80.0f;
			sfxFC.setValue(sfxCurrentVolume);
		}else {
			sfxCurrentVolume = sfxPreviousVolume;
			sfxFC.setValue(sfxCurrentVolume);
		}
		sfxMuted =!sfxMuted;
	}
}
