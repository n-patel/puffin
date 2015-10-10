package com.puffin;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;
import com.puffin.GameScreen;
public class PuffinGame extends Game {


	@Override
	public void create() {
		setScreen(new GameScreen());

	}
}
