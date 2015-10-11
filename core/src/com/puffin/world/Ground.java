package com.puffin.world;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.puffin.util.Constants;
import com.puffin.util.GameActor;
import com.puffin.util.WorldUtils;

public class Ground extends GameActor {

    public float width;
    public float height;
    public float xPos;

    public Ground(World world, float width, float height, float xPos) {
        super(WorldUtils.createGround(world, width , height, xPos));

        this.width =  width ;
        this.height = height ;
        this.xPos = xPos;

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