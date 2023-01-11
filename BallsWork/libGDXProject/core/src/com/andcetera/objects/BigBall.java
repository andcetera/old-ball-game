package com.andcetera.objects;

import com.andcetera.ballsgame.Assets;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;

public class BigBall {
	
	public final Sprite image;
	public final Sprite hit1;
	public final Sprite hit2;
	public final Sprite hit3;
	public final Sprite hit4;
	public final Sprite hit5;
	public final Sprite hit6;
	public final Sprite fire1;
	public final Sprite fire2;
	public final Sprite fire3;
	public final Sprite fire4;
	public final Circle bounds;
	public final Sound hit;
	public final Sound burn;
	

	public BigBall(float x, float y){
		image = Assets.bigBall;
		hit1 = Assets.hit1;
		hit2 = Assets.hit2;
		hit3 = Assets.hit3;
		hit4 = Assets.hit4;
		hit5 = Assets.hit5;
		hit6 = Assets.hit6;
		fire1 = Assets.fire1;
		fire2 = Assets.fire2;
		fire3 = Assets.fire3;
		fire4 = Assets.fire4;
		bounds = new Circle(x, y, Assets.bigTex.getWidth()/2);
		hit = Assets.hit;
		burn = Assets.light;
	}
}
