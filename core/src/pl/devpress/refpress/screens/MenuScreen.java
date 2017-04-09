package pl.devpress.refpress.screens;

import pl.devpress.refpress.RefPress;
import pl.devpress.refpress.ui.PlayButton;
import pl.devpress.refpress.ui.SettingsButton;

public class MenuScreen extends AbstractScreen {
	
	
	private PlayButton playButton;
	private SettingsButton settingsButton;
	public MenuScreen(RefPress game) {
		super(game);
	}

	@Override
	protected void init() {
		initPlayButton();		
		initSettingsButton();
		stage.setDebugAll(true);
		stage.addActor(playButton);
		stage.addActor(settingsButton);
	}

	private void initSettingsButton() {
		settingsButton = new SettingsButton(game);
	}
	
	private void initPlayButton() {
		playButton = new PlayButton(game);
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
		playButton.dispose();
	}

}
