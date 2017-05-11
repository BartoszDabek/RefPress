package pl.devpress.refpress.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import pl.devpress.refpress.services.GameSoundServiceSingleton;

public class PlusButton extends Image {
	public static final String plusButtonImg = "plus.png";
	private final static int WIDHT = 150;
	private final static int HEIGHT = 150;
	private static Texture volumeUp;
	private GameSoundServiceSingleton gameSoundServiceSingleton;
	
	public PlusButton() {
		super(volumeUp = new Texture(plusButtonImg));

		this.setOrigin(WIDHT / 2, HEIGHT / 2);
		this.setSize(WIDHT, HEIGHT);	
		this.setPosition(setXAxis(), setYAxis());
		
		gameSoundServiceSingleton = GameSoundServiceSingleton.getInstance();
		reactOnClick();
	}
	
	public void dispose() {
		volumeUp.dispose();
	}
	
	private int setYAxis() {
		return 515;
	}
	
	private int setXAxis() {
		return 260;
	}
	
	private void reactOnClick() {
		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				gameSoundServiceSingleton.volumeUp();
				gameSoundServiceSingleton.play();
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
}
