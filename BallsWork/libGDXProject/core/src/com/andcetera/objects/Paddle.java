package com.andcetera.objects;

import com.andcetera.ballsgame.Assets;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;

public class Paddle {
	
		public final Sprite image;
		public final Circle bounds;
		public final Sound hit;
		public final Sprite fLab;
		
		public Paddle(float x, float y){
			image = Assets.paddle;
			bounds = new Circle(x, y, Assets.paddTex.getWidth()/2);
			hit = Assets.thwack;
			fLab = Assets.fLabel;
		}

}
