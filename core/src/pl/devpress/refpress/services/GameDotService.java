package pl.devpress.refpress.services;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import pl.devpress.refpress.ui.RedDot;

public class GameDotService {
	
	private RedDot redDot;
	private int timesToRepeat = 0;
	
	public GameDotService(Stage stage) {
		init(stage);
	}

	private void init(final Stage stage) {
		redDot = new RedDot();
		stage.addActor(redDot);
		
		redDot.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				redDot.remove();
				
				Timer.schedule(new Task() {
					@Override
					public void run() {
						if(timesToRepeat >= 4){
							timesToRepeat = 0;
							cancel();
						} else {
							init(stage);
							timesToRepeat++;
						}
					}
				}, generateRandomSpawnTime());
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		

	}
	
	private float generateRandomSpawnTime() {
		float start = 0.8f;
		float end = 4f;
		
		return MathUtils.random(start, end);
	}
	
}
