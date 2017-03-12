package pl.devpress.refpress.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import pl.devpress.refpress.RefPress;

public class ScoreScreen extends AbstractScreen {

	private Texture texture;
	
	public ScoreScreen(RefPress game) {
		super(game);
		texture = new Texture("badlogic.jpg");
	}


	@Override
	protected void init() {
		System.out.println("Byles w scorescreenie");
	}

	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		if(Gdx.input.justTouched()) {
			game.setScreen(new MenuScreen(game));
		}
		
		spriteBatch.begin();
		spriteBatch.draw(texture, 0, 0);
		spriteBatch.end();
	}
	
}
