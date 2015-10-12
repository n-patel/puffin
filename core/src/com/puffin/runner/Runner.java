package com.puffin.runner;

import com.badlogic.gdx.physics.box2d.Body;
import com.puffin.util.GameActor;

/**
 * Represents the Puffin object. Has fields to check whether puffin is currently
 * jumping
 */
public class Runner extends GameActor {
    private boolean jumping;
    private boolean dblJump;

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
        if (!jumping) { // CHANGE TO dblJump FOR DOUBLE JUMP CAPABILITIES
            body.applyLinearImpulse(getUserData().getJumpingLinearImpulse(), body.getWorldCenter(), true);
            if(jumping){
                dblJump = true;
            }
            jumping = true;
        }
    }

    /**
     * Returns if the runner is jumping or not
     */
    public boolean isJumping() {
        return jumping;
    }

    /**
     * Sets the field attribute jumping to false
     */
    public void landed() {
        jumping = false;
        dblJump = false;
    }
}