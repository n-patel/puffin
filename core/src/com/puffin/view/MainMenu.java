package com.puffin.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.puffin.GameScreen;

/**
 * Created by Nikhil on 10/11/15.
 */
public class MainMenu implements Screen {

    private Game game;
    private SpriteBatch spriteBatch;
    private Sprite splashScreen;

    public MainMenu(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        splashScreen = new Sprite(new Texture("background1.png"));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        splashScreen.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        splashScreen.draw(spriteBatch);;
        spriteBatch.end();

        if (Gdx.input.justTouched()) {
            game.setScreen(new GameScreen());
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
