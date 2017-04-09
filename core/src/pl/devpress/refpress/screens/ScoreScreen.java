package pl.devpress.refpress.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import pl.devpress.refpress.RefPress;
import pl.devpress.refpress.services.GameDotService;

public class ScoreScreen extends AbstractScreen {

	private int screenTouched = 0;
	private String averageReaction;
	private String slowestReaction;
	private String fastestReaction;
	private String message;
	BitmapFont mapFont;
	
	
	public ScoreScreen(RefPress game) {
		super(game);
	}

	@Override
	protected void init() {
		displayScore();
	}

	private void displayScore() {
		averageReaction = "Average reaction: " + GameDotService.getAverageReaction() + "ms";
		slowestReaction = "Slowest reaction: " + GameDotService.slowestReaction + "ms";
		fastestReaction = "Fastest reaction: " + GameDotService.fastestReaction + "ms"; 
		message = "Tap to retry";
		mapFont = new BitmapFont();
	}


	private void setScreen() {
		if(screenTouched == 2) {
			game.setScreen(new MenuScreen(game));
			GameDotService.timesToRepeat = 0;
			GameDotService.averageReaction = 0;
			GameDotService.slowestReaction = 0;
			GameDotService.fastestReaction = 9999999;
		}
	}

	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		if(Gdx.input.justTouched()) {
			screenTouched++;
			setScreen();
		}
		
		spriteBatch.begin();
		mapFont.draw(spriteBatch, averageReaction, 150, 410);
		mapFont.draw(spriteBatch, fastestReaction, 150, 380);
		mapFont.draw(spriteBatch, slowestReaction, 150, 350);
		mapFont.draw(spriteBatch, message, 150, 300);
		spriteBatch.end();
	}
	
	@Override
	public void dispose() {
		mapFont.dispose();
	}
	
}
