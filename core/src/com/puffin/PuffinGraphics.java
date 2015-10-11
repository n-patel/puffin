package com.puffin;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Jessie on 10/10/2015.
 */


public class PuffinGraphics implements ApplicationListener {
    public SpriteBatch batch;
    public Texture texture;
    public Sprite sprite;

    public void create() {
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("android/assets/puffin-running-1.png"));
        sprite = new Sprite(texture);
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        sprite.draw(batch);
        batch.end();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }
}
