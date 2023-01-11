package com.andcetera.objects;

import com.andcetera.ballsgame.Assets;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;

public class Prize {

	public final Sprite image;
	public final Circle bounds;
	public final Sound bling;
	public final Sound fall;
	
	public Prize(float x, float y){
		image = Assets.prize;
		bounds = new Circle(x, y, Assets.przTex.getWidth()/2);
		bling = Assets.bling;
		fall = Assets.fall;
	}
}
