package pl.devpress.refpress.screens;

import com.badlogic.gdx.scenes.scene2d.Stage;

import pl.devpress.refpress.RefPress;
import pl.devpress.refpress.services.GameDotService;

public class PlayScreen extends AbstractScreen {

	private GameDotService gameDotService;
	
	public PlayScreen(RefPress game) {
		super(game);
	}

	@Override
	protected void init() {
		stage.setDebugAll(true);
		initGameDotService(stage, game);
	}
	

	private void initGameDotService(Stage stage, RefPress game) {
		gameDotService = new GameDotService(stage, game);
	}


	@Override
	public void render(float delta) {
		super.render(delta);
		
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}
	
	@Override
	public void dispose() {
		gameDotService.dispose();
	}

}
