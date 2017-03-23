package pl.devpress.refpress.services;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import pl.devpress.refpress.RefPress;
import pl.devpress.refpress.screens.ScoreScreen;
import pl.devpress.refpress.ui.RedDot;

public class GameDotService {
	
	public static int timesToRepeat = 0;
	public static long averageReaction, slowestReaction;
	public static long fastestReaction = 9999999;
	private RefPress game;
	private RedDot redDot;
	private Stage stage;
	private long currentTime, timeUntilDotSpawn; 
	private Sound sound;
	
	public GameDotService(Stage stage, RefPress game) {
		this.game = game;
		this.stage = stage;
		init();
	}

	private void init() {
		sound = Gdx.audio.newSound(Gdx.files.internal("Powerup.ogg"));
		spawnInRandomTime();
	}
	
	public static long getAverageReaction() {
		return averageReaction/timesToRepeat;
	}
	
	private void spawnInRandomTime() {
		Timer.schedule(new Task() {
			@Override
			public void run() {
				createDot();
				reactOnClick();
			}
		}, generateRandomSpawnTime());
	}
	
	private void createDot() {
		redDot = new RedDot();
		stage.addActor(redDot);
		currentTime = TimeUtils.millis();
	}
	
	private void reactOnClick() {
		redDot.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				sound.play();
				redDot.remove();
				generateReactions();
				isGameFinished();
				
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
	
	private void isGameFinished() {
		timesToRepeat++;
		
		if(timesToRepeat >= 5){
			game.setScreen(new ScoreScreen(game));
		} else {
			spawnInRandomTime();
		}
	}
	
	private void generateReactions() {
		timeUntilDotSpawn = TimeUtils.timeSinceMillis(currentTime);
		averageReaction += timeUntilDotSpawn;
		if (fastestReaction > timeUntilDotSpawn)
				fastestReaction = timeUntilDotSpawn;
		if (timeUntilDotSpawn > slowestReaction)
				slowestReaction = timeUntilDotSpawn;
	}
	
	private float generateRandomSpawnTime() {
		float start = 0.8f;
		float end = 4f;
		
		return MathUtils.random(start, end);
	}
	
}
