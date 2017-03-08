package pl.devpress.refpress.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import pl.devpress.refpress.RefPress;

public class RedDot extends Image{

	public static final String redDotImg = "reddot.png";
	private final static int WIDHT = 50;
	private final static int HEIGHT = 50;
	
	public RedDot() {
		super(new Texture(redDotImg));
		
		this.setOrigin(WIDHT / 2, HEIGHT / 2);
		this.setSize(WIDHT, HEIGHT);	
		this.setPosition(getHalfOfXAxis(),getHalfOfYAxis());
		
	}

	private float getHalfOfYAxis() {
		return (RefPress.HEIGHT/2) - (HEIGHT/2);
	}

	private float getHalfOfXAxis() {
		return (RefPress.WIDTH/2) - (WIDHT/2);
	}

	
}
