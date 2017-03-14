package pl.devpress.refpress.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import pl.devpress.refpress.RefPress;
import pl.devpress.refpress.services.GameDotService;

public class ScoreScreen extends AbstractScreen {

	private String averageReaction;
	private String slowestReaction;
	private String fastestReaction;
	private String message;
	BitmapFont mapFont;
	
	public ScoreScreen(RefPress game) {
		super(game);
		displayScore();
	}


	private void displayScore() {
		averageReaction = "Average reaction: " + GameDotService.getAverageReaction() + "ms";
		slowestReaction = "Slowest reaction: " + GameDotService.slowestReaction + "ms";
		fastestReaction = "Fastest reaction: " + GameDotService.fastestReaction + "ms"; 
		message = "Tap to retry";
		mapFont = new BitmapFont();
	}


	@Override
	protected void init() {
		
	}
	

	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		if(Gdx.input.justTouched()) {
			game.setScreen(new MenuScreen(game));
			GameDotService.timesToRepeat = 0;
			GameDotService.averageReaction = 0;
			GameDotService.slowestReaction = 0;
			GameDotService.fastestReaction = 9999999;
		}
		
		spriteBatch.begin();
		mapFont.draw(spriteBatch, averageReaction, 150, 410);
		mapFont.draw(spriteBatch, fastestReaction, 150, 380);
		mapFont.draw(spriteBatch, slowestReaction, 150, 350);
		mapFont.draw(spriteBatch, message, 150, 300);
		spriteBatch.end();
	}
	
}
