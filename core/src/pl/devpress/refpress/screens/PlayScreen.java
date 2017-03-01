package pl.devpress.refpress.screens;

import com.badlogic.gdx.graphics.Texture;

import pl.devpress.refpress.RefPress;

public class PlayScreen extends AbstractScreen {

	private Texture texture;
	
	public PlayScreen(RefPress game) {
		super(game);
	}

	@Override
	protected void init() {
		texture = new Texture("reddot.png");
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		spriteBatch.begin();
		spriteBatch.draw(texture, 0, 0);
		spriteBatch.end();
	}

}
