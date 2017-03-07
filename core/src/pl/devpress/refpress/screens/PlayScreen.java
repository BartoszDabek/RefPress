package pl.devpress.refpress.screens;

import pl.devpress.refpress.RefPress;
import pl.devpress.refpress.ui.RedDot;

public class PlayScreen extends AbstractScreen {

	private RedDot redDot;
	
	public PlayScreen(RefPress game) {
		super(game);
	}

	@Override
	protected void init() {
			initRedDot();
	}
	


	private void initRedDot() {
		redDot = new RedDot(stage);
		stage.addActor(redDot);
		stage.setDebugAll(true);
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

}
