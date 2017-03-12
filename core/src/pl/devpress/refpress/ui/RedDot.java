package pl.devpress.refpress.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class RedDot extends Image{

	public static final String redDotImg = "reddot.png";
	private final static int WIDHT = 50;
	private final static int HEIGHT = 50;
	
	public RedDot() {
		super(new Texture(redDotImg));
		
		this.setOrigin(WIDHT / 2, HEIGHT / 2);
		this.setSize(WIDHT, HEIGHT);	
		this.setPosition(getRandomXAxis(),getRandomYAxis());
		
	}

	private float getRandomYAxis() {
		//   0 - 650    Y Axis
		return MathUtils.random(0, 650);
	}
	
	private float getRandomXAxis() {
		//   0 - 430    X Axis
		return MathUtils.random(0, 430);
	}
}

