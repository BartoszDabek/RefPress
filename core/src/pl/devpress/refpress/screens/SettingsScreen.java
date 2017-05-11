package pl.devpress.refpress.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;

import pl.devpress.refpress.RefPress;
import pl.devpress.refpress.ui.BackToMenu;
import pl.devpress.refpress.ui.MuteSoundButton;
import pl.devpress.refpress.ui.MinusButton;
import pl.devpress.refpress.ui.PlusButton;

public class SettingsScreen extends AbstractScreen {

	private MinusButton soundDown;
	private PlusButton plusButton;
	private BackToMenu backToMenu;
	private MuteSoundButton checkBox;
	private FreeTypeFontGenerator generator;
	private FreeTypeFontParameter parameter;
	private BitmapFont textFont;
	private String text = "MUTE SOUND:";
	
	public SettingsScreen(RefPress game) {
		super(game);
	}

	@Override
	protected void init() {
		
		initSoundDown();
		initPlusButton();
		initBackToMenu();
		initCheckBox();
		stage.addActor(soundDown);
		stage.addActor(plusButton);
		stage.addActor(backToMenu);
		stage.addActor(checkBox);

		generator = new FreeTypeFontGenerator(Gdx.files.internal("OpenSans-ExtraBold.ttf"));
		parameter = new FreeTypeFontParameter();
		
		parameter.size = 34;
		parameter.borderColor = Color.BLACK;
		parameter.borderWidth = 2;
		
		textFont = generator.generateFont(parameter);
	}

	private void initCheckBox() {
		checkBox = new MuteSoundButton();
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
		textFont.draw(spriteBatch, text, 5, 425);	
		spriteBatch.end();
		
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
