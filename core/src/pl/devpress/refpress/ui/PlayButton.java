package pl.devpress.refpress.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import pl.devpress.refpress.RefPress;
import pl.devpress.refpress.screens.PlayScreen;

public class PlayButton extends Image {
	
	public static final String playButtonImg = "playbuttonx200.png";
	private RefPress game;
	
	public PlayButton(RefPress game) {
		super(new Texture(playButtonImg));
		this.game = game;
		reactOnClick();
	}

	private void reactOnClick() {
		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				game.setScreen(new PlayScreen(game));
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}


	
}
