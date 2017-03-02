package pl.devpress.refpress.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class PlayButton extends Image {
	
	public static final String playButtonImg = "playbuttonx200.png";
	
	public PlayButton(final IClickCallBack callback) {
		super(new Texture(playButtonImg));
		
		init(callback);
	}

	private void init(final IClickCallBack callback) {
		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				callback.onClick();
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}


	
}
