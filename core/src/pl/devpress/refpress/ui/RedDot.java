package pl.devpress.refpress.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import pl.devpress.refpress.RefPress;

public class RedDot extends Image{

	public static final String redDotImg = "reddot.png";
	private final static int WIDHT = 50;
	private final static int HEIGHT = 50;
	
	public RedDot(Stage stage) {
		super(new Texture(redDotImg));
		
		this.setOrigin(WIDHT / 2, HEIGHT / 2);
		this.setSize(WIDHT, HEIGHT);	
		this.setPosition(getHalfOfXAxis(),getHalfOfYAxis());
		
		
		reactOnClick(stage);
	}

	private void reactOnClick(final Stage stage) {
		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				System.out.println("click");
				RedDot redDot = new RedDot(stage);
				stage.addActor(redDot);
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}

	private float getHalfOfYAxis() {
		return (RefPress.HEIGHT/2) - (HEIGHT/2);
	}

	private float getHalfOfXAxis() {
		return (RefPress.WIDTH/2) - (WIDHT/2);
	}

	
}
