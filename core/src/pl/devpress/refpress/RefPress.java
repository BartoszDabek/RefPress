package pl.devpress.refpress;

import com.badlogic.gdx.Game;

import pl.devpress.refpress.screens.MenuScreen;

public class RefPress extends Game {
	
	public static final String GAME_TITLE = "Reflex";
	public static final int WIDTH = 480;
	public static final int HEIGHT = 700;

	@Override
	public void create () {
		this.setScreen(new MenuScreen(this));
	}
	
}
