package pl.devpress.refpress.screens;

import pl.devpress.refpress.RefPress;
import pl.devpress.refpress.ui.BackToMenu;
import pl.devpress.refpress.ui.MinusButton;
import pl.devpress.refpress.ui.PlusButton;

public class SettingsScreen extends AbstractScreen {

	private MinusButton soundDown;
	private PlusButton plusButton;
	private BackToMenu backToMenu;
	
	public SettingsScreen(RefPress game) {
		super(game);
	}

	@Override
	protected void init() {
		initSoundDown();
		initPlusButton();
		initBackToMenu();
		stage.addActor(soundDown);
		stage.addActor(plusButton);
		stage.addActor(backToMenu);
	}

	private void initBackToMenu() {
		backToMenu = new BackToMenu(game);
	}
	
	private void initPlusButton() {
		plusButton = new PlusButton();
	}


	private void initSoundDown() {
		soundDown = new MinusButton();
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
		soundDown.dispose();
		plusButton.dispose();
		backToMenu.dispose();
	}

}
