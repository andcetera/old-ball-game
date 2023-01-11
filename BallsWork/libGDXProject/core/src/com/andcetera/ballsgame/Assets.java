package com.andcetera.ballsgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class Assets {

	public static Sound bounce, block, thwack, hit, woosh, bling, fire, shoot, light, win, lose, fall, fizzle;
	
	//Background
	public static Texture backTex;
	public static Sprite background;
	//Objects
	public static Texture ballTex, paddTex, sqTex;
	public static Sprite smallBall, paddle, square;
	//Big Ball
	public static Texture bigTex;
	public static Sprite bigBall, hit1, hit2, hit3, hit4, hit5, hit6, fire1, fire2, fire3, fire4;
	//Extras
	public static Texture przTex, fb1Tex, fLabTex;
	public static Sprite prize, fBall1, fBall2, fLabel;
	

	public static void load() {
		//Background
		backTex = new Texture(Gdx.files.internal("images/background.png"));
		backTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		background = new Sprite(backTex);
		background.flip(false, true);
		//Objects
		ballTex = new Texture(Gdx.files.internal("images/small_ball.png"));
		smallBall = new Sprite(ballTex);
		paddTex = new Texture(Gdx.files.internal("images/paddle.png"));
		paddle = new Sprite(paddTex);
		paddle.flip(false, true);
		sqTex = new Texture(Gdx.files.internal("images/square1.jpg"));
		square = new Sprite(sqTex);
		square.flip(false, true);
		//Big Ball
		bigTex = new Texture(Gdx.files.internal("images/bigBall/full_ball.png"));
		bigBall = new Sprite(bigTex);
		bigBall.flip(false, true);
		hit1 = new Sprite(new Texture(Gdx.files.internal("images/bigBall/hit1.png")));
		hit1.flip(false, true);
		hit2 = new Sprite(new Texture(Gdx.files.internal("images/bigBall/hit2.png")));
		hit2.flip(false, true);
		hit3 = new Sprite(new Texture(Gdx.files.internal("images/bigBall/hit3.png")));
		hit3.flip(false, true);
		hit4 = new Sprite(new Texture(Gdx.files.internal("images/bigBall/hit4.png")));
		hit4.flip(false, true);
		hit5 = new Sprite(new Texture(Gdx.files.internal("images/bigBall/hit5.png")));
		hit5.flip(false, true);
		hit6 = new Sprite(new Texture(Gdx.files.internal("images/bigBall/hit6.png")));
		hit6.flip(false, true);
		fire1 = new Sprite(new Texture(Gdx.files.internal("images/bigBall/fire1.png")));
		fire1.flip(false, true);
		fire2 = new Sprite(new Texture(Gdx.files.internal("images/bigBall/fire2.png")));
		fire2.flip(false, true);
		fire3 = new Sprite(new Texture(Gdx.files.internal("images/bigBall/fire3.png")));
		fire3.flip(false, true);
		fire4 = new Sprite(new Texture(Gdx.files.internal("images/bigBall/fire4.png")));
		fire4.flip(false, true);
		//Extras
		przTex = new Texture(Gdx.files.internal("images/prize.png"));
		prize = new Sprite(przTex);
		fb1Tex = new Texture(Gdx.files.internal("images/fireball1a.png"));
		fBall1 = new Sprite(fb1Tex);
		fBall1.flip(false, true);
		fBall2 = new Sprite(new Texture(Gdx.files.internal("images/fireball1.png")));
		fBall2.flip(false, true);
		fLabTex = new Texture(Gdx.files.internal("images/fireballa.png"));
		fLabel = new Sprite(fLabTex);
		
		//Sounds
		bounce = Gdx.audio.newSound(Gdx.files.internal("sounds/drip.ogg"));
		block = Gdx.audio.newSound(Gdx.files.internal("sounds/thump.ogg"));
		thwack = Gdx.audio.newSound(Gdx.files.internal("sounds/thwack.ogg"));
		hit = Gdx.audio.newSound(Gdx.files.internal("sounds/bassvib.ogg"));
		woosh = Gdx.audio.newSound(Gdx.files.internal("sounds/echowoosh.ogg"));
		bling = Gdx.audio.newSound(Gdx.files.internal("sounds/xyl.ogg"));
		fire = Gdx.audio.newSound(Gdx.files.internal("sounds/bassvib2.ogg"));
		shoot = Gdx.audio.newSound(Gdx.files.internal("sounds/shoot.ogg"));
		light = Gdx.audio.newSound(Gdx.files.internal("sounds/flame.ogg"));
		win = Gdx.audio.newSound(Gdx.files.internal("sounds/major.ogg"));
		lose = Gdx.audio.newSound(Gdx.files.internal("sounds/beeohh.ogg"));
		fall = Gdx.audio.newSound(Gdx.files.internal("sounds/fail.ogg"));
		fizzle = Gdx.audio.newSound(Gdx.files.internal("sounds/crackle.ogg"));
		
	}
	
	public static void disposeAll(){
		bounce.dispose();
		block.dispose();
		thwack.dispose();
		hit.dispose();
		woosh.dispose();
		bling.dispose();
		fire.dispose();
		shoot.dispose();
		light.dispose();
		win.dispose();
		lose.dispose();
		fall.dispose();
		fizzle.dispose();
	
		backTex.dispose();
		ballTex.dispose();
		paddTex.dispose();
		sqTex.dispose();
		bigTex.dispose();
		hit1.getTexture().dispose();
		hit2.getTexture().dispose();
		hit3.getTexture().dispose();
		hit4.getTexture().dispose();
		hit5.getTexture().dispose();
		hit6.getTexture().dispose();
		fire1.getTexture().dispose();
		fire2.getTexture().dispose();
		fire3.getTexture().dispose();
		fire4.getTexture().dispose();
		przTex.dispose();
		fb1Tex.dispose();
		fBall2.getTexture().dispose();
		fLabTex.dispose();
	}
}
