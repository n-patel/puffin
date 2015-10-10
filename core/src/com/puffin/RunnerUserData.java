package com.puffin;

import com.badlogic.gdx.math.Vector2;
import com.puffin.UserDataType;
import com.puffin.Constants;

public class RunnerUserData extends UserData {

    private Vector2 jumpingLinearImpulse;

    public RunnerUserData() {
        super();
        jumpingLinearImpulse = Constants.RUNNER_JUMPING_LINEAR_IMPULSE;
        userDataType = UserDataType.RUNNER;
    }

    public Vector2 getJumpingLinearImpulse() {
        return jumpingLinearImpulse;
    }

    public void setJumpingLinearImpulse(Vector2 jumpingLinearImpulse) {
        this.jumpingLinearImpulse = jumpingLinearImpulse;
    }

}