package com.puffin;
import com.badlogic.gdx.Game;
import com.puffin.view.MainMenu;

public class PuffinGame extends Game {
	@Override
	public void create() {
		//setScreen(new GameScreen());
		setScreen(new MainMenu(this));
	}
}
