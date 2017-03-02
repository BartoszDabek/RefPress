package pl.devpress.refpress.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class SettingsButton extends Image {
	
	public static final String settingsButtonImg = "settingsbutton.png";

	public SettingsButton() {
		super(new Texture(settingsButtonImg));
	}
}
