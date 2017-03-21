package pl.devpress.refpress.services;

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
	
	private RefPress game;
	private RedDot redDot;
	private Stage stage;
	public static int timesToRepeat = 0;
	private long currentTime, timeUntilDotSpawn; 
	public static long averageReaction, slowestReaction;
	public static long fastestReaction = 9999999;
	
	public GameDotService(Stage stage, RefPress game) {
		this.game = game;
		this.stage = stage;
		init();
	}

	private void init() {
		spawnInRandomTime();
	}
	
	private void spawnInRandomTime() {
		Timer.schedule(new Task() {
			@Override
			public void run() {
				spawnDot();
				reactOnClick();
			}
		}, generateRandomSpawnTime());
	}
	
	private void spawnDot() {
		redDot = new RedDot();
		stage.addActor(redDot);
		currentTime = TimeUtils.millis();
	}
	
	private void reactOnClick() {
		redDot.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				timesToRepeat++;
				redDot.remove();
				timeUntilDotSpawn = TimeUtils.timeSinceMillis(currentTime);
				generateReactions(timeUntilDotSpawn);
				
				if(timesToRepeat >= 5){
					game.setScreen(new ScoreScreen(game));
				} else {
					spawnInRandomTime();
				}
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
	
	
	public static long getAverageReaction() {
		return averageReaction/timesToRepeat;
	}
	
	private void generateReactions(long timeUntilDotSpawn) {
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
