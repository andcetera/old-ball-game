package com.andcetera.screens;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.andcetera.ballsgame.GameMain;
import com.andcetera.tween.ActorAccessor;
import com.andcetera.tween.TableAccessor;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainMenuScreen implements Screen {
	
	//TO DO:
	//Save top score/level, option to load saved game (level, score, FBs, etc only)
	
	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table, table2;
	
	private TextButton buttonExit, buttonPlay, buttonResume, buttonOptions, back;
	private ImageButton sound;//or button group vib/sound/off - separate music & sound
	private Slider sensitivity;
	private BitmapFont balls, buttons, white, big;
	private Label heading, heading2, soundFX, accel;	
	
	private TweenManager mngr;
	private SpriteBatch batch;
	private Sprite bkgnd;
	private float w;
	private float h;
		
	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		bkgnd.draw(batch);
		batch.end();
		
		mngr.update(delta);
		stage.act(delta);//update
		stage.draw();
		
		if(Gdx.input.isKeyJustPressed(Keys.BACK)){
			Gdx.app.exit();
		}
	}
	
	@Override
	public void show() {
		
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		bkgnd = new Sprite(new Texture(Gdx.files.internal("images/background.png")));
		bkgnd.setBounds(0, 0, w, h);

		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		atlas = new TextureAtlas("ui/menu.txt");
		skin = new Skin(atlas);
		//skin = new Skin(Gdx.files.internal("ui/menuSkin.json"), atlas);
		table = new Table();//had skin in here but seems ok w/out
		table.setBounds(0, 0, w, h);
		table2 = new Table(skin);
		table2.setBounds(0, -h, w, h);
		
		mngr = new TweenManager();
		Tween.registerAccessor(Actor.class, new ActorAccessor());
		Tween.registerAccessor(Table.class, new TableAccessor());

		//Menu Fonts
		balls = new BitmapFont(Gdx.files.internal("fonts/balls.fnt"), Gdx.files.internal("fonts/balls.png"), false);
		buttons = new BitmapFont(Gdx.files.internal("fonts/menu.fnt"), Gdx.files.internal("fonts/menu.png"), false);
		buttons.setScale(w * 0.001f);
		//Options Fonts
		white = new BitmapFont(Gdx.files.internal("fonts/score.fnt"), Gdx.files.internal("fonts/score.png"), false);
		white.setScale(w * 0.001f);
		big = new BitmapFont(Gdx.files.internal("fonts/score.fnt"), Gdx.files.internal("fonts/score.png"), false);
		big.setScale(w * 0.003f);
		
		
		//JSON!!
		
		//Menu Styles
		TextButtonStyle bStyle = new TextButtonStyle();
		bStyle.up = skin.getDrawable("button-up");
		bStyle.down = skin.getDrawable("button-down");
		bStyle.disabled = skin.getDrawable("button-disabled");
		bStyle.pressedOffsetX = 1;
		bStyle.pressedOffsetY = -1;
		bStyle.font = buttons;
		LabelStyle lStyle = new LabelStyle();
		lStyle.font = balls;

		//Options Styles
		TextButtonStyle button = new TextButtonStyle();
		button.up = skin.getDrawable("button-up");
		button.down = skin.getDrawable("button-down");
		button.pressedOffsetX = 1;
		button.pressedOffsetY = -1;
		button.font = white;
		ImageButtonStyle iStyle = new ImageButtonStyle();
		iStyle.up = skin.getDrawable("sound");
		iStyle.checked = skin.getDrawable("mute");
		LabelStyle label = new LabelStyle();
		label.font = white;
		LabelStyle label2 = new LabelStyle();
		label2.font = big;
		SliderStyle sStyle = new SliderStyle();
		sStyle.background = skin.getDrawable("slider");
		sStyle.knob = skin.getDrawable("knob");
		
		//Main Menu Buttons
		heading = new Label("BALLS!", lStyle);
		heading.setFontScale((float) w/280 * 0.8f);
		
		buttonPlay = new TextButton("New Game", bStyle);
		buttonPlay.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				GameMain.game_screen = new GameScreen(GameMain.game);
				((Game) Gdx.app.getApplicationListener()).setScreen(GameMain.game_screen);
			}
		});
				
		buttonResume = new TextButton("Resume", bStyle);
		if(GameScreen.gameStarted){
			buttonResume.setDisabled(false);
			buttonResume.addListener(new ClickListener(){
				@Override
				public void clicked(InputEvent event, float x, float y) {
					((Game) Gdx.app.getApplicationListener()).setScreen(GameMain.game_screen);
				}
			});
		} else {
			buttonResume.setDisabled(true);
		}
				
		buttonOptions = new TextButton("Options", bStyle);
		buttonOptions.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {				
				Timeline.createParallel().beginParallel()
				.push(Tween.to(table, TableAccessor.Y, 1.2f).target(h))
				.push(Tween.to(table2, TableAccessor.Y, 1.2f).target(0))
				.end().start(mngr);
			}
		});
		
		buttonExit = new TextButton("Exit", bStyle);
		buttonExit.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});
		
		//Options Menu Buttons
		heading2 = new Label("Options", label2);
		soundFX = new Label("Sound: " + GameMain.sound, label);
		accel = new Label("Accelerometer Sensitivity: " + GameMain.SENSE, label);
		
		sound = new ImageButton(iStyle);
		sound.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(sound.isChecked()){
					GameMain.mute();
					GameMain.sound = "OFF";
					soundFX.setText("Sound: " + GameMain.sound);
				} else {
					GameMain.soundOn();
					GameMain.sound = "ON";
					soundFX.setText("Sound: " + GameMain.sound);
				}
				soundFX.invalidate();
			}
		});
		if(GameMain.sound == "OFF"){
			sound.setChecked(true);
		} else {
			sound.setChecked(false);
		}
		
		sensitivity = new Slider(200, 800, 20, false, sStyle);
		sensitivity.setValue(GameMain.SENSE);
		sensitivity.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Slider slider = (Slider) actor;
				float value = slider.getValue();
				GameMain.SENSE = (int) value;
				accel.setText("Accelerometer Sensitivity: " + GameMain.SENSE);
				accel.invalidate();
			}
		});
		
		back = new TextButton("Back to\nMain Menu", button);
		back.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {				
				Timeline.createParallel().beginParallel()
				.push(Tween.to(table, TableAccessor.Y, 1.2f).target(0))
				.push(Tween.to(table2, TableAccessor.Y, 1.2f).target(-h))
				.end().start(mngr);
			}
		});
		
		//Menu Table
		table.add(heading).row();
		table.getCell(heading).spaceBottom(h/10f);
		table.add(buttonPlay).size(w * 0.6f, h/12f).row();
		table.getCell(buttonPlay).spaceBottom(h/40f);
		table.add(buttonResume).size(w * 0.6f, h/12f).row();
		table.getCell(buttonResume).spaceBottom(h/40f);
		table.add(buttonOptions).size(w * 0.6f, h/12f).row();
		table.getCell(buttonOptions).spaceBottom(h/40f);
		table.add(buttonExit).size(w * 0.6f, h/12f);
		//table.debug();//for red lines
		
		table.align(Align.top).pad(h/6);
		stage.addActor(table);
		
		//Options Table
		table2.add(heading2).row();
		table2.getCell(heading2).spaceBottom(h/20f);
		table2.add(soundFX).row();
		table2.add(sound).row();
		table2.getCell(sound).spaceBottom(h/20f);
		table2.add(accel).row();
		table2.add(sensitivity).fill().colspan(3).row();
		table2.getCell(sensitivity).spaceBottom(h/20f);
		table2.add(back).size(w/3f, h/8f);
		
		stage.addActor(table2);
				
		//Main animation
		Timeline.createParallel().beginParallel()
			.push(Tween.set(buttonPlay, ActorAccessor.ALPHA).target(0))
			.push(Tween.set(buttonResume, ActorAccessor.ALPHA).target(0))
			.push(Tween.set(buttonOptions, ActorAccessor.ALPHA).target(0))
			.push(Tween.set(buttonExit, ActorAccessor.ALPHA).target(0))
			.end().start(mngr);
			
		Timeline.createSequence().beginSequence()
			.push(Tween.from(table, ActorAccessor.Y, 1.2f).target(h))
			.push(Tween.to(buttonPlay, ActorAccessor.ALPHA, 0.5f).target(1))
			.push(Tween.to(buttonResume, ActorAccessor.ALPHA, 0.5f).target(1))
			.push(Tween.to(buttonOptions, ActorAccessor.ALPHA, 0.5f).target(1))
			.push(Tween.to(buttonExit, ActorAccessor.ALPHA, 0.5f).target(1))
			.end().start(mngr);
	
}

	@Override
	public void hide() {
		buttonPlay.clearListeners();
		buttonExit.clearListeners();
		buttonResume.clearListeners();
		buttonOptions.clearListeners();
		sound.clearListeners();
		sensitivity.clearListeners();
		back.clearListeners();
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		stage.dispose();
		skin.dispose();
		atlas.dispose();
		balls.dispose();
		table.clear();
		batch.dispose();
		bkgnd.getTexture().dispose();
		white.dispose();
		big.dispose();
		table2.clear();
	}
	
	@Override
	public void resize(int width, int height) {//for resizing window...
		//stage.getViewport().update(width, height, true);//center camera
		//table.invalidateHierarchy();
		//table.setSize(width, height);
	}

}
