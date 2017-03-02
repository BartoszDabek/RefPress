package pl.devpress.refpress.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import pl.devpress.refpress.RefPress;

public abstract class AbstractScreen implements Screen {

	private OrthographicCamera camera;
	protected RefPress game;
	protected Stage stage;
	protected SpriteBatch spriteBatch;
	private Viewport viewport;
	
	
	public AbstractScreen(RefPress game) {
		this.game = game;
		createCamera();
		viewport = new FitViewport(RefPress.WIDTH, RefPress.HEIGHT, camera);
		stage = new Stage(viewport);
		spriteBatch = new SpriteBatch();
		Gdx.input.setInputProcessor(stage);
		init();
	}
	
	protected abstract void init();

	private void createCamera() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, RefPress.WIDTH, RefPress.HEIGHT);
		camera.update();
	}

	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		backgroundColor();
		camera.update();
		spriteBatch.setProjectionMatrix(camera.combined);
	}

	private void backgroundColor() {
		float gettingRGBColor = 255f;
		Gdx.gl.glClearColor(102/gettingRGBColor, 178/gettingRGBColor, 255/gettingRGBColor, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}


	@Override
	public void dispose() {
		game.dispose();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
		stage.getViewport().update(width, height);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}


}
