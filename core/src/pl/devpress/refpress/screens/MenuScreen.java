package pl.devpress.refpress.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import pl.devpress.refpress.RefPress;

public class MenuScreen extends AbstractScreen {
	
	private final String playButtonImg = "playbutton.png";
	
	private Texture playButton;
	
	public MenuScreen(RefPress game) {
		super(game);
		playButton = new Texture(playButtonImg);
		
	}

	@Override
	protected void init() {
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		
		if(Gdx.input.justTouched()) {
			game.setScreen(new PlayScreen(game));
			dispose();
		}
		
		spriteBatch.begin();
		spriteBatch.draw(playButton, getHalfOfXAxis(), getHalfOfYAxis());
		spriteBatch.end();
	}
	
	
	
	private float getHalfOfYAxis() {
		return (RefPress.HEIGHT/2) - (playButton.getHeight()/2);
	}

	private float getHalfOfXAxis() {
		return (RefPress.WIDTH/2) - (playButton.getWidth()/2);
	}
	
}
