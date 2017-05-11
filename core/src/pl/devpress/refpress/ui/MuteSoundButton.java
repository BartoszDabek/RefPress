package pl.devpress.refpress.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import pl.devpress.refpress.services.GameSoundServiceSingleton;

public class MuteSoundButton extends Button {

	private static final String checkBoxImg = "checkBox.atlas";
	private GameSoundServiceSingleton gameSoundServiceSingleton;
    private static ButtonStyle buttonStyle = new ButtonStyle();
    private boolean checkOrNot = false;

    public MuteSoundButton() {
    	super(prepareButtonStyle());
        
        init();
        reactOnClick();
    }

	private void reactOnClick() {
		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				if(checkOrNot){
					gameSoundServiceSingleton.unMute();
					checkOrNot = false;
				} else {
					gameSoundServiceSingleton.mute();
					checkOrNot = true;
				}
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}

	private void init() {
		gameSoundServiceSingleton = GameSoundServiceSingleton.getInstance();
		
		this.setSize(150, 150);
		this.setX(260);
		this.setY(340);
	}
    
	private static ButtonStyle prepareButtonStyle() {
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(checkBoxImg));
		Skin skin = new Skin(atlas);
		buttonStyle.up = skin.getDrawable("checkBoxUnchecked");
		buttonStyle.checked = skin.getDrawable("checkBoxChecked");
		
		return buttonStyle;
	}



}
