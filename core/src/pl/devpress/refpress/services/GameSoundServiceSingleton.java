package pl.devpress.refpress.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class GameSoundServiceSingleton {
	private static GameSoundServiceSingleton instance = null;
	private BigDecimal start;
	private BigDecimal setValueOfSound;
	private Sound soundWhenDotTouched;
	
    private GameSoundServiceSingleton() {
    	init();
	}
	
    private void init() {
    	start = new BigDecimal(1).setScale(1, RoundingMode.FLOOR);
    	setValueOfSound = new BigDecimal(0.1).setScale(1, RoundingMode.FLOOR);
    	soundWhenDotTouched = Gdx.audio.newSound(Gdx.files.internal("Powerup.ogg"));
	}

	public static GameSoundServiceSingleton getInstance() {
        if(instance == null) {
           instance = new GameSoundServiceSingleton();
        }
        return instance;
     }
    
	public void play() {
		soundWhenDotTouched.play(start.floatValue());
	}
	
	public void subtractVolume() {
		if( start.floatValue() > 0 ){
			start = start.subtract(setValueOfSound);
		}
		System.out.println(start);
	}
	
	public void dispose() {
		soundWhenDotTouched.dispose();
	}
}
