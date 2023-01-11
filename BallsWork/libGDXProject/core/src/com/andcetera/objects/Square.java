package com.andcetera.objects;

import com.andcetera.ballsgame.Assets;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Square {
	
	public final Sprite image;
	public final Rectangle bounds;
	public final Sound hit;

	public Square(float x, float y){
		image = Assets.square;
		bounds = new Rectangle(x, y, Assets.sqTex.getWidth(), Assets.sqTex.getHeight());
		hit = Assets.block;
	}
}
