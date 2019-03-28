package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends Game {
	SpriteBatch batch;
	//
	Assets assets;

	
	@Override
	public void create () {

		batch = new SpriteBatch();
		assets = new Assets();
		assets.load();

		setScreen(new LoadingScreen(this));


	}


}
