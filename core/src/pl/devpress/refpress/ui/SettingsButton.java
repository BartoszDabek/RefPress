package pl.devpress.refpress.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import pl.devpress.refpress.RefPress;

public class SettingsButton extends Image {
	
	public static final String settingsButtonImg = "settingsbutton.png";
	private RefPress game;
	
	public SettingsButton(RefPress game) {
		super(new Texture(settingsButtonImg));
		this.game = game;
		
		reactOnClick();
	}

	private void reactOnClick() {
		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				System.out.println("settings");
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
}
