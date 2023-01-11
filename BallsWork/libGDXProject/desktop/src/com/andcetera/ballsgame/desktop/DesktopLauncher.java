package com.andcetera.ballsgame.desktop;

import com.andcetera.ballsgame.GameMain;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Balls!";
		config.useGL30 = false;
		config.width = 488;
		config.height = 800;
		
		new LwjglApplication(new GameMain(), config);		
	}
}
