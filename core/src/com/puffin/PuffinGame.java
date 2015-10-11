package com.puffin;
import com.badlogic.gdx.Game;
public class PuffinGame extends Game {
	@Override
	public void create() {
		setScreen(new GameScreen());
	}
}
