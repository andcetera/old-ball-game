package com.andcetera.objects;

import com.andcetera.ballsgame.Assets;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;

public class Fireball {
	
	public final Sprite image1;
	public final Sprite image2;
	public final Circle bounds;
	public final Sound crackle;
	public final Sound shoot;
	public final Sound fizzle;
	
	public Fireball(float x, float y){
		image1 = Assets.fBall1;
		image2 = Assets.fBall2;
		bounds = new Circle(x, y, Assets.fBall1.getWidth()/2);
		crackle = Assets.fire;
		shoot = Assets.shoot;
		fizzle = Assets.fizzle;
		
	}

}
