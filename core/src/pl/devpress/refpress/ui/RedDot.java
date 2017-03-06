package pl.devpress.refpress.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import pl.devpress.refpress.RefPress;

public class RedDot extends Image{

	public static final String redDotImg = "reddot.png";
	private RefPress game;
	
	public RedDot(RefPress game) {
		super(new Texture(redDotImg));
		this.game = game;
		reactOnClick();
	}

	private void reactOnClick() {
		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				RedDot.this.remove();
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
}
