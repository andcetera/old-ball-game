package com.andcetera.objects;

import com.andcetera.ballsgame.Assets;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class SmallBall {
	
	public final Sprite image;
	public final Circle bounds;
	public final Vector2 speed;
	public float speedMin;
	public final Sound bounce;
	public final Sound woosh;
	
	public SmallBall(float x, float y){
		image = Assets.smallBall;
		speedMin = 500;
		speed = new Vector2(0, 0);
		bounds = new Circle(x, y, Assets.ballTex.getWidth()/2);
		bounce = Assets.bounce;
		woosh = Assets.woosh;
	}
}
