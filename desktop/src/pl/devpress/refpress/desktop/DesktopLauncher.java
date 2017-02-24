package pl.devpress.refpress.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import pl.devpress.refpress.RefPress;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = RefPress.GAME_TITLE;
		config.width = RefPress.WIDTH;
		config.height = RefPress.HEIGHT;
		new LwjglApplication(new RefPress(), config);
	}
}
