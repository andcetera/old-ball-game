package com.andcetera.screens;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.andcetera.ballsgame.Assets;
import com.andcetera.ballsgame.GameMain;
import com.andcetera.tween.ActorAccessor;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.FloatAction;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class GameEndScreen implements Screen {
	
	//give points for balls, save high score?
	//open lose screen w/some animations, etc
	
	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table t;
	private TextButton menu;
	private Label gOver, score, scoreLab;
	
	private SpriteBatch batch;
	private Sprite bkgnd;
	private float w, h;
	private long show;
	private BitmapFont levelFont, scoreFont;
	private TweenManager mngr;
	private BitmapFont buttonFont;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(show < GameMain.SCORE){
			show += GameMain.SCORE/137;
		} else {
			show = GameMain.SCORE;
			menu.addAction(Actions.fadeIn(0.5f));
		}
		score.setText("" + show);
		score.invalidate();

		batch.begin();
		bkgnd.draw(batch);
		batch.end();
		
		mngr.update(delta);
		stage.act();
		stage.draw();
	}

	@Override
	public void show() {
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		show = 0;
		batch = new SpriteBatch();
		bkgnd = Assets.background;
		bkgnd.flip(false, true);
		bkgnd.setBounds(0, 0, w, h);	
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		atlas = new TextureAtlas("ui/menu.txt");
		skin = new Skin(atlas);
		t = new Table();
		t.setBounds(0, 0, w, h);
		
		mngr = new TweenManager();
		Tween.registerAccessor(Actor.class, new ActorAccessor());
		
		levelFont = new BitmapFont(Gdx.files.internal("fonts/balls.fnt"), Gdx.files.internal("fonts/balls.png"), false);
		levelFont.setScale(w/400f);
		scoreFont = new BitmapFont(Gdx.files.internal("fonts/score.fnt"), Gdx.files.internal("fonts/score.png"), false);
		scoreFont.setScale(1.2f);
		buttonFont = new BitmapFont(Gdx.files.internal("fonts/score.fnt"), Gdx.files.internal("fonts/score.png"), false);
		buttonFont.setScale(w * 0.001f);
		
		TextButtonStyle s = new TextButtonStyle();
		s.up = skin.getDrawable("button-up");
		s.down = skin.getDrawable("button-down");
		s.pressedOffsetX = 1;
		s.pressedOffsetY = -1;
		s.font = buttonFont;
		LabelStyle l = new LabelStyle();
		l.font = scoreFont;
		l.fontColor = Color.YELLOW;
		LabelStyle l2 = new LabelStyle();
		l2.font = levelFont;

		gOver = new Label("GAME\nOVER", l2);
		scoreLab = new Label("FINAL SCORE:", l);
		score = new Label("" + show, l);
		menu = new TextButton("Main\nMenu", s);
		menu.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				GameScreen.gameStarted = false;
				((Game) Gdx.app.getApplicationListener()).setScreen(GameMain.menu);
			}
		});
		
		t.add(gOver).row();
		t.add(scoreLab).row();
		t.add(score).row();
		t.getCell(score).spaceBottom(h/8);
		t.add(menu).size(w/3f, h/8f);
		
		stage.addActor(t);
		
		Timeline.createParallel().beginParallel()
		.push(Tween.set(gOver, ActorAccessor.ALPHA).target(0))
		.push(Tween.set(scoreLab, ActorAccessor.ALPHA).target(0))
		.push(Tween.set(score, ActorAccessor.ALPHA).target(0))
		.push(Tween.set(menu, ActorAccessor.ALPHA).target(0))
		.end().start(mngr);
		
	Timeline.createSequence().beginSequence()
		.push(Tween.to(gOver, ActorAccessor.ALPHA, 0.5f).target(1))
		.push(Tween.to(scoreLab, ActorAccessor.ALPHA, 0.5f).target(1))
		.push(Tween.to(score, ActorAccessor.ALPHA, 0.5f).target(1))
		.end().start(mngr);
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}
	
	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void dispose() {
		if(bkgnd != null) bkgnd.getTexture().dispose();
		if(batch != null) batch.dispose();
		if(scoreFont != null) scoreFont.dispose();
		if(levelFont != null) levelFont.dispose();
		if(menu != null) menu.clearListeners();
	}
}
