package pl.devpress.refpress.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

import pl.devpress.refpress.RefPress;
import pl.devpress.refpress.services.GameDotService;

public class ScoreScreen extends AbstractScreen {

	private FreeTypeFontGenerator generator;
	private FreeTypeFontParameter parameter;
	private BitmapFont textFont, scoreFont, decorationFont, bigText;
	private String averageReaction, slowestReaction, fastestReaction, averageScore,
					slowestScore, fastestScore, message, decoration;
	private int screenTouched = 0;
	
	public ScoreScreen(RefPress game) {
		super(game);
	}

	@Override
	protected void init() {
		initFonts();
		initText();
	}

	private void initFonts() {
		generator = new FreeTypeFontGenerator(Gdx.files.internal("OpenSans-ExtraBold.ttf"));
		parameter = new FreeTypeFontParameter();
		
		parameter.size = 24;
		parameter.borderColor = Color.BLACK;
		parameter.borderWidth = 2;
		
		decorationFont = generator.generateFont(parameter);
		textFont = generator.generateFont(parameter);
		scoreFont = generator.generateFont(parameter);
		
		parameter.size = 32;
		parameter.borderWidth = 3;
		
		bigText = generator.generateFont(parameter);
	}

	private void initText() {
		averageReaction = "Average reaction \n";
		slowestReaction = "Slowest reaction \n";
		fastestReaction = "Fastest reaction \n";
		message = "Tap to retry";
		decoration = "__________________";
		averageScore = GameDotService.getAverageReaction()+ "ms";
		slowestScore = GameDotService.slowestReaction+ "ms";
		fastestScore = GameDotService.fastestReaction+ "ms";
	}


	

	private void drawScore() {
		spriteBatch.begin();
		textFont.draw(spriteBatch, averageReaction, 130, 600);
		textFont.draw(spriteBatch, fastestReaction, 130, 460);
		textFont.draw(spriteBatch, slowestReaction, 130, 320);		
		bigText.draw(spriteBatch, message, 140, 170);
		
		decorationFont.draw(spriteBatch, decoration, 130, 580);
		decorationFont.draw(spriteBatch, decoration, 130, 540);
		decorationFont.draw(spriteBatch, decoration, 130, 440);
		decorationFont.draw(spriteBatch, decoration, 130, 400);
		decorationFont.draw(spriteBatch, decoration, 130, 300);
		decorationFont.draw(spriteBatch, decoration, 130, 260);

		scoreFont.draw(spriteBatch, averageScore, 210, 550);
		scoreFont.draw(spriteBatch, fastestScore, 210, 410);
		scoreFont.draw(spriteBatch, slowestScore, 210, 270);
		spriteBatch.end();
	}

	
	@Override
	public void render(float delta) {
		super.render(delta);
		drawScore();
		
		if(Gdx.input.justTouched()) {
			screenTouched++;
			setScreen();
		}
		
	}
	
	private void setScreen() {
		if(screenTouched == 2) {
			resetReactionTimers();
			game.setScreen(new MenuScreen(game));
		}
	}
	
	private void resetReactionTimers() {
		GameDotService.timesRepeated = 0;
		GameDotService.averageReaction = 0;
		GameDotService.slowestReaction = 0;
		GameDotService.fastestReaction = 9999999;
	}
	
	@Override
	public void dispose() {
		generator.dispose();
	}
	
}
