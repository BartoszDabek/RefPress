package pl.devpress.refpress.screens;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

import pl.devpress.refpress.RefPress;
import pl.devpress.refpress.ui.PlayButton;
import pl.devpress.refpress.ui.SettingsButton;

public class MenuScreen extends AbstractScreen {
	
	
	private PlayButton playButton;
	private SettingsButton settingsButton;
	private Table table;
	
	public MenuScreen(RefPress game) {
		super(game);
	}

	@Override
	protected void init() {
		initPlayButton();		
		initSettingsButton();
		initTable();
		addElementToTable();

	}


	private void addElementToTable() {
		table.add(playButton).width(230).height(230).padBottom(50);
		table.row();
		table.add(settingsButton).width(200).height(200).padBottom(50);
	}

	private void initTable() {
		table = new Table();
		table.setFillParent(true);
		table.setDebug(true);
		stage.addActor(table);
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

	
}
