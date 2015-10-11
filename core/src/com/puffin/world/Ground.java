package com.puffin.world;

import com.badlogic.gdx.physics.box2d.Body;
import com.puffin.util.GameActor;

public class Ground extends GameActor {

    public float width;
    public float height;

    public Ground(Body body, float width, float height) {
        super(body);
        this.width = width;
        this.height = height;
    }

    @Override
    public GroundUserData getUserData() {
        return (GroundUserData) userData;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public void setHeight(float height) {
        this.height = height;
    }
}