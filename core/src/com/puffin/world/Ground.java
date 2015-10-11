package com.puffin.world;

import com.badlogic.gdx.physics.box2d.Body;
import com.puffin.util.GameActor;

public class Ground extends GameActor {

    public Ground(Body body) {
        super(body);
    }

    @Override
    public com.puffin.world.GroundUserData getUserData() {
        return (com.puffin.world.GroundUserData) userData;
    }
}