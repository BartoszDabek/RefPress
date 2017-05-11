package pl.devpress.refpress.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import pl.devpress.refpress.services.GameSoundServiceSingleton;

public class MinusButton extends Image {
	public static final String minusButtonImg = "minus2.png";
	private final static int WIDHT = 160;
	private final static int HEIGHT = 40;
	private static Texture volumeDown;
	private GameSoundServiceSingleton gameSoundServiceSingleton;
	
	public MinusButton() {
		super(volumeDown = new Texture(minusButtonImg));

		this.setOrigin(WIDHT / 2, HEIGHT / 2);
		this.setSize(WIDHT, HEIGHT);	
		this.setPosition(setXAxis(), setYAxis());
		
		gameSoundServiceSingleton = GameSoundServiceSingleton.getInstance();
		reactOnClick();
	}
	
	public void dispose() {
		volumeDown.dispose();
	}
	
	private int setYAxis() {
		return 570;
	}
	
	private int setXAxis() {
		return 70;
	}
	
	private void reactOnClick() {
		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				gameSoundServiceSingleton.volumeDown();
				gameSoundServiceSingleton.play();
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
}
