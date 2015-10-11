package com.puffin;

import com.badlogic.gdx.physics.box2d.Body;
import com.puffin.RunnerUserData;

/**
 * Represents the Puffin object. Has fields to check whether puffin is currently
 * jumping
 */
public class Runner extends GameActor {


    private boolean jumping;

    /**
     * Creates a new Runner object. By default the runner is landed, or not jumping
     * @param body The body obejct which gives runner it's attributes
     */
    public Runner(Body body) {
        super(body);
    }

    @Override
    public RunnerUserData getUserData() {
        return (RunnerUserData) userData;
    }

    /**
     * Causes the runner to jump into the air and sets jumping field to
     *  false, iff jumping field is false (runner is not currently jumping)
     */
    public void jump() {

        if (!jumping) {
            body.applyLinearImpulse(getUserData().getJumpingLinearImpulse(), body.getWorldCenter(), true);
            jumping = true;
        }

    }

    /**
     * Sets the field attribute jumping to false
     */
    public void landed() {
        jumping = false;
    }
}