package pl.devpress.refpress.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import pl.devpress.refpress.RefPress;
import pl.devpress.refpress.ui.RedDot;

public class PlayScreen extends AbstractScreen {

	private RedDot redDot;
	private Table table;
	
	public PlayScreen(RefPress game) {
		super(game);
	}

	@Override
	protected void init() {
		initRedDot();
		initTable();
		addElementToTable();
	}
	
	private void addElementToTable() {
		table.add(redDot);
	}

	private void initTable() {
		table = new Table();
		table.setFillParent(true);
		table.setDebug(true);
		stage.addActor(table);
	}

	private void initRedDot() {
		redDot = new RedDot(game);
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

}
