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
	private int timesToRepeat = 0;
	private long currentTime, timeUntilLastClick, averageReaction, slowestReaction; 
	private long fastestReaction = 9999999;
	
	public GameDotService(Stage stage, RefPress game) {
		init(stage);
		this.game = game;
	}

	private void init(final Stage stage) {
		
		redDot = new RedDot();
		stage.addActor(redDot);
		
		currentTime = TimeUtils.millis();
		
		redDot.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				timesToRepeat++;
				System.out.println(timesToRepeat);
				redDot.remove();
				timeUntilLastClick = TimeUtils.timeSinceMillis(currentTime);
				generateReactions(timeUntilLastClick);
				
				
				Timer.schedule(new Task() {
					@Override
					public void run() {
						if(timesToRepeat >= 5){
							cancel();
							System.out.println("Fastest reaction: "+ fastestReaction);
							System.out.println("Slowest reaction: "+ slowestReaction);
							game.setScreen(new ScoreScreen(game, getAverageReaction()));
						} else {
							init(stage);
						}
					}

				}, generateRandomSpawnTime());
				return super.touchDown(event, x, y, pointer, button);
			}


		});
		
	}
	
	public long getAverageReaction() {
		return averageReaction/timesToRepeat;
		
	}
	
	private void generateReactions(long timeUntilLastClick) {
		System.out.println("time since: "+ timeUntilLastClick);
		averageReaction += timeUntilLastClick;
		if (fastestReaction > timeUntilLastClick)
				fastestReaction = timeUntilLastClick;
		if (timeUntilLastClick > slowestReaction)
				slowestReaction = timeUntilLastClick;
	}
	
	private float generateRandomSpawnTime() {
		float start = 0.8f;
		float end = 4f;
		
		return MathUtils.random(start, end);
	}
	
}
