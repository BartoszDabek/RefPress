package pl.devpress.refpress.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

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
		playButton = new PlayButton();
		settingsButton = new SettingsButton();
		playButton.addListener(new ClickListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				
				game.setScreen(new PlayScreen(game));
				dispose();
				
				return super.touchDown(event, x, y, pointer, button);
			}
			
		});
		
		
		table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
	//	table.setDebug(true);
		table.add(playButton).width(230).height(230).pad(30);
		table.top().padTop(50);
		table.row();
		table.add(settingsButton).width(200).height(200).pad(30);
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

	
}
