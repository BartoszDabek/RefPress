package pl.devpress.refpress.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import pl.devpress.refpress.RefPress;

public class CheckBox {
    private static final String checkBoxImg = "checkBox.atlas";
    private TextureAtlas textureAtlas;
    private TextureRegion textureRegion;
    private RefPress game;

    public CheckBox(RefPress game) {
        textureAtlas = new TextureAtlas(Gdx.files.internal(checkBoxImg));
        textureRegion = textureAtlas.findRegion("checkBoxChecked");

        this.game = game;
    }



}
