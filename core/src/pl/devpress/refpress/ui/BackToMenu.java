package pl.devpress.refpress.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import pl.devpress.refpress.RefPress;
import pl.devpress.refpress.screens.MenuScreen;

public class BackToMenu extends Image {
	public static final String playButtonImg = "back.png";
	private final static int WIDHT = 200;
	private final static int HEIGHT = 200;
	private static Texture backToMenu;
	private RefPress game;

	public BackToMenu(RefPress game) {
		super(backToMenu = new Texture(playButtonImg));
		
		this.setOrigin(WIDHT / 2, HEIGHT / 2);
		this.setSize(WIDHT, HEIGHT);	
		this.setPosition(setXAxis(), setYAxis());
		
		this.game = game;
		reactOnClick();
	}
	
	public void dispose() {
		backToMenu.dispose();
	}
	
	private int setYAxis() {
		return 150;
	}
	
	private int setXAxis() {
		return RefPress.WIDTH/2 - WIDHT/2;
	}
	
	private void reactOnClick() {
		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				game.setScreen(new MenuScreen(game));
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
}
