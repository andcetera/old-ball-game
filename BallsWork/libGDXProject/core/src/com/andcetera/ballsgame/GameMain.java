package com.andcetera.ballsgame;

import com.andcetera.screens.GameEndScreen;
import com.andcetera.screens.GameScreen;
import com.andcetera.screens.MainMenuScreen;
import com.andcetera.screens.SplashScreen;
import com.badlogic.gdx.Game;

public class GameMain extends Game {
	//ApplicationListener does not support multiple screens
	//Game implements Applistener for us
	
	public SplashScreen splash;
	public static GameMain game;
	public static GameScreen game_screen;
	public static MainMenuScreen menu;
	public static GameEndScreen end;
	public static int VOLUME, SENSE;
	public static long SCORE;
	public static String sound;
	
	@Override
	public void create () {
		//Gdx.app.log(tag, message);
		Assets.load();
		VOLUME = 1;
		//SCORE = 15031;//?
		sound = "ON";
		if(SENSE == 0){
			SENSE = 500;
		}
		//create camera & batch here instead?
		game = this;
		splash = new SplashScreen();
		menu = new MainMenuScreen();
		game_screen = new GameScreen(this);
		end = new GameEndScreen();
		setScreen(splash);
		
	}
	
	public void render(){
		//game state manager here?
		super.render();//must have for multiple screens!
	}
	
	public static void mute(){
		VOLUME = 0;
	}
	public static void soundOn(){
		VOLUME = 1;
	}
	
	@Override
	public void dispose() {
		GameScreen.gameStarted = false;
		game_screen.dispose();
		menu.dispose();
		end.dispose();
	}
}
