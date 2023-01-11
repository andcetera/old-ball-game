package com.andcetera.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

import com.andcetera.ballsgame.GameMain;
import com.andcetera.tween.SpriteAccessor;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SplashScreen implements Screen {

	private SpriteBatch batch;
	private Sprite splash;
	private TweenManager mngr;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		mngr.update(delta);

		batch.begin();
		splash.draw(batch);
		batch.end();
	}

	@Override
	public void show() {
		// This is where we set the variables instead of constructor
		batch = new SpriteBatch();
		mngr = new TweenManager();
		Tween.registerAccessor(Sprite.class, new SpriteAccessor());

		// Texture has constructor that can get image from string rather than
		// Gdx.files.internal stuff
		Texture splashTex = new Texture("images/logo.png");
		splash = new Sprite(splashTex);
		splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		// ok to leave start() blank also
		Tween.set(splash, SpriteAccessor.ALPHA).target(0).start(mngr);// from transparent
		Tween.to(splash, SpriteAccessor.ALPHA, 2).target(1).repeatYoyo(1, 2).setCallback(new TweenCallback() {
			
			@Override
			public void onEvent(int type, BaseTween<?> source) {
				((Game) Gdx.app.getApplicationListener()).setScreen(GameMain.menu);
			}
		}).start(mngr);// to opaque in 3 seconds (and back)
		//repeatYoyo(how many times, delay) does reverse of "to" animation & length
		//callback lets us know when done so we can open new screen at that time
		//Tween.to(splash, SpriteAccessor.ALPHA, 2).target(0).delay(4).start(mngr);// fade back out after delay
		//for some reason fade out seems to go much slower than fade in...
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
	public void dispose() {
		batch.dispose();
		splash.getTexture().dispose();//unless using elsewhere
	}

	@Override
	public void resize(int width, int height) {

	}

}
