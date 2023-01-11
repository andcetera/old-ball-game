package com.andcetera.ballsgame.android;

import android.os.Bundle;

import com.andcetera.ballsgame.GameMain;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useGLSurfaceView20API18 = true;
		config.useCompass = false;
		config.useAccelerometer = true;
		config.useWakelock = true;
		initialize(new GameMain(), config);
	}
	
	//add back button check here?
}
